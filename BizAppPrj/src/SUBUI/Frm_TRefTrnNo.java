/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;

import CONTROLLERS.C_Products;
import CONTROLLERS.C_TransactionCom;
import CONTROLLERS.C_Units;
import MODELS.MProducts;
import MODELS.MUnits;
import MODELS.TStockline;
import MODELS.UTransactions;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Buwanaka
 */
public class Frm_TRefTrnNo extends javax.swing.JDialog {

    private static String CurrentSelection = null;

    private C_TransactionCom cTrn = null;

    private UTransactions t = null;
    private MProducts p = null;
    private double ReqQty = 0;
    private MUnits Unit = null;

    private C_Units cunits=null;
    private Frm_TRefTrnNo(java.awt.Frame parent, boolean modal) {

    }

    private Frm_TRefTrnNo(java.awt.Frame parent, boolean modal, MProducts pro, UTransactions t, double ReqQty, MUnits Unit) {
        super(parent, modal);
        initComponents();
        setShortCutKeys(this);
        this.p = pro;
        this.t = t;
        this.ReqQty = ReqQty;
        this.Unit = Unit;
        this.cunits=new C_Units();
        this.cTrn = new C_TransactionCom();
        txt_TrnNo.grabFocus();
        LoadData();
    }

    public static String createRefNoPopUp(JFrame parent, MProducts Pro, UTransactions t, double ReqQty, MUnits UnitId) {
        if (Pro != null) {
            Frm_TRefTrnNo popup = new Frm_TRefTrnNo(parent, true, Pro, t, ReqQty, UnitId);
            popup.setVisible(true);
        }
        return CurrentSelection;
    }

    private void exit() {
        // CurrentSelection = DEFAULT_SEL;
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

        layout_Outer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        but_Check = new javax.swing.JButton();
        txt_TrnNo = new javax.swing.JTextField();
        lbl_TrnNo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbl_Proname = new javax.swing.JTextArea();
        lbl_ProId = new javax.swing.JTextField();
        lbl_Qty = new javax.swing.JLabel();
        lbl_Unit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        layout_Outer.setBackground(new java.awt.Color(255, 255, 255));
        layout_Outer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        layout_Outer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText(" REFERENCE ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        layout_Outer.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 40));

        but_Check.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        but_Check.setText("Check");
        but_Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_CheckActionPerformed(evt);
            }
        });
        layout_Outer.add(but_Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 160, 40));

        txt_TrnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TrnNoActionPerformed(evt);
            }
        });
        layout_Outer.add(txt_TrnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 260, 60));

        lbl_TrnNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        layout_Outer.add(lbl_TrnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 260, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Proname.setEditable(false);
        lbl_Proname.setColumns(20);
        lbl_Proname.setRows(5);
        jScrollPane1.setViewportView(lbl_Proname);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 330, 60));

        lbl_ProId.setEditable(false);
        jPanel1.add(lbl_ProId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, 30));

        lbl_Qty.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_Qty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_Qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 140, 70));

        lbl_Unit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(lbl_Unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 90, 70));

        layout_Outer.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 360, 290));

        getContentPane().add(layout_Outer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void but_CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_CheckActionPerformed
        checkReturn();
    }//GEN-LAST:event_but_CheckActionPerformed

    private void txt_TrnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TrnNoActionPerformed
        checkReturn();
    }//GEN-LAST:event_txt_TrnNoActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_TRefTrnNo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_TRefTrnNo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_TRefTrnNo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_TRefTrnNo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_TRefTrnNo dialog = new Frm_TRefTrnNo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton but_Check;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel layout_Outer;
    private javax.swing.JTextField lbl_ProId;
    private javax.swing.JTextArea lbl_Proname;
    private javax.swing.JLabel lbl_Qty;
    private javax.swing.JLabel lbl_TrnNo;
    private javax.swing.JLabel lbl_Unit;
    private javax.swing.JTextField txt_TrnNo;
    // End of variables declaration//GEN-END:variables

    private void LoadData() {
        lbl_TrnNo.setText(t.getTrndesc() + " No");
        lbl_ProId.setText(p.getId());
        lbl_Proname.setText(p.getPrintdes());
        lbl_Qty.setText("" + ReqQty);
        lbl_Unit.setText(Unit.getSymble());

    }

    private void checkReturn() {
        try {
            if (txt_TrnNo.getText().length() > 0) {
                TStockline trn = cTrn.getStockLineSpecificPositive(txt_TrnNo.getText(), t, p.getId());
                if (trn != null) {
                    double returnedQty = cTrn.getStockLineQtyReturned(txt_TrnNo.getText(), t, p.getId());
                    double aqty = cTrn.getConvertToMaxUnit(trn.getQty(), trn.getUnitGroupId(), trn.getUnitId()) + returnedQty;
                    System.out.println("A:"+aqty+" R:"+ReqQty+" PRV:"+returnedQty);
                    if (aqty > 0) {
                        boolean CheckReturnQty = cTrn.CheckReturnQty(p.getUnitGroupId(), ReqQty, Unit.getId(), aqty, cunits.getMaxUnitOfGroup(trn.getUnitGroupId()));
                        if (CheckReturnQty) {
                            CurrentSelection = trn.getTStockmst().getId();
                            this.dispose();
                        } else {

                            throw new Exception("Invalid Quantity Request");
                        }
                    } else {
                        throw new Exception("Invalid Quantity Request");
                    }
                } else {
                    throw new Exception("Invalid " + t.getTrndesc() + " No");
                }
            } else {
                throw new Exception("Please enter " + t.getTrndesc() + " No");
            }
        } catch (Exception e) {
            CurrentSelection = "";
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
        }

    }

}
