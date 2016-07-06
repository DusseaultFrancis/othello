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
public interface JoueurArtificiel {

    public Cellule algorithmeJeu();

    public void jouerPion(Couleur couleur, int ligne, int colonne);

    public void passeTour();

}
