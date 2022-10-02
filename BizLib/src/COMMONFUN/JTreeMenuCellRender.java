/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMMONFUN;

import MODELS.MGroupCommon;
import MODELS.MPermissions;
import java.awt.Color;
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
            label.setText("");
            label.setBackground(Color.WHITE);
             label.setForeground(Color.DARK_GRAY);
             label.setFont(label.getFont().deriveFont(14f));
        } else if (o instanceof MPermissions) {

            MPermissions p = (MPermissions) o;
            if (p != null) {
               // System.out.println(p.getIcon());
                if (p.getIcon().length() > 0) {
                    label.setIcon(new ImageIcon(getClass().getResource("/SYSIMG/TreeIcons/"+p.getIcon())));
                } else {
                    label.setIcon(permIcon);
                }
                label.setText(p.getDescription());
            }

            if(selected){
                label.setForeground(Color.RED);
                label.setBackground(Color.LIGHT_GRAY);
            }else{
                label.setForeground(Color.DARK_GRAY);
                label.setBackground(Color.WHITE);
            }
            
        }else if(o instanceof MGroupCommon){
            MGroupCommon g=(MGroupCommon) o;
            
            if (g != null) {
               // System.out.println(p.getIcon());
                if (leaf) {
                    label.setIcon(new ImageIcon(getClass().getResource("/SYSIMG/TreeIcons/file.png")));
                } else {
                      label.setIcon(new ImageIcon(getClass().getResource("/SYSIMG/TreeIcons/folder.png")));
                }
                label.setText(g.getName());
            }
            
        }

        
        
        
        return label;
    }

}
