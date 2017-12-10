/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import COMMONFUN.CommonFun;
import DB_ACCESS.DB;
import MODELS.MSalesMan;
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
 * @author user pc
 */
public class C_SalesMan {

    QUERYBUILDER.QueryGen qb = null;
    CommonFun cf = null;

    public C_SalesMan() {
        qb = new QueryGen();
        cf = new CommonFun();
    }

    public void saveSalesMan(MSalesMan s) throws Exception {
        Map<String, String> m = new TreeMap<>();
        m.put("FNAME", "'" + s.getFirstName() + "'");
        m.put("LNAME", "'" + s.getLastName() + "'");
        m.put("IMGPATH", "'" + s.getImgPath() + "'");
        m.put("COMM_PER", "'" + s.getComPer() + "'");
        m.put("ACTIVE", "'" + s.getActive() + "'");

        if (s.getId() != null && s.getId().length() > 0) {
            if (getSalesMan(s.getId()) != null) {
                String q = qb.UpdateRecord("m_SalesPerson", m, " WHERE ID='" + s.getId() + "' ");
                DB.Save(q);
            } else {
                throw new Exception("No Sales man found for Id:" + s.getId());
            }
        } else {
            m.put("ID", "'" + cf.generateNextNo(5, "", "m_SalesPerson", "ID") + "'");
            String q = qb.SaveRecord("m_SalesPerson", m);
            DB.Update(q);
        }

    }

    public MSalesMan getSalesMan(String id) throws Exception {
        String q = "SELECT * FROM m_SalesPerson WHERE ID='" + id + "' ";
        ResultSet rs = DB.Search(q);
        MSalesMan sm = null;
        if (rs.next()) {
            sm = new MSalesMan();
            sm.setId(rs.getString("ID"));
            sm.setFirstName(rs.getString("FNAME"));
            sm.setLastName(rs.getString("LNAME"));
            sm.setImgPath(rs.getString("IMGPATH"));
            sm.setComPer(rs.getDouble("COMM_PER"));
            sm.setActive(rs.getInt("ACTIVE"));
        }
        return sm;
    }

    public Vector<MSalesMan> getAllSalesMen() throws Exception {
        String q = "SELECT * FROM m_SalesPerson WHERE ACTIVE=1 ";
        ResultSet rs = DB.Search(q);
        Vector<MSalesMan> ar = new Vector<>();
        
        ar.add(new MSalesMan("","", 0.0));
        
        
        while (rs.next()) {
            MSalesMan sm = new MSalesMan();
            sm.setId(rs.getString("ID"));
            sm.setFirstName(rs.getString("FNAME"));
            sm.setLastName(rs.getString("LNAME"));
            sm.setImgPath(rs.getString("IMGPATH"));
            sm.setComPer(rs.getDouble("COMM_PER"));
            sm.setActive(rs.getInt("ACTIVE"));
            ar.add(sm);
        }
        return ar;
    }

    public void AddDefaultSalesMan(){
        try {
            if(getSalesMan("00000")==null){
                String q="INSERT INTO m_salesperson(ID,FNAME,LNAME,COMM_PER,ACTIVE)VALUES('00000','','',0,1) ";
            DB.Save(q);
            }
        } catch (Exception ex) {
           // Logger.getLogger(C_SalesMan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
