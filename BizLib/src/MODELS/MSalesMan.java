/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

/**
 *
 * @author user pc
 */
public class MSalesMan {
    private String id;
    private String FirstName;
    private String LastName;
    private String ImgPath;
    private double ComPer;
    private int Active;

    public MSalesMan() {
    }

    public MSalesMan(String id) {
        this.id=id;
    }
    
    public MSalesMan(String id,String name,double com) {
        this.id=id;
       this.ComPer=com;
       this.FirstName=name;
       this.LastName="";
    }
    
    public MSalesMan(String id, String FirstName, String LastName, String ImgPath, double ComPer, int Active) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.ImgPath = ImgPath;
        this.ComPer = ComPer;
        this.Active = Active;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getImgPath() {
        return ImgPath;
    }

    public void setImgPath(String ImgPath) {
        this.ImgPath = ImgPath;
    }

    public double getComPer() {
        return ComPer;
    }

    public void setComPer(double ComPer) {
        this.ComPer = ComPer;
    }

    @Override
    public String toString() {
        return getFirstName()+" "+getLastName();
    }

    @Override
    public boolean equals(Object obj) {
        MSalesMan e=(MSalesMan) obj;
       return e.getId().equals(this.getId());
    }
    
    
    
    
    
    
}
