/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import DB_ACCESS.DB;
import MODELS.MPermissions;
import QUERYBUILDER.QueryGen;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Buwanaka
 */
public class C_Permissions {

    QueryGen qg = null;

    public C_Permissions() {
        qg = new QueryGen();
    }

    public void saveBullkPermissions(ArrayList<MPermissions> ar) {
        for (MPermissions mPermissions : ar) {
            try {
                addPermission(mPermissions);
            } catch (Exception ex) {
                // System.err.println(ex.getMessage());
                //  Logger.getLogger(C_Permissions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addPermission(MPermissions m) throws Exception {
        Map<String, String> map = new TreeMap<>();

        map.put("ISUIMENU", m.getIsuimenu().toString());
        map.put("ORD", "" + m.getOrd());

        if (IsPermissionExists(m.getId(), m.getParentid()) == false) {
            map.put("ID", "'" + m.getId() + "'");
            map.put("PARENTID", "'" + m.getParentid() + "'");
            map.put("NAME", "'" + m.getName() + "'");
            map.put("DESCRIPTION", "'" + m.getDescription() + "'");
            map.put("TYPE", "'" + m.getType() + "'");
            map.put("HASSUB", m.getHassub().toString());

            DB.Save(qg.SaveRecord("M_PERMISSIONS", map));
        } else {
            if (SkipList(m) == false) {

                map.put("NAME", "'" + m.getName() + "'");
                map.put("DESCRIPTION", "'" + m.getDescription() + "'");
            }
            DB.Update(qg.UpdateRecord("M_PERMISSIONS", map, " WHERE ID='" + m.getId() + "' "));
        }
    }

    public ArrayList<MPermissions> getAllPermissions() throws Exception {
        String q = "SELECT * FROM M_PERMISSIONS ";

        ResultSet rs = DB.Search(q);
        ArrayList<MPermissions> ar = new ArrayList<>();
        while (rs.next()) {
            MPermissions p = new MPermissions();
            p.setId(rs.getString("ID"));
            p.setParentid(rs.getString("PARENTID"));
            p.setDescription(rs.getString("DESCRIPTION"));
            p.setName(rs.getString("NAME"));
            p.setType(rs.getString("TYPE"));
            p.setHassub(rs.getByte("HASSUB"));
            p.setIsuimenu(rs.getByte("ISUIMENU"));
            p.setOrd(rs.getInt("ORD"));
            ar.add(p);
        }
        return ar;
    }
    public MPermissions getPermission(String perid) throws Exception {
        String q = "SELECT * FROM M_PERMISSIONS where ID='"+perid+"' ";

        ResultSet rs = DB.Search(q);
        MPermissions p=null;
        if(rs.next()) {
            p = new MPermissions();
            p.setId(rs.getString("ID"));
            p.setParentid(rs.getString("PARENTID"));
            p.setDescription(rs.getString("DESCRIPTION"));
            p.setName(rs.getString("NAME"));
            p.setType(rs.getString("TYPE"));
            p.setHassub(rs.getByte("HASSUB"));
            p.setIsuimenu(rs.getByte("ISUIMENU"));
            p.setOrd(rs.getInt("ORD"));
           
        }
        return p;
    }

    public boolean IsPermissionExists(String SubId, String ParentId) throws Exception {
        boolean state = false;
        String q = "SELECT * FROM M_PERMISSIONS ";
        q += " WHERE ID='" + SubId + "' AND PARENTID='" + ParentId + "' ";
        ResultSet rs = DB.Search(q);
        if (rs.next()) {
            state = true;
        }
        return state;
    }

    public boolean IsExistsGroupPermissions(int GroupId, String SubPer, String ParentPer) throws Exception {
        boolean state = false;
        String q = "SELECT * FROM USER_PERMITIONS ";
        q += " WHERE M_USERGROUP_ID=" + GroupId + " AND M_PERMISSIONS_ID='" + SubPer + "' AND M_PERMISSIONS_PARENTID='" + ParentPer + "' ";

        ResultSet rs = DB.Search(q);
        if (rs.next()) {
            state = true;
        }
        return state;
    }

    public void saveGroupPermissions(int GroupId, String SubPer, String ParentPer, String AcessTyp) throws Exception {
        if (IsExistsGroupPermissions(GroupId, SubPer, ParentPer) == false) {
            Map<String, String> map = new TreeMap<>();
            map.put("M_USERGROUP_ID", "" + GroupId);
            map.put("M_PERMISSIONS_ID", "'" + SubPer + "'");
            map.put("M_PERMISSIONS_PARENTID", "'" + ParentPer + "'");
            map.put("ACCESSTYPE", "'" + AcessTyp + "'");

            DB.Save(qg.SaveRecord("USER_PERMITIONS", map));
        }
    }

    private boolean SkipList(MPermissions m) {
        boolean state = false;
        switch (m.getId()) {
            case "M00002":
                state = true;
                break;
            case "M00003":
                state = true;
                break;
            case "M00004":
                state = true;
                break;
            case "M00005":
                state = true;
                break;
            case "M00006":
                state = true;
                break;
            default:
                state = false;
                break;
        }
        return state;
    }

}
