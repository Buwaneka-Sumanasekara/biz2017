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
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOME
 */
public class CommonFun {
    
    C_GroupCommon gc = null;
    
    public CommonFun() {
        gc = new C_GroupCommon();
    }
    
    public String generateNextNo(int length, String Prefix, String tbl, String tblIDCol) throws Exception {
        return generateNextNo(length, Prefix, tbl, tblIDCol, "");
    }
    
    public void WriteLog(String place, String msg) {
        System.out.println("Called Write log");
        Object get = GlobalData.Settings.get("DEBUG_MODE");
        if (get != null) {
            if (get.equals("1")) {
                System.out.println("========LOG========");
                System.out.println("DATE:" + (new Date()));
                System.out.println("LOCATION:" + place);
                System.out.println("MSG:" + msg);
                System.out.println("========END:LOG========");
            }else{
                  System.out.println("DEBUG MODE=0");
            }
        }else{
            System.out.println("CONFIG FILE NOT FOUND!");
        }
    }
    
    public String generateNextNo(int length, String Prefix, String tbl, String tblIDCol, String WhereClause) throws Exception {
        String q = "SELECT Max(" + tblIDCol + ") as ID FROM " + tbl + " " + WhereClause;
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
    
    public String generateLastNo(int length, String Prefix, String tbl, String tblIDCol, String WhereClause) throws Exception {
        String q = "SELECT Max(" + tblIDCol + ") as ID FROM " + tbl + " " + WhereClause;
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
    
    public int generateNxtIntNo(String tbl, String tblIDCol, String WhereClause) throws Exception {
        String q = "SELECT Max(" + tblIDCol + ") as ID FROM " + tbl + " " + WhereClause;
        ResultSet rs = DB.Search(q);
        int id = 1;
        
        if (rs.next()) {
            id = rs.getInt("ID") + 1;
        }
        return id;
    }

    //Create Product Name
    public String getProductName(ArrayList<MGroupCommon> GList) {
        String ProName = "";
        //G1000

        for (MGroupCommon G : GList) {
            
            if (G != null && !gc.IsDefaultGroup(G.getId())) {
                
                if (ProName.length() > 0) {
                    ProName += " " + G.getName();
                } else {
                    ProName = G.getName();
                }
            }
        }
        return ProName.toUpperCase();
    }
    
    public static String getSystemTheme() {
        //String theme = "mint.MintLookAndFeel";
        String theme = "aero.AeroLookAndFeel";
        
        try {
            
            ResultSet rs = DB.Search("SELECT * FROM u_systhemes WHERE ID=" + GlobalData.Setup.getUitheme() + "");
            if (rs.next()) {
                theme = rs.getString("URL");
            }
        } catch (Exception ex) {
            
        }
        return theme;
    }
    
    public static String getCurrentDateTime(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }
    
    public static String getCurrentDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }
    
    public String getValueWithComma(double amount) {
        
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        
        symbols.setGroupingSeparator(',');
        formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(amount);
    }

    public BigDecimal parseValueWithComma(String amount) throws ParseException {
        
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ROOT);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        
        symbols.setGroupingSeparator(',');
        formatter.setDecimalFormatSymbols(symbols);
        formatter.setMaximumFractionDigits(0);
        return BigDecimal.valueOf(formatter.parse(amount).doubleValue());
    }
    
    public static void main(String[] args) {
        try {
            CommonFun c = new CommonFun();
            double d = 5000000000.45;
            
            String amt = c.getValueWithComma(d);
            System.out.println(amt);
            System.out.println(c.parseValueWithComma(amt) + "");
        } catch (ParseException ex) {
            Logger.getLogger(CommonFun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
