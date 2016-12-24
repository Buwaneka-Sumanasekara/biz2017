/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TABLE_STRUCT;

import DB_Access.DB;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Buwanaka
 */
public class TableStruCreation {

    private boolean IsTableExists(String TableName) {
        boolean state = false;
        try {
            String q = "SELECT TABLE_CATALOG,TABLE_NAME FROM INFORMATION_SCHEMA.TABLES ";
            q += " WHERE TABLE_CATALOG='BIZDB' AND TABLE_NAME='" + TableName + "' ";
           // System.out.println(q);
            ResultSet rs = DB.Search(q);
            if (rs.next()) {
                state = true;
            }
        } catch (Exception e) {
            System.err.println("CHECK EXISTS " + TableName + " :" + e.getMessage());
        }

        return state;
    }

    private boolean IsColumnExists(String TableName, String ColumnName) {
        boolean state = false;
        try {
            String q = "SELECT TABLE_CATALOG,TABLE_NAME,COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS ";
            q += " WHERE TABLE_CATALOG='BIZDB' AND TABLE_NAME='" + TableName + "' AND COLUMN_NAME='" + ColumnName + "' ";
            ResultSet rs = DB.Search(q);
            if (rs.next()) {
                state = true;
            }
        } catch (Exception e) {
            System.err.println("CHECK EXISTS " + TableName + " [" + ColumnName + "] :" + e.getMessage());
        }

        return state;
    }

   public void executeSql(String sql){
       if(!sql.equals("")){
           try {
               DB.Save(sql);
           } catch (Exception ex) {
               System.err.println("TABLE STRUCTURE CREATTION ERROR:"+ex.getMessage());
           }
       }
   } 
    
   public void createTable(String TableName, ArrayList<TblColumn> Columns) throws Exception{
       
       
        if (IsTableExists(TableName)) {
            for (TblColumn tableColumn : Columns) {
                if (IsColumnExists(TableName, tableColumn.getColumnName())==false) {
                    try {
                        String q = "ALTER TABLE " + TableName + " ";
                        q += " ADD " + tableColumn.getColumnName() + " " + tableColumn.getDataType() + " " + tableColumn.getDefaultValue() + " ";
                        
                        DB.Save(q);
                    } catch (Exception e) {
                        throw new Exception("ADD COLUMN " + TableName + " [" + tableColumn.getColumnName() + "] :" + e.getMessage());
                         
                    }

                }
            }

        } else {
            if (Columns.size() > 0 ) {
                try {
                    String q = "CREATE TABLE " + TableName + "(";
                    int i = 0;
                    for (TblColumn tableColumn : Columns) {
                        
                        if (i > 0) {
                            q += ",";
                        }
                        q += " " + tableColumn.getColumnName() + " " + tableColumn.getDataType() + " " + tableColumn.getDefaultValue() + " ";

                    }

                    q += " )";
                    System.out.println(q);
                    DB.Save(q);
                } catch (Exception e) {
                     throw new Exception("NEW TABLE CREATION " + TableName + " :" + e.getMessage());
                       
                   
                }

            }
        }
    }
}

