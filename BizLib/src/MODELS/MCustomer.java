package MODELS;
// Generated Jun 12, 2016 10:23:46 AM by Hibernate Tools 3.6.0

/**
 * MCustomer generated by hbm2java
 */
public class MCustomer  implements java.io.Serializable,MCreditPayee {


     private String id;
     private String name;
     private String addno;
     private String add1;
     private String add2;
     private String add3;
     private String contact;
     private String mobile;
     private Byte active;
    private Double creditLimit;
    private Double creditBalance;

 

    public MCustomer() {
    }
	
       @Override
    public Double getCreditLimit() {
        return creditLimit;
    }

     @Override
    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getCreditBalance() {
        return creditBalance;
    }

     @Override
    public void setCreditBalance(Double creditBalance) {
        this.creditBalance = creditBalance;
    }
   
     @Override
    public String getId() {
        return this.id;
    }
    
     @Override
    public void setId(String id) {
        this.id = id;
    }
     @Override
    public String getName() {
        return this.name;
    }
    
    /**
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    public String getAddno() {
        return this.addno;
    }
    
    public void setAddno(String addno) {
        this.addno = addno;
    }
    public String getAdd1() {
        return this.add1;
    }
    
    public void setAdd1(String add1) {
        this.add1 = add1;
    }
    public String getAdd2() {
        return this.add2;
    }
    
    public void setAdd2(String add2) {
        this.add2 = add2;
    }
    public String getAdd3() {
        return this.add3;
    }
    
    public void setAdd3(String add3) {
        this.add3 = add3;
    }
     @Override
    public String getContact() {
        return this.contact;
    }
    
    /**
     *
     * @param contact
     */
    @Override
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Byte getActive() {
        return this.active;
    }
    
    public void setActive(Byte active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return getName();
    }
   
    
       @Override
    public boolean equals(Object obj) {
        MCustomer c=(MCustomer) obj;
        if(c.id.equals(this.id)){
            return true;
        }else{
            return false;
        }
    }
  
    



}


