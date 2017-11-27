/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBUI;

import MAIN.Frm_Main;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRootPane;
import org.apache.poi.util.IOUtils;

/**
 *
 * @author user pc
 */
public class Frm_Help extends javax.swing.JDialog {

    /**
     * Creates new form FRm_Help
     */
    public Frm_Help(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
         this.setBounds(this.getX(), this.getY(),400, 300);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        but_UTube = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        but_PDF = new javax.swing.JButton();
        butLogout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 147, 169)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(110, 147, 169));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("              Help");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Click to Watch Tutorial videos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 330, 30));

        but_UTube.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/if_youtube_social_media_logo_1078775.png"))); // NOI18N
        but_UTube.setContentAreaFilled(false);
        but_UTube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_UTubeActionPerformed(evt);
            }
        });
        jPanel1.add(but_UTube, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 330, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Click to Read Document");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 340, 30));

        but_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/if_icon-70-document-file-pdf_315672.png"))); // NOI18N
        but_PDF.setContentAreaFilled(false);
        but_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_PDFActionPerformed(evt);
            }
        });
        jPanel1.add(but_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 350, 70));

        butLogout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        butLogout.setForeground(new java.awt.Color(89, 143, 179));
        butLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SYSIMG/if_free-09_463017.png"))); // NOI18N
        butLogout.setToolTipText("Exit [Esc]");
        butLogout.setBorderPainted(false);
        butLogout.setContentAreaFilled(false);
        butLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(butLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 40, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(137, 163, 189));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(" info.bizerp@gmail.com");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 380, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void but_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_PDFActionPerformed

        showPDF();


    }//GEN-LAST:event_but_PDFActionPerformed

    private void butLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLogoutActionPerformed
        this.dispose();
    }//GEN-LAST:event_butLogoutActionPerformed

    private void but_UTubeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_UTubeActionPerformed
       showWebpage();
    }//GEN-LAST:event_but_UTubeActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_Help dialog = new Frm_Help(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butLogout;
    private javax.swing.JButton but_PDF;
    private javax.swing.JButton but_UTube;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void showPDF() {

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("SYS_DOC/BIZ.pdf");
            try {
                File file = File.createTempFile("User_Guide", ".pdf");
                file.deleteOnExit();
                FileOutputStream out = new FileOutputStream(file);
                try {
                    // copy contents from resource to out
                    IOUtils.copy(resource, out);
                } finally {
                    out.close();

                }
                desktop.open(file);
            } catch (Exception ex) {
                Logger.getLogger(Frm_Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    resource.close();
                } catch (IOException ex) {
                    Logger.getLogger(Frm_Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public  void showWebpage() {
    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
            desktop.browse(new URL("https://www.youtube.com/channel/UCJ2Vpt1nQ_k20lZWTc0PmHQ").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}
