/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm.model;

import java.util.ArrayList;
import java.util.Arrays;
import org.netbeans.modules.scm.utils.LCOMUtil;
import java.util.Collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClassInfo extends AbstractCodeUnitInfo{

    Set<String> variables = new HashSet<String>();
    Set<MethodInfo> methods = new HashSet<MethodInfo>();
    Map<String, MethodInfo> methodsMap = new HashMap<String, MethodInfo>();
    
    public ClassInfo(String name) {
        this.name = name;
        classesCount = 1;
    }


    public Set<MethodInfo> getMethods() {
        return methods;
    }
    
  

    public void setMethods(Set<MethodInfo> methods) {
        methodsCount = methods.size();
        this.methods = methods;
    }

    public int getMethodsCount() {
        return methodsCount;
    }    
    

    public Set<String> getVariables() {
        return variables;
    }

    public void setVariables(Set<String> variables) {
        this.variables = variables;
    }

    public boolean addMethod(MethodInfo m) {
        if (methods.contains(m)) return false;
        
        methodsCount++;
        methods.add(m);
        methodsMap.put(m.getName().toString(), m);
        
        ccSum += m.getCyclomaticComplexity();
        computeCC();
        return true;
    }

    public MethodInfo getMethodByName(String s) {
        return methodsMap.get(s);
    }
       
    public boolean addVariable(String s) {
        return variables.add(s);
    }

    public boolean containsVariable(String v) {
        return variables.contains(v);
    }    
    

    void bindMethods() {
       for(MethodInfo met: methods){
           met.bindMethods();
       }
    }

    public void computeIndirectVariablesAccess() {
        boolean variableAccessFound;
        
        do{
           variableAccessFound = false;
           for(MethodInfo met: methods){
               Set<String> vars = met.getVariablesUsed();
               Set<MethodInfo> indirectMethods = met.methodInvocations;
               for(MethodInfo indMet: indirectMethods){
                   Set<String> indVars = indMet.getVariablesUsed();
                   for(String var: indVars){
                        if (!vars.contains(var)){
                            vars.add(var);
                            variableAccessFound = true;
                        }
                   }                   
               }
           }              
        }while(variableAccessFound);
    }
    
    @Override
    public String toString() {
        return "(Class: " + name /*"Methods in class: " + methods + " Variables: " + variables */+ " LCOMS:" + lcom1 + " " + lcom2 + " " + lcom3 + " " + lcom4 + ")\n"; 
    }
    
    public void computeLCOMS() {
       Collection<Set<MethodInfo>> sets = LCOMUtil.computeMethodsSet(getMethods());
       lcom1 = LCOMUtil.computeLCOM1(sets);
       int variablesUsedInMethodsCount = computeVariablesUsedInMethodsCount(methods);
       int vars = getVariables().size();
       int mets = getMethods().size();
       lcom2 = LCOMUtil.computeLCOM2(mets, vars, variablesUsedInMethodsCount);
       lcom3 = LCOMUtil.computeLCOM3(mets, vars, variablesUsedInMethodsCount);       
       lcom4 = LCOMUtil.computeLCOM4(sets);       
    }

  

    public void filterVars() {
         for(MethodInfo met: methods){
            met.filterVars();
        }
    }



    private int computeVariablesUsedInMethodsCount(Set<MethodInfo> methods) {
        int vars = 0;
        for(MethodInfo met: methods){
            vars += met.getVariablesUsed().size();
        }
        return vars;
    }
    
    public List<MethodInfo> getAllMethods(){
        return new ArrayList<MethodInfo>(getMethods());      
    } 

    @Override
    public List<ClassInfo> getAllClasses() {
        return Arrays.asList(this);
    }

    @Override
    public List<PackageInfo> getAllPackage() {
        return new ArrayList<PackageInfo>();
    }      
}
