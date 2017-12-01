/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SUBUI;

import CONTROLLERS.C_Products;
import FOCUS_TRAVERSAL.MyFocusTraversalPolicy;
import MODELS.MProducts;
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
public class Frm_MProSubItems extends javax.swing.JDialog {

    private Frm_MProSubItems Frm;
    private final static String DEFAULT_BATCH="";
    private  static String CurrentSelection=null;
    private ArrayList<MProducts> arPro_top=null;
    private Component[] focusList =null;
    private int focusNumber = 0;
    private C_Products CPro=null;
    private Frm_MProSubItems(java.awt.Frame parent, boolean modal){
        
    }
    private  Frm_MProSubItems(java.awt.Frame parent, boolean modal,ArrayList<MProducts> arPro) {
        super(parent, modal);
        initComponents();
        setShortCutKeys(this);
        createKeybindings(tbl_Pro);
        CPro=new C_Products();
        
        arPro_top=arPro;
       CurrentSelection=arPro.get(0).getId();
        loadItems(arPro);
        //tab key focus management
            focusList = new Component[]{tbl_Pro};
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
                
                tbl_Pro.grabFocus();
            } catch (Exception e) {
                System.err.println("Exception in Batch Window Exception:" + e);
            }
    }

    public static  String createSubItemsPopUp(JFrame parent,ArrayList<MProducts> ar){
        if(ar!=null){
            Frm_MProSubItems popup=new Frm_MProSubItems(parent, true,ar);
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
                int selectedRow = tbl_Pro.getSelectedRow();
                if (selectedRow >= 0) {
                    //System.err.println("press");
                    CurrentSelection=tbl_Pro.getValueAt(selectedRow, 0).toString();
                   
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
        tbl_Pro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        layout_Outer.setBackground(new java.awt.Color(255, 255, 255));
        layout_Outer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        layout_Outer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("  Sub Items");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        layout_Outer.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 40));

        tbl_Pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Pro.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_Pro.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_Pro);
        if (tbl_Pro.getColumnModel().getColumnCount() > 0) {
            tbl_Pro.getColumnModel().getColumn(0).setResizable(false);
            tbl_Pro.getColumnModel().getColumn(0).setPreferredWidth(20);
            tbl_Pro.getColumnModel().getColumn(1).setResizable(false);
            tbl_Pro.getColumnModel().getColumn(1).setPreferredWidth(280);
        }

        layout_Outer.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 450, 240));

        getContentPane().add(layout_Outer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 320));

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
            java.util.logging.Logger.getLogger(Frm_MProSubItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_MProSubItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_MProSubItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_MProSubItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_MProSubItems dialog = new Frm_MProSubItems(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tbl_Pro;
    // End of variables declaration//GEN-END:variables

    private void loadItems(ArrayList<MProducts> arp) {
        try {
           
            
            DefaultTableModel dtm=(DefaultTableModel) tbl_Pro.getModel();
            dtm.setRowCount(0);
            for (MProducts p : arp) {
               Vector v=new Vector();
               v.add(p.getId());
               v.add(p.getName());
               dtm.addRow(v);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Frm_MProSubItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
