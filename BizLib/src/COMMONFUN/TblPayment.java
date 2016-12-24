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
public class TblPayment extends javax.swing.table.DefaultTableCellRenderer{
    
    
    @Override
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, java.lang.Object value, boolean isSelected, boolean hasFocus, int row, int column) {
     
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
         
     //   if(row%2==0){
     //   c.setBackground(Color.WHITE);
      //  }else{
            c.setBackground(new Color(153,153,153));
            c.setForeground(Color.WHITE);
            
     //   }
        return c;

    }
}
