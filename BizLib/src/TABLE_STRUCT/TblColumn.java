/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TABLE_STRUCT;

/**
 *
 * @author Buwanaka
 */
public class TblColumn {
 
    private String ColumnName;
    private String DataType;
    private String DefaultValue;

    public TblColumn( String ColumnName, String DataType, String DefaultValue) {
     
        this.ColumnName = ColumnName;
        this.DataType = DataType;
        this.DefaultValue = DefaultValue;
    }

    
    

    /**
     * @return the ColumnName
     */
    public String getColumnName() {
        return ColumnName;
    }

    /**
     * @param ColumnName the ColumnName to set
     */
    public void setColumnName(String ColumnName) {
        this.ColumnName = ColumnName;
    }

    /**
     * @return the DataType
     */
    public String getDataType() {
        return DataType;
    }

    /**
     * @param DataType the DataType to set
     */
    public void setDataType(String DataType) {
        this.DataType = DataType;
    }

    /**
     * @return the DefaultValue
     */
    public String getDefaultValue() {
        return DefaultValue;
    }

    /**
     * @param DefaultValue the DefaultValue to set
     */
    public void setDefaultValue(String DefaultValue) {
        this.DefaultValue = DefaultValue;
    }

   
}
