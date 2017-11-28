/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EXCEL_UPLOADER;

import MODELS.MProductExcel;
import MODELS.MProductPropertise;
import MODELS.MProducts;
import MODELS.MSupplier;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author user pc
 */
public class ExcelUploader {

    public static final int TABLE_PRODUCT = 1;

    public ArrayList getExcelAsList(File f, int Table) throws Exception {

        FileInputStream fis = null;
        try {

            fis = new FileInputStream(f);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);

            if (TABLE_PRODUCT == Table) {
                return getProductList(spreadsheet);

            } else {
                return null;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            fis.close();
        }

    }

    private ArrayList<MProductExcel> getProductList(XSSFSheet excel) throws Exception {
        ArrayList<MProductExcel> ar_products = new ArrayList<>();

        for (int rowIndex = 1; rowIndex <= excel.getLastRowNum(); rowIndex++) {
            XSSFRow row = excel.getRow(rowIndex);

            if (row != null) {

                if (row.getCell(0) != null) {

                    String G1_Code = row.getCell(0).getStringCellValue();
                    String G2_Code = row.getCell(2).getStringCellValue();
                    String G3_Code = row.getCell(4).getStringCellValue();
                    String G4_Code = "G4"+row.getCell(6).getStringCellValue().substring(2);


                    String G5_Code = "G5"+row.getCell(8).getStringCellValue().substring(2);
                    
                    
                   // System.out.println(rowIndex+"- "+row.getCell(9).getCellType());
                    //String G5_size="";
                    
                    String G1_name=row.getCell(1).getStringCellValue();
                    String G2_name=row.getCell(3).getStringCellValue();
                    String G3_name=row.getCell(5).getStringCellValue();
                    String G4_name=row.getCell(7).getStringCellValue();
                    String G5_size = row.getCell(9).getStringCellValue();
                    

                    String ItemName = G1_name.toUpperCase()+" "+G2_name.toUpperCase()+" "+G3_name.toUpperCase()+" "+G4_name.toUpperCase()+" "+G5_size.toUpperCase();

                    double Cost = row.getCell(11).getNumericCellValue();

                    double Sell = row.getCell(12).getNumericCellValue();

                    double margine = new BigDecimal((((Sell - Cost) / Cost) * 100)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                    String Ref2 = (row.getCell(15)!=null?row.getCell(15).getStringCellValue():"");

                    MProducts p = new MProducts();
                    p.setId("");
                    p.setName(ItemName);
                    p.setPrintdes((ItemName.length() > 42 ? ItemName.substring(42) : ItemName));
                    p.setBatch((byte) 0);
                    p.setActive((byte) 1);
                    p.setUnitGroupId("UG001");
                    p.setMUserByCruser("U0000");
                    p.setMUserByMduser("U0000");
                    p.setMGroup1(G1_Code);
                    p.setMGroup2(G2_Code);
                    p.setMGroup3(G3_Code);
                    p.setMGroup4(G4_Code);
                    p.setMGroup5(G5_Code);
                    p.setRef2("");
                    if(Ref2.length()>0){
                       p.setRef1(G5_size + "-" + Ref2); 
                    }else{
                        p.setRef1("");
                    }
                    

                    p.setCprice(Cost);
                    p.setMarkup(margine);
                    p.setSprice(Sell);

                    String SupCode = "S"+row.getCell(13).getStringCellValue();
                    Vector<MSupplier> V_Sup = new Vector<>();
                    V_Sup.add(new MSupplier(SupCode));

                    Vector<MProductPropertise> V_Prop = new Vector<>();

                    ar_products.add(new MProductExcel(p, V_Prop, V_Sup));
                }
            }

        }

        return ar_products;
    }
    
     private ArrayList<MProductExcel> getProductList_Org(XSSFSheet excel) throws Exception {
        ArrayList<MProductExcel> ar_products = new ArrayList<>();

        for (int rowIndex = 1; rowIndex <= excel.getLastRowNum(); rowIndex++) {
            XSSFRow row = excel.getRow(rowIndex);

            if (row != null) {

                if (row.getCell(0) != null) {

                    String G1_Code = row.getCell(0).getStringCellValue();
                    String G2_Code = row.getCell(2).getStringCellValue();
                    String G3_Code = row.getCell(4).getStringCellValue();
                    String G4_Code = row.getCell(6).getStringCellValue();


                    String G5_Code = row.getCell(8).getStringCellValue();
                    
                    String G5_size = row.getCell(9).getStringCellValue();
                    

                    String ItemName = row.getCell(10).getStringCellValue();

                    double Cost = row.getCell(11).getNumericCellValue();

                    double Sell = row.getCell(12).getNumericCellValue();

                    double margine = new BigDecimal((((Sell - Cost) / Cost) * 100)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                     String Ref2 = (row.getCell(15)!=null?row.getCell(15).getStringCellValue():"");
                     
                    MProducts p = new MProducts();
                    p.setId("");
                    p.setName(ItemName);
                    p.setPrintdes((ItemName.length() > 42 ? ItemName.substring(42) : ItemName));
                    p.setBatch((byte) 0);
                    p.setActive((byte) 1);
                    p.setUnitGroupId("UG001");
                    p.setMUserByCruser("U0000");
                    p.setMUserByMduser("U0000");
                    p.setMGroup1(G1_Code);
                    p.setMGroup2(G2_Code);
                    p.setMGroup3(G3_Code);
                    p.setMGroup4(G4_Code);
                    p.setMGroup5(G5_Code);
                    p.setRef2("");
                    if(Ref2.length()>0){
                       p.setRef1(G5_size + "-" + Ref2); 
                    }else{
                        p.setRef1("");
                    }
                    p.setCprice(Cost);
                    p.setMarkup(margine);
                    p.setSprice(Sell);

                    String SupCode = "S"+row.getCell(13).getStringCellValue();
                    Vector<MSupplier> V_Sup = new Vector<>();
                    V_Sup.add(new MSupplier(SupCode));

                    Vector<MProductPropertise> V_Prop = new Vector<>();

                    ar_products.add(new MProductExcel(p, V_Prop, V_Sup));
                }
            }

        }

        return ar_products;
    }
    
}
