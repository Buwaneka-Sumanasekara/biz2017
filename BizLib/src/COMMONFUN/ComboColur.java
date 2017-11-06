/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMMONFUN;

import MODELS.MUsergroup;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author user pc
 */
public class ComboColur implements ListCellRenderer<Object> {

    JLabel text;

    public ComboColur() {

        text = new JLabel();
        text.setOpaque(true);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        try {
            if (value instanceof MUsergroup) {
                if (isSelected ) {
                    text.setBackground(list.getSelectionBackground());
                }else{
                     text.setBackground(list.getBackground());
                }
                
                

                MUsergroup ug = (MUsergroup) value;
                text.setText(ug.getGroupname());
                if (ug.getActive() == 0) {
                    text.setBackground(Color.RED);
                    text.setForeground(Color.WHITE);
                } else {
                    text.setBackground(Color.WHITE);
                    text.setForeground(Color.BLACK);
                }
                
                if (cellHasFocus) {
                    text.setBackground(list.getSelectionBackground());
                }
                
                
                
            }
        } catch (Exception e) {
        }
        return text;
    }

}
