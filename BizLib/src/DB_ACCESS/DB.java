/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_ACCESS;


import GLOBALDATA.GlobalData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Buwaneka
 */
public class DB {

    private static Connection con;//data type is conection variable static variavle
  
    
    public static void setConnectionNull(){
      con=null;  
    }
    
    private static void getConnection() throws SQLException, ClassNotFoundException {         
            String localServer = GlobalData.config.getServer();//this is my localip address
            String localDB ="bizdb";// name of the db
            String port=GlobalData.config.getPort();
            String user=GlobalData.config.getUsername();
            String pass=GlobalData.config.getPassword();
            
         //   System.out.println(GlobalData.config.getPort());
            Class.forName("com.mysql.jdbc.Driver");//loading the class to conect with db
            con = DriverManager.getConnection("jdbc:mysql://" + localServer + ":"+port+"/" + localDB,user, pass);//this is a static methord
    }

   public static Connection getCurrentCon() throws Exception{
       if(con==null){
           getConnection();
       }
       return con;
   }

    public static ResultSet Search(String query) throws SQLException, ClassNotFoundException {
  
            if (con == null || con.isClosed()) {
                getConnection();
            }
            return con.createStatement().executeQuery(query);
    }

    public static int Save(String query) throws SQLException, ClassNotFoundException {
     
            if (con == null || con.isClosed()) {
                getConnection();
            }
           System.out.println(query);
            return con.createStatement().executeUpdate(query);
       
    }

    public static int Update(String query) throws SQLException, ClassNotFoundException {
     
            if (con == null || con.isClosed()) {
                getConnection();
            }
           // System.out.println(query);
            return con.createStatement().executeUpdate(query);
           
     
    }

    public static int Delete(String query) throws SQLException, ClassNotFoundException {
      
            if (con == null || con.isClosed()) {
                getConnection();
            }
            //System.out.println(query);
            return con.createStatement().executeUpdate(query);
   
    }
}
