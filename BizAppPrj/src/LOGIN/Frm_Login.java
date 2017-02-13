/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIN;

import COMMONFUN.DefaultData;
import CONTROLLERS.C_UserGroup;
import CONTROLLERS.C_Users;
import GLOBALDATA.GlobalData;
import MAIN.Frm_Main;
import MODELS.MPermissions;
import MODELS.MUser;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author HOME
 */
public class Frm_Login extends javax.swing.JFrame {

    C_Users u = null;
    C_UserGroup ug = null;
    DefaultData def=null;
    Frm_Login frml = null;

    public Frm_Login() {
        initComponents();
        def=new DefaultData();
        
        createLayout();
        
        u = new C_Users();
        ug = new C_UserGroup();
        txtuname.grabFocus();
        this.frml = this;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtuname = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        butLogin.setText("Login");
        butLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        butLogin.setContentAreaFilled(false);
        butLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLoginActionPerformed(evt);
            }
        });
        getContentPane().add(butLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 90, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 60, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 70, 30));

        txtuname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtuname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunameActionPerformed(evt);
            }
        });
        getContentPane().add(txtuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 170, 30));

        txtpass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        getContentPane().add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 170, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/iconappimg.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 130, 130));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Software By :  Buwaneka Tharanga Sumanasekara");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 590, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(110, 147, 169));
        jLabel5.setText("Biz");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 100, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void butLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLoginActionPerformed
        login();

    }//GEN-LAST:event_butLoginActionPerformed

    private void txtunameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtunameActionPerformed
        txtpass.grabFocus();
    }//GEN-LAST:event_txtunameActionPerformed

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        login();
    }//GEN-LAST:event_txtpassActionPerformed

    private void clear() {
        txtuname.setText("");
        txtpass.setText("");
        txtuname.grabFocus();
    }

    public static void main(String args[]) {
        try {
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

           // UIManager.setLookAndFeel("com.jtattoo.plaf." + CommonFun.getSystemTheme());
        } catch (Exception ex) {
            Logger.getLogger(Frm_Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables

    private void login() {

        if (txtuname.getText().equals("") || txtpass.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please Fill the fileds", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                MUser user = u.CheckUserLogin(txtuname.getText(), txtpass.getText());
                if (user != null) {
                    this.dispose();

                    ArrayList<MPermissions> Menus = ug.getUserGroupPermitions(user.getMUsergroup().getId(), 1);
                    Map<String,String> SpecialPer = ug.getUserGroupPermitions_Map(user.getMUsergroup().getId(), 2,"");
                    GlobalData.SpecialPer = SpecialPer;
                    GlobalData.CurUser=user;
                    final Frm_Main frm = new Frm_Main(this, Menus);
                    frm.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Login faild,Please try again", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);

            }
        }

    }

    private void createLayout() {
       def.createDefaultData();
    }
}
