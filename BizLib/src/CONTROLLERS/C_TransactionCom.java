/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import COMMONFUN.CommonFun;
import DB_Access.DB;
import MODELS.MCustomer;
import MODELS.MLocation;
import MODELS.MProducts;
import MODELS.MSupplier;
import MODELS.TStockline;
import MODELS.TStockmst;
import MODELS.TStockpayments;
import MODELS.UTransactions;
import QUERYBUILDER.QueryGen;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Buwanaka
 */
public class C_TransactionCom {

    QueryGen qg = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf_trnformat = new SimpleDateFormat("yyMM");

    CommonFun cf = null;
    C_Products C_Pro = null;
    C_Units C_units = null;
    C_Users CUsers = null;
    C_Suppliers CSupplier = null;
    C_Customers CCustomer = null;
    C_Locations CLoc = null;

    public C_TransactionCom() {
        qg = new QueryGen();
        cf = new CommonFun();
        C_Pro = new C_Products();
        C_units = new C_Units();
        CUsers = new C_Users();
        CSupplier = new C_Suppliers();
        CCustomer = new C_Customers();
        CLoc = new C_Locations();
    }

    public String getNxtTrnNo(String TrnTyp) throws Exception {

        return cf.generateNextNo(10, sdf_trnformat.format(new Date()), "T_STOCKMST", "ID", "WHERE TRNTYPE='" + TrnTyp + "'");
    }

    public void UpdateTransactionBatch(String MstId, String ProCode, String Batch) throws Exception {
        String q = "UPDATE T_STOCKLINE SET BATCH_NO='" + Batch + "' WHERE T_STOCKMST_ID='" + MstId + "' AND PROID='" + ProCode + "' ";
        System.out.println(q);
        DB.Update(q);
    }

    private void removeTransaction(String TrnNo, String TrnTyp) throws Exception {
        Connection c = DB.getCurrentCon();

        try {
            c.setAutoCommit(false);
            String Qhed = "DELETE FROM T_STOCKMST WHERE ID='" + TrnNo + "' AND TRNTYPE='" + TrnTyp + "'  ";
            // System.out.println();
            DB.Delete(Qhed, c);
            String Qdet = "DELETE FROM T_STOCKLINE WHERE T_STOCKMST_ID='" + TrnNo + "' AND TRNTYP='" + TrnTyp + "' ";
            DB.Delete(Qdet, c);
            c.commit();

        } catch (Exception e) {
            c.rollback();
            throw e;
        } finally {
            c.setAutoCommit(true);
        }

    }

    public TStockmst getStockHed(String TrnNo, UTransactions TrnTyp) throws Exception {
        String q = "SELECT * FROM T_STOCKMST WHERE ID='" + TrnNo + "' AND TRNTYPE='" + TrnTyp.getTrntype() + "' ";
        System.out.println(q);
        ResultSet rs = DB.Search(q);

        TStockmst sthed = null;
        if (rs.next()) {
            sthed = new TStockmst();
            sthed.setId(rs.getString("ID"));
            sthed.setUTransactions(TrnTyp);
            sthed.setFullutilize(rs.getByte("FULLUTILIZE"));
            sthed.setCrdate(rs.getDate("CRDATE"));
            sthed.setMUserByMUserCr(CUsers.getUser(rs.getString("M_USER_CR")));
            sthed.setMUserByMUserMd(CUsers.getUser(rs.getString("M_USER_MD")));
            sthed.setMddate(rs.getDate("MDDATE"));
            sthed.setRefno(rs.getString("REFNO"));
            sthed.setRefno2(rs.getString("REFNO2"));
            sthed.setRefnote(rs.getString("REFNOTE"));
            sthed.setIsactive(rs.getByte("ISACTIVE"));
            sthed.setTrnstate(rs.getString("TRNSTATE"));
            sthed.setGramount(rs.getDouble("GRAMOUNT"));
            sthed.setNetdis(rs.getDouble("NETDIS"));
            sthed.setNetamount(rs.getDouble("NETAMOUNT"));
            MCustomer cus = (rs.getString("M_CUSTOMER_ID") != null && !rs.getString("M_CUSTOMER_ID").equals("")) ? CCustomer.getCustomer(rs.getString("M_CUSTOMER_ID")) : null;
            sthed.setMCustomer(cus);

            MSupplier sup = (rs.getString("M_SUPPLIER_ID") != null && !rs.getString("M_SUPPLIER_ID").equals("")) ? CSupplier.getSupplier(rs.getString("M_SUPPLIER_ID")) : null;
            sthed.setMSupplier(sup);

            MLocation LocSource = (rs.getString("M_LOCATION_SOURCE") != null && !rs.getString("M_LOCATION_SOURCE").equals("")) ? CLoc.getLocation(rs.getString("M_LOCATION_SOURCE")) : null;
            sthed.setMLocationByMLocationSource(LocSource);

            MLocation LocDes = (rs.getString("M_LOCATION_DEST") != null && !rs.getString("M_LOCATION_DEST").equals("")) ? CLoc.getLocation(rs.getString("M_LOCATION_DEST")) : null;
            sthed.setMLocationByMLocationDest(LocDes);

            sthed.setEftDate(rs.getDate("EFT_DATE"));
            sthed.setRefTrnNo(rs.getString("REF_TRNNO"));
            sthed.setChange(rs.getDouble("CHANGE"));

        }
        return sthed;
    }

    public ArrayList<TStockline> getStockLine(String TrnNo, UTransactions TrnTyp) throws Exception {
        String q = "SELECT * FROM T_STOCKLINE WHERE T_STOCKMST_ID='" + TrnNo + "' AND TRNTYP='" + TrnTyp.getTrntype() + "' ";
        System.out.println(q);
        ResultSet rs = DB.Search(q);

        ArrayList<TStockline> ar = new ArrayList<>();
        while (rs.next()) {
            TStockline st = new TStockline();
            st.setTStockmst(getStockHed(TrnNo, TrnTyp));
            st.setLineNo(rs.getInt("LINEID"));
            st.setProId(rs.getString("PROID"));
            st.setSprice(rs.getDouble("SPRICE"));
            st.setCprice(rs.getDouble("CPRICE"));
            st.setQty(rs.getDouble("QTY"));
            st.setLdis(rs.getDouble("LDIS"));
            st.setLdisper(rs.getDouble("LDISPER"));
            st.setAmount(rs.getDouble("AMOUNT"));
            st.setUnitId(rs.getString("M_UNITS_ID"));
            st.setUnitGroupId(rs.getString("M_UNITGROUPS_ID"));
            st.setProname(rs.getString("PRONAME"));
            st.setBatch((rs.getString("BATCH_NO") == null ? "" : rs.getString("BATCH_NO")));
            st.setUTransactions(TrnTyp);
            ar.add(st);
        }

        return ar;
    }

    public String saveTransaction(TStockmst hedc, ArrayList<TStockline> det, ArrayList<TStockpayments> paydet) throws Exception {
        String TrnNo = "";
        Connection c = null;
        try {

            TStockmst hed = hedc;

            if (!hed.getId().equals("")) {
                TStockmst stockHed = getStockHed(hed.getId(), hed.getUTransactions());
                if (stockHed != null && stockHed.getTrnstate().equals("H")) {
                    removeTransaction(hed.getId(), hed.getUTransactions().getTrntype());
                    hed.setCrdate(stockHed.getMddate());
                    hed.setMUserByMUserCr(stockHed.getMUserByMUserMd());

                } else {
                    if (stockHed == null) {
                        throw new Exception("Invalid Transaction no:" + hed.getId() + ",This no is not exists in the system");
                    } else if (!stockHed.getTrnstate().equals("H")) {
                        throw new Exception("Invalid Transaction no:" + hed.getId() + ",This is not a Hold Transaction");

                    }
                }
            } else {
                hed.setId(getNxtTrnNo(hed.getUTransactions().getTrntype()));
            }

            c = DB_Access.DB.getCurrentCon();
            c.setAutoCommit(false);

            Map<String, String> hedMap = new TreeMap<>();

            hedMap.put("ID", "'" + hed.getId() + "'");
            hedMap.put("TRNTYPE", "'" + hed.getUTransactions().getTrntype() + "'");
            hedMap.put("FULLUTILIZE", "'" + hed.getFullutilize() + "'");
            hedMap.put("CRDATE", "'" + sdf.format(hed.getCrdate()) + "'");
            hedMap.put("M_USER_CR", "'" + hed.getMUserByMUserCr().getId() + "'");
            hedMap.put("M_USER_MD", "'" + hed.getMUserByMUserMd().getId() + "'");
            hedMap.put("MDDATE", "'" + sdf.format(hed.getMddate()) + "'");
            hedMap.put("REFNO", "'" + hed.getRefno() + "'");
            hedMap.put("REFNO2", "'" + hed.getRefno2() + "'");
            hedMap.put("REFNOTE", "'" + hed.getRefnote() + "'");
            hedMap.put("ISACTIVE", "'" + hed.getIsactive() + "'");
            hedMap.put("TRNSTATE", "'" + hed.getTrnstate() + "'");
            hedMap.put("GRAMOUNT", "'" + hed.getGramount() + "'");
            hedMap.put("NETDIS", "'" + hed.getNetdis() + "'");
            hedMap.put("NETAMOUNT", "'" + hed.getNetamount() + "'");
            hedMap.put("M_CUSTOMER_ID", "'" + (hed.getMCustomer() != null ? hed.getMCustomer().getId() : "") + "'");
            hedMap.put("M_SUPPLIER_ID", "'" + (hed.getMSupplier() != null ? hed.getMSupplier().getId() : "") + "'");
            hedMap.put("M_LOCATION_SOURCE", "'" + (hed.getMLocationByMLocationSource() != null ? hed.getMLocationByMLocationSource().getId() : 0) + "'");
            hedMap.put("M_LOCATION_DEST", "'" + (hed.getMLocationByMLocationDest() != null ? hed.getMLocationByMLocationDest().getId() : 0) + "'");
            hedMap.put("EFT_DATE", "'" + sdf.format(hed.getEftDate() != null ? hed.getEftDate() : new Date()) + "'");
            hedMap.put("REF_TRNNO", "'" + hed.getRefTrnNo() + "'");
            hedMap.put("CHANGE", "" + hed.getChange());
            String qHed = qg.SaveRecord("T_STOCKMST", hedMap);
            DB.Save(qHed, c);

            for (TStockline d : det) {
                Map<String, String> detMap = new TreeMap<>();
                detMap.put("T_STOCKMST_ID", "'" + hed.getId() + "'");
                detMap.put("LINEID", "'" + d.getLineNo() + "'");
                detMap.put("PROID", "'" + d.getProId() + "'");
                detMap.put("TRNTYP", "'" + d.getUTransactions().getTrntype() + "'");
                detMap.put("SPRICE", "'" + d.getSprice() + "'");
                detMap.put("CPRICE", "'" + d.getCprice() + "'");
                detMap.put("QTY", "'" + d.getQty() + "'");
                detMap.put("LDIS", "'" + d.getLdis() + "'");
                detMap.put("LDISPER", "'" + d.getLdisper() + "'");
                detMap.put("AMOUNT", "'" + d.getAmount() + "'");
                detMap.put("M_UNITS_ID", "'" + d.getUnitId() + "'");
                detMap.put("M_UNITGROUPS_ID", "'" + d.getUnitGroupId() + "'");
                detMap.put("PRONAME", "'" + d.getProname() + "'");
                detMap.put("BATCH_NO", "'" + d.getBatch() + "'");

                String qDet = qg.SaveRecord("T_STOCKLINE", detMap);
                DB.Save(qDet, c);

                double unitConversion = C_Pro.getUnitConversion(d.getProId(), d.getUnitId());

                int StockEntryTyp = hed.getUTransactions().getStockentyp();
                if (hedc.getTrnstate().equals("C")) {
                    StockEntryTyp = hed.getUTransactions().getStockentyp() * (-1);
                }

                double ConvertedQty = (d.getQty() / unitConversion) * StockEntryTyp;
                if (!hedc.getTrnstate().equals("H")) {
                    if (hed.getUTransactions().getBatchcreate() == 1) {
                        MProducts product = C_Pro.getProduct(d.getProId());

                        boolean CanBatchCreate = ((product.getCprice().equals(d.getCprice()) == false) || (product.getSprice().equals(d.getSprice()) == false)) ? true : false;
                        if (CanBatchCreate) {
                            String CreateBatch = C_Pro.CreateBatch(d.getProId(), d.getCprice(), d.getSprice(), hed.getMLocationByMLocationSource(), Boolean.TRUE, C_units.getBaseUnitId(product.getUnitGroupId()), ConvertedQty);
                            UpdateTransactionBatch(hed.getId(), d.getProId(), CreateBatch);
                        } else {
                            String LastBatch = C_Pro.getLastBatch(d.getProId(), hed.getMLocationByMLocationSource().getId().toString());
                            C_Pro.updateSpecificBatch(d.getProId(), d.getCprice(), d.getSprice(), hed.getMLocationByMLocationSource(), LastBatch, C_units.getBaseUnitId(product.getUnitGroupId()), ConvertedQty);
                            UpdateTransactionBatch(hed.getId(), product.getId(), LastBatch);
                        }
                    } else {
                        MProducts product = C_Pro.getProduct(d.getProId());
                        C_Pro.updateSpecificBatch(d.getProId(), d.getCprice(), d.getSprice(), hed.getMLocationByMLocationSource(), d.getBatch(), C_units.getBaseUnitId(product.getUnitGroupId()), ConvertedQty);
                        UpdateTransactionBatch(hed.getId(), product.getId(), d.getBatch());

                    }
                } else {
                    if (hed.getUTransactions().getBatchcreate() == 0) {

                        String LastBatch = C_Pro.getLastBatch(d.getProId(), hed.getMLocationByMLocationSource().getId().toString());
                        C_Pro.updateSpecificBatch(d.getProId(), d.getCprice(), d.getSprice(), hed.getMLocationByMLocationSource(), LastBatch, C_units.getBaseUnitId(d.getUnitGroupId()), ConvertedQty);
                        UpdateTransactionBatch(hed.getId(), d.getProId(), LastBatch);
                    }
                }
            }

            if (paydet != null) {
                for (TStockpayments pay : paydet) {
                    Map<String, String> payMap = new TreeMap<>();
                    payMap.put("ID", "" + pay.getId());
                    payMap.put("T_STOCKMST_ID", "'" + pay.getTStockmst().getId() + "'");
                    payMap.put("REFNO", "'" + pay.getRefno() + "'");
                    payMap.put("FRMAMOUNT", "'" + pay.getFrmamount() + "'");
                    payMap.put("AMOUNT", "'" + pay.getAmount() + "'");
                    payMap.put("CHANGE", "'" + pay.getChange() + "'");
                    payMap.put("PAYDETID", "'" + pay.getMPaydetId() + "'");
                    payMap.put("PAYHEDID", "'" + pay.getMPayHedId() + "'");
                    payMap.put("EFT_DATE", "'" + (pay.getMPayHedId().equals("CHQ") ? "1900-01-01" : pay.getEfectiveDate()) + "'");
                    payMap.put("TRNTYP", "'" + pay.getUTransactions().getTrntype() + "'");
                    payMap.put("UTILIZED", "'" + pay.getUtilized() + "'");
                    
                    String q = qg.SaveRecord("T_STOCKPAYMENTS", payMap);
                    DB.Save(q);

                    if (pay.getMPayHedId().equals("CHQ")) {
                        Map<String, String> payChq = new TreeMap<>();
                        payChq.put("CHQ_NO", "'" + pay.getRefno() + "'");
                        payChq.put("CHQ_DATE", "'" + pay.getEfectiveDate() + "'");
                        payChq.put("STATE", "'P'");//P-Pending , U-Utilized,Returned-Returned
                        payChq.put("REFNO", "'" + pay.getTStockmst().getId() + "'");
                        payChq.put("REFTRNTYP", "'" + pay.getTStockmst().getUTransactions().getTrntype() + "'");
                        if (pay.getTStockmst().getMCustomer() != null) {
                            payChq.put("CUS_ID", "'" + pay.getTStockmst().getMCustomer().getId() + "'");
                        }
                        if (pay.getTStockmst().getMSupplier() != null) {
                            payChq.put("SUP_ID", "'" + pay.getTStockmst().getMSupplier().getId() + "'");
                        }
                        payChq.put("AMOUNT", "'" + pay.getAmount() + "'");
                        payChq.put("M_USER_CR", "'" + pay.getTStockmst().getMUserByMUserCr().getId() + "'");
                        payChq.put("CRDATE", "'" + sdf.format(pay.getTStockmst().getCrdate()) + "'");

                        String qq = qg.SaveRecord("T_CHQPAYMENTS", payChq);
                        DB.Save(qq);
                    }
                }
            }

            TrnNo = hed.getId();
            c.commit();

        } catch (Exception e) {
            TrnNo = "";
            if (c != null) {
                c.rollback();
            }
            throw e;
        } finally {
            if (c != null) {

                c.setAutoCommit(true);

            }
        }
        return TrnNo;
    }

}
