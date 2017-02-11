package MODELS;
// Generated Jun 12, 2016 10:23:46 AM by Hibernate Tools 3.6.0


/**
 * MPermissions generated by hbm2java
 */
public class MPermissions  implements java.io.Serializable {


     private String id;
     private String parentid;
     private String name;
     private String description;
     private String type;
     private Byte hassub;
     private Byte isuimenu;
     private String acesst;

    public MPermissions(String id, String parentid, String name, String description, String type, Byte hassub, Byte isuimenu) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.description = description;
        this.type = type;
        this.hassub = hassub;
        this.isuimenu = isuimenu;
    }

    public MPermissions(String id, String parentid, String name, String description, String type, Byte hassub, Byte isuimenu, String acesst) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.description = description;
        this.type = type;
        this.hassub = hassub;
        this.isuimenu = isuimenu;
        this.acesst = acesst;
    }
    

    public MPermissions() {
    
    }

    public String getAcesst() {
        return acesst;
    }

    public void setAcesst(String acesst) {
        this.acesst = acesst;
    }
  

     
   
  
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public Byte getHassub() {
        return this.hassub;
    }
    
    public void setHassub(Byte hassub) {
        this.hassub = hassub;
    }

    public Byte getIsuimenu() {
        return isuimenu;
    }

    public void setIsuimenu(Byte isuimenu) {
        this.isuimenu = isuimenu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

  

    @Override
    public String toString() {
        return this.getDescription();
    }

    
   
    
    
    


}


