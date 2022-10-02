/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import COMMONFUN.CommonFun;
import DB_ACCESS.DB;
import MODELS.MUnitGroup;
import MODELS.MUnitGroupAssign;
import MODELS.MUnits;
import QUERYBUILDER.QueryGen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOME
 */
public class C_Units {

    private QueryGen qg = null;
    private COMMONFUN.CommonFun comF = null;

    public C_Units() {
        qg = new QueryGen();
        comF = new CommonFun();
    }

    public String GenerateNewUnitNo() throws Exception {
        return comF.generateNextNo(4, "U", "m_units", "ID");
    }

    public String GenerateNewUnitGroupNo() throws Exception {
        return comF.generateNextNo(4, "UG", "M_UNITGROUPS", "ID");
    }

    public String getBaseUnitId(String UnitGroupId) throws Exception{
         String q="SELECT * FROM M_UNITGROUPS_HAS_M_UNITS WHERE BASEUNIT=1 AND M_UNITGROUPS_ID='"+UnitGroupId+"' ";
        
        ResultSet rs = DB.Search(q);
        String BaseUnitId="";
        if (rs.next()) {            
          BaseUnitId=rs.getString("M_UNITS_ID");
        }
        if(BaseUnitId==""){
             throw new Exception("Base unit not found !");
        }
        return BaseUnitId;
    }
    
   
    
    public int saveUnit(MUnits m) throws Exception {

        TreeMap<String, String> tm = new TreeMap<>();
        tm.put("ID", "'" + (m.getId()!=null?m.getId():GenerateNewUnitNo()) + "'");
        tm.put("NAME", "'" + m.getName() + "'");
        tm.put("ACTIVE", m.getActive().toString());
        tm.put("SYMBLE", "'" + m.getSymble() + "'");
        String q = qg.SaveRecord("m_units", tm);
        return DB.Save(q);

    }

    public int updateUnit(MUnits m) throws Exception {
        TreeMap<String, String> tm = new TreeMap<>();

        tm.put("NAME", "'" + m.getName() + "'");
        tm.put("ACTIVE", m.getActive().toString());
        tm.put("SYMBLE", "'" + m.getSymble() + "'");
        String q = qg.UpdateRecord("m_units", tm, "WHERE ID='" + m.getId()+"'");
        return DB.Update(q);
    }

    public MUnits getUnit(String Id) throws Exception {
        String q = "SELECT * FROM m_units WHERE ID='" + Id + "'";
        System.out.println(q);
        ResultSet rs = DB.Search(q);
        MUnits m = null;
        if (rs.next()) {
            m = new MUnits();
            m.setId(rs.getString("ID"));
            m.setName(rs.getString("NAME"));
            m.setSymble(rs.getString("SYMBLE"));
            m.setActive(rs.getByte("ACTIVE"));
        }
        return m;
    }
    
    

    public Vector<MUnits> getAllUnits() {
        Vector<MUnits> v = new Vector<>();
        try {
            String q = "SELECT * FROM m_units WHERE ACTIVE=1";
            ResultSet rs = DB.Search(q);

            while (rs.next()) {
                MUnits m = new MUnits();
                m.setId(rs.getString("ID"));
                m.setName(rs.getString("NAME"));
                       m.setSymble(rs.getString("SYMBLE"));
                m.setActive(rs.getByte("ACTIVE"));
                v.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(MUnits.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    /*  UNIT GROUPS*/
    public MUnitGroup findUnitGroupExists(String ID) throws Exception {
        String q = "SELECT * FROM M_UNITGROUPS WHERE ID='" + ID + "'";
        ResultSet rs = DB.Search(q);
        MUnitGroup m = null;
        if (rs.next()) {
            m = new MUnitGroup();
            m.setUnitGroupId(rs.getString("ID"));
            m.setUnitGroupName(rs.getString("NAME"));
            m.setUnitGroupActive(rs.getByte("ACTIVE"));
        }
        return m;
    }

     public Vector<MUnitGroup> findAllUnitGroups() throws Exception {
        String q = "SELECT * FROM M_UNITGROUPS WHERE ACTIVE=1 ";
        ResultSet rs = DB.Search(q);
        Vector<MUnitGroup>  v=new Vector<>();
        while (rs.next()) {
            MUnitGroup m = new MUnitGroup();
            m.setUnitGroupId(rs.getString("ID"));
            m.setUnitGroupName(rs.getString("NAME"));
            m.setUnitGroupActive(rs.getByte("ACTIVE"));
            v.add(m);
        }
        return v;
    }

    public MUnitGroup findUnitGroupExistsByName(String Name) throws Exception {
        String q = "SELECT * FROM M_UNITGROUPS WHERE NAME='" + Name.toUpperCase() + "'";
        ResultSet rs = DB.Search(q);
        MUnitGroup m = null;
        if (rs.next()) {
            m = new MUnitGroup();
            m.setUnitGroupId(rs.getString("ID"));
            m.setUnitGroupName(rs.getString("NAME"));
            m.setUnitGroupActive(rs.getByte("ACTIVE"));
        }
        return m;
    }

    private int createUnitGroup(MUnitGroup ug) throws Exception {
        TreeMap<String, String> tm = new TreeMap<>();
        tm.put("ID", "'" + ug.getUnitGroupId() + "'");
        tm.put("NAME", "'" + ug.getUnitGroupName() + "'");
        tm.put("ACTIVE", "" + ug.getUnitGroupActive());

        String q = qg.SaveRecord("M_UNITGROUPS", tm);
        return DB.Save(q);
    }
    private int updateUnitGroup(MUnitGroup ug) throws Exception {
        TreeMap<String, String> tm = new TreeMap<>();
        tm.put("ID", "'" + ug.getUnitGroupId() + "'");
        tm.put("NAME", "'" + ug.getUnitGroupName() + "'");
        tm.put("ACTIVE", "" + ug.getUnitGroupActive());

        String q = qg.UpdateRecord("M_UNITGROUPS", tm,"WHERE ID='" + ug.getUnitGroupId()+"'");
        return DB.Save(q);
    }

    private void assignUnitToGroups(MUnitGroupAssign uga) throws Exception {
        TreeMap<String, String> tm = new TreeMap<>();
        tm.put("M_UNITGROUPS_ID", "'" + uga.getUnitGroupId() + "'");
        tm.put("M_UNITS_ID", "'" + uga.getUnitId() + "'");
        tm.put("BASEUNIT", "" + uga.getIsBase());
        tm.put("VOLUME", "" + uga.getVolume());
        tm.put("ACTIVE", "" + uga.getActive());

        String q = qg.SaveRecord("M_UNITGROUPS_HAS_M_UNITS", tm);
        DB.Save(q);
    }

    
    
    private void removeGroupAssign(String UnitGroup) throws Exception {
         String q="DELETE FROM M_UNITGROUPS_HAS_M_UNITS WHERE M_UNITGROUPS_ID='"+UnitGroup+"'";
         DB.Delete(q);
    }
        public void removeGroupAssign(String UnitGroup,String unit) throws Exception {
         String q="DELETE FROM M_UNITGROUPS_HAS_M_UNITS WHERE M_UNITGROUPS_ID='"+UnitGroup+"' AND M_UNITS_ID='"+unit+"'";
         DB.Delete(q);
    }

    public ArrayList<Vector> getAllAssignUnits(String UnitGroupId) throws Exception{
        String q="SELECT * FROM M_UNITGROUPS_HAS_M_UNITS WHERE M_UNITGROUPS_ID='"+UnitGroupId+"' ";
        ArrayList<Vector> ar=new ArrayList<>();
        ResultSet rs = DB.Search(q);
        while (rs.next()) {            
           Vector v=new Vector();
           v.add(getUnit(rs.getString("M_UNITS_ID")));
           v.add(rs.getDouble("VOLUME"));
           v.add(rs.getBoolean("BASEUNIT"));
           ar.add(v);
        }
        return ar;
    }
    public Vector getAllAssignUnitsVect(String UnitGroupId) throws Exception{
        String q="SELECT * FROM M_UNITGROUPS_HAS_M_UNITS WHERE M_UNITGROUPS_ID='"+UnitGroupId+"' ";
        Vector v=new Vector();
        ResultSet rs = DB.Search(q);
        while (rs.next()) {            
          
           v.add(getUnit(rs.getString("M_UNITS_ID")));
      
       
        }
        return v;
    }
    
    
    
    public void UpdateUnitGroup(MUnitGroup ug, ArrayList<MUnitGroupAssign> uga) throws Exception {
        try {
            DB.getCurrentCon().setAutoCommit(false);
            updateUnitGroup(ug);
            removeGroupAssign(ug.getUnitGroupId());
            for (MUnitGroupAssign mUnitGroupAssign : uga) {
                assignUnitToGroups(mUnitGroupAssign);
            }

            DB.getCurrentCon().commit();

        } catch (Exception e) {

            try {
                DB.getCurrentCon().rollback();
            } catch (Exception ex) {
                //Logger.getLogger(C_Units.class.getName()).log(Level.SEVERE, null, ex);
            }
            throw e;
        } finally {
            try {
                DB.getCurrentCon().setAutoCommit(true);
            } catch (Exception ex) {
                // Logger.getLogger(C_Units.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void SaveUnitGroup(MUnitGroup ug, ArrayList<MUnitGroupAssign> uga) throws Exception {
        try {
            DB.getCurrentCon().setAutoCommit(false);
            if(findUnitGroupExists(ug.getUnitGroupId())==null){
                 createUnitGroup(ug);
            }
           
            for (MUnitGroupAssign mUnitGroupAssign : uga) {
                try {
                   assignUnitToGroups(mUnitGroupAssign); 
                } catch (Exception e) {
                    System.out.println("Error assign unit group"+"Group:"+ug.getUnitGroupId()+e.getMessage());
                }
                
            }

            DB.getCurrentCon().commit();

        } catch (Exception e) {

            try {
                DB.getCurrentCon().rollback();
            } catch (Exception ex) {
                //Logger.getLogger(C_Units.class.getName()).log(Level.SEVERE, null, ex);
            }
            throw e;
        } finally {
            try {
                DB.getCurrentCon().setAutoCommit(true);
            } catch (Exception ex) {
                // Logger.getLogger(C_Units.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    public double getUnitConversion(String UnitGroup,String UnitId) throws Exception{
        double conv=0.0;
        String q="SELECT VOLUME  FROM M_UNITGROUPS_HAS_M_UNITS WHERE M_UNITGROUPS_ID='"+UnitGroup+"' AND M_UNITS_ID='"+UnitId+"' ";
        ResultSet rs = DB.Search(q);
        if (rs.next()) {            
            conv=rs.getDouble("VOLUME");
        }
        return conv;
    }
    
    public MUnits getBaseUnitIdObj(String UnitGroup)throws Exception{
        String q="SELECT * FROM  m_units WHERE ID IN(SELECT M_UNITS_ID FROM M_UNITGROUPS_HAS_M_UNITS WHERE BASEUNIT=1 AND M_UNITGROUPS_ID='"+UnitGroup+"') ";
        System.out.println(q);
        ResultSet rs = DB.Search(q);
        MUnits m = null;
        if (rs.next()) {
            m = new MUnits();
            m.setId(rs.getString("ID"));
            m.setName(rs.getString("NAME"));
            m.setSymble(rs.getString("SYMBLE"));
            m.setActive(rs.getByte("ACTIVE"));
        }
        return m;
    }
    
    public String getMaxUnitOfGroup(String ug)throws Exception{
          String q="SELECT strf_getMaxUnit('"+ug+"') AS U ";
         ResultSet rs = DB.Search(q);

       String d="";
        if (rs.next()) {
           d=rs.getString("U");
           
        }

        return d;
    }
}
