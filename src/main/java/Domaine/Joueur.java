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
public class Joueur {

    private Couleur couleur;

    public Joueur(Couleur couleur) {
        this.couleur = couleur;
    }
    
    public void passerTour() {

    }

    public boolean jouerPion(Table table, int ligne, int colonne) {
        return table.ajouterPion(this.couleur, ligne, colonne);
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

}
