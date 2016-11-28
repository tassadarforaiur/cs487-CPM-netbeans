/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class MethodInfo {

    final String name;
    Set<String> namesOfMethodInvocations = new HashSet<String>();
    Set<MethodInfo> methodInvocations = new HashSet<MethodInfo>();
    Set<String> variablesUsed = new HashSet<String>();
    ClassInfo owningClass;
    int cyclomaticComplexity;

    public MethodInfo(String name, ClassInfo owningClass) {
        this.name = name;
        this.owningClass = owningClass;
    }
    
    public void bindMethods(){
        for(String s: namesOfMethodInvocations){
            MethodInfo method = owningClass.getMethodByName(s);
            
            if (method != null){
                methodInvocations.add(method);
            }
        }
    }

    public boolean addAllMethods(Collection<? extends String> c) {
        return namesOfMethodInvocations.addAll(c);
    }

    public boolean addMethod(String m) {
        return namesOfMethodInvocations.add(m);
    }

    public Set<String> getVariablesUsed() {
        return variablesUsed;
    }

    public void setVariablesUsed(Set<String> variablesUsed) {
        this.variablesUsed = variablesUsed;
    }

    public int getCyclomaticComplexity() {
        return cyclomaticComplexity;
    }

    public void setCyclomaticComplexity(int cyclomaticComplexity) {
        this.cyclomaticComplexity = cyclomaticComplexity;
    }

    public Set<String> getMethodInvocations() {
        return namesOfMethodInvocations;
    }

    public void setMethodInvocations(Set<String> methodInvocations) {
        this.namesOfMethodInvocations = methodInvocations;
    }

    public String getName() {
        return name;
    }

    public ClassInfo getOwningClass() {
        return owningClass;
    }
    
    @Override
    public String toString() {
        return "(Method: " + name + " Methods Used: " + methodInvocations + " Variables Used: " + variablesUsed + ")\n";
    }

    void filterVars() {
        Set<String> filteredVars = new HashSet<String>();
        for(String var: variablesUsed){
            if (owningClass.containsVariable(var))
                filteredVars.add(var);
        }
        variablesUsed = filteredVars;
    }
    
}
