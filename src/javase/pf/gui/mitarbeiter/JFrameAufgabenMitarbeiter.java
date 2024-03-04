/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javase.pf.gui.mitarbeiter;

import java.util.ArrayList;
import javase.pf.haupt.Aufgaben;
import javase.pf.handler.MitarbeiterHandler;
import javase.pf.handler.VerwaltungHandler;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class JFrameAufgabenMitarbeiter extends javax.swing.JFrame {

    /**
     * Creates new form JFrameAufgaben
     */
    public JFrameAufgabenMitarbeiter() {
        initComponents();
        setSize(960, 550);
    }

    private int mitarbeiterId;

    public void setMitarbeiterId(int mitarbeiterId) {
        this.mitarbeiterId = mitarbeiterId;
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
        jTextFieldAufgabeIdAnzeigen = new javax.swing.JTextField();
        jLabelAufgabeAnzeigen = new javax.swing.JLabel();
        jButtonAufgabeErledigenMarkieren = new javax.swing.JButton();
        jTextFielErledigtedAufgabeId = new javax.swing.JTextField();
        jLabelErledigteAufgabe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTableAufgaben.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Aufgabe-ID", "Projekt-ID", "Projektleiter-ID", "Projektleiter Name", "Zeitraum-Tage", "Status", "Erstell-Datum"
            }
        ));
        jScrollPane1.setViewportView(jTableAufgaben);

        jButtonAufgabeAnzeigen.setText("Aufgabe anzeigen");
        jButtonAufgabeAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAufgabeAnzeigenActionPerformed(evt);
            }
        });

        jLabelAufgabeAnzeigen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAufgabeAnzeigen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAufgabeAnzeigen.setText("Bitte geben Sie die Anfrage-ID an, für die Sie die Nachricht sehen möchten.     ");

        jButtonAufgabeErledigenMarkieren.setText("Erledigt");
        jButtonAufgabeErledigenMarkieren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAufgabeErledigenMarkierenActionPerformed(evt);
            }
        });

        jLabelErledigteAufgabe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelErledigteAufgabe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelErledigteAufgabe.setText("Bitte geben Sie die Anfrage-ID an, die Sie erledigt haben und klick auf erledigen.    ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAufgabeAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelErledigteAufgabe, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextFieldAufgabeIdAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAufgabeAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextFielErledigtedAufgabeId, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAufgabeErledigenMarkieren, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAufgabeAnzeigen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldAufgabeIdAnzeigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAufgabeAnzeigen, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAufgabeErledigenMarkieren)
                        .addComponent(jTextFielErledigtedAufgabeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelErledigteAufgabe, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAufgabeAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAufgabeAnzeigenActionPerformed

        int aufgabeId = Integer.parseInt(jTextFieldAufgabeIdAnzeigen.getText());

        String beschreibung = VerwaltungHandler.aufgabeBeschreibungBayAufgabeId(aufgabeId);

        JFrame beschreibungFenster = new JFrame("Aufgabenbeschreibung");
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
        gettAllaufgabenMitarbeiter();
    }//GEN-LAST:event_formWindowOpened

    private void jButtonAufgabeErledigenMarkierenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAufgabeErledigenMarkierenActionPerformed
        int aufgabeId = Integer.parseInt(jTextFielErledigtedAufgabeId.getText());
        Aufgaben aufgabe = new Aufgaben(aufgabeId, mitarbeiterId);
        MitarbeiterHandler.statusAufgabeAndern(aufgabe);

        gettAllaufgabenMitarbeiter();
        textFieldLeer();
        JOptionPane.showMessageDialog(null, "Aufgabe " + jTextFielErledigtedAufgabeId.getText() + " ist erledigt");
    }//GEN-LAST:event_jButtonAufgabeErledigenMarkierenActionPerformed

    public void gettAllaufgabenMitarbeiter() {
        ArrayList<Aufgaben> augabenList = MitarbeiterHandler.getAufgabenByMitarbeiterId(mitarbeiterId);
        DefaultTableModel tm = (DefaultTableModel) jTableAufgaben.getModel();
        tm.setRowCount(0);

        for (Aufgaben a : augabenList) {
            Object[] rowData = {
                a.getAufgabeId(),
                a.getProjektId(),
                a.getProjektleiterId(),
                a.getProjektleiterName(),
                a.getZeitraumTage(),
                a.getStatus(),
                a.getErstellungDatum()
            };
            tm.addRow(rowData);
        }
    }

    public void textFieldLeer() {
        jTextFielErledigtedAufgabeId.setText(null);
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
            java.util.logging.Logger.getLogger(JFrameAufgabenMitarbeiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAufgabenMitarbeiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAufgabenMitarbeiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAufgabenMitarbeiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAufgabenMitarbeiter().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAufgabeAnzeigen;
    private javax.swing.JButton jButtonAufgabeErledigenMarkieren;
    private javax.swing.JLabel jLabelAufgabeAnzeigen;
    private javax.swing.JLabel jLabelErledigteAufgabe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAufgaben;
    private javax.swing.JTextField jTextFielErledigtedAufgabeId;
    private javax.swing.JTextField jTextFieldAufgabeIdAnzeigen;
    // End of variables declaration//GEN-END:variables
}
