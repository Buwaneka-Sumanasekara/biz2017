package MODELS;
// Generated Jun 12, 2016 10:23:46 AM by Hibernate Tools 3.6.0

/**
 * TStockline generated by hbm2java
 */
public class TStockline implements java.io.Serializable {

    private int LineNo;

    private TStockmst TStockmst;
     private UTransactions UTransactions;
    private Double sprice;
    private Double cprice;
    private Double qty;
    private Double ldis;
    private Double ldisper;
    private Double amount;
    private String proname;
    private String UnitId;
    private String UnitGroupId;
    private String ProId;
    private String Batch;
    private int IsGV;
   private String  RefTrnNo;
    
    
    public TStockmst getTStockmst() {
        return this.TStockmst;
    }

    public void setTStockmst(TStockmst TStockmst) {
        this.TStockmst = TStockmst;
    }

    public Double getSprice() {
        return this.sprice;
    }

    public void setSprice(Double sprice) {
        this.sprice = sprice;
    }

    public Double getCprice() {
        return this.cprice;
    }

    public void setCprice(Double cprice) {
        this.cprice = cprice;
    }

    public Double getQty() {
        return this.qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getLdis() {
        return this.ldis;
    }

    public void setLdis(Double ldis) {
        this.ldis = ldis;
    }

    public Double getLdisper() {
        return this.ldisper;
    }

    public void setLdisper(Double ldisper) {
        this.ldisper = ldisper;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getLineNo() {
        return LineNo;
    }

    public void setLineNo(int LineNo) {
        this.LineNo = LineNo;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getUnitId() {
        return UnitId;
    }

    public void setUnitId(String UnitId) {
        this.UnitId = UnitId;
    }

    public String getUnitGroupId() {
        return UnitGroupId;
    }

    public void setUnitGroupId(String UnitGroupId) {
        this.UnitGroupId = UnitGroupId;
    }

    public String getProId() {
        return ProId;
    }

    public void setProId(String ProId) {
        this.ProId = ProId;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    public UTransactions getUTransactions() {
        return UTransactions;
    }

    public void setUTransactions(UTransactions UTransactions) {
        this.UTransactions = UTransactions;
    }

    public int getIsGV() {
        return IsGV;
    }

    public void setIsGV(int IsGV) {
        this.IsGV = IsGV;
    }

    public String getRefTrnNo() {
        return RefTrnNo;
    }

    public void setRefTrnNo(String RefTrnNo) {
        this.RefTrnNo = RefTrnNo;
    }

}
