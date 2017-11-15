/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TABLE_STRUCT;

import DB_ACCESS.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Buwanaka
 */
public class TableStruCreation {

    public static final String STR_FUN="STR_FUN";
    public static final String STR_PROC="STR_PROC";
    
    
    
    private boolean IsTableExists(String TableName) {
        boolean state = false;
        try {
            String q = "SELECT * FROM INFORMATION_SCHEMA.TABLES ";
            q += " WHERE table_schema='BIZDB' AND TABLE_NAME='" + TableName + "' ";
          //  System.out.println(q);
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
            q += " WHERE table_schema='BIZDB' AND TABLE_NAME='" + TableName + "' AND COLUMN_NAME='" + ColumnName + "' ";
          //  System.out.println(q);
            ResultSet rs = DB.Search(q);
            if (rs.next()) {
                state = true;
            }
        } catch (Exception e) {
            System.err.println("CHECK EXISTS " + TableName + " [" + ColumnName + "] :" + e.getMessage());
        }

        return state;
    }

    public void executeSql(String sql) {
        if (!sql.equals("")) {
            try {
                DB.Save(sql);
            } catch (Exception ex) {
                System.err.println("TABLE STRUCTURE CREATTION ERROR:" + ex.getMessage());
            }
        }
    }

    public void createTable(String TableName, ArrayList<TblColumn> Columns) throws Exception {
        createTable(TableName, Columns, null);
    }

    public void createTable(String TableName, ArrayList<TblColumn> Columns, ArrayList<String> PrimaryKeys) throws Exception {

        if (IsTableExists(TableName)) {
            for (TblColumn tableColumn : Columns) {
                if (IsColumnExists(TableName, tableColumn.getColumnName()) == false) {
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
            if (Columns.size() > 0) {
                try {
                    String q = "CREATE TABLE " + TableName + "(";
                    int i = 0;
                    for (TblColumn tableColumn : Columns) {

                        if (i > 0) {
                            q += ",";
                        }
                        q += " " + tableColumn.getColumnName() + " " + tableColumn.getDataType() + " " + tableColumn.getDefaultValue() + " " + ((tableColumn.getPrimaryKey() != null && tableColumn.getPrimaryKey().equals("") == false) ? tableColumn.getPrimaryKey() : "") + " ";
                        i++;
                    }

                    if (PrimaryKeys != null) {
                        if (PrimaryKeys.size() > 0) {
                           // q += " ,CONSTRAINT pk_" + TableName + " PRIMARY KEY (";
                            q+=" ,PRIMARY KEY (";
                            int j = 0;
                            for (String col : PrimaryKeys) {

                                if (j > 0) {
                                    q += ",";
                                }

                                q+=col;
                                
                                j++;
                            }
                            q += ")";
                        }
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
    
    
    public void createStoredFunction(String strd_F_Name,String parameters,ArrayList<String> lines,String ReturnType) throws Exception{
        String q0="DROP FUNCTION IF EXISTS "+strd_F_Name+" ";
         DB.Save(q0);
        
        String q="";
        q+=" CREATE FUNCTION "+strd_F_Name+" ("+parameters+") ";
        q+=" RETURNS "+ReturnType+" ";
        q+=" BEGIN ";
        for (String q_line : lines) {
            q+=" "+q_line+" ;";
        }
        q+=" END ";
        
        DB.Save(q);
    }
    
     public void createStoredProcedure(String strd_P_Name,String parameters,ArrayList<String> lines) throws Exception{
        String q0="DROP PROCEDURE IF EXISTS "+strd_P_Name+" ";
         DB.Save(q0);
        
        String q="";
        q+=" CREATE PROCEDURE "+strd_P_Name+" ("+parameters+") ";
    
        q+=" BEGIN ";
        for (String q_line : lines) {
            q+=" "+q_line+" ;";
        }
        q+=" END ";
        
        DB.Save(q);
    }
    
}
