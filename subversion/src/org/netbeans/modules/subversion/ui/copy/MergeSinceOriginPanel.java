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

package org.netbeans.modules.subversion.ui.copy;

import org.tigris.subversion.svnclientadapter.SVNRevision;

/**
 *
 * @author  Petr Kuzel
 */
public class MergeSinceOriginPanel extends javax.swing.JPanel {

    /** Creates new form WorkdirPanel */
    public MergeSinceOriginPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName(org.openide.util.NbBundle.getMessage(MergeSinceOriginPanel.class, "CTL_MergeSincePanel_Message")); // NOI18N

        mergeEndRepositoryFolderLabel.setLabelFor(mergeEndUrlComboBox);
        org.openide.awt.Mnemonics.setLocalizedText(mergeEndRepositoryFolderLabel, org.openide.util.NbBundle.getMessage(MergeSinceOriginPanel.class, "CTL_MergeSincePanel_RepositoryFolder")); // NOI18N

        mergeAfterRevisionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/subversion/resources/icons/ending_revision.png"))); // NOI18N
        mergeAfterRevisionLabel.setLabelFor(mergeEndRevisionTextField);
        org.openide.awt.Mnemonics.setLocalizedText(mergeAfterRevisionLabel, org.openide.util.NbBundle.getMessage(MergeSinceOriginPanel.class, "CTL_MergeSincePanel_EndingRevision")); // NOI18N

        mergeEndRevisionTextField.setText(SVNRevision.HEAD.toString());
        mergeEndRevisionTextField.setToolTipText(org.openide.util.NbBundle.getMessage(MergeSinceOriginPanel.class, "CTL_MergeSincePanel_EmptyHint")); // NOI18N

        mergeEndUrlComboBox.setEditable(true);

        org.openide.awt.Mnemonics.setLocalizedText(mergeEndBrowseButton, org.openide.util.NbBundle.getMessage(MergeSinceOriginPanel.class, "CTL_MergeSincePanel_Browse")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(mergeEndSearchButton, org.openide.util.NbBundle.getMessage(MergeSinceOriginPanel.class, "CTL_MergeSincePanel_Search")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(mergeEndBrowseRevisionButton, org.openide.util.NbBundle.getMessage(MergeSinceOriginPanel.class, "CTL_MergeSincePanel_Browse")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cbIgnoreAncestry, org.openide.util.NbBundle.getMessage(MergeSinceOriginPanel.class, "CTL_MergePanel_IgnoreAncestry")); // NOI18N
        cbIgnoreAncestry.setToolTipText(org.openide.util.NbBundle.getMessage(MergeSinceOriginPanel.class, "CTL_MergePanel_IgnoreAncestryTT")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mergeAfterRevisionLabel)
                    .addComponent(mergeEndRepositoryFolderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mergeEndRevisionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mergeEndSearchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mergeEndBrowseRevisionButton))
                    .addComponent(mergeEndUrlComboBox, 0, 309, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mergeEndBrowseButton))
            .addGroup(layout.createSequentialGroup()
                .addComponent(cbIgnoreAncestry)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mergeEndBrowseButton)
                    .addComponent(mergeEndRepositoryFolderLabel)
                    .addComponent(mergeEndUrlComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mergeAfterRevisionLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mergeEndRevisionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mergeEndSearchButton)
                        .addComponent(mergeEndBrowseRevisionButton)))
                .addGap(18, 18, 18)
                .addComponent(cbIgnoreAncestry)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mergeEndRepositoryFolderLabel.getAccessibleContext().setAccessibleDescription("Repository Folder");
        mergeAfterRevisionLabel.getAccessibleContext().setAccessibleDescription("End Revision for Merging");
        mergeEndRevisionTextField.getAccessibleContext().setAccessibleName("End Revision");
        mergeEndRevisionTextField.getAccessibleContext().setAccessibleDescription("End Revision");
        mergeEndUrlComboBox.getAccessibleContext().setAccessibleName("Repository URL ");
        mergeEndUrlComboBox.getAccessibleContext().setAccessibleDescription("Repository URL");
        mergeEndBrowseButton.getAccessibleContext().setAccessibleDescription("Browse Repository URL");
        mergeEndSearchButton.getAccessibleContext().setAccessibleDescription("Search Revision for Merging");
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    final javax.swing.JCheckBox cbIgnoreAncestry = new javax.swing.JCheckBox();
    final javax.swing.JLabel mergeAfterRevisionLabel = new javax.swing.JLabel();
    final javax.swing.JButton mergeEndBrowseButton = new javax.swing.JButton();
    final javax.swing.JButton mergeEndBrowseRevisionButton = new javax.swing.JButton();
    final javax.swing.JLabel mergeEndRepositoryFolderLabel = new javax.swing.JLabel();
    final javax.swing.JTextField mergeEndRevisionTextField = new javax.swing.JTextField();
    final javax.swing.JButton mergeEndSearchButton = new javax.swing.JButton();
    final javax.swing.JComboBox mergeEndUrlComboBox = new javax.swing.JComboBox();
    // End of variables declaration//GEN-END:variables
    
}
