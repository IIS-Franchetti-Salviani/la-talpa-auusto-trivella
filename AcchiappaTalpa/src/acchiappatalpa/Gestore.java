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
    private int tempoRimanente = 60; // Durata di 1 minuto
    
    private ImageIcon iconaTalpa;
    private ImageIcon iconaBucaVuota;
    private boolean inEsecuzione = true;
    private Random random = new Random();

    public Gestore(JLabel[] labelForm, JLabel lblPunteggio, JLabel lblTimer) {
        this.buche = labelForm;
        this.lblPunteggio = lblPunteggio;
        this.lblTimer = lblTimer;

        // 1. Salviamo l'immagine della buca vuota (quella che hai già messo nel Form)
        this.iconaBucaVuota = (ImageIcon) buche[0].getIcon();

        // 2. Carichiamo e ridimensioniamo la talpa
        try {
            java.net.URL imgURL = getClass().getResource("/acchiappatalpa/talpaFinale.png");
            if (imgURL != null) {
                ImageIcon originale = new ImageIcon(imgURL);
                // Ridimensioniamo a 150x100 per adattarla alle tue label
                Image ridimensionata = originale.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
                this.iconaTalpa = new ImageIcon(ridimensionata);
            }
        } catch (Exception e) {
            System.err.println("Errore: Immagine talpaFinale.png non trovata!");
        }
    }

    @Override
    public void run() {
        while (inEsecuzione && tempoRimanente > 0) {
            try {
                // Aspetta 1 secondo
                Thread.sleep(1000);
                tempoRimanente--;

                // Aggiorna l'interfaccia in modo sicuro
                SwingUtilities.invokeLater(() -> {
                    lblTimer.setText("Tempo: " + tempoRimanente + "s");
                    faiSpostareTalpa();
                    
                    if (tempoRimanente <= 0) {
                        terminaPartita();
                    }
                });
            } catch (InterruptedException e) {
                inEsecuzione = false;
            }
        }
    }

    private void faiSpostareTalpa() {
        // Rimuove la talpa dalla vecchia posizione rimetterndo la buca vuota
        if (posizioneTalpa != -1) {
            buche[posizioneTalpa].setIcon(iconaBucaVuota);
        }

        // Sceglie una nuova buca a caso
        int nuovaPosizione;
        do {
            nuovaPosizione = random.nextInt(buche.length);
        } while (nuovaPosizione == posizioneTalpa);

        // Mostra la talpa nella nuova posizione
        buche[nuovaPosizione].setIcon(iconaTalpa);
        posizioneTalpa = nuovaPosizione;
    }

    // Metodo chiamato quando clicchi su una buca nel JFrame
    public void verificaColpo(int indiceCliccato) {
        if (inEsecuzione && indiceCliccato == posizioneTalpa) {
            punti += 10; // Aggiunge punti
            lblPunteggio.setText("" + punti);
            
            // Fai sparire la talpa immediatamente se colpita
            buche[posizioneTalpa].setIcon(iconaBucaVuota);
            posizioneTalpa = -1;
        }
    }

    private void terminaPartita() {
    inEsecuzione = false; // Ferma il ciclo del thread

    // Usiamo SwingUtilities per essere sicuri di non mandare in crash la grafica
    javax.swing.SwingUtilities.invokeLater(() -> {
        
        // 1. Creiamo la finestra della classifica passandogli il punteggio attuale
        ClassificaJFrame schermataClassifica = new ClassificaJFrame(punti);
        
        // 2. LA RINDIAMO VISIBILE
        schermataClassifica.setVisible(true);
        
        // 3. CHIUDIAMO IL GIOCO
        // Troviamo la finestra TalpaJFrame partendo da una delle buche e la chiudiamo
        javax.swing.JFrame finestraGioco = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(buche[0]);
        if (finestraGioco != null) {
            finestraGioco.dispose(); 
        }
    });
}

    private void mostraClassifica() {
        // Per ora stampiamo in console, poi qui creerai il nuovo JFrame classifica
        System.out.println("Apertura classifica per il punteggio: " + punti);
        // Esempio: new ClassificaJFrame(punti).setVisible(true);
    }
}