/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm;

import org.netbeans.modules.scm.model.comparators.AbstractCodeUnitLCOM4Comparator;
import org.netbeans.modules.scm.model.comparators.AbstractCodeUnitBlanksComparator;
import org.netbeans.modules.scm.model.comparators.AbstractCodeUnitLOCComparator;
import org.netbeans.modules.scm.model.comparators.AbstractCodeUnitLCOM2Comparator;
import org.netbeans.modules.scm.model.comparators.AbstractCodeUnitImportsComparator;
import org.netbeans.modules.scm.model.comparators.AbstractCodeUnitLCOM1Comparator;
import javax.tools.JavaFileObject;
import org.netbeans.modules.scm.model.ClassInfo;
import org.netbeans.modules.scm.model.MethodInfo;
import org.netbeans.modules.scm.model.PackageInfo;
import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.Tree.Kind;
import com.sun.source.tree.VariableTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.prefs.Preferences;
import org.netbeans.api.java.source.CompilationController;
import org.netbeans.api.java.source.JavaSource;
import org.netbeans.api.java.source.JavaSource.Phase;
import org.netbeans.api.java.source.Task;
import org.netbeans.modules.scm.model.AbstractCodeUnitInfo;
import org.netbeans.modules.scm.options.ScmPanel;
import org.netbeans.modules.scm.model.comparators.MethodsCCComparator;
import org.netbeans.modules.scm.model.comparators.AbstractCodeUnitNumberOfClassesComparator;
import org.netbeans.modules.scm.model.comparators.AbstractCodeUnitNumberOfMethodsComparator;
import org.openide.awt.StatusDisplayer;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.NbPreferences;
import org.openide.util.actions.CookieAction;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.openide.windows.OutputWriter;


public final class SCMAction extends CookieAction {

    InputOutput io;
    OutputWriter out;
    boolean lcomEnabled, lcom1Enabled, lcom2Enabled, lcom3Enabled, lcom4Enabled;
    boolean ccEnabled;
    int ccLimit;
    int classesLimit;
    int packagesLimit;
    boolean classesEnabled, packagesEnabled;  
    boolean locEnabled, importsEnabled, blanksEnabled;
    boolean classesCountEnabled, methodsCountEnabled;

    protected void performAction(Node[] activatedNodes) {
        Preferences prefs = NbPreferences.forModule(ScmPanel.class);

        lcomEnabled = prefs.getBoolean(ScmPanel.LCOM, true);
        lcom1Enabled = prefs.getBoolean(ScmPanel.LCOM1, true);
        lcom2Enabled = prefs.getBoolean(ScmPanel.LCOM2, true);
        lcom3Enabled = prefs.getBoolean(ScmPanel.LCOM3, true);
        lcom4Enabled = prefs.getBoolean(ScmPanel.LCOM4, true);
        ccEnabled = prefs.getBoolean(ScmPanel.CC, true);
        ccLimit = prefs.getInt(ScmPanel.CC_LIMIT, 5);

        locEnabled = prefs.getBoolean(ScmPanel.LOC, true);
        importsEnabled = prefs.getBoolean(ScmPanel.IMPORTS, true);
        blanksEnabled = prefs.getBoolean(ScmPanel.BLANKS, true);

        classesEnabled = prefs.getBoolean(ScmPanel.CLASSES, true);
        packagesEnabled = prefs.getBoolean(ScmPanel.PACKAGES, true);

        classesLimit = prefs.getInt(ScmPanel.CLASSES_LIMIT, 5);
        packagesLimit = prefs.getInt(ScmPanel.PACKAGES_LIMIT, 5);
        classesCountEnabled = prefs.getBoolean(ScmPanel.CLASSES_COUNT, true);
        methodsCountEnabled = prefs.getBoolean(ScmPanel.METHODS_COUNT, true);        

        DataObject dataObject = activatedNodes[0].getLookup().lookup(DataObject.class);
        
        if (null == JavaSource.forFileObject(dataObject.getPrimaryFile()) && !(dataObject instanceof DataFolder)){
            StatusDisplayer.getDefault().setStatusText("Select java file or package");
            return;
        }
        
        io = IOProvider.getDefault().getIO("Analysis of " + dataObject.getName(), true);
        out = io.getOut();

        PackageInfo applicationInfo = new PackageInfo(dataObject.getName(), true);

        collectData(applicationInfo, dataObject);

        applicationInfo.filterVars();

        applicationInfo.bindMethods();

        applicationInfo.computeIndirectVariablesAccess();

        if (lcomEnabled) {
            applicationInfo.computeLCOMS();
        }

        printResults(applicationInfo.getSingleSubElem());
    }

    protected int mode() {
        return CookieAction.MODE_EXACTLY_ONE;
    }

    public String getName() {
        return NbBundle.getMessage(SCMAction.class, "CTL_CopyFQNAction");
    }

    protected Class[] cookieClasses() {
        return new Class[]{DataObject.class};
    }

    @Override
    protected String iconResource() {
        return "org/netbeans/modules/scm/icon.png";
    }

    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }

    private void collectData(PackageInfo packageInfo, DataObject dataObject) {
        if (null != JavaSource.forFileObject(dataObject.getPrimaryFile())) {
            collectDataFromJavaFile(packageInfo, dataObject);
        } else if (dataObject instanceof DataFolder) {
            collectDataFromPackage(packageInfo, (DataFolder) dataObject);
        }
    }

    private void collectDataFromJavaFile(final PackageInfo parentInfo, final DataObject dataObject) {
        FileObject fileObject = dataObject.getPrimaryFile();
        JavaSource javaSource = JavaSource.forFileObject(fileObject);
        if (javaSource != null) {
            try {
                javaSource.runUserActionTask(
                        new Task<CompilationController>() {

                            public void run(CompilationController cc) throws Exception {

                                cc.toPhase(Phase.ELEMENTS_RESOLVED);
                                CompilationUnitTree cut = cc.getCompilationUnit();

                                JavaFileObject javaSource = cut.getSourceFile();

                                int loc = 1;
                                int blankL = 0;
                                int imports = cut.getImports().size();

                                if (locEnabled) {
                                    BufferedReader reader = new BufferedReader(javaSource.openReader(ccEnabled));

                                    String line = reader.readLine();
                                    while (line != null) {
                                        loc++;

                                        if (blanksEnabled) {
                                            line = line.trim();
                                            if (line.isEmpty()) {
                                                blankL++;
                                            }
                                        }

                                        line = reader.readLine();
                                    }
                                    reader.close();
                                }

                                List<? extends Tree> typeDecls = cc.getCompilationUnit().getTypeDecls();
                                if (!typeDecls.isEmpty()) {

                                    Tree t = typeDecls.get(0);

                                    if (t.getKind() == Kind.CLASS) {
                                        ClassTree classT = (ClassTree) t;
                                        ClassInfo classInfo = new ClassInfo(classT.getSimpleName().toString());

                                        classInfo.setLoc(loc);
                                        classInfo.setImportL(imports);
                                        classInfo.setBlankL(blankL);

                                        List<? extends Tree> members = classT.getMembers();

                                        for (Tree memb : members) {
                                            Kind memberKind = memb.getKind();

                                            if (memberKind == Kind.METHOD) {
                                                MethodTree methodT = (MethodTree) memb;
                                                if (!methodT.getName().toString().equals("<init>")) {
                                                    MethodInfo methodInfo = new MethodInfo(methodT.getName().toString(), classInfo);

                                                    if (ccEnabled) {
                                                        Integer ccomp = 1 + (new CyclomaticComplexityVisitor()).scan(methodT, Integer.valueOf(0));
                                                        methodInfo.setCyclomaticComplexity(ccomp);
                                                    }

                                                    Set<String> vars = (new IdentifierUsageVisitor()).scan(methodT.getBody(), new HashSet<String>());
                                                    if (vars == null) {
                                                        vars = new HashSet<String>();
                                                    }
                                                    methodInfo.setVariablesUsed(vars);

                                                    Set<String> methodInvocations = (new MethodInvocationVisitor()).scan(methodT.getBody(), new HashSet<String>());
                                                    if (methodInvocations == null) {
                                                        methodInvocations = new HashSet<String>();
                                                    }
                                                    methodInfo.setMethodInvocations(methodInvocations);
                                                    classInfo.addMethod(methodInfo);
                                                }
                                            } else if (memberKind == Kind.VARIABLE) {
                                                classInfo.addVariable(((VariableTree) memb).getName().toString());
                                            }
                                        }
                                        parentInfo.addClass(classInfo);
                                    }
                                }
                            }
                        }, true);
            } catch (Exception ex) {
                StatusDisplayer.getDefault().setStatusText("ERROR !!!");

                Exceptions.printStackTrace(ex);
            }
        }
    }

    private void collectDataFromPackage(final PackageInfo parentInfo, final DataFolder dataFolder) {
        final PackageInfo packageInfo = new PackageInfo(dataFolder.getName(), false);

        for (DataObject child : dataFolder.getChildren()) {
            collectData(packageInfo, child);
        }

        parentInfo.addPackage(packageInfo);
    }

    private void printLastNC(List<ClassInfo> l, int n, String method) {
        for (int i = l.size() - 1; n > 0 & i >= 0; i--, n--) {
            try {
                Method m = l.get(i).getClass().getMethod(method);
                out.println(l.get(i).getName() + ": " + m.invoke(l.get(i)));
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    private void printLastNP(List<PackageInfo> l, int n, String method) {
        for (int i = l.size() - 1; n > 0 & i >= 0; i--, n--) {
            try {
                Method m = l.get(i).getClass().getMethod(method);
                out.println(l.get(i).getName() + ": " + m.invoke(l.get(i)));
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    private void printLastNM(List<MethodInfo> l, int n, String method) {
        for (int i = l.size() - 1; n > 0 & i >= 0; i--, n--) {
            try {
                MethodInfo met = l.get(i);
                Method m = met.getClass().getMethod(method);
                out.println(met.getOwningClass().getName() + "::" + met.getName() + ": " + m.invoke(l.get(i)));
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    private void printWithBlanks(String s) {
        out.println();
        out.println(s);
        out.println();
    }

    private void printWithLines(String s) {
        out.println();
        out.println("------------------");
        out.println(s);
        out.println("------------------");
    }

    private void printClasses(String s, List<ClassInfo> classes, Comparator<AbstractCodeUnitInfo> comp, int limit, String method) {
        if (classesEnabled) {
            printWithBlanks(s);
            Collections.sort(classes, comp);
            printLastNC(classes, limit, method);
        }
    }

    private void printPackages(String s, List<PackageInfo> packages, Comparator<AbstractCodeUnitInfo> comp, int limit, String method) {
        if (packagesEnabled) {
            printWithBlanks(s);
            Collections.sort(packages, comp);
            printLastNP(packages, limit, method);
        }
    }

    private void printMethods(String s, List<MethodInfo> methods, Comparator<MethodInfo> comp, int limit, String method) {
        printWithBlanks(s);
        Collections.sort(methods, comp);
        printLastNM(methods, limit, method);
    }
    
    private void printResults(AbstractCodeUnitInfo data) {
        if (data instanceof ClassInfo) {
            classesEnabled = false;
            packagesEnabled = false;
        }
        
        if (!packagesEnabled) classesCountEnabled = false;
        if (!classesEnabled) methodsCountEnabled = false;

        List<MethodInfo> methods = data.getAllMethods();
        List<ClassInfo> classes = data.getAllClasses();
        List<PackageInfo> packages = data.getAllPackage();
        
        String avgIfNeeded = data instanceof ClassInfo ? "" : "Average ";
        
        if (locEnabled) {
            printWithLines("LOC ");
            out.println("Total LOC: " + data.getLoc());
            printClasses("Classes LOC:", classes, new AbstractCodeUnitLOCComparator(), classesLimit, "getLoc");
            printPackages("Packages LOC:", packages, new AbstractCodeUnitLOCComparator(), packagesLimit, "getLoc");
        }

        if (importsEnabled) {
            printWithLines("Lines with imports ");
            out.println("Total imports: " + data.getImportL());
            printClasses("Classes imports:", classes, new AbstractCodeUnitImportsComparator(), classesLimit, "getImportL");
            printPackages("Packages imports:", packages, new AbstractCodeUnitImportsComparator(), packagesLimit, "getImportL");
        }

        if (blanksEnabled) {
            printWithLines("Blank lines");
            out.println("Total blank lines: " + data.getBlankL());
            printClasses("Classes blank lines:", classes, new AbstractCodeUnitBlanksComparator(), classesLimit, "getBlankL");
            printPackages("Packages blank lines:", packages, new AbstractCodeUnitBlanksComparator(), packagesLimit, "getBlankL");
        }
        
         if (classesCountEnabled) {
            printWithLines("Classes count");
            out.println("Total classes: " + data.getClassesCount());
            printPackages("Packages with the biggest number of classes:", packages, new AbstractCodeUnitNumberOfClassesComparator(), packagesLimit, "getClassesCount");
        }
        
        if (methodsCountEnabled) {
            printWithLines("Methods count");
            out.println("Total methods: " + data.getMethodsCount());
            printClasses("Classes with the biggest number of methods:", classes, new AbstractCodeUnitNumberOfMethodsComparator(), classesLimit, "getMethodsCount");
        }

        if (ccEnabled) {
            printWithLines("Cyclomatic complexity");
            out.println("Average cyclomatic complexity: " + data.getCc());
            printMethods("Methods with the highest cyclomatic complexity:", methods, new MethodsCCComparator(), ccLimit, "getCyclomaticComplexity");
        }

        if (lcomEnabled) {
            printWithLines("LCOM");
            if (lcom1Enabled) {
                printWithLines(avgIfNeeded + "LCOM 1: " + data.getLcom1());
                printClasses("Classes with the highest LCOM 1:", classes, new AbstractCodeUnitLCOM1Comparator(), classesLimit, "getLcom1");
                printPackages("Packages with the highest average LCOM 1:", packages, new AbstractCodeUnitLCOM1Comparator(), packagesLimit, "getLcom1");
            }
            if (lcom2Enabled) {
                printWithLines(avgIfNeeded + "LCOM 2: " + data.getLcom2());
                printClasses("Classes with the highest LCOM 2:", classes, new AbstractCodeUnitLCOM2Comparator(), classesLimit, "getLcom2");
                printPackages("Packages with the highest average LCOM 2:", packages, new AbstractCodeUnitLCOM2Comparator(), packagesLimit, "getLcom2");

            }
            if (lcom3Enabled) {
                printWithLines(avgIfNeeded + "LCOM 3: " + data.getLcom3());
                printClasses("Classes with the highest LCOM 3:", classes, new AbstractCodeUnitLCOM1Comparator(), classesLimit, "getLcom3");
                printPackages("Packages with the highest average LCOM 3:", packages, new AbstractCodeUnitLCOM1Comparator(), packagesLimit, "getLcom3");

            }
            if (lcom4Enabled) {
                printWithLines(avgIfNeeded + "LCOM 4: " + data.getLcom4());
                printClasses("Classes with the highest LCOM 4:", classes, new AbstractCodeUnitLCOM4Comparator(), classesLimit, "getLcom4");
                printPackages("Packages with the highest average LCOM 4:", packages, new AbstractCodeUnitLCOM4Comparator(), packagesLimit, "getLcom4");
            }
        }
    }
}

