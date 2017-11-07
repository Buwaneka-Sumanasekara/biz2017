/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;

import COMMONFUN.CommonFun;
import CONTROLLERS.C_Suppliers;
import DB_ACCESS.DB;
import MAIN.Frm_Main;
import MODELS.MSupplier;
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
public class Frm_MSupplier extends javax.swing.JInternalFrame implements MyWindowBasicControllers {

    Frm_Table ft = null;
    C_Suppliers m = null;
    Frm_Main mainW = null;
    MyValidator fv = null;
    CommonFun comf = new CommonFun();

    
    
    public Frm_MSupplier(Frm_Main mainw, String ScreenName) {
        initComponents();
        this.setTitle(ScreenName);
        this.m = new C_Suppliers();
        this.lblScreenName.setText(ScreenName);
        this.mainW = mainw;
        this.fv = new MyValidator();
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
        txt_SupCode = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        but_SupUpdate = new javax.swing.JButton();
        but_SupSave = new javax.swing.JButton();
        but_SupSearch = new javax.swing.JButton();
        butSupRefresh = new javax.swing.JButton();
        lblScreenName = new javax.swing.JLabel();
        jpanelq = new javax.swing.JPanel();
        txt_SupDescription = new javax.swing.JTextField();
        Chk_Active = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_SupContact = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_SupContactPerson = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_SupMobile = new javax.swing.JTextField();
        txt_SupAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

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

        txt_SupCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SupCodeActionPerformed(evt);
            }
        });
        txt_SupCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SupCodeKeyTyped(evt);
            }
        });
        jPanel1.add(txt_SupCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 150, 30));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        but_SupUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/edit.png"))); // NOI18N
        but_SupUpdate.setToolTipText("Save");
        but_SupUpdate.setContentAreaFilled(false);
        but_SupUpdate.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/edit_disable.png"))); // NOI18N
        but_SupUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_SupUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(but_SupUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 40, 40));

        but_SupSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save.png"))); // NOI18N
        but_SupSave.setToolTipText("Save");
        but_SupSave.setContentAreaFilled(false);
        but_SupSave.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save_disable.png"))); // NOI18N
        but_SupSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_SupSaveActionPerformed(evt);
            }
        });
        jPanel2.add(but_SupSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        but_SupSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search.png"))); // NOI18N
        but_SupSearch.setToolTipText("Search(F2)");
        but_SupSearch.setContentAreaFilled(false);
        but_SupSearch.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search_disable.png"))); // NOI18N
        but_SupSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_SupSearchActionPerformed(evt);
            }
        });
        jPanel2.add(but_SupSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 40, 40));

        butSupRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh.png"))); // NOI18N
        butSupRefresh.setToolTipText("Refresh");
        butSupRefresh.setContentAreaFilled(false);
        butSupRefresh.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh_disable.png"))); // NOI18N
        butSupRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSupRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(butSupRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 40, 40));

        lblScreenName.setBackground(new java.awt.Color(153, 255, 51));
        lblScreenName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblScreenName.setText("caption");
        jPanel2.add(lblScreenName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 180, 40));
        jPanel2.add(jpanelq, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 270, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));
        jPanel1.add(txt_SupDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 260, 30));

        Chk_Active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chk_ActiveMouseClicked(evt);
            }
        });
        jPanel1.add(Chk_Active, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 180, -1));

        jLabel1.setText("Contact Number");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 110, 30));

        jLabel2.setText("Code");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 110, 30));

        txt_SupContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SupContactKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SupContactKeyTyped(evt);
            }
        });
        jPanel1.add(txt_SupContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 160, 30));

        jLabel4.setText("Description *");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 110, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(153, 51, 0));
        jLabel5.setText("System will provide Auto Number for Code. So you need not to enter Code while creating  new Records");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 810, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 820, 40));
        jPanel1.add(txt_SupContactPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 260, 30));

        jLabel3.setText("Contact Person");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 110, 30));

        jLabel6.setText("Mobile Number");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 110, 30));

        txt_SupMobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SupMobileKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SupMobileKeyTyped(evt);
            }
        });
        jPanel1.add(txt_SupMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 160, 30));
        jPanel1.add(txt_SupAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 260, 30));

        jLabel7.setText("Address");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 650));

        setBounds(0, 0, 849, 677);
    }// </editor-fold>//GEN-END:initComponents

    private void but_SupSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_SupSearchActionPerformed
        SearchMode();
    }//GEN-LAST:event_but_SupSearchActionPerformed

    private void butSupRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSupRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_butSupRefreshActionPerformed

    private void Chk_ActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chk_ActiveMouseClicked
        if (Chk_Active.isSelected()) {
            Chk_Active.setText("Active");
        } else {
            Chk_Active.setText("In-Active");
        }
    }//GEN-LAST:event_Chk_ActiveMouseClicked

    private void txt_SupCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SupCodeActionPerformed
        loadSupplier();
    }//GEN-LAST:event_txt_SupCodeActionPerformed

    private void but_SupSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_SupSaveActionPerformed
        SaveProcess();
    }//GEN-LAST:event_but_SupSaveActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        txt_SupCode.grabFocus();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        txt_SupCode.grabFocus();
    }//GEN-LAST:event_formInternalFrameOpened

    private void but_SupUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_SupUpdateActionPerformed
        EditMode();
    }//GEN-LAST:event_but_SupUpdateActionPerformed

    private void txt_SupCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SupCodeKeyTyped
        fv.NumbersOnly(txt_SupCode, evt);
    }//GEN-LAST:event_txt_SupCodeKeyTyped

    private void txt_SupContactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SupContactKeyReleased
          
    }//GEN-LAST:event_txt_SupContactKeyReleased

    private void txt_SupMobileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SupMobileKeyReleased
    
    }//GEN-LAST:event_txt_SupMobileKeyReleased

    private void txt_SupContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SupContactKeyTyped
      fv.NumbersOnly(txt_SupContact,10, evt);
    }//GEN-LAST:event_txt_SupContactKeyTyped

    private void txt_SupMobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SupMobileKeyTyped
         fv.NumbersOnly(txt_SupMobile,10, evt);
    }//GEN-LAST:event_txt_SupMobileKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Chk_Active;
    private javax.swing.JButton butSupRefresh;
    private javax.swing.JButton but_SupSave;
    private javax.swing.JButton but_SupSearch;
    private javax.swing.JButton but_SupUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jpanelq;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JTextField txt_SupAddress;
    private javax.swing.JTextField txt_SupCode;
    private javax.swing.JTextField txt_SupContact;
    private javax.swing.JTextField txt_SupContactPerson;
    private javax.swing.JTextField txt_SupDescription;
    private javax.swing.JTextField txt_SupMobile;
    // End of variables declaration//GEN-END:variables

    @Override
    public void SaveProcess() {

        try {
            if (!txt_SupDescription.getText().equals("")) {

                int state = JOptionPane.showConfirmDialog(rootPane, "Do you want to Save/Update ?", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (state == JOptionPane.YES_OPTION) {
                    if (!txt_SupCode.getText().equals("")) {
                        //update
                        MSupplier Sup = m.getSupplier(txt_SupCode.getText());
                        if (Sup != null) {
                            MSupplier obj = new MSupplier();
                            obj.setId((txt_SupCode.getText()));
                            obj.setName(txt_SupDescription.getText());
                            obj.setMobile(txt_SupMobile.getText());
                            obj.setContact(txt_SupContact.getText());
                            obj.setContactperson(txt_SupContactPerson.getText());
                            obj.setAddress(txt_SupAddress.getText());
                            if (Chk_Active.isSelected()) {
                                obj.setActive((byte) 1);
                            } else {
                                obj.setActive((byte) 0);
                            }
                            int UpdateSupplier = m.UpdateSupplier(obj);

                            JOptionPane.showMessageDialog(rootPane, "Supplier Updated Sucessfully!", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.INFORMATION_MESSAGE);
                            Refresh();
                        }
                    } else {
                        MSupplier Sup = m.CheckExists(txt_SupDescription.getText());
                        if (Sup == null) {
                            MSupplier obj = new MSupplier();
                            obj.setId(comf.generateNextNo(5, "S", "M_SUPPLIER", "ID"));
                            obj.setName(txt_SupDescription.getText());
                            obj.setMobile(txt_SupMobile.getText());
                            obj.setContact(txt_SupContact.getText());
                            obj.setContactperson(txt_SupContactPerson.getText());
                            obj.setAddress(txt_SupAddress.getText());
                            if (Chk_Active.isSelected()) {
                                obj.setActive((byte) 1);
                            } else {
                                obj.setActive((byte) 0);
                            }
                            int SaveSupplier = m.SaveSupplier(obj);
                            if (SaveSupplier == 1) {
                                JOptionPane.showMessageDialog(rootPane, "Supplier Save Sucessfully!", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.INFORMATION_MESSAGE);
                                Refresh();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "This Supplier couldn`t Save", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.WARNING_MESSAGE);

                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "This Supplier is Already Available!", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.WARNING_MESSAGE);

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
        JComponent[] DisCom = {but_SupUpdate,but_SupSearch,txt_SupCode};
        JComponent[] EnCom = {but_SupSave, butSupRefresh, txt_SupDescription, txt_SupMobile, txt_SupContact, txt_SupContactPerson, txt_SupAddress, Chk_Active};
        setDisableEnableComponents(EnCom, DisCom);
    }

    @Override
    public void Refresh() {
        txt_SupCode.setText("");
        txt_SupDescription.setText("");
        txt_SupAddress.setText("");
        txt_SupContact.setText("");
        txt_SupContactPerson.setText("");
        txt_SupMobile.setText("");
        txt_SupCode.setFocusable(true);
        txt_SupCode.grabFocus();

        Chk_Active.setText("Active");
        Chk_Active.setSelected(true);

        JComponent[] EnCom = {but_SupSearch, but_SupSave,txt_SupCode, txt_SupDescription, txt_SupMobile, txt_SupContact, txt_SupContactPerson, txt_SupAddress, Chk_Active};
        JComponent[] DisCom = {but_SupUpdate};
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
            Logger.getLogger(Frm_MSupplier.class.getName()).log(Level.SEVERE, null, ex);
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
        String SQL = "select ID,NAME from m_supplier ";
        String SQLWhere = "";
        Connection currentCon = null;
        try {
            currentCon = DB.getCurrentCon();
        } catch (Exception ex) {
            Logger.getLogger(Frm_MSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ft == null) {

            ft = new Frm_Table(txt_SupCode, currentCon, col, SQL_Col, SQL, SQLWhere);
            ft.setVisible(true);

        } else {
            ft = null;
            ft = new Frm_Table(txt_SupCode, currentCon, col, SQL_Col, SQL, SQLWhere);
            ft.setFocusable(true);
            ft.setVisible(true);
        }
    }

    private void loadSupplier() {
        if (!txt_SupCode.getText().equals("")) {
            try {
                MSupplier Sup = m.getSupplier(txt_SupCode.getText());

                if (Sup != null) {
                    txt_SupDescription.setText(Sup.getName());
                    txt_SupMobile.setText(Sup.getMobile());
                    txt_SupContact.setText(Sup.getContact());
                    txt_SupContactPerson.setText(Sup.getContactperson());
                    txt_SupAddress.setText(Sup.getAddress());
                    if (Sup.getActive() == 1) {
                        Chk_Active.setSelected(true);
                    } else {
                        Chk_Active.setSelected(false);
                    }
                    JComponent[] EnCom = {  but_SupUpdate, butSupRefresh};
                    JComponent[] DisCom = {but_SupSave,txt_SupCode,but_SupSearch,txt_SupDescription, txt_SupMobile, txt_SupContact, txt_SupContactPerson, txt_SupAddress, Chk_Active};
                    setDisableEnableComponents(EnCom, DisCom);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "No Supplier found for given ID :" + txt_SupCode.getText(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
                    Refresh();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Unable to find Supplier by given code:" + txt_SupCode.getText(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
                Refresh();
            }

        }
    }

}
