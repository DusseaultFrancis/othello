/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import InterfaceGraphique.TableObserver;

/**
 *
 * @author Francis
 */
public class Table {

    Cellule listeCellule[][];
    private int nbPionBlanc = 0;
    private int nbPionNoir = 0;
    TableObserver observateur;

    public Table() {
    }

    public Table(Table table) {
    }

    public boolean peutJouer(Couleur couleur, int ligne, int colonne) {
        boolean peutJouer = false;

        return peutJouer;
    }

    public void ajouterPion(Couleur couleur, int ligne, int colonne) {
    }

    public void modifierCouleurPions() {
    }

    public Cellule[][] getListeCellule() {
        return listeCellule;
    }

    public int getNbPionBlanc() {
        return nbPionBlanc;
    }

    public int getNbPionNoir() {
        return nbPionNoir;
    }

    public TableObserver getObservateur() {
        return observateur;
    }

    public void setListeCellule(Cellule[][] listeCellule) {
        this.listeCellule = listeCellule;
    }

    public void setNbPionBlanc(int nbPionBlanc) {
        this.nbPionBlanc = nbPionBlanc;
    }

    public void setNbPionNoir(int nbPionNoir) {
        this.nbPionNoir = nbPionNoir;
    }

    public void setObservateur(TableObserver observateur) {
        this.observateur = observateur;
    }

}
