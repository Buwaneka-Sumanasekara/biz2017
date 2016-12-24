/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELS;

/**
 *
 * @author Buwanaka
 */
public class MStocks {
    private String LocId;
    private String ProId;
    private String BatchNo;
    private Double CostPrice;
    private Double SellPrice;
    private String UnitId;
    private Double SIH;
    private Double Markup;
    private int Active;

    
    
    public String getLocId() {
        return LocId;
    }

    public void setLocId(String LocId) {
        this.LocId = LocId;
    }

    public String getProId() {
        return ProId;
    }

    public void setProId(String ProId) {
        this.ProId = ProId;
    }

    public String getBatchNo() {
        return BatchNo;
    }

    public void setBatchNo(String BatchNo) {
        this.BatchNo = BatchNo;
    }

    public Double getCostPrice() {
        return CostPrice;
    }

    public void setCostPrice(Double CostPrice) {
        this.CostPrice = CostPrice;
    }

    public Double getSellPrice() {
        return SellPrice;
    }

    public void setSellPrice(Double SellPrice) {
        this.SellPrice = SellPrice;
    }

    public String getUnitId() {
        return UnitId;
    }

    public void setUnitId(String UnitId) {
        this.UnitId = UnitId;
    }

    public Double getSIH() {
        return SIH;
    }

    public void setSIH(Double SIH) {
        this.SIH = SIH;
    }

    public Double getMarkup() {
        return Markup;
    }

    public void setMarkup(Double Markup) {
        this.Markup = Markup;
    }

    @Override
    public String toString() {
        return getBatchNo();
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }
    
    
    
}
