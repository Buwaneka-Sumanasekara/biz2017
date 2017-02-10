/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CONTROLLERS;

import DB_Access.DB;
import MODELS.UTransactions;
import QUERYBUILDER.QueryGen;
import java.sql.ResultSet;

/**
 *
 * @author Buwanaka
 */
public class C_TransactionSetup {

    QUERYBUILDER.QueryGen qg=null;
    public C_TransactionSetup() {
        qg=new QueryGen();
    }
    
    public UTransactions getTransactionConfig(String TrnSetupNo) throws Exception{
        String q="SELECT * FROM U_TRANSACTIONS WHERE TRNNO='"+TrnSetupNo+"' AND ACTIVE=1";
        UTransactions m=null;
        ResultSet rs = DB.Search(q);
        if (rs.next()) {            
            m=new UTransactions();
            m.setTrnno(rs.getString("TRNNO"));
            m.setTrntype(rs.getString("TRNTYPE"));
            m.setReftrntype(rs.getString("REFTRNTYPE"));
            m.setRefno(rs.getString("REFNO"));
            m.setRefno2(rs.getString("REFNO2"));
            m.setTrndesc(rs.getString("TRNDESC"));
            m.setActive(rs.getByte("ACTIVE"));
            m.setStockentyp(rs.getInt("STOCKENTYP"));
            m.setDefprice(rs.getString("DEFPRICE"));
            m.setLinedis(rs.getByte("LINEDIS"));
            m.setLinedisper(rs.getByte("LINEDISPER"));
            m.setCustomer(rs.getByte("CUSTOMER"));
            m.setSupplier(rs.getByte("SUPPLIER"));
            m.setCprice(rs.getByte("CPRICE"));
            m.setSprice(rs.getByte("SPRICE"));
            m.setBatchcreate(rs.getByte("BATCHCREATE"));
            m.setDatechooser(rs.getByte("DATECHOOSER"));
            m.setFuturedate(rs.getByte("FUTUREDATE"));
            m.setChgdefprice(rs.getByte("CHGDEFPRICE"));
            m.setSourceloc(rs.getByte("SOURCELOC"));
            m.setDestloc(rs.getByte("DESTLOC"));
            m.setPayments(rs.getByte("PAYMENTS"));
            m.setReportpath(rs.getString("REPORT_PATH"));
            
        }else{
            throw new Exception("Can`t Find Specific Trnasaction on setup table");
        }
        return m;
    }
    
    
  
    
}
