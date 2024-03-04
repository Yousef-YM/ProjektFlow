/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javase.pf.gui.verwaltung;

import java.util.ArrayList;
import javase.pf.haupt.Anfrage;
import javase.pf.handler.VerwaltungHandler;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class VJFrameAnfragenTabelle extends javax.swing.JFrame {

    /**
     * Creates new form AufgabenJFrame
     */
    public VJFrameAnfragenTabelle() {
        initComponents();
        setSize(960, 550);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldAnfrageId = new javax.swing.JTextField();
        jButtonAnfrageAnzeigen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAnfragen = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButtonAnfrageAnzeigen.setText("Aufgabe anzeigen");
        jButtonAnfrageAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnfrageAnzeigenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Bitte geben Sie die Anfrage-ID an, für die Sie die Nachricht sehen möchten.");

        jTableAnfragen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Anfrage-ID", "P.leiter-ID", "P.Name", "Erstell-Datum"
            }
        ));
        jScrollPane1.setViewportView(jTableAnfragen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAnfrageId, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAnfrageAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnfrageAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAnfrageId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnfrageAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnfrageAnzeigenActionPerformed

        int aufgabeId = Integer.parseInt(jTextFieldAnfrageId.getText());

        String nachricht = VerwaltungHandler.anfrageNachrichtByProjektleiterId(aufgabeId);

        JFrame nachrichtFenster = new JFrame("Die Anfrage");
        // Fenster schließen, ohne das Hauptfenster zu beeinflussen
        nachrichtFenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel beschreibungLabel = new JLabel("<html><body>" + "Anfragebeschreibung: " + nachricht + "</body></html>");
        beschreibungLabel.setHorizontalAlignment(SwingConstants.CENTER);

        nachrichtFenster.add(beschreibungLabel);

        int width = 400;
        int height = 200;
        nachrichtFenster.setSize(width, height);

        // Fenster in der Mitte des Bildschirms positionieren
        nachrichtFenster.setLocationRelativeTo(null);
        nachrichtFenster.setVisible(true);
    }//GEN-LAST:event_jButtonAnfrageAnzeigenActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        gettAllAnfragen();
    }//GEN-LAST:event_formWindowOpened

    public void gettAllAnfragen() {
        ArrayList<Anfrage> anfragenList = VerwaltungHandler.getAnfragenVonProjektleiter();
        DefaultTableModel tm = (DefaultTableModel) jTableAnfragen.getModel();
        tm.setRowCount(0);

        for (Anfrage a : anfragenList) {
            Object[] rowData = {
                a.getAnfrageId(),
                a.getProjektleiterId(),
                a.getProjektleiterName(),
                a.getErstellDatum()
            };
            tm.addRow(rowData);
        }
    }

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
            java.util.logging.Logger.getLogger(VJFrameAnfragenTabelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VJFrameAnfragenTabelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VJFrameAnfragenTabelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VJFrameAnfragenTabelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VJFrameAnfragenTabelle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnfrageAnzeigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAnfragen;
    private javax.swing.JTextField jTextFieldAnfrageId;
    // End of variables declaration//GEN-END:variables
}
