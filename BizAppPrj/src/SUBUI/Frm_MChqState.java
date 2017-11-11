/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;

import CONTROLLERS.C_ChequePayments;
import GLOBALDATA.GlobalData;
import MODELS.TChqPayments;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Buwanaka
 */
public class Frm_MChqState extends javax.swing.JDialog {

    private static Boolean CurrentSelection;
    private Frm_MChqState Frm;
    private TChqPayments m;
    SimpleDateFormat sdf = null;

    private C_ChequePayments CChq = null;

    private Frm_MChqState(java.awt.Frame parent, boolean modal) {

    }

    private Frm_MChqState(java.awt.Frame parent, boolean modal, TChqPayments m) {
        super(parent, modal);
        initComponents();
        setShortCutKeys(this);
        this.m = m;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.CChq = new C_ChequePayments();
        RefreshScreen();

    }

    public static Boolean createMChqStatePopUp(java.awt.Frame parent, boolean modal, TChqPayments m) {
        if (m != null) {
            Frm_MChqState popup = new Frm_MChqState(parent, modal, m);
            popup.setVisible(true);
        }
        return CurrentSelection;
    }

    private void exit() {
        // CurrentSelection = DEFAULT_BATCH;
        this.dispose();
    }

    private void setShortCutKeys(JDialog f) {
        String exit = "exit";
        InputMap inputMap = f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), exit);
        ActionMap actionMap = f.getRootPane().getActionMap();
        actionMap.put(exit, new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                exit();
            }
        }
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        butRealized = new javax.swing.JButton();
        butReturned = new javax.swing.JButton();
        lblChequeSup = new javax.swing.JLabel();
        lblChqTyp = new javax.swing.JLabel();
        lblChqPaidDate = new javax.swing.JLabel();
        lblChqCustomer = new javax.swing.JLabel();
        txtDepositdate = new com.toedter.calendar.JDateChooser();
        lblChqNo = new javax.swing.JLabel();
        lblChqTrnNo = new javax.swing.JLabel();
        txtChqSup = new javax.swing.JLabel();
        txtChqNo = new javax.swing.JLabel();
        txtChqPaidDate = new javax.swing.JLabel();
        txtChqCustomer = new javax.swing.JLabel();
        txtChqTrnTyp = new javax.swing.JLabel();
        txtChqTrnNo = new javax.swing.JLabel();
        butUnrealized = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Disposit Date");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 340, 50));

        butRealized.setBackground(new java.awt.Color(0, 153, 0));
        butRealized.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butRealized.setText("Realized");
        butRealized.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRealizedActionPerformed(evt);
            }
        });
        jPanel1.add(butRealized, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 130, 50));

        butReturned.setBackground(new java.awt.Color(255, 51, 51));
        butReturned.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butReturned.setText("Returned");
        butReturned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butReturnedActionPerformed(evt);
            }
        });
        jPanel1.add(butReturned, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 130, 50));

        lblChequeSup.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChequeSup.setText("Supplier");
        jPanel1.add(lblChequeSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 80, 20));

        lblChqTyp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChqTyp.setText("Trn Type");
        jPanel1.add(lblChqTyp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 60, 20));

        lblChqPaidDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChqPaidDate.setText("Paid Date");
        jPanel1.add(lblChqPaidDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 20));

        lblChqCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChqCustomer.setText("Customer");
        jPanel1.add(lblChqCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 20));

        txtDepositdate.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(txtDepositdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 260, 30));

        lblChqNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChqNo.setText("Cheque No");
        jPanel1.add(lblChqNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 20));

        lblChqTrnNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChqTrnNo.setText("Trn No");
        jPanel1.add(lblChqTrnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 70, 20));

        txtChqSup.setText("jLabel2");
        jPanel1.add(txtChqSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 20));

        txtChqNo.setText("jLabel2");
        jPanel1.add(txtChqNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, 20));

        txtChqPaidDate.setText("jLabel2");
        jPanel1.add(txtChqPaidDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 190, 20));

        txtChqCustomer.setText("cus");
        jPanel1.add(txtChqCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 190, 20));

        txtChqTrnTyp.setText("jLabel2");
        jPanel1.add(txtChqTrnTyp, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 190, 20));

        txtChqTrnNo.setText("jLabel2");
        jPanel1.add(txtChqTrnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 190, 20));

        butUnrealized.setBackground(new java.awt.Color(255, 204, 102));
        butUnrealized.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butUnrealized.setText("Unrealized");
        butUnrealized.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUnrealizedActionPerformed(evt);
            }
        });
        jPanel1.add(butUnrealized, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 130, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 320));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void butReturnedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butReturnedActionPerformed
        try {
            CChq.UpdateState(m, "R", txtDepositdate.getDate());
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), GLOBALDATA.GlobalData.APPNAME, JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_butReturnedActionPerformed

    private void butRealizedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRealizedActionPerformed
        try {
            CChq.UpdateState(m, "U", txtDepositdate.getDate());
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), GLOBALDATA.GlobalData.APPNAME, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butRealizedActionPerformed

    private void butUnrealizedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUnrealizedActionPerformed
        try {
            CChq.UpdateState(m, "P", txtDepositdate.getDate());
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), GLOBALDATA.GlobalData.APPNAME, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butUnrealizedActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_MChqState.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_MChqState.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_MChqState.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_MChqState.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_MChqState dialog = new Frm_MChqState(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton butRealized;
    private javax.swing.JButton butReturned;
    private javax.swing.JButton butUnrealized;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblChequeSup;
    private javax.swing.JLabel lblChqCustomer;
    private javax.swing.JLabel lblChqNo;
    private javax.swing.JLabel lblChqPaidDate;
    private javax.swing.JLabel lblChqTrnNo;
    private javax.swing.JLabel lblChqTyp;
    private javax.swing.JLabel txtChqCustomer;
    private javax.swing.JLabel txtChqNo;
    private javax.swing.JLabel txtChqPaidDate;
    private javax.swing.JLabel txtChqSup;
    private javax.swing.JLabel txtChqTrnNo;
    private javax.swing.JLabel txtChqTrnTyp;
    private com.toedter.calendar.JDateChooser txtDepositdate;
    // End of variables declaration//GEN-END:variables

    private void RefreshScreen() {
        if (m != null) {
            txtChqNo.setText(m.getChqNo());
            txtChqPaidDate.setText(sdf.format(m.getCRDate()));
            txtChqCustomer.setText(m.getCusName());
            txtChqSup.setText(m.getSupName());
            txtChqTrnNo.setText(m.getRefNo());
            txtChqTrnTyp.setText(m.getRefTrnTyp());
            txtDepositdate.setDate(new Date());

            txtChqSup.setVisible(false);
            lblChequeSup.setVisible(false);
            txtChqCustomer.setVisible(false);
            lblChqCustomer.setVisible(false);
            
            butRealized.setVisible((m.getChqState().equals("P"))?true:false);
            butReturned.setVisible((m.getChqState().equals("P"))?true:false);
           // butUnrealized.setVisible((m.getChqState().equals("U")||m.getChqState().equals("R"))?true:false);
            
            if(GlobalData.SpecialPer.get("P00020")!=null){
                
            butRealized.setVisible((m.getChqState().equals("R"))?true:false);
            butReturned.setVisible((m.getChqState().equals("U"))?true:false);
           
            }
            
            

            if (m.getSupId() != null && m.getSupId().equals("") == false) {
                txtChqSup.setVisible(true);
                lblChequeSup.setVisible(true);
                txtChqSup.setText(m.getSupName());
            } else {
                txtChqCustomer.setVisible(true);
                lblChqCustomer.setVisible(true);

                txtChqCustomer.setText(m.getCusName());

            }

        }

    }

}
