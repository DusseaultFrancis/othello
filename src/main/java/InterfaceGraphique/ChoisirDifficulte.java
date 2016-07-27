package interfaceGraphique;

import Domaine.Application;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ChoisirDifficulte extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contenant;
    private JPanel panelBouton;
    private JPanel panelInformation;
    private static JButton boutonDebutant;
    private JButton boutonAvance;
    private JLabel info;

    public ChoisirDifficulte() {

        setTitle("Choisir l'adversaire");
        setBounds(800, 300, 300, 125);
        contenant = new JPanel();
        contenant.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contenant);
        contenant.setLayout(new GridLayout(1, 1, 0, 0));

        panelBouton = new JPanel();

        panelBouton.setBorder(new TitledBorder(null, "Difficulté",
                TitledBorder.LEFT, TitledBorder.TOP, null, Color.decode("#000000")));

        panelBouton.setLayout(new GridLayout(1, 1, 0, 0));
        contenant.add(panelBouton);

        boutonDebutant = new JButton("Dédutant");
        boutonDebutant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {

                Application app = new Application();
                InterfaceGraphique.ApplicationVue jeu = new InterfaceGraphique.ApplicationVue(app);
                InterfaceGraphique.TableObserver observateur = new InterfaceGraphique.TableObserver(jeu);
                app.jouerContreIaDebutant(observateur);
                setVisible(false);
                jeu.setVisible(true);

            }
        });
        panelBouton.add(boutonDebutant);

        boutonAvance = new JButton("Avancé");
        boutonAvance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {

                Application app = new Application();
                InterfaceGraphique.ApplicationVue jeu = new InterfaceGraphique.ApplicationVue(app);
                InterfaceGraphique.TableObserver observateur = new InterfaceGraphique.TableObserver(jeu);
                app.jouerContreIaAvance(observateur);
                setVisible(false);
                jeu.setVisible(true);

            }
        });
        panelBouton.add(boutonAvance);

        setVisible(true);

    }

    public JButton getBtnAjouter() {

        return boutonDebutant;

    }

    public JButton getBtnAnnuler() {

        return boutonAvance;

    }

    public void actionPerformed(ActionEvent e) {

    }

}
