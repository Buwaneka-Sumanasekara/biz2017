/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TEST;

import DB_Access.DB;
import java.sql.ResultSet;

/**
 *
 * @author Buwanaka
 */
public class Test2 {
    public static void main(String[] args) {
        String q="SELECT TABLE_NAME, COLUMN_NAME, COLUMNPROPERTY(OBJECT_ID(TABLE_SCHEMA + '.' + TABLE_NAME), COLUMN_NAME, 'ColumnID') AS COLUMN_ID  \n" +
"FROM INFORMATION_SCHEMA.COLUMNS ";
        try {
            ResultSet rs = DB.Search(q);
            while (rs.next()) {                
                System.out.println(rs.getString("TABLE_NAME"));
            }
        } catch (Exception ex) {
           // Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
