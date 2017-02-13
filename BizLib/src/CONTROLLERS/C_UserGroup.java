/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import DB_Access.DB;
import MODELS.MPermissions;
import MODELS.MUsergroup;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author HOME
 */
public class C_UserGroup {

    ////////////////////////METHODS////////////////////////////////////
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

    public ArrayList<MPermissions> getUserGroupPermitions(int UserGroupId, int ReqPer) throws Exception {
        return getUserGroupPermitions(UserGroupId, ReqPer, "");
    }

    public Map<String, String> getUserGroupPermitions_Map(int UserGroupId, int ReqPer, String ParentID) throws Exception {
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
        Map<String, String> l = new TreeMap<String, String>();
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
            l.put(rs.getString("ID"), rs.getString("ACCESST"));
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
        System.out.println(sql);
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
