/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;

import CONTROLLERS.C_SalesMan;
import DB_ACCESS.DB;
import MAIN.Frm_Main;
import MODELS.MSalesMan;
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
public class Frm_MSalesMan extends javax.swing.JInternalFrame implements MyWindowBasicControllers {

    Frm_Table ft = null;

    Frm_Main mainW = null;
    MyValidator fv = null;

    C_SalesMan csales = null;

    public Frm_MSalesMan(Frm_Main mainw, String ScreenName) {
        initComponents();
        this.setTitle(ScreenName);
        this.lblScreenName.setText(ScreenName);
        this.mainW = mainw;
        this.fv = new MyValidator();
        this.csales = new C_SalesMan();
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
        txt_Code = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        but_Update = new javax.swing.JButton();
        but_Save = new javax.swing.JButton();
        but_Search = new javax.swing.JButton();
        but_Refresh = new javax.swing.JButton();
        lblScreenName = new javax.swing.JLabel();
        jpanelq = new javax.swing.JPanel();
        txt_Name = new javax.swing.JTextField();
        Chk_Active = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_CommPer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_LName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CodeActionPerformed(evt);
            }
        });
        txt_Code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CodeKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Code, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 150, 30));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        but_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/edit.png"))); // NOI18N
        but_Update.setToolTipText("Save");
        but_Update.setContentAreaFilled(false);
        but_Update.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/edit_disable.png"))); // NOI18N
        but_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_UpdateActionPerformed(evt);
            }
        });
        jPanel2.add(but_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 40, 40));

        but_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save.png"))); // NOI18N
        but_Save.setToolTipText("Save");
        but_Save.setContentAreaFilled(false);
        but_Save.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save_disable.png"))); // NOI18N
        but_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_SaveActionPerformed(evt);
            }
        });
        jPanel2.add(but_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        but_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search.png"))); // NOI18N
        but_Search.setToolTipText("Search(F2)");
        but_Search.setContentAreaFilled(false);
        but_Search.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search_disable.png"))); // NOI18N
        but_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_SearchActionPerformed(evt);
            }
        });
        jPanel2.add(but_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 40, 40));

        but_Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh.png"))); // NOI18N
        but_Refresh.setToolTipText("Refresh");
        but_Refresh.setContentAreaFilled(false);
        but_Refresh.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh_disable.png"))); // NOI18N
        but_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_RefreshActionPerformed(evt);
            }
        });
        jPanel2.add(but_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 40, 40));

        lblScreenName.setBackground(new java.awt.Color(153, 255, 51));
        lblScreenName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblScreenName.setText("caption");
        jPanel2.add(lblScreenName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 220, 40));
        jPanel2.add(jpanelq, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 310, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 40));
        jPanel1.add(txt_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 260, 30));

        Chk_Active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chk_ActiveMouseClicked(evt);
            }
        });
        jPanel1.add(Chk_Active, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 180, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("%");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 110, 30));

        jLabel2.setText("Code");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 110, 30));

        txt_CommPer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CommPerKeyTyped(evt);
            }
        });
        jPanel1.add(txt_CommPer, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 100, 30));

        jLabel4.setText("First Name *");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 110, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(153, 51, 0));
        jLabel5.setText("System will provide Auto Number for Code. So you need not to enter Code while creating  new Records");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 770, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 870, 40));
        jPanel1.add(txt_LName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 260, 30));

        jLabel6.setText("Last Name ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 110, 30));

        jLabel3.setText("Commission (%)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 650));

        setBounds(0, 0, 905, 677);
    }// </editor-fold>//GEN-END:initComponents

    private void but_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_SearchActionPerformed
        SearchMode();
    }//GEN-LAST:event_but_SearchActionPerformed

    private void but_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_RefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_but_RefreshActionPerformed

    private void txt_CodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CodeActionPerformed
        loadSalesMan();
    }//GEN-LAST:event_txt_CodeActionPerformed

    private void but_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_SaveActionPerformed
        SaveProcess();
    }//GEN-LAST:event_but_SaveActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void but_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_UpdateActionPerformed
        EditMode();
    }//GEN-LAST:event_but_UpdateActionPerformed

    private void txt_CodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodeKeyTyped

    }//GEN-LAST:event_txt_CodeKeyTyped

    private void Chk_ActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chk_ActiveMouseClicked

    }//GEN-LAST:event_Chk_ActiveMouseClicked

    private void txt_CommPerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CommPerKeyTyped
        fv.validateforFloatingPoints(txt_CommPer, evt, 2);
    }//GEN-LAST:event_txt_CommPerKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Chk_Active;
    private javax.swing.JButton but_Refresh;
    private javax.swing.JButton but_Save;
    private javax.swing.JButton but_Search;
    private javax.swing.JButton but_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jpanelq;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JTextField txt_Code;
    private javax.swing.JTextField txt_CommPer;
    private javax.swing.JTextField txt_LName;
    private javax.swing.JTextField txt_Name;
    // End of variables declaration//GEN-END:variables

    @Override
    public void SaveProcess() {
        if (but_Save.isEnabled()) {
            try {
                if (validateSalesPer()) {
                    MSalesMan s = new MSalesMan();
                    s.setId(txt_Code.getText());
                    s.setFirstName(txt_Name.getText().toUpperCase());
                    s.setLastName(txt_LName.getText().toUpperCase());
                    s.setImgPath("");
                    if (txt_CommPer.getText().length() > 0) {
                        s.setComPer(Double.parseDouble(txt_CommPer.getText()));
                    } else {
                        s.setComPer(0);
                    }

                    s.setActive((Chk_Active.isSelected() ? 1 : 0));

                    csales.saveSalesMan(s);

                    String txt = "";

                    if (txt_Code.getText().length() > 0) {
                        txt = "Update";
                    } else {
                        txt = "Save";
                    }
                    Refresh();
                    JOptionPane.showMessageDialog(rootPane, "Sales man sucessfully saved!", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void EditMode() {
        if (but_Update.isEnabled()) {
            JComponent en[] = {but_Refresh, but_Save, txt_Name, txt_LName, txt_CommPer};
            JComponent dis[] = {txt_Code, but_Update, but_Search};

            setDisableEnableComponents(en, dis);
        }
    }

    @Override
    public void Refresh() {
        if (but_Refresh.isEnabled()) {
            txt_Code.setText("");
            txt_Name.setText("");
            txt_LName.setText("");
            txt_CommPer.setText("");
              JComponent en[] = {but_Refresh, but_Save, txt_Name, txt_LName,txt_CommPer ,txt_Code,but_Search};
            JComponent dis[] = { but_Update };
 
            setDisableEnableComponents(en, dis);
            Chk_Active.setSelected(true);
            txt_Code.grabFocus();
        }
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
            Logger.getLogger(Frm_MSalesMan.class.getName()).log(Level.SEVERE, null, ex);
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
        col.add("First Name");
        col.add("Last Name");
        col.add("Commision(%)");

        String[] SQL_Col = {"ID", "FNAME", "LNAME"};
        String SQL = "select ID,FNAME,LNAME,COMM_PER from m_SalesPerson ";
        String SQLWhere = "  ";
        Connection currentCon = null;
        try {
            currentCon = DB.getCurrentCon();
        } catch (Exception ex) {
            Logger.getLogger(Frm_MSalesMan.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ft == null) {

            ft = new Frm_Table(txt_Code, currentCon, col, SQL_Col, SQL, SQLWhere);
            ft.setVisible(true);

        } else {
            ft = null;
            ft = new Frm_Table(txt_Code, currentCon, col, SQL_Col, SQL, SQLWhere);
            ft.setFocusable(true);
            ft.setVisible(true);
        }
    }

    private void loadSalesMan() {

        if (txt_Code.getText().length() > 0) {
            try {
                MSalesMan salesMan = csales.getSalesMan(txt_Code.getText());
                if (salesMan != null) {
                    txt_Name.setText(salesMan.getFirstName());
                    txt_LName.setText(salesMan.getLastName());
                    txt_CommPer.setText("" + salesMan.getComPer());
                    JComponent dis[] = {but_Refresh, but_Save, txt_Name, txt_LName, txt_CommPer, txt_Code};
                    JComponent en[] = {but_Update, but_Search};

                    setDisableEnableComponents(en, dis);
                } else {
                    throw new Exception("No Saleman found");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    private boolean validateSalesPer() throws Exception {
        boolean state = true;

        if (txt_Name.getText().length() == 0) {
            state = false;
            throw new Exception("Pleaseenater first name");
        }
        return state;
    }

}
