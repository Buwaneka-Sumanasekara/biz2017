/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EXCEL_UPLOADER;

import CONTROLLERS.C_GroupCommon;
import CONTROLLERS.C_Products;
import MODELS.MGroupCommon;
import MODELS.MProductExcel;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user pc
 */
public class Test {

    C_Products c = null;
    C_GroupCommon Grp=null;
    public Test() {
        c = new C_Products();
        Grp=new C_GroupCommon();
    }

    public static void main(String[] args) {

        new Test().readExcel();

    }

    private void readExcel() {
        try {
            ExcelUploader e = new ExcelUploader();
            File f = new File("C:\\Users\\user pc\\Documents\\NetBeansProjects\\BizExcelUpload\\Upload\\pro_test.xlsx");
            ArrayList excelAsList = e.getExcelAsList(f, ExcelUploader.TABLE_PRODUCT);

            ArrayList<MProductExcel> arrayList = (ArrayList<MProductExcel>) excelAsList;
            System.out.println("Count:" + arrayList.size());
            System.out.println("");
            for (MProductExcel p : arrayList) {
                System.out.println(p);

                ArrayList<MGroupCommon> GList = new ArrayList<>();
                GList.add(new MGroupCommon(p.getProduct().getMGroup1()));
                GList.add(new MGroupCommon(p.getProduct().getMGroup2()));
                GList.add(new MGroupCommon(p.getProduct().getMGroup3()));
                GList.add(new MGroupCommon(p.getProduct().getMGroup4()));
                GList.add(new MGroupCommon(p.getProduct().getMGroup5()));
                Grp.saveGroupMaping_Excel(GList);
                

                c.addProduct(p.getProduct(), p.getProprop(), p.getSuppliers());
            }

        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
