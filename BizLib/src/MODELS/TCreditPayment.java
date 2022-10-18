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
public class TCreditPayment {

    String id;
    Date CRdate;
    private MCreditPayee Payee; //customer or supplier id
    String credType;
    Double amount;
    String note;
    private String MPayHedId;
    private String MPaydetId;
    int active;
    private String CRBy;
    Date eftDate;
    int Utilized;
    String payRefNo;
    private String UpBy;
    Date Updateddate;
        String note2;

    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    public String getUpBy() {
        return UpBy;
    }

    public void setUpBy(String UpBy) {
        this.UpBy = UpBy;
    }

    public Date getUpdateddate() {
        return Updateddate;
    }

    public void setUpdateddate(Date Updateddate) {
        this.Updateddate = Updateddate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCRdate() {
        return CRdate;
    }

    public void setCRdate(Date CRdate) {
        this.CRdate = CRdate;
    }

    public MCreditPayee getPayee() {
        return Payee;
    }

    public void setPayee(MCreditPayee Payee) {
        this.Payee = Payee;
    }

    public String getCredType() {
        return credType;
    }

    public void setCredType(String credType) {
        this.credType = credType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCRBy() {
        return CRBy;
    }

    public void setCRBy(String CRBy) {
        this.CRBy = CRBy;
    }

    public Date getEftDate() {
        return eftDate;
    }

    public void setEftDate(Date eftDate) {
        this.eftDate = eftDate;
    }

    public int getUtilized() {
        return Utilized;
    }

    public void setUtilized(int Utilized) {
        this.Utilized = Utilized;
    }

    public String getPayRefNo() {
        return payRefNo;
    }

    public void setPayRefNo(String payRefNo) {
        this.payRefNo = payRefNo;
    }

}
