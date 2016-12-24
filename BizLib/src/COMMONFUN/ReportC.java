/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMMONFUN;

import DB_Access.DB;
import GLOBALDATA.GlobalData;
import MODELS.USetup;
import MODELS.UTransactions;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Buwanaka
 */
public class ReportC {

    public boolean printFromDB_Trn(String TrnNo, UTransactions trnSetup, boolean isReprint) throws Exception {
        USetup setup = GlobalData.Setup;
        String MasterreportPath = new File("").getAbsolutePath() + "\\Reports\\Transactions\\" + ((trnSetup.getReportpath() == null || trnSetup.getReportpath().equals("")) ? "TRpt_Default.jrxml" : trnSetup.getReportpath());
        String SubReport = new File("").getAbsolutePath() + "\\Reports\\Transactions\\";

        if (new File(MasterreportPath).exists() == false) {
            throw new Exception("Report Path is invalid!");
        }

        JasperReport jasperMasterReport = JasperCompileManager.compileReport(MasterreportPath);
        // Map<String, String> ComData = GlobleData.CompanyDetails;
        // JREmptyDataSource datasource = new JREmptyDataSource();
        Connection con = DB.getCurrentCon();
        Map<String, Object> para = new HashMap<>();
        para.put("PARA_TRNNO", TrnNo);
        para.put("PARA_TITLE", trnSetup.getTrndesc().toUpperCase());
        para.put("PARA_COMNAME", setup.getComname());
        para.put("PARA_ADD1", setup.getAddno());
        para.put("PARA_ADD2", setup.getAdd1());
        para.put("PARA_ADD3", setup.getAdd2());
        para.put("PARA_ADD4", setup.getAdd3());
        para.put("PARA_CONTACT", "");
        para.put("PARA_TRNTYP", trnSetup.getTrntype());

        JasperPrint print = JasperFillManager.fillReport(jasperMasterReport, para, con);

        boolean printReport = JasperPrintManager.printReport(print, false);

        return true;

    }

}
