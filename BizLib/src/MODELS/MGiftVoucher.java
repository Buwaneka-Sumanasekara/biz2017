/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELS;

import java.util.Date;

/**
 *
 * @author Home
 */
public class MGiftVoucher {
    private String GrpNo;
    private String GVNo;
    private Double GVValue;
    private int CRLoc;
    private String CRBy;
    private Date CRDate;
    private int PurLoc;
    private Date PurDate;
    private String PurCrBy;
    private String PurRefNo;
    private int Active;
    private String gvDes;
private byte IsPurchased;
    
    
    

    
    public String getGrpNo() {
        return GrpNo;
    }

    public void setGrpNo(String GrpNo) {
        this.GrpNo = GrpNo;
    }

    public String getGVNo() {
        return GVNo;
    }

    public void setGVNo(String GVNo) {
        this.GVNo = GVNo;
    }

    public Double getGVValue() {
        return GVValue;
    }

    public void setGVValue(Double GVValue) {
        this.GVValue = GVValue;
    }

    public int getCRLoc() {
        return CRLoc;
    }

    public void setCRLoc(int CRLoc) {
        this.CRLoc = CRLoc;
    }

    
    public Date getCRDate() {
        return CRDate;
    }

    public void setCRDate(Date CRDate) {
        this.CRDate = CRDate;
    }

    public int getPurLoc() {
        return PurLoc;
    }

    public void setPurLoc(int PurLoc) {
        this.PurLoc = PurLoc;
    }

    public Date getPurDate() {
        return PurDate;
    }

    public void setPurDate(Date PurDate) {
        this.PurDate = PurDate;
    }

    

    public String getPurRefNo() {
        return PurRefNo;
    }

    public void setPurRefNo(String PurRefNo) {
        this.PurRefNo = PurRefNo;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }

    public String getCRBy() {
        return CRBy;
    }

    public void setCRBy(String CRBy) {
        this.CRBy = CRBy;
    }

    public String getPurCrBy() {
        return PurCrBy;
    }

    public void setPurCrBy(String PurCrBy) {
        this.PurCrBy = PurCrBy;
    }

    public byte getIsPurchased() {
        return IsPurchased;
    }

    public void setIsPurchased(byte IsPurchased) {
        this.IsPurchased = IsPurchased;
    }

    public String getGvDes() {
        return gvDes;
    }

    public void setGvDes(String gvDes) {
        this.gvDes = gvDes;
    }
    
    
    
    
}
