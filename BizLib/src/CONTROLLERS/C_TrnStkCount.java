/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import COMMONFUN.CommonFun;
import DB_ACCESS.DB;
import MODELS.TPhystkdet;
import MODELS.TPhystkmst;
import MODELS.TStockmst;
import QUERYBUILDER.QueryGen;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author user pc
 */
public class C_TrnStkCount {

    QueryGen qg = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf_trnformat = new SimpleDateFormat("yyMM");

    CommonFun cf = null;
    C_Products C_Pro = null;
    C_Units C_units = null;
    C_Users CUsers = null;

    C_Locations CLoc = null;

    public C_TrnStkCount() {
        qg = new QueryGen();
        cf = new CommonFun();
        C_Pro = new C_Products();
        C_units = new C_Units();
        CUsers = new C_Users();

        CLoc = new C_Locations();

    }

    public String getNxtTrnNo(String TrnTyp, String LocId, String TermId) throws Exception {

        return cf.generateNextNo(12, (LocId.length() > 1 ? LocId : "0" + LocId) + (TermId.length() > 1 ? TermId : "0" + TermId) + sdf_trnformat.format(new Date()), "t_phystkmst", "ID", "");
    }

    public TPhystkmst getPhyStockHed(String Id) {
        return null;
    }

    private void removeTransaction(String TrnNo) throws Exception {
        Connection c = DB.getCurrentCon();

        try {
            c.setAutoCommit(false);
            String Qhed = "DELETE FROM T_STOCKMST WHERE ID='" + TrnNo + "'  ";
            // System.out.println();
            DB.Delete(Qhed);
            String Qdet = "DELETE FROM T_STOCKLINE WHERE T_STOCKMST_ID='" + TrnNo + "'  ";
            DB.Delete(Qdet);
            c.commit();

        } catch (Exception e) {
            c.rollback();
            throw e;
        } finally {
            c.setAutoCommit(true);
        }

    }

    public String savePhyStock(TPhystkmst mst, ArrayList<TPhystkdet> ar_det) throws Exception {
        String trnno = "";
        try {
            TPhystkmst hed = mst;

            if (!hed.getId().equals("")) {
                TPhystkmst stockHed = getPhyStockHed(hed.getId());
                if (stockHed != null && stockHed.getTrnstate().equals("H")) {
                    removeTransaction(hed.getId());

                } else if (stockHed == null) {
                    throw new Exception("Invalid Transaction no:" + hed.getId() + ",This no is not exists in the system");
                } else if (!stockHed.getTrnstate().equals("H")) {
                    throw new Exception("Invalid Transaction no:" + hed.getId() + ",This is not a Hold Transaction");

                }
            } else {
                hed.setId(getNxtTrnNo("PHY", "" + (hed.getMLocation() != null ? hed.getMLocation().getId() : 0), "01"));
            }
            DB.getCurrentCon().setAutoCommit(false);

            Map<String, String> mhed = new TreeMap<>();
            mhed.put("ID", "'" + trnno + "'");
            mhed.put("CRDATE", "NOW()");
            mhed.put("M_USER_CR", "'" + mst.getMUserByMUserCr().getId() + "'");
            mhed.put("MDDATE", "NOW()");
            mhed.put("M_USER_MD", "'" + mst.getMUserByMUserCr().getId() + "'");
            mhed.put("M_LOCATION_ID", "'" + (hed.getMLocation() != null ? hed.getMLocation().getId() : 0) + "'");
            mhed.put("ISACTIVE", "'" + hed.getIsactive() + "'");
            mhed.put("TRNSTATE", "'" + hed.getTrnstate() + "'");

            DB.Save(qg.SaveRecord("t_phystkmst", mhed));

            int i = 1;
            for (TPhystkdet det : ar_det) {
                Map<String, String> mdet = new TreeMap<>();
                mdet.put("ID", "'" + i + "'");
                mdet.put("T_PHYSTKMST_ID", "'" + trnno + "'");
                mdet.put("SYSQTY", "'" + det.getSysqty() + "'");
                mdet.put("PHYQTY", "'" + 0 + "'");
                mdet.put("CPRICE", "'" + 0 + "'");
                mdet.put("SPRICE", "'" + 0 + "'");
                mdet.put("PROID", "'" + det.getProid() + "'");
                mdet.put("M_UNITS_ID", "'" + det.getMUnitSys().getId()+ "'");
                mdet.put("M_UNITGROUPS_ID", "'" + det.getMUnitGrp().getUnitGroupId() + "'");
                
                DB.Save(qg.SaveRecord("t_phystkdet", mdet));
                

                i++;
            }

            DB.getCurrentCon().commit();
        } catch (Exception e) {
            trnno = "";
            DB.getCurrentCon().rollback();
        } finally {
            DB.getCurrentCon().setAutoCommit(true);
        }
        return trnno;
    }

}
