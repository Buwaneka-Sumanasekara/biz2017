package MODELS;
// Generated Jun 12, 2016 10:23:46 AM by Hibernate Tools 3.6.0

import java.util.Date;


/**
 * MSupplier generated by hbm2java
 */
public class MSupplier implements java.io.Serializable, MCreditPayee {

    private String id;
    private String name;
    private String contactperson;
    private String contact;
    private String mobile;
    private Byte active;
    private String address;
    private Double creditLimit;
    private Double creditBalance;
     private Date lastSettlementDate;

    @Override
    public Date getLastSettlementDate() {
        return lastSettlementDate;
    }

    @Override
    public void setLastSettlementDate(Date lastSettlementDate) {
        this.lastSettlementDate = lastSettlementDate;
    }

    public MSupplier() {
    }

    @Override
    public Double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     *
     * @return
     */
    @Override
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


    public MSupplier(String id) {
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

    public String getContactperson() {
        return this.contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    @Override
    public String getContact() {
        return this.contact;
    }

    @Override
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String getMobile() {
        return this.mobile;
    }

    @Override
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getActive() {
        return this.active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  this.name;
    }

    @Override
    public boolean equals(Object obj) {
        MSupplier s = (MSupplier) obj;
        if (s.id.equals(this.id)) {
            return true;
        } else {
            return false;
        }
    }

}
