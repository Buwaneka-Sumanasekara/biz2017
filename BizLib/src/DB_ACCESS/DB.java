/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Access;

import GLOBALDATA.GlobalData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author BUWANEKA
 */
public class DB {

    private static Connection con;
      private static Connection con_infoDB;
    
  //mySQL
   /* private static void getConnection() throws SQLException, ClassNotFoundException {         
     String localServer = "127.0.0.1";
     String localDB ="biz";
     String port="3309";
     String user="root";
     String pass="123";
            
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://" + localServer + ":"+port+"/" + localDB,user, pass);
     }*/

    //SQL Server
    private static void getConnection() throws Exception {
        String localServer =GlobalData.Settings.get("LOCALSERVER").toString();
        
        if(localServer!=null && localServer.equals("")){
            throw new Exception("Setting \"LOCALSERVER\" is not available in settings file");
        }
                
                
        String localDB = "BIZDB";
        String user = "biz";
        String pass = "bizadmin";

        String url = "";

        if (localServer.indexOf("/") != -1) {
            String[] split = localServer.split("/");
            url = "jdbc:sqlserver://" + split[0] + ";instanceName=" + split[1] + ";databaseName=" + localDB;
        } else {

            url = "jdbc:sqlserver://" + localServer + ";databaseName=" + localDB;

        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, user, pass);

    }
private static void getConnectionInfoDB() throws Exception {
        String localServer =GlobalData.Settings.get("LOCALSERVER").toString();
        
        if(localServer!=null && localServer.equals("")){
            throw new Exception("Setting \"LOCALSERVER\" is not available in settings file");
        }
                
                
        String localDB = "INFORMATION_SCHEMA";
        String user = "biz";
        String pass = "bizadmin";

        String url = "";

        if (localServer.indexOf("/") != -1) {
            String[] split = localServer.split("/");
            url = "jdbc:sqlserver://" + split[0] + ";instanceName=" + split[1] + ";databaseName=" + localDB;
        } else {

            url = "jdbc:sqlserver://" + localServer + ";databaseName=" + localDB;

        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con_infoDB = DriverManager.getConnection(url, user, pass);

    }

    
    public static Connection getCurrentCon() throws Exception {
        if (con == null) {
            getConnection();
        }
        return con;
    }

    public static ResultSet Search(String query) throws Exception {

        if (con == null || con.isClosed()) {
            getConnection();
        }
        return con.createStatement().executeQuery(query);
    }
 public static ResultSet SearchInfoDB(String query) throws Exception {

        if (con_infoDB == null || con_infoDB.isClosed()) {
            getConnectionInfoDB();
        }
        return con_infoDB.createStatement().executeQuery(query);
    }
    public static int Save(String query) throws Exception {

        if (con == null || con.isClosed()) {
            getConnection();
        }
        System.out.println(query);
        return con.createStatement().executeUpdate(query);

    }
     public static int Save(String query,Connection c) throws Exception {

        
        return c.createStatement().executeUpdate(query);

    }

    public static int Update(String query) throws Exception {

        if (con == null || con.isClosed()) {
            getConnection();
        }
        System.out.println(query);
        return con.createStatement().executeUpdate(query);

    }

    public static int Delete(String query) throws Exception {

        if (con == null || con.isClosed()) {
            getConnection();
        }
        System.out.println(query);
        return con.createStatement().executeUpdate(query);

    }
    
    public static int Delete(String query,Connection c) throws Exception {

        
        return c.createStatement().executeUpdate(query);

    }
}
