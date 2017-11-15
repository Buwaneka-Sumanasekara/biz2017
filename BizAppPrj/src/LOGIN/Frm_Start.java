package LOGIN;

import COMMONFUN.CommonFun;
import COMMONFUN.DefaultData;
import CONTROLLERS.C_ReportSetup;
import CONTROLLERS.C_Setup;
import CONTROLLERS.C_TransactionSetup;
import GLOBALDATA.GlobalData;
import MODELS.RptCommon;
import MODELS.UTransactions;
import SETTINGS.Settings;
import TABLE_STRUCT.TableStruCreation;
import TABLE_STRUCT.TblColumn;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

public final class Frm_Start extends javax.swing.JDialog {

    TableStruCreation TblStru = null;
    SETTINGS.Settings settings = null;
    DefaultData DefData = null;
    C_TransactionSetup cTrn = null;
    C_ReportSetup cRptSetup = null;

    public Frm_Start(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        GlobalData.Setup = C_Setup.getSetupRec();
        GlobalData.Settings = SETTINGS.Settings.readFile();
        TblStru = new TableStruCreation();
        settings = new Settings();
        DefData = new DefaultData();
        cTrn = new C_TransactionSetup();
        cRptSetup = new C_ReportSetup();
    }

    public void InitPrgressBar(int MaxRecords) {

        jProgressBar1.setMinimum(0);
        jProgressBar1.setMaximum(MaxRecords);
    }

    public void setProgressBarVal() {
        //System.out.println(jProgressBar1.getValue());
        //System.out.println("Max:" + jProgressBar1.getMaximum());
        jProgressBar1.setValue(jProgressBar1.getValue() + 1);
        jProgressBar1.update(jProgressBar1.getGraphics());

    }

    public void startPrograme() {
        txtStatues.setText("");
        super.update(this.getGraphics());

        ArrayList<Structure> arStructures = new ArrayList<>();

        ArrayList<TblColumn> ar_20161002_t1 = new ArrayList<>();
        ar_20161002_t1.add(new TblColumn("MARKUP", "DOUBLE", "NOT NULL DEFAULT 0"));
        Structure str_20161002_t1 = new Structure(20161002, "M_STOCKS", ar_20161002_t1);
        arStructures.add(str_20161002_t1);

        /*20170226*/
        ArrayList<TblColumn> ar_20170226_t1 = new ArrayList<>();
        ar_20170226_t1.add(new TblColumn("IS_POSTRN", "INT", "NOT NULL DEFAULT 0"));
        ar_20170226_t1.add(new TblColumn("DISPLAY_UNIT", "INT", "NOT NULL DEFAULT 1"));
        Structure str_20170226_t1 = new Structure(20170226, "u_transactions", ar_20170226_t1);
        arStructures.add(str_20170226_t1);

        /*20170305*/
        ArrayList<TblColumn> ar_20170305_t0 = new ArrayList<>();
        ar_20170305_t0.add(new TblColumn("GRP_ID", "VARCHAR(50)", "NOT NULL"));
        ar_20170305_t0.add(new TblColumn("GRP_NAME", "VARCHAR(100)", "NOT NULL"));
        ar_20170305_t0.add(new TblColumn("GRP_STARTNO", "VARCHAR(100)", "NOT NULL"));
        ar_20170305_t0.add(new TblColumn("GRP_ENDNO", "VARCHAR(100)", "NOT NULL"));
        ar_20170305_t0.add(new TblColumn("GRP_QTY", "INT", "NOT NULL DEFAULT 0"));
        ar_20170305_t0.add(new TblColumn("GRP_ACTIVE", "INT", "NOT NULL DEFAULT 0"));

        ArrayList<String> ar_20170305_t0PK = new ArrayList<>();
        ar_20170305_t0PK.add("GRP_ID");

        Structure str_20170305_t0 = new Structure(20170305, "M_GIFTVOUCHER_GROUP", ar_20170305_t0, ar_20170305_t0PK);
        arStructures.add(str_20170305_t0);

        ArrayList<TblColumn> ar_20170305_t1 = new ArrayList<>();
        ar_20170305_t1.add(new TblColumn("GRP_ID", "VARCHAR(50)", "NOT NULL"));
        ar_20170305_t1.add(new TblColumn("GV_NO", "VARCHAR(100)", "NOT NULL"));
        ar_20170305_t1.add(new TblColumn("VALUE", "DOUBLE", "NOT NULL DEFAULT 0"));
        ar_20170305_t1.add(new TblColumn("CR_LOC", "INT", "NOT NULL"));
        ar_20170305_t1.add(new TblColumn("CR_BY", "VARCHAR(50)", "NOT NULL"));
        ar_20170305_t1.add(new TblColumn("CR_DATE", "DATETIME", ""));
        ar_20170305_t1.add(new TblColumn("PUR_LOC", "INT", ""));
        ar_20170305_t1.add(new TblColumn("PUR_DATE", "DATETIME", ""));
        ar_20170305_t1.add(new TblColumn("PUR_CRBY", "VARCHAR(50)", ""));
        ar_20170305_t1.add(new TblColumn("PUR_REFNO", "VARCHAR(100)", ""));
        ar_20170305_t1.add(new TblColumn("ACTIVE", "INT", "NOT NULL DEFAULT 0"));
        ar_20170305_t1.add(new TblColumn("ISPUR", "INT", "NOT NULL DEFAULT 0"));
        ar_20170305_t1.add(new TblColumn("GV_DES", "VARCHAR(100)", ""));

        ArrayList<String> ar_20170305_t1PK = new ArrayList<>();
        // ar_20170305_t1PK.add("GRP_ID");
        ar_20170305_t1PK.add("GV_NO");

        Structure str_20170305_t1 = new Structure(20170305, "M_GIFTVOUCHER", ar_20170305_t1, ar_20170305_t1PK);
        arStructures.add(str_20170305_t1);

        ArrayList<TblColumn> ar_20170305_t2 = new ArrayList<>();
        ar_20170305_t2.add(new TblColumn("NO", "INT", "NOT NULL"));
        ar_20170305_t2.add(new TblColumn("GV_NO", "VARCHAR(100)", "NOT NULL"));
        ar_20170305_t2.add(new TblColumn("RED_VAL", "DOUBLE", "NOT NULL DEFAULT 0"));
        ar_20170305_t2.add(new TblColumn("RED_LOC", "INT", "NOT NULL"));
        ar_20170305_t2.add(new TblColumn("RED_CRBY", "VARCHAR(50)", "NOT NULL"));
        ar_20170305_t2.add(new TblColumn("RED_REFNO", "VARCHAR(100)", "NOT NULL"));

        ArrayList<String> ar_20170305_t2PK = new ArrayList<>();
        ar_20170305_t2PK.add("NO");
        ar_20170305_t2PK.add("GV_NO");

        Structure str_20170305_t2 = new Structure(20170305, "T_GVREDEEM", ar_20170305_t2, ar_20170305_t2PK);
        arStructures.add(str_20170305_t2);

        String q_20171101_t1 = "ALTER TABLE m_user DROP COLUMN LOCID";
        Structure str_20171101_t1 = new Structure(20171101, q_20171101_t1);
        arStructures.add(str_20171101_t1);

        ArrayList<TblColumn> ar_20171102_t1 = new ArrayList<>();
        ar_20171102_t1.add(new TblColumn("PREV_REP", "INT", "NOT NULL DEFAULT 1"));
        ar_20171102_t1.add(new TblColumn("CANCEL_OPT", "INT", "NOT NULL DEFAULT 0"));
        ar_20171102_t1.add(new TblColumn("CANCEL_DAYS_WITH", "INT", "NOT NULL DEFAULT 1"));

        ArrayList<String> ar_20171102_t1PK = new ArrayList<>();
        ar_20170305_t2PK.add("TRNNO");
        ar_20170305_t2PK.add("TRNTYPE");

        Structure str_20171102_t2 = new Structure(20171102, "u_transactions", ar_20171102_t1, ar_20171102_t1PK);
        arStructures.add(str_20171102_t2);

        ArrayList<TblColumn> ar_20171106_t1 = new ArrayList<>();
        ar_20171106_t1.add(new TblColumn("ORD", "INT", "NOT NULL DEFAULT 0"));

        ArrayList<String> ar_20171106_t1PK = new ArrayList<>();
        ar_20171106_t1PK.add("ID");
        ar_20171106_t1PK.add("PARENTID");

        Structure str_20171106_t1 = new Structure(20171106, "m_permissions", ar_20171106_t1, ar_20171106_t1PK);
        arStructures.add(str_20171106_t1);

        ArrayList<TblColumn> ar_20171106_t2 = new ArrayList<>();
        ar_20171106_t2.add(new TblColumn("LOCID", "INT", "NOT NULL "));
        ar_20171106_t2.add(new TblColumn("PROID", "VARCHAR(50)", "NOT NULL "));
        ar_20171106_t2.add(new TblColumn("BATCHID", "VARCHAR(50)", "NOT NULL "));
        ar_20171106_t2.add(new TblColumn("SERIALID", "VARCHAR(100)", "NOT NULL "));
        ar_20171106_t2.add(new TblColumn("PRONAME", "VARCHAR(100)", "NOT NULL "));
        ar_20171106_t2.add(new TblColumn("COSTP", "DOUBLE", "NOT NULL "));
        ar_20171106_t2.add(new TblColumn("SELLP", "DOUBLE", "NOT NULL "));

        ArrayList<String> ar_20171106_t2PK = new ArrayList<>();
        ar_20171106_t2PK.add("LOCID");
        ar_20171106_t2PK.add("PROID");
        ar_20171106_t2PK.add("BATCHID");

        Structure str_20171106_t2 = new Structure(20171106, "R_PRICE_TAGS", ar_20171106_t2, ar_20171106_t2PK);
        arStructures.add(str_20171106_t2);

        //2017/11/07
        ArrayList<TblColumn> ar_20171107_t1 = new ArrayList<>();
        ar_20171107_t1.add(new TblColumn("RPT_ID", "VARCHAR(50)", "NOT NULL "));
        ar_20171107_t1.add(new TblColumn("RPT_NAME", "VARCHAR(100)", "NOT NULL "));
        ar_20171107_t1.add(new TblColumn("RPT_PATH", "VARCHAR(200)", "NOT NULL "));
        ar_20171107_t1.add(new TblColumn("RPT_EN_LOC", "INT", "NOT NULL DEFAULT 0"));
        ar_20171107_t1.add(new TblColumn("RPT_EN_CUS", "INT", "NOT NULL DEFAULT 0"));
        ar_20171107_t1.add(new TblColumn("RPT_EN_SUP", "INT", "NOT NULL DEFAULT 0"));
        ar_20171107_t1.add(new TblColumn("RPT_EN_DATE_RANGE", "INT", "NOT NULL DEFAULT 0"));
        ar_20171107_t1.add(new TblColumn("RPT_EN_DATE_AS_AT", "INT", "NOT NULL DEFAULT 0"));
        ar_20171107_t1.add(new TblColumn("RPT_EN_DATE_QUATER", "INT", "NOT NULL DEFAULT 0"));
        ar_20171107_t1.add(new TblColumn("RPT_EN_GRP", "INT", "NOT NULL DEFAULT 0"));

        ArrayList<String> ar_20171107_t1PK = new ArrayList<>();
        ar_20171107_t1PK.add("RPT_ID");

        Structure str_20171107_t1 = new Structure(20171107, "U_REPORTS", ar_20171107_t1, ar_20171107_t1PK);
        arStructures.add(str_20171107_t1);

        ArrayList<String> q_20171107_t2 = new ArrayList<>();
        q_20171107_t2.add(" DECLARE UNIT_NAME VARCHAR(100) DEFAULT '' ");
        q_20171107_t2.add(" SELECT u.NAME INTO UNIT_NAME FROM m_units u where u.ID=unit_id ");
        q_20171107_t2.add(" RETURN UNIT_NAME  ");
        Structure str_20171107_t2 = new Structure(20171107, TableStruCreation.STR_FUN, " strf_getUnitName ", " unit_id VARCHAR(100) ", q_20171107_t2, " varchar(100) ");
        arStructures.add(str_20171107_t2);

        ArrayList<TblColumn> ar_20171108_t1 = new ArrayList<>();
        ar_20171108_t1.add(new TblColumn("RPT_ACTIVE", "INT", "NOT NULL DEFAULT 1"));

        ArrayList<String> ar_20171108_t1PK = new ArrayList<>();
        ar_20171108_t1PK.add("RPT_ID");

        Structure str_20171108_t1 = new Structure(20171108, "U_REPORTS", ar_20171108_t1, ar_20171108_t1PK);
        arStructures.add(str_20171108_t1);

        ArrayList<TblColumn> ar_20171108_t2 = new ArrayList<>();
        ar_20171108_t2.add(new TblColumn("SUP_PROD_ONLY", "INT", "NOT NULL DEFAULT 0"));
        ar_20171108_t2.add(new TblColumn("CHANGE_SPRICE", "INT", "NOT NULL DEFAULT 0"));
        ar_20171108_t2.add(new TblColumn("HOLD_ONLY", "INT", "NOT NULL DEFAULT 0"));

        ArrayList<String> ar_20171108_t2PK = new ArrayList<>();
        ar_20171108_t1PK.add("TRNNO");
        ar_20171108_t1PK.add("TRNTYPE");

        Structure str_20171108_t2 = new Structure(20171108, "u_transactions", ar_20171108_t2, ar_20171108_t2PK);
        arStructures.add(str_20171108_t2);

        ArrayList<String> q_20171114_t1 = new ArrayList<>();
        q_20171114_t1.add(" DECLARE UNIT_VOL DOUBLE DEFAULT '0' ");
        q_20171114_t1.add(" select ugu.VOLUME INTO UNIT_VOL from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp AND ugu.M_UNITS_ID=unit_id  ");
        q_20171114_t1.add(" RETURN UNIT_VOL  ");
        Structure str_20171114_t1 = new Structure(20171114, TableStruCreation.STR_FUN, " strf_getUnitVol ", " unit_grp VARCHAR(100),unit_id VARCHAR(100) ", q_20171114_t1, " DOUBLE ");
        arStructures.add(str_20171114_t1);

        ArrayList<String> q_20171114_t2 = new ArrayList<>();
        q_20171114_t2.add(" DECLARE UNIT_VOL_CUR  DOUBLE DEFAULT '0' ");
        q_20171114_t2.add(" DECLARE UNIT_VOL_MAX  DOUBLE DEFAULT '0' ");
        q_20171114_t2.add(" select ugu.VOLUME INTO UNIT_VOL_CUR from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp AND ugu.M_UNITS_ID=unit_id   ");
        q_20171114_t2.add(" select ugu.VOLUME INTO UNIT_VOL_MAX from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp ORDER BY ugu.VOLUME desc limit 1   ");
        q_20171114_t2.add(" RETURN ((qty*UNIT_VOL_CUR)/UNIT_VOL_MAX) ");
        Structure str_20171114_t2 = new Structure(20171114, TableStruCreation.STR_FUN, " strf_ConvMaxUnit ", " unit_grp VARCHAR(100),unit_id VARCHAR(100),qty DOUBLE ", q_20171114_t2, " DOUBLE ");
        arStructures.add(str_20171114_t2);

        ArrayList<String> q_20171114_t3 = new ArrayList<>();
        q_20171114_t3.add(" DECLARE UNIT_ID VARCHAR(100) DEFAULT '' ");
        q_20171114_t3.add(" select ugu.M_UNITS_ID  INTO UNIT_ID from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp ORDER BY ugu.VOLUME DESC LIMIT 1   ");
        q_20171114_t3.add(" RETURN UNIT_ID  ");
        Structure str_20171114_t3 = new Structure(20171114, TableStruCreation.STR_FUN, " strf_getMaxUnit ", " unit_grp VARCHAR(100) ", q_20171114_t3, " VARCHAR(100) ");
        arStructures.add(str_20171114_t3);

        ArrayList<String> q_20171114_t4 = new ArrayList<>();
        q_20171114_t4.add(" DECLARE UNIT_SYM VARCHAR(100) DEFAULT '' ");
        q_20171114_t4.add(" SELECT SYMBLE INTO UNIT_SYM FROM m_units WHERE ID=unit_id ");
        q_20171114_t4.add(" RETURN UNIT_SYM  ");
        Structure str_20171114_t4 = new Structure(20171114, TableStruCreation.STR_FUN, " strf_getUnitSym ", " unit_id VARCHAR(100) ", q_20171114_t4, " VARCHAR(100) ");
        arStructures.add(str_20171114_t4);

        ArrayList<TblColumn> ar_20171114_t6 = new ArrayList<>();

        ar_20171114_t6.add(new TblColumn("M_PRODUCTS_ID", "VARCHAR(50)", "NOT NULL"));
        ar_20171114_t6.add(new TblColumn("PRONAME", "VARCHAR(200)", "NOT NULL"));
        ar_20171114_t6.add(new TblColumn("SIH", "DOUBLE", "NOT NULL"));
        ar_20171114_t6.add(new TblColumn("UNIT_ID", "VARCHAR(50)", "NOT NULL"));
        ar_20171114_t6.add(new TblColumn("UNIT_SYM", "VARCHAR(50)", "NOT NULL"));
        ar_20171114_t6.add(new TblColumn("BATCHNO", "VARCHAR(50)", "NOT NULL"));
        ar_20171114_t6.add(new TblColumn("M_LOCATION_ID", "INT", "NOT NULL"));

        ArrayList<String> ar_20171114_t6PK = new ArrayList<>();
        ar_20171114_t6PK.add("M_PRODUCTS_ID");
        ar_20171114_t6PK.add("BATCHNO");
        ar_20171114_t6PK.add("M_LOCATION_ID");

        Structure str_20171114_t6 = new Structure(20171114, "M_STOCKS_TEM", ar_20171114_t6, ar_20171114_t6PK);
        arStructures.add(str_20171114_t6);

        ArrayList<String> q_20171114_t5 = new ArrayList<>();
        q_20171114_t5.add(" TRUNCATE TABLE  M_STOCKS_TEM ");
        String q_20171114_t5_str = " INSERT INTO M_STOCKS_TEM (SELECT PROID,NAME,sum(SIH) AS SIH,UNITID,UNIT,BATCH,LOCID FROM ";
        q_20171114_t5_str += " ( ";
        q_20171114_t5_str += " (select p.ID as PROID,p.NAME as NAME,0 as SIH,strf_getMaxUnit(p.M_UNITGROUPS_ID) AS UNITID, ";
        q_20171114_t5_str += " strf_getUnitSym(strf_getMaxUnit(p.M_UNITGROUPS_ID)) AS UNIT,'0001' as BATCH,l.ID as LOCID  ";
        q_20171114_t5_str += " from m_products p cross join m_location l  ";
        q_20171114_t5_str += " where p.ACTIVE=1 AND l.ACTIVE=1 ) ";
        q_20171114_t5_str += " union all ";
        q_20171114_t5_str += " (SELECT SL.PROID AS PROID,P.NAME AS NAME,SUM(u.STOCKENTYP*strf_ConvMaxUnit(SL.M_UNITGROUPS_ID, SL.M_UNITS_ID, SL.QTY)) AS SIH, ";
        q_20171114_t5_str += " strf_getMaxUnit(p.M_UNITGROUPS_ID) AS UNITID,strf_getUnitSym(strf_getMaxUnit(p.M_UNITGROUPS_ID)) AS UNIT,SL.BATCH_NO AS BATCH, ";
        q_20171114_t5_str += " SM.M_LOCATION_SOURCE as LOCID ";
        q_20171114_t5_str += " FROM t_stockmst SM ";
        q_20171114_t5_str += " inner join t_stockline SL ";
        q_20171114_t5_str += " on SM.ID=SL.T_STOCKMST_ID and SM.TRNTYPE=SL.TRNTYP ";
        q_20171114_t5_str += " inner join u_transactions u ";
        q_20171114_t5_str += " on SM.TRNTYPE=u.TRNTYPE ";
        q_20171114_t5_str += " INNER JOIN m_products P ";
        q_20171114_t5_str += " on SL.PROID=P.ID ";
        q_20171114_t5_str += " where SM.TRNSTATE='P' ";
        q_20171114_t5_str += " GROUP BY SL.PROID,P.NAME) ";
        q_20171114_t5_str += " )A ";
        q_20171114_t5_str += " WHERE A.LOCID=loc_code ";
        q_20171114_t5_str += " group by  A.PROID,A.NAME,A.LOCID,A.BATCH,A.UNIT ";
        q_20171114_t5_str += " order by  A.PROID,A.NAME,A.LOCID )";
        q_20171114_t5.add(q_20171114_t5_str);

        Structure str_20171114_t5 = new Structure(20171114, TableStruCreation.STR_PROC, " strp_StockBalance ", " loc_code INT ", q_20171114_t5);
        arStructures.add(str_20171114_t5);

        ArrayList<String> q_20171114_t7 = new ArrayList<>();
        q_20171114_t7.add(" CALL strp_StockBalance(loc_code) ");
        q_20171114_t7.add(" UPDATE  M_STOCKS  S INNER JOIN M_STOCKS_TEM TS ON S.M_PRODUCTS_ID=TS.M_PRODUCTS_ID AND S.BATCHNO=TS.BATCHNO AND S.M_LOCATION_ID=TS.M_LOCATION_ID SET S.SIH=TS.SIH  ");
        Structure str_20171114_t7 = new Structure(20171114, TableStruCreation.STR_PROC, " strp_UpdateStockBalance ", " loc_code INT ", q_20171114_t7);
        arStructures.add(str_20171114_t7);

        ArrayList<TblColumn> ar_20171114_t8 = new ArrayList<>();
        ar_20171114_t8.add(new TblColumn("PRO_IMG", "VARCHAR(100)", ""));
        ArrayList<String> ar_20171114_t8PK = new ArrayList<>();
        ar_20171114_t8PK.add("ID");
        Structure str_20171114_t8 = new Structure(20171114, "m_products", ar_20171114_t8, ar_20171114_t8PK);
        arStructures.add(str_20171114_t8);
        
        
        

        int TotalResults = arStructures.size() + 1;
        InitPrgressBar(TotalResults + 2);

        /* ##################### TABLE STRUCTURE CREATION ###########################*/
        int latestVersion = 20160901;

        txtStatues.setText("Creating Structure changes...");
        super.update(this.getGraphics());

        for (Structure structure : arStructures) {
            if (structure.version > settings.getVersion()) {

                try {

                    if (structure.getType().equals("") && (structure.getSQL() == null || structure.getSQL().equals(""))) {

                        TblStru.createTable(structure.getTableName(), structure.getColumns(), structure.getPrimaryKeys());
                    } else if (structure.getType().equals(TableStruCreation.STR_FUN)) {
                        TblStru.createStoredFunction(structure.getName(), structure.getParameters(), structure.getLines(), structure.getReturnType());
                    } else if (structure.getType().equals(TableStruCreation.STR_PROC)) {
                        TblStru.createStoredProcedure(structure.getName(), structure.getParameters(), structure.getLines());
                    } else {
                        TblStru.executeSql(structure.getSQL());
                    }
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }

            }

            latestVersion = structure.getVersion();

            setProgressBarVal();
        }

        settings.UpdateVersion("" + latestVersion);

        txtStatues.setText("Adding Default Data...");
        super.update(this.getGraphics());

        DefData.createDefaultData();
        setProgressBarVal();

        txtStatues.setText("Compiling Reports...");

        super.update(this.getGraphics());

        compileReports();
        setProgressBarVal();

        this.dispose();
        new LOGIN.Frm_Login().setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtStatues = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStatues.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatues.setText("aaa");
        jPanel1.add(txtStatues, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 560, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(110, 147, 169));
        jLabel5.setText("Biz");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 100, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/iconappimg.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 140, 110));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 580, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        startPrograme();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            UIManager.setLookAndFeel("com.jtattoo.plaf." + CommonFun.getSystemTheme());
        } catch (Exception ex) {
            Logger.getLogger(Frm_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_Start dialog = new Frm_Start(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    class Structure {

        private int version;
        private String TableName;
        private ArrayList<TblColumn> Columns;
        private String SQL;
        private ArrayList<String> PrimaryKeys;

        private String Type = "";
        private String Name;
        private String Parameters;
        private ArrayList<String> Lines;
        private String ReturnType;

        public Structure(int version, String TableName, ArrayList<TblColumn> Columns, ArrayList<String> PrimaryKeys) {
            this.version = version;
            this.TableName = TableName;
            this.Columns = Columns;
            this.PrimaryKeys = PrimaryKeys;
        }

        public Structure(int version, String TableName, ArrayList<TblColumn> Columns) {
            this.version = version;
            this.TableName = TableName;
            this.Columns = Columns;
        }

        public Structure(int version, String SQL) {
            this.version = version;
            this.SQL = SQL;

        }

        public Structure(int version, String Type, String Name, String Parameters, ArrayList<String> Lines, String ReturnType) {
            this.version = version;
            this.Name = Name;
            this.Parameters = Parameters;
            this.Lines = Lines;
            this.ReturnType = ReturnType;
            this.Type = Type;
        }

        public Structure(int version, String Type, String Name, String Parameters, ArrayList<String> Lines) {
            this.version = version;
            this.Name = Name;
            this.Parameters = Parameters;
            this.Lines = Lines;

            this.Type = Type;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getTableName() {
            return TableName;
        }

        public void setTableName(String TableName) {
            this.TableName = TableName;
        }

        public ArrayList<TblColumn> getColumns() {
            return Columns;
        }

        public void setColumns(ArrayList<TblColumn> Columns) {
            this.Columns = Columns;
        }

        public String getSQL() {
            return SQL;
        }

        public void setSQL(String SQL) {
            this.SQL = SQL;
        }

        public ArrayList<String> getPrimaryKeys() {
            return PrimaryKeys;
        }

        public void setPrimaryKeys(ArrayList<String> PrimaryKeys) {
            this.PrimaryKeys = PrimaryKeys;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getParameters() {
            return Parameters;
        }

        public void setParameters(String Parameters) {
            this.Parameters = Parameters;
        }

        public ArrayList<String> getLines() {
            return Lines;
        }

        public void setLines(ArrayList<String> Lines) {
            this.Lines = Lines;
        }

        public String getReturnType() {
            return ReturnType;
        }

        public void setReturnType(String ReturnType) {
            this.ReturnType = ReturnType;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

    }

    public void compileReports() {
        //Map<String, JasperReport> map_rep = new TreeMap<>();

        ArrayList<UTransactions> artrn = cTrn.getAllTransations();
        for (UTransactions TrnSetup : artrn) {
            String MasterreportPath = "Reports\\Transactions\\" + ((TrnSetup.getReportpath() == null || TrnSetup.getReportpath().equals("")) ? "DEF\\TRpt_Default.jrxml" : TrnSetup.getReportpath());
            File f = new File(MasterreportPath);
            if (f.exists()) {
                try {
                    //  System.err.println(f.getAbsolutePath());
                    // cf.WriteLog("REPORTS["+TrnSetup.getTrndesc()+"]",f.getAbsolutePath() ); 
                    GlobalData.CompiledReports.put("RPT_" + TrnSetup.getTrnno(), JasperCompileManager.compileReport(f.getAbsolutePath()));
                } catch (JRException ex) {
                    System.err.println("COMPINLING REPORTS[TRANSACTIONS]:" + ex.getMessage());
                }
            }

        }

        try {
            ArrayList<RptCommon> allReportSetup = cRptSetup.getAllReportSetup();

            for (RptCommon rptCommon : allReportSetup) {
                if (rptCommon.getRptPath() != null && rptCommon.getRptPath().length() > 0) {
                    String MasterreportPath = "Reports\\" + rptCommon.getRptPath();
                    // System.err.println(MasterreportPath);
                    File f = new File(MasterreportPath);
                    if (f.exists()) {
                        try {
                            // System.err.println(rptCommon.getId()+" - "+ rptCommon.getName()+": "+MasterreportPath);
                            GlobalData.CompiledReports.put("RPT_" + rptCommon.getId(), JasperCompileManager.compileReport(f.getAbsolutePath()));
                        } catch (JRException ex) {
                            System.err.println("COMPINLING REPORTS[TRANSACTIONS]:" + ex.getMessage());
                        }
                    }
                } else {
                    //  System.err.println(rptCommon.getId()+" - "+ rptCommon.getName()+": Report path empty ");
                }
            }
        } catch (Exception ex) {
            System.err.println("COMPINLING REPORTS[COM_REPORTS]:" + ex.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel txtStatues;
    // End of variables declaration//GEN-END:variables
}
