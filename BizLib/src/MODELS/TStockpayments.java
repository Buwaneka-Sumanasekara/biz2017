package MODELS;
// Generated Jun 12, 2016 10:23:46 AM by Hibernate Tools 3.6.0

import java.util.Date;




/**
 * TStockpayments generated by hbm2java
 */
public class TStockpayments  implements java.io.Serializable {


     private int id;
     private TStockmst TStockmst;
   private UTransactions UTransactions;
     private String MPayHedId;
     private String MPaydetId;
     private String refno;
     private Double frmamount;
     private Double amount;
     private Double change;
     private String EfectiveDate;
     
    public TStockpayments() {
    }

 

	
    
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public TStockmst getTStockmst() {
        return this.TStockmst;
    }
    
    public void setTStockmst(TStockmst TStockmst) {
        this.TStockmst = TStockmst;
    }
 
    public String getRefno() {
        return this.refno;
    }
    
    public void setRefno(String refno) {
        this.refno = refno;
    }
    public Double getFrmamount() {
        return this.frmamount;
    }
    
    public void setFrmamount(Double frmamount) {
        this.frmamount = frmamount;
    }
    public Double getAmount() {
        return this.amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Double getChange() {
        return this.change;
    }
    
    public void setChange(Double change) {
        this.change = change;
    }

    public String getMPayHedId() {
        return MPayHedId;
    }

    public void setMPayHedId(String MPayHedId) {
        this.MPayHedId = MPayHedId;
    }

    public String getMPaydetId() {
        return MPaydetId;
    }

    public void setMPaydetId(String MPaydetId) {
        this.MPaydetId = MPaydetId;
    }

    public String getEfectiveDate() {
        return EfectiveDate;
    }

    public void setEfectiveDate(String EfectiveDate) {
        this.EfectiveDate = EfectiveDate;
    }

    public UTransactions getUTransactions() {
        return UTransactions;
    }

    public void setUTransactions(UTransactions UTransactions) {
        this.UTransactions = UTransactions;
    }




}


