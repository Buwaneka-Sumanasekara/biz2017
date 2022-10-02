/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SUBUI;

import CONTROLLERS.C_Products;
import FOCUS_TRAVERSAL.MyFocusTraversalPolicy;
import MODELS.MStocks;
import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Buwanaka
 */
public class Frm_MBatchPopUp extends javax.swing.JDialog {

    private Frm_MBatchPopUp Frm;
    private final static MStocks DEFAULT_BATCH=null;
    private  static MStocks CurrentSelection=null;
    private Component[] focusList =null;
    private int focusNumber = 0;
    private C_Products CPro=null;
    private Frm_MBatchPopUp(java.awt.Frame parent, boolean modal){
        
    }
    private  Frm_MBatchPopUp(java.awt.Frame parent, boolean modal,ArrayList<MStocks> ArBatches) {
        super(parent, modal);
        initComponents();
        setShortCutKeys(this);
        createKeybindings(tbl_Batch);
        CPro=new C_Products();
       // loadBatch(proNo,LocNo);
        loadBatch(ArBatches);
        
        //tab key focus management
            focusList = new Component[]{tbl_Batch};
            //tab key order
            this.setFocusTraversalPolicy(new MyFocusTraversalPolicy(focusNumber, focusList));
            try {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent ke) {
                        if (ke.getID() == KeyEvent.KEY_PRESSED) {
                            if (ke.getKeyCode() == KeyEvent.VK_TAB) {
                                Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

                                if (comp.isEnabled() == false) {
                                    if (ke.isShiftDown()) {
                                        KeyboardFocusManager.getCurrentKeyboardFocusManager().focusPreviousComponent();
                                    } else {
                                        KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
                                    }
                                }
                            }

                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                System.err.println("Exception in Batch Window Exception:" + e);
            }
    }

    public static  MStocks createBatchPopUp(JFrame parent,ArrayList<MStocks> ArBatches){
        if(ArBatches!=null){
            Frm_MBatchPopUp popup=new Frm_MBatchPopUp(parent, true,ArBatches);
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
     private void createKeybindings(JTable table) {
          table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        table.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // productSearch();
                int selectedRow = tbl_Batch.getSelectedRow();
                if (selectedRow >= 0) {
                    //System.err.println("press");
                    CurrentSelection=(MStocks)tbl_Batch.getValueAt(selectedRow, 0);
                   
                     exit();
                } else {

                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layout_Outer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Batch = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        layout_Outer.setBackground(new java.awt.Color(255, 255, 255));
        layout_Outer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("  Batches");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl_Batch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_Batch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Batch", "Cost", "Sell", "SIH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Batch.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbl_Batch);
        if (tbl_Batch.getColumnModel().getColumnCount() > 0) {
            tbl_Batch.getColumnModel().getColumn(0).setResizable(false);
            tbl_Batch.getColumnModel().getColumn(1).setResizable(false);
            tbl_Batch.getColumnModel().getColumn(2).setResizable(false);
            tbl_Batch.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout_OuterLayout = new javax.swing.GroupLayout(layout_Outer);
        layout_Outer.setLayout(layout_OuterLayout);
        layout_OuterLayout.setHorizontalGroup(
            layout_OuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout_OuterLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout_OuterLayout.setVerticalGroup(
            layout_OuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout_OuterLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layout_Outer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layout_Outer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Frm_MBatchPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_MBatchPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_MBatchPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_MBatchPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_MBatchPopUp dialog = new Frm_MBatchPopUp(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel layout_Outer;
    private javax.swing.JTable tbl_Batch;
    // End of variables declaration//GEN-END:variables

    private void loadBatch(ArrayList<MStocks> arBatches) {
        try {
             DefaultTableModel dtm=(DefaultTableModel) tbl_Batch.getModel();
            //dtm.setRowCount(0);
            for (MStocks mStocks : arBatches) {
                Vector v=new Vector();
                v.add(mStocks);
                v.add(mStocks.getCostPrice());
                v.add(mStocks.getSellPrice());
                v.add(mStocks.getSIH());
                dtm.addRow(v);
            }
        } catch (Exception e) {
        }
    }
    
   /*
    private void loadBatch(String proNo,String LocNo) {
        try {
            ArrayList<MStocks> allBatches = CPro.getAllBatches(proNo, LocNo,1);
            
            DefaultTableModel dtm=(DefaultTableModel) tbl_Batch.getModel();
            //dtm.setRowCount(0);
            for (MStocks mStocks : allBatches) {
                Vector v=new Vector();
                v.add(mStocks);
                v.add(mStocks.getCostPrice());
                v.add(mStocks.getSellPrice());
                v.add(mStocks.getSIH());
                dtm.addRow(v);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Frm_MBatchPopUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   */
}
