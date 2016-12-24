/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CONTROLLERS;

import DB_Access.DB;
import MODELS.MPropertise;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOME
 */
public class C_Propertise {
     
     public Vector<MPropertise> getAllPropertise() {
          Vector<MPropertise> v=new Vector<>();
        try {
            String Q="SELECT PROP.ID AS ID,PROP.NAME AS NAME,PROTYP.ID AS PRODATATYP,PROP.ACTIVE AS ACTIVE,PROTYP.FORMAT AS FORMAT "
                    + " FROM M_PROPERTISE PROP INNER JOIN m_propdatatype PROTYP ON PROP.M_PROPDATATYPE_ID=PROTYP.ID  WHERE ACTIVE=1";
            ResultSet rs = DB.Search(Q);
           
            
            while (rs.next()) {
                MPropertise p=new MPropertise();
                p.setPropId(rs.getString("ID"));
                p.setPropName(rs.getString("NAME"));
                p.setDataType(rs.getInt("PRODATATYP"));
                p.setActive(rs.getInt("ACTIVE"));
                p.setFormat(rs.getString("FORMAT"));
                v.add(p);
            }
            
        } catch (Exception ex) {
          
        } 
        return v;
    }
     
     public MPropertise getProperty(String Id){
          MPropertise p=null;
          try {
            String Q="SELECT PROP.ID AS ID,PROP.NAME AS NAME,PROTYP.ID AS PRODATATYP,PROP.ACTIVE AS ACTIVE,PROTYP.FORMAT AS FORMAT "
                    + " FROM M_PROPERTISE PROP INNER JOIN m_propdatatype PROTYP ON PROP.M_PROPDATATYPE_ID=PROTYP.ID  WHERE ACTIVE=1 ";
            Q+=" AND PROP.ID='"+Id+"'";
            ResultSet rs = DB.Search(Q);
           
           
            if (rs.next()) {
                p=new MPropertise();
                p.setPropId(rs.getString("ID"));
                p.setPropName(rs.getString("NAME"));
                p.setDataType(rs.getInt("PRODATATYP"));
                p.setActive(rs.getInt("ACTIVE"));
                p.setFormat(rs.getString("FORMAT"));
               
            }
            
        } catch (Exception ex) {
            Logger.getLogger(MPropertise.class.getName()).log(Level.SEVERE, null, ex);
        }
          return p;
     }
}
