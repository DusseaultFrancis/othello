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
public class Pion {

    private Couleur couleur;

    public Pion(Couleur couleur) {
        this.couleur = couleur;
    }

    public void changerCouleur() {
        if(couleur.equals(Couleur.BLANC)){
            couleur = Couleur.NOIR;
        }else{
            couleur = Couleur.BLANC;
        }
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

}
