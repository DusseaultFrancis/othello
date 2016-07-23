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
public interface Partie {

    public void changerJoueurCourant();

    public void jouer(int linge, int colonne);

    public void visualiser();

    public boolean estFini();

}
