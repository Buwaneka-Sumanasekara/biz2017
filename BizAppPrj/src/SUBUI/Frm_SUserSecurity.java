/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;


import CONTROLLERS.C_Users;
import DB_ACCESS.DB;
import MAIN.Frm_Main;
import MODELS.MUsersecurity;
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
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author HOME
 */
public class Frm_SUserSecurity extends javax.swing.JInternalFrame implements MyWindowBasicControllers {

    Frm_Table ft = null;
  
    Frm_Main mainW=null;
    MyValidator fv=null;
    C_Users cuser=null;
    public Frm_SUserSecurity(Frm_Main mainw,String ScreenName) {
        initComponents();
       this.setTitle(ScreenName);
       this.lblScreenName.setText(ScreenName);
        this.mainW=mainw;
        this.fv=new MyValidator();
        this.cuser=new C_Users();
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
        txtUsername = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        but_LocSave = new javax.swing.JButton();
        lblScreenName = new javax.swing.JLabel();
        jpanelq = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtConfPass = new javax.swing.JPasswordField();
        txtCurPass = new javax.swing.JPasswordField();
        txtNewPass = new javax.swing.JPasswordField();

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

        txtUsername.setEditable(false);
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 190, 30));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lblScreenName.setBackground(new java.awt.Color(153, 255, 51));
        lblScreenName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblScreenName.setText("caption");
        jPanel2.add(lblScreenName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 180, 40));
        jPanel2.add(jpanelq, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 270, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));

        jLabel1.setText("Confirm Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 110, 30));

        jLabel2.setText("User name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 110, 30));

        jLabel4.setText("Current Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 110, 30));

        jLabel3.setText("New Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 110, 30));
        jPanel1.add(txtConfPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 190, 30));
        jPanel1.add(txtCurPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 190, 30));
        jPanel1.add(txtNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 190, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 620));

        setBounds(0, 0, 867, 646);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
      
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void but_LocSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_LocSaveActionPerformed
SaveProcess();
    }//GEN-LAST:event_but_LocSaveActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
      
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
   
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
      
    }//GEN-LAST:event_txtUsernameKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_LocSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpanelq;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JPasswordField txtConfPass;
    private javax.swing.JPasswordField txtCurPass;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    @Override
    public void SaveProcess() {
        try {
            if(validateSec()){
                MUsersecurity usec=new MUsersecurity();
                usec.setUsername(txtUsername.getText());
                usec.setPassword(txtConfPass.getText());
                cuser.updatePassword(usec,txtCurPass.getText());
                JOptionPane.showMessageDialog(rootPane, "Password updated sucessfully!",GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.INFORMATION_MESSAGE);
                Refresh();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX,JOptionPane.ERROR_MESSAGE);
        }
      
    }

    @Override
    public void EditMode() {
       
    }

    @Override
    public void Refresh() {
       txtNewPass.setText("");
       txtCurPass.setText("");
       txtConfPass.setText("");
       
       txtUsername.setText(GLOBALDATA.GlobalData.CurUser.getUsername());
       txtCurPass.grabFocus();
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

    private boolean validateSec()throws Exception {
      boolean state=true;
        if(txtUsername.getText().length()==0){
            state=false;
          throw new Exception("Plase enter username");
      } else if(txtCurPass.getText().length()==0){
          state=false;
          throw new Exception("Please enter current password");
      } else if(txtNewPass.getText().length()==0){
          state=false;
          throw new Exception("Please enter New  password");
      }else if(txtConfPass.getText().length()==0){
          state=false;
          throw new Exception("Please enter Confirm  password");
      }else if(!txtConfPass.getText().equals(txtNewPass.getText())){
          state=false;
          throw new Exception("Passwords should be match");
      }
    return state;
    
    
    }

}
