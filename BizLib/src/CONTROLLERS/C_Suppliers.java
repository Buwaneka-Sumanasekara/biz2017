/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import DB_ACCESS.DB;
import MODELS.MSupplier;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Buwanaka
 */
public class C_Suppliers {

    public Vector<MSupplier> getAllSuppliers() throws Exception {
        String q = "SELECT * FROM M_SUPPLIER WHERE ACTIVE=1 order by NAME asc";
        ResultSet rs = DB.Search(q);

        Vector<MSupplier> v = new Vector();
        while (rs.next()) {
            MSupplier s = new MSupplier();
            s.setId(rs.getString("ID"));
            s.setName(rs.getString("NAME"));
            s.setMobile(rs.getString("MOBILE"));
            s.setContact(rs.getString("CONTACT"));
            s.setContactperson(rs.getString("CONTACTPERSON"));
            s.setActive(rs.getByte("ACTIVE"));
            s.setAddress(rs.getString("ADDRESS"));
            s.setCreditLimit(rs.getDouble("CREDIT_LIMIT"));
            s.setCreditBalance(rs.getDouble("CREDIT_BALANCE"));
            v.add(s);
        }
        return v;
    }

    public MSupplier getSupplier(String Id) throws Exception {
        return getSupplier(Id, -1);
    }

    public MSupplier getSupplier(String Id, int state) throws Exception {
        String sql = "SELECT * FROM M_SUPPLIER where ID='" + Id + "' ";
        if (state == 0 || state == 1) {
            sql += " AND ACTIVE=" + state;
        }
         sql+=" order by NAME asc";
         
        MSupplier s = new MSupplier();

        ResultSet rs = DB.Search(sql);
        if (rs.next()) {
            s.setId(rs.getString("ID"));
            s.setName(rs.getString("NAME"));
            s.setMobile(rs.getString("MOBILE"));
            s.setContact(rs.getString("CONTACT"));
            s.setContactperson(rs.getString("CONTACTPERSON"));
            s.setActive(rs.getByte("ACTIVE"));
            s.setAddress(rs.getString("ADDRESS"));
            s.setCreditLimit(rs.getDouble("CREDIT_LIMIT"));
            s.setCreditBalance(rs.getDouble("CREDIT_BALANCE"));
        }

        return s;
    }

    public MSupplier CheckExists(String SupName) throws Exception {
        String sql = "SELECT * FROM M_SUPPLIER WHERE NAME='" + SupName.toUpperCase() + "' order by NAME asc";
        ResultSet rs = DB.Search(sql);
        MSupplier s = null;
        if (rs.next()) {
            s = new MSupplier();
            s.setId(rs.getString("ID"));
            s.setName(rs.getString("NAME"));
            s.setMobile(rs.getString("MOBILE"));
            s.setContact(rs.getString("CONTACT"));
            s.setContactperson(rs.getString("CONTACTPERSON"));
            s.setActive(rs.getByte("ACTIVE"));
            s.setAddress(rs.getString("ADDRESS"));
            s.setCreditLimit(rs.getDouble("CREDIT_LIMIT"));
            s.setCreditBalance(rs.getDouble("CREDIT_BALANCE"));
        }
        return s;
    }

    public int SaveSupplier(MSupplier s) throws Exception {
        String sql = "INSERT INTO M_SUPPLIER(ID,NAME,CONTACTPERSON,CREDIT_LIMIT,CONTACT,MOBILE,ADDRESS,ACTIVE) "
                + "VALUES('" + s.getId().toUpperCase() + "','" + s.getName().toUpperCase() + "','" + s.getContactperson().toUpperCase()
                + "','" + s.getCreditLimit()
                + "','" + s.getContact() + "','" + s.getMobile() + "','" + s.getAddress().toUpperCase() + "'," + s.getActive() + ")";
        return DB.Save(sql);
    }

    public int UpdateSupplier(MSupplier s) throws Exception {
        if (s.getId() != "") {
            String sql = "UPDATE M_SUPPLIER SET NAME='" + s.getName().toUpperCase()
                    + "',CONTACTPERSON='" + s.getContactperson().toUpperCase() + "',CONTACT='" + s.getContact() + "',MOBILE='" + s.getMobile()
                    + "',CREDIT_LIMIT='" + s.getCreditLimit()
                    + "',ADDRESS='" + s.getAddress().toUpperCase() + "',ACTIVE=" + s.getActive() + " WHERE ID='" + s.getId() + "'";
            return DB.Update(sql);
        } else {
            return -1;
        }
    }
}
