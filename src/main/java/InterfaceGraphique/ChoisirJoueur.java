package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class ChoisirJoueur extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contenant;
    private JPanel panelBouton;
    private JPanel panelInformation;
    private static JButton boutonOrdinateur;
    private JButton boutonJoueur;
    private JLabel info;

    private JOptionPane joueurInvalide;

    public ChoisirJoueur() {

        setTitle("Choisir l'adversaire");
        setBounds(800, 300, 300, 125);
        contenant = new JPanel();
        contenant.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contenant);
        contenant.setLayout(new GridLayout(1, 1, 0, 0));

        panelBouton = new JPanel();
        panelBouton.setBackground(Color.decode("#AD4F09"));

        panelBouton.setBorder(new TitledBorder(null, "Veuillez choisir votre adversaire",
                TitledBorder.LEFT, TitledBorder.TOP, null, Color.decode("#ffffff")));

        panelBouton.setLayout(new GridLayout(1, 1, 0, 0));
        contenant.add(panelBouton);

        boutonOrdinateur = new JButton("Ordinateur");
        boutonOrdinateur.setBackground(Color.decode("#87E990"));
        boutonOrdinateur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {

                setVisible(false);
                ChoisirDifficulte choixDifficulte = new ChoisirDifficulte();
                
            }
        });
        panelBouton.add(boutonOrdinateur);

        boutonJoueur = new JButton("Joueur");
        boutonJoueur.setBackground(Color.decode("#87E990"));
        boutonJoueur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {

                joueurInvalide = new JOptionPane();
                joueurInvalide.showMessageDialog(null, "Vous devez acheter le jeu pour pouvoir jouer contre un autre joueur.", "Attention", JOptionPane.WARNING_MESSAGE);
            }
        });
        panelBouton.add(boutonJoueur);

        setVisible(true);

    }

    public JButton getBtnAjouter() {

        return boutonOrdinateur;

    }

    public JButton getBtnAnnuler() {

        return boutonJoueur;

    }

}
