/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMMONFUN;

import CONTROLLERS.C_Customers;
import CONTROLLERS.C_GroupCommon;
import CONTROLLERS.C_Locations;
import CONTROLLERS.C_Permissions;
import CONTROLLERS.C_SalesMan;
import CONTROLLERS.C_Suppliers;
import CONTROLLERS.C_TransactionSetup;
import CONTROLLERS.C_UserGroup;
import CONTROLLERS.C_Users;
import DB_ACCESS.DB;
import MODELS.MPermissions;
import MODELS.MUser;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Buwanaka
 */
public class DefaultData {

    C_Permissions CPerm = null;
    C_Users CUsers = null;
    C_TransactionSetup cTrn = null;
    CommonFun cf = null;
    C_SalesMan cSalesman = null;
    C_Customers cCustomers = null;
    C_Suppliers cSup = null;
    C_UserGroup cUserGrp = null;
    C_GroupCommon cGroup = null;
    C_Locations cLoc = null;

    public DefaultData() {
        CPerm = new C_Permissions();
        CUsers = new C_Users();
        cTrn = new C_TransactionSetup();
        cf = new CommonFun();
        cSalesman = new C_SalesMan();
        cCustomers = new C_Customers();
        cSup = new C_Suppliers();
        cUserGrp = new C_UserGroup();
        cGroup = new C_GroupCommon();
        cLoc = new C_Locations();
    }

    public void createDefaultData() {
        createSuperAdmin();
        createPermissions();
        createSuperAdminPrevilages();
        createDefaultFolders();
        createDefualtRec();
    }

    private void createPermissions() {
        ArrayList<MPermissions> ar = new ArrayList<>();

        //Master files(0-100)
        ar.add(new MPermissions("M00000", "M00000", "MASTER", "Master Files", "MSTF", (byte) 1, (byte) 1, "A", 0, "materfiles.png"));//1
        ar.add(new MPermissions("M00001", "M00000", "LOCATIONS", "Locations", "LOC", (byte) 0, (byte) 1, "A", 1, "location.png"));
        ar.add(new MPermissions("M00002", "M00000", "GROUP1", "Group1", "GROUP", (byte) 0, (byte) 1, "A", 2, "group.png"));
        ar.add(new MPermissions("M00003", "M00000", "GROUP2", "Group2", "GROUP", (byte) 0, (byte) 1, "A", 3, "group.png"));
        ar.add(new MPermissions("M00004", "M00000", "GROUP3", "Group3", "GROUP", (byte) 0, (byte) 1, "A", 4, "group.png"));
        ar.add(new MPermissions("M00005", "M00000", "GROUP4", "Group4", "GROUP", (byte) 0, (byte) 1, "A", 5, "group.png"));
        ar.add(new MPermissions("M00006", "M00000", "GROUP5", "Group5", "GROUP", (byte) 0, (byte) 1, "A", 6, "group.png"));
        ar.add(new MPermissions("M00007", "M00000", "GROUP6", "Group6", "GROUP", (byte) 0, (byte) 1, "A", 7, "group.png"));

        ar.add(new MPermissions("M00011", "M00000", "GROUPMAP", "Group Map", "GRPM", (byte) 0, (byte) 1, "A", 12, "groupmap.png"));
        ar.add(new MPermissions("M00012", "M00000", "UNITS", "Unit Master", "UNITS", (byte) 0, (byte) 1, "A", 13, "units.png"));
        ar.add(new MPermissions("M00013", "M00000", "UGRP", "Unit Group", "UGRP", (byte) 0, (byte) 1, "A", 14, "unitgrp.png"));
        ar.add(new MPermissions("M00014", "M00000", "ITEMS", "Item Maser", "ITEMS", (byte) 0, (byte) 1, "A", 15, "item_cloth.png"));
        ar.add(new MPermissions("M00015", "M00000", "SUP", "Supplier", "SUP", (byte) 0, (byte) 1, "A", 16, "supplier.png"));
        ar.add(new MPermissions("M00016", "M00000", "CUS", "Customer", "CUS", (byte) 0, (byte) 1, "A", 17, "customer.png"));
        ar.add(new MPermissions("M00017", "M00000", "GVCRE", "Gift Voucher Creation", "GVCRE", (byte) 0, (byte) 1, "A", 18, "gv.png"));
        ar.add(new MPermissions("M00018", "M00000", "GVSTA", "Gift Voucher Status", "GVSTA", (byte) 0, (byte) 1, "A", 19, "gv_status.png"));
        ar.add(new MPermissions("M00019", "M00000", "SALESM", "Sales Person", "SALESM", (byte) 0, (byte) 1, "A", 20, "salesman.png"));

        //Transactions(101-200)
        ar.add(new MPermissions("T00000", "T00000", "TRANSACTIONS", "Transactions", "TRN", (byte) 1, (byte) 1, 101, "transaction.png"));//4
        ar.add(new MPermissions("T00001", "T00000", "T_GRN", "Goods Received Note", "TRN", (byte) 0, (byte) 1, 102, "grn.png"));
        ar.add(new MPermissions("T00002", "T00000", "T_INV", "Invoice", "TRN", (byte) 0, (byte) 1, 103, "Invoice.png"));

        //Reports(201-600)
        ar.add(new MPermissions("R00000", "R00000", "RPT", "Reports", "RPT", (byte) 1, (byte) 1, 201, "report.png"));//5

        //Sales Reports(202-300)
        ar.add(new MPermissions("R00001", "R00000", "R_SALES", "Sales Reports", "RPT", (byte) 0, (byte) 1, 202, "Sales_Folder.png"));
        ar.add(new MPermissions("R00002", "R00001", "R_SALES_1", "Invoice Listing", "RPT", (byte) 0, (byte) 1, 203, "Report_sub.png"));
        ar.add(new MPermissions("R00003", "R00001", "R_SALES_2", "Payment mode wise Sale", "RPT", (byte) 0, (byte) 1, 204, "Report_sub.png"));
        ar.add(new MPermissions("R00004", "R00001", "R_SALES_3", "Supplier Products Sale", "RPT", (byte) 0, (byte) 1, 205, "Report_sub.png"));
        ar.add(new MPermissions("R00005", "R00001", "R_SALES_4", "Invoice wise Profit Report", "RPT", (byte) 0, (byte) 1, 206, "Report_sub.png"));

        //Stock Reports(301-400)
        ar.add(new MPermissions("R00101", "R00000", "R_STOCK", "Stock Reports", "RPT", (byte) 0, (byte) 1, 301, "Stock_Folder.png"));
        ar.add(new MPermissions("R00102", "R00101", "R_STOCK_1", "Stock Balance Summary", "RPT", (byte) 0, (byte) 1, 302, "Report_sub.png"));

        //Custom Reports(401-500)
        //Other Reports(501-600)
        //Accounts(601-700) 
        ar.add(new MPermissions("A00000", "A00000", "ACCOUNTS", "Accounts/Payments", "ACC", (byte) 1, (byte) 1, "A", 601, "accounts.png"));//3
        ar.add(new MPermissions("A00001", "A00000", "ACHQ", "Cheque Payments", "ACHQ", (byte) 0, (byte) 1, "A", 602, "Cheque.png"));

        //Security(701-750)
        ar.add(new MPermissions("S00000", "S00000", "SECURITY", "Security", "SECUR", (byte) 1, (byte) 1, "A", 701, "security.png"));//2
        ar.add(new MPermissions("S00001", "S00000", "SEC_UC", "User Creation", "SUC", (byte) 0, (byte) 1, "A", 702, "user_create.png"));
        ar.add(new MPermissions("S00002", "S00000", "SEC_GP", "Group Permission", "SGP", (byte) 0, (byte) 1, "A", 703, ""));
        ar.add(new MPermissions("S00003", "S00000", "SEC_US", "User Security", "SUS", (byte) 0, (byte) 1, "A", 704, "user_security.png"));

        ar.add(new MPermissions("S00004", "S00000", "SEC_UUD", "User Details Update", "SUUDU", (byte) 0, (byte) 0, "A", 705, ""));
        ar.add(new MPermissions("S00005", "S00000", "SEC_UUS", "User State Update only", "SUSU", (byte) 0, (byte) 0, "A", 706, ""));

        //Utilities(751-800)
        ar.add(new MPermissions("U00000", "U00000", "SETTINGS", "Utilities", "SET", (byte) 1, (byte) 1, "A", 751, "fol.png"));//2
        ar.add(new MPermissions("U00001", "U00000", "SET_SYS", "Settings", "SET", (byte) 0, (byte) 1, "A", 752, "settings.png"));//2
        ar.add(new MPermissions("U00002", "U00000", "SET_EXC", "Excel Upload", "SET", (byte) 0, (byte) 1, "A", 753, "excel.png"));//2

        //General Permissions(801-1000)
        ar.add(new MPermissions("P00000", "P00000", "GEN_PER", "General Permissions", "GEN_PER", (byte) 1, (byte) 0, "A", 801, ""));//6
        ar.add(new MPermissions("P00001", "P00000", "P1", "Login", "GEN_PER", (byte) 0, (byte) 0, "A", 802, ""));
        ar.add(new MPermissions("P00002", "P00000", "P2", "Logout", "GEN_PER", (byte) 0, (byte) 0, "A", 803, ""));
        ar.add(new MPermissions("P00003", "P00000", "P3", "Location Create", "GEN_PER", (byte) 0, (byte) 0, "A", 804, ""));
        ar.add(new MPermissions("P00004", "P00000", "P4", "Location Update", "GEN_PER", (byte) 0, (byte) 0, "A", 805, ""));
        ar.add(new MPermissions("P00005", "P00000", "P5", "Group Creation", "GEN_PER", (byte) 0, (byte) 0, "A", 805, ""));
        ar.add(new MPermissions("P00006", "P00000", "P6", "Group Update", "GEN_PER", (byte) 0, (byte) 0, "A", 807, ""));
        ar.add(new MPermissions("P00007", "P00000", "P7", "Unit Creation", "GEN_PER", (byte) 0, (byte) 0, "A", 808, ""));
        ar.add(new MPermissions("P00008", "P00000", "P8", "Unit Update", "GEN_PER", (byte) 0, (byte) 0, "A", 809, ""));
        ar.add(new MPermissions("P00009", "P00000", "P9", "Item Creation", "GEN_PER", (byte) 0, (byte) 0, "A", 810, ""));
        ar.add(new MPermissions("P00010", "P00000", "P10", "Item Update", "GEN_PER", (byte) 0, (byte) 0, "A", 811, ""));
        ar.add(new MPermissions("P00011", "P00000", "P11", "Supplier Create", "GEN_PER", (byte) 0, (byte) 0, "A", 812, ""));
        ar.add(new MPermissions("P00012", "P00000", "P12", "Supplier Update", "GEN_PER", (byte) 0, (byte) 0, "A", 813, ""));
        ar.add(new MPermissions("P00013", "P00000", "P13", "Customer Create", "GEN_PER", (byte) 0, (byte) 0, "A", 814, ""));
        ar.add(new MPermissions("P00014", "P00000", "P14", "Customer Update", "GEN_PER", (byte) 0, (byte) 0, "A", 815, ""));
        ar.add(new MPermissions("P00015", "P00000", "P15", "Group Map Create", "GEN_PER", (byte) 0, (byte) 0, "A", 816, ""));
        ar.add(new MPermissions("P00016", "P00000", "P16", "Group Map Update", "GEN_PER", (byte) 0, (byte) 0, "A", 817, ""));
        ar.add(new MPermissions("P00017", "P00000", "P17", "Unit Map Create", "GEN_PER", (byte) 0, (byte) 0, "A", 818, ""));
        ar.add(new MPermissions("P00018", "P00000", "P18", "Unit Map Update", "GEN_PER", (byte) 0, (byte) 0, "A", 819, ""));

        ar.add(new MPermissions("P00019", "P00000", "P19", "Cheque Payment Update State", "GEN_PER", (byte) 0, (byte) 0, "A", 820, ""));
        ar.add(new MPermissions("P00020", "P00000", "P20", "Cheque Payment Special Update(Re-Assign)", "GEN_PER", (byte) 0, (byte) 0, "A", 821, ""));

        ar.add(new MPermissions("P00021", "P00000", "P21", "Gift voucher purchase", "GEN_PER", (byte) 0, (byte) 0, "A", 822, ""));
        ar.add(new MPermissions("P00022", "P00000", "P22", "Gift voucher redeem", "GEN_PER", (byte) 0, (byte) 0, "A", 823, ""));

        ar.add(new MPermissions("P00023", "P00000", "P23", "Give Discount Percentage", "GEN_PER", (byte) 0, (byte) 0, "A", 824, ""));
        ar.add(new MPermissions("P00024", "P00000", "P24", "Give Discount Amount", "GEN_PER", (byte) 0, (byte) 0, "A", 825, ""));
        ar.add(new MPermissions("P00025", "P00000", "P25", "Give Total Discount", "GEN_PER", (byte) 0, (byte) 0, "A", 826, ""));
        ar.add(new MPermissions("P00026", "P00000", "P26", "Cancel Transaction", "GEN_PER", (byte) 0, (byte) 0, "A", 826, ""));

        CPerm.saveBullkPermissions(ar);
    }

    private void createSuperAdminPrevilages() {

        try {
            MUser user = CUsers.getUser("U0000");
            if (user != null) {
                ArrayList<MPermissions> ar = CPerm.getAllPermissions();
                for (MPermissions mPermissions : ar) {
                    try {
                        CPerm.saveGroupPermissions(user.getMUsergroup().getId(), mPermissions.getId(), mPermissions.getParentid(), mPermissions.getAcesst());
                    } catch (Exception e) {
                        System.err.println("DEF PERMISSION CREATION ERROR:" + e.getMessage());
                    }

                }

            }
        } catch (Exception ex) {

        }

    }

    private void createSuperAdmin() {

        try {
            if (cUserGrp.getUserGroup("0") == null) {
                String q = "INSERT INTO m_usergroup(ID,GROUPNAME,ACTIVE,VISIBLE) values(0,'SUPERADMIN',1,0) ";
                DB.Save(q);
            }
        } catch (Exception e) {
        }

        try {
            if (CUsers.getUser("U0000") == null) {
                String q_admin = "INSERT INTO m_user(ID,FIRSTNAME,LASTNAME,IMGURL,UGRUID,ACTIVE,VISIBLE) values('U0000','SUPER ADMIN','','',0,1,0) ";
                DB.Save(q_admin);

                String q_pass = "INSERT INTO m_usersecurity(ID,USERNAME,PASSWORD,UID) values('0','ADMIN','" + SECURITY.myEncript.encript("bizadmin") + "','U0000')";
                DB.Save(q_pass);
            }
        } catch (Exception e) {
            System.err.println("ADMIN Creation Error:" + e.getMessage());
        }

    }

    private void createDefaultFolders() {
        try {
            File f_myData = new File("MyData");
            if (f_myData.exists() == false) {
                f_myData.mkdir();
            }
            File f_UserImg = new File(f_myData, "Users");
            if (f_UserImg.exists() == false) {
                f_UserImg.mkdir();
            }
            File f_ProImg = new File(f_myData, "Products");
            if (f_ProImg.exists() == false) {
                f_ProImg.mkdir();
            }
            File f_ProCom = new File(f_myData, "Company");
            if (f_ProCom.exists() == false) {
                f_ProCom.mkdir();
            }

        } catch (Exception e) {
            System.err.println("FOLDER CREATION ERROR:" + e.getMessage());
        }

    }

    private void createDefualtRec() {
        /*
        try {//GROUPS
            for (int i = 1; i <= 5; i++) {
                if (cGroup.IsExists("m_group" + i, "G" + i + "000") == null) {
                    String q_grp = "INSERT INTO m_group" + i + "(ID,NAME,ACTIVE,ISHIDDEN) values('G" + i + "000','',1,1) ";
                    DB.Save(q_grp);
                }
            }
        } catch (Exception e) {
        }
         */
 /*
        try {//LOCATION
            if (cLoc.getLocation("0") == null) {
                String q_loc = "INSERT INTO m_location(ID,NAME,ACTIVE,VISIBLE,REFNO) values('0','MAIN',1,1,'') ";
                DB.Save(q_loc);
            }

        } catch (Exception e) {
        }
         */

        try {//SUP
            if (cSup.getSupplier("S0000") == null) {
                String q_sup = "INSERT INTO m_supplier(ID,NAME,ACTIVE) values('S0000','',1) ";
                DB.Save(q_sup);
            }

        } catch (Exception e) {
        }

        try {//CUS
            if (cCustomers.getCustomer("00000") == null) {
                String q_cus = "INSERT INTO m_customer(ID,NAME,ACTIVE) values('00000','CASH',1) ";
                DB.Save(q_cus);
            }

        } catch (Exception e) {
        }

        try {//SA
/*
            String q_cus = "INSERT INTO m_salesperson(ID,FNAME,ACTIVE) values('00000','',1) ";
            DB.Save(q_cus);
             */
        } catch (Exception e) {
        }

    }

}
