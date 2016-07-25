package InterfaceGraphique;

import Domaine.Application;
import Domaine.Couleur;
import Domaine.*;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ApplicationVue extends JFrame implements ActionListener {

    private JButton[][] cellules = new JButton[8][8];
    private JPanel contenu;
    private JPanel tableauDeBord;
    private JPanel pointage;
    private JPanel option;
    private JPanel table;
    private Application app;

    private JLabel ordinateur;
    private JLabel joueur;
    private JTextField ordinateurPoints;
    private JTextField joueurPoints;

    private JButton boutonSauvegarder;
    private JButton boutonChargerPartie;
    private JButton boutonVisualiserPartie;
    private JButton boutonQuitter;

    public ApplicationVue(Application app) {

        contenu = new JPanel();
        setContentPane(contenu);
        contenu.setLayout(new GridLayout(0, 2));

        this.app = app;
        setTitle("Othello");
        setBounds(450, 200, 1200, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table = new JPanel(new GridLayout(0, 9));
        table.setBackground(Color.decode("#AD4F09"));

        for (int i = 0; i < cellules.length; i++) {
            for (int j = 0; j < cellules[i].length; j++) {
                JButton b = new JButton();

                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(new Color(0, 150, 0));
                } else {
                    b.setBackground(new Color(0, 100, 0));
                }
                cellules[j][i] = b;
                cellules[j][i].addActionListener(new CelluleActionListener(i, j));
            }
        }

        for (int i = 0; i < 8; i++) {
            table.add(new JLabel(""));
        }

        for (int i = 0; i < cellules.length; i++) {
            for (int j = 0; j < cellules.length; j++) {
                if (j == 0) {
                    table.add(new JLabel(""));
                }
                table.add(cellules[j][i]);
            }
        }

        tableauDeBord = new JPanel();
        tableauDeBord.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel pointage = new JPanel();
        pointage.setBackground(Color.decode("#AD4F09"));

        pointage.setBorder(new TitledBorder(null, "Pointage",
                TitledBorder.LEFT, TitledBorder.TOP, null, Color.decode("#FFFFFF")));

        pointage.setLayout(new GridLayout(4, 1, 0, 0));

        ordinateur = new JLabel("Ordinateur");
        ordinateur.setForeground(Color.decode("#FFFFFF"));
        joueur = new JLabel("Vous");
        joueur.setForeground(Color.decode("#FFFFFF"));

        ordinateurPoints = new JTextField();
        joueurPoints = new JTextField();

        pointage.add(ordinateur);
        pointage.add(ordinateurPoints);
        pointage.add(joueur);
        pointage.add(joueurPoints);

        JPanel option = new JPanel();
        option.setBackground(Color.decode("#AD4F09"));

        option.setBorder(new TitledBorder(null, "Options",
                TitledBorder.LEFT, TitledBorder.TOP, null, Color.decode("#FFFFFF")));

        option.setLayout(new GridLayout(4, 1, 0, 0));

        boutonSauvegarder = new JButton("Sauvegarder la partie");
        boutonSauvegarder.setBackground(Color.decode("#87E990"));
        boutonSauvegarder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {
               
                interfaceGraphique.SaisirNomSauvegarde nomSauvegarde = new interfaceGraphique.SaisirNomSauvegarde(app.getPartie());
                nomSauvegarde.setVisible(true);

                
              
            }
        });
        
        

        boutonChargerPartie = new JButton("Charger la partie");
        boutonChargerPartie.setBackground(Color.decode("#87E990"));
        boutonChargerPartie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {
              
            }
        });

        boutonVisualiserPartie = new JButton("Visualiser la partie");
        boutonVisualiserPartie.setBackground(Color.decode("#87E990"));
        boutonVisualiserPartie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {
                app.getPartie().visualiser();
            }
        });

        boutonQuitter = new JButton("Quitter");
        boutonQuitter.setBackground(Color.decode("#87E990"));
        boutonQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(1);
            }
        });

        option.add(boutonSauvegarder);
        option.add(boutonChargerPartie);
        option.add(boutonVisualiserPartie);
        option.add(boutonQuitter);

        tableauDeBord.add(pointage);
        tableauDeBord.add(option);

        contenu.add(table);
        contenu.add(tableauDeBord);

    }

    public void actionPerformed(ActionEvent e) {

    }

    public void setCouleurCellule(int i, int j, Couleur couleur) {
        if (couleur.equals(Couleur.BLANC)) {
            cellules[j][i].setBackground(Color.white);
        } else {
            cellules[j][i].setBackground(Color.black);
        }
    }

    private class CelluleActionListener implements ActionListener {

        private int i;
        private int j;

        public CelluleActionListener(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("i: " + i + ", j: " + j);
            app.getPartie().jouer(i, j);
        }
    }

    public void setOrdinateurPoints(int ordinateurPoints) {

        this.ordinateurPoints.setText(Integer.toString(ordinateurPoints));
    }

    public void setJoueurPoints(int joueurPoints) {
        this.joueurPoints.setText(Integer.toString(joueurPoints));
    }

}
