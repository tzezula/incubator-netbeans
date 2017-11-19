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
package org.netbeans.modules.xml.tax.beans.customizer;

import java.beans.PropertyChangeEvent;

import org.netbeans.tax.TreeException;
import org.netbeans.tax.TreeComment;
import org.netbeans.tax.TreeData;

import org.netbeans.modules.xml.tax.util.TAXUtil;

/**
 *
 * @author  Libor Kramolis
 * @version 0.1
 */
public class TreeCommentCustomizer extends AbstractTreeCustomizer {

    /** Serial Version UID */
    private static final long serialVersionUID =-2298790138555257739L;


    //
    // init
    //

    /** */
    public TreeCommentCustomizer () {
        super ();
        
        initComponents ();
        initAccessibility ();
    }
    
    
    //
    // itself
    //
    
    /**
     */
    protected final TreeComment getComment () {
        return (TreeComment)getTreeObject ();
    }
    
    /**
     */
    protected final void safePropertyChange (PropertyChangeEvent pche) {
        super.safePropertyChange (pche);
        
        if (pche.getPropertyName ().equals (TreeData.PROP_DATA)) {
            updateDataComponent ();
        }
    }
    
    /**
     */
    protected final void updateCommentData () {
        try {
            getComment ().setData (dataTextArea.getText ());
        } catch (TreeException exc) {
            updateDataComponent ();
            TAXUtil.notifyTreeException (exc);
        }
    }
    
    /**
     */
    protected final void updateDataComponent () {
        dataTextArea.setText (getComment ().getData ());
    }
    
    /**
     */
    protected final void initComponentValues () {
        updateDataComponent ();
    }
    
    
    /**
     */
    protected final void updateReadOnlyStatus (boolean editable) {
        dataTextArea.setEditable (editable);
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        dataPanel = new javax.swing.JPanel();
        dataScroll = new javax.swing.JScrollPane();
        dataTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        setPreferredSize(new java.awt.Dimension(350, 230));
        dataPanel.setLayout(new java.awt.BorderLayout());

        dataTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dataTextAreaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dataTextAreaFocusLost(evt);
            }
        });

        dataTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataTextAreaKeyPressed(evt);
            }
        });

        dataScroll.setViewportView(dataTextArea);

        dataPanel.add(dataScroll, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 11);
        add(dataPanel, gridBagConstraints);

    }//GEN-END:initComponents

    private void dataTextAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataTextAreaFocusGained
        if ("new".equals(getClientProperty("xml-edit-mode"))) {  // NOI18N
            dataTextArea.selectAll();
        }
    }//GEN-LAST:event_dataTextAreaFocusGained

    private void dataTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataTextAreaKeyPressed
        // Add your handling code here:
        if ( applyKeyPressed (evt) ) {
            updateCommentData ();
        }
    }//GEN-LAST:event_dataTextAreaKeyPressed

    private void dataTextAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataTextAreaFocusLost
        // Add your handling code here:
        updateCommentData ();
    }//GEN-LAST:event_dataTextAreaFocusLost
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea dataTextArea;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JScrollPane dataScroll;
    // End of variables declaration//GEN-END:variables
    
    /** Initialize accesibility
     */
    public void initAccessibility (){
        
        this.getAccessibleContext ().setAccessibleDescription (Util.THIS.getString ("ACSD_TreeCommentCustomizer"));
        dataTextArea.getAccessibleContext ().setAccessibleDescription (Util.THIS.getString ("ACSD_dataPanel"));
        dataTextArea.getAccessibleContext ().setAccessibleName (Util.THIS.getString ("ACSN_dataPanel"));
    }
    
}
