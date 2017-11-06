/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import DB_ACCESS.DB;
import MODELS.MGroupCommon;
import QUERYBUILDER.QueryGen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOME
 */
public class C_GroupCommon {

    QueryGen qg = null;

    public C_GroupCommon() {
        qg = new QueryGen();
    }

    public boolean IsDefaultGroup(String ID) {
        switch (ID) {
            case "G1000":
                return true;
            case "G2000":
                return true;
            case "G3000":
                return true;
            case "G4000":
                return true;
            case "G5000":
                return true;
            default:
                return false;
        }
    }

    public String getDefaultGroup(int GID) {
        switch (GID) {
            case 1:
                return "G1000";
            case 2:
                return "G2000";
            case 3:
                return "G3000";
            case 4:
                return "G4000";
            case 5:
                return "G5000";
            default:
                return "";
        }
    }

    public int saveGroup(String tbl, MGroupCommon g) throws Exception {
        String q = "INSERT INTO " + tbl + "(ID,NAME,ACTIVE,ISHIDDEN) VALUES('" + g.getId() + "','" + g.getName() + "'," + g.getActive() + ",0) ";

        return DB.Save(q);
    }

    public int updateGroup(String tbl, MGroupCommon g) throws Exception {
        String q = "UPDATE " + tbl + " SET NAME='" + g.getName() + "',ACTIVE=" + g.getActive() + " WHERE ID='" + g.getId() + "' ";
        System.out.println(q);
        return DB.Update(q);
    }

    public Map<Integer, String> getGroupDisplayNames() {
        Map<Integer, String> m = new TreeMap<>();
        try {
            String q = "SELECT * from m_permissions WHERE TYPE='GROUP'";
            ResultSet rs = DB.Search(q);

            int i = 1;
            while (rs.next()) {

                m.put(i, rs.getString("DESCRIPTION"));
                i++;
            }

        } catch (Exception ex) {
            Logger.getLogger(MGroupCommon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    public MGroupCommon IsExists(String tbl, String ID) throws Exception {
        String q = "SELECT * FROM " + tbl + " WHERE ID='" + ID + "'";
        ResultSet rs = DB.Search(q);
        MGroupCommon g = null;
        if (rs.next()) {
            g = new MGroupCommon();
            g.setId(rs.getString("ID"));
            g.setName(rs.getString("NAME"));

        }
        return g;
    }

    public Vector<MGroupCommon> getAllGroupValues(int Group) {
        return getAllGroupValues(Group, false);
    }

    public Vector<MGroupCommon> getAllGroupValues(int Group, boolean skipDefault) {
        Vector<MGroupCommon> v = new Vector<>();
        try {
            String q = "SELECT * FROM m_group" + Group + " WHERE ACTIVE=1 AND ISHIDDEN=0 ORDER BY NAME ";
            ResultSet rs =DB.Search(q);
            if (skipDefault == false) {
                v.add(new MGroupCommon(getDefaultGroup(Group), "NOT APPLICABLE", (byte) 1));
            }
            while (rs.next()) {
                MGroupCommon g = new MGroupCommon();
                g.setId(rs.getString("ID"));
                g.setName(rs.getString("NAME"));
                v.add(g);
            }

        } catch (Exception ex) {
            Logger.getLogger(MGroupCommon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public void saveGroupMaping(ArrayList<MGroupCommon> arl) throws Exception {

        Map<String, String> MQuery = new TreeMap<>();
        int id = 1;
        for (MGroupCommon mGroupCommon : arl) {
            MQuery.put("G" + id + "_ID", "'" + mGroupCommon.getId() + "'");
            id++;
        }

        if (CheckGroupMappingExists(arl) == false) {
            DB.Save(qg.SaveRecord("M_GROUPLINK", MQuery));
        } else {
            throw new Exception("Group combination is already Exists!");
        }

    }

    public void RemoveGroupMaping(ArrayList<MGroupCommon> arl) throws Exception {
        String q = "DELETE FROM M_GROUPLINK WHERE ";

        int id = 1;
        for (MGroupCommon mGroupCommon : arl) {
            if (id == 1) {
                q += " G" + id + "_ID ='" + mGroupCommon.getId() + "'  ";
            } else {
                q += " AND G" + id + "_ID ='" + mGroupCommon.getId() + "'  ";
            }
            id++;
        }

        DB.Delete(q);

    }

    public boolean CheckGroupMappingExists(ArrayList<MGroupCommon> arl) throws Exception {
        boolean state = false;

        String q = "SELECT * FROM M_GROUPLINK WHERE ";

        int id = 1;
        for (MGroupCommon mGroupCommon : arl) {
            if (id == 1) {
                q += " G" + id + "_ID ='" + mGroupCommon.getId() + "'  ";
            } else {
                q += " AND G" + id + "_ID ='" + mGroupCommon.getId() + "'  ";
            }
            id++;
        }

        ResultSet rs = DB.Search(q);
        if (rs.next()) {
            state = true;
        }
        return state;
    }

    public ArrayList<Vector<MGroupCommon>> getAllGroupMapings(MGroupCommon Group) throws Exception {

        ArrayList<Vector<MGroupCommon>> ar = new ArrayList<>();
        String q = "SELECT * FROM M_GROUPLINK  WHERE ";
        q += " G" + 1 + "_ID ='" + Group.getId() + "'  ";

        ResultSet rs = DB.Search(q);

        while (rs.next()) {
            Vector<MGroupCommon> v = new Vector<>();

            for (int i = 1; i <= 5; i++) {
                MGroupCommon groupCommon = IsExists("m_group" + i, rs.getString("G" + i + "_ID"));
                v.add(groupCommon);
            }

            ar.add(v);

        }
        return ar;
    }

    public Vector<MGroupCommon> getFilteredGroups(int ReqGroup, ArrayList<String> PreviousSelectGroupIds) throws Exception {
        Vector<MGroupCommon> v = new Vector<>();
        if (PreviousSelectGroupIds.size() > 0) {
            String q = "SELECT G" + ReqGroup + "_ID FROM M_GROUPLINK  WHERE G" + ReqGroup + "_ID <> '"+getDefaultGroup(ReqGroup)+"' ";

            int GNo = 1;
            for (String SelectedGroupsId : PreviousSelectGroupIds) {
                 
                
                  q+=" AND ";
             
                q+=" G" + GNo + "_ID = '"+SelectedGroupsId+"'  ";
                GNo++;
            }
            q+=" GROUP BY G" + ReqGroup + "_ID" ;
            
            ResultSet rs = DB.Search(q);
            
            v.add(IsExists("M_GROUP" + ReqGroup,getDefaultGroup(ReqGroup)));
            
            while (rs.next()) {                
                MGroupCommon Group = IsExists("M_GROUP"+ReqGroup,rs.getString("G" + ReqGroup + "_ID"));
                if(Group!=null){
                    v.add(Group);
                }
            }
        }
        return v;
    }

}
