/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import DB_ACCESS.DB;
import MODELS.MPaydet;
import MODELS.MPaymst;
import MODELS.UTransactions;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Buwanaka
 */
public class C_Payments {

    public C_Payments() {
    }

    public MPaymst getPayMst(String id) throws Exception {
        String q = "SELECT * FROM M_PAYMST WHERE ACTIVE=1 AND ID='" + id + "'";
        ResultSet rs = DB.Search(q);
        MPaymst m = null;
        if (rs.next()) {
            m = new MPaymst();
            m.setId(rs.getString("ID"));
            m.setName(rs.getString("NAME"));
            m.setHasdet(rs.getByte("HASDET"));
            m.setRefreq(rs.getByte("REFREQ"));
            m.setOrder(rs.getInt("SEQ_ORDER"));
            m.setShortname(rs.getString("SHORT_NAME"));
            m.setActive(rs.getByte("ACTIVE"));
            m.setOverpay(rs.getByte("OVER_PAY"));
            m.setDatef(rs.getByte("DATE_F"));
            m.setSetdueauto(rs.getByte("SET_DUE_AUTO"));
        }
        return m;
    }

//    public Vector<MPaymst> getPayMstAll() throws Exception {
//        String q = "SELECT * FROM M_PAYMST WHERE ACTIVE=1 ORDER BY SEQ_ORDER";
//        ResultSet rs = DB.Search(q);
//        Vector<MPaymst> v = new Vector<>();
//        while (rs.next()) {
//            MPaymst m = new MPaymst();
//            m.setId(rs.getString("ID"));
//            m.setName(rs.getString("NAME"));
//            m.setHasdet(rs.getByte("HASDET"));
//            m.setRefreq(rs.getByte("REFREQ"));
//            m.setOrder(rs.getInt("SEQ_ORDER"));
//            m.setShortname(rs.getString("SHORT_NAME"));
//            m.setActive(rs.getByte("ACTIVE"));
//            m.setOverpay(rs.getByte("OVER_PAY"));
//            m.setDatef(rs.getByte("DATE_F"));
//            m.setSetdueauto(rs.getByte("SET_DUE_AUTO"));
//            v.add(m);
//        }
//        return v;
//    }
    public Vector<MPaymst> getPayMstAll(UTransactions trnsetup) throws Exception {
        String q = "SELECT * FROM M_PAYMST WHERE ACTIVE=1 ORDER BY SEQ_ORDER";
        ResultSet rs = DB.Search(q);
        Vector<MPaymst> v = new Vector<>();
        while (rs.next()) {
            String payHedId = rs.getString("ID");
            System.out.println(payHedId);
            System.out.println(trnsetup.getEnableCredit());
            if (!payHedId.equals("CRD") || (payHedId.equals("CRD") && trnsetup.getEnableCredit() == 1)) {
                MPaymst m = new MPaymst();
                m.setId(payHedId);
                m.setName(rs.getString("NAME"));
                m.setHasdet(rs.getByte("HASDET"));
                m.setRefreq(rs.getByte("REFREQ"));
                m.setOrder(rs.getInt("SEQ_ORDER"));
                m.setShortname(rs.getString("SHORT_NAME"));
                m.setActive(rs.getByte("ACTIVE"));
                m.setOverpay(rs.getByte("OVER_PAY"));
                m.setDatef(rs.getByte("DATE_F"));
                m.setSetdueauto(rs.getByte("SET_DUE_AUTO"));
                v.add(m);
            }

        }
        return v;
    }

    public Vector<MPaymst> getPayMstFiltered(String[] payHedSkip) throws Exception {
        String q = "SELECT * FROM M_PAYMST WHERE ACTIVE=1 ";

        if (payHedSkip.length > 0) {
            q += " AND ";

            for (int i = 0; i < payHedSkip.length; i++) {
                String Id = payHedSkip[i];
                if (i > 0) {
                    q += " AND ";
                }
                q += "ID<>'" + Id + "'";
            }
        }

        q += " ORDER BY SEQ_ORDER";

        ResultSet rs = DB.Search(q);
        Vector<MPaymst> v = new Vector<>();
        while (rs.next()) {
            String payHedId = rs.getString("ID");

            MPaymst m = new MPaymst();
            m.setId(payHedId);
            m.setName(rs.getString("NAME"));
            m.setHasdet(rs.getByte("HASDET"));
            m.setRefreq(rs.getByte("REFREQ"));
            m.setOrder(rs.getInt("SEQ_ORDER"));
            m.setShortname(rs.getString("SHORT_NAME"));
            m.setActive(rs.getByte("ACTIVE"));
            m.setOverpay(rs.getByte("OVER_PAY"));
            m.setDatef(rs.getByte("DATE_F"));
            m.setSetdueauto(rs.getByte("SET_DUE_AUTO"));
            v.add(m);

        }
        return v;
    }

    public Vector<MPaydet> getPayDet(String MstId) throws Exception {
        String q = "SELECT * FROM M_PAYDET WHERE ACTIVE=1 AND M_PAYMST_ID='" + MstId + "' ORDER BY SEQ_ORDER";
        System.out.println(q);
        ResultSet rs = DB.Search(q);
        Vector<MPaydet> v = new Vector<>();
        while (rs.next()) {
            MPaydet m = new MPaydet();
            m.setMstId(rs.getString("M_PAYMST_ID"));
            m.setId(rs.getString("ID"));
            m.setName(rs.getString("NAME"));
            m.setRate(rs.getDouble("RATE"));
            m.setRefreq(rs.getByte("REF_REQ"));
            m.setOrder(rs.getInt("SEQ_ORDER"));
            m.setShortname(rs.getString("SHORT_NAME"));
            m.setActive(rs.getByte("ACTIVE"));
            m.setDatef(rs.getByte("DATE_F"));

            v.add(m);
        }
        return v;
    }
}
