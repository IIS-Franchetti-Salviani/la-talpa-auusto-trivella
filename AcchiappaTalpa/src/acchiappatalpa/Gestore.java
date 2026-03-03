package acchiappatalpa;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author trivella.augusto
 */
import java.util.Random;

public class Gestore {

    private Buca[] buche = new Buca[8];
    private Talpa talpa = new Talpa();
    private Random random = new Random();

    public Gestore() {
        for (int i = 0; i < 8; i++) {
            buche[i] = new Buca();
        }
    }

    public void spostaTalpa() {

        // reset precedente
        for (Buca b : buche) {
            b.setTalpa(false);
        }

        int nuovaPos = random.nextInt(8);

        buche[nuovaPos].setTalpa(true);
        talpa.setPosizione(nuovaPos);
    }

    public Buca[] getBuche() {
        return buche;
    }
}
