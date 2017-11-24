/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;

import COMMONFUN.JTreeMenuCellRender;
import CONTROLLERS.C_GroupCommon;

import GLOBALDATA.GlobalData;
import MAIN.Frm_Main;
import MODELS.MGroupCommon;
import UI.Frm_Table;
import VALIDATIONS.MyValidator;
import WINMNG.MyWindowBasicControllers;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author HOME
 */
public class Frm_MGroupMap extends javax.swing.JInternalFrame implements MyWindowBasicControllers {

    Frm_Table ft = null;

    Frm_Main mainW = null;
    MyValidator fv = null;

    C_GroupCommon CGroup = null;

    public Frm_MGroupMap(Frm_Main mainw, String ScreenName) {
        initComponents();
        this.setTitle(ScreenName);
        this.lblScreenName.setText(ScreenName);
        this.mainW = mainw;
        this.fv = new MyValidator();

        CGroup = new C_GroupCommon();

        Refresh();
        setShortCutKeys(this);
        createLayout();
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
        but_LocUpdate = new javax.swing.JButton();
        but_LocSave = new javax.swing.JButton();
        butLocRefresh = new javax.swing.JButton();
        lblScreenName = new javax.swing.JLabel();
        jpanelq = new javax.swing.JPanel();
        cmbG1 = new javax.swing.JComboBox();
        lblG1 = new javax.swing.JLabel();
        lblG2 = new javax.swing.JLabel();
        cmbG2 = new javax.swing.JComboBox();
        cmbG3 = new javax.swing.JComboBox();
        lblG3 = new javax.swing.JLabel();
        cmbG4 = new javax.swing.JComboBox();
        lblG4 = new javax.swing.JLabel();
        lblG5 = new javax.swing.JLabel();
        cmbG5 = new javax.swing.JComboBox();
        butGroupComAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGroupCom = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree_Groups = new javax.swing.JTree();

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

        cmbG1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbG1ActionPerformed(evt);
            }
        });
        cmbG1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbG1KeyReleased(evt);
            }
        });
        jPanel1.add(cmbG1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 30));

        lblG1.setText("Code");
        jPanel1.add(lblG1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 30));

        lblG2.setText("Code");
        jPanel1.add(lblG2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 170, 30));

        cmbG2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbG2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 170, 30));

        cmbG3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbG3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 170, 30));

        lblG3.setText("Code");
        jPanel1.add(lblG3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 170, 30));

        cmbG4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbG4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, 30));

        lblG4.setText("Code");
        jPanel1.add(lblG4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 170, 30));

        lblG5.setText("Code");
        jPanel1.add(lblG5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 170, 30));

        cmbG5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbG5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 170, 30));

        butGroupComAdd.setText("Add Combination");
        butGroupComAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butGroupComAddActionPerformed(evt);
            }
        });
        jPanel1.add(butGroupComAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, 30));

        tblGroupCom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Group 1", "Group 2", "Group 3", "Group 4", "Group 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGroupCom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblGroupComKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblGroupCom);
        if (tblGroupCom.getColumnModel().getColumnCount() > 0) {
            tblGroupCom.getColumnModel().getColumn(0).setResizable(false);
            tblGroupCom.getColumnModel().getColumn(1).setResizable(false);
            tblGroupCom.getColumnModel().getColumn(2).setResizable(false);
            tblGroupCom.getColumnModel().getColumn(3).setResizable(false);
            tblGroupCom.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 510, 310));

        jScrollPane2.setViewportView(jTree_Groups);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 300, 560));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 868, 630));

        setBounds(0, 0, 867, 678);
    }// </editor-fold>//GEN-END:initComponents

    private void butLocRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLocRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_butLocRefreshActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void cmbG1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbG1KeyReleased


    }//GEN-LAST:event_cmbG1KeyReleased

    private void butGroupComAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butGroupComAddActionPerformed
        try {
            ArrayList<MGroupCommon> GList = new ArrayList<>();
            GList.add((MGroupCommon) cmbG1.getSelectedItem());
            GList.add((MGroupCommon) cmbG2.getSelectedItem());
            GList.add((MGroupCommon) cmbG3.getSelectedItem());
            GList.add((MGroupCommon) cmbG4.getSelectedItem());
            GList.add((MGroupCommon) cmbG5.getSelectedItem());

            CGroup.saveGroupMaping(GList);

            JOptionPane.showMessageDialog(rootPane, "Group combination saved Sucessfully!", GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.INFORMATION_MESSAGE);
            loadGroup1Links();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_butGroupComAddActionPerformed

    private void cmbG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbG1ActionPerformed

        loadGroup1Links();

    }//GEN-LAST:event_cmbG1ActionPerformed

    private void tblGroupComKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGroupComKeyPressed
        int selectedRow = tblGroupCom.getSelectedRow();
        if (selectedRow >= 0) {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to remove highlighted combination?", GlobalData.MESSAGEBOX, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    DefaultTableModel dtm = (DefaultTableModel) tblGroupCom.getModel();

                    ArrayList<MGroupCommon> arl = new ArrayList<>();
                    for (int i = 0; i < dtm.getColumnCount(); i++) {
                        MGroupCommon gc = (MGroupCommon) tblGroupCom.getValueAt(selectedRow, i);
                        arl.add(gc);
                    }

                    try {
                        CGroup.RemoveGroupMaping(arl);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, e.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
        }

        loadGroup1Links();
    }//GEN-LAST:event_tblGroupComKeyPressed

    private void but_LocSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_LocSaveActionPerformed
        SaveProcess();
    }//GEN-LAST:event_but_LocSaveActionPerformed

    private void but_LocUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_LocUpdateActionPerformed
        EditMode();
    }//GEN-LAST:event_but_LocUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butGroupComAdd;
    private javax.swing.JButton butLocRefresh;
    private javax.swing.JButton but_LocSave;
    private javax.swing.JButton but_LocUpdate;
    private javax.swing.JComboBox cmbG1;
    private javax.swing.JComboBox cmbG2;
    private javax.swing.JComboBox cmbG3;
    private javax.swing.JComboBox cmbG4;
    private javax.swing.JComboBox cmbG5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree_Groups;
    private javax.swing.JPanel jpanelq;
    private javax.swing.JLabel lblG1;
    private javax.swing.JLabel lblG2;
    private javax.swing.JLabel lblG3;
    private javax.swing.JLabel lblG4;
    private javax.swing.JLabel lblG5;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JTable tblGroupCom;
    // End of variables declaration//GEN-END:variables

    @Override
    public void SaveProcess() {

    }

    @Override
    public void EditMode() {

    }

    public void createLayout() {
        JComponent[] disableCom = {but_LocSave, but_LocUpdate};
        setDisableEnableComponents(null, disableCom);

        Map<Integer, String> GroupNames = CGroup.getGroupDisplayNames();
        lblG1.setText(GroupNames.get(1));
        lblG2.setText(GroupNames.get(2));
        lblG3.setText(GroupNames.get(3));
        lblG4.setText(GroupNames.get(4));
        lblG5.setText(GroupNames.get(5));

        JTableHeader th = tblGroupCom.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();

        for (int i = 0; i < 5; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(GroupNames.get(i + 1));
        }

        th.repaint();
        th.updateUI();
    }

    @Override
    public void Refresh() {
        JComponent enablecom[] = {};
        JComponent disablecom[] = {but_LocSave, but_LocUpdate};
        setDisableEnableComponents(enablecom, disablecom);
        cmbG1.setModel(new DefaultComboBoxModel(CGroup.getAllGroupValues(1, true)));

        cmbG2.setModel(new DefaultComboBoxModel(CGroup.getAllGroupValues(2)));
        cmbG3.setModel(new DefaultComboBoxModel(CGroup.getAllGroupValues(3)));
        cmbG4.setModel(new DefaultComboBoxModel(CGroup.getAllGroupValues(4)));
        cmbG5.setModel(new DefaultComboBoxModel(CGroup.getAllGroupValues(5)));

        loadGroup1Links();

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
            Logger.getLogger(Frm_MGroupMap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void setDisableEnableComponents(JComponent[] EnComlist, JComponent[] DisComlist) {
        if (DisComlist != null) {
            for (JComponent c : DisComlist) {
                c.setEnabled(false);
            }
        }
        if (EnComlist != null) {
            for (JComponent c : EnComlist) {
                c.setEnabled(true);
            }
        }
    }

    @Override
    public void SearchMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadGroup1Links() {

        try {
            ArrayList<Vector<MGroupCommon>> ar = CGroup.getAllGroupMapings((MGroupCommon) cmbG1.getSelectedItem());

            DefaultTableModel dtm = (DefaultTableModel) tblGroupCom.getModel();
            dtm.setRowCount(0);
            for (Vector<MGroupCommon> v : ar) {
                dtm.addRow(v);
            }

            Tree_loadGroupTree();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);

        }
    }

    private void Tree_loadGroupTree() {
        try {

            MGroupCommon g = (MGroupCommon) cmbG1.getSelectedItem();
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(g);

            Map<Integer, String> m = new TreeMap<>();
            m.put(1, g.getId());
            jTree_Groups.setModel(new DefaultTreeModel(CGroup.getTreeNodes(m, g.getId(), 2, root)));

          //  expandAllNodes(jTree_Groups, 0,jTree_Groups.getRowCount());
              jTree_Groups.setCellRenderer(new JTreeMenuCellRender());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }

        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }
}
