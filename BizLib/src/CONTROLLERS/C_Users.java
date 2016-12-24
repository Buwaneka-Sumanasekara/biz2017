/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CONTROLLERS;

import DB_Access.DB;
import MODELS.MUser;
import MODELS.MUsersecurity;
import SECURITY.myEncript;
import java.sql.ResultSet;

/**
 *
 * @author HOME
 */
public class C_Users {
    ///////////////Methods/////////////////////////////
    public MUser getUser(String UID) throws Exception {
        String sql = "SELECT * FROM m_user where ID='" + UID + "'";
        MUser user = null;

        ResultSet rs = DB.Search(sql);
        if (rs.next()) {
            user = new MUser();
            user.setId(rs.getString("ID"));
            user.setActive(rs.getByte("ACTIVE"));
            user.setFirstname(rs.getString("FIRSTNAME"));
            user.setImgurl(rs.getString("IMGURL"));
            user.setLastname(rs.getString("LASTNAME"));
            user.setMLocation(new C_Locations().getLocation(rs.getString("LOCID")));
            user.setMUsergroup(new C_UserGroup().getUserGroup(rs.getString("UGRUID")));
        }

        return user;
    }

    public MUser CheckUserLogin(String uname, String Pass) throws Exception {
        String sql = "SELECT UID FROM m_usersecurity where USERNAME='" + uname + "' AND PASSWORD='" + myEncript.encript(Pass.replace("'", "")) + "'";
        MUser user = null;

        ResultSet rs = DB.Search(sql);
        if (rs.next()) {
            user = getUser(rs.getString("UID"));
        }
        return user;
    }

    public void createUser(MUser user,MUsersecurity userSec){
        
    }
    
}
