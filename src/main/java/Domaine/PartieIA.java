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
public class PartieIA {

    private Joueur blanc;
    private Joueur noir;
    private Joueur joueurCourant;
    private Table table[];
    private int tour;
    private boolean fini;

    public PartieIA(Joueur blanc, JoueurArtificiel noir) {

    }

    public void Sauvegarder() {

    }

    public Joueur getBlanc() {
        return blanc;
    }

    public Joueur getNoir() {
        return noir;
    }

    public Joueur getJoueurCourant() {
        return joueurCourant;
    }

    public Table[] getTable() {
        return table;
    }

    public int getTour() {
        return tour;
    }

    public boolean isFini() {
        return fini;
    }

    public void setBlanc(Joueur blanc) {
        this.blanc = blanc;
    }

    public void setNoir(Joueur noir) {
        this.noir = noir;
    }

    public void setJoueurCourant(Joueur joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    public void setTable(Table[] table) {
        this.table = table;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public void setFini(boolean fini) {
        this.fini = fini;
    }

}
