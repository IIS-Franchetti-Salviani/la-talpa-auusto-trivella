package acchiappatalpa;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Gestore extends Thread {
    private JLabel[] buche;
    private JLabel lblPunteggio;
    private JLabel lblTimer;
    
    private int posizioneTalpa = -1;
    private int punti = 0;
    private int tempoRimanente = 60;
    private ImageIcon iconaTalpaColpita;
    private ImageIcon iconaTalpa;
    private ImageIcon iconaBucaVuota;
    private boolean inEsecuzione = true;
    private Random random = new Random();

    public Gestore(JLabel[] labelForm, JLabel lblPunteggio, JLabel lblTimer) {
    this.buche = labelForm;
    this.lblPunteggio = lblPunteggio;
    this.lblTimer = lblTimer;

    this.iconaBucaVuota = (ImageIcon) buche[0].getIcon();

    try {
        java.net.URL imgURL = getClass().getResource("/acchiappatalpa/talpaFinale.png");
        if (imgURL != null) {
            Image ridimensionata = new ImageIcon(imgURL).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
            this.iconaTalpa = new ImageIcon(ridimensionata);
        }
    } catch (Exception e) { System.err.println("Errore talpaFinale.png"); }

    try {
        java.net.URL imgURLColpita = getClass().getResource("/acchiappatalpa/talpaColpita.png");
        if (imgURLColpita != null) {
            Image ridimensionata = new ImageIcon(imgURLColpita).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
            this.iconaTalpaColpita = new ImageIcon(ridimensionata);
        }
    } catch (Exception e) { System.err.println("Errore talpaColpita.png"); }
}

    @Override
public void run() {
    long ultimoSpostamento = System.currentTimeMillis();

    while (inEsecuzione && tempoRimanente > 0) {
        try {
            Thread.sleep(100); 

            if (System.currentTimeMillis() - ultimoSpostamento >= 1000) {
                tempoRimanente--;
                ultimoSpostamento = System.currentTimeMillis();

                SwingUtilities.invokeLater(() -> {
                    lblTimer.setText("Tempo: " + tempoRimanente + "s");

                    if (tempoRimanente <= 10) {
                        lblTimer.setForeground(java.awt.Color.RED);
                        lblTimer.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
                    }

                    faiSpostareTalpa();

                    if (tempoRimanente <= 0) {
                        terminaPartita();
                    }
                });
            }
        } catch (InterruptedException e) {
            inEsecuzione = false;
        }
    }
}

    private void faiSpostareTalpa() {
        if (posizioneTalpa != -1) {
            buche[posizioneTalpa].setIcon(iconaBucaVuota);
        }

        int nuovaPosizione;
        do {
            nuovaPosizione = random.nextInt(buche.length);
        } while (nuovaPosizione == posizioneTalpa);

        buche[nuovaPosizione].setIcon(iconaTalpa);
        posizioneTalpa = nuovaPosizione;
    }

    public void verificaColpo(int indiceCliccato) {
        if (inEsecuzione && indiceCliccato == posizioneTalpa) {
            punti += 10;
            lblPunteggio.setText("" + punti);
        
            int posColpita = posizioneTalpa;
            buche[posColpita].setIcon(iconaTalpaColpita);
            posizioneTalpa = -1; 

            new javax.swing.Timer(300, e -> {
            buche[posColpita].setIcon(iconaBucaVuota);
            ((javax.swing.Timer)e.getSource()).stop();
            }).start();
        }
    }
    
    private void terminaPartita() {
        inEsecuzione = false; 

        ClassificaJFrame schermataClassifica = new ClassificaJFrame(punti);
        schermataClassifica.setVisible(true);

        javax.swing.JFrame finestraGioco = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(buche[0]);
        if (finestraGioco != null) {
        finestraGioco.dispose(); 
        }
    }
}