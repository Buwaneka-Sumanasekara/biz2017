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
    private String defaultUnit;

    public String getDefaultUnit() {
        return defaultUnit;
    }

    public void setDefaultUnit(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    public MUnitGroup() {
    }

    public MUnitGroup(String UnitGroupId) {
        this.UnitGroupId = UnitGroupId;
    }

    
    
    public String getUnitGroupId() {
        return UnitGroupId;
    }

    public void setUnitGroupId(String UnitGroupId) {
        if(UnitGroupId.startsWith("UG")){
            this.UnitGroupId = UnitGroupId;
        }else{
            this.UnitGroupId = "UG"+UnitGroupId;
        }
        
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
        return UnitGroupName;
    }

    @Override
    public boolean equals(Object obj) {
        MUnitGroup ug= (MUnitGroup)obj;
        if(ug.UnitGroupId.equals(this.UnitGroupId)){
            return true;
        }else{
            return false;
        }
        
    
    }

   

}
