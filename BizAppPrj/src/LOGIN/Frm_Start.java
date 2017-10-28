package LOGIN;

import COMMONFUN.CommonFun;
import COMMONFUN.DefaultData;
import SETTINGS.Settings;
import TABLE_STRUCT.TableStruCreation;
import TABLE_STRUCT.TblColumn;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

public final class Frm_Start extends javax.swing.JDialog {

    TableStruCreation TblStru = null;
    SETTINGS.Settings settings = null;
    DefaultData DefData = null;

    public Frm_Start(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        TblStru = new TableStruCreation();
        settings = new Settings();
        DefData = new DefaultData();

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

        
        
        
        
        int TotalResults = arStructures.size() + 1;
        InitPrgressBar(TotalResults);

        /* ##################### TABLE STRUCTURE CREATION ###########################*/
        int latestVersion = 20160901;
        for (Structure structure : arStructures) {
            if (structure.version > settings.getVersion()) {

                try {

                    if (structure.getSQL() == null || structure.getSQL().equals("")) {
                        TblStru.createTable(structure.getTableName(), structure.getColumns(), structure.getPrimaryKeys());
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
        DefData.createDefaultData();
        setProgressBarVal();

        this.dispose();
        new LOGIN.Frm_Login().setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 580, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/iconappimg.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 140, 110));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(110, 147, 169));
        jLabel5.setText("Biz");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 100, 50));

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

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
