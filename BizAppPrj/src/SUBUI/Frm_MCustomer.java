/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;


import COMMONFUN.CommonFun;
import CONTROLLERS.C_Customers;
import DB_ACCESS.DB;
import MAIN.Frm_Main;
import MODELS.MCustomer;
import UI.Frm_Table;
import VALIDATIONS.MyValidator;
import WINMNG.MyWindowBasicControllers;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
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

/**
 *
 * @author HOME
 */
public class Frm_MCustomer extends javax.swing.JInternalFrame implements MyWindowBasicControllers {

    Frm_Table ft = null;
    C_Customers m = null;
    Frm_Main mainW = null;
    MyValidator fv = null;
    CommonFun comf = new CommonFun();

    public Frm_MCustomer(Frm_Main mainw, String ScreenName) {
        initComponents();
        this.setTitle(ScreenName);
        this.lblScreenName.setText(ScreenName);
        this.mainW = mainw;
        this.fv = new MyValidator();
        this.m = new C_Customers();
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

        jPanel1 = new javax.swing.JPanel();
        txt_CusCode = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        but_CusUpdate = new javax.swing.JButton();
        but_CusSave = new javax.swing.JButton();
        but_CusSearch = new javax.swing.JButton();
        butCusRefresh = new javax.swing.JButton();
        lblScreenName = new javax.swing.JLabel();
        jpanelq = new javax.swing.JPanel();
        txt_CusDescription = new javax.swing.JTextField();
        Chk_Active = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_CusAddNo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_CusMobile = new javax.swing.JTextField();
        txt_CusContact = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_CusAdd1 = new javax.swing.JTextField();
        txt_CusAdd2 = new javax.swing.JTextField();
        txt_CusAdd3 = new javax.swing.JTextField();

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

        txt_CusCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CusCodeActionPerformed(evt);
            }
        });
        txt_CusCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CusCodeKeyTyped(evt);
            }
        });
        jPanel1.add(txt_CusCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 150, 30));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        but_CusUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/edit.png"))); // NOI18N
        but_CusUpdate.setToolTipText("Save");
        but_CusUpdate.setContentAreaFilled(false);
        but_CusUpdate.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/edit_disable.png"))); // NOI18N
        but_CusUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_CusUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(but_CusUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 40, 40));

        but_CusSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save.png"))); // NOI18N
        but_CusSave.setToolTipText("Save");
        but_CusSave.setContentAreaFilled(false);
        but_CusSave.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save_disable.png"))); // NOI18N
        but_CusSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_CusSaveActionPerformed(evt);
            }
        });
        jPanel2.add(but_CusSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        but_CusSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search.png"))); // NOI18N
        but_CusSearch.setToolTipText("Search(F2)");
        but_CusSearch.setContentAreaFilled(false);
        but_CusSearch.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search_disable.png"))); // NOI18N
        but_CusSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_CusSearchActionPerformed(evt);
            }
        });
        jPanel2.add(but_CusSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 40, 40));

        butCusRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh.png"))); // NOI18N
        butCusRefresh.setToolTipText("Refresh");
        butCusRefresh.setContentAreaFilled(false);
        butCusRefresh.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh_disable.png"))); // NOI18N
        butCusRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCusRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(butCusRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 40, 40));

        lblScreenName.setBackground(new java.awt.Color(153, 255, 51));
        lblScreenName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblScreenName.setText("caption");
        jPanel2.add(lblScreenName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 180, 40));
        jPanel2.add(jpanelq, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 270, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));
        jPanel1.add(txt_CusDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 260, 30));

        Chk_Active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chk_ActiveMouseClicked(evt);
            }
        });
        jPanel1.add(Chk_Active, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 180, -1));

        jLabel1.setText("Address");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 110, 30));

        jLabel2.setText("Code");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 110, 30));
        jPanel1.add(txt_CusAddNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 70, 30));

        jLabel4.setText("Description *");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 110, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(153, 51, 0));
        jLabel5.setText("System will provide Auto Number for Code. So you need not to enter Code while creating  new Records");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 810, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 820, 40));

        jLabel7.setText("State");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 110, 30));

        jLabel6.setText("Street");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 110, 30));

        jLabel3.setText("No");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 20, 30));
        jPanel1.add(txt_CusMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 160, 30));

        txt_CusContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CusContactKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CusContactKeyTyped(evt);
            }
        });
        jPanel1.add(txt_CusContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 160, 30));

        jLabel8.setText("Contact");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 110, 30));

        jLabel9.setText("Mobile");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 110, 30));

        jLabel10.setText("City");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 110, 30));

        txt_CusAdd1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CusAdd1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CusAdd1KeyTyped(evt);
            }
        });
        jPanel1.add(txt_CusAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 130, 30));

        txt_CusAdd2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CusAdd2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CusAdd2KeyTyped(evt);
            }
        });
        jPanel1.add(txt_CusAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 130, 30));

        txt_CusAdd3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CusAdd3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CusAdd3KeyTyped(evt);
            }
        });
        jPanel1.add(txt_CusAdd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 130, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        setBounds(0, 0, 867, 592);
    }// </editor-fold>//GEN-END:initComponents

    private void but_CusSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_CusSearchActionPerformed
        Vector<String> col = new Vector<>();
        col.add("Code");
        col.add("Des");

        String[] SQL_Col = {"ID", "NAME"};
        String SQL = "select ID,NAME from M_CUSTOMER ";
        String SQLWhere = " ACTIVE=1 AND ";
        Connection currentCon = null;
        try {
            currentCon = DB.getCurrentCon();
        } catch (Exception ex) {
            Logger.getLogger(Frm_MCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ft == null) {

            ft = new Frm_Table(txt_CusCode, currentCon, col, SQL_Col, SQL, SQLWhere);
            ft.setVisible(true);

        } else {
            ft = null;
            ft = new Frm_Table(txt_CusCode, currentCon, col, SQL_Col, SQL, SQLWhere);
            ft.setFocusable(true);
            ft.setVisible(true);
        }
    }//GEN-LAST:event_but_CusSearchActionPerformed

    private void butCusRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCusRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_butCusRefreshActionPerformed

    private void Chk_ActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chk_ActiveMouseClicked

    }//GEN-LAST:event_Chk_ActiveMouseClicked

    private void txt_CusCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CusCodeActionPerformed
loadCustomer();
    }//GEN-LAST:event_txt_CusCodeActionPerformed

    private void but_CusSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_CusSaveActionPerformed
SaveProcess();
    }//GEN-LAST:event_but_CusSaveActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
txt_CusCode.grabFocus();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
txt_CusCode.grabFocus();
    }//GEN-LAST:event_formInternalFrameOpened

    private void but_CusUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_CusUpdateActionPerformed
EditMode();
    }//GEN-LAST:event_but_CusUpdateActionPerformed

    private void txt_CusCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CusCodeKeyTyped
fv.NumbersOnly(txt_CusCode, evt);
    }//GEN-LAST:event_txt_CusCodeKeyTyped

    private void txt_CusContactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CusContactKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CusContactKeyReleased

    private void txt_CusContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CusContactKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CusContactKeyTyped

    private void txt_CusAdd1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CusAdd1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CusAdd1KeyReleased

    private void txt_CusAdd1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CusAdd1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CusAdd1KeyTyped

    private void txt_CusAdd2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CusAdd2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CusAdd2KeyReleased

    private void txt_CusAdd2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CusAdd2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CusAdd2KeyTyped

    private void txt_CusAdd3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CusAdd3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CusAdd3KeyReleased

    private void txt_CusAdd3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CusAdd3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CusAdd3KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Chk_Active;
    private javax.swing.JButton butCusRefresh;
    private javax.swing.JButton but_CusSave;
    private javax.swing.JButton but_CusSearch;
    private javax.swing.JButton but_CusUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jpanelq;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JTextField txt_CusAdd1;
    private javax.swing.JTextField txt_CusAdd2;
    private javax.swing.JTextField txt_CusAdd3;
    private javax.swing.JTextField txt_CusAddNo;
    private javax.swing.JTextField txt_CusCode;
    private javax.swing.JTextField txt_CusContact;
    private javax.swing.JTextField txt_CusDescription;
    private javax.swing.JTextField txt_CusMobile;
    // End of variables declaration//GEN-END:variables

    @Override
    public void SaveProcess() {
        try {
            if (!txt_CusDescription.getText().equals("")) {

                int state = JOptionPane.showConfirmDialog(rootPane, "Do you want to Save/Update ?", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (state == JOptionPane.YES_OPTION) {
                    if (!txt_CusCode.getText().equals("")) {
                        //update
                        MCustomer Sup = m.getCustomer(txt_CusCode.getText());
                        if (Sup != null) {
                            MCustomer obj = new MCustomer();
                            obj.setId((txt_CusCode.getText()));
                            obj.setName(txt_CusDescription.getText());
                            obj.setAddno(txt_CusAddNo.getText());
                            obj.setAdd1(txt_CusAdd3.getText());
                            obj.setAdd2(txt_CusAdd2.getText());
                            obj.setAdd3(txt_CusAdd3.getText());
                            obj.setMobile(txt_CusMobile.getText());
                            obj.setContact(txt_CusContact.getText());
                            if (Chk_Active.isSelected()) {
                                obj.setActive((byte) 1);
                            } else {
                                obj.setActive((byte) 0);
                            }
                            int UpdateCustomer = m.UpdateCustomer(obj);

                            JOptionPane.showMessageDialog(rootPane, "Customer Updated Sucessfully!", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.INFORMATION_MESSAGE);
                            Refresh();
                        }
                    } else {
                        MCustomer Cus = m.CheckExists(txt_CusDescription.getText());
                        if (Cus == null) {
                            MCustomer obj = new MCustomer();
                            obj.setId(comf.generateNextNo(5, "C", "M_CUSTOMER", "ID"));
                            obj.setName(txt_CusDescription.getText());
                            obj.setAddno(txt_CusAddNo.getText());
                            obj.setAdd1(txt_CusAdd3.getText());
                            obj.setAdd2(txt_CusAdd2.getText());
                            obj.setAdd3(txt_CusAdd3.getText());
                            obj.setMobile(txt_CusMobile.getText());
                            obj.setContact(txt_CusContact.getText());
                            if (Chk_Active.isSelected()) {
                                obj.setActive((byte) 1);
                            } else {
                                obj.setActive((byte) 0);
                            }
                            int SaveCustomer = m.SaveCustomer(obj);
                            if (SaveCustomer == 1) {
                                JOptionPane.showMessageDialog(rootPane, "Customer Save Sucessfully!", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.INFORMATION_MESSAGE);
                                Refresh();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "This Customer couldn`t Save", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.WARNING_MESSAGE);

                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "This Customer is Already Available!", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.WARNING_MESSAGE);

                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please Fill requied fields!", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.WARNING_MESSAGE);
            }
//
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Couldnt Save/Update due to:" + ex.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void EditMode() {
        JComponent[] DisCom = {but_CusSave,but_CusUpdate, but_CusSearch};
        JComponent[] EnCom = {but_CusSave, butCusRefresh, txt_CusCode, txt_CusDescription, txt_CusMobile, txt_CusContact, txt_CusAddNo, txt_CusAdd1,txt_CusAdd2,txt_CusAdd3, Chk_Active};
        setDisableEnableComponents(EnCom, DisCom);
    }

    @Override
    public void Refresh() {      
 
        txt_CusCode.setText("");
        txt_CusDescription.setText("");
        txt_CusAddNo.setText("");
        txt_CusAdd3.setText("");
        txt_CusAdd2.setText("");
        txt_CusAdd3.setText("");
        txt_CusMobile.setText("");
        txt_CusContact.setText("");
        txt_CusCode.setFocusable(true);
        txt_CusCode.grabFocus();

        Chk_Active.setText("Active");
        Chk_Active.setSelected(true);

        JComponent[] EnCom = {but_CusSearch, but_CusSave,txt_CusCode, txt_CusDescription, txt_CusMobile, txt_CusContact, txt_CusAddNo, txt_CusAdd1,txt_CusAdd2,txt_CusAdd3, Chk_Active};
        JComponent[] DisCom = {but_CusUpdate};
        setDisableEnableComponents(EnCom, DisCom);
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
            Logger.getLogger(Frm_MCustomer.class.getName()).log(Level.SEVERE, null, ex);
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
                Vector<String> col = new Vector<>();
        col.add("Code");
        col.add("Des");

        String[] SQL_Col = {"ID", "NAME"};
        String SQL = "select ID,NAME from M_CUSTOMER ";
        String SQLWhere = "";
        Connection currentCon = null;
        try {
            currentCon = DB.getCurrentCon();
        } catch (Exception ex) {
            Logger.getLogger(Frm_MSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ft == null) {

            ft = new Frm_Table(txt_CusCode, currentCon, col, SQL_Col, SQL, SQLWhere);
            ft.setVisible(true);

        } else {
            ft = null;
            ft = new Frm_Table(txt_CusCode, currentCon, col, SQL_Col, SQL, SQLWhere);
            ft.setFocusable(true);
            ft.setVisible(true);
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
private void loadCustomer() {
        if (!txt_CusCode.getText().equals("")) {
            try {
                MCustomer Cus = m.getCustomer(txt_CusCode.getText());

                if (Cus != null) {
                    
                    txt_CusDescription.setText(Cus.getName());
                    txt_CusAddNo.setText(Cus.getAddno());
                    txt_CusAdd3.setText(Cus.getAdd1());
                    txt_CusAdd2.setText(Cus.getAdd2());
                    txt_CusAdd3.setText(Cus.getAdd3());
                    txt_CusMobile.setText(Cus.getMobile());
                    txt_CusContact.setText(Cus.getContact());
                    if (Cus.getActive() == 1) {
                        Chk_Active.setSelected(true);
                    } else {
                        Chk_Active.setSelected(false);
                    }
                    JComponent[] EnCom = {but_CusSave, but_CusUpdate, butCusRefresh};
                    JComponent[] DisCom = {but_CusSearch,txt_CusCode, txt_CusDescription, txt_CusMobile, txt_CusContact, txt_CusAddNo, txt_CusAdd3,txt_CusAdd2,txt_CusAdd3, Chk_Active};
                    setDisableEnableComponents(EnCom, DisCom);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "No Customer found for given ID :" + txt_CusCode.getText(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
                    Refresh();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Unable to find Customer by given code:" + txt_CusCode.getText(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
                Refresh();
            }

        }
    }
}
