/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PackageInfo extends AbstractCodeUnitInfo {

    final boolean artificial;
    final Set<ClassInfo> classes = new HashSet<ClassInfo>();
    final Set<PackageInfo> packages = new HashSet<PackageInfo>();  
    
    int lcom1sum = 0, lcom4sum = 0;
    double lcom2sum = 0., lcom3sum = 0.;


    public PackageInfo(String name, boolean artificial) {
        this.name = name;
        this.artificial = artificial;
    }
    
    public boolean addPackage(PackageInfo pk) {
        classesCount += pk.getClassesCount();
        methodsCount += pk.getMethodsCount();
        ccSum += pk.getCcSum();
        computeCC();
        loc += pk.loc;
        importL += pk.importL;
        blankL += pk.getBlankL();
        
        return packages.add(pk);
    }

    public boolean addClass(ClassInfo cl) {
        classesCount++;
        methodsCount += cl.getMethodsCount();
        ccSum += cl.getCcSum();
        computeCC();
        loc += cl.getLoc();
        importL += cl.getImportL();
        blankL += cl.getBlankL();
        
        return classes.add(cl);
    }
    
    public List<MethodInfo> getAllMethods(){
        List<MethodInfo> mets = new ArrayList<MethodInfo>();
        for(PackageInfo pack: packages){
            mets.addAll(pack.getAllMethods());
        } 
        for(ClassInfo cl: classes){
            mets.addAll(cl.getMethods());
        } 
        return mets;        
    }   

    
    public void bindMethods(){
        for(PackageInfo pack: packages){
            pack.bindMethods();
        } 
        for(ClassInfo cl: classes){
            cl.bindMethods();
        }          
    }
    
    public void computeIndirectVariablesAccess() {
         for(PackageInfo pack: packages){
            pack.computeIndirectVariablesAccess();
        } 
        for(ClassInfo cl: classes){
            cl.computeIndirectVariablesAccess();
        }        
    }

    @Override
    public String toString() {
       return "(PackageInfo: " + name + " SubPackages: " + packages + " Classes: " + classes + " LCOMS:" + lcom1 + " " + lcom2 + " " + lcom3 + " " + lcom4 + "mets: " + methodsCount + " cla: " + classesCount + "\n"; 
    }

    public void computeLCOMS() {
                
        for(PackageInfo pack: packages){
            pack.computeLCOMS();
            lcom1sum += pack.getLcom1sum();
            lcom2sum += pack.getLcom2sum();
            lcom3sum += pack.getLcom3sum();
            lcom4sum += pack.getLcom4sum();
        } 
        for(ClassInfo cl: classes){
            cl.computeLCOMS();
            lcom1sum += cl.getLcom1();
            lcom2sum += cl.getLcom2();
            lcom3sum += cl.getLcom3();
            lcom4sum += cl.getLcom4();
        }
        
        int classesC = getClassesCount();
        if (classesC != 0){
            lcom1 = lcom1sum / classesC;
            lcom2 = lcom2sum / (double) classesC;
            lcom3 = lcom3sum / (double) classesC;
            lcom4 = lcom4sum / classesC;
        }        
    }

    public void filterVars() {
        for(PackageInfo pack: packages){
            pack.filterVars();
        } 
        for(ClassInfo cl: classes){
            cl.filterVars();
        }  
    }
    
    public int getMethodsCount() {
        return methodsCount;
    }

    public int getLcom1sum() {
        return lcom1sum;
    }

    public void setLcom1sum(int lcom1sum) {
        this.lcom1sum = lcom1sum;
    }

    public double getLcom2sum() {
        return lcom2sum;
    }

    public void setLcom2sum(double lcom2sum) {
        this.lcom2sum = lcom2sum;
    }

    public double getLcom3sum() {
        return lcom3sum;
    }

    public void setLcom3sum(double lcom3sum) {
        this.lcom3sum = lcom3sum;
    }

    public int getLcom4sum() {
        return lcom4sum;
    }

    public void setLcom4sum(int lcom4sum) {
        this.lcom4sum = lcom4sum;
    }

    @Override
    public List<ClassInfo> getAllClasses() {
        List<ClassInfo> cls = new ArrayList<ClassInfo>(classes);
        for(PackageInfo pack: packages){
            cls.addAll(pack.getAllClasses());
        } 
        return cls;        
    }

    @Override
    public List<PackageInfo> getAllPackage() {
        List<PackageInfo> pks = new ArrayList<PackageInfo>(packages);
        for(PackageInfo pack: packages){
            pks.addAll(pack.getAllPackage());
        }
        return pks;
    }
    
    public AbstractCodeUnitInfo getSingleSubElem(){
        if (!packages.isEmpty()){
            return packages.iterator().next();
        }
        return classes.iterator().next();        
    }
}
