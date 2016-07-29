package interfaceGraphique;

import Domaine.Application;
import Domaine.Partie;
import Domaine.PartieIA;
import Domaine.Table;
import static Sauvegarde.XMLReader.lireFichiersRepertoire;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ChargerPartie extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contenant;
    private JPanel panelBouton;
    private JPanel panelInformation;
    private JButton boutonOrdinateur;
    private JButton boutonJoueur;
    private String nom;
    private JLabel info;
    JComboBox choixChargerPartie;
    Application app;
    

    private JOptionPane joueurInvalide;

    public ChargerPartie(Application app) {

        setTitle("Chagrer une partie");
        setBounds(800, 300, 400, 150);
        contenant = new JPanel();
        contenant.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contenant);
        contenant.setLayout(new GridLayout(2, 1, 0, 0));

        panelInformation = new JPanel();

        panelInformation.setBorder(new TitledBorder(null, "Veuillez charger votre partie",
                TitledBorder.LEFT, TitledBorder.TOP, null, Color.decode("#ffffff")));

        panelInformation.setLayout(new GridLayout(1, 1, 0, 0));

        
        // Aller chercher tout les fichier finissant par .xml
        String[] items = lireFichiersRepertoire();
        
        
      
        choixChargerPartie = new JComboBox(items);

        panelInformation.add(choixChargerPartie);

        panelBouton = new JPanel();
        panelBouton.setBackground(Color.decode("#AD4F09"));

        panelBouton.setBorder(new TitledBorder(null, "",
                TitledBorder.LEFT, TitledBorder.TOP, null, Color.decode("#ffffff")));

        panelBouton.setLayout(new GridLayout(1, 1, 0, 0));

        boutonOrdinateur = new JButton("Ok");
        boutonOrdinateur.setBackground(Color.decode("#87E990"));
        boutonOrdinateur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {

                setVisible(false);

                nom = choixChargerPartie.getSelectedItem().toString();

                //PartieIA partieIA = null;

                try {
                    app.setPartie(Sauvegarde.XMLReader.lireFichierXML(nom));
                    InterfaceGraphique.TableObserver.update(app.getPartie().getTable().get(app.getPartie().getTable().size() - 1));
                } catch (IOException ex) {
                    Logger.getLogger(ChargerPartie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        panelBouton.add(boutonOrdinateur);

        boutonJoueur = new JButton("Annuler");
        boutonJoueur.setBackground(Color.decode("#87E990"));
        boutonJoueur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {
                setVisible(false);

            }
        });

        panelBouton.add(boutonJoueur);

        panelBouton.setBackground(Color.decode("#AD4F09"));
        panelInformation.setBackground(Color.decode("#AD4F09"));

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

    public JComboBox getLeNomDeTaComboBox() {
        return choixChargerPartie;
    }
    

}
