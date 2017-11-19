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
package org.netbeans.modules.java.hints.suggestions;

import java.util.prefs.Preferences;
import javax.swing.JComponent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.spi.java.hints.CustomizerProvider;

/**
 *
 * @author lahvac
 */
public class FillSwitchCustomizer extends javax.swing.JPanel {

    private final Preferences p;
    public FillSwitchCustomizer(final Preferences p) {
        initComponents();
        this.p = p;
        generateDefault.setSelected(p.getBoolean(Tiny.KEY_DEFAULT_ENABLED, Tiny.DEF_DEFAULT_ENABLED));
        defaultTemplate.setText(p.get(Tiny.KEY_DEFAULT_SNIPPET, Tiny.DEF_DEFAULT_SNIPPET));
        enableDisable();
        defaultTemplate.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) {
                p.put(Tiny.KEY_DEFAULT_SNIPPET, defaultTemplate.getText());
            }
            @Override public void removeUpdate(DocumentEvent e) {
                p.put(Tiny.KEY_DEFAULT_SNIPPET, defaultTemplate.getText());
            }
            @Override public void changedUpdate(DocumentEvent e) { }
        });
        p.putBoolean(Tiny.KEY_DEFAULT_ENABLED, generateDefault.isSelected());
        p.put(Tiny.KEY_DEFAULT_SNIPPET, defaultTemplate.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generateDefault = new javax.swing.JCheckBox();
        defaultTemplate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(generateDefault, org.openide.util.NbBundle.getMessage(FillSwitchCustomizer.class, "FillSwitchCustomizer.generateDefault.text")); // NOI18N
        generateDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateDefaultActionPerformed(evt);
            }
        });

        defaultTemplate.setText(org.openide.util.NbBundle.getMessage(FillSwitchCustomizer.class, "FillSwitchCustomizer.defaultTemplate.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(FillSwitchCustomizer.class, "FillSwitchCustomizer.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(generateDefault, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defaultTemplate))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(generateDefault)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defaultTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)))
        );

        jLabel1.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(FillSwitchCustomizer.class, "FillSwitchCustomizer.jLabel1.AccessibleContext.accessibleDescription")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void generateDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateDefaultActionPerformed
        p.putBoolean(Tiny.KEY_DEFAULT_ENABLED, generateDefault.isSelected());
        enableDisable();
    }//GEN-LAST:event_generateDefaultActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField defaultTemplate;
    private javax.swing.JCheckBox generateDefault;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void enableDisable() {
        defaultTemplate.setEditable(generateDefault.isSelected());
    }

    public static final class CustomizerProviderImpl implements CustomizerProvider {

        @Override
        public JComponent getCustomizer(Preferences prefs) {
            return new FillSwitchCustomizer(prefs);
        }

    }
}
