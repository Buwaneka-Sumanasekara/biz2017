/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELS;

/**
 *
 * @author HOME
 */
public class RptCommon {
    private String Id;
    private String Name;
    private String RptPath;
    private int En_Loc;
    private int En_Cus;
    private int En_Sup;
    private int En_DateRange;
    private int En_DateAsAt;
    private int En_DateQut;
    private int En_Grp;

    public RptCommon() {
    }

    public RptCommon(String Id, String Name, String RptPath, int En_Loc, int En_Cus, int En_Sup, int En_DateRange, int En_DateAsAt, int En_DateQut, int En_Grp) {
        this.Id = Id;
        this.Name = Name;
        this.RptPath = RptPath;
        this.En_Loc = En_Loc;
        this.En_Cus = En_Cus;
        this.En_Sup = En_Sup;
        this.En_DateRange = En_DateRange;
        this.En_DateAsAt = En_DateAsAt;
        this.En_DateQut = En_DateQut;
        this.En_Grp = En_Grp;
    }

   

    public int getEn_Grp() {
        return En_Grp;
    }

    public void setEn_Grp(int En_Grp) {
        this.En_Grp = En_Grp;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getEn_Loc() {
        return En_Loc;
    }

    public void setEn_Loc(int En_Loc) {
        this.En_Loc = En_Loc;
    }

    public int getEn_Cus() {
        return En_Cus;
    }

    public void setEn_Cus(int En_Cus) {
        this.En_Cus = En_Cus;
    }

    public int getEn_Sup() {
        return En_Sup;
    }

    public void setEn_Sup(int En_Sup) {
        this.En_Sup = En_Sup;
    }

    public int getEn_DateRange() {
        return En_DateRange;
    }

    public void setEn_DateRange(int En_DateRange) {
        this.En_DateRange = En_DateRange;
    }

    public int getEn_DateAsAt() {
        return En_DateAsAt;
    }

    public void setEn_DateAsAt(int En_DateAsAt) {
        this.En_DateAsAt = En_DateAsAt;
    }

    public int getEn_DateQut() {
        return En_DateQut;
    }

    public void setEn_DateQut(int En_DateQut) {
        this.En_DateQut = En_DateQut;
    }

    public String getRptPath() {
        return RptPath;
    }

    public void setRptPath(String RptPath) {
        this.RptPath = RptPath;
    }
  
    
    
    
}
