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
        
        javax.swing.JLabel[] arrayBuche = {
            buca1, buca2, buca3, buca4, buca5, buca6, buca7, buca8
        };

        gestore = new Gestore(arrayBuche, lblPunteggio, lblTimer);
        gestore.start(); 
        
        for (int i = 0; i < arrayBuche.length; i++) {
            final int indiceBuca = i; 
            arrayBuche[i].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    gestore.verificaColpo(indiceBuca);
                }
            });
            arrayBuche[i].setText("");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buca5 = new javax.swing.JLabel();
        buca6 = new javax.swing.JLabel();
        buca3 = new javax.swing.JLabel();
        buca1 = new javax.swing.JLabel();
        buca8 = new javax.swing.JLabel();
        buca2 = new javax.swing.JLabel();
        buca4 = new javax.swing.JLabel();
        buca7 = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPunteggio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buca5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        getContentPane().add(buca5, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 304, 159, 103));

        buca6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        getContentPane().add(buca6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 449, 159, 103));

        buca3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        getContentPane().add(buca3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 159, 103));

        buca1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        getContentPane().add(buca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 170, 159, 103));

        buca8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        getContentPane().add(buca8, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 449, 159, 103));

        buca2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        getContentPane().add(buca2, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 170, 159, 103));

        buca4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        getContentPane().add(buca4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 304, 159, 103));

        buca7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buca7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/bucaFinale.png"))); // NOI18N
        getContentPane().add(buca7, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 449, 159, 103));

        lblTimer.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 255, 255));
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 250, 55));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("punteggio:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        lblPunteggio.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblPunteggio.setForeground(new java.awt.Color(255, 255, 255));
        lblPunteggio.setText("0");
        getContentPane().add(lblPunteggio, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 110, 45));

        jLabel2.setBackground(new java.awt.Color(0, 153, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acchiappatalpa/sfondoFinale.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1320, 620));

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPunteggio;
    private javax.swing.JLabel lblTimer;
    // End of variables declaration//GEN-END:variables
}
