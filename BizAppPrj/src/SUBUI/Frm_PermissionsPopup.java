/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;

import CONTROLLERS.C_Permissions;
import CONTROLLERS.C_UserGroup;
import CONTROLLERS.C_Users;
import MODELS.MPermissions;
import MODELS.MUser;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Buwanaka
 */
public class Frm_PermissionsPopup extends javax.swing.JDialog {

    C_Users CUser = null;
    private static Boolean CurState = false;
    Map<String, String> CurPer = null;
    String PerId;
    C_UserGroup ug = null;
    C_Permissions cper=null;
    private Frm_PermissionsPopup(java.awt.Frame parent, boolean modal, String PerId) throws Exception {
        super(parent, modal);
        initComponents();
        this.PerId = PerId;
        this.CUser = new C_Users();
        this.ug = new C_UserGroup();
        this.cper=new C_Permissions();
        lbl_Message.setText(cper.getPermission(PerId).toString());
        CurPer = new TreeMap<String, String>();
        
    }

    public static Boolean createPermissionPopUp(java.awt.Frame parent, boolean modal, String PerId) {

        try {
            Frm_PermissionsPopup popup = new Frm_PermissionsPopup(parent, modal, PerId);
            popup.setVisible(true);
            
            return CurState;
        } catch (Exception ex) {
             System.err.println("AUTH POPUP:"+ex.getMessage());
             return CurState;
        }
    }

    @Override
    public void dispose() {
       
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
    }

    
    private void exit() {
      
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtuname = new javax.swing.JTextField();
        butChk = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        lbl_Message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/1487416361_Policeman.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 130, 120));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Authentication Required !!!!!!!!!!!");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 440, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 100, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Username");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 100, 20));
        jPanel1.add(txtuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 190, 30));

        butChk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        butChk.setText("Check");
        butChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butChkActionPerformed(evt);
            }
        });
        jPanel1.add(butChk, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 90, 40));

        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 190, 30));

        lbl_Message.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Message.setForeground(new java.awt.Color(51, 51, 255));
        lbl_Message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_Message, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 420, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void butChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butChkActionPerformed
        LoginCheck();
    }//GEN-LAST:event_butChkActionPerformed

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
       LoginCheck();
    }//GEN-LAST:event_txtpassActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butChk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Message;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables

    private void LoginCheck() {
        try {
            MUser u = CUser.CheckUserLogin(txtuname.getText(), txtpass.getText());
            if (u != null && u.getActive() == 1) {
                Map<String, MPermissions> userGroupPermitions_Map = ug.getUserGroupPermitions_Map(u.getMUsergroup().getId(), 2, "");
                if (userGroupPermitions_Map.get(PerId) != null) {
                    CurState = true;
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "User has no permision", GLOBALDATA.GlobalData.APPNAME, JOptionPane.ERROR_MESSAGE);

                    CurState = false;
                }
            } else {
                CurState = false;
                JOptionPane.showMessageDialog(rootPane, "Invalid User", GLOBALDATA.GlobalData.APPNAME, JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception ex) {
              CurState = false;
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), GLOBALDATA.GlobalData.APPNAME, JOptionPane.ERROR_MESSAGE);
        }

    }
}
