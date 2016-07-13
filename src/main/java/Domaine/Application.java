/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

/**
 *
 * @author Francis
 */
public class Application {

    private Joueur joueur;
    private Partie partie;

    public Partie jouerContreIa() {
        joueur = new Joueur(Couleur.BLANC);
        partie = new PartieIA(joueur, new IADebutant());
        partie.jouer();

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
