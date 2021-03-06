/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm.options;

import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;

public final class ScmPanel extends javax.swing.JPanel {

    private final ScmOptionsPanelController controller;
    public final static String LCOM = "LCOM";
    public final static String LCOM1 = "LCOM1";
    public final static String LCOM2 = "LCOM2";
    public final static String LCOM3 = "LCOM3";
    public final static String LCOM4 = "LCOM4";
    public final static String LOC = "LOC";
    public final static String BLANKS = "BLANKS";
    public final static String IMPORTS = "IMPORTS";
    public final static String CC = "CC";
    public final static String CC_LIMIT = "CC_LIMIT";
    public final static String PACKAGES = "PACKAGES";
    public final static String PACKAGES_LIMIT = "PACKAGES_LIMIT";
    public final static String CLASSES_COUNT = "PACKAGES_LIMIT";
    public final static String CLASSES = "CLASSES";
    public final static String CLASSES_LIMIT = "CLASSES_LIMIT";
    public final static String METHODS_COUNT = "CLASSES_LIMIT";

    ScmPanel(ScmOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        
        setLCOMS();
        setSpinners();
    // TODO listen to changes in form fields and call controller.changed()
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LCOMBox = new javax.swing.JCheckBox();
        LCOM1Box = new javax.swing.JCheckBox();
        LCOM2Box = new javax.swing.JCheckBox();
        LCOM3Box = new javax.swing.JCheckBox();
        LCOM4Box = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        CCBox = new javax.swing.JCheckBox();
        ccLimitSpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        LOCBox = new javax.swing.JCheckBox();
        ImportsBox = new javax.swing.JCheckBox();
        BlanksBox = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        packagesBox = new javax.swing.JCheckBox();
        classesBox = new javax.swing.JCheckBox();
        packagesLimitSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        classesLimitSpinner = new javax.swing.JSpinner();
        classesCountBox = new javax.swing.JCheckBox();
        methodsCountBox = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.jLabel1.text")); // NOI18N

        LCOMBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(LCOMBox, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.LCOMBox.text")); // NOI18N
        LCOMBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LCOMBoxActionPerformed(evt);
            }
        });
        LCOMBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                LCOMBoxPropertyChange(evt);
            }
        });

        LCOM1Box.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(LCOM1Box, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.LCOM1Box.text")); // NOI18N

        LCOM2Box.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(LCOM2Box, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.LCOM2Box.text")); // NOI18N

        LCOM3Box.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(LCOM3Box, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.LCOM3Box.text")); // NOI18N

        LCOM4Box.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(LCOM4Box, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.LCOM4Box.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LCOMBox)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(LCOM1Box)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LCOM2Box)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LCOM3Box)
                                .addGap(6, 6, 6)
                                .addComponent(LCOM4Box)))
                        .addGap(210, 210, 210)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LCOMBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LCOM2Box)
                    .addComponent(LCOM3Box)
                    .addComponent(LCOM1Box)
                    .addComponent(LCOM4Box)))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.jLabel2.text")); // NOI18N

        CCBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(CCBox, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.CCBox.text")); // NOI18N

        ccLimitSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(0), null, Integer.valueOf(1)));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.jLabel6.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(CCBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccLimitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CCBox)
                    .addComponent(jLabel6)
                    .addComponent(ccLimitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.jLabel3.text")); // NOI18N

        LOCBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(LOCBox, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.LOCBox.text")); // NOI18N

        ImportsBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(ImportsBox, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.ImportsBox.text")); // NOI18N

        BlanksBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(BlanksBox, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.BlanksBox.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(LOCBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ImportsBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BlanksBox))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LOCBox)
                    .addComponent(ImportsBox)
                    .addComponent(BlanksBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.jLabel5.text")); // NOI18N

        packagesBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(packagesBox, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.packagesBox.text")); // NOI18N
        packagesBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packagesBoxActionPerformed(evt);
            }
        });

        classesBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(classesBox, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.classesBox.text")); // NOI18N
        classesBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classesBoxActionPerformed(evt);
            }
        });

        packagesLimitSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(0), null, Integer.valueOf(1)));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.jLabel4.text")); // NOI18N

        classesLimitSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(0), null, Integer.valueOf(1)));

        classesCountBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(classesCountBox, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.classesCountBox.text")); // NOI18N

        methodsCountBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(methodsCountBox, org.openide.util.NbBundle.getMessage(ScmPanel.class, "ScmPanel.methodsCountBox.text")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(classesCountBox))
                                    .addComponent(packagesBox)
                                    .addComponent(classesBox))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(classesLimitSpinner)
                                            .addComponent(packagesLimitSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(methodsCountBox)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(packagesBox)
                    .addComponent(packagesLimitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classesCountBox)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classesBox)
                    .addComponent(classesLimitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(methodsCountBox)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void LCOMBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LCOMBoxPropertyChange
}//GEN-LAST:event_LCOMBoxPropertyChange

private void setLCOMS(){
    Boolean b = (Boolean) LCOMBox.isSelected();
    if (b != null) {
        LCOM1Box.setEnabled(b);
        LCOM2Box.setEnabled(b);
        LCOM3Box.setEnabled(b);
        LCOM4Box.setEnabled(b);
    }
}

private void setSpinners(){
    packagesLimitSpinner.setEnabled(packagesBox.isSelected());
    classesLimitSpinner.setEnabled(classesBox.isSelected());
    classesCountBox.setEnabled(packagesBox.isSelected());
    methodsCountBox.setEnabled(classesBox.isSelected());
}


private void LCOMBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LCOMBoxActionPerformed
    setLCOMS();
}//GEN-LAST:event_LCOMBoxActionPerformed

private void packagesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packagesBoxActionPerformed
    setSpinners();
}//GEN-LAST:event_packagesBoxActionPerformed

private void classesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classesBoxActionPerformed
    setSpinners();
}//GEN-LAST:event_classesBoxActionPerformed

    void load() {
        Preferences prefs = NbPreferences.forModule(ScmPanel.class);

        packagesBox.setSelected(prefs.getBoolean(PACKAGES, true));
        packagesLimitSpinner.setValue(prefs.getInt(PACKAGES_LIMIT, 5));        
        classesCountBox.setSelected(prefs.getBoolean(CLASSES_COUNT, true));

        classesBox.setSelected(prefs.getBoolean(CLASSES, true));
        methodsCountBox.setSelected(prefs.getBoolean(METHODS_COUNT, true));        
        classesLimitSpinner.setValue(prefs.getInt(CLASSES_LIMIT, 5));

        LOCBox.setSelected(prefs.getBoolean(LOC, true));
        ImportsBox.setSelected(prefs.getBoolean(IMPORTS, true));
        BlanksBox.setSelected(prefs.getBoolean(BLANKS, true));
        
        CCBox.setSelected(prefs.getBoolean(CC, true));
        ccLimitSpinner.setValue(prefs.getInt(CC_LIMIT, 5));

        LCOMBox.setSelected(prefs.getBoolean(LCOM, true));
        LCOM1Box.setSelected(prefs.getBoolean(LCOM1, true));
        LCOM2Box.setSelected(prefs.getBoolean(LCOM2, true));
        LCOM3Box.setSelected(prefs.getBoolean(LCOM3, true));
        LCOM4Box.setSelected(prefs.getBoolean(LCOM4, true));
        
        setLCOMS();
        setSpinners();
    }

    void store() {
        Preferences prefs = NbPreferences.forModule(ScmPanel.class);

        prefs.putBoolean(PACKAGES, packagesBox.isSelected());
        prefs.putBoolean(CLASSES_COUNT, classesCountBox.isSelected());
        prefs.putInt(PACKAGES_LIMIT, (Integer) packagesLimitSpinner.getValue());

        prefs.putBoolean(CLASSES, classesBox.isSelected());
        prefs.putBoolean(METHODS_COUNT, methodsCountBox.isSelected());
        prefs.putInt(CLASSES_LIMIT, (Integer) classesLimitSpinner.getValue());

        prefs.putBoolean(LOC, LOCBox.isSelected());
        prefs.putBoolean(IMPORTS, ImportsBox.isSelected());
        prefs.putBoolean(BLANKS, BlanksBox.isSelected());

        prefs.putBoolean(CC, CCBox.isSelected());
        prefs.putInt(CC_LIMIT, (Integer) ccLimitSpinner.getValue());

        prefs.putBoolean(LCOM, LCOMBox.isSelected());
        prefs.putBoolean(LCOM1, LCOM1Box.isSelected());
        prefs.putBoolean(LCOM2, LCOM2Box.isSelected());
        prefs.putBoolean(LCOM3, LCOM3Box.isSelected());
        prefs.putBoolean(LCOM4, LCOM4Box.isSelected());

    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BlanksBox;
    private javax.swing.JCheckBox CCBox;
    private javax.swing.JCheckBox ImportsBox;
    private javax.swing.JCheckBox LCOM1Box;
    private javax.swing.JCheckBox LCOM2Box;
    private javax.swing.JCheckBox LCOM3Box;
    private javax.swing.JCheckBox LCOM4Box;
    private javax.swing.JCheckBox LCOMBox;
    private javax.swing.JCheckBox LOCBox;
    private javax.swing.JSpinner ccLimitSpinner;
    private javax.swing.JCheckBox classesBox;
    private javax.swing.JCheckBox classesCountBox;
    private javax.swing.JSpinner classesLimitSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JCheckBox methodsCountBox;
    private javax.swing.JCheckBox packagesBox;
    private javax.swing.JSpinner packagesLimitSpinner;
    // End of variables declaration//GEN-END:variables
}
