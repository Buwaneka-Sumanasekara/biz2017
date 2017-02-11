/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMMONFUN;

import CONTROLLERS.C_Permissions;
import CONTROLLERS.C_Users;
import MODELS.MPermissions;
import MODELS.MUser;
import java.util.ArrayList;

/**
 *
 * @author Buwanaka
 */
public class DefaultData {

    C_Permissions CPerm = null;
    C_Users CUsers = null;

    public DefaultData() {
        CPerm = new C_Permissions();
        CUsers = new C_Users();
    }

    public void createDefaultData() {
        createSuperAdmin();
        createPermissions();
        createSuperAdminPrevilages();
    }

    private void createPermissions() {
        ArrayList<MPermissions> ar = new ArrayList<>();
        
        //Master files
        ar.add(new MPermissions("M00000", "M00000", "MASTER", "Master Files", "MSTF", (byte) 1, (byte) 1,"A"));
        ar.add(new MPermissions("M00001", "M00000", "LOCATIONS", "Locations", "LOC", (byte) 0, (byte) 1,"A"));
        ar.add(new MPermissions("M00002", "M00000", "GROUP1", "Group1", "GROUP", (byte) 0, (byte) 1,"A"));
        ar.add(new MPermissions("M00003", "M00000", "GROUP2", "Group2", "GROUP", (byte) 0, (byte) 1,"A"));
        ar.add(new MPermissions("M00004", "M00000", "GROUP3", "Group3", "GROUP", (byte) 0, (byte) 1,"A"));
        ar.add(new MPermissions("M00005", "M00000", "GROUP4", "Group4", "GROUP", (byte) 0, (byte) 1,"A"));
        ar.add(new MPermissions("M00006", "M00000", "GROUP5", "Group5", "GROUP", (byte) 0, (byte) 1,"A"));
        ar.add(new MPermissions("M00007", "M00000", "UNITS", "Unit Master", "UNITS", (byte) 0, (byte) 1,"A"));
        ar.add(new MPermissions("M00008", "M00000", "ITEMS", "Item Maser", "ITEMS", (byte) 0, (byte) 1,"A"));
        ar.add(new MPermissions("M00009", "M00000", "SUP", "Supplier", "SUP", (byte) 0, (byte) 1,"A"));
        ar.add(new MPermissions("M00010", "M00000", "CUS", "Customer", "CUS", (byte) 0, (byte) 1,"A"));
        ar.add(new MPermissions("M00011", "M00000", "GROUPMAP", "Group Map", "GRPM", (byte) 0, (byte) 1,"A"));
        ar.add(new MPermissions("M00012", "M00000", "UGRP", "Unit Group", "UGRP", (byte) 0, (byte) 1,"A"));
        
       //Security
       ar.add(new MPermissions("S00000", "S00000", "SECURITY", "Security", "SECUR", (byte) 1, (byte) 1,"A"));
       ar.add(new MPermissions("S00001", "S00000", "SEC_UC", "User Creation", "SUC", (byte) 0, (byte) 1,"A"));
       ar.add(new MPermissions("S00002", "S00000", "SEC_GP", "Group Permission", "SGP", (byte) 0, (byte) 1,"A"));
       ar.add(new MPermissions("S00003", "S00000", "SEC_US", "User Security", "SUS", (byte) 0, (byte) 1,"A"));
               
       //Accounts 
        ar.add(new MPermissions("A00000", "A00000", "ACCOUNTS", "Accounts/Payments", "ACC", (byte) 1, (byte) 1,"A"));
        ar.add(new MPermissions("A00001", "A00000", "ACHQ", "Cheque Payments", "ACHQ", (byte) 0, (byte) 1,"A"));
       
        
        //Transactions
        ar.add(new MPermissions("T00000", "T00000", "TRANSACTIONS", "Transactions", "TRN", (byte) 1, (byte) 1));
         ar.add(new MPermissions("T00001", "T00000", "T_GRN", "Goods Receive Note", "TRN", (byte) 0, (byte) 1));

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
                        System.err.println(e.getMessage());
                    }

                }

            }
        } catch (Exception ex) {

        }

    }

    private void createSuperAdmin() {

    }
}
