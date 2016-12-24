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
public class MProductPropertise {
    String ProductId;
    String PropertyId;
    String PropertyValue;

    
    public MProductPropertise() {

    }

    public MProductPropertise(String ProductId, String PropertyId, String PropertyValue) {
        this.ProductId = ProductId;
        this.PropertyId = PropertyId;
        this.PropertyValue = PropertyValue;
    }

    
    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public String getPropertyId() {
        return PropertyId;
    }

    public void setPropertyId(String PropertyId) {
        this.PropertyId = PropertyId;
    }

    public String getPropertyValue() {
        return PropertyValue;
    }

    public void setPropertyValue(String PropertyValue) {
        this.PropertyValue = PropertyValue;
    }

  
    
    
   
    
}
