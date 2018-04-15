package LOGIN;

import COMMONFUN.CommonFun;
import COMMONFUN.DefaultData;
import CONTROLLERS.C_Products;
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
    C_Products cPro = null;

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
        cPro = new C_Products();
        this.setBounds(this.getX(), this.getY(), 590, 300);
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

        ArrayList<String> q_20171114_t10 = new ArrayList<>();
        q_20171114_t10.add(" DECLARE UNIT_VOL_CUR  DOUBLE DEFAULT '0' ");
        q_20171114_t10.add(" DECLARE UNIT_VOL_MIN  DOUBLE DEFAULT '0' ");
        q_20171114_t10.add(" select ugu.VOLUME INTO UNIT_VOL_CUR from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp AND ugu.M_UNITS_ID=unit_id   ");
        q_20171114_t10.add(" select ugu.VOLUME INTO UNIT_VOL_MIN from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp ORDER BY ugu.VOLUME asc limit 1   ");
        q_20171114_t10.add(" RETURN ((qty*UNIT_VOL_CUR)*UNIT_VOL_MIN) ");
        Structure str_20171114_t10 = new Structure(20171114, TableStruCreation.STR_FUN, " strf_ConvMinUnit ", " unit_grp VARCHAR(100),unit_id VARCHAR(100),qty DOUBLE ", q_20171114_t10, " DOUBLE ");
        arStructures.add(str_20171114_t10);

        ArrayList<TblColumn> ar_20171204_t1 = new ArrayList<>();
        ar_20171204_t1.add(new TblColumn("ID", "INT", "NOT NULL"));
        ar_20171204_t1.add(new TblColumn("RPT_ID", "VARCHAR(50)", "NOT NULL"));
        ar_20171204_t1.add(new TblColumn("EMAIL_ADD", "VARCHAR(200)", "NOT NULL"));

        ArrayList<String> ar_20171204_t1PK = new ArrayList<>();
        ar_20171204_t1PK.add("ID");

        Structure str_20171204_t1 = new Structure(20171204, "U_RPT_EMAILS", ar_20171204_t1, ar_20171204_t1PK);
        arStructures.add(str_20171204_t1);

        ArrayList<TblColumn> ar_20171206_t1 = new ArrayList<>();
        ar_20171206_t1.add(new TblColumn("SET_DUE_AUTO", "TINYINT", "DEFAULT '0'"));
        ArrayList<String> ar_20171206_t1PK = new ArrayList<>();
        ar_20171206_t1PK.add("ID");
        Structure str_20171206_t1 = new Structure(20171206, "m_paymst", ar_20171206_t1, ar_20171206_t1PK);
        arStructures.add(str_20171206_t1);

        ArrayList<TblColumn> ar_20171206_t2 = new ArrayList<>();
        ar_20171206_t2.add(new TblColumn("ID", "VARCHAR(50)", "NOT NULL"));
        ar_20171206_t2.add(new TblColumn("FNAME", "VARCHAR(60)", "NOT NULL"));
        ar_20171206_t2.add(new TblColumn("LNAME", "VARCHAR(60)", "NOT NULL"));
        ar_20171206_t2.add(new TblColumn("IMGPATH", "VARCHAR(100)", "DEFAULT ''"));
        ar_20171206_t2.add(new TblColumn("COMM_PER", "DOUBLE", "DEFAULT '0'"));
        ar_20171206_t2.add(new TblColumn("ACTIVE", "TINYINT", "DEFAULT '1'"));
        ArrayList<String> ar_20171206_t2PK = new ArrayList<>();
        ar_20171206_t2PK.add("ID");
        Structure str_20171206_t2 = new Structure(20171206, "m_SalesPerson", ar_20171206_t2, ar_20171206_t2PK);
        arStructures.add(str_20171206_t2);

        ArrayList<TblColumn> ar_20171206_t3 = new ArrayList<>();
        ar_20171206_t3.add(new TblColumn("SALESMAN", "VARCHAR(50)", "DEFAULT ''"));
        ar_20171206_t3.add(new TblColumn("SALES_COM", "DOUBLE", "DEFAULT '0'"));

        ArrayList<String> ar_20171206_t3PK = new ArrayList<>();
        ar_20171206_t3PK.add("T_STOCKMST_ID");
        ar_20171206_t3PK.add("TERMINAL");
        ar_20171206_t3PK.add("TRNTYP");
        ar_20171206_t3PK.add("LINEID");
        ar_20171206_t3PK.add("PROID");
        Structure str_20171206_t3 = new Structure(20171206, "t_stockline", ar_20171206_t3, ar_20171206_t3PK);
        arStructures.add(str_20171206_t3);

        ArrayList<TblColumn> ar_20171206_t4 = new ArrayList<>();
        ar_20171206_t4.add(new TblColumn("EN_SALESMAN", "TINYINT", "DEFAULT '0'"));

        ArrayList<String> ar_20171206_t4PK = new ArrayList<>();
        ar_20171206_t4PK.add("TRNNO");
        ar_20171206_t4PK.add("TRNTYPE");

        Structure str_20171206_t4 = new Structure(20171206, "u_transactions", ar_20171206_t4, ar_20171206_t4PK);
        arStructures.add(str_20171206_t4);

        
        
        ArrayList<TblColumn> ar_20170108_t1 = new ArrayList<>();
        ar_20170108_t1.add(new TblColumn("UNIT_SYS", "VARCHAR(50)", "DEFAULT ''"));
        ar_20170108_t1.add(new TblColumn("BATCH", "VARCHAR(5)", "DEFAULT ''"));
        
        ArrayList<String> ar_20170108_t1PK = new ArrayList<>();
        Structure str_20170108_t1 = new Structure(20170108, "t_phystkdet", ar_20170108_t1, ar_20170108_t1PK);
        arStructures.add(str_20170108_t1);
        
        
        
        ArrayList<TblColumn> ar_20180211_t1 = new ArrayList<>();
        ar_20180211_t1.add(new TblColumn("EMAIL_RPT_DAYS_BFR", "INT", "DEFAULT '0'"));
        
        ArrayList<String> ar_20180211_t1PK = new ArrayList<>();
        Structure str_20180211_t1 = new Structure(20180211, "u_setup", ar_20180211_t1, ar_20180211_t1PK);
        arStructures.add(str_20180211_t1);
        
        
        
        ArrayList<String> q_20180415_t1 = new ArrayList<>();
        q_20180415_t1.add(" DECLARE TRNPROFIT  DOUBLE DEFAULT '0' ");
        
        String q_20180415_q0=" select (SUM(sl.AMOUNT)-SUM(sl.CPRICE*sl.QTY)) INTO TRNPROFIT ";
        q_20180415_q0+=" from t_stockline sl  ";
        q_20180415_q0+=" where sl.T_STOCKMST_ID=para_trnid AND sl.TRNTYP=para_trntyp ";
        q_20180415_q0+=" GROUP BY sl.T_STOCKMST_ID,sl.TRNTYP  ";
        
        q_20180415_t1.add(q_20180415_q0);
        q_20180415_t1.add(" RETURN TRNPROFIT ");
        Structure str_20180415_t1 = new Structure(20180415, TableStruCreation.STR_FUN, " strf_getInvProfit ", " para_trnid VARCHAR(100),para_trntyp VARCHAR(5) ", q_20180415_t1, " DOUBLE ");
        arStructures.add(str_20180415_t1);
        

        int TotalResults = arStructures.size() + 1;
        InitPrgressBar(TotalResults + 3);

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

        txtStatues.setText("Loading Product Images...");

        super.update(this.getGraphics());
        LoadImages();
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
        jLabel6 = new javax.swing.JLabel();

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
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 147, 169)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStatues.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtStatues.setForeground(new java.awt.Color(102, 102, 102));
        txtStatues.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatues.setText("aaa");
        jPanel1.add(txtStatues, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 560, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("ERP");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 60, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/iconappimg_small.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 80, 60));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 570, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("BiZ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 90, 50));

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

    public void LoadImages() {
        /*
        try {

            ArrayList<MProducts> allProducts = cPro.getAllProducts(2);
            for (MProducts mProducts : allProducts) {
                String imgpath = mProducts.getProImg();
                File f = new File(imgpath);
                if (f.exists()) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(f);
                        GlobalData.ProImg.put(mProducts.getId(), img);

                    } catch (IOException e) {

                        System.out.println("Pro img Load[Loading]" + e.getMessage());
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Pro img [Loading]" + e.getMessage());
        }
         */
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel txtStatues;
    // End of variables declaration//GEN-END:variables
}
