package MODELS;
// Generated Jun 12, 2016 10:23:46 AM by Hibernate Tools 3.6.0

/**
 * MPaymst generated by hbm2java
 */
public class MPaymst  implements java.io.Serializable {


     private String id;
     private String name;
     private Byte hasdet;
     private Byte refreq;
     private int order;
     private String shortname;
     private Byte active;
     private Byte overpay;
     private Byte datef;
    public MPaymst() {
    }

	
    
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Byte getHasdet() {
        return this.hasdet;
    }
    
    public void setHasdet(Byte hasdet) {
        this.hasdet = hasdet;
    }
    public Byte getRefreq() {
        return this.refreq;
    }
    
    public void setRefreq(Byte refreq) {
        this.refreq = refreq;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    @Override
    public String toString() {
        String name="";
        
        if(getShortname().equals("")){
            name=getName();
        }else{
            name=getShortname();
        }
        
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        MPaymst mst=(MPaymst)obj;
        if(mst.getId().equals(getId())){
            return true;
        }else{
            return false;
        }
        
    }

    public Byte getOverpay() {
        return overpay;
    }

    public void setOverpay(Byte overpay) {
        this.overpay = overpay;
    }

    public Byte getDatef() {
        return datef;
    }

    public void setDatef(Byte datef) {
        this.datef = datef;
    }
   
    
    




}


