/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CONTROLLERS;

import COMMONFUN.CommonFun;
import DB_ACCESS.DB;
import MODELS.MLocation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author HOME
 */
public class C_Locations {
    CommonFun cf=null;
    public C_Locations() {
        cf=new CommonFun();
    }
    
    
    
    
    ////////////////////////METHODS////////////////////////////////////
    public MLocation getLocation(String Id) throws Exception {
        String sql = "SELECT * FROM m_location where ID='" + Id + "'";
        MLocation m = new MLocation();

        ResultSet rs = DB.Search(sql);
        if (rs.next()) {
            m.setId(rs.getInt("ID"));
            m.setName(rs.getString("NAME"));
            m.setActive(rs.getByte("ACTIVE"));
            m.setRefno(rs.getString("REFNO"));
            m.setVisible(rs.getByte("VISIBLE"));
        }

        return m;
    }

    public ArrayList<MLocation> getAllLocations() throws Exception{
        String q="SELECT * FROM m_location where ACTIVE=" + 1 + "";
         
       ArrayList<MLocation> arl=new ArrayList<>();
        ResultSet rs = DB.Search(q);
        while (rs.next()) {
            MLocation m = new MLocation();
            m.setId(rs.getInt("ID"));
            m.setName(rs.getString("NAME"));
            m.setActive(rs.getByte("ACTIVE"));
            m.setRefno(rs.getString("REFNO"));
            m.setVisible(rs.getByte("VISIBLE"));
            arl.add(m);
        }
        return arl;
    }
    
    public Vector<MLocation> getAllLocationsV() throws Exception{
        String q="SELECT * FROM m_location where ACTIVE=" + 1 + "";
         
       Vector<MLocation> arl=new Vector<>();
        ResultSet rs = DB.Search(q);
        while (rs.next()) {
            MLocation m = new MLocation();
            m.setId(rs.getInt("ID"));
            m.setName(rs.getString("NAME"));
            m.setActive(rs.getByte("ACTIVE"));
            m.setRefno(rs.getString("REFNO"));
            m.setVisible(rs.getByte("VISIBLE"));
            arl.add(m);
        }
        return arl;
    }
    
    public MLocation getLocation(String Id, int state) throws Exception {
        String sql = "SELECT * FROM m_location where ID='" + Id + "' AND ACTIVE=" + state + "";
        MLocation m = new MLocation();

        ResultSet rs = DB.Search(sql);
        if (rs.next()) {
            m.setId(rs.getInt("ID"));
            m.setName(rs.getString("NAME"));
            m.setActive(rs.getByte("ACTIVE"));
            m.setRefno(rs.getString("REFNO"));
            m.setVisible(rs.getByte("VISIBLE"));
        }

        return m;
    }

    public MLocation CheckExists(String LocName) throws Exception {
        String sql = "SELECT ID,NAME FROM m_location WHERE NAME='" + LocName.toUpperCase() + "' ";
        ResultSet rs = DB.Search(sql);
        MLocation m = null;
        if (rs.next()) {
            m = new MLocation();
            m.setId(rs.getInt("ID"));
            m.setName(rs.getString("NAME"));
        }
        return m;
    }

    public int SaveLocation(MLocation m) throws Exception {
         int id = cf.generateNxtIntNo("m_location", "ID", "");
        String sql = "INSERT INTO m_location(ID,NAME,REFNO,ACTIVE,VISIBLE) VALUES('"+id+"','" + m.getName().toUpperCase() + "','" + m.getRefno() + "',1,1)";
        return DB.Save(sql);
    }

    public int UpdateLocation(MLocation m) throws Exception {
        if (m.getId() != 0) {
            String sql = "UPDATE m_location SET ACTIVE='"+m.getActive()+"',NAME='" + m.getName().toUpperCase() + "',REFNO='" + m.getRefno() + "' WHERE ID=" + m.getId() + "";
            return DB.Update(sql);
        }else{
            return -1;
        }
    }

}
