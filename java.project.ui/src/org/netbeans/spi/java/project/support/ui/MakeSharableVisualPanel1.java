/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.spi.java.project.support.ui;

import java.io.File;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.api.queries.CollocationQuery;
import static org.netbeans.spi.java.project.support.ui.Bundle.*;
import org.netbeans.spi.project.support.ant.AntProjectHelper;
import org.netbeans.spi.project.support.ant.PropertyUtils;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileUtil;
import org.openide.util.ChangeSupport;
import org.openide.util.NbBundle.Messages;

final class MakeSharableVisualPanel1 extends JPanel {

    private AntProjectHelper helper;
    private ChangeSupport support;
    private WizardDescriptor settings;
    private DocumentListener docListener;

    /** Creates new form MakeSharableVisualPanel1 */
    public MakeSharableVisualPanel1(ChangeSupport supp) {
        initComponents();
        this.support = supp;
        docListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { 
                support.fireChange();
            }

            public void removeUpdate(DocumentEvent e) {
                support.fireChange();
            }

            public void changedUpdate(DocumentEvent e) {
                support.fireChange();
            }
            
        };
        txtDefinition.getDocument().addDocumentListener(docListener);
    }

    @Messages("TIT_LibraryDefinitionSelection=Library Folder")
    @Override
    public String getName() {
        return TIT_LibraryDefinitionSelection();
    }

    @Messages({
        "WARN_MakeSharable.absolutePath=<html>Please make sure that the absolute path in the Libraries Folder field is valid for all users.<html>",
        "WARN_makeSharable.relativePath=<html>Please make sure that the relative path in the Libraries Folder field is valid for all users.<html>"
    })
    boolean isValidPanel() {
        String location = getLibraryLocation();
        boolean wrong = false;
        if (new File(location).isAbsolute()) {
            settings.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, WARN_MakeSharable_absolutePath());
            wrong = true;
        } else {
            File projectLoc = FileUtil.toFile(helper.getProjectDirectory());
            File libLoc = PropertyUtils.resolveFile(projectLoc, location);
            if (!CollocationQuery.areCollocated(projectLoc, libLoc)) {
                settings.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, WARN_makeSharable_relativePath());
                wrong = true;
            }
        }
        if (!wrong) {
            settings.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, null);
        }

        return true;
    }

    private String getLibraryLocation() {
        return txtDefinition.getText().trim();
    }

    private void setLibraryLocation(String loc) {
        txtDefinition.setText(loc);
    }

    void readSettings(WizardDescriptor wiz) {
        settings = wiz;
        String loc = (String) wiz.getProperty(SharableLibrariesUtils.PROP_LOCATION);
        helper = (AntProjectHelper) wiz.getProperty(SharableLibrariesUtils.PROP_HELPER);
        if (loc == null) {
            loc = "." + File.separator + "lib"; //NOI18N
        } else {
            loc = loc.substring(0, loc.length() - SharableLibrariesUtils.DEFAULT_LIBRARIES_FILENAME.length());
        }
        setLibraryLocation(loc);
        support.fireChange();
    }

    void storeSettings(WizardDescriptor wiz) {
        String librariesDefinition = getLibraryLocation();
        if (librariesDefinition != null) {
            if (librariesDefinition.length() != 0 && !librariesDefinition.endsWith(File.separator)) {
                librariesDefinition += File.separatorChar;
            }
            librariesDefinition += SharableLibrariesUtils.DEFAULT_LIBRARIES_FILENAME;
        }

        wiz.putProperty(SharableLibrariesUtils.PROP_LOCATION, librariesDefinition);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDefinition = new javax.swing.JLabel();
        txtDefinition = new javax.swing.JTextField();
        btnDefinition = new javax.swing.JButton();
        lblNote = new javax.swing.JLabel();

        lblDefinition.setLabelFor(txtDefinition);
        org.openide.awt.Mnemonics.setLocalizedText(lblDefinition, org.openide.util.NbBundle.getMessage(MakeSharableVisualPanel1.class, "MakeSharableVisualPanel1.lblDefinition.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(btnDefinition, org.openide.util.NbBundle.getMessage(MakeSharableVisualPanel1.class, "MakeSharableVisualPanel1.btnDefinition.text")); // NOI18N
        btnDefinition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefinitionActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(lblNote, org.openide.util.NbBundle.getMessage(MakeSharableVisualPanel1.class, "MakeSharableVisualPanel1.lblNote.text")); // NOI18N
        lblNote.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblDefinition)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNote, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDefinition, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDefinition))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDefinition)
                    .addComponent(lblDefinition)
                    .addComponent(txtDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        lblDefinition.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(MakeSharableVisualPanel1.class, "ACSD_lblDefinition")); // NOI18N
        txtDefinition.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(MakeSharableVisualPanel1.class, "ACSD_lblDefinition")); // NOI18N
        btnDefinition.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(MakeSharableVisualPanel1.class, "ACSD_btnDefinition")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

private void btnDefinitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefinitionActionPerformed
        File f = FileUtil.toFile(helper.getProjectDirectory()); // NOI18N
        String curr = SharableLibrariesUtils.browseForLibraryLocation(getLibraryLocation(), this, f);
        if (curr != null) {
            setLibraryLocation(curr);
        }

}//GEN-LAST:event_btnDefinitionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDefinition;
    private javax.swing.JLabel lblDefinition;
    private javax.swing.JLabel lblNote;
    private javax.swing.JTextField txtDefinition;
    // End of variables declaration//GEN-END:variables
}

