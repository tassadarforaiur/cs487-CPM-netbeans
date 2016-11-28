/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm.utils;


import org.netbeans.modules.scm.model.MethodInfo;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class LCOMUtil {
    
     public static Collection<Set<MethodInfo>> computeMethodsSet(Collection<MethodInfo> methods) {
        FindAndUnion<MethodInfo> fAndU = new FindAndUnion<MethodInfo>(methods);
      
        for(MethodInfo m1: methods){
            Set<String> v1 = m1.getVariablesUsed();
            for(MethodInfo m2: methods){
                if (!m1.getName().equals(m2.getName())){
                    Set<String> v2 = m2.getVariablesUsed();
                    if (!Collections.disjoint(v1, v2)) 
                        fAndU.union(m1, m2);
                }
            }
        }
        
        return fAndU.getSet();
    }
    
    
      public static int computeLCOM1(Collection<Set<MethodInfo>> sets) {
        int p = 0, q = 0;
        
        int allMethodsCount = 0;
        for(Set<MethodInfo> set: sets){
            allMethodsCount += set.size();                   
        }        
        
        for(Set<MethodInfo> set: sets){
            int setSize = set.size();
            assert (setSize != 0);
            int pairs = setSize * (setSize - 1);            
           
            q += pairs;
            
            p += (allMethodsCount - setSize) * setSize;           
        }
        
        int t = p - q;
        
        t /= 2;
        return (t > 0 ? t : 0);
        
    }
    
     public static int computeLCOM4(Collection<Set<MethodInfo>> sets) {       
        return sets.size();
    }
     
    public static double computeLCOM2(int mets, int vars, int variablesUsedInMethodsCount) {
        if (mets == 0 || vars == 0) return 0.;
        return 1. - (double)variablesUsedInMethodsCount / ((double)(mets * vars));        
    }
    
    public static double computeLCOM3(int mets, int vars, int variablesUsedInMethodsCount) {
        if (mets < 2 || vars == 0) return 0.;
        return ((double)mets - ((double)variablesUsedInMethodsCount / (double)vars)) / ((double)mets - 1.);        
    }   
}
