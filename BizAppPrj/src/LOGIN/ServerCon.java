/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIN;

import COMMONFUN.CommonFun;
import DB_ACCESS.DB;
import GLOBALDATA.GlobalData;
import MODEL.CONFIG.UConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.UIManager;

/**
 *
 * @author HOME
 */
public class ServerCon {

    CommonFun cf = null;

    public ServerCon() {
        cf = new CommonFun();
    }

    public static void main(String[] args) {

        new ServerCon().checkConnectionOnStart();

    }

    public void updateConnection(UConfig u) throws Exception {
        File f = new File("Server.settings");
        FileOutputStream fos = null;
        ObjectOutputStream ous = null;

       // System.out.println("updateConnection:" + f.getAbsolutePath());
        try {
            if (f.exists()) {
              //  System.out.println("File Exists");
                fos = new FileOutputStream(f);
                ous = new ObjectOutputStream(fos);
                ous.writeObject(u);
                GLOBALDATA.GlobalData.config = u;
                ous.flush();

            } else {
               // System.out.println("File not Exists");
                f.createNewFile();
                fos = new FileOutputStream(f);
                ous = new ObjectOutputStream(fos);
                ous.writeObject(u);
                GLOBALDATA.GlobalData.config = u;
                ous.flush();
            }
        } catch (IOException e) {
            throw e;
        } finally {

            if (fos != null) {

                fos.close();

            } else if (ous != null) {
                ous.close();
            }

        }
    }

    public void checkConnection(Frm_ServerInfo frm) throws Exception {
        if (DB.getCurrentCon().isValid(10)) {

            frm.dispose();

            new Frm_Start(new javax.swing.JFrame(), true).setVisible(true);
        } else {

            throw new Exception("Server details invalid,Please enter correct details");
        }
    }

    public void setUIDesign() {
        try {

            UIManager.put("List.focusCellHighlightBorder", BorderFactory.createEmptyBorder());
            UIManager.put("Synthetica.internalFrame.titlePane.dropShadow", true);

            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void checkConnectionOnStart() {
        try {
            DB.setConnectionNull();
            updateConfigFile();
            if (DB.getCurrentCon().isValid(20)) {
                setUIDesign();
                new Frm_Start(new javax.swing.JFrame(), true).setVisible(true);
            } else {
               // System.out.println("Connecion invalid");
                setUIDesign();
                new Frm_ServerInfo().setVisible(true);
            }
        } catch (Exception e) {
            System.err.println("checkConnectionOnStart():" + e.getMessage());
            setUIDesign();
            new Frm_ServerInfo().setVisible(true);
        }
    }

    public boolean updateConfigFile() throws Exception {

        File f = new File("Server.settings");
        FileOutputStream fos = null;
        ObjectOutputStream ous = null;

        FileInputStream fis = null;
        ObjectInputStream ois = null;

     //   System.out.println("settings path:" + f.getAbsolutePath());

        if (f.exists()) {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
          //  System.out.println("Settings file exisis");

            UConfig u = (UConfig) ois.readObject();
            GLOBALDATA.GlobalData.config = u;

        } else {
         //   System.out.println("Settings file not-exisis");
            fos = new FileOutputStream(f);
            UConfig u = new UConfig();
            u.setDb("biz");
            u.setServer("localhost");
            u.setUsername("bizdb");
            u.setPassword("123");
            u.setPort("3306");
            ous = new ObjectOutputStream(fos);
            ous.writeObject(u);
            ous.flush();
            ous.close();

            GLOBALDATA.GlobalData.config = u;

        }

        return true;

    }

}
