package aam_lab5_doc;

import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hwpf.HWPFDocument;

public class ReceiptWord extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    class TThread1 extends Thread {

        public void run() {
            String dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator");
            
            // Чтение из файла-шаблона в переменную doc
            HWPFDocument doc = null;
            try (FileInputStream fis = new FileInputStream(dir + "receipt_template.doc")) {
                doc = new HWPFDocument(fis);
                fis.close();
            } catch (Exception ex) {
                System.err.println("Error template!");
            }

            // Замена в переменной doc данных
            try {
                doc.getRange().replaceText("$FIO", jTextField_FIO.getText());
                doc.getRange().replaceText("$DATA", jTextField_Date.getText());
                doc.getRange().replaceText("$ADRES", jTextField_Adres.getText());
                doc.getRange().replaceText("$Any", jTextField_Any.getText());
            } catch (Exception ex) {
                System.err.println("Error replaceText!");
            }

            // Сохранение переменной doc в новый файл
            try (FileOutputStream fos = new FileOutputStream(dir + "receipt.doc")) {
                doc.write(fos);
                fos.close();
                // Открытие файла внешней программой
                if (System.getProperty("os.name").equals("Linux")
                        && System.getProperty("java.vendor").startsWith("Red Hat")) {
                    new ProcessBuilder("xdg-open", dir + "receipt.doc").start();
                } else {
                    Desktop.getDesktop().open(new File(dir + "receipt.doc"));
                }
            } catch (Exception ex) {
                System.err.println("Error getDesktop!");
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    public ReceiptWord() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Save = new javax.swing.JButton();
        jTextField_FIO = new javax.swing.JTextField();
        jTextField_Date = new javax.swing.JTextField();
        jTextField_Any = new javax.swing.JTextField();
        jTextField_Adres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Квитанция в MS Word");
        setResizable(false);
        getContentPane().setLayout(null);

        jButton_Save.setText("в WORD");
        jButton_Save.setToolTipText("");
        jButton_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Save);
        jButton_Save.setBounds(160, 450, 80, 23);

        jTextField_FIO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_FIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_FIOActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_FIO);
        jTextField_FIO.setBounds(60, 270, 270, 20);

        jTextField_Date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DateActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_Date);
        jTextField_Date.setBounds(150, 310, 100, 20);

        jTextField_Any.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Any);
        jTextField_Any.setBounds(110, 390, 180, 20);

        jTextField_Adres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Adres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_AdresActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_Adres);
        jTextField_Adres.setBounds(120, 330, 160, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aam_lab5_doc/screen2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 390, 540);

        setSize(new java.awt.Dimension(408, 576));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        new TThread1().start();
    }//GEN-LAST:event_jButton_SaveActionPerformed

    private void jTextField_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DateActionPerformed

    private void jTextField_AdresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_AdresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_AdresActionPerformed

    private void jTextField_FIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_FIOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_FIOActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceiptWord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField_Adres;
    private javax.swing.JTextField jTextField_Any;
    private javax.swing.JTextField jTextField_Date;
    private javax.swing.JTextField jTextField_FIO;
    // End of variables declaration//GEN-END:variables
}
