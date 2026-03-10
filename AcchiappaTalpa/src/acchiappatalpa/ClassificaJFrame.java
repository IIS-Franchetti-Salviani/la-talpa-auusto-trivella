/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package acchiappatalpa;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ClassificaJFrame extends javax.swing.JFrame {

    public ClassificaJFrame(int punteggioOttenuto) {
    initComponents(); 
    
    btnPlayAgain.setBackground(new java.awt.Color(255, 102, 0)); 
    btnPlayAgain.setForeground(java.awt.Color.WHITE);
    btnPlayAgain.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    
    this.getContentPane().setBackground(new java.awt.Color(34, 139, 34)); 
    jLabel1.setForeground(java.awt.Color.YELLOW);

    this.setLocationRelativeTo(null); 

    String nome = JOptionPane.showInputDialog(this, "Partita finita! Inserisci il tuo nome:");
    if (nome == null || nome.trim().isEmpty()) nome = "Anonimo";

    salvaPunteggio(nome, punteggioOttenuto);
    caricaClassificaInTabella();
}

    public ClassificaJFrame() {
        initComponents();
        caricaClassificaInTabella();
    }

    private void salvaPunteggio(String nome, int punti) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("classifica.txt", true)))) {
            out.println(nome + ":" + punti);
        } catch (IOException e) {
            System.err.println("Errore nel salvataggio: " + e.getMessage());
        }
    }

    private void caricaClassificaInTabella() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Giocatore", "Punteggio"}, 0) {

            @Override
            public Class<?> getColumnClass(int column) {
                return column == 1 ? Integer.class : String.class;
            }
        };
        
        jTable1.setModel(model);      
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getRowSorter().toggleSortOrder(1);
        jTable1.getRowSorter().toggleSortOrder(1); 

        File file = new File("classifica.txt");
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String riga = scanner.nextLine();
                String[] parti = riga.split(":");
                if (parti.length == 2) {
                    model.addRow(new Object[]{parti[0], Integer.parseInt(parti[1])});
                }
            }
        } catch (Exception e) {
            System.err.println("Errore nel caricamento: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPlayAgain = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPlayAgain.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        btnPlayAgain.setText("GIOCA ANCORA");
        btnPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayAgainActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlayAgain, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, -1, 88));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        jLabel1.setText("CLASSIFICA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 279, 87));

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "nome", "punteggio"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 461, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAgainActionPerformed
                                           
    new TalpaJFrame().setVisible(true); 
    this.dispose(); 
    }//GEN-LAST:event_btnPlayAgainActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ClassificaJFrame classifica = new ClassificaJFrame(0);
    classifica.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
