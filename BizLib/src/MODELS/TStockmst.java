package MODELS;
// Generated Jun 12, 2016 10:23:46 AM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * TStockmst generated by hbm2java
 */
public class TStockmst  implements java.io.Serializable {


     private String id;
     private UTransactions UTransactions;
     private MCustomer MCustomer;
     private MLocation MLocationByMLocationSource;
     private MUser MUserByMUserCr;
     private MSupplier MSupplier;
     private MLocation MLocationByMLocationDest;
     private MUser MUserByMUserMd;
     private Byte fullutilize;
     private Date crdate;
     private Date mddate;
     private String refno;
     private String refno2;
     private String refnote;
     private Byte isactive;
     private String trnstate;
     private Double gramount;
     private Double netdis;
     private Double netamount;
     private Date EftDate;
    private String RefTrnNo;
    private Double change; 
     
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public UTransactions getUTransactions() {
        return this.UTransactions;
    }
    
    public void setUTransactions(UTransactions UTransactions) {
        this.UTransactions = UTransactions;
    }
    public MCustomer getMCustomer() {
        return this.MCustomer;
    }
    
    public void setMCustomer(MCustomer MCustomer) {
        this.MCustomer = MCustomer;
    }
    public MLocation getMLocationByMLocationSource() {
        return this.MLocationByMLocationSource;
    }
    
    public void setMLocationByMLocationSource(MLocation MLocationByMLocationSource) {
        this.MLocationByMLocationSource = MLocationByMLocationSource;
    }
    public MUser getMUserByMUserCr() {
        return this.MUserByMUserCr;
    }
    
    public void setMUserByMUserCr(MUser MUserByMUserCr) {
        this.MUserByMUserCr = MUserByMUserCr;
    }
    public MSupplier getMSupplier() {
        return this.MSupplier;
    }
    
    public void setMSupplier(MSupplier MSupplier) {
        this.MSupplier = MSupplier;
    }
    public MLocation getMLocationByMLocationDest() {
        return this.MLocationByMLocationDest;
    }
    
    public void setMLocationByMLocationDest(MLocation MLocationByMLocationDest) {
        this.MLocationByMLocationDest = MLocationByMLocationDest;
    }
    public MUser getMUserByMUserMd() {
        return this.MUserByMUserMd;
    }
    
    public void setMUserByMUserMd(MUser MUserByMUserMd) {
        this.MUserByMUserMd = MUserByMUserMd;
    }
    public Byte getFullutilize() {
        return this.fullutilize;
    }
    
    public void setFullutilize(Byte fullutilize) {
        this.fullutilize = fullutilize;
    }
    public Date getCrdate() {
        return this.crdate;
    }
    
    public void setCrdate(Date crdate) {
        this.crdate = crdate;
    }
    public Date getMddate() {
        return this.mddate;
    }
    
    public void setMddate(Date mddate) {
        this.mddate = mddate;
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
    public String getRefnote() {
        return this.refnote;
    }
    
    public void setRefnote(String refnote) {
        this.refnote = refnote;
    }
    public Byte getIsactive() {
        return this.isactive;
    }
    
    public void setIsactive(Byte isactive) {
        this.isactive = isactive;
    }
    public String getTrnstate() {
        return this.trnstate;
    }
    
    public void setTrnstate(String trnstate) {
        this.trnstate = trnstate;
    }
    public Double getGramount() {
        return this.gramount;
    }
    
    public void setGramount(Double gramount) {
        this.gramount = gramount;
    }
    public Double getNetdis() {
        return this.netdis;
    }
    
    public void setNetdis(Double netdis) {
        this.netdis = netdis;
    }
    public Double getNetamount() {
        return this.netamount;
    }
    
    public void setNetamount(Double netamount) {
        this.netamount = netamount;
    }

    public Date getEftDate() {
        return EftDate;
    }

    public void setEftDate(Date EftDate) {
        this.EftDate = EftDate;
    }

    public String getRefTrnNo() {
        return RefTrnNo;
    }

    public void setRefTrnNo(String RefTrnNo) {
        this.RefTrnNo = RefTrnNo;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }
 
    
 




}


