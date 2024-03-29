/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package javase.pf.nichts;

/**
 *
 * @author user
 */
public class HauptJFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    public HauptJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMitarbeiter = new javax.swing.JButton();
        jProjektleiter = new javax.swing.JButton();
        jVerwaltung = new javax.swing.JButton();
        jTitel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMitarbeiter.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jMitarbeiter.setText("Mitarbeiter");
        jMitarbeiter.setPreferredSize(null);

        jProjektleiter.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jProjektleiter.setText("Projektleiter");

        jVerwaltung.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jVerwaltung.setText("Verwaltung");
        jVerwaltung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVerwaltungActionPerformed(evt);
            }
        });

        jTitel.setFont(new java.awt.Font("Segoe Print", 1, 48)); // NOI18N
        jTitel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitel.setText("ProjektFlow");
        jTitel.setPreferredSize(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jVerwaltung, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jProjektleiter, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jMitarbeiter, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTitel, javax.swing.GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTitel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProjektleiter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jMitarbeiter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jVerwaltung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jVerwaltungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVerwaltungActionPerformed
        // hier wollte ich JInternalFrameVerwaltung verwendet "Internal"
        //JInternalFrameVerwaltung verwaltungScreen = new JInternalFrameVerwaltung();
        //verwaltungScreen.setVisible(true);
        //jPanelDesktop.add(verwaltungScreen);

        /*
        JFrameVerwaltung jVerwaltung = new JFrameVerwaltung();
        jVerwaltung.setVisible(true);
        */

        Verwaltung__JFrame jV = new Verwaltung__JFrame();
        jV.setVisible(true);

    }//GEN-LAST:event_jVerwaltungActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jMitarbeiter;
    private javax.swing.JButton jProjektleiter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jTitel;
    private javax.swing.JButton jVerwaltung;
    // End of variables declaration//GEN-END:variables
}
