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

package org.netbeans.modules.gradle.newproject;

import javax.swing.JPanel;
import org.openide.WizardDescriptor;
import org.openide.util.NbBundle.Messages;

public final class SubProjectPanelVisual extends JPanel {

    /**
     * Creates new form NewProjectVisualPanel2
     */
    public SubProjectPanelVisual() {
        initComponents();
    }

    @Override
    @Messages("SubProjectsPanel=Sub-Projects")
    public String getName() {
        return Bundle.SubProjectsPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSubProjects = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSubProjects = new javax.swing.JTextArea();
        lbSubProjectHint = new javax.swing.JLabel();

        lbSubProjects.setLabelFor(taSubProjects);
        org.openide.awt.Mnemonics.setLocalizedText(lbSubProjects, org.openide.util.NbBundle.getMessage(SubProjectPanelVisual.class, "SubProjectPanelVisual.lbSubProjects.text")); // NOI18N

        taSubProjects.setColumns(20);
        taSubProjects.setRows(5);
        jScrollPane1.setViewportView(taSubProjects);

        org.openide.awt.Mnemonics.setLocalizedText(lbSubProjectHint, org.openide.util.NbBundle.getMessage(SubProjectPanelVisual.class, "SubProjectPanelVisual.lbSubProjectHint.text")); // NOI18N
        lbSubProjectHint.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbSubProjects)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                            .addComponent(lbSubProjectHint))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSubProjects)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSubProjectHint, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    void read(WizardDescriptor settings) {
        taSubProjects.setText((String) settings.getProperty(GradleMultiWizardIterator.PROP_SUBPROJECTS));
        Boolean initWrapper = (Boolean) settings.getProperty(GradleMultiWizardIterator.PROP_INIT_WRAPPER);
    }

    void write(WizardDescriptor settings) {
        settings.putProperty(GradleMultiWizardIterator.PROP_SUBPROJECTS, taSubProjects.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSubProjectHint;
    private javax.swing.JLabel lbSubProjects;
    private javax.swing.JTextArea taSubProjects;
    // End of variables declaration//GEN-END:variables
}
