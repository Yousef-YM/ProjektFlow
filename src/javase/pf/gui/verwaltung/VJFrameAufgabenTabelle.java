/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javase.pf.gui.verwaltung;

import java.util.ArrayList;
import javase.pf.haupt.Aufgaben;
import javase.pf.handler.VerwaltungHandler;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class VJFrameAufgabenTabelle extends javax.swing.JFrame {

    /**
     * Creates new form AufgabenTabelle
     */
    public VJFrameAufgabenTabelle() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAufgaben = new javax.swing.JTable();
        jButtonAufgabeAnzeigen = new javax.swing.JButton();
        jTextFieldAnfrageId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTableAufgaben.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Aufgabe-ID", "Projekt-ID", "Projekt-Name", "P.leiter-ID", "P.Name", "M-ID", "M-Name", "Erstell-Datum", "Status", "Zeitraum-Tage"
            }
        ));
        jScrollPane1.setViewportView(jTableAufgaben);

        jButtonAufgabeAnzeigen.setText("Aufgabe anzeigen");
        jButtonAufgabeAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAufgabeAnzeigenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Bitte geben Sie die Anfrage-ID an, für die Sie die Nachricht sehen möchten.");

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
                        .addComponent(jButtonAufgabeAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAufgabeAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAnfrageId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAufgabeAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAufgabeAnzeigenActionPerformed

        int aufgabeId = Integer.parseInt(jTextFieldAnfrageId.getText());

        String beschreibung = VerwaltungHandler.aufgabeBeschreibungBayAufgabeId(aufgabeId);

        JFrame beschreibungFenster = new JFrame("Aufgabenbeschreibung");
        // Fenster schließen, ohne das Hauptfenster zu beeinflussen
        beschreibungFenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel beschreibungLabel = new JLabel("<html><body>" + "Aufgabenbeschreibung: " + beschreibung + "</body></html>");
        beschreibungLabel.setHorizontalAlignment(SwingConstants.CENTER);

        beschreibungFenster.add(beschreibungLabel);

        int width = 400;
        int height = 200;
        beschreibungFenster.setSize(width, height);

        // Fenster in der Mitte des Bildschirms positionieren
        beschreibungFenster.setLocationRelativeTo(null);
        beschreibungFenster.setVisible(true);
    }//GEN-LAST:event_jButtonAufgabeAnzeigenActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getAllAufgaben();
    }//GEN-LAST:event_formWindowOpened

    public void getAllAufgaben() {
        ArrayList<Aufgaben> augabenList = VerwaltungHandler.getAllAufgaben();
        DefaultTableModel tm = (DefaultTableModel) jTableAufgaben.getModel();
        tm.setRowCount(0);

        for (Aufgaben a : augabenList) {
            Object[] rowData = {
                a.getAufgabeId(),
                a.getProjektId(),
                a.getProjektName(),
                a.getProjektleiterId(),
                a.getProjektleiterName(),
                a.getMitarbeiterId(),
                a.getMitarbeiterName(),
                a.getErstellungDatum(),
                a.getZeitraumTage(),
                a.getStatus()
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
            java.util.logging.Logger.getLogger(VJFrameAufgabenTabelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VJFrameAufgabenTabelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VJFrameAufgabenTabelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VJFrameAufgabenTabelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VJFrameAufgabenTabelle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAufgabeAnzeigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAufgaben;
    private javax.swing.JTextField jTextFieldAnfrageId;
    // End of variables declaration//GEN-END:variables
}
