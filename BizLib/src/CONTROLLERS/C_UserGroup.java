/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import COMMONFUN.CommonFun;
import DB_ACCESS.DB;
import MODELS.MPermissions;
import MODELS.MUsergroup;
import QUERYBUILDER.QueryGen;
import VALIDATIONS.MyValidator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author HOME
 */
public class C_UserGroup {

    QueryGen qg = null;
    CommonFun CommFun = null;
    VALIDATIONS.MyValidator v = null;

    public C_UserGroup() {
        CommFun = new CommonFun();
        qg = new QueryGen();
        v = new MyValidator();
    }

    ////////////////////////METHODS////////////////////////////////////
    public void saveUserGroup(MUsergroup ug) throws Exception {
        if (ug.getId() == 0) {
            //save
            int id = CommFun.generateNxtIntNo("m_usergroup", "ID", "");

            String q = "INSERT INTO m_usergroup(ID,GROUPNAME,ACTIVE,VISIBLE)VALUES('" + id + "','" + v.replacer(ug.getGroupname()).toUpperCase() + "','" + ug.getActive() + "',1)  ";
            DB.Save(q);

        } else {
            //update
            String q = "UPDATE m_usergroup SET GROUPNAME='" + v.replacer(ug.getGroupname()).toUpperCase() + "',ACTIVE='" + ug.getActive() + "' WHERE ID='" + ug.getId() + "' ";
            DB.Update(q);
        }
    }

    public Vector<MUsergroup> getUserGroups(boolean only_visible, boolean skipown) throws Exception {
        String sql = "SELECT * FROM m_usergroup ";
        if (only_visible) {
            sql += " where VISIBLE=1 ";
        }

        Vector<MUsergroup> v = new Vector<>();
        ResultSet rs = DB.Search(sql);
        while (rs.next()) {

            MUsergroup ug = new MUsergroup();
            ug.setId(rs.getInt("ID"));
            ug.setGroupname(rs.getString("GROUPNAME"));
            ug.setActive(rs.getByte("ACTIVE"));
            ug.setVisible(rs.getByte("VISIBLE"));
            if (skipown && GLOBALDATA.GlobalData.CurUser.getMUsergroup().equals(ug)) {
            } else {
                v.add(ug);
            }
        }

        return v;
    }

    public MUsergroup getUserGroup(String UGId) throws Exception {
        String sql = "SELECT * FROM m_usergroup where ID='" + UGId + "'";
        MUsergroup ug = new MUsergroup();

        ResultSet rs = DB.Search(sql);
        if (rs.next()) {
            ug.setId(rs.getInt("ID"));
            ug.setGroupname(rs.getString("GROUPNAME"));
            ug.setActive(rs.getByte("ACTIVE"));
            ug.setVisible(rs.getByte("VISIBLE"));
        }

        return ug;
    }

    public boolean SearchParentPermission(int ug, MPermissions p) throws Exception {
        boolean state = false;
        if (p.getId().equals(p.getParentid())) {
            state = true;
        } else {
            String q = "SELECT M_PERMISSIONS_ID from user_permitions WHERE M_USERGROUP_ID='" + ug + "' AND M_PERMISSIONS_ID='" + p.getParentid() + "'";
            ResultSet rs = DB.Search(q);
            if (rs.next()) {
                state = true;
            }
        }
        return state;
    }

    public boolean checkUserPermission(int ug, MPermissions p) throws Exception {
        boolean state = false;

        String q = "SELECT M_PERMISSIONS_ID from user_permitions WHERE M_USERGROUP_ID='" + ug + "' AND M_PERMISSIONS_ID='" + p.getId() + "'";
        ResultSet rs = DB.Search(q);
        if (rs.next()) {
            state = true;
        }

        return state;
    }

    public void AddPermissionToGroup(int ug, MPermissions p) throws Exception {
        if (checkUserPermission(ug, p) == false && SearchParentPermission(ug, p)) {
            String sql = "INSERT INTO user_permitions(M_USERGROUP_ID,M_PERMISSIONS_ID,M_PERMISSIONS_PARENTID,ACCESSTYPE) VALUES('" + ug + "','" + p.getId() + "','" + p.getParentid() + "','A')  ";
            DB.Save(sql);
        } else {
            throw new Exception("Please add Parent Permission before adding child");
        }

    }

    public ArrayList<MPermissions> getUserGroupPermitions(int UserGroupId, int ReqPer) throws Exception {
        return getUserGroupPermitions(UserGroupId, ReqPer, "");
    }

    public Map<String, MPermissions> getUserGroupPermitions_Map(int UserGroupId, int ReqPer, String ParentID) throws Exception {
        String sql = "select p.ID AS ID,p.PARENTid AS PARID,p.Name AS NAME,p.DESCRIPTION AS DES,"
                + "p.TYPE AS TYP,p.HASSUB AS HASSUB,p.ISUIMENU AS ISUIMENU,up.ACCESSTYPE AS ACCESST "
                + " from m_permissions p inner join user_permitions up "
                + "on p.ID=up.M_PERMISSIONS_ID "
                + "where up.M_USERGROUP_ID IN (select ID from m_usergroup where ID='" + UserGroupId + "')";

        if (ReqPer == 1) {
            //UI permissions only
            sql += " AND p.ISUIMENU=1";
        } else if (ReqPer == 2) {
            //Permissions which are not menu
            sql += " AND p.ISUIMENU=0";
        }

        if (!ParentID.equals("")) {
            sql += " AND p.PARENTid='" + ParentID + "' ";
        }

        sql += " ORDER BY p.ID ";
        // System.out.println(sql);  
        Map<String, MPermissions> l = new TreeMap<String, MPermissions>();
        ResultSet rs = DB.Search(sql);
        while (rs.next()) {
            MPermissions p = new MPermissions();
            p.setId(rs.getString("ID"));
            p.setParentid(rs.getString("PARID"));
            p.setName(rs.getString("NAME"));
            p.setDescription(rs.getString("DES"));
            p.setType(rs.getString("TYP"));
            p.setHassub(rs.getByte("HASSUB"));
            p.setIsuimenu(rs.getByte("ISUIMENU"));
            p.setAcesst(rs.getString("ACCESST"));
            //l.add(p);
            l.put(rs.getString("ID"), p);
        }

        return l;
    }

    public ArrayList<MPermissions> getUserGroupPermitions(int UserGroupId, int ReqPer, String ParentID) throws Exception {
        String sql = "select p.ID AS ID,p.PARENTid AS PARID,p.Name AS NAME,p.DESCRIPTION AS DES,"
                + "p.TYPE AS TYP,p.HASSUB AS HASSUB,p.ISUIMENU AS ISUIMENU,up.ACCESSTYPE AS ACCESST "
                + " from m_permissions p inner join user_permitions up "
                + "on p.ID=up.M_PERMISSIONS_ID "
                + "where up.M_USERGROUP_ID IN (select ID from m_usergroup where ID='" + UserGroupId + "')";

        if (ReqPer == 1) {
            //UI permissions only
            sql += " AND p.ISUIMENU=1";
        } else if (ReqPer == 2) {
            //Permissions which are not menu
            sql += " AND p.ISUIMENU=0";
        }

        if (!ParentID.equals("")) {
            sql += " AND p.PARENTid='" + ParentID + "' ";
        }

        sql += " ORDER BY p.ID ";
       // System.out.println(sql);
        ArrayList<MPermissions> l = new ArrayList<>();
        ResultSet rs = DB.Search(sql);
        while (rs.next()) {
            MPermissions p = new MPermissions();
            p.setId(rs.getString("ID"));
            p.setParentid(rs.getString("PARID"));
            p.setName(rs.getString("NAME"));
            p.setDescription(rs.getString("DES"));
            p.setType(rs.getString("TYP"));
            p.setHassub(rs.getByte("HASSUB"));
            p.setIsuimenu(rs.getByte("ISUIMENU"));
            p.setAcesst(rs.getString("ACCESST"));
            l.add(p);
        }

        return l;
    }

    public ArrayList<MPermissions> getUserGroupPermitions(String ParentID) throws Exception {
        String sql = "select p.ID AS ID,p.PARENTid AS PARID,p.Name AS NAME,p.DESCRIPTION AS DES,"
                + "p.TYPE AS TYP,p.HASSUB AS HASSUB,p.ISUIMENU AS ISUIMENU,up.ACCESSTYPE AS ACCESST "
                + " from m_permissions p inner join user_permitions up "
                + "on p.ID=up.M_PERMISSIONS_ID ";

        if (!ParentID.equals("")) {
            sql += " WHERE  p.PARENTid='" + ParentID + "' ";
        }
        sql += " ORDER BY p.ID ";
        ArrayList<MPermissions> l = new ArrayList<>();
        ResultSet rs = DB.Search(sql);
        while (rs.next()) {
            MPermissions p = new MPermissions();
            p.setId(rs.getString("ID"));
            p.setParentid(rs.getString("PARID"));
            p.setName(rs.getString("NAME"));
            p.setDescription(rs.getString("DES"));
            p.setType(rs.getString("TYP"));
            p.setHassub(rs.getByte("HASSUB"));
            p.setIsuimenu(rs.getByte("ISUIMENU"));
            p.setAcesst(rs.getString("ACCESST"));
            l.add(p);
        }

        return l;
    }
}
