/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;

import CONTROLLERS.C_UserGroup;
import MODELS.MUsergroup;
import javax.swing.JOptionPane;

/**
 *
 * @author user pc
 */
public class Frm_Sub_UserGrp extends javax.swing.JDialog {

    MUsergroup ug = null;
    C_UserGroup cug=null;
    public Frm_Sub_UserGrp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Frm_Sub_UserGrp(java.awt.Frame parent, boolean modal, MUsergroup ug) {
        super(parent, modal);
        initComponents();

        cug=new C_UserGroup();
        if (ug != null) {
            this.ug = ug;

            txt_Name.setText(ug.getGroupname());
            Chk_Active.setSelected((ug.getActive() == 1 ? true : false));
        } else {
            this.ug = new MUsergroup();
            this.ug.setId(0);
            txt_Name.setText("");
            Chk_Active.setSelected(true);

        }

        ChangeActive();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jpanelq = new javax.swing.JPanel();
        lblScreenName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_Name = new javax.swing.JTextField();
        butUserGrup = new javax.swing.JButton();
        Chk_Active = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanelq.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblScreenName.setBackground(new java.awt.Color(153, 255, 51));
        lblScreenName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblScreenName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScreenName.setText("User Group ");
        jpanelq.add(lblScreenName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 40));

        jPanel2.add(jpanelq, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 180, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 40));

        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 70, 30));
        getContentPane().add(txt_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 200, 30));

        butUserGrup.setText("Update");
        butUserGrup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUserGrupActionPerformed(evt);
            }
        });
        getContentPane().add(butUserGrup, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 90, 30));

        Chk_Active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chk_ActiveMouseClicked(evt);
            }
        });
        getContentPane().add(Chk_Active, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 180, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Chk_ActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chk_ActiveMouseClicked
        ChangeActive();
    }//GEN-LAST:event_Chk_ActiveMouseClicked

    private void butUserGrupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUserGrupActionPerformed

        saveUserGroup();

    }//GEN-LAST:event_butUserGrupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Sub_UserGrp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Sub_UserGrp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Sub_UserGrp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Sub_UserGrp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_Sub_UserGrp dialog = new Frm_Sub_UserGrp(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Chk_Active;
    private javax.swing.JButton butUserGrup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpanelq;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JTextField txt_Name;
    // End of variables declaration//GEN-END:variables

    private void ChangeActive() {
        if (Chk_Active.isSelected()) {
            Chk_Active.setText("Active");
        } else {
            Chk_Active.setText("Deactive");
        }
    }

    private void saveUserGroup() {
        try {
           if(txt_Name.getText().length()>0){
               ug.setGroupname(txt_Name.getText());
               ug.setActive((byte)(Chk_Active.isSelected()?1:0));
               
               cug.saveUserGroup(ug);
               this.dispose();
           }else{
               throw new Exception("Fill User Group name");
           }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
        }
    }
}
