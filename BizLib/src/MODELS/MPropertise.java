/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELS;

import DB_Access.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOME
 */
public class MPropertise {
    String PropId;
    String PropName;
    int Active;
    int DataType;
    String Format;
   
     
    public String getPropId() {
        return PropId;
    }

    public void setPropId(String PropId) {
        this.PropId = PropId;
    }

    public String getPropName() {
        return PropName;
    }

    public void setPropName(String PropName) {
        this.PropName = PropName;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String Format) {
        this.Format = Format;
    }

   

    public int getActive() {
        return Active;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }

    public int getDataType() {
        return DataType;
    }

    public void setDataType(int DataType) {
        this.DataType = DataType;
    }
      @Override
    public String toString() {
        return PropName;
    }
    
   
}
