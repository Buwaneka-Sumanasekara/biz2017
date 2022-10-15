/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CONTROLLERS;

import DB_ACCESS.DB;
import MODELS.MCustomer;
import QUERYBUILDER.QueryGen;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Buwanaka
 */
public class C_Customers {
    QueryGen qg=null;
    public C_Customers() {
        qg=new QueryGen();
    }
    
    
    public Vector<MCustomer> getAllCustomers() throws Exception {
        String q = "SELECT * FROM M_CUSTOMER WHERE ACTIVE=1";
        ResultSet rs = DB.Search(q);

        Vector<MCustomer> v = new Vector();
        while (rs.next()) {
            MCustomer c = new MCustomer();
            c.setId(rs.getString("ID"));
            c.setName(rs.getString("NAME"));
            c.setAddno(rs.getString("ADDNO"));
            c.setAdd1(rs.getString("ADD1"));
            c.setAdd2(rs.getString("ADD2"));
            c.setAdd3(rs.getString("ADD3"));
            c.setContact(rs.getString("CONTACT"));
            c.setMobile(rs.getString("MOBILE"));
            c.setActive(rs.getByte("ACTIVE"));
              c.setCreditLimit(rs.getDouble("CREDIT_LIMIT"));
              c.setCreditBalance(rs.getDouble("CREDIT_BALANCE"));
          
            v.add(c);
        }
        return v;
    }
    
    public MCustomer getCustomer(String CustomerId) throws Exception {
        String q = "SELECT * FROM M_CUSTOMER WHERE ID='"+CustomerId+"'";
        ResultSet rs = DB.Search(q);

        MCustomer c=null;
        if (rs.next()) {
             c = new MCustomer();
            c.setId(rs.getString("ID"));
            c.setName(rs.getString("NAME"));
            c.setAddno(rs.getString("ADDNO"));
            c.setAdd1(rs.getString("ADD1"));
            c.setAdd2(rs.getString("ADD2"));
            c.setAdd3(rs.getString("ADD3"));
            c.setContact(rs.getString("CONTACT"));
            c.setMobile(rs.getString("MOBILE"));
            c.setActive(rs.getByte("ACTIVE"));
            c.setCreditLimit(rs.getDouble("CREDIT_LIMIT"));
              c.setCreditBalance(rs.getDouble("CREDIT_BALANCE"));
            
        }
        return c;
    }
        public MCustomer getCustomer(String Id, int state) throws Exception {
        String sql = "SELECT * FROM M_CUSTOMER where ID='" + Id + "' ";
        if(state==0 || state==1){
            sql+=" AND ACTIVE=" + state ;
        }
        MCustomer c = new MCustomer();

        ResultSet rs = DB.Search(sql);
        if (rs.next()) {
            c.setId(rs.getString("ID"));
            c.setName(rs.getString("NAME"));
            c.setAddno(rs.getString("ADDNO"));
            c.setAdd1(rs.getString("ADD1"));
            c.setAdd2(rs.getString("ADD2"));
            c.setAdd3(rs.getString("ADD3"));
            c.setContact(rs.getString("CONTACT"));
            c.setMobile(rs.getString("MOBILE"));
            c.setActive(rs.getByte("ACTIVE"));
              c.setCreditLimit(rs.getDouble("CREDIT_LIMIT"));
              c.setCreditBalance(rs.getDouble("CREDIT_BALANCE"));
        }
        return c;
    }
       public MCustomer CheckExists(String SupName) throws Exception {
        String sql = "SELECT * FROM M_CUSTOMER WHERE NAME='" + SupName.toUpperCase() + "' ";
        ResultSet rs = DB.Search(sql);
        MCustomer c = null;
        if (rs.next()) {
            c = new MCustomer();
            c.setId(rs.getString("ID"));
            c.setName(rs.getString("NAME"));
            c.setAddno(rs.getString("ADDNO"));
            c.setAdd1(rs.getString("ADD1"));
            c.setAdd2(rs.getString("ADD2"));
            c.setAdd3(rs.getString("ADD3"));
            c.setContact(rs.getString("CONTACT"));
            c.setMobile(rs.getString("MOBILE"));
            c.setActive(rs.getByte("ACTIVE"));
             c.setCreditLimit(rs.getDouble("CREDIT_LIMIT"));
              c.setCreditBalance(rs.getDouble("CREDIT_BALANCE"));
        }
        return c;
    } 
        public int SaveCustomer(MCustomer c) throws Exception {
        String sql = "INSERT INTO M_CUSTOMER(ID,NAME,ADDNO,ADD1,ADD2,ADD3,CREDIT_LIMIT,CONTACT,MOBILE,ACTIVE) "
                + "VALUES('" + c.getId().toUpperCase() + "','" + c.getName().toUpperCase() + "','" + c.getAddno().toUpperCase()
                + "','" + c.getAdd1().toUpperCase() + "','" + c.getAdd2().toUpperCase() + "','" + c.getAdd3().toUpperCase()
                + "','" + c.getCreditLimit()
                + "','"+ c.getContact() + "','"+ c.getMobile() + "','" + c.getActive() + "')";
        return DB.Save(sql);
    }
            public int UpdateCustomer(MCustomer c) throws Exception {
        if (c.getId() != "") {
            String sql = "UPDATE M_CUSTOMER SET NAME='" + c.getName().toUpperCase()
                    + "',ADDNO='" + c.getAddno().toUpperCase() + "',ADD1='" + c.getAdd1().toUpperCase()
                    + "',ADD2='" + c.getAdd2().toUpperCase()+ "',ADD3='" + c.getAdd3().toUpperCase() + "',CONTACT='" + c.getContact()
                    + "',CREDIT_LIMIT='" + c.getCreditLimit()
                    + "',MOBILE='" + c.getMobile() + "',ACTIVE=" + c.getActive() + " WHERE ID='" + c.getId() + "'";
            return DB.Update(sql);
        } else {
            return -1;
        }
    }
    
}
