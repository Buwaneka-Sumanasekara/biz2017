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
import javax.swing.tree.DefaultMutableTreeNode;

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
        if (IsExists_Name(tbl, g.getName()) == null) {
            String q = "INSERT INTO " + tbl + "(ID,NAME,ACTIVE,ISHIDDEN) VALUES('" + g.getId() + "','" + g.getName() + "'," + g.getActive() + ",0) ";

            return DB.Save(q);
        } else {
            throw new Exception("This Group is already existing");
        }
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
            g.setActive(rs.getByte("ACTIVE"));

        }
        return g;
    }

    public MGroupCommon IsExists_Name(String tbl, String Name) throws Exception {
        String q = "SELECT * FROM " + tbl + " WHERE NAME='" + Name.toUpperCase() + "'";
        ResultSet rs = DB.Search(q);
        MGroupCommon g = null;
        if (rs.next()) {
            g = new MGroupCommon();
            g.setId(rs.getString("ID"));
            g.setName(rs.getString("NAME"));
            g.setActive(rs.getByte("ACTIVE"));

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
            ResultSet rs = DB.Search(q);
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

    public Vector<MGroupCommon> GetGroupValuesMapped(int parentGrp, Vector<MGroupCommon> parentIds, int ReqGrp) {
        Vector<MGroupCommon> v = new Vector<>();
        try {
            String q = "select * from m_group" + ReqGrp + " G where G.ACTIVE=1 and G.ID IN (select gl.G" + ReqGrp + "_ID from m_grouplink gl where  ";

            int i = 0;
            for (MGroupCommon GC : parentIds) {
                if (i == 0) {
                    q += " gl.G" + parentGrp + "_ID='" + GC.getId() + "' ";
                } else {
                    q += " OR gl.G" + parentGrp + "_ID='" + GC.getId() + "' ";
                }

                i++;
            }

            q += ")";
            System.out.println(q);
            ResultSet rs = DB.Search(q);

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

     public void saveGroupMaping_Excel(ArrayList<MGroupCommon> arl) throws Exception {

        Map<String, String> MQuery = new TreeMap<>();
        int id = 1;
        for (MGroupCommon mGroupCommon : arl) {
            MQuery.put("G" + id + "_ID", "'" + mGroupCommon.getId() + "'");
            id++;
        }

        if (CheckGroupMappingExists(arl) == false) {
            DB.Save(qg.SaveRecord("M_GROUPLINK", MQuery));
        } else {
           // throw new Exception("Group combination is already Exists!");
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

    public ArrayList<MGroupCommon> getGroupMappedList(Map<Integer, String> parents, int Lvl) throws Exception {
        ArrayList<MGroupCommon> ar = new ArrayList<>();
        String q = "SELECT * FROM m_group" + Lvl + " G where  G.ID IN (SELECT DISTINCT  G" + Lvl + "_ID  FROM M_GROUPLINK  ";
        if (parents != null && parents.size() > 0) {
            q += " WHERE (";
            int i = 0;
            for (Map.Entry<Integer, String> entry : parents.entrySet()) {
                Integer key = entry.getKey();
                String value = entry.getValue();

                if (i > 0) {
                    q += " AND ";
                }
                q += " G" + key + "_ID='" + value + "' ";

                i++;
            }
            q += ")";
        }
        q += ")";
        //    System.out.println(q);

        ResultSet rs = DB.Search(q);
        while (rs.next()) {
            MGroupCommon g = new MGroupCommon();
            g.setId(rs.getString("ID"));
            g.setName(rs.getString("NAME"));
            g.setActive(rs.getByte("ACTIVE"));
            ar.add(g);
        }

        return ar;
    }

    public DefaultMutableTreeNode getTreeNodes(Map<Integer, String> map_parents, String parent, int lvl, DefaultMutableTreeNode root) throws Exception {

        ArrayList<MGroupCommon> g1ar = getGroupMappedList(map_parents, lvl);

        for (MGroupCommon g1 : g1ar) {
            //  System.out.println(g1);
            DefaultMutableTreeNode dtm_g1 = new DefaultMutableTreeNode(g1);
            root.add(dtm_g1);
            map_parents.put(lvl, g1.getId());

            ArrayList<MGroupCommon> g2ar = getGroupMappedList(map_parents, lvl + 1);
            for (MGroupCommon g2 : g2ar) {
                // System.out.println("- "+g2);
                DefaultMutableTreeNode dtm_g2 = new DefaultMutableTreeNode(g2);
                dtm_g1.add(dtm_g2);
                map_parents.put(lvl + 1, g2.getId());

                ArrayList<MGroupCommon> g3ar = getGroupMappedList(map_parents, lvl + 2);
                for (MGroupCommon g3 : g3ar) {
                    // System.out.println("-- "+g3);
                    DefaultMutableTreeNode dtm_g3 = new DefaultMutableTreeNode(g3);
                    dtm_g2.add(dtm_g3);
                    map_parents.put(lvl + 2, g3.getId());

                    ArrayList<MGroupCommon> g4ar = getGroupMappedList(map_parents, lvl + 3);
                    for (MGroupCommon g4 : g4ar) {
                        //  System.out.println("--- "+g4);
                        DefaultMutableTreeNode dtm_g4 = new DefaultMutableTreeNode(g4);
                        dtm_g3.add(dtm_g4);

                        

                    }

                    map_parents.clear();
                    map_parents.put(1, parent);
                }

            }

        }

        return root;
    }

    public Vector<MGroupCommon> getFilteredGroups(int ReqGroup, ArrayList<String> PreviousSelectGroupIds) throws Exception {
        Vector<MGroupCommon> v = new Vector<>();
        if (PreviousSelectGroupIds.size() > 0) {
            String q = "SELECT DISTINCT G" + ReqGroup + "_ID FROM M_GROUPLINK  WHERE G" + ReqGroup + "_ID <> '" + getDefaultGroup(ReqGroup) + "' ";

            int GNo = 1;
            q+=" OR (";
            for (String SelectedGroupsId : PreviousSelectGroupIds) {

                if(GNo>1){
                q += " AND ";
                }
                q += " G" + GNo + "_ID = '" + SelectedGroupsId + "'  ";
                GNo++;
            }
            q+=")";
            
            q += " GROUP BY G" + ReqGroup + "_ID";

          //  System.out.println(q);
            
            ResultSet rs = DB.Search(q);

        

            while (rs.next()) {
                MGroupCommon Group = IsExists("M_GROUP" + ReqGroup, rs.getString("G" + ReqGroup + "_ID"));
                if (Group != null) {
                    v.add(Group);
                }
            }
            
                v.add(IsExists("M_GROUP" + ReqGroup, getDefaultGroup(ReqGroup)));
        }
        
       // System.out.println("V:"+v.size());
        return v;
    }

}
