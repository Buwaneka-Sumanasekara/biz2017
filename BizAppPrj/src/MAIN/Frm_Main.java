/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import GLOBALDATA.GlobalData;
import LOGIN.Frm_Login;
import MODELS.MPermissions;
import MODELS.MUsergroup;
import WINMNG.MyWindowManager;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author HOME
 */
public class Frm_Main extends javax.swing.JFrame {

    public String CurrentFrame = "";

    Frm_Login frmlog = null;
    MUsergroup ug = null;
    ArrayList<MPermissions> menus = null;
    MyWindowManager myw = null;

    public Frm_Main() {
        initComponents();
        this.setUndecorated(true);
    }

    public Frm_Main(Frm_Login frmlogin, ArrayList<MPermissions> m) {
        initComponents();
        this.frmlog = frmlogin;
        this.menus = m;
        this.ug = new MUsergroup();
        this.myw = new MyWindowManager();
        this.lblUsername.setText(GlobalData.CurUser.getFirstname());
        this.lblCompanyName.setText(GlobalData.Setup.getComname());
        RefreshLayOut();
        createUserMenu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TUserMenu = new javax.swing.JTree();
        lblUserimg = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblCompanyName = new javax.swing.JLabel();
        JDesktopF = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_Global_Instructions = new javax.swing.JLabel();
        butLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 550));

        lblUserimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/1465731972_user-01.png"))); // NOI18N
        getContentPane().add(lblUserimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 70, 70));

        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("BUWANEKA");
        getContentPane().add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 150, 30));

        lblCompanyName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCompanyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompanyName.setText("COMPANY NAME");
        getContentPane().add(lblCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 760, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/iconappimg.png"))); // NOI18N
        JDesktopF.add(jLabel3);
        jLabel3.setBounds(380, 190, 150, 110);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(110, 147, 169));
        jLabel5.setText("Biz");
        JDesktopF.add(jLabel5);
        jLabel5.setBounds(410, 280, 90, 58);

        getContentPane().add(JDesktopF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 870, 640));

        lbl_Global_Instructions.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbl_Global_Instructions.setForeground(new java.awt.Color(204, 0, 0));
        lbl_Global_Instructions.setText("[  F2 : SEARCH   ]   [   F3: EDIT  ]  [  F4: REFRESH  ]   [  F5: SAVE  ]  [F6: HOLD]  [F7: CANCEL]");
        getContentPane().add(lbl_Global_Instructions, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 670, 750, -1));

        butLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/if_exit_7989 (2).png"))); // NOI18N
        butLogout.setBorderPainted(false);
        butLogout.setContentAreaFilled(false);
        butLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(butLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 0, 60, 30));

        setSize(new java.awt.Dimension(1024, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void TUserMenuValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_TUserMenuValueChanged

    }//GEN-LAST:event_TUserMenuValueChanged

    private void butLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLogoutActionPerformed
        Logout();
    }//GEN-LAST:event_butLogoutActionPerformed

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblUserimg;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lbl_Global_Instructions;
    // End of variables declaration//GEN-END:variables

    private void createUserMenu() {
        Map<String, DefaultMutableTreeNode> NodesMap = new TreeMap<String, DefaultMutableTreeNode>();
        try {

            //create the root node
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Home");

            TUserMenu.setCellRenderer(new DefaultTreeCellRenderer() {
                private Icon loadIcon = UIManager.getIcon("OptionPane.errorIcon");
                private Icon homeIcon = new ImageIcon(getClass().getResource("/SYSIMG/TreeIcons/home.png"));
                private Icon saveIcon = UIManager.getIcon("OptionPane.informationIcon");

                //private Icon loadIcon = new ImageIcon(getClass().getResource("/SYSIMG/iconappimg.png"));
                //private Icon saveIcon = new ImageIcon(getClass().getResource("/SYSIMG/iconappimg.png"));
                @Override
                public Component getTreeCellRendererComponent(JTree tree,
                        Object value, boolean selected, boolean expanded,
                        boolean isLeaf, int row, boolean focused) {
                    Component c = super.getTreeCellRendererComponent(tree, value,
                            selected, expanded, isLeaf, row, focused);

                    if (selected) {
                        if (value.toString().equals("Home")) {
                            setIcon(homeIcon);
                        }
                    } else if (value.toString().equals("Home")) {
                        setIcon(homeIcon);
                    }

                    return c;

                }
            });

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

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private void openWindow(MPermissions p) throws Exception {

        JInternalFrame jf = myw.getRequestWindow(p, this);
        if (jf != null) {
            jf.setFocusCycleRoot(true);
            jf.addInternalFrameListener(new InternalFrameListener() {

                @Override
                public void internalFrameOpened(InternalFrameEvent e) {
                }

                @Override
                public void internalFrameClosing(InternalFrameEvent e) {
                    CurrentFrame = "";
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
                CurrentFrame = p.getId();
                JDesktopF.removeAll();
                JDesktopF.updateUI();

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

}
