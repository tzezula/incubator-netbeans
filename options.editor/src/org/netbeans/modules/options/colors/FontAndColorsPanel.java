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

package org.netbeans.modules.options.colors;

import org.netbeans.modules.options.colors.spi.FontsColorsController;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.netbeans.api.options.OptionsDisplayer;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.NotifyDescriptor.InputLine;
import org.openide.NotifyDescriptor.Message;
import org.openide.awt.Mnemonics;
import org.openide.util.NbBundle;

/**
 *
 * @author  Jan Jancura
 */
@OptionsPanelController.Keywords(keywords = {"#KW_FontsAndColorsOptions"}, location = OptionsDisplayer.FONTSANDCOLORS, tabTitle="#CTL_Font_And_Color_Options_Title")
public class FontAndColorsPanel extends JPanel implements ActionListener {
    
    private final Collection<? extends FontsColorsController> panels;
    
    private ColorModel		    colorModel;
    private String		    currentProfile;
    private boolean		    listen = false;
    
    
    /** Creates new form FontAndColorsPanel1 */
    public FontAndColorsPanel (Collection<? extends FontsColorsController> panels) {
        this.panels = panels;
        
        initComponents ();
        
        // init components
        cbProfile.getAccessibleContext ().setAccessibleName (loc ("AN_Profiles"));
        cbProfile.getAccessibleContext ().setAccessibleDescription (loc ("AD_Profiles"));
        bDelete.getAccessibleContext ().setAccessibleName (loc ("AN_Delete"));
        bDelete.getAccessibleContext ().setAccessibleDescription (loc ("AD_Delete"));
        bDuplicate.getAccessibleContext ().setAccessibleName (loc ("AN_Clone"));
        bDuplicate.getAccessibleContext ().setAccessibleDescription (loc ("AD_Clone"));
        tpCustomizers.getAccessibleContext ().setAccessibleName (loc ("AN_Categories"));
        tpCustomizers.getAccessibleContext ().setAccessibleDescription (loc ("AD_Categories"));
        
        loc(lProfile, "CTL_Color_Profile_Name");
        cbProfile.addItemListener (new ItemListener () {
            public void itemStateChanged (ItemEvent evt) {
                if (!listen) return;
                setCurrentProfile ((String) cbProfile.getSelectedItem ());
            }
        });
        loc (bDuplicate, "CTL_Create_New");
        bDuplicate.addActionListener (this);
        loc (bDelete, "CTL_Delete");
        bDelete.addActionListener (this);
        
        JLabel label = new JLabel(); // Only for setting tab names
        for(FontsColorsController p : panels) {
            JComponent component = p.getComponent();
            component.setBorder(new EmptyBorder(8, 8, 8, 8));

            String tabName = component.getName();
            Mnemonics.setLocalizedText(label, tabName);
            tpCustomizers.addTab(label.getText(), component);

            int idx = Mnemonics.findMnemonicAmpersand(tabName);
            if (idx != -1 && idx + 1 < tabName.length()) {
                int tabcount = tpCustomizers.getTabCount();
                assert tabcount > 0 : "Tabcount is less than 1 with processing tab " + tabName;
                tpCustomizers.setMnemonicAt(
                     tabcount - 1,
                    Character.toUpperCase(tabName.charAt(idx + 1)));
            }
        }
    }
    
    @Override
    public void removeNotify() {
        super.removeNotify();
        for (ComponentListener l : getComponentListeners()) {
            super.removeComponentListener(l);
        }
    }
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lProfile = new javax.swing.JLabel();
        cbProfile = new javax.swing.JComboBox<String>
        ();
        tpCustomizers = new javax.swing.JTabbedPane();
        bDuplicate = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();

        lProfile.setLabelFor(cbProfile);
        lProfile.setText("Profile:");

        bDuplicate.setText("Duplicate...");

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbProfile, 0, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bDuplicate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bDelete))
            .addComponent(tpCustomizers, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bDelete, bDuplicate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lProfile)
                    .addComponent(bDelete)
                    .addComponent(bDuplicate)
                    .addComponent(cbProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpCustomizers, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bDeleteActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_bDeleteActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bDuplicate;
    private javax.swing.JComboBox<String>
    cbProfile;
    private javax.swing.JLabel lProfile;
    private javax.swing.JTabbedPane tpCustomizers;
    // End of variables declaration//GEN-END:variables
    
    
    private void setCurrentProfile (String profile) {
        if (colorModel.isCustomProfile (profile))
            loc (bDelete, "CTL_Delete");                              // NOI18N
        else
            loc (bDelete, "CTL_Restore");                             // NOI18N
        currentProfile = profile;
        
        for(FontsColorsController c : panels) {
            c.setCurrentProfile(currentProfile);
        }
    }
    
    private void deleteCurrentProfile () {
        String currentProfile = (String) cbProfile.getSelectedItem ();
        for(FontsColorsController c : panels) {
            c.deleteProfile(currentProfile);
        }
        if (colorModel.isCustomProfile (currentProfile)) {
            cbProfile.removeItem (currentProfile);
            cbProfile.setSelectedIndex (0);
        }
    }
    
    
    // other methods ...........................................................
    
    void update () {
        colorModel = new ColorModel ();
        
        for(FontsColorsController c : panels) {
            c.update(colorModel);
        }
        
        currentProfile = colorModel.getCurrentProfile ();
//        previousProfileName = currentProfile;
        if (colorModel.isCustomProfile (currentProfile))
            loc (bDelete, "CTL_Delete"); // NOI18N
        else
            loc (bDelete, "CTL_Restore"); // NOI18N

        // init schemes
        listen = false;
        Iterator<String> it = colorModel.getProfiles ().iterator ();
        cbProfile.removeAllItems ();
        while (it.hasNext ())
            cbProfile.addItem (it.next ());
        listen = true;
        cbProfile.setSelectedItem (currentProfile);
    }
    
    
    
    void applyChanges () {
        for(FontsColorsController c : panels) {
            c.applyChanges();
        }
        if (colorModel == null) return;
        colorModel.setCurrentProfile (currentProfile);
//        showDarkLaFNotification(currentProfile);
    }
    
    void cancel () {
        for(FontsColorsController c : panels) {
            c.cancel();
        }
    }
    
    boolean dataValid () {
        return true;
    }
    
    boolean isChanged () {
        if (currentProfile != null &&
            colorModel != null &&
            !currentProfile.equals (colorModel.getCurrentProfile ())
        ) {
            return true;
        }
        
        for(FontsColorsController c : panels) {
            if (c.isChanged()) {
                return true;
            }
        }
        return false;
    }
   
    public void actionPerformed (ActionEvent e) {
        if (!listen) return;
        if (e.getSource () == bDuplicate) {
            InputLine il = new InputLine (
                loc ("CTL_Create_New_Profile_Message"),                // NOI18N
                loc ("CTL_Create_New_Profile_Title")                   // NOI18N
            );
            il.setInputText (currentProfile);
            DialogDisplayer.getDefault ().notify (il);
            if (il.getValue () == NotifyDescriptor.OK_OPTION) {
                String newScheme = il.getInputText ();                
                for (int i = 0; i < cbProfile.getItemCount(); i++)                 
                    if (newScheme.equals (cbProfile.getItemAt(i))) {
                        Message md = new Message (
                            loc ("CTL_Duplicate_Profile_Name"),        // NOI18N
                            Message.ERROR_MESSAGE
                        );
                        DialogDisplayer.getDefault ().notify (md);
                        return;
                    }
                setCurrentProfile (newScheme);
                listen = false;
                cbProfile.addItem (il.getInputText ());
                cbProfile.setSelectedItem (il.getInputText ());
                listen = true;
            }
            return;
        }
        if (e.getSource () == bDelete) {
            deleteCurrentProfile ();
        }
    }
    
    private static String loc (String key) {
        return NbBundle.getMessage (FontAndColorsPanel.class, key);
    }
    
    private static void loc (Component c, String key) {
        if (c instanceof AbstractButton)
            Mnemonics.setLocalizedText (
                (AbstractButton) c, 
                loc (key)
            );
        else
            Mnemonics.setLocalizedText (
                (JLabel) c, 
                loc (key)
            );
    }

//    private static final String DARK_COLOR_PROFILE_NAME = "Norway Today"; //NOI18N
//    private String previousProfileName;
//    private Notification changeLaFNotification = null;
//
//    /**
//     * When Norway Today profile is selected then a notification balloon pops up
//     * offering the user to switch to a dark look and feel to match the dark editor color schema.
//     * @param profileName
//     */
//    private void showDarkLaFNotification( String profileName ) {
//        if( null != previousProfileName && !previousProfileName.equals( profileName ) ) { //NOI18N
//            if( DARK_COLOR_PROFILE_NAME.equals( profileName ) ) {
//                if( !isDarkLaF() && null == changeLaFNotification && !isForcedLaF() ) {
//                    changeLaFNotification = NotificationDisplayer.getDefault().notify( NbBundle.getMessage(FontAndColorsPanel.class, "Title_DarkLaF"),
//                            ImageUtilities.loadImageIcon( "org/netbeans/modules/options/colors/darklaf.png", true), //NOI18N
//                            NbBundle.getMessage(FontAndColorsPanel.class, "Hint_DarkLaF"), new ActionListener() {
//
//                        @Override
//                        public void actionPerformed( ActionEvent e ) {
//                            OptionsDisplayer.getDefault().open( "Advanced/Windows/LaF"); //NOI18N
//                        }
//                    });
//                }
//            } else {
//                if( null != changeLaFNotification ) {
//                    changeLaFNotification.clear();
//                    changeLaFNotification = null;
//                }
//            }
//        }
//
//    }
//
//    private static boolean isDarkLaF() {
//        Preferences prefs = NbPreferences.root().node( "laf" ); //NOI18N
//        return prefs.getBoolean( "theme.dark", false ) && (MetalLookAndFeel.class.getName().equals( prefs.get( "laf", "" ))
//                                                        || NimbusLookAndFeel.class.getName().equals( prefs.get( "laf", "" ))
//                                                        || com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel.class.getName().equals( prefs.get( "laf", "" )) ); //NOI18N
//    }
//
//    private boolean isForcedLaF() {
//        return null != System.getProperty( "nb.laf.forced" ); //NOI18N
//    }
}
