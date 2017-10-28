/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import COMMONFUN.CommonFun;
import DB_ACCESS.DB;
import MODELS.MGiftVoucher;
import MODELS.MGiftVoucherGroup;
import QUERYBUILDER.QueryGen;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author Home
 */
public class C_Voucher {

    private QUERYBUILDER.QueryGen qg = null;
    private COMMONFUN.CommonFun cf = null;
    SimpleDateFormat sdf_GV = new SimpleDateFormat("yy");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    int GVLenght = 12;
    String Prf = "";

    public C_Voucher() {
        qg = new QueryGen();
        cf = new CommonFun();
        Prf = sdf_GV.format(new Date());
    }

    public double getVoucherRemainAmt(String GVNo) throws Exception {
        double amt=0.0;
        
        String q = "SELECT SUM(gr.RED_VAL) as AMT FROM m_giftvoucher gv ";
        q += " INNER JOIN t_gvredeem gr ON gv.GV_NO=gr.GV_NO WHERE gv.ISPUR=1 AND gv.GV_NO='" + GVNo + "' ";
        q += " group by gv.GV_NO ";

        System.out.println(q);
        
        ResultSet rs = DB.Search(q);
        if (rs.next()) {
           amt=rs.getDouble("AMT");
        }

        
        
        MGiftVoucher specificVoucher = getSpecificVoucher(GVNo, -1);
        if(specificVoucher==null){
            throw new Exception("Invalid Gift Voucher");
        }else{
            if(specificVoucher.getActive()==0){
                    throw new Exception("Giftvoucher is not activated");
        
            }
            else if(specificVoucher.getIsPurchased()==0){
                throw new Exception("Giftvoucher still not purchased");
        
           } else{
                amt=specificVoucher.getGVValue()-amt;
            }
        }
        
      return amt;
    }
    
    public String saveRedeemRecord(String GVNo,int Loc,double Amount,String CRUser,String RefNo) throws Exception{
        Map<String,String> m=new TreeMap<>();
        String generateNextNo = cf.generateNextNo(1, "", "t_gvredeem", "NO", "WHERE GV_NO='"+GVNo+"'");
        
        m.put("NO", "'" + generateNextNo + "'");
        m.put("GV_NO", "'" + GVNo + "'");
         m.put("RED_LOC", "'" + Loc + "'");
        m.put("RED_VAL", "'" + Amount + "'");
        m.put("RED_CRBY", "'" + CRUser + "'");
         m.put("RED_REFNO", "'" + RefNo + "'");
return qg.SaveRecord("t_gvredeem", m);
    }
    

    public MGiftVoucher getSpecificVoucher(String GVNo, int isPurchaesed) throws Exception {
        String q = "SELECT * FROM m_giftvoucher WHERE GV_NO='" + GVNo + "'  ";
if(isPurchaesed>(-1)){
    q+="AND ISPUR='" + isPurchaesed + "'";
}
        
        ResultSet rs = DB.Search(q);
        MGiftVoucher gv = null;
        if (rs.next()) {
            gv = new MGiftVoucher();
            gv.setActive(rs.getByte("ACTIVE"));
            gv.setCRBy(rs.getString("CR_BY"));
            gv.setCRDate(rs.getDate("CR_DATE"));
            gv.setCRLoc(rs.getInt("CR_LOC"));
            gv.setGVNo(rs.getString("GV_NO"));
            gv.setGVValue(rs.getDouble("VALUE"));
            gv.setGrpNo(rs.getString("GRP_ID"));
            if (isPurchaesed == 1) {
                gv.setPurCrBy(rs.getString("PUR_CRBY"));
                gv.setPurDate(rs.getDate("PUR_DATE"));
                gv.setPurLoc(rs.getInt("PUR_LOC"));
                gv.setPurRefNo(rs.getString("PUR_REFNO"));
            }
            gv.setIsPurchased(rs.getByte("ISPUR"));
            gv.setGvDes(rs.getString("GV_DES"));
        }
        return gv;
    }

    public String UpdateVoucherStateQuery(MGiftVoucher g) throws Exception {

        Map<String, String> mdet = new TreeMap<>();
            //mdet.put("GRP_ID", "'" + g.getGrpId() + "'");
        //mdet.put("GV_NO", "'" + g.getGVNo() + "'");
        //mdet.put("VALUE", "'" + g.getGVvalue() + "'");
        //mdet.put("CR_LOC", "" + CurLoc + "");
        //mdet.put("CR_BY", "'" + CurUser + "'");
        // mdet.put("CR_DATE", "NOW()");
        mdet.put("PUR_LOC", "'" + g.getPurLoc() + "'");
        mdet.put("PUR_DATE", "'" + sdf.format(g.getPurDate()) + "'");
        mdet.put("PUR_CRBY", "'" + g.getPurCrBy() + "'");
        mdet.put("PUR_REFNO", "'" + g.getPurRefNo() + "'");
        mdet.put("ISPUR", "'" + 1 + "'");

        String UpdateDetQ = qg.UpdateRecord("m_giftvoucher", mdet, "WHERE GV_NO='" + g.getGVNo() + "'");
        return UpdateDetQ;
    }

    public void UpdateVoucherState(MGiftVoucher g) throws Exception {
        Connection c = DB_ACCESS.DB.getCurrentCon();
        try {
            c.setAutoCommit(false);
            Map<String, String> mdet = new TreeMap<>();
            //mdet.put("GRP_ID", "'" + g.getGrpId() + "'");
            //mdet.put("GV_NO", "'" + g.getGVNo() + "'");
            //mdet.put("VALUE", "'" + g.getGVvalue() + "'");
            //mdet.put("CR_LOC", "" + CurLoc + "");
            //mdet.put("CR_BY", "'" + CurUser + "'");
            // mdet.put("CR_DATE", "NOW()");
            mdet.put("PUR_LOC", "'" + g.getPurLoc() + "'");
            mdet.put("PUR_DATE", "'" + g.getPurDate() + "'");
            mdet.put("PUR_CRBY", "'" + g.getPurCrBy() + "'");
            mdet.put("PUR_REFNO", "'" + g.getPurRefNo() + "'");
            mdet.put("ISPUR", "'" + 1 + "'");

            String UpdateDetQ = qg.UpdateRecord("m_giftvoucher", mdet, "WHERE GV_NO='" + g.getGVNo() + "'");
            DB.Update(UpdateDetQ);
            c.commit();
        } catch (Exception e) {
            c.rollback();
            throw e;
        } finally {
            c.setAutoCommit(true);
        }
    }

    public void createVouchers(MGiftVoucherGroup g) throws Exception {
        Connection c = DB_ACCESS.DB.getCurrentCon();
        try {
            int CurLoc = GLOBALDATA.GlobalData.Setup.getCurLoc();
            String CurUser = GLOBALDATA.GlobalData.CurUser.getId();

            c.setAutoCommit(false);
            Map<String, String> mhed = new TreeMap<>();
            mhed.put("GRP_ID", "'" + g.getGrpId() + "'");
            mhed.put("GRP_NAME", "'" + g.getGrpName() + "'");
            mhed.put("GRP_STARTNO", "'" + g.getStartNo() + "'");
            mhed.put("GRP_ENDNO", "'" + g.getEndNo() + "'");
            mhed.put("GRP_QTY", "" + g.getGrpQty() + "");
            mhed.put("GRP_ACTIVE", "" + 1);

            String SaveHedQ = qg.SaveRecord("m_giftvoucher_group", mhed);
            DB.Save(SaveHedQ);

            String CurNo = g.getStartNo();
            for (int i = 0; i < g.getGrpQty(); i++) {

                Map<String, String> mdet = new TreeMap<>();
                mdet.put("GRP_ID", "'" + g.getGrpId() + "'");
                mdet.put("GV_NO", "'" + CurNo + "'");
                mdet.put("VALUE", "'" + g.getGVvalue() + "'");
                mdet.put("CR_LOC", "" + CurLoc + "");
                mdet.put("CR_BY", "'" + CurUser + "'");
                mdet.put("CR_DATE", "NOW()");
                //mdet.put("PUR_LOC", "'" +CurNo + "'");
                // mdet.put("PUR_DATE", "'" +CurNo + "'");
                //mdet.put("PUR_CRBY", "'" +CurNo + "'");
                //mdet.put("PUR_REFNO", "'" +CurNo + "'");
                mdet.put("ACTIVE", "'" + 1 + "'");

                String SaveDetQ = qg.SaveRecord("m_giftvoucher", mdet);
                DB.Save(SaveDetQ);
                CurNo = getNxtSugNo(GVLenght, Prf, CurNo);
            }

            c.commit();
        } catch (Exception e) {
            c.rollback();
            throw e;
        } finally {
            c.setAutoCommit(true);
        }

    }

    public String getBookNo() throws Exception {
        return cf.generateNextNo(5, "B", "m_giftvoucher_group", "GRP_ID");
    }

    public String getNxtVoucherNo() throws Exception {
        return cf.generateNextNo(GVLenght, Prf, "m_giftvoucher", "GV_NO");
    }

    public String getLastVoucherNo(String CurrentId, int Qty) throws Exception {

        int nextno = Integer.parseInt(CurrentId.substring(Prf.length())) + Qty;
        String ID = Prf;
        for (int i = 0; i < (GVLenght - Prf.length() - ("" + nextno).length()); i++) {
            ID += "0";
        }
        ID += nextno;
        return ID;
    }

    public Vector<String> getVoucherSugList(int length, String prf, String CurrentId, int Qty) {
        Vector<String> v = new Vector<>();
        for (int i = 0; i < Qty; i++) {
            String curId = "";
            if (i == 0) {
                curId = getNxtSugNo(length, prf, CurrentId);
                v.add(curId);
            } else {
                curId = getNxtSugNo(length, prf, curId);
                v.add(curId);

            }

        }
        return v;
    }

    private String getNxtSugNo(int length, String prf, String CurrentId) {
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

}
