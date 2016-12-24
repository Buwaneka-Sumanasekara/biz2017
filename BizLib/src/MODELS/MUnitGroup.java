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
public class MUnitGroup {
    private String UnitGroupId;
    private String UnitGroupName;
    private int UnitGroupActive;

    public String getUnitGroupId() {
        return UnitGroupId;
    }

    public void setUnitGroupId(String UnitGroupId) {
        this.UnitGroupId = UnitGroupId;
    }

    public String getUnitGroupName() {
        return UnitGroupName;
    }

    public void setUnitGroupName(String UnitGroupName) {
        this.UnitGroupName = UnitGroupName;
    }

    public int getUnitGroupActive() {
        return UnitGroupActive;
    }

    public void setUnitGroupActive(int UnitGroupActive) {
        this.UnitGroupActive = UnitGroupActive;
    }

    @Override
    public String toString() {
        return getUnitGroupName();
    }
    
    
    
}
