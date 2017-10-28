/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import COMMONFUN.CommonFun;
import DB_ACCESS.DB;
import MODELS.MLocation;
import MODELS.MProductPropertise;
import MODELS.MProducts;
import MODELS.MStocks;
import MODELS.MSupplier;
import QUERYBUILDER.QueryGen;
import VALIDATIONS.MyValidator;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author HOME
 */
public class C_Products {

    QueryGen qg = null;
    CommonFun CommFun = null;
    MyValidator fv = null;
    C_Locations l = null;
    C_Units cUnits = null;
    C_Suppliers CSup = null;

    public C_Products() {
        qg = new QueryGen();
        CommFun = new CommonFun();
        fv = new MyValidator();
        l = new C_Locations();
        cUnits = new C_Units();
        CSup = new C_Suppliers();
    }

    public void createStocksForProduct(MProducts p, Boolean createBatch, String BaseUnitId) throws Exception {
        createStocksForProduct(p, createBatch, BaseUnitId, 0.0);
    }

    public void createStocksForProduct(MProducts p, Boolean createBatch, String BaseUnitId, Double Qty) throws Exception {

        ArrayList<MLocation> allLocations = l.getAllLocations();
        for (MLocation mLocation : allLocations) {
            Map<String, String> Mstk = new TreeMap<String, String>();
            Mstk.put("M_LOCATION_ID", "" + mLocation.getId());
            Mstk.put("M_PRODUCTS_ID", "'" + p.getId() + "'");
            String Batch = "";
            if (createBatch) {
                Batch = getNextBatch(p.getId(), "" + mLocation.getId());

            } else {
                Batch = getLastBatch(p.getId(), "" + mLocation.getId());
            }
            Mstk.put("BATCHNO", "'" + Batch + "'");
            Mstk.put("COSTP", "" + p.getCprice());
            Mstk.put("SELLP", "" + p.getSprice());
            Mstk.put("CRDATE", "NOW()");
            Mstk.put("M_UNITS_ID", "'" + BaseUnitId + "'");
            Mstk.put("SIH", "" + Qty + "");
            Mstk.put("MARKUP", "" + p.getMarkup());

            if (IsBatchExists(p.getId(), mLocation.getId().toString(), Batch) == false) {

                DB.Save(qg.SaveRecord("M_STOCKS", Mstk));
            } else {
                Mstk.put("SIH", "SIH+" + Qty + "");
                DB.Update(qg.UpdateRecord("M_STOCKS", Mstk, "WHERE M_LOCATION_ID=" + mLocation.getId() + " AND M_PRODUCTS_ID='" + p.getId() + "' AND BATCHNO='" + Batch + "'"));
            }

        }

    }

    public String CreateBatch(String ProId, double Cost, double Sell, MLocation Loc, Boolean createBatch, String BaseUnitId, Double Qty) throws Exception {
        String BatchNo = "";
        Map<String, String> Mstk = new TreeMap<String, String>();
        Mstk.put("M_LOCATION_ID", "" + Loc.getId());
        Mstk.put("M_PRODUCTS_ID", "'" + ProId + "'");
        String Batch = "";
        if (createBatch) {
            Batch = getNextBatch(ProId, "" + Loc.getId());

        } else {
            Batch = getLastBatch(ProId, "" + Loc.getId());
        }
        Mstk.put("BATCHNO", "'" + Batch + "'");
        Mstk.put("COSTP", "" + Cost);
        Mstk.put("SELLP", "" + Sell);
        Mstk.put("CRDATE", "NOW()");
        Mstk.put("M_UNITS_ID", "'" + BaseUnitId + "'");
        Mstk.put("SIH", "" + Qty + "");
        Mstk.put("ACTIVE", "" + 1 + "");
        

        if (IsBatchExists(ProId, Loc.getId().toString(), Batch) == false) {
            Mstk.put("MARKUP", "" + 0.0);
            DB.Save(qg.SaveRecord("M_STOCKS", Mstk));
        } else {
            Mstk.put("SIH", "SIH+" + Qty + "");
            DB.Update(qg.UpdateRecord("M_STOCKS", Mstk, "WHERE M_LOCATION_ID=" + Loc.getId() + " AND M_PRODUCTS_ID='" + ProId + "' AND BATCHNO='" + Batch + "'"));
        }
        BatchNo = Mstk.get("BATCHNO");
        return BatchNo;
    }

    public void updateSpecificBatch(String ProId, double Cost, double Sell, MLocation Loc, String BatchNo, String BaseUnitId, Double Qty) throws Exception {
        Map<String, String> Mstk = new TreeMap<String, String>();
        Mstk.put("M_LOCATION_ID", "" + Loc.getId());
        Mstk.put("M_PRODUCTS_ID", "'" + ProId + "'");
        String Batch = BatchNo;

        Mstk.put("BATCHNO", "'" + Batch + "'");
        Mstk.put("COSTP", "" + Cost);
        Mstk.put("SELLP", "" + Sell);
        Mstk.put("CRDATE", "NOW()");
        Mstk.put("M_UNITS_ID", "'" + BaseUnitId + "'");
        Mstk.put("SIH", "" + Qty + "");
        
        if (IsBatchExists(ProId, Loc.getId().toString(), Batch)) {

            Mstk.put("SIH", "SIH+" + Qty + "");
            DB.Update(qg.UpdateRecord("M_STOCKS", Mstk, "WHERE M_LOCATION_ID=" + Loc.getId() + " AND M_PRODUCTS_ID='" + ProId + "' AND BATCHNO='" + Batch + "'"));
        }

    }

    public String getNextBatch(String ProId, String LocId) throws Exception {
        return CommFun.generateNextNo(4, "", "M_STOCKS", "BATCHNO", "WHERE M_LOCATION_ID='" + LocId + "' AND M_PRODUCTS_ID='" + ProId + "'");
    }

    public String getLastBatch(String ProId, String LocId) throws Exception {
        return CommFun.generateLastNo(4, "", "M_STOCKS", "BATCHNO", "WHERE M_LOCATION_ID='" + LocId + "' AND M_PRODUCTS_ID='" + ProId + "'");
    }

    public boolean IsBatchExists(String ProId, String LocId, String Batch) throws Exception {
        String q = "SELECT M_PRODUCTS_ID FROM M_STOCKS WHERE M_LOCATION_ID='" + LocId + "' AND M_PRODUCTS_ID='" + ProId + "' AND  BATCHNO='" + Batch + "'";

        ResultSet rs = DB.Search(q);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<MStocks> getAllBatches(String ProId) throws Exception {
        return getAllBatches(ProId,"",-1);
     }
     public ArrayList<MStocks> getAllBatches(String ProId, String LocId) throws Exception {
        return getAllBatches(ProId,LocId,-1);
     }
    
    public ArrayList<MStocks> getAllBatches(String ProId, String LocId,int StockAvaialbleOnly) throws Exception {
        String q = "SELECT * FROM M_STOCKS WHERE M_PRODUCTS_ID='" + ProId + "' AND ACTIVE=1 ";
        
        if(!LocId.equals("")){
            q+=" AND M_LOCATION_ID='" + LocId + "' ";
        }
        if(StockAvaialbleOnly==0 ||  StockAvaialbleOnly==1){
            if(StockAvaialbleOnly==0){
                 q+=" AND SIH<=0";
            }else{
                q+=" AND SIH>0";
            }
           
        }
        
        System.out.println(q);
        ResultSet rs = DB.Search(q);

        ArrayList<MStocks> ar = new ArrayList<>();
        while (rs.next()) {
            MStocks s = new MStocks();
            s.setProId(rs.getString("M_PRODUCTS_ID"));
            s.setLocId(rs.getString("M_LOCATION_ID"));
            s.setBatchNo(rs.getString("BATCHNO"));
            s.setCostPrice(rs.getDouble("COSTP"));
            s.setSellPrice(rs.getDouble("SELLP"));
            s.setSIH(rs.getDouble("SIH"));
            s.setMarkup(rs.getDouble("MARKUP"));
            s.setUnitId(rs.getString("M_UNITS_ID"));
            s.setActive(rs.getInt("ACTIVE"));
            ar.add(s);
        }
        return ar;
    }

    public MStocks getSpecificBatch(String ProId, String LocId, String BatchNo) throws Exception {
        String q = "SELECT * FROM M_STOCKS WHERE M_LOCATION_ID='" + LocId + "' AND M_PRODUCTS_ID='" + ProId + "' AND BATCHNO='" + BatchNo + "' ";
        ResultSet rs = DB.Search(q);

        MStocks s = null;
        if (rs.next()) {
            s = new MStocks();
            s.setProId(rs.getString("M_PRODUCTS_ID"));
            s.setLocId(rs.getString("M_LOCATION_ID"));
            s.setBatchNo(rs.getString("BATCHNO"));
            s.setCostPrice(rs.getDouble("COSTP"));
            s.setSellPrice(rs.getDouble("SELLP"));
            s.setSIH(rs.getDouble("SIH"));
            s.setMarkup(rs.getDouble("MARKUP"));

        }
        return s;
    }

    public MProducts getProduct(String ProId) throws Exception {

        return getProduct(ProId, -1);
    }

    public MProducts getProduct(String ProId, int Active) throws Exception {
        MProducts p = null;
        if (ProId != null && !ProId.equals("")) {
            String q = "SELECT * FROM m_products WHERE ID='" + fv.replacer(ProId) + "' ";
            if (Active == 0 || Active == 1) {
                q += " AND  ACTIVE=" + Active;
            }
            ResultSet rs = DB.Search(q);

            if (rs.next()) {
                p = new MProducts();
                p.setId(rs.getString("ID"));
                p.setName(rs.getString("NAME"));
                p.setPrintdes(rs.getString("PRINTDES"));
                p.setBatch(rs.getByte("BATCH"));
                p.setActive(rs.getByte("ACTIVE"));
                MStocks lastBatch = getLastBatch(p.getId());
                p.setSprice(lastBatch.getSellPrice());
                p.setMarkup(lastBatch.getMarkup());
                p.setCprice(lastBatch.getCostPrice());
                p.setMGroup1(rs.getString("M_GROUP1_ID"));
                p.setMGroup2(rs.getString("M_GROUP2_ID"));
                p.setMGroup3(rs.getString("M_GROUP3_ID"));
                p.setMGroup4(rs.getString("M_GROUP4_ID"));
                p.setMGroup5(rs.getString("M_GROUP5_ID"));
                p.setRef1(rs.getString("REF1"));
                p.setRef2(rs.getString("REF2"));
                p.setUnitGroupId(rs.getString("M_UNITGROUPS_ID"));
            }
        }
        return p;
    }

    public Vector<MProductPropertise> getProductPropertise(String ProId) throws Exception {
        String Q = "SELECT * FROM m_products_has_m_propertise WHERE M_PRODUCTS_ID='" + fv.replacer(ProId) + "'";
        ResultSet rs = DB.Search(Q);
        Vector<MProductPropertise> VPro = new Vector<>();
        while (rs.next()) {
            MProductPropertise ProProp = new MProductPropertise();
            ProProp.setProductId(rs.getString("M_PRODUCTS_ID"));
            ProProp.setPropertyId(rs.getString("M_PROPERTISE_ID"));
            ProProp.setPropertyValue(rs.getString("VALUE"));
            VPro.add(ProProp);
        }
        return VPro;
    }

    public void removeAllProductPropertise(String ProId) throws Exception {
        String q = "DELETE FROM m_products_has_m_propertise WHERE M_PRODUCTS_ID='" + fv.replacer(ProId) + "'";
        DB.Delete(q);
    }

    public void AddProductPropertise(String ProId, Vector<MProductPropertise> proprop) throws Exception {
        removeAllProductPropertise(ProId);
        for (MProductPropertise prop : proprop) {
            Map<String, String> mpro = new TreeMap<String, String>();
            mpro.put("M_PRODUCTS_ID", "'" + ProId + "'");
            mpro.put("M_PROPERTISE_ID", "'" + prop.getPropertyId() + "'");
            mpro.put("VALUE", "'" + prop.getPropertyValue() + "'");
            String SaveRecord = qg.SaveRecord("m_products_has_m_propertise", mpro);
            DB.Save(SaveRecord);
        }
    }

    public void saveProductSuppliers(String ProId, Vector<MSupplier> Suppliers) throws Exception {
        for (MSupplier S : Suppliers) {
            Map<String, String> mpro = new TreeMap<String, String>();
            mpro.put("M_SUPPLIER_ID", "'" + S.getId() + "'");
            mpro.put("M_PRODUCTS_ID", "'" + ProId + "'");
            mpro.put("ACTIVE", "'" + 1 + "'");
            String SaveRecord = qg.SaveRecord("M_SUPPLIER_HAS_M_PRODUCTS", mpro);
            DB.Save(SaveRecord);
        }

    }

    public Vector<MSupplier> getAllSuppliers(String ProId) throws Exception {
        String q = "SELECT M_SUPPLIER_ID FROM M_SUPPLIER_HAS_M_PRODUCTS WHERE M_PRODUCTS_ID='" + ProId + "'";
        ResultSet rs = DB.Search(q);
        Vector<MSupplier> v = new Vector<>();
        while (rs.next()) {
            v.add(CSup.getSupplier(rs.getString("M_SUPPLIER_ID")));
        }
        return v;
    }

    public MStocks getLastBatch(String ProId) throws Exception {
        String q = "SELECT * FROM M_STOCKS WHERE M_PRODUCTS_ID='" + ProId + "' ORDER BY BATCHNO DESC ";
        ResultSet rs = DB.Search(q);
        MStocks s = null;
        if (rs.next()) {
            s = new MStocks();
            s.setBatchNo(rs.getString("BATCHNO"));
            s.setCostPrice(rs.getDouble("COSTP"));
            s.setSellPrice(rs.getDouble("SELLP"));
            s.setMarkup(rs.getDouble("MARKUP"));
            s.setLocId(rs.getString("M_LOCATION_ID"));
            s.setProId(rs.getString("M_PRODUCTS_ID"));
            s.setSIH(rs.getDouble("SIH"));
        }
        return s;
    }
    
   

    public String addProduct(MProducts p, Vector<MProductPropertise> proprop, Vector<MSupplier> Suppliers) throws Exception {
        String status = "";
        Map<String, String> mpro = new TreeMap<String, String>();
        mpro.put("NAME", "'" + fv.replacer(p.getName()) + "'");
        mpro.put("PRINTDES", "'" + fv.replacer(p.getPrintdes()) + "'");
        mpro.put("BATCH", p.getBatch().toString());
        mpro.put("ACTIVE", p.getActive().toString());
        mpro.put("M_UNITGROUPS_ID", "'" + p.getUnitGroupId() + "'");
        mpro.put("MDDATE", "NOW()");
        mpro.put("MDUSER", "'" + p.getMUserByMduser() + "'");
        mpro.put("M_GROUP1_ID", "'" + p.getMGroup1() + "'");
        mpro.put("M_GROUP2_ID", "'" + p.getMGroup2() + "'");
        mpro.put("M_GROUP3_ID", "'" + p.getMGroup3() + "'");
        mpro.put("M_GROUP4_ID", "'" + p.getMGroup4() + "'");
        mpro.put("M_GROUP5_ID", "'" + p.getMGroup5() + "'");
        mpro.put("REF1", "'" + fv.replacer(p.getRef1()) + "'");
        mpro.put("REF2", "'" + fv.replacer(p.getRef2()) + "'");

        String GenIdProId = CommFun.generateNextNo(6, "", "m_products", "ID");
        String ProId = GenIdProId;

        if (!p.getId().equals("")) {
            MProducts product = getProduct(p.getId());
            if (product == null) {
                throw new Exception("Product  not found for given Id " + p.getId());
            } else {
                ProId = p.getId();
            }
        }

        mpro.put("ID", "'" + ProId + "'");
        try {
            DB.getCurrentCon().setAutoCommit(false);
            if (GenIdProId.equals(ProId)) {
                mpro.put("CRDATE", "NOW()");
                mpro.put("CRUSER", "'" + p.getMUserByMduser() + "'");
                String Q_ProSave = qg.SaveRecord("m_products", mpro);
                DB.Save(Q_ProSave);
                p.setId(ProId);
                createStocksForProduct(p, false, cUnits.getBaseUnitId(p.getUnitGroupId()));
                AddProductPropertise(ProId, proprop);

                String q1 = "DELETE FROM M_SUPPLIER_HAS_M_PRODUCTS WHERE M_PRODUCTS_ID='" + ProId + "' ";
                DB.Delete(q1);
                saveProductSuppliers(ProId, Suppliers);
                status = "Product Save Success!";
            } else {
                //Update
                String Q_ProUpdate = qg.UpdateRecord("m_products", mpro, " WHERE ID='" + ProId + "'");
                DB.Update(Q_ProUpdate);
                if (GLOBALDATA.GlobalData.Setup.getBatchenable() == 1) {
                    if (p.getBatch() == 1) {
                        createStocksForProduct(p, false, cUnits.getBaseUnitId(ProId));
                    } else {
                        createStocksForProduct(p, false, cUnits.getBaseUnitId(ProId));
                    }

                } else {
                    createStocksForProduct(p, false, cUnits.getBaseUnitId(p.getUnitGroupId()));
                }
                AddProductPropertise(ProId, proprop);

                String q1 = "DELETE FROM M_SUPPLIER_HAS_M_PRODUCTS WHERE M_PRODUCTS_ID='" + ProId + "' ";
                DB.Delete(q1);
                saveProductSuppliers(ProId, Suppliers);
                status = "Product Update Success!";
            }

            DB.getCurrentCon().commit();
        } catch (Exception e) {
            DB.getCurrentCon().rollback();

            throw e;

        } finally {
            DB.getCurrentCon().setAutoCommit(true);
        }

        return status;
    }

    public double getUnitConversion(String ProId, String UnitId) throws Exception {
        double conv = 1.0;
        MProducts product = getProduct(ProId);
        if (product != null) {

            conv = cUnits.getUnitConversion(product.getUnitGroupId(), UnitId);
        }

        return conv;
    }

}
