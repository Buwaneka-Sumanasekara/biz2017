/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import DB_ACCESS.DB;
import MODELS.MCreditPayee;
import MODELS.TChqPayments;
import MODELS.TCreditPayment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Buwanaka
 */
public class C_CreditPayments {

    SimpleDateFormat sdf = null;
    QUERYBUILDER.QueryGen qg = null;

    String tableName = "";
    String crdType = "";

    C_ChequePayments c_chq = null;
    C_Suppliers CSupplier = null;
    C_Customers CCustomer = null;

    public C_CreditPayments(String crdType) {
        qg = new QUERYBUILDER.QueryGen();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.crdType = crdType;
        this.tableName = (crdType.equals("CUS") ? "t_crd_settlement_cus" : "t_crd_settlement_sup");
        this.c_chq = new C_ChequePayments();
        this.CSupplier = new C_Suppliers();
        this.CCustomer = new C_Customers();
    }
    
    
    public TCreditPayment getSpecificCreditSettlement(String id) {
        String q = "select * from " + this.tableName + " where ID" + id;
        TCreditPayment m = null;
        try {
            ResultSet rs = DB.Search(q);

            if (rs.next()) {
                m = new TCreditPayment();
                m.setId(rs.getString("ID"));
                m.setCRdate(rs.getDate("CR_DATE"));
                m.setCRBy(rs.getString("CR_BY"));
                m.setUpBy(rs.getString("UP_BY"));
                m.setUpdateddate(rs.getDate("UP_DATE"));

                MCreditPayee payee = (this.crdType.equals("CUS") ? CCustomer.getCustomer(rs.getString("CUS_ID")) : CSupplier.getSupplier(rs.getString("SUP_ID")));
                m.setPayee(payee);
                m.setAmount(rs.getDouble("AMOUNT"));
                m.setNote(rs.getString("NOTE"));
                m.setMPayHedId(rs.getString("PAY_HED"));
                m.setMPaydetId(rs.getString("PAY_DET"));
                m.setEftDate(rs.getDate("EFT_DATE"));
                m.setUtilized(rs.getByte("UTILIZED"));
                m.setActive(rs.getByte("ACTIVE"));
                m.setPayRefNo(rs.getString("PAY_REF_NO"));
                m.setNote2(rs.getString("NOTE2"));

            }
        } catch (Exception ex) {
            Logger.getLogger(C_CreditPayments.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
    
    

    public void CancelCredit(TCreditPayment crdPay) throws Exception {
        Map<String, String> m = new TreeMap<String, String>();
        m.put("ACTIVE", "'0'");
        m.put("UP_DATE", "'" + sdf.format(new Date()) + "'");
        m.put("UP_BY", "'" + GLOBALDATA.GlobalData.CurUser.getId() + "'");
        if (crdPay.getCredType().equals("CUS")) {
            m.put("CUS_ID", "'" + crdPay.getPayee().getId() + "'");
        } else if (crdPay.getCredType().equals("SUP")) {
            m.put("SUP_ID", "'" + crdPay.getPayee().getId() + "'");
        }

        m.put("NOTE2", "'Credit settlement cancelled by user:" + GLOBALDATA.GlobalData.CurUser.getId() + "'");

        String UpdateRecord = qg.UpdateRecord(this.tableName, m, "WHERE ID='" + crdPay.getId() + "'");
        DB.Update(UpdateRecord);

        if (crdPay.getMPayHedId().equals("CHQ")) {
            TCreditPayment crdPayFull = getSpecificCreditSettlement(crdPay.getId());
            TChqPayments chqPay = new TChqPayments();
            chqPay.setChqNo(crdPayFull.getPayRefNo());
            chqPay.setNote("Credit Settlement Cancelled: " + crdPay.getId());

            c_chq.CancelChq(chqPay);
        }

    }

    

}
