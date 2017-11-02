/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;

import CONTROLLERS.C_ChequePayments;
import MAIN.Frm_Main;
import MODELS.MPermissions;
import MODELS.TChqPayments;

import UI.Frm_Table;
import VALIDATIONS.MyValidator;
import WINMNG.MyWindowBasicControllers;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HOME
 */
public class Frm_TChequePayments extends javax.swing.JInternalFrame implements MyWindowBasicControllers {
    
    Frm_Table ft = null;
    
    Frm_Main mainW = null;
    MyValidator fv = null;
    
    C_ChequePayments CChq = null;
    
    public Frm_TChequePayments(Frm_Main mainw, String ScreenName) {
        initComponents();
        this.setTitle(ScreenName);
        this.lblScreenName.setText(ScreenName);
        this.mainW = mainw;
        this.fv = new MyValidator();
        this.CChq = new C_ChequePayments();
        Refresh();
        setShortCutKeys(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        butLocRefresh = new javax.swing.JButton();
        lblScreenName = new javax.swing.JLabel();
        jpanelq = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Rad_Returned = new javax.swing.JRadioButton();
        Rad_Unrealized = new javax.swing.JRadioButton();
        Rad_Realized = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtChqNo = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDateF = new com.toedter.calendar.JDateChooser();
        txtDateT = new com.toedter.calendar.JDateChooser();
        butSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChqStatus = new javax.swing.JTable();

        setClosable(true);
        setTitle("caption");
        setName(""); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(226, 226, 226));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butLocRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh.png"))); // NOI18N
        butLocRefresh.setToolTipText("Refresh");
        butLocRefresh.setContentAreaFilled(false);
        butLocRefresh.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh_disable.png"))); // NOI18N
        butLocRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLocRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(butLocRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        lblScreenName.setBackground(new java.awt.Color(153, 255, 51));
        lblScreenName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblScreenName.setText("caption");
        jPanel2.add(lblScreenName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 180, 40));
        jPanel2.add(jpanelq, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 270, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Panel"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cheque State");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 20));

        buttonGroup1.add(Rad_Returned);
        Rad_Returned.setText("Returned");
        jPanel5.add(Rad_Returned, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 80, -1));

        buttonGroup1.add(Rad_Unrealized);
        Rad_Unrealized.setText("UnRealized");
        jPanel5.add(Rad_Unrealized, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        buttonGroup1.add(Rad_Realized);
        Rad_Realized.setText("Realized");
        jPanel5.add(Rad_Realized, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 80, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 280, 70));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cheque No");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 20));

        txtChqNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(txtChqNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 70));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Date Period");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 20));

        txtDateF.setDateFormatString("yyyy-MM-dd");
        jPanel6.add(txtDateF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 40));

        txtDateT.setDateFormatString("yyyy-MM-dd");
        jPanel6.add(txtDateT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 150, 40));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 330, 70));

        butSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search.png"))); // NOI18N
        butSearch.setText("Search");
        butSearch.setToolTipText("Search(F2)");
        butSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        butSearch.setContentAreaFilled(false);
        butSearch.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search_disable.png"))); // NOI18N
        butSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSearchActionPerformed(evt);
            }
        });
        jPanel3.add(butSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 110, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 850, 150));

        tblChqStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CHQ No", "CHQ Date", "CR Date", "Amount", "State", "RefNo", "RefTyp", "ChqState"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChqStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChqStatusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChqStatus);
        if (tblChqStatus.getColumnModel().getColumnCount() > 0) {
            tblChqStatus.getColumnModel().getColumn(0).setResizable(false);
            tblChqStatus.getColumnModel().getColumn(1).setResizable(false);
            tblChqStatus.getColumnModel().getColumn(2).setResizable(false);
            tblChqStatus.getColumnModel().getColumn(3).setResizable(false);
            tblChqStatus.getColumnModel().getColumn(4).setResizable(false);
            tblChqStatus.getColumnModel().getColumn(5).setResizable(false);
            tblChqStatus.getColumnModel().getColumn(6).setResizable(false);
            tblChqStatus.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 830, 390));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 620));

        setBounds(0, 0, 867, 646);
    }// </editor-fold>//GEN-END:initComponents

    private void butLocRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLocRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_butLocRefreshActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void butSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSearchActionPerformed
        SearchMode();
    }//GEN-LAST:event_butSearchActionPerformed

    private void tblChqStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChqStatusMouseClicked
        getChequeState();
    }//GEN-LAST:event_tblChqStatusMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Rad_Realized;
    private javax.swing.JRadioButton Rad_Returned;
    private javax.swing.JRadioButton Rad_Unrealized;
    private javax.swing.JButton butLocRefresh;
    private javax.swing.JButton butSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanelq;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JTable tblChqStatus;
    private javax.swing.JTextField txtChqNo;
    private com.toedter.calendar.JDateChooser txtDateF;
    private com.toedter.calendar.JDateChooser txtDateT;
    // End of variables declaration//GEN-END:variables

    @Override
    public void SaveProcess() {
        
    }
    
    @Override
    public void EditMode() {
        
    }
    
    @Override
    public void Refresh() {
        txtChqNo.setText("");
        txtDateF.setDate(new Date());
        txtDateT.setDate(new Date());
        Rad_Unrealized.setSelected(true);
        txtChqNo.grabFocus();

        //7
        tblChqStatus.getColumnModel().getColumn(7).setWidth(0);
        
        SearchMode();
    }
    
    public void setShortCutKeys(JInternalFrame f) {
        
        String exit = "exit";
        InputMap inputMap0 = f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap0.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), exit);
        ActionMap actionMap0 = f.getRootPane().getActionMap();
        actionMap0.put(exit, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                exit();
            }
            
        }
        );
        
        String Search = "Search";
        InputMap inputMap1 = f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap1.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), Search);
        ActionMap actionMap1 = f.getRootPane().getActionMap();
        actionMap1.put(Search, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                SearchMode();
            }
            
        }
        );
        
        String Save = "Save";
        InputMap inputMap2 = f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), Save);
        ActionMap actionMap2 = f.getRootPane().getActionMap();
        actionMap2.put(Save, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                SaveProcess();
            }
            
        }
        );
        
        String Edit = "Edit";
        InputMap inputMap3 = f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), Edit);
        ActionMap actionMap3 = f.getRootPane().getActionMap();
        actionMap3.put(Edit, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                EditMode();
            }
            
        }
        );
        
        String Refresh = "Refresh";
        InputMap inputMap4 = f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), Refresh);
        ActionMap actionMap4 = f.getRootPane().getActionMap();
        actionMap4.put(Refresh, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Refresh();
            }
            
        }
        );
        
    }
    
    private void exit() {
        
        try {
            this.setClosed(true);
            mainW.CurrentFrame = "";
            
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Frm_TChequePayments.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void setDisableEnableComponents(JComponent[] EnComlist, JComponent[] DisComlist) {
        for (JComponent c : DisComlist) {
            c.setEnabled(false);
        }
        for (JComponent c : EnComlist) {
            c.setEnabled(true);
        }
        
    }
    
    @Override
    public void SearchMode() {
        
        try {
            String State = "";
            if (Rad_Realized.isSelected()) {
                State = "U";
            }
            if (Rad_Unrealized.isSelected()) {
                State = "P";
                
            }
            if (Rad_Returned.isSelected()) {
                State = "R";
            }
            ArrayList<Vector> ar = CChq.getAllPayments(txtChqNo.getText(), State, txtDateF.getDate(), txtDateT.getDate());
            
            DefaultTableModel dtm = (DefaultTableModel) tblChqStatus.getModel();
            dtm.setRowCount(0);
            for (Vector v : ar) {
                dtm.addRow(v);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), GLOBALDATA.GlobalData.APPNAME, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void getChequeState() {
        if (tblChqStatus.getSelectedRow() > -1) {
            try {
                String state = tblChqStatus.getValueAt(tblChqStatus.getSelectedRow(), 7).toString();
                
                MPermissions Per = GLOBALDATA.GlobalData.SpecialPer.get("P00019");
                if (Per != null) {
                    MPermissions PerSp = GLOBALDATA.GlobalData.SpecialPer.get("P00020");
                    if (PerSp != null) {
                        String ChqNo = tblChqStatus.getValueAt(tblChqStatus.getSelectedRow(), 0).toString();
                        TChqPayments specificPayment = CChq.getSpecificPayment(ChqNo);
                        if (specificPayment != null) {
                            Frm_MChqState.createMChqStatePopUp(mainW, true, specificPayment);
                            Refresh();
                        }
                    }else{
                        String ChqNo = tblChqStatus.getValueAt(tblChqStatus.getSelectedRow(), 0).toString();
                        TChqPayments specificPayment = CChq.getSpecificPayment(ChqNo);
                        if (specificPayment != null && specificPayment.getChqState().equals("P")) {
                            Frm_MChqState.createMChqStatePopUp(mainW, true, specificPayment);
                            Refresh();
                        }
                    }
                }
               
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), GLOBALDATA.GlobalData.APPNAME, JOptionPane.ERROR_MESSAGE);
                
            }
        }
    }
    
}
