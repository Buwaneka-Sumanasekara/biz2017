/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CONTROLLERS;

import DB_ACCESS.DB;
import MODELS.RptCommon;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HOME
 */
public class C_ReportSetup {
    
    public RptCommon getReportSetup(String id) throws Exception {
        String q = "SELECT * FROM  u_reports WHERE RPT_ID='" + id + "' ";
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
        }
        return r;
    }
    
}
