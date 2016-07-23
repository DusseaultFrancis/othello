/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import InterfaceGraphique.ApplicationVue;
import InterfaceGraphique.TableObserver;

/**
 *
 * @author Francis
 */
public class Application {

    private Joueur joueur;
    private Partie partie;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Application app = new Application();
        ApplicationVue jeu = new ApplicationVue(app);
        TableObserver observateur = new TableObserver(jeu);
        app.jouerContreIa(observateur);
       
        jeu.setVisible(true);
        
    }
    
    

    public Partie jouerContreIa(TableObserver observateur) {
        joueur = new Joueur(Couleur.BLANC);
        partie = new PartieIA(joueur, new IADebutant(), observateur);
        
        return partie;
    }

    public PartieHumain jouerContreHumain() {

        PartieHumain partieHumain = null;

        return partieHumain;
    }

    public PartieIA changerPartie() {

        PartieIA partieIA = null;

        return partieIA;
    }

    public void visualiserPartie(Partie partie) {

    }

    public void quitter() {

    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

}
