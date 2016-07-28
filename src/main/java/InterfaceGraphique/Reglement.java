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
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Reglement extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contenant;
    private JPanel panelReglement;
    private JPanel panelInformation;
    private JTextPane info;

    private JOptionPane joueurInvalide;

    public Reglement() {

        setTitle("Règlements");
        setBounds(800, 300, 1200, 600);
        contenant = new JPanel();
        contenant.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contenant);
        contenant.setLayout(new GridLayout(1, 1, 0, 0));

        panelReglement = new JPanel();
        panelReglement.setBackground(Color.decode("#AD4F09"));

        panelReglement.setBorder(new TitledBorder(null, "Règlements",
                TitledBorder.LEFT, TitledBorder.TOP, null, Color.decode("#ffffff")));

        panelReglement.setLayout(new GridLayout(1, 1, 0, 0));

        info = new JTextPane();

        info.setText("Le but du jeu est d'otebnir un maximum de pion lorsque la partie est terminée."
                + "\n"
                + "\n"
                + "Le but du jeu est d'otebnir un maximum de pion lorsque la partie est terminée."
                + "\n"
                + "\n"
                + "Le but du jeu est d'otebnir un maximum de pion lorsque la partie est terminée."
                + "\n"
                + "\n"
                + "Le but du jeu est d'otebnir un maximum de pion lorsque la partie est terminée."
                + "\n"
                + "\n"
                + "Le but du jeu est d'otebnir un maximum de pion lorsque la partie est terminée."
                + "\n"
                + "\n"
                + "Le but du jeu est d'otebnir un maximum de pion lorsque la partie est terminée."
                + "\n"
                + "\n"
                + "Le but du jeu est d'otebnir un maximum de pion lorsque la partie est terminée."
                + "\n"
                + "\n"
        );

        panelReglement.add(info);

        contenant.add(panelReglement);

        setVisible(true);

    }

}
