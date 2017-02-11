/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WINMNG;

import CONTROLLERS.C_TransactionSetup;
import MAIN.Frm_Main;
import MODELS.MPermissions;
import MODELS.UTransactions;
import SUBUI.Frm_MCustomer;
import SUBUI.Frm_MGroup;
import SUBUI.Frm_MGroupMap;
import SUBUI.Frm_MItems;
import SUBUI.Frm_MLocation;
import SUBUI.Frm_MSupplier;
import SUBUI.Frm_MUnitGroup;
import SUBUI.Frm_MUnits;
import SUBUI.Frm_SUserCreation;
import SUBUI.Frm_SUserGroupPer;
import SUBUI.Frm_SUserSecurity;
import SUBUI.Frm_TChequePayments;
import SUBUI.Frm_TCommonTrn;
import javax.swing.JInternalFrame;

/**
 *
 * @author HOME
 */
public class MyWindowManager {

    C_TransactionSetup cTrnSetup = null;

    public MyWindowManager() {
        cTrnSetup = new C_TransactionSetup();
    }

    public JInternalFrame getRequestWindow(MPermissions p, Frm_Main fm) throws Exception {
        JInternalFrame jf = null;
        if (!p.getType().equals("TRN")) {
            switch (p.getId()) {
                case "M00001":
                    jf = new Frm_MLocation(fm);
                    break;
                case "M00002":
                    jf = new Frm_MGroup(fm, "m_group1", p.getDescription(), "G1");
                    break;
                case "M00003":
                    jf = new Frm_MGroup(fm, "m_group2", p.getDescription(), "G2");
                    break;
                case "M00004":
                    jf = new Frm_MGroup(fm, "m_group3", p.getDescription(), "G3");
                    break;
                case "M00005":
                    jf = new Frm_MGroup(fm, "m_group4", p.getDescription(), "G4");
                    break;
                case "M00006":
                    jf = new Frm_MGroup(fm, "m_group5", p.getDescription(), "G5");
                    break;
                case "M00007":
                    jf = new Frm_MUnits(fm, p.getDescription());
                    break;
                case "M00008":
                    jf = new Frm_MItems(fm, p.getDescription());
                    break;
                case "M00009":
                    jf = new Frm_MSupplier(fm, p.getDescription());
                    break;
                case "M00010":
                    jf = new Frm_MCustomer(fm, p.getDescription());
                    break;
                case "M00011":
                    jf = new Frm_MGroupMap(fm, p.getDescription());
                    break;
                case "M00012":
                    jf = new Frm_MUnitGroup(fm, p.getDescription());
                    break;
                case "S00001":
                    jf = new Frm_SUserCreation(fm, p.getDescription());
                    break;
                case "S00002":
                    jf = new Frm_SUserGroupPer(fm, p.getDescription());
                    break;
                case "S00003":
                    jf = new Frm_SUserSecurity(fm, p.getDescription());
                    break;
                     case "A00001":
                    jf = new Frm_TChequePayments(fm, p.getDescription());
                    break;
            }
        } else if (p.getType().equals("TRN")) {
            switch (p.getId()) {
                default:

                    UTransactions transactionConfig = cTrnSetup.getTransactionConfig(p.getId());
                    if (transactionConfig != null) {
                        jf = new Frm_TCommonTrn(fm, transactionConfig.getTrndesc(), transactionConfig);
                    }

                    break;
            }
        }
        return jf;
    }

}
