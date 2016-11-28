/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm.model;

import java.util.List;


public abstract class AbstractCodeUnitInfo {

    String name;
    double lcom2 = 0., lcom3 = 0.;
    int lcom1 = 0, lcom4 = 0;
    int loc = 0, importL = 0, commentsL = 0, blankL = 0;
    int classesCount = 0;
    int methodsCount = 0;
    
    double cc = 0.;
    int ccSum = 0;
    
    protected void computeCC(){        
         cc = methodsCount == 0 ? 0 : ((double)ccSum) / ((double)methodsCount);
    }
    
    public abstract List<MethodInfo> getAllMethods();   
    public abstract List<ClassInfo> getAllClasses();  
    public abstract List<PackageInfo> getAllPackage();  
    

    public int getLcom1() {
        return lcom1;
    }

    public double getLcom2() {
        return lcom2;
    }

    public double getLcom3() {
        return lcom3;
    }

    public int getLcom4() {
        return lcom4;
    }

    public int getClassesCount() {
        return classesCount;
    }

    public void setClassesCount(int classesCount) {
        this.classesCount = classesCount;
    }

    public int getBlankL() {
        return blankL;
    }

    public void setBlankL(int blankL) {
        this.blankL = blankL;
    }

    public int getCommentsL() {
        return commentsL;
    }

    public void setCommentsL(int commentsL) {
        this.commentsL = commentsL;
    }

    public int getImportL() {
        return importL;
    }

    public void setImportL(int importL) {
        this.importL = importL;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public void incLoc() {
        loc++;
    }

    public void incImportL() {
        importL++;
    }

    public void incCommentsL() {
        commentsL++;
    }

    public void incBlankL() {
        blankL++;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public int getCcSum() {
        return ccSum;
    }

    public void setCcSum(int ccSum) {
        this.ccSum = ccSum;
    }

    public String getName() {
        return name;
    }

    public int getMethodsCount() {
        return methodsCount;
    }    
}
