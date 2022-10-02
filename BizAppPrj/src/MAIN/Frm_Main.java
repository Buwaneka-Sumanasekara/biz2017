/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import COMMONFUN.JTreeMenuCellRender;
import GLOBALDATA.GlobalData;
import LOGIN.Frm_Login;
import MODELS.MPermissions;
import MODELS.MUsergroup;
import SUBUI.Frm_Help;
import WINMNG.MyWindowManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author HOME
 */
public class Frm_Main extends javax.swing.JFrame {

    public String CurrentFrame = "";
     public MPermissions CurrentFrameObj = null;

    Frm_Login frmlog = null;
    MUsergroup ug = null;
    ArrayList<MPermissions> menus = null;
    MyWindowManager myw = null;
    Frm_Help frm_Help = null;

    public Frm_Main() {
        initComponents();
        //  this.setUndecorated(true);
    }

    public Frm_Main(Frm_Login frmlogin, ArrayList<MPermissions> m) {
        initComponents();
        reloadComponents();
        this.frmlog = frmlogin;
        this.menus = m;
        this.ug = new MUsergroup();
        this.myw = new MyWindowManager();
        this.lblUsername.setText(GlobalData.CurUser.getFirstname());
        this.lblCompanyName.setText(GlobalData.Setup.getComname());
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.frm_Help = new Frm_Help(this, true);
        this.txt_DB_HOST.setText("Server:  " + GlobalData.config.getServer());
        this.txt_DB_Name.setText("DB:  " + GlobalData.config.getDb());
        RefreshLayOut();
        createUserMenu();
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

        layout_Outer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TUserMenu = new javax.swing.JTree();
        layout_footer = new javax.swing.JPanel();
        txt_DB_HOST = new javax.swing.JLabel();
        lbl_Global_Instructions = new javax.swing.JLabel();
        txt_DB_Name = new javax.swing.JLabel();
        layout_profile = new javax.swing.JPanel();
        lblUserimg = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        JDesktopF = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        layout_header = new javax.swing.JPanel();
        butLogout = new javax.swing.JButton();
        lblCompanyName = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        butMinimize = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        layout_Outer.setBackground(new java.awt.Color(255, 255, 255));
        layout_Outer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        TUserMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        TUserMenu.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        TUserMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TUserMenuMouseClicked(evt);
            }
        });
        TUserMenu.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                TUserMenuValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(TUserMenu);

        layout_footer.setBackground(new java.awt.Color(153, 255, 153));

        txt_DB_HOST.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_DB_HOST.setForeground(new java.awt.Color(102, 102, 102));
        txt_DB_HOST.setText("jLabel1");

        lbl_Global_Instructions.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbl_Global_Instructions.setForeground(new java.awt.Color(204, 0, 0));
        lbl_Global_Instructions.setText("[  F2 : SEARCH   ]   [   F3: EDIT  ]  [  F4: REFRESH  ]   [  F5: SAVE  ]  [F6: HOLD]  [F7: CANCEL] [F8: PRINT]");

        txt_DB_Name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_DB_Name.setForeground(new java.awt.Color(102, 102, 102));
        txt_DB_Name.setText("jLabel1");

        javax.swing.GroupLayout layout_footerLayout = new javax.swing.GroupLayout(layout_footer);
        layout_footer.setLayout(layout_footerLayout);
        layout_footerLayout.setHorizontalGroup(
            layout_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout_footerLayout.createSequentialGroup()
                .addGap(0, 633, Short.MAX_VALUE)
                .addComponent(txt_DB_HOST, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_DB_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout_footerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbl_Global_Instructions, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(314, Short.MAX_VALUE)))
        );
        layout_footerLayout.setVerticalGroup(
            layout_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout_footerLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_DB_Name)
                    .addComponent(txt_DB_HOST))
                .addGap(24, 24, 24))
            .addGroup(layout_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout_footerLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(lbl_Global_Instructions)
                    .addContainerGap(27, Short.MAX_VALUE)))
        );

        layout_profile.setBackground(new java.awt.Color(255, 204, 204));
        layout_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserimg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/1465731972_user-01.png"))); // NOI18N
        layout_profile.add(lblUserimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 80));

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(102, 102, 102));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("BUWANEKA");
        layout_profile.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 150, 30));

        JDesktopF.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/iconappimg.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("ERP");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Biz");

        JDesktopF.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDesktopF.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDesktopF.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDesktopFLayout = new javax.swing.GroupLayout(JDesktopF);
        JDesktopF.setLayout(JDesktopFLayout);
        JDesktopFLayout.setHorizontalGroup(
            JDesktopFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDesktopFLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JDesktopFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JDesktopFLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JDesktopFLayout.setVerticalGroup(
            JDesktopFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDesktopFLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JDesktopFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        butLogout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        butLogout.setForeground(new java.awt.Color(89, 143, 179));
        butLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/if_free-09_463017.png"))); // NOI18N
        butLogout.setToolTipText("Exit [Esc]");
        butLogout.setBorderPainted(false);
        butLogout.setContentAreaFilled(false);
        butLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLogoutActionPerformed(evt);
            }
        });

        lblCompanyName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCompanyName.setForeground(new java.awt.Color(102, 102, 102));
        lblCompanyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompanyName.setText("COMPANY NAME");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/if_question_2625632.png"))); // NOI18N
        jButton1.setToolTipText("Help [F1] ");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        butMinimize.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        butMinimize.setForeground(new java.awt.Color(89, 143, 179));
        butMinimize.setText("-");
        butMinimize.setToolTipText("Minimize [-]");
        butMinimize.setBorderPainted(false);
        butMinimize.setContentAreaFilled(false);
        butMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMinimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout_headerLayout = new javax.swing.GroupLayout(layout_header);
        layout_header.setLayout(layout_headerLayout);
        layout_headerLayout.setHorizontalGroup(
            layout_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout_headerLayout.createSequentialGroup()
                .addComponent(lblCompanyName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout_headerLayout.setVerticalGroup(
            layout_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(butLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(butMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout_OuterLayout = new javax.swing.GroupLayout(layout_Outer);
        layout_Outer.setLayout(layout_OuterLayout);
        layout_OuterLayout.setHorizontalGroup(
            layout_OuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout_OuterLayout.createSequentialGroup()
                .addGroup(layout_OuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout_OuterLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(layout_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout_OuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDesktopF)
                    .addComponent(layout_footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(layout_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout_OuterLayout.setVerticalGroup(
            layout_OuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout_OuterLayout.createSequentialGroup()
                .addComponent(layout_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout_OuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout_OuterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDesktopF)
                        .addGap(0, 0, 0)
                        .addComponent(layout_footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout_OuterLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(layout_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layout_Outer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(layout_Outer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1245, 788));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void TUserMenuValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_TUserMenuValueChanged

    }//GEN-LAST:event_TUserMenuValueChanged

    private void TUserMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TUserMenuMouseClicked
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) TUserMenu.getLastSelectedPathComponent();

        if (node != null && node.isLeaf()) {
            try {
                openWindow((MPermissions) node.getUserObject());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Couldn`t open window: " + ex.getMessage(), GLOBALDATA.GlobalData.MESSAGEBOX, JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_TUserMenuMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ShowHelp();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void butLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLogoutActionPerformed
        Logout();
    }//GEN-LAST:event_butLogoutActionPerformed

    private void butMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butMinimizeActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_butMinimizeActionPerformed

    public static void main(String args[]) {

        /* try {
         UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
         } catch (ClassNotFoundException ex) {
         Logger.getLogger(Frm_Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
         Logger.getLogger(Frm_Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
         Logger.getLogger(Frm_Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(Frm_Login.class.getName()).log(Level.SEVERE, null, ex);
         }
         */
        //frm.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane JDesktopF;
    private javax.swing.JTree TUserMenu;
    private javax.swing.JButton butLogout;
    private javax.swing.JButton butMinimize;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel layout_Outer;
    private javax.swing.JPanel layout_footer;
    private javax.swing.JPanel layout_header;
    private javax.swing.JPanel layout_profile;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblUserimg;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lbl_Global_Instructions;
    private javax.swing.JLabel txt_DB_HOST;
    private javax.swing.JLabel txt_DB_Name;
    // End of variables declaration//GEN-END:variables

    public void setShortCutKeys(JFrame f) {

        String exit = "exit";
        InputMap inputMap0 = f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap0.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), exit);
        ActionMap actionMap0 = f.getRootPane().getActionMap();
        actionMap0.put(exit, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Logout();
            }

        }
        );

    }

    private void createUserMenu() {
        TreeMap<String, DefaultMutableTreeNode> NodesMap = new TreeMap<String, DefaultMutableTreeNode>();
        try {

            //create the root node
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("");

            for (MPermissions p : menus) {
                //  System.out.println(p.getId() + "-" + p.getParentid());

                if (p.getId().equals(p.getParentid())) {
                    if (NodesMap.get(p.getId()) == null) {
                        DefaultMutableTreeNode parent = new DefaultMutableTreeNode(p);
                        NodesMap.put(p.getId(), parent);
                        root.add(parent);

                    }
                } else {
                    DefaultMutableTreeNode parent = NodesMap.get(p.getParentid());
                    if (parent != null) {
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode(p);
                        
                        NodesMap.put(p.getId(), node);
                        parent.add(node);
                    }

                }
            }
            TUserMenu.setModel(new DefaultTreeModel(root));
            TUserMenu.setCellRenderer(new JTreeMenuCellRender());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private void openWindow(MPermissions p) throws Exception {

        JInternalFrame jf = myw.getRequestWindow(p, this);
        jf.setResizable(true);
        if (jf != null) {
            jf.setFocusCycleRoot(true);

            jf.setClosable(true);
             jf.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
            //  ((javax.swing.plaf.basic.BasicInternalFrameUI) jf.getUI()).setNorthPane(null);
            jf.setBorder(null);
            // jf.setBounds(0, 0, 868, 630);
            jf.addInternalFrameListener(new InternalFrameListener() {

                //[110,147,169]
                @Override
                public void internalFrameOpened(InternalFrameEvent e) {
                    try {
                        jf.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(Frm_Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                @Override
                public void internalFrameClosing(InternalFrameEvent e) {

                    int option = JOptionPane.showConfirmDialog(null, "Really want to Close this screen ?", "Close Screen", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        //call dispose to really close it
                        CurrentFrame = "";
                        CurrentFrameObj=null;
                      jf.dispose();
                    }

                }

                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    CurrentFrame = "";

                }

                @Override
                public void internalFrameIconified(InternalFrameEvent e) {
                }

                @Override
                public void internalFrameDeiconified(InternalFrameEvent e) {
                }

                @Override
                public void internalFrameActivated(InternalFrameEvent e) {
                }

                @Override
                public void internalFrameDeactivated(InternalFrameEvent e) {
                }
            });

            if (CurrentFrame.equals(p.getId())) {
                jf.setSelected(true);

                jf.setFocusable(true);
                jf.moveToFront();
            } else {
                
                boolean canRefresh=false;
                
                if(CurrentFrameObj!=null && !CurrentFrameObj.getType().equals("TRN")){
                    canRefresh=true;
                }
                
                CurrentFrame = p.getId();
                CurrentFrameObj=p;
                
                if(canRefresh){
                 JDesktopF.removeAll();
                 JDesktopF.updateUI();
                }
             

                JDesktopF.add(jf);

                jf.setVisible(true);

                jf.setFocusable(true);
                jf.setSelected(true);
                jf.moveToFront();
            }

        }

    }

    private void RefreshLayOut() {
        String imgpath = GlobalData.CurUser.getImgurl();
        File f = new File(imgpath);
        if (f.exists()) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(f);
                Image dimg = img.getScaledInstance(70, 70,
                        Image.SCALE_SMOOTH);

                lblUserimg.setIcon(new ImageIcon(dimg));
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (GlobalData.CurUser.getId().equals("U0000")) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(getClass().getResource("/SYSIMG/ADMIN.jpg"));
                Image dimg = img.getScaledInstance(70, 70,
                        Image.SCALE_SMOOTH);
                lblUserimg.setIcon(new ImageIcon(dimg)); // NOI18N
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            lblUserimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/1465731972_user-01.png"))); // NOI18N
        }

    }

    private void Logout() {
        int showConfirmDialog = JOptionPane.showConfirmDialog(rootPane, "Do you want to logout from the System", GlobalData.MESSAGEBOX, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (showConfirmDialog == JOptionPane.YES_OPTION) {
            Frm_Login l = new Frm_Login();
            this.dispose();
            l.setVisible(true);
        }

    }

    private void ShowHelp() {

        frm_Help.setVisible(true);
    }

    private void reloadComponents() {
       layout_footer.setBackground(Color.WHITE);
       layout_profile.setBackground(Color.WHITE);
    }

}
