/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;


import CONTROLLERS.C_Voucher;
import DB_ACCESS.DB;
import MAIN.Frm_Main;
import MODELS.MGiftVoucher;
import MODELS.MGiftVoucherGroup;
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
public class Frm_GvCreation extends javax.swing.JInternalFrame implements MyWindowBasicControllers {

    Frm_Table ft = null;
  
    Frm_Main mainW=null;
    MyValidator fv=null;

    C_Voucher CVou=null;
    
    public Frm_GvCreation(Frm_Main mainw,String ScreenName) {
        initComponents();
       this.setTitle(ScreenName);
       this.lblScreenName.setText(ScreenName);
        this.mainW=mainw;
        this.fv=new MyValidator();
        this.CVou=new C_Voucher();
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
        jPanel2 = new javax.swing.JPanel();
        lblScreenName = new javax.swing.JLabel();
        jpanelq = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        butGenerate = new javax.swing.JButton();
        txtBookId = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtValue = new javax.swing.JTextField();
        txtEndNo = new javax.swing.JTextField();
        txtStartNo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();

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

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblScreenName.setBackground(new java.awt.Color(153, 255, 51));
        lblScreenName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblScreenName.setText("caption");
        jPanel2.add(lblScreenName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 180, 40));
        jPanel2.add(jpanelq, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 270, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Book Id");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 110, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Qty");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 110, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 110, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Value");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 110, 50));

        butGenerate.setText("Generate");
        butGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butGenerateActionPerformed(evt);
            }
        });
        jPanel3.add(butGenerate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 110, 40));

        txtBookId.setEditable(false);
        txtBookId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txtBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 210, 40));

        txtQty.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtQty.setText("1");
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtyKeyTyped(evt);
            }
        });
        jPanel3.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 150, 40));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 380, 40));

        txtValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValueKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValueKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValueKeyTyped(evt);
            }
        });
        jPanel3.add(txtValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 190, 40));

        txtEndNo.setEditable(false);
        jPanel3.add(txtEndNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 180, 40));

        txtStartNo.setEditable(false);
        jPanel3.add(txtStartNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 180, 40));

        jTabbedPane1.addTab("Create Vouchers", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addTab("Voucher Statues", jPanel4);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 850, 560));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 868, 630));

        setBounds(0, 0, 885, 662);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
      
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
   
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyTyped
 fv.NumbersOnly(txtQty, evt);      
        
       
    }//GEN-LAST:event_txtQtyKeyTyped

    private void txtValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValueKeyReleased
       
    }//GEN-LAST:event_txtValueKeyReleased

    private void txtQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyReleased
          
         try {
            
            txtEndNo.setText(CVou.getLastVoucherNo(txtStartNo.getText(), Integer.parseInt(txtQty.getText())));
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_txtQtyKeyReleased

    private void txtQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyPressed
    
    }//GEN-LAST:event_txtQtyKeyPressed

    private void txtValueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValueKeyPressed
        
    }//GEN-LAST:event_txtValueKeyPressed

    private void txtValueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValueKeyTyped
       fv.validateforFloatingPoints(txtValue, evt, 2);
    }//GEN-LAST:event_txtValueKeyTyped

    private void butGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butGenerateActionPerformed
        SaveProcess();
    }//GEN-LAST:event_butGenerateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butGenerate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpanelq;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JTextField txtBookId;
    private javax.swing.JTextField txtEndNo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtStartNo;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables

    @Override
    public void SaveProcess() {
        try {
           
            MGiftVoucherGroup gv=new MGiftVoucherGroup();
            gv.setActive(1);
            gv.setEndNo(txtEndNo.getText());
            gv.setGVvalue(Double.parseDouble(txtValue.getText()));
            gv.setGrpId(txtBookId.getText());
            gv.setGrpName(txtName.getText());
            gv.setGrpQty(Integer.parseInt(txtQty.getText()));
            gv.setStartNo(txtStartNo.getText());
            
           CVou.createVouchers(gv);
           Refresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,e.getMessage(),GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
        }
      
    }

    @Override
    public void EditMode() {
       
    }

    @Override
    public void Refresh() {
        try {
            txtBookId.setText(CVou.getBookNo());
            String SNo=CVou.getNxtVoucherNo();
            txtStartNo.setText(SNo);
            txtQty.setText("1");
            txtValue.setText("0.0");
           
            txtEndNo.setText(CVou.getLastVoucherNo(txtStartNo.getText(), 1));
           
        } catch (Exception ex) {
            Logger.getLogger(Frm_GvCreation.class.getName()).log(Level.SEVERE, null, ex);
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
            mainW.CurrentFrame="";
            
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Frm_GvCreation.class.getName()).log(Level.SEVERE, null, ex);
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
