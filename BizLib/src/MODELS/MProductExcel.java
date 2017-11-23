/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import java.util.Vector;

/**
 *
 * @author user pc
 */
public class MProductExcel {
    private MProducts product;
    private Vector<MProductPropertise> proprop;
    private Vector<MSupplier> Suppliers;

    public MProductExcel(MProducts product, Vector<MProductPropertise> proprop, Vector<MSupplier> Suppliers) {
        this.product = product;
        this.proprop = proprop;
        this.Suppliers = Suppliers;
    }

    public Vector<MSupplier> getSuppliers() {
        return Suppliers;
    }

    public void setSuppliers(Vector<MSupplier> Suppliers) {
        this.Suppliers = Suppliers;
    }

    public MProducts getProduct() {
        return product;
    }

    public void setProduct(MProducts product) {
        this.product = product;
    }

    public Vector<MProductPropertise> getProprop() {
        return proprop;
    }

    public void setProprop(Vector<MProductPropertise> proprop) {
        this.proprop = proprop;
    }

    @Override
    public String toString() {
        return this.getProduct().getName();
    }
    
    
    
            
}
