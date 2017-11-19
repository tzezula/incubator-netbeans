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

package org.netbeans.modules.derby.ui;

import org.openide.util.RequestProcessor;

/**
 *
 * @author jhavlin
 */
public abstract class SecurityManagerBugPanel extends javax.swing.JPanel {

    private static final RequestProcessor RP
            = new RequestProcessor(SecurityManagerBugPanel.class);

    /**
     * Creates new form SecurityManagerBugPanel
     */
    public SecurityManagerBugPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        disableSecurityManagerButton = new javax.swing.JButton();
        info1Label = new javax.swing.JLabel();
        info2Label = new javax.swing.JLabel();
        doNotShowAgainButton = new javax.swing.JButton();

        setOpaque(false);

        org.openide.awt.Mnemonics.setLocalizedText(disableSecurityManagerButton, org.openide.util.NbBundle.getMessage(SecurityManagerBugPanel.class, "SecurityManagerBugPanel.disableSecurityManagerButton.text")); // NOI18N
        disableSecurityManagerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        disableSecurityManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disableSecurityManagerButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(info1Label, org.openide.util.NbBundle.getMessage(SecurityManagerBugPanel.class, "SecurityManagerBugPanel.info1Label.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(info2Label, org.openide.util.NbBundle.getMessage(SecurityManagerBugPanel.class, "SecurityManagerBugPanel.info2Label.text")); // NOI18N
        info2Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        info2Label.setMaximumSize(new java.awt.Dimension(2147483647, 100));

        org.openide.awt.Mnemonics.setLocalizedText(doNotShowAgainButton, org.openide.util.NbBundle.getMessage(SecurityManagerBugPanel.class, "SecurityManagerBugPanel.doNotShowAgainButton.text")); // NOI18N
        doNotShowAgainButton.setBorder(null);
        doNotShowAgainButton.setBorderPainted(false);
        doNotShowAgainButton.setContentAreaFilled(false);
        doNotShowAgainButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doNotShowAgainButton.setOpaque(false);
        doNotShowAgainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doNotShowAgainButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(info1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(disableSecurityManagerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(doNotShowAgainButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info1Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(info2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doNotShowAgainButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disableSecurityManagerButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void disableSecurityManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disableSecurityManagerButtonActionPerformed
        RP.post(new Runnable() {

            @Override
            public void run() {
                disableSecurityManagerClicked();
            }
        });
        disableSecurityManagerButton.setEnabled(false);
        doNotShowAgainButton.setEnabled(false);
    }//GEN-LAST:event_disableSecurityManagerButtonActionPerformed

    private void doNotShowAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doNotShowAgainButtonActionPerformed
        RP.post(new Runnable() {

            @Override
            public void run() {
                doNotShowAgainClicked();
            }
        });
    }//GEN-LAST:event_doNotShowAgainButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton disableSecurityManagerButton;
    private javax.swing.JButton doNotShowAgainButton;
    private javax.swing.JLabel info1Label;
    private javax.swing.JLabel info2Label;
    // End of variables declaration//GEN-END:variables

    public abstract void disableSecurityManagerClicked();

    public abstract void doNotShowAgainClicked();
}
