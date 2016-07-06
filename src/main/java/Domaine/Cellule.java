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
public class Cellule {

    private int ligne;
    private int colonne;
    private boolean occupe;
    private Pion pion;

    public boolean estOccupe() {
        boolean estOccupe = false;

        return estOccupe;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public boolean isOccupe() {
        return occupe;
    }

    public Pion getPion() {
        return pion;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }

    public void setPion(Pion pion) {
        this.pion = pion;
    }

}
