/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GLOBALDATA;

import CONTROLLERS.C_Setup;
import MODELS.MUser;
import MODELS.USetup;
import java.util.Map;

/**
 *
 * @author HOME
 */
public class GlobalData {

    public static final String APPNAME = "Biz";
 
    
    public static Map<String, Object> Settings = SETTINGS.Settings.readFile();
    public static Map<String,String> SpecialPer = null;
    public static USetup Setup = C_Setup.getSetupRec();
  
    
    public static MUser CurUser=null;
  
    
    public static final String MESSAGEBOX = "Biz Message";
}
