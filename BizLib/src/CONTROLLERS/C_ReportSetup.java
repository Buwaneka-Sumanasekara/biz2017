/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import DB_ACCESS.DB;
import MODELS.RptCommon;
import java.sql.ResultSet;

import java.util.ArrayList;

/**
 *
 * @author HOME
 */
public class C_ReportSetup {

    public RptCommon getReportSetup(String id) throws Exception {
        String q = "SELECT * FROM  u_reports WHERE RPT_ACTIVE='1' AND RPT_ID='" + id + "' ";
        ResultSet rs = DB.Search(q);

        RptCommon r = null;
        if (rs.next()) {
            r = new RptCommon();
            r.setId(rs.getString("RPT_ID"));
            r.setName(rs.getString("RPT_NAME"));
            r.setRptPath(rs.getString("RPT_PATH"));
            r.setEn_Loc(rs.getByte("RPT_EN_LOC"));
            r.setEn_Cus(rs.getByte("RPT_EN_CUS"));
            r.setEn_Sup(rs.getByte("RPT_EN_SUP"));
            r.setEn_DateRange(rs.getByte("RPT_EN_DATE_RANGE"));
            r.setEn_DateAsAt(rs.getByte("RPT_EN_DATE_AS_AT"));
            r.setEn_DateQut(rs.getByte("RPT_EN_DATE_QUATER"));
            r.setEn_Grp(rs.getInt("RPT_EN_GRP"));
            r.setActive(rs.getByte("RPT_ACTIVE"));
            r.setSubReportPath(rs.getString("RPT_SUBREPORT_PATH"));
        }
        return r;
    }

    public ArrayList<RptCommon> getAllReportSetup() throws Exception {
        String q = "SELECT * FROM  u_reports WHERE RPT_ACTIVE='1'  ";
        ResultSet rs = DB.Search(q);

        ArrayList<RptCommon> ar_rpt = new ArrayList<>();
        while (rs.next()) {

            RptCommon r = new RptCommon();
            r.setId(rs.getString("RPT_ID"));
            r.setName(rs.getString("RPT_NAME"));
            r.setRptPath(rs.getString("RPT_PATH"));
            r.setEn_Loc(rs.getByte("RPT_EN_LOC"));
            r.setEn_Cus(rs.getByte("RPT_EN_CUS"));
            r.setEn_Sup(rs.getByte("RPT_EN_SUP"));
            r.setEn_DateRange(rs.getByte("RPT_EN_DATE_RANGE"));
            r.setEn_DateAsAt(rs.getByte("RPT_EN_DATE_AS_AT"));
            r.setEn_DateQut(rs.getByte("RPT_EN_DATE_QUATER"));
            r.setEn_Grp(rs.getInt("RPT_EN_GRP"));
            r.setActive(rs.getByte("RPT_ACTIVE"));
             r.setSubReportPath(rs.getString("RPT_SUBREPORT_PATH"));
            ar_rpt.add(r);
        }
        return ar_rpt;
    }

    
    public void rpt_RunStockBalance(int locid)throws Exception{
        String q="CALL strp_UpdateStockBalance('"+locid+"')";
        DB.Save(q);
    }
    
    
    
    
}
