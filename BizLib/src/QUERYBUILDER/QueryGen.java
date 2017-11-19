package QUERYBUILDER;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Map;

/**
 *
 * @author BUWANEKA
 */
public class QueryGen {

    public String UpdateRecord(String Table, Map<String, String> data, String WhereClase) {
        //If its a string value enter it with '' Single quts)
        Object[] Columns = data.keySet().toArray();
        Object[] Values = data.values().toArray();

        String query = "UPDATE " + Table + " SET ";

        for (int i = 0; i < Columns.length; i++) {
            if (i == Columns.length - 1) {
                query += "" + Columns[i] + "=" + Values[i];
                break;
            } else {
                query += "" + Columns[i] + "=" + Values[i] + ",";
            }

        }
        query += " " + WhereClase;
       // System.out.println(query);
        return query;
    }

    public String SaveRecord(String Table, Map<String, String> data) {
        //If its a string value enter it with '' Single quts)
        Object[] Columns =  data.keySet().toArray();
        Object[] Values =  data.values().toArray();

        String query = "insert into " + Table + "( ";

        for (int i = 0; i < Columns.length; i++) {
            if (i == Columns.length - 1) {
                query += "" + Columns[i] + "";
                break;
            } else {
                query += "" + Columns[i] + ",";
            }

        }

        query += ")values(";
        for (int i = 0; i < Values.length; i++) {
            if (i == Values.length - 1) {

                query += "" + Values[i] + "";

                break;
            } else {

                query += "" + Values[i] + ",";

            }
        }

        query += ")";
        System.out.println(query);
        return query;
    }

}
