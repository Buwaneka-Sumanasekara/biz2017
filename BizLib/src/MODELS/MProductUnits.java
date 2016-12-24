/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELS;

/**
 *
 * @author HOME
 */
public class MProductUnits {
    String ProId;
    String UnitId;
    Double Volume;
    int Active;

    public MProductUnits() {
    }

    
    public MProductUnits(String ProId, String UnitId, Double Volume, int Active) {
        this.ProId = ProId;
        this.UnitId = UnitId;
        this.Volume = Volume;
        this.Active = Active;
    }

    
    
    public String getProId() {
        return ProId;
    }

    public void setProId(String ProId) {
        this.ProId = ProId;
    }

    public String getUnitId() {
        return UnitId;
    }

    public void setUnitId(String UnitId) {
        this.UnitId = UnitId;
    }

    public Double getVolume() {
        return Volume;
    }

    public void setVolume(Double Volume) {
        this.Volume = Volume;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }
    
    
}
