/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EXCEL_UPLOADER;

import CONTROLLERS.C_GroupCommon;
import CONTROLLERS.C_Products;
import CONTROLLERS.C_Suppliers;
import CONTROLLERS.C_Units;
import MODELS.MGroupCommon;
import MODELS.MProductExcel;
import MODELS.MProductPropertise;
import MODELS.MProducts;
import MODELS.MSupplier;
import MODELS.MUnitGroup;
import MODELS.MUnitGroupAssign;
import MODELS.MUnits;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author user pc
 */
public class ExcelUploader {

    public static final int TABLE_PRODUCT_FULL = 0;
    public static final int TABLE_UNITS = 1;
    public static final int TABLE_UNIT_GROUP = 2;
    public static final int TABLE_UNIT_GROUP_MAPPING = 3;
    public static final int TABLE_SUPPLIERS = 4;
    public static final int TABLE_GROUPS = 5;
    public static final int TABLE_GROUP_MAPPING = 6;
    public static final int TABLE_PRODUCT = 7;

    public C_Units c_unit = null;
    public C_Suppliers c_suppliers = null;
    public C_GroupCommon c_group = null;
    public C_Products c_product = null;

    public ExcelUploader() {
        c_unit = new C_Units();
        c_suppliers = new C_Suppliers();
        c_group = new C_GroupCommon();
        c_product = new C_Products();
    }

    public void importFromExcel(File f, int Table) throws Exception {

        FileInputStream fis = null;
        try {

            fis = new FileInputStream(f);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            System.out.println("===== import Unit ========");
            //unit 
            XSSFSheet spreadsheet_uom = workbook.getSheetAt(10);
            saveUnits(spreadsheet_uom);

            System.out.println("===== import Unit:done ========");

            //unit group
            System.out.println("===== import Unit group ========");
            XSSFSheet spreadsheet_uom_group = workbook.getSheetAt(8);
            XSSFSheet spreadsheet_uom_map = workbook.getSheetAt(9);
            saveUnitGroups(spreadsheet_uom_group, spreadsheet_uom_map);
            System.out.println("===== import Unit group:done ========");

            //suppliers
            System.out.println("===== import Suppliers ========");
            XSSFSheet spreadsheet_supplier = workbook.getSheetAt(7);
            saveSuppliers(spreadsheet_supplier);
            System.out.println("===== import Suppliers:done ========");

            //groups
            System.out.println("===== import Groups ========");
            XSSFSheet spreadsheet_group6 = workbook.getSheetAt(6);
            XSSFSheet spreadsheet_group5 = workbook.getSheetAt(5);
            XSSFSheet spreadsheet_group4 = workbook.getSheetAt(4);
            XSSFSheet spreadsheet_group3 = workbook.getSheetAt(3);
            XSSFSheet spreadsheet_group2 = workbook.getSheetAt(2);
            XSSFSheet spreadsheet_group1 = workbook.getSheetAt(1);

            XSSFSheet[] ar_excel_groups = new XSSFSheet[6];
            ar_excel_groups[0] = spreadsheet_group1;
            ar_excel_groups[1] = spreadsheet_group2;
            ar_excel_groups[2] = spreadsheet_group3;
            ar_excel_groups[3] = spreadsheet_group4;
            ar_excel_groups[4] = spreadsheet_group5;
            ar_excel_groups[5] = spreadsheet_group6;
            saveGroups(ar_excel_groups);
            System.out.println("===== import Groups:done ========");

            //product
            System.out.println("===== import Products ========");
            XSSFSheet spreadsheet_product = workbook.getSheetAt(0);
            saveProdcuts(spreadsheet_product);
            System.out.println("===== import Products:done ========");

        } catch (Exception e) {
            throw e;
        } finally {
            fis.close();
        }

    }

    private void saveUnits(XSSFSheet excel) throws Exception {

        for (int rowIndex = 1; rowIndex <= excel.getLastRowNum(); rowIndex++) {
            XSSFRow row = excel.getRow(rowIndex);

            if (row != null) {

                if (row.getCell(0) != null) {

                    String Code = (row.getCell(0).getStringCellValue()).toUpperCase();
                    
                    if(!Code.startsWith("U")){
                        Code="U"+Code;
                    }
                    
                    String Name = row.getCell(1).getStringCellValue().toUpperCase();
                    String Sym = row.getCell(2).getStringCellValue().toUpperCase();
                    MUnits unit = c_unit.getUnit(Code);
                    if (unit == null) {
                        MUnits u = new MUnits();
                        u.setId(Code);
                        u.setName(Name);
                        u.setSymble(Sym);
                        u.setActive((byte) 1);

                        c_unit.saveUnit(u);
                    }

                }
            }

        }

    }

    private void saveUnitGroups(XSSFSheet excel_unitGroup, XSSFSheet excel_unit_map) throws Exception {

        HashMap<String, MUnitGroup> unitGroups = new HashMap<>();
        for (int rowIndex = 1; rowIndex <= excel_unitGroup.getLastRowNum(); rowIndex++) {
            XSSFRow row = excel_unitGroup.getRow(rowIndex);

            if (row != null) {

                if (row.getCell(0) != null) {

                    String Code = row.getCell(0).getStringCellValue().toUpperCase();
                   
                      
                    String Name = row.getCell(1).getStringCellValue().toUpperCase();
                    String DefaultUOM = row.getCell(2).getStringCellValue().toUpperCase();

                    MUnitGroup unitg = c_unit.findUnitGroupExists(Code);
                    if (unitg == null) {
                        unitg = new MUnitGroup();
                        unitg.setUnitGroupId(Code);
                        unitg.setUnitGroupName(Name);
                        unitg.setUnitGroupActive((byte) 1);
                        unitg.setDefaultUnit(DefaultUOM);

                    }
                    unitGroups.put(Code, unitg);

                }
            }

        }

        HashMap<MUnitGroup, ArrayList<MUnitGroupAssign>> unit_group_save = new HashMap<>();

        for (int rowIndex = 1; rowIndex <= excel_unit_map.getLastRowNum(); rowIndex++) {
            XSSFRow row = excel_unit_map.getRow(rowIndex);

            if (row != null) {

                if (row.getCell(0) != null) {

                    String Code = row.getCell(0).getStringCellValue().toUpperCase();
                    String UOM_ID = row.getCell(1).getStringCellValue().toUpperCase();
                    String Vol = row.getCell(2).getRawValue().toUpperCase();

                    MUnitGroup ug = unitGroups.get(Code);
                    if (ug != null) {
                        MUnitGroupAssign uga = new MUnitGroupAssign();
                        uga.setActive((byte)1);
                        uga.setIsBase((ug.equals(new MUnitGroup(UOM_ID)) ? 1 : 0));
                        uga.setUnitGroupId(Code);
                        uga.setUnitId(UOM_ID);
                        uga.setVolume(Double.parseDouble(Vol));

                        ArrayList<MUnitGroupAssign> arUg = unit_group_save.get(ug);
                        if (arUg != null && arUg.size() > 0) {
                            arUg.add(uga);
                        } else {
                            arUg = new ArrayList<>();
                            arUg.add(uga);

                        }

                        unit_group_save.put(ug, arUg);
                    }

                }
            }

        }

        for (Map.Entry<MUnitGroup, ArrayList<MUnitGroupAssign>> entry : unit_group_save.entrySet()) {
            MUnitGroup key = entry.getKey();
            ArrayList<MUnitGroupAssign> value = entry.getValue();

            c_unit.SaveUnitGroup(key, value);

        }

    }

    private void saveSuppliers(XSSFSheet excel) throws Exception {

        for (int rowIndex = 1; rowIndex <= excel.getLastRowNum(); rowIndex++) {
            XSSFRow row = excel.getRow(rowIndex);

            if (row != null) {

                if (row.getCell(0) != null && row.getCell(1) != null) {

                    String Code = row.getCell(0).getStringCellValue().toUpperCase();
                    String Name = row.getCell(1).getStringCellValue().toUpperCase();

                    MSupplier s = new MSupplier();
                    s.setId(Code);
                    s.setName(Name);
                    s.setContact("");
                    s.setContactperson("");
                    s.setMobile("");
                    s.setAddress("");
                    s.setActive((byte) 1);

                    c_suppliers.SaveSupplier(s);
                }
            }

        }

    }

    private void saveGroups(XSSFSheet[] arexcel) throws Exception {

        int i = 1;
        for (XSSFSheet excel : arexcel) {
            for (int rowIndex = 1; rowIndex <= excel.getLastRowNum(); rowIndex++) {
                XSSFRow row = excel.getRow(rowIndex);

                if (row != null) {

                    if (row.getCell(0) != null && row.getCell(1) != null) {

                        try {
                            String Code = row.getCell(0).getStringCellValue().toUpperCase();
                            String Name = row.getCell(1).getStringCellValue().toUpperCase();

                            try {
                                c_group.saveGroup("m_group" + i, new MGroupCommon(Code, Name, (byte) 1));
                            } catch (Exception e) {
                                System.out.println("Group:" + e.getMessage());
                            }
                        } catch (Exception e) {
                            System.out.println("Group skiped:" + row.getCell(0) + e.getMessage());
                        }

                    }
                }

            }

            i++;
        }

    }

    private void saveProdcuts(XSSFSheet excel) throws Exception {
        ArrayList<MProductExcel> productList = getProductList(excel);
        for (MProductExcel p : productList) {
            //System.out.println(p);

            ArrayList<MGroupCommon> GList = new ArrayList<>();
            GList.add(new MGroupCommon(p.getProduct().getMGroup1()));
            GList.add(new MGroupCommon(p.getProduct().getMGroup2()));
            GList.add(new MGroupCommon(p.getProduct().getMGroup3()));
            GList.add(new MGroupCommon(p.getProduct().getMGroup4()));
            GList.add(new MGroupCommon(p.getProduct().getMGroup5()));
            GList.add(new MGroupCommon(p.getProduct().getMGroup6()));
            c_group.saveGroupMaping_Excel(GList);

            c_product.addProduct(p.getProduct(), p.getProprop(), p.getSuppliers());
        }

    }

//    public ArrayList old_getExcelAsList(File f, int Table) throws Exception {
//
//        FileInputStream fis = null;
//        try {
//
//            fis = new FileInputStream(f);
//            XSSFWorkbook workbook = new XSSFWorkbook(fis);
//
//            XSSFSheet spreadsheet = workbook.getSheetAt(0);
//
//            if (TABLE_PRODUCT_FULL == Table) {
//                return getProductList(spreadsheet);
//
//            } else {
//                return null;
//            }
//
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            fis.close();
//        }
//
//    }
    private ArrayList<MProductExcel> getProductList(XSSFSheet excel) throws Exception {
        ArrayList<MProductExcel> ar_products = new ArrayList<>();

        for (int rowIndex = 1; rowIndex <= excel.getLastRowNum(); rowIndex++) {
            XSSFRow row = excel.getRow(rowIndex);

            if (row != null) {

                if (row.getCell(0) != null) {

                    String G1_Code = row.getCell(0).getStringCellValue().toUpperCase();
                    String G2_Code = row.getCell(2).getStringCellValue().toUpperCase();
                    String G3_Code = row.getCell(4).getStringCellValue().toUpperCase();
                    String G4_Code = row.getCell(6).getStringCellValue().toUpperCase();

                    String G5_Code = row.getCell(8).getStringCellValue().toUpperCase();
                    String G6_Code = row.getCell(10).getStringCellValue().toUpperCase();

                    // System.out.println(rowIndex+"- "+row.getCell(9).getCellType());
                    //String G5_size="";
                    String G1_name = "";
                    if (row.getCell(1) != null) {
                        G1_name = row.getCell(1).getRawValue();
                    }
                    String G2_name = "";
                    if (row.getCell(3) != null) {
                        G2_name = row.getCell(3).getRawValue();
                    }
                    String G3_name = "";
                    if (row.getCell(1) != null) {
                        G3_name = row.getCell(5).getRawValue();
                    }

                    String G4_name = "";
                    if (row.getCell(1) != null) {
                        G4_name = row.getCell(7).getRawValue();
                    }

                    String G5_name = "";
                    if (row.getCell(1) != null) {
                        G5_name = row.getCell(9).getRawValue();
                    }

                    String G6_name = "";
                    if (row.getCell(1) != null) {
                        G6_name = row.getCell(11).getStringCellValue();
                    }

                    String ItemName = (G1_name + " " + G2_name + " " + G3_name + " " + G4_name + " " + G5_name + " " + G6_name).toUpperCase();

                    String UOM_Group_id = row.getCell(14).getStringCellValue().toUpperCase();

                    MProducts p = new MProducts();
                    p.setId("");
                    p.setName(ItemName);
                    p.setPrintdes((ItemName.length() > 42 ? ItemName.substring(0, 42) : ItemName));
                    p.setBatch((byte) 0);
                    p.setActive((byte) 1);
                    p.setUnitGroupId(UOM_Group_id);
                    p.setMUserByCruser("U0000");
                    p.setMUserByMduser("U0000");
                    p.setMGroup1(G1_Code);
                    p.setMGroup2(G2_Code);
                    p.setMGroup3(G3_Code);
                    p.setMGroup4(G4_Code);
                    p.setMGroup5(G5_Code);
                    p.setMGroup6(G6_Code);
                    p.setRef2("");

                    p.setCprice(0.0);
                    p.setMarkup(0.0);
                    p.setSprice(0.0);
                    
                    p.setCommision(0.0);

                    String SupCode = row.getCell(12).getStringCellValue();
                    Vector<MSupplier> V_Sup = new Vector<>();
                    V_Sup.add(new MSupplier(SupCode));

                    Vector<MProductPropertise> V_Prop = new Vector<>();

                    ar_products.add(new MProductExcel(p, V_Prop, V_Sup));
                }
            }

        }

        return ar_products;
    }

//    private ArrayList<MProductExcel> getProductList_Org(XSSFSheet excel) throws Exception {
//        ArrayList<MProductExcel> ar_products = new ArrayList<>();
//
//        for (int rowIndex = 1; rowIndex <= excel.getLastRowNum(); rowIndex++) {
//            XSSFRow row = excel.getRow(rowIndex);
//
//            if (row != null) {
//
//                if (row.getCell(0) != null) {
//
//                    String G1_Code = row.getCell(0).getStringCellValue();
//                    String G2_Code = row.getCell(2).getStringCellValue();
//                    String G3_Code = row.getCell(4).getStringCellValue();
//                    String G4_Code = row.getCell(6).getStringCellValue();
//
//                    String G5_Code = row.getCell(8).getStringCellValue();
//
//                    String G5_size = row.getCell(9).getStringCellValue();
//
//                    String ItemName = row.getCell(10).getStringCellValue();
//
//                    double Cost = row.getCell(11).getNumericCellValue();
//
//                    double Sell = row.getCell(12).getNumericCellValue();
//
//                    double margine = new BigDecimal((((Sell - Cost) / Cost) * 100)).setScale(2, RoundingMode.HALF_UP).doubleValue();
//                    String Ref2 = (row.getCell(15) != null ? row.getCell(15).getStringCellValue() : "");
//
//                    MProducts p = new MProducts();
//                    p.setId("");
//                    p.setName(ItemName);
//                    p.setPrintdes((ItemName.length() > 42 ? ItemName.substring(42) : ItemName));
//                    p.setBatch((byte) 0);
//                    p.setActive((byte) 1);
//                    p.setUnitGroupId("UG001");
//                    p.setMUserByCruser("U0000");
//                    p.setMUserByMduser("U0000");
//                    p.setMGroup1(G1_Code);
//                    p.setMGroup2(G2_Code);
//                    p.setMGroup3(G3_Code);
//                    p.setMGroup4(G4_Code);
//                    p.setMGroup5(G5_Code);
//                    p.setRef2("");
//                    if (Ref2.length() > 0) {
//                        p.setRef1(G5_size + "-" + Ref2);
//                    } else {
//                        p.setRef1("");
//                    }
//                    p.setCprice(Cost);
//                    p.setMarkup(margine);
//                    p.setSprice(Sell);
//
//                    String SupCode = "S" + row.getCell(13).getStringCellValue();
//                    Vector<MSupplier> V_Sup = new Vector<>();
//                    V_Sup.add(new MSupplier(SupCode));
//
//                    Vector<MProductPropertise> V_Prop = new Vector<>();
//
//                    ar_products.add(new MProductExcel(p, V_Prop, V_Sup));
//                }
//            }
//
//        }
//
//        return ar_products;
//    }
}
