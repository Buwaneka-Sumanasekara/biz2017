/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package COMMONFUN;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Buwanaka
 */
 public class MyTableModel extends DefaultTableModel {

   


     
     
    List<Color> rowColours = Arrays.asList(
        Color.RED,
        Color.GREEN,
        Color.CYAN
    );

    public void setRowColour(int row, Color c) {
        rowColours.set(row, c);
        fireTableRowsUpdated(row, row);
    }

    public Color getRowColour(int row) {
        return rowColours.get(row);
    }

    @Override
    public int getRowCount() {
        return 12;
    }

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public void setColumnIdentifiers(Object[] newIdentifiers) {
        Object [] col={"Code","description","cost","sell","qty","unitsym","unit","dis%","Dis Amt","Amount","Batch","ColourId"};
        super.setColumnIdentifiers(col); //To change body of generated methods, choose Tools | Templates.
    }

  
    @Override
    public void setRowCount(int rowCount) {
        super.setRowCount(0); //To change body of generated methods, choose Tools | Templates.
    }

    

    
  
}
