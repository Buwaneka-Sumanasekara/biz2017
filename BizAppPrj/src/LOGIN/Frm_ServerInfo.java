/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LOGIN;

import MODEL.CONFIG.UConfig;


import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author HOME
 */
public class Frm_ServerInfo extends javax.swing.JFrame {

   
    ServerCon servercon=null;
    public Frm_ServerInfo() {
        initComponents();
        servercon=new ServerCon();
    }

    
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtServerIp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtServerUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtServerPass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        butSave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtserverport = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtServerIp.setText("LOCALHOST");
        jPanel1.add(txtServerIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 190, 30));

        jLabel2.setText("Server Port");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 140, 20));

        txtServerUsername.setText("root");
        txtServerUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServerUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtServerUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 190, 30));

        jLabel3.setText("Server Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 120, 20));

        txtServerPass.setText("123");
        jPanel1.add(txtServerPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 190, 30));

        jLabel4.setText("Server IP");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 80, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Server Information");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 30));

        butSave.setText("Update");
        butSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSaveActionPerformed(evt);
            }
        });
        jPanel1.add(butSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 80, 30));

        jLabel5.setText("Server Username");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 140, 20));

        txtserverport.setText("3306");
        jPanel1.add(txtserverport, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 190, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtServerUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServerUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServerUsernameActionPerformed

    private void butSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSaveActionPerformed
       
        try {
            UConfig uc=new UConfig();
            uc.setServer(txtServerIp.getText());
            uc.setPort(txtserverport.getText());
            uc.setUsername(txtServerUsername.getText());
            uc.setPassword(txtServerPass.getText());
           servercon.updateConnection(uc);
           servercon.checkConnection(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),GLOBALDATA.GlobalData.MESSAGEBOX,JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_butSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {

            UIManager.put("List.focusCellHighlightBorder", BorderFactory.createEmptyBorder());
            UIManager.put("Synthetica.internalFrame.titlePane.dropShadow", true);

           UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_ServerInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtServerIp;
    private javax.swing.JPasswordField txtServerPass;
    private javax.swing.JTextField txtServerUsername;
    private javax.swing.JTextField txtserverport;
    // End of variables declaration//GEN-END:variables
}
