/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import java.util.ArrayList;

/**
 *
 * @author user pc
 */
public class MGroupNode {
    private String id;
    private String name;
    private ArrayList<MGroupNode> ar;

    public MGroupNode(String id, String name, ArrayList<MGroupNode> ar) {
        this.id = id;
        this.name = name;
        this.ar = ar;
    }

    public ArrayList<MGroupNode> getAr() {
        return ar;
    }

    public void setAr(ArrayList<MGroupNode> ar) {
        this.ar = ar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
}
