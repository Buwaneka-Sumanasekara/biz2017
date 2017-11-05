/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;

import CONTROLLERS.C_UserGroup;
import CONTROLLERS.C_Users;
import DB_ACCESS.DB;
import MAIN.Frm_Main;
import MODELS.MPermissions;
import MODELS.MUser;
import MODELS.MUsergroup;
import MODELS.MUsersecurity;
import UI.Frm_Table;
import VALIDATIONS.MyValidator;
import WINMNG.MyWindowBasicControllers;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author HOME
 */
public class Frm_SUserCreation extends javax.swing.JInternalFrame implements MyWindowBasicControllers {

    Frm_Table ft = null;

    Frm_Main mainW = null;
    MyValidator fv = null;
    C_UserGroup cug = null;
    C_Users cuser = null;

    public Frm_SUserCreation(Frm_Main mainw, String ScreenName) {
        initComponents();
        this.setTitle(ScreenName);
        this.lblScreenName.setText(ScreenName);
        this.mainW = mainw;
        this.fv = new MyValidator();
        this.cug = new C_UserGroup();
        this.cuser = new C_Users();
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

        img_chooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        txt_UserId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        but_UserUpdate = new javax.swing.JButton();
        but_UserSave = new javax.swing.JButton();
        but_UserSearch = new javax.swing.JButton();
        but_UserRefresh = new javax.swing.JButton();
        lblScreenName = new javax.swing.JLabel();
        jpanelq = new javax.swing.JPanel();
        txt_FirstName = new javax.swing.JTextField();
        Chk_Active = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Uname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_UserGrp = new javax.swing.JComboBox<>();
        lblimg = new javax.swing.JLabel();
        but_ChooseImg = new javax.swing.JButton();
        txt_imgurl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_LastName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        chkpassword = new javax.swing.JCheckBox();
        layout_ResetPass = new javax.swing.JPanel();
        butResetPass = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

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

        txt_UserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UserIdActionPerformed(evt);
            }
        });
        txt_UserId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_UserIdKeyTyped(evt);
            }
        });
        jPanel1.add(txt_UserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 150, 30));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        but_UserUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/edit.png"))); // NOI18N
        but_UserUpdate.setToolTipText("Save");
        but_UserUpdate.setContentAreaFilled(false);
        but_UserUpdate.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/edit_disable.png"))); // NOI18N
        but_UserUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_UserUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(but_UserUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 40, 40));

        but_UserSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save.png"))); // NOI18N
        but_UserSave.setToolTipText("Save");
        but_UserSave.setContentAreaFilled(false);
        but_UserSave.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save_disable.png"))); // NOI18N
        but_UserSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_UserSaveActionPerformed(evt);
            }
        });
        jPanel2.add(but_UserSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        but_UserSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search.png"))); // NOI18N
        but_UserSearch.setToolTipText("Search(F2)");
        but_UserSearch.setContentAreaFilled(false);
        but_UserSearch.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Search_disable.png"))); // NOI18N
        but_UserSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_UserSearchActionPerformed(evt);
            }
        });
        jPanel2.add(but_UserSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 40, 40));

        but_UserRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh.png"))); // NOI18N
        but_UserRefresh.setToolTipText("Refresh");
        but_UserRefresh.setContentAreaFilled(false);
        but_UserRefresh.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/refresh_disable.png"))); // NOI18N
        but_UserRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_UserRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(but_UserRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 40, 40));

        lblScreenName.setBackground(new java.awt.Color(153, 255, 51));
        lblScreenName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblScreenName.setText("caption");
        jPanel2.add(lblScreenName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 180, 40));
        jPanel2.add(jpanelq, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 270, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));
        jPanel1.add(txt_FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, 30));

        Chk_Active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chk_ActiveMouseClicked(evt);
            }
        });
        jPanel1.add(Chk_Active, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 180, -1));

        jLabel1.setText("User Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 110, 30));

        jLabel2.setText("Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 110, 30));
        jPanel1.add(txt_Uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 260, 30));

        jLabel4.setText("First Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 110, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(153, 51, 0));
        jLabel5.setText("System will provide Auto Number for Code. So you need not to enter Code while creating  new Records");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 810, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 820, 40));

        jLabel3.setText("Last Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 110, 30));

        jPanel1.add(cmb_UserGrp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 260, 30));

        lblimg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/1465731972_user-01.png"))); // NOI18N
        lblimg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(lblimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 150, 190));

        but_ChooseImg.setText("Browse");
        but_ChooseImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_ChooseImgActionPerformed(evt);
            }
        });
        jPanel1.add(but_ChooseImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, -1, -1));

        txt_imgurl.setText("path/to/user/jpg");
        jPanel1.add(txt_imgurl, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 300, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 410, 10));
        jPanel1.add(txt_LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 260, 30));

        jLabel6.setText("User Group");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 110, 30));

        jLabel7.setText("Password");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 260, 30));

        chkpassword.setText("Use User name As Password");
        jPanel1.add(chkpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 180, 30));

        layout_ResetPass.setBackground(new java.awt.Color(153, 153, 153));
        layout_ResetPass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butResetPass.setText("Reset Password to Username");
        butResetPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butResetPassActionPerformed(evt);
            }
        });
        layout_ResetPass.add(butResetPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 190, 70));

        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reset Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        layout_ResetPass.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 180));

        jPanel1.add(layout_ResetPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 380, 180));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 620));

        setBounds(0, 0, 867, 646);
    }// </editor-fold>//GEN-END:initComponents

    private void but_UserSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_UserSearchActionPerformed
        SearchMode();
    }//GEN-LAST:event_but_UserSearchActionPerformed

    private void but_UserRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_UserRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_but_UserRefreshActionPerformed

    private void Chk_ActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chk_ActiveMouseClicked
        ChangeActive();
    }//GEN-LAST:event_Chk_ActiveMouseClicked

    private void txt_UserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UserIdActionPerformed

        LoadUser();

    }//GEN-LAST:event_txt_UserIdActionPerformed

    private void but_UserSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_UserSaveActionPerformed

        SaveProcess();


    }//GEN-LAST:event_but_UserSaveActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void but_UserUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_UserUpdateActionPerformed
        EditMode();
    }//GEN-LAST:event_but_UserUpdateActionPerformed

    private void txt_UserIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UserIdKeyTyped

    }//GEN-LAST:event_txt_UserIdKeyTyped

    private void but_ChooseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_ChooseImgActionPerformed

        int returnval = img_chooser.showOpenDialog(but_ChooseImg);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            File file = img_chooser.getSelectedFile();
            setLableImage(file);

        }


    }//GEN-LAST:event_but_ChooseImgActionPerformed

    private void butResetPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butResetPassActionPerformed

        try {
            if (txt_Uname.getText().length() > 0) {
                if (txt_Uname.isEditable()) {
                    throw new Exception("This option is not valid for new users");
                } else {
                    cuser.ResetPassword(txt_Uname.getText());
                    JOptionPane.showMessageDialog(rootPane, "Password reset sucessfully", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                throw new Exception("Need Valid User");
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_butResetPassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Chk_Active;
    private javax.swing.JButton butResetPass;
    private javax.swing.JButton but_ChooseImg;
    private javax.swing.JButton but_UserRefresh;
    private javax.swing.JButton but_UserSave;
    private javax.swing.JButton but_UserSearch;
    private javax.swing.JButton but_UserUpdate;
    private javax.swing.JCheckBox chkpassword;
    private javax.swing.JComboBox<String> cmb_UserGrp;
    private javax.swing.JFileChooser img_chooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpanelq;
    private javax.swing.JPanel layout_ResetPass;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JLabel lblimg;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txt_FirstName;
    private javax.swing.JTextField txt_LastName;
    private javax.swing.JTextField txt_Uname;
    private javax.swing.JTextField txt_UserId;
    private javax.swing.JLabel txt_imgurl;
    // End of variables declaration//GEN-END:variables

    @Override
    public void SaveProcess() {
        try {
            if (doValidate()) {
                if (txt_UserId.getText().length() > 0) {
                    //update
                    MUser u = cuser.getUser(txt_UserId.getText());
                    if (u != null) {
                        if (checkForUserDetUpdates(u)) {
                            MPermissions p = GLOBALDATA.GlobalData.SpecialPer.get("S00004");
                            if (p != null) {
                                u.setFirstname(txt_FirstName.getText());
                                u.setLastname(txt_Uname.getText());
                                u.setActive((byte) (Chk_Active.isSelected() ? 1 : 0));

                                if (txt_imgurl.getText().length() > 0) {

                                    u.setImgurl("MyData/Users/USER_"+u.getId()+"."+getExtension(new File(txt_imgurl.getText())));
                                } else {
                                    u.setImgurl("");
                                }

                                MUsergroup usergrp = (MUsergroup) cmb_UserGrp.getSelectedItem();
                                u.setMUsergroup(usergrp);
                                cuser.saveUser(u, null);
                                uploadImage(u.getImgurl(), u.getId());
                                JOptionPane.showMessageDialog(rootPane, "User details updated sucessfully", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.INFORMATION_MESSAGE);
                                Refresh();
                            } else {
                                throw new Exception("You don`t have permission to update user details");
                            }
                        } else if (u.getActive() != ((byte) (Chk_Active.isSelected() ? 1 : 0))) {
                            MPermissions p = GLOBALDATA.GlobalData.SpecialPer.get("S00004");
                            if (p != null) {

                                u.setActive((byte) (Chk_Active.isSelected() ? 1 : 0));
                                cuser.saveUser(u, null);
                                JOptionPane.showMessageDialog(rootPane, "User state updated sucessfully", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.INFORMATION_MESSAGE);

                                Refresh();
                            } else {
                                throw new Exception("You don`t have permission to change state");
                            }
                        }

                    } else {
                        throw new Exception("Invalid user Id, No user found for this id");
                    }

                } else {
                    //Save

                    MUser u = new MUser();
                    u.setId("");
                    u.setFirstname(txt_FirstName.getText());
                    u.setLastname(txt_Uname.getText());
                    u.setActive((byte) 1);
                    if (txt_imgurl.getText().length() > 0) {

                        u.setImgurl(getExtension(new File(txt_imgurl.getText())));
                    } else {
                        u.setImgurl("");
                    }

                    MUsergroup usergrp = (MUsergroup) cmb_UserGrp.getSelectedItem();
                    u.setMUsergroup(usergrp);
                    MUsersecurity us = new MUsersecurity();
                    us.setUsername(txt_Uname.getText());
                    if (chkpassword.isSelected() == false) {
                        us.setPassword(txtPassword.getText());
                    } else {
                        us.setPassword(txt_Uname.getText());
                    }
                    String userid = cuser.saveUser(u, us);
                    uploadImage(u.getImgurl(), userid);
                    Refresh();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void EditMode() {

        JComponent[] DisCom = {but_UserUpdate, but_UserSearch, txt_Uname, txt_UserId};
        JComponent[] EnCom = {but_UserSave, but_UserRefresh, txt_FirstName, txt_LastName, txt_UserId, cmb_UserGrp, chkpassword, txtPassword, Chk_Active, but_ChooseImg, butResetPass};
        setDisableEnableComponents(EnCom, DisCom);
        layout_ResetPass.setVisible(true);

    }

    @Override
    public void Refresh() {
        try {
            txt_FirstName.setText("");
            txt_LastName.setText("");
            txt_Uname.setText("");
            txt_UserId.setText("");
            txt_imgurl.setText("");

            Chk_Active.setSelected(true);

            txt_imgurl.setVisible(false);

            cmb_UserGrp.setModel(new DefaultComboBoxModel(cug.getUserGroups(true, false)));
            ChangeActive();
            layout_ResetPass.setVisible(false);

            JComponent[] DisCom = {but_UserUpdate};
            JComponent[] EnCom = {but_UserSearch, but_UserSave, but_UserRefresh, txt_FirstName, txt_LastName, txt_UserId, cmb_UserGrp, txt_Uname, chkpassword, txtPassword, Chk_Active, but_ChooseImg};
            setDisableEnableComponents(EnCom, DisCom);
            lblimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/1465731972_user-01.png"))); // NOI18N
        } catch (Exception ex) {
            Logger.getLogger(Frm_SUserCreation.class.getName()).log(Level.SEVERE, null, ex.getMessage());
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
            Logger.getLogger(Frm_SUserCreation.class.getName()).log(Level.SEVERE, null, ex);
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
        col.add("State");
        col.add("User Group");

        String[] SQL_Col = {"A.ID", "A.FIRSTNAME", "A.LASTNAME", "A.STATEE", "A.GROUPNAME"};
        String SQL = "SELECT * FROM (select U.ID,U.FIRSTNAME,U.LASTNAME,IF (U.ACTIVE=1,'ACTIVE', 'DEACTIVE') AS STATEE,UG.GROUPNAME from m_user U ";
        SQL += " INNER JOIN m_usergroup UG  ";
        SQL += " ON U.UGRUID=UG.ID  ";
        String SQLWhere = " U.VISIBLE=1 )A WHERE ";
        String endq="";
        //  System.out.println(SQL);
        Connection currentCon = null;
        try {
            currentCon = DB.getCurrentCon();
        } catch (Exception ex) {
            Logger.getLogger(Frm_SUserCreation.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ft == null) {

            ft = new Frm_Table(this, true,txt_UserId, currentCon, col, SQL_Col, SQL, SQLWhere, endq);
            ft.setVisible(true);

        } else {
            ft = null;
            ft = new Frm_Table(this, true,txt_UserId, currentCon, col, SQL_Col, SQL, SQLWhere, endq);
            ft.setFocusable(true);
            ft.setVisible(true);
        }

    }

    private void ChangeActive() {
        if (Chk_Active.isSelected()) {
            Chk_Active.setText("Active");
        } else {
            Chk_Active.setText("Deactive");
        }

    }

    private boolean doValidate() throws Exception {
        boolean state = true;

        if (txt_FirstName.getText().length() == 0) {
            state = false;
            throw new Exception("Please enter First Name");
        } else if (txt_Uname.getText().length() == 0) {
            state = false;
            throw new Exception("Please enter Last Name");
        } else if (txt_UserId.getText().length() == 0 && txt_Uname.getText().length() == 0) {
            state = false;
            throw new Exception("Enter valid username");
        } else if (txt_UserId.getText().length() == 0 && chkpassword.isSelected() == false) {
            state = false;
            throw new Exception("Enter Password");
        }
        return state;
    }

    private boolean checkForUserDetUpdates(MUser user) {
        boolean state = false;
        MUsergroup usergrp = (MUsergroup) cmb_UserGrp.getSelectedItem();
        if (txt_FirstName.getText().toUpperCase().equals(user.getFirstname().toUpperCase())) {
            state = true;
        } else if (txt_Uname.getText().toUpperCase().equals(user.getLastname().toUpperCase())) {
            state = true;
        } else if (txt_imgurl.getText().toUpperCase().equals(user.getImgurl().toUpperCase())) {
            state = true;
        } else if (txt_imgurl.getText().toUpperCase().equals(user.getImgurl().toUpperCase())) {
            state = true;
        } else if (!user.getMUsergroup().equals(usergrp)) {
            state = true;
        }

        return state;
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    private void uploadImage(String imgurl, String userid) throws Exception {
        if (imgurl.length() > 0) {

            File f = new File(imgurl);
            if (f.exists()) {
                Path FROM = Paths.get(f.getAbsolutePath());

                Path TO = Paths.get("MyData\\Users\\USER_" + userid + "." + getExtension(f));
                //overwrite existing file, if exists
                CopyOption[] options = new CopyOption[]{
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
                };
                Files.copy(FROM, TO, options);
            }

        }

    }

    private void LoadUser() {
        if (txt_UserId.getText().length() > 0) {
            try {
                MUser u = cuser.getUser(txt_UserId.getText());
                if (u != null) {

                    txt_UserId.setText(u.getId());
                    txt_FirstName.setText(u.getFirstname());
                    txt_LastName.setText(u.getLastname());
                    cmb_UserGrp.setSelectedItem(u.getMUsergroup());
                    Chk_Active.setSelected(u.getActive() == 1 ? true : false);
                    txt_Uname.setText(u.getUsername());
                    txtPassword.setText("");

                    txt_imgurl.setText("");

                    if (u.getImgurl().length() > 0) {
                        setLableImage(new File(u.getImgurl()));
                    }
                    layout_ResetPass.setVisible(true);

                    JComponent[] EnCom = {but_UserUpdate};
                    JComponent[] DisCom = {txt_UserId, but_UserSearch, but_UserSave, but_UserRefresh, txt_FirstName, txt_LastName, txt_UserId, cmb_UserGrp, txt_Uname, chkpassword, txtPassword, Chk_Active, but_ChooseImg, butResetPass};
                    setDisableEnableComponents(EnCom, DisCom);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    private void setLableImage(File file) {
        if (file.exists()) {
            System.out.println(file.getAbsolutePath());
            txt_imgurl.setText(file.getAbsolutePath());
            BufferedImage img = null;
            try {
                img = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimg = img.getScaledInstance(lblimg.getWidth(), lblimg.getHeight(),
                    Image.SCALE_SMOOTH);

            lblimg.setIcon(new ImageIcon(dimg));
        } else {
            lblimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/1465731972_user-01.png"))); // NOI18N
        }

    }

}
