/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CONTROLLERS;

import DB_ACCESS.DB;
import MODELS.TChqPayments;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author Buwanaka
 */
public class C_ChequePayments {
    SimpleDateFormat sdf=null;
    QUERYBUILDER.QueryGen qg=null;
    public C_ChequePayments() {
        qg=new QUERYBUILDER.QueryGen();
        sdf=new SimpleDateFormat("yyyy-MM-dd");
    }

    public TChqPayments getSpecificPayment(String ChqNo) throws Exception{
          String q="SELECT CP.CHQ_NO AS CHQ_NO,CP.CHQ_DATE AS CHQ_DATE,CP.STATE AS STATE,CP.REFNO AS REFNO,CP.REFTRNTYP AS REFTRNTYP,  ";
          q+="CP.CUS_ID AS CUS_ID,CP.SUP_ID AS SUP_ID,CP.AMOUNT AS AMOUNT,CP.CRDATE AS CRDATE,CP.M_USER_CR AS M_USER_CR,CP.M_USER_MD AS M_USER_MD,";
         q+="CP.MDDATE,S.NAME AS SUPNAME,C.NAME AS CUSNAME "; 
          q+= "FROM T_CHQPAYMENTS CP LEFT JOIN M_SUPPLIER S ON CP.SUP_ID=S.ID ";
          q+= "LEFT JOIN M_CUSTOMER C ON CP.CUS_ID=C.ID ";
          
          q+=" WHERE ";
          q+=" CHQ_NO='"+ChqNo+"' ";
        
        ResultSet rs = DB.Search(q);
        TChqPayments m=null;  
        if(rs.next()){
              m=new TChqPayments();
              m.setChqNo(rs.getString("CHQ_NO"));
              m.setChqDate(rs.getDate("CHQ_DATE"));
              m.setChqState(rs.getString("STATE"));
              m.setRefNo(rs.getString("REFNO"));
              m.setRefTrnTyp(rs.getString("REFTRNTYP"));
              m.setCusId(rs.getString("CUS_ID"));
              m.setSupId(rs.getString("SUP_ID"));
              m.setAmount(rs.getDouble("AMOUNT"));
              m.setCRDate(rs.getDate("CRDATE"));
              m.setCRUser(rs.getString("M_USER_CR"));
              m.setMDUser(rs.getString("M_USER_MD"));
              m.setMDDate(rs.getDate("MDDATE"));
              m.setSupName(rs.getString("SUPNAME"));
              m.setCusName(rs.getString("CUSNAME"));
          }
        return m;
    }
    
    public ArrayList<Vector> getAllPayments(String ChqNo,String State,Date datef,Date datet) throws Exception{
        String q="SELECT * FROM T_CHQPAYMENTS ";
        if(ChqNo.equals("")==false || State.equals("")==false || (datef.equals("")==false && datet.equals("")==false)){
            q+=" WHERE ";
        }
        if(ChqNo.equals("")==false){
            q+=" CHQ_NO='"+ChqNo+"' ";
        }
        else  if(State.equals("")==false){
            if(ChqNo.equals("")){
                q+=" STATE='"+State+"' ";
            }else{
                q+=" AND STATE='"+State+"' ";
            }
        }else  if(datef.equals("")==false && datet.equals("")==false){
            if(State.equals("") && ChqNo.equals("")){
                q+=" CRDATE BETWEEN '"+sdf.format(datef)+"' AND '"+sdf.format(datet)+"' ";
            }else{
                q+=" AND CRDATE BETWEEN '"+sdf.format(datef)+"' AND '"+sdf.format(datet)+"' ";
            }
        }
        System.out.println(q);
        ResultSet rs = DB.Search(q);
        ArrayList<Vector> ar=new ArrayList<>();
        while (rs.next()) {
            Vector v =new Vector();
            
            String state=rs.getString("STATE");
            
            v.add(rs.getString("CHQ_NO"));
            v.add(rs.getString("CHQ_DATE"));
            v.add(rs.getString("CRDATE"));
            v.add(rs.getString("AMOUNT"));
            String state_txt=(state.equals("P")?"Unrealized":state.equals("U")?"Realized":"Returned");
            v.add(state_txt);
            v.add(rs.getString("REFNO"));
            v.add(rs.getString("REFTRNTYP"));
            v.add(state);
            
            ar.add(v);
        }
        return ar;
    }
    
    
    public void UpdateState(TChqPayments chkPay,String State,Date date) throws Exception{
        Map<String,String>m=new TreeMap<String,String>();
        m.put("STATE", "'"+State+"'");
        m.put("MDDATE", "'"+sdf.format(date)+"'");
        m.put("M_USER_MD", "'"+GLOBALDATA.GlobalData.CurUser.getId()+"'");
        
        String UpdateRecord = qg.UpdateRecord("T_CHQPAYMENTS", m, "WHERE CHQ_NO='"+chkPay.getChqNo()+"'");
        DB.Update(UpdateRecord);
        
        Map<String,String>mTrn=new TreeMap<String,String>();
        mTrn.put("T_STOCKMST_ID", "'"+chkPay.getRefNo()+"'");
        mTrn.put("TRNTYP", "'"+chkPay.getRefTrnTyp()+"'");
        
        int utilized=(State.equals("U")?1:0);
        String eftdate=(utilized==1?sdf.format(date):"1900-01-01");
        
        mTrn.put("UTILIZED", "'"+utilized+"'");
        mTrn.put("EFT_DATE", "'"+eftdate+"'");
        
        String UpdateStkPay = qg.UpdateRecord("T_STOCKPAYMENTS", mTrn, "WHERE T_STOCKMST_ID='"+chkPay.getRefNo()+"' AND TRNTYP='"+chkPay.getRefTrnTyp()+"' AND PAYHEDID='CHQ' ");
        DB.Update(UpdateStkPay);
        
        
    }
    
}
