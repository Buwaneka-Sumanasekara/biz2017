/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

/**
 *
 * @author sular
 */
public interface MCreditPayee {

    public Double getCreditLimit();

    public void setCreditLimit(Double creditLimit);

    public Double getCreditBalance();

    public void setCreditBalance(Double creditBalance);

    public String getId();

    public void setId(String id);

    public String getName();

    public void setName(String name);
    
     public String getContact();

    public void setContact(String contact);
}
