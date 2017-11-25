/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GLOBALDATA;

import MODEL.CONFIG.UConfig;
import MODELS.MPermissions;
import MODELS.MUser;
import MODELS.USetup;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.TreeMap;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author HOME
 */
public class GlobalData {

    public static final String APPNAME = "Biz";

    public static UConfig config;
    public static Map<String, Object> Settings = SETTINGS.Settings.readFile();
    public static Map<String, MPermissions> SpecialPer = null;
    public static USetup Setup = null;

    public static Map<String, JasperReport> CompiledReports = new TreeMap<String, JasperReport>();

   
    public static MUser CurUser = null;

    public static final String MESSAGEBOX = "Biz Message";
}
