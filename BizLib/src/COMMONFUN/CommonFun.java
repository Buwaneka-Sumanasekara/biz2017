/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMMONFUN;

import CONTROLLERS.C_GroupCommon;
import DB_ACCESS.DB;
import GLOBALDATA.GlobalData;
import MODELS.MGroupCommon;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HOME
 */
public class CommonFun {
    C_GroupCommon gc=null;

    public CommonFun() {
        gc=new C_GroupCommon();
    }

    public String generateNextNo(int length, String Prefix, String tbl, String tblIDCol) throws Exception {
        return generateNextNo(length, Prefix, tbl, tblIDCol,"");
    }
    
    public String generateNextNo(int length, String Prefix, String tbl, String tblIDCol,String WhereClause) throws Exception {
        String q = "SELECT Max(" + tblIDCol + ") as ID FROM " + tbl+" "+WhereClause;
        ResultSet rs = DB.Search(q);
        String ID = "";
        if (rs.next()) {
            String id = rs.getString("ID");
            if (id != null && !id.equals("")) {
                ID = getNxtNo(length, Prefix, id);
            } else {
                ID = getNxtNo(length, Prefix, "");
            }
        }

        return ID;
    }

     public String generateLastNo(int length, String Prefix, String tbl, String tblIDCol,String WhereClause) throws Exception {
        String q = "SELECT Max(" + tblIDCol + ") as ID FROM " + tbl+" "+WhereClause;
        ResultSet rs = DB.Search(q);
        String ID = "";
        if (rs.next()) {
            String id = rs.getString("ID");
            if (id != null && !id.equals("")) {
                ID = id;
            } else {
                ID = getNxtNo(length, Prefix, "");
            }
        }

        return ID;
    }
    private String getNxtNo(int length, String prf, String CurrentId) {
        String ID = "";
        if (CurrentId.equals("")) {
            //new
            ID = prf;
            for (int i = 1; i < (length - prf.length()); i++) {
                ID += "0";
            }
            ID += "1";
        } else {
            int nextno = Integer.parseInt(CurrentId.substring(prf.length())) + 1;
            ID = prf;
            for (int i = 0; i < (length - prf.length() - ("" + nextno).length()); i++) {
                ID += "0";
            }
            ID += nextno;
        }
        return ID;
    }

    
    //Create Product Name
    public String getProductName(ArrayList<MGroupCommon> GList) {
        String ProName = "";
        //G1000
        
        
        for (MGroupCommon G : GList) {
            
            if (G!=null && !gc.IsDefaultGroup(G.getId())) {
               
                if (ProName.length() > 0) {
                    ProName += " "+G.getName();
                } else {
                    ProName = G.getName();
                }
            }
        }
        return ProName.toUpperCase();
    }

    public static String getSystemTheme(){
         String theme="mint.MintLookAndFeel";
        try {
           
             ResultSet rs = DB.Search("SELECT * FROM u_systhemes WHERE ID="+GlobalData.Setup.getUitheme()+"");
             if(rs.next()){
                 theme=rs.getString("URL");
             }
        } catch (Exception ex) {
            
        }
        return theme;
    }
    
    public static String getCurrentDateTime(Date d){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }
      public static String getCurrentDate(Date d){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }
}
