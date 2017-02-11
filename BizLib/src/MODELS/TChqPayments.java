/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELS;

import java.util.Date;

/**
 *
 * @author Buwanaka
 */
public class TChqPayments {
    private String ChqNo;
    private Date ChqDate;
    private String ChqState;//P-Pending , U-Utilized,Returned-Returned
    private String RefNo;
    private String RefTrnTyp;
    private String CusId;
    private String CusName;
    private String SupId;
    private String SupName;
    private Double Amount;
    private String CRUser;
    private Date CRDate;
    private String MDUser;
    private Date MDDate;

    public String getChqNo() {
        return ChqNo;
    }

    public void setChqNo(String ChqNo) {
        this.ChqNo = ChqNo;
    }

    public Date getChqDate() {
        return ChqDate;
    }

    public void setChqDate(Date ChqDate) {
        this.ChqDate = ChqDate;
    }

    public String getChqState() {
        return ChqState;
    }

    public void setChqState(String ChqState) {
        this.ChqState = ChqState;
    }

    public String getRefNo() {
        return RefNo;
    }

    public void setRefNo(String RefNo) {
        this.RefNo = RefNo;
    }

    public String getRefTrnTyp() {
        return RefTrnTyp;
    }

    public void setRefTrnTyp(String RefTrnTyp) {
        this.RefTrnTyp = RefTrnTyp;
    }

    public String getCusId() {
        return CusId;
    }

    public void setCusId(String CusId) {
        this.CusId = CusId;
    }

    public String getSupId() {
        return SupId;
    }

    public void setSupId(String SupId) {
        this.SupId = SupId;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double Amount) {
        this.Amount = Amount;
    }

    public String getCRUser() {
        return CRUser;
    }

    public void setCRUser(String CRUser) {
        this.CRUser = CRUser;
    }

    public Date getCRDate() {
        return CRDate;
    }

    public void setCRDate(Date CRDate) {
        this.CRDate = CRDate;
    }

    public String getMDUser() {
        return MDUser;
    }

    public void setMDUser(String MDUser) {
        this.MDUser = MDUser;
    }

    public Date getMDDate() {
        return MDDate;
    }

    public void setMDDate(Date MDDate) {
        this.MDDate = MDDate;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public String getSupName() {
        return SupName;
    }

    public void setSupName(String SupName) {
        this.SupName = SupName;
    }
    
    
    
    
    
}
