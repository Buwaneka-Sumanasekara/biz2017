/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;

import CONTROLLERS.C_GroupCommon;
import CONTROLLERS.C_Products;
import DB_ACCESS.DB;
import EXCEL_UPLOADER.ExcelUploader;
import EXCEL_UPLOADER.Test;
import MAIN.Frm_Main;
import MODELS.MGroupCommon;
import MODELS.MProductExcel;
import MODELS.MProducts;
import static SUBUI.Frm_SUserCreation.getExtension;
import UI.Frm_Table;
import VALIDATIONS.MyValidator;
import WINMNG.MyWindowBasicControllers;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author HOME
 */
public class Frm_UExcelUploader extends javax.swing.JInternalFrame implements MyWindowBasicControllers {

    Frm_Table ft = null;

    Frm_Main mainW = null;
    MyValidator fv = null;
    ExcelUploader CExcelUp = null;
    C_GroupCommon Grp = null;
    C_Products cpro = null;

    public Frm_UExcelUploader(Frm_Main mainw, String ScreenName) {
        initComponents();
        this.setTitle(ScreenName);
        this.lblScreenName.setText(ScreenName);
        this.mainW = mainw;
        this.fv = new MyValidator();
        this.CExcelUp = new ExcelUploader();
        this.Grp = new C_GroupCommon();
        this.cpro = new C_Products();
        Refresh();
        setShortCutKeys(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        but_ExcelSave = new javax.swing.JButton();
        lblScreenName = new javax.swing.JLabel();
        jpanelq = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        but_Choose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmb_Type = new javax.swing.JComboBox<String>();
        lbl_Path = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

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

        but_ExcelSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save.png"))); // NOI18N
        but_ExcelSave.setToolTipText("Save");
        but_ExcelSave.setContentAreaFilled(false);
        but_ExcelSave.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/Controlls/Save_disable.png"))); // NOI18N
        but_ExcelSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_ExcelSaveActionPerformed(evt);
            }
        });
        jPanel2.add(but_ExcelSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        lblScreenName.setBackground(new java.awt.Color(153, 255, 51));
        lblScreenName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblScreenName.setText("caption");
        jPanel2.add(lblScreenName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 180, 40));
        jPanel2.add(jpanelq, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 270, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose Your File");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 210, 20));

        but_Choose.setText("Choose");
        but_Choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_ChooseActionPerformed(evt);
            }
        });
        jPanel1.add(but_Choose, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 120, 50));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/if_Excel_15_98845.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 240, 170));

        jPanel1.add(cmb_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 240, 50));

        lbl_Path.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_Path, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 560, 50));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 750, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 620));

        setBounds(0, 0, 867, 646);
    }// </editor-fold>//GEN-END:initComponents

    private void but_ExcelSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_ExcelSaveActionPerformed
        SaveProcess();
    }//GEN-LAST:event_but_ExcelSaveActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void but_ChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_ChooseActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XLS files", "xlsx");
        jFileChooser1.setFileFilter(filter);
        int returnval = jFileChooser1.showOpenDialog(this);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            lbl_Path.setText(file.getAbsolutePath());

        }
    }//GEN-LAST:event_but_ChooseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_Choose;
    private javax.swing.JButton but_ExcelSave;
    private javax.swing.JComboBox<String> cmb_Type;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPanel jpanelq;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JLabel lbl_Path;
    // End of variables declaration//GEN-END:variables

    @Override
    public void SaveProcess() {
        try {
            if (lbl_Path.getText().length() > 0) {
                File f = new File(lbl_Path.getText());
                if (f.exists()) {
                    ExcelUploader e = new ExcelUploader();

                    e.importFromExcel(f, ExcelUploader.TABLE_PRODUCT_FULL);
                    JOptionPane.showMessageDialog(rootPane, "Excel impored Sucessfully!", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void EditMode() {

    }

    @Override
    public void Refresh() {

        Vector<ExcelType> v = new Vector<>();
        v.add(new ExcelType(ExcelUploader.TABLE_PRODUCT_FULL, "Product full"));

        cmb_Type.setModel(new DefaultComboBoxModel(v));
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
            Logger.getLogger(Frm_UExcelUploader.class.getName()).log(Level.SEVERE, null, ex);
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

    private void doUpload() {

    }

    private void ReplaceProImg() {
        try {
            ArrayList<MProducts> allProducts = cpro.getAllProducts(1);
            for (MProducts p : allProducts) {
                System.out.println(p.getRef1().trim().replace(" ", ""));
                if (p.getRef1().length() > 0 && p.getRef1().indexOf("-") > -1) {
                    String[] split = p.getRef1().trim().split("-");
                    String FrmPath = "C:\\Users\\HOME\\Downloads\\PRODUCTS\\" + split[1].trim().replace(" ", "").toLowerCase() + ".jpg";
                    System.out.println(FrmPath);
                    File f = new File(FrmPath);
                    if (f.exists()) {
                        Path FROM = Paths.get(f.getAbsolutePath());

                        String RepPath = "MyData/Products/PRO_" + p.getId() + "." + getExtension(f);

                        System.out.println(RepPath);

                        Path TO = Paths.get(RepPath);

//overwrite existing file, if exists
                        CopyOption[] options = new CopyOption[]{
                            StandardCopyOption.REPLACE_EXISTING,
                            StandardCopyOption.COPY_ATTRIBUTES
                        };
                        Files.copy(FROM, TO, options);

                        DB.Update("UPDATE m_products SET PRO_IMG='" + RepPath + "' where ID='" + p.getId() + "' ");

                        //    System.out.println(p.getId());
                    }
                }
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}

class ExcelType {

    public ExcelType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

}
