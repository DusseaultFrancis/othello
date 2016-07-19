package InterfaceGraphique;

import Domaine.Partie;
import java.awt.Color;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ApplicationVue extends JFrame implements ActionListener {

    private JButton[][] cellules = new JButton[8][8];
    private JPanel table;
    
    public ApplicationVue() {
        
        setTitle("Othello");
        setBounds(450, 200, 1000, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        table = new JPanel(new GridLayout(0, 9));
        table.setBorder(new LineBorder(Color.BLACK));
        add( table );
        for(int i = 0; i < cellules.length; i++) {
            for(int j = 0; j < cellules[i].length; j++) {
                JButton b = new JButton();
                
                if((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(new Color(0, 150, 0));
                } else {
                    b.setBackground(new Color(0,100,0));
                }
                cellules[j][i] = b;
            }
        }
        
        for(int i = 0; i < 8; i++) {
            table.add(new JLabel(""));
        }
        
        for(int i = 0; i < cellules.length; i++) {
            for(int j = 0; j < cellules.length; j++) {
                if(j == 0){
                    table.add(new JLabel(""));
                }
                table.add(cellules[j][i]);
            }
        }
        
    }

    public void actionPerformed(ActionEvent e) {

    }
    
    

}
