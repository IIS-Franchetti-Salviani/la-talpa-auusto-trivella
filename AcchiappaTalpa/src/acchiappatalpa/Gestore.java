package acchiappatalpa;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Gestore extends Thread {
    private JLabel[] buche;
    private int posizioneTalpa = -1;
    private Random random = new Random();
    private ImageIcon iconaTalpa;
    private ImageIcon iconaBucaVuota; 
    private boolean inEsecuzione = true;

    public Gestore(JLabel[] labelForm) {
        this.buche = labelForm;
        
        // Salviamo l'immagine attuale della label (bucaFinale.png) per poterla ripristinare
        this.iconaBucaVuota = (ImageIcon) buche[0].getIcon();

        // Carichiamo la talpa e la ridimensioniamo per farla stare bene nella buca
        try {
            // Usiamo il percorso corretto del tuo pacchetto
            java.net.URL imgURL = getClass().getResource("/acchiappatalpa/talpaFinale.png");
            if (imgURL != null) {
                ImageIcon originale = new ImageIcon(imgURL);
                // Ridimensioniamo l'immagine a 150x100 (le misure che hai nel form)
                Image ridimensionata = originale.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
                this.iconaTalpa = new ImageIcon(ridimensionata);
            }
        } catch (Exception e) {
            System.err.println("Errore nel caricamento di talpaFinale.png");
        }
    }

    @Override
    public void run() {
        while (inEsecuzione) {
            try {
                Thread.sleep(1000); // Cambia buca ogni secondo
                SwingUtilities.invokeLater(() -> faiComparireTalpa());
            } catch (InterruptedException e) {
                inEsecuzione = false;
            }
        }
    }

    public void faiComparireTalpa() {
        // 1. Ripristiniamo l'immagine della buca vuota nella posizione precedente
        if (posizioneTalpa != -1) {
            buche[posizioneTalpa].setIcon(iconaBucaVuota);
        }

        // 2. Scegliamo una nuova buca a caso
        int nuovaPosizione;
        do {
            nuovaPosizione = random.nextInt(buche.length);
        } while (nuovaPosizione == posizioneTalpa);

        // 3. Cambiamo l'immagine della label in talpaFinale.png
        buche[nuovaPosizione].setIcon(iconaTalpa);
        posizioneTalpa = nuovaPosizione;
    }
    
    public void fermaGioco() {
        inEsecuzione = false;
        this.interrupt();
    }
}