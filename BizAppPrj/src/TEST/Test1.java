/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TEST;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HOME
 */
public class Test1 {
    
    public static void main(String[] args) {
        //System.out.println(myEncript.encript("bizadmin"));
       // System.out.println(myEncript.decript("ÃËÝÅÉÓÐÖ"));
    SimpleDateFormat sdf_trnformat = new SimpleDateFormat("yyMM");
    
        System.out.println("Date:"+sdf_trnformat.format(new Date()));
        
    }
}
