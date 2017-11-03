package MODELS;
// Generated Jun 12, 2016 10:23:46 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * UTransactions generated by hbm2java
 */
public class UTransactions  implements java.io.Serializable {


     private String trnno;
     private String trntype;
     private String reftrntype;
     private String refno;
     private String refno2;
     private String trndesc;
     private Byte active;
     private Integer stockentyp;
     private String defprice;
     private Byte linedis;
     private Byte linedisper;
     private Byte customer;
     private Byte supplier;
     private Byte cprice;
     private Byte sprice;
     private Byte batchcreate;
     private Byte datechooser;
     private Byte futuredate;
     private Byte chgdefprice;
     private Byte sourceloc;
     private Byte destloc;
     private Byte payments;
     private String Reportpath;
     private Byte isPosTran;
     private Byte displayunit;
     private Byte PreviewRep;
     private Byte CancelOpt;
     private int CancelDaysWithing;
     
     private Set TStockmsts = new HashSet(0);

    public UTransactions() {
    }

	
    public UTransactions(String trnno) {
        this.trnno = trnno;
    }
  
   
    public String getTrnno() {
        return this.trnno;
    }
    
    public void setTrnno(String trnno) {
        this.trnno = trnno;
    }
    public String getTrntype() {
        return this.trntype;
    }
    
    public void setTrntype(String trntype) {
        this.trntype = trntype;
    }
    public String getReftrntype() {
        return this.reftrntype;
    }
    
    public void setReftrntype(String reftrntype) {
        this.reftrntype = reftrntype;
    }
    public String getRefno() {
        return this.refno;
    }
    
    public void setRefno(String refno) {
        this.refno = refno;
    }
    public String getRefno2() {
        return this.refno2;
    }
    
    public void setRefno2(String refno2) {
        this.refno2 = refno2;
    }
    public String getTrndesc() {
        return this.trndesc;
    }
    
    public void setTrndesc(String trndesc) {
        this.trndesc = trndesc;
    }
    public Byte getActive() {
        return this.active;
    }
    
    public void setActive(Byte active) {
        this.active = active;
    }
    public Integer getStockentyp() {
        return this.stockentyp;
    }
    
    public void setStockentyp(Integer stockentyp) {
        this.stockentyp = stockentyp;
    }
    public String getDefprice() {
        return this.defprice;
    }
    
    public void setDefprice(String defprice) {
        this.defprice = defprice;
    }
    public Byte getLinedis() {
        return this.linedis;
    }
    
    public void setLinedis(Byte linedis) {
        this.linedis = linedis;
    }
    public Byte getLinedisper() {
        return this.linedisper;
    }
    
    public void setLinedisper(Byte linedisper) {
        this.linedisper = linedisper;
    }
    public Byte getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Byte customer) {
        this.customer = customer;
    }
    public Byte getSupplier() {
        return this.supplier;
    }
    
    public void setSupplier(Byte supplier) {
        this.supplier = supplier;
    }
    public Byte getCprice() {
        return this.cprice;
    }
    
    public void setCprice(Byte cprice) {
        this.cprice = cprice;
    }
    public Byte getSprice() {
        return this.sprice;
    }
    
    public void setSprice(Byte sprice) {
        this.sprice = sprice;
    }
    public Byte getBatchcreate() {
        return this.batchcreate;
    }
    
    public void setBatchcreate(Byte batchcreate) {
        this.batchcreate = batchcreate;
    }
    public Byte getDatechooser() {
        return this.datechooser;
    }
    
    public void setDatechooser(Byte datechooser) {
        this.datechooser = datechooser;
    }
    public Byte getFuturedate() {
        return this.futuredate;
    }
    
    public void setFuturedate(Byte futuredate) {
        this.futuredate = futuredate;
    }
    public Byte getChgdefprice() {
        return this.chgdefprice;
    }
    
    public void setChgdefprice(Byte chgdefprice) {
        this.chgdefprice = chgdefprice;
    }
    public Byte getSourceloc() {
        return this.sourceloc;
    }
    
    public void setSourceloc(Byte sourceloc) {
        this.sourceloc = sourceloc;
    }
    public Byte getDestloc() {
        return this.destloc;
    }
    
    public void setDestloc(Byte destloc) {
        this.destloc = destloc;
    }
    public Byte getPayments() {
        return this.payments;
    }
    
    public void setPayments(Byte payments) {
        this.payments = payments;
    }
    public Set getTStockmsts() {
        return this.TStockmsts;
    }
    
    public void setTStockmsts(Set TStockmsts) {
        this.TStockmsts = TStockmsts;
    }

    public String getReportpath() {
        return Reportpath;
    }

    public void setReportpath(String Reportpath) {
        this.Reportpath = Reportpath;
    }

    public Byte getDisplayunit() {
        return displayunit;
    }

    public void setDisplayunit(Byte displayunit) {
        this.displayunit = displayunit;
    }

    public Byte getIsPosTran() {
        return isPosTran;
    }

    public void setIsPosTran(Byte isPosTran) {
        this.isPosTran = isPosTran;
    }

    public Byte getPreviewRep() {
        return PreviewRep;
    }

    public void setPreviewRep(Byte PreviewRep) {
        this.PreviewRep = PreviewRep;
    }

    public Byte getCancelOpt() {
        return CancelOpt;
    }

    public void setCancelOpt(Byte CancelOpt) {
        this.CancelOpt = CancelOpt;
    }

    public int getCancelDaysWithing() {
        return CancelDaysWithing;
    }

    public void setCancelDaysWithing(int CancelDaysWithing) {
        this.CancelDaysWithing = CancelDaysWithing;
    }




}


