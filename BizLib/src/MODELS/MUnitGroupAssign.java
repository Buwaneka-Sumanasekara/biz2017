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
public class MUnitGroupAssign {
    private String UnitGroupId;
    private String UnitId;
    private double Volume;
    private int IsBase;
    private int Active;

    public MUnitGroupAssign() {
    }

    
    public MUnitGroupAssign(String UnitGroupId, String UnitId, double Volume, int IsBase, int Active) {
        this.UnitGroupId = UnitGroupId;
        this.UnitId = UnitId;
        this.Volume = Volume;
        this.IsBase = IsBase;
        this.Active = Active;
    }

    public String getUnitGroupId() {
        return UnitGroupId;
    }

    public void setUnitGroupId(String UnitGroupId) {
        this.UnitGroupId = UnitGroupId;
    }

    public String getUnitId() {
        return UnitId;
    }

    public void setUnitId(String UnitId) {
        this.UnitId = UnitId;
    }

    public double getVolume() {
        return Volume;
    }

    public void setVolume(double Volume) {
        this.Volume = Volume;
    }

    public int getIsBase() {
        return IsBase;
    }

    public void setIsBase(int IsBase) {
        this.IsBase = IsBase;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }
    
    
    
}
