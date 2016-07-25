package interfaceGraphique;

import Domaine.Application;
import Domaine.Partie;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class SaisirNomSauvegarde extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contenant;
    private JPanel panelBouton;
    private JPanel panelInformation;
    private JButton boutonOrdinateur;
    private JButton boutonJoueur;
    private JTextField nomSauvegarde;
    private String nom;
    private JLabel info;

    private JOptionPane joueurInvalide;

    public SaisirNomSauvegarde(Partie partie) {

        setTitle("Nom de la sauvegarde");
        setBounds(800, 300, 400, 150);
        contenant = new JPanel();
        contenant.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contenant);
        contenant.setLayout(new GridLayout(2, 1, 0, 0));

        panelInformation = new JPanel();

        panelInformation.setBorder(new TitledBorder(null, "Veuillez saisir le nom de la sauvegarde",
                TitledBorder.LEFT, TitledBorder.TOP, null, Color.decode("#000000")));

        panelInformation.setLayout(new GridLayout(1, 1, 0, 0));

        nomSauvegarde = new JTextField();

        panelInformation.add(nomSauvegarde);

        panelBouton = new JPanel();

        panelBouton.setBorder(new TitledBorder(null, "",
                TitledBorder.LEFT, TitledBorder.TOP, null, Color.decode("#000000")));

        panelBouton.setLayout(new GridLayout(1, 1, 0, 0));

        boutonOrdinateur = new JButton("Ok");
        boutonOrdinateur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {

                nom = nomSauvegarde.getText();
                try {
                    Sauvegarde.XMLWriter.conversionStringXML(partie, nom);
                } catch (IOException ex) {
                    Logger.getLogger(SaisirNomSauvegarde.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);

            }
        });
        panelBouton.add(boutonOrdinateur);

        boutonJoueur = new JButton("Annuler");
        boutonJoueur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {
                setVisible(false);

            }
        });

        panelBouton.add(boutonJoueur);

        contenant.add(panelInformation);
        contenant.add(panelBouton);

        setVisible(true);

    }

    public JButton getBtnAjouter() {

        return boutonOrdinateur;

    }

    public JButton getBtnAnnuler() {

        return boutonJoueur;

    }

    public String getNom() {
        return nom;
    }

}
