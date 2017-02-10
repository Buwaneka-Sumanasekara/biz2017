/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;


import MAIN.Frm_Main;

import UI.Frm_Table;
import VALIDATIONS.MyValidator;
import WINMNG.MyWindowBasicControllers;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

/**
 *
 * @author HOME
 */
public class Frm_SUserSecurity extends javax.swing.JInternalFrame implements MyWindowBasicControllers {

    Frm_Table ft = null;
  
    Frm_Main mainW=null;
    MyValidator fv=null;
    
    public Frm_SUserSecurity(Frm_Main mainw,String ScreenName) {
        initComponents();
       this.setTitle(ScreenName);
       this.lblScreenName.setText(ScreenName);
        this.mainW=mainw;
        this.fv=new MyValidator();
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
        txt_LocCode = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        but_LocUpdate = new javax.swing.JButton();
        but_LocSave = new javax.swing.JButton();
        but_LocSearch = new javax.swing.JButton();
        butLocRefresh = new javax.swing.JButton();
        lblScreenName = new javax.swing.JLabel();
        jpanelq = new javax.swing.JPanel();
        txt_LocDescription = new javax.swing.JTextField();
        Chk_Active = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_LocRefNO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

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

        txt_LocCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_LocCodeActionPerformed(evt);
            }
        });
        txt_LocCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_LocCodeKeyTyped(evt);
            }
        });
        jPanel1.add(txt_LocCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 150, 30));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        but_LocUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/edit.png"))); // NOI18N
        but_LocUpdate.setToolTipText("Save");
        but_LocUpdate.setContentAreaFilled(false);
        but_LocUpdate.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/edit_disable.png"))); // NOI18N
        but_LocUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_LocUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(but_LocUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 40, 40));

        but_LocSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save.png"))); // NOI18N
        but_LocSave.setToolTipText("Save");
        but_LocSave.setContentAreaFilled(false);
        but_LocSave.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save_disable.png"))); // NOI18N
        but_LocSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_LocSaveActionPerformed(evt);
            }
        });
        jPanel2.add(but_LocSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        but_LocSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search.png"))); // NOI18N
        but_LocSearch.setToolTipText("Search(F2)");
        but_LocSearch.setContentAreaFilled(false);
        but_LocSearch.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search_disable.png"))); // NOI18N
        but_LocSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_LocSearchActionPerformed(evt);
            }
        });
        jPanel2.add(but_LocSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 40, 40));

        butLocRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh.png"))); // NOI18N
        butLocRefresh.setToolTipText("Refresh");
        butLocRefresh.setContentAreaFilled(false);
        butLocRefresh.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh_disable.png"))); // NOI18N
        butLocRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLocRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(butLocRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 40, 40));

        lblScreenName.setBackground(new java.awt.Color(153, 255, 51));
        lblScreenName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblScreenName.setText("caption");
        jPanel2.add(lblScreenName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 180, 40));
        jPanel2.add(jpanelq, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 270, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));
        jPanel1.add(txt_LocDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 260, 30));

        Chk_Active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chk_ActiveMouseClicked(evt);
            }
        });
        jPanel1.add(Chk_Active, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 180, -1));

        jLabel1.setText("Reference No/ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 110, 30));

        jLabel2.setText("Code");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 110, 30));
        jPanel1.add(txt_LocRefNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 160, 30));

        jLabel4.setText("Description *");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 110, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(153, 51, 0));
        jLabel5.setText("System will provide Auto Number for Code. So you need not to enter Code while creating  new Records");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 810, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 820, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 580));

        setBounds(0, 0, 867, 646);
    }// </editor-fold>//GEN-END:initComponents

    private void but_LocSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_LocSearchActionPerformed
        Vector<String> col = new Vector<>();
        col.add("Code");
        col.add("Des");

        String[] SQL_Col = {"ID", "NAME"};
        String SQL = "select ID,NAME from m_location ";
        String SQLWhere=" VISIBLE=1 AND ";
        Connection currentCon = null;
        try {
            currentCon = DB_Access.DB.getCurrentCon();
        } catch (Exception ex) {
            Logger.getLogger(Frm_SUserSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } 
        if (ft == null) {

            ft = new Frm_Table(txt_LocCode, currentCon, col, SQL_Col, SQL,SQLWhere);
            ft.setVisible(true);

        } else {
            ft=null;
             ft = new Frm_Table(txt_LocCode, currentCon, col, SQL_Col, SQL,SQLWhere);
            ft.setFocusable(true);
            ft.setVisible(true);
        }
    }//GEN-LAST:event_but_LocSearchActionPerformed

    private void butLocRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLocRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_butLocRefreshActionPerformed

    private void Chk_ActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chk_ActiveMouseClicked
       
    }//GEN-LAST:event_Chk_ActiveMouseClicked

    private void txt_LocCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_LocCodeActionPerformed
      
    }//GEN-LAST:event_txt_LocCodeActionPerformed

    private void but_LocSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_LocSaveActionPerformed
       
    }//GEN-LAST:event_but_LocSaveActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
      
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
   
    }//GEN-LAST:event_formInternalFrameOpened

    private void but_LocUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_LocUpdateActionPerformed
  
    }//GEN-LAST:event_but_LocUpdateActionPerformed

    private void txt_LocCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_LocCodeKeyTyped
      
    }//GEN-LAST:event_txt_LocCodeKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Chk_Active;
    private javax.swing.JButton butLocRefresh;
    private javax.swing.JButton but_LocSave;
    private javax.swing.JButton but_LocSearch;
    private javax.swing.JButton but_LocUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jpanelq;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JTextField txt_LocCode;
    private javax.swing.JTextField txt_LocDescription;
    private javax.swing.JTextField txt_LocRefNO;
    // End of variables declaration//GEN-END:variables

    @Override
    public void SaveProcess() {

      
    }

    @Override
    public void EditMode() {
       
    }

    @Override
    public void Refresh() {
       
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
            mainW.CurrentFrame="";
            
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Frm_SUserSecurity.class.getName()).log(Level.SEVERE, null, ex);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
