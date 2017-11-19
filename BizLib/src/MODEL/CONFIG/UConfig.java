/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODEL.CONFIG;

import java.io.Serializable;

/**
 *
 * @author HOME
 */
public class UConfig implements Serializable{
    private String Server;
    private String Username;
    private String Password;
    private String Port;
    private String Db;
    
    

    public String getServer() {
        return Server;
    }

    public void setServer(String Server) {
        this.Server = Server;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String Port) {
        this.Port = Port;
    }

    public String getDb() {
       
        return Db;
    }

    public void setDb(String Db) {
        this.Db = Db;
    }
    
    
    
    
}
