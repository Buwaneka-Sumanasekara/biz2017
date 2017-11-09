/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import COMMONFUN.CommonFun;
import DB_ACCESS.DB;
import MODELS.MUser;
import MODELS.MUsersecurity;
import SECURITY.myEncript;
import VALIDATIONS.MyValidator;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HOME
 */
public class C_Users {

    COMMONFUN.CommonFun cf = null;
    VALIDATIONS.MyValidator v = null;

    public C_Users() {
        cf = new CommonFun();
        v = new MyValidator();
    }

    ///////////////Methods/////////////////////////////
    public MUser getUser(String UID) throws Exception {
        String sql = "SELECT u.ID AS UID,u.ACTIVE AS UACTIVE,u.FIRSTNAME,u.IMGURL,u.LASTNAME,u.UGRUID,us.USERNAME FROM m_user u inner join m_usersecurity us on u.ID=us.UID where u.ID='" + UID + "'";
        MUser user = null;

        ResultSet rs = DB.Search(sql);
        if (rs.next()) {
            user = new MUser();
            user.setId(rs.getString("UID"));
            user.setActive(rs.getByte("UACTIVE"));
            user.setFirstname(rs.getString("FIRSTNAME"));
            user.setImgurl(rs.getString("IMGURL"));
            user.setLastname(rs.getString("LASTNAME"));
            //  user.setMLocation(new C_Locations().getLocation(rs.getString("LOCID")));
            user.setMUsergroup(new C_UserGroup().getUserGroup(rs.getString("UGRUID")));
            user.setUsername(rs.getString("USERNAME"));

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

    public boolean CheckUserName(String uname) throws Exception {
        String sql = "SELECT UID FROM m_usersecurity where USERNAME='" + uname + "' ";
        boolean state = false;

        ResultSet rs = DB.Search(sql);
        if (rs.next()) {
            state = true;
        }
        return state;
    }

    public void ResetPassword(String uname) throws Exception {
        String q = " UPDATE  m_usersecurity  SET PASSWORD='" + myEncript.encript(uname.replace("'", "")) + "' where USERNAME='" + uname + "'    ";
        DB.Update(q);

    }

    public String saveUser(MUser u, MUsersecurity userSec) throws Exception {
        String userid = "";

        if (u.getId().length() == 0) {
            //save
            if (CheckUserName(userSec.getUsername())) {
                throw new Exception("Username isalready Avaialble,Please try with another username");
            } else if (userSec == null) {
                throw new Exception("Need username");
            } else {
                String uid = cf.generateNextNo(5, "U", "m_user", "ID");
                String imgurl = "";
                if (u.getImgurl().length() > 0) {
                    imgurl = "MyData/Users/USER_" + uid + u.getImgurl();
                }

                String q = "INSERT INTO m_user(ID,FIRSTNAME,LASTNAME,UGRUID,IMGURL,ACTIVE,VISIBLE)";
                q += "VALUES('" + uid + "','" + v.replacer(u.getFirstname()) + "','" + v.replacer(u.getLastname()) + "','" + u.getMUsergroup().getId() + "','" + imgurl + "','" + u.getActive() + "',1) ";
                DB.Save(q);

                int id = cf.generateNxtIntNo("m_usersecurity", "ID", "");
                String q2 = "INSERT INTO m_usersecurity(ID,USERNAME,PASSWORD,UID) ";
                q2 += " VALUES('" + id + "','" + v.replacer(userSec.getUsername()) + "','" + myEncript.encript(userSec.getPassword()) + "','" + uid + "')";
                DB.Save(q2);

                userid = uid;

            }

        } else {
            //update
            String q = "UPDATE m_user SET UGRUID='"+u.getMUsergroup().getId()+"',FIRSTNAME='" + v.replacer(u.getFirstname()) + "',LASTNAME='" + v.replacer(u.getLastname()) + "',IMGURL='" + u.getImgurl() + "',ACTIVE='" + u.getActive() + "' ";
            q += " WHERE ID='" + u.getId() + "' ";
            DB.Update(q);
            userid = u.getId();
        }

        return userid;
    }

    public void updatePassword(MUsersecurity us, String curpass) throws Exception {
        if (us != null) {
            MUser u = CheckUserLogin(us.getUsername(), curpass);
            if (u != null) {
                String q = " UPDATE  m_usersecurity  SET PASSWORD='" + myEncript.encript(us.getPassword().replace("'", "")) + "' where USERNAME='" + us.getUsername() + "'    ";
                DB.Update(q);

            } else {
                throw new Exception("Current password is invalid!");
            }
        } else {
            throw new Exception("Invalid security details");
        }
    }

}
