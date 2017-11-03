package SETTINGS;

import GLOBALDATA.GlobalData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author BUWANEKA
 */
public class Settings {

   
    public  Integer getVersion() {
        Integer ver = 20160901;
        try {
            String path = new File("").getAbsolutePath() + "\\version.biz";
            File f = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.ready()) {

                ver = Integer.parseInt(br.readLine());

            }

        } catch (Exception e) {
        }
        return ver;
    }

    public  void UpdateVersion(String version){
         BufferedWriter bw = null;
        try {
           
            String path = new File("").getAbsolutePath() + "\\version.biz";
            File f = new File(path);
            bw = new BufferedWriter(new FileWriter(f));
            
            bw.write(version);
            bw.flush();
           
           // bw.newLine();
            //System.out.println(key+"="+value);
        } catch (IOException ex) {
           Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException ex) {
                   // Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            
    }
    /*Funtion Read Config File*/
    public static Map<String,Object> readFile() {

        String path ="settings.biz";
        File set_file = new File(path);

        Map<String,Object> m = new TreeMap<>();
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(set_file));
            while (br.ready()) {

                String[] split = br.readLine().split("=");
              m.put(split[0], split[1]);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Config file Not Found!", GLOBALDATA.GlobalData.APPNAME, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Config file Not Found!", GLOBALDATA.GlobalData.APPNAME, JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return m ;
    }

    /*Funtion get Specific Seting value*/
    public static Object getSpecificSetting(String keyName) {
        Map<String, Object> readFile = Settings.readFile();

        return readFile.get(keyName);
    }

    /*Funtion get Specific Seting value*/
    public static void setSpecificSetting(String keyName, Object new_value) {
        BufferedWriter bw = null;
        String path = new File("").getAbsolutePath() + "\\settings.biz";
        try {
            Map<String, Object> readFile = readFile();
            readFile.put(keyName, new_value);
            File f = new File(path);
            bw = new BufferedWriter(new FileWriter(f));
            for (Map.Entry<String, Object> entrySet : readFile.entrySet()) {
                String key = entrySet.getKey();
                Object value = entrySet.getValue();
                bw.write(key + "=" + value);
                bw.newLine();
                //System.out.println(key+"="+value);
            }
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
