/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMMONFUN;

import MODELS.MPermissions;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author user pc
 */
public class JTreeMenuCellRender implements TreeCellRenderer {

    private Icon homeIcon = null;
    private Icon permIcon = null;
    private JLabel label=null;

    public JTreeMenuCellRender() {
        label = new JLabel();
        homeIcon = new ImageIcon(getClass().getResource("/SYSIMG/TreeIcons/home.png"));
        permIcon = new ImageIcon(getClass().getResource("/SYSIMG/TreeIcons/permission_reg.png"));
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        Object o = ((DefaultMutableTreeNode) value).getUserObject();

        if (o.toString().equals("")) {
            label.setIcon(homeIcon);
        } else if (o instanceof MPermissions) {

            MPermissions p = (MPermissions) o;
            if (p != null) {
                if (p.getIcon().length() > 0) {
                    label.setIcon(homeIcon);
                } else {
                    label.setIcon(permIcon);
                }
                label.setText(p.getName());
            }

        }

        return label;
    }

}
