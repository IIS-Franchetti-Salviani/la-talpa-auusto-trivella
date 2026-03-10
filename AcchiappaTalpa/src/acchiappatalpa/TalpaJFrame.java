package acchiappatalpa;

import javax.swing.JLabel;

/**
 * @author trivella.augusto
 */
public class TalpaJFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TalpaJFrame.class.getName());
    private Gestore gestore;

    public TalpaJFrame() {
        initComponents();
        
        // 1. Array delle buche
        javax.swing.JLabel[] arrayBuche = {
            buca1, buca2, buca3, buca4, buca5, buca6, buca7, buca8
        };

        // 2. Inizializzazione gestore con Punteggio e Timer
        gestore = new Gestore(arrayBuche, lblPunteggio, lblTimer);
        gestore.start(); 
        
        // 3. Aggiunta listener per il click
        for (int i = 0; i < arrayBuche.length; i++) {
            final int indiceBuca = i; 
            arrayBuche[i].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    gestore.verificaColpo(indiceBuca);
                }
            });
            // Rimuove il testo "jLabel3" lasciando solo l'immagine
            arrayBuche[i].setText("");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buca5 = new javax.swing.JLabel();
        buca6 = new javax.swing.JLabel();
        buca1 = new javax.swing.JLabel();
        buca8 = new javax.swing.JLabel();
        buca2 = new javax.swing.JLabel();
        buca3 = new javax.swing.JLabel();
        buca4 = new javax.swing.JLabel();
        buca7 = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPunteggio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buca5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        buca5.setText("jLabel3");

        buca6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        buca6.setText("jLabel3");

        buca1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        buca1.setText("jLabel3");

        buca8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        buca8.setText("jLabel3");

        buca2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        buca2.setText("jLabel3");

        buca3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        buca3.setText("jLabel3");

        buca4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        buca4.setText("jLabel3");

        buca7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        buca7.setText("jLabel3");

        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("punteggio:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(buca1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(buca2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(buca3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(buca4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(buca5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(buca6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)
                        .addComponent(buca7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(buca8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPunteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblPunteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buca1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buca2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buca3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buca4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buca5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buca6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buca7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buca8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TalpaJFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buca1;
    private javax.swing.JLabel buca2;
    private javax.swing.JLabel buca3;
    private javax.swing.JLabel buca4;
    private javax.swing.JLabel buca5;
    private javax.swing.JLabel buca6;
    private javax.swing.JLabel buca7;
    private javax.swing.JLabel buca8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPunteggio;
    private javax.swing.JLabel lblTimer;
    // End of variables declaration//GEN-END:variables
}
