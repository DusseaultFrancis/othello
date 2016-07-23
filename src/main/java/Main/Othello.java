/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Domaine.Application;
import Domaine.Partie;
import InterfaceGraphique.ApplicationVue;

/**
 *
 * @author Francis
 */
public class Othello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Partie partie = null;
        ApplicationVue jeu = new ApplicationVue();
        jeu.setVisible(true);
        Application app = new Application();
        app.jouerContreIa();
    }

}
