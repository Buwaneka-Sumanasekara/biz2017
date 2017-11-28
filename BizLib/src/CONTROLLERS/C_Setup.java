/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CONTROLLERS;

import DB_ACCESS.DB;
import MODELS.USetup;
import java.sql.ResultSet;

/**
 *
 * @author HOME
 */
public class C_Setup {
    public static USetup getSetupRec(){
        USetup u=null;
        try {
            String q="SELECT * FROM u_setup";
            ResultSet rs = DB.Search(q);
            if(rs.next()){
                u=new USetup();
                u.setId(rs.getInt("ID"));
                u.setComserial(rs.getString("COMSERIAL"));
                u.setComname(rs.getString("COMNAME"));
                u.setAddno(rs.getString("ADDNO"));
                u.setAdd1(rs.getString("ADD1"));
                u.setAdd2(rs.getString("ADD2"));
                u.setAdd3(rs.getString("ADD3"));
                u.setStkmin(rs.getInt("STKMIN"));
                u.setUitheme(rs.getInt("UITHEME"));
               u.setUitheme(rs.getInt("UITHEME"));
               u.setBatchenable(rs.getInt("BATCH_ENABLE"));
                u.setCurLoc(rs.getInt("CURLOC"));
                u.setComimg(rs.getString("COM_IMG"));
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(C_Setup.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return u;
    }
}
