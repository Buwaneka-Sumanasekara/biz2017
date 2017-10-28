/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMMONFUN;

import java.awt.Color;
import java.awt.Component;

/**
 *
 * @author Buwanaka
 */
public class TblCellColour extends javax.swing.table.DefaultTableCellRenderer {
int ColourRow=-1;
    int colurType=0;

    //0=default, 1=yellow
  
    
    
    
@Override
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, java.lang.Object value, boolean isSelected, boolean hasFocus, int row, int column) {
     
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
          int status = (int)table.getModel().getValueAt(row, 11);
        if(status>0){
        c.setBackground(Color.YELLOW);
        }else{
            c.setBackground(Color.WHITE);
        }
          int gv = (int)table.getModel().getValueAt(row, 12);
        if(gv==1){
            c.setBackground(Color.GREEN);
              c.setForeground(Color.BLACK); 
        }else{
            if(isSelected){
              c.setBackground(Color.LIGHT_GRAY);
              c.setForeground(Color.BLACK);
            }else{
              c.setBackground(Color.WHITE);
              c.setForeground(Color.BLACK);
                
            }
        }
        
        return c;

    }


}
