/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import InterfaceGraphique.TableObserver;
import java.util.ArrayList;

/**
 *
 * @author Francis
 */
public class PartieIA implements Partie{

    private Joueur blanc;
    private JoueurArtificiel noir;
    private Couleur joueurCourant;
    private ArrayList<Table> listeTable;
    private int tour;
    private boolean fini;
    private TableObserver observateur;

    public PartieIA(Joueur blanc, JoueurArtificiel noir, TableObserver observateur) {
        this.listeTable = new ArrayList<Table>();
        this.listeTable.add(new Table());
        this.blanc = blanc;
        this.noir = noir;
        this.joueurCourant = Couleur.BLANC;
        this.fini = false;
        this.observateur = observateur;
        tour = 0;
        updateObserver(listeTable.get(tour));
    }
    
    @Override
    public void changerJoueurCourant() {
        if(joueurCourant.equals(Couleur.BLANC)){
            joueurCourant = Couleur.NOIR;
        }else{
            joueurCourant = Couleur.BLANC;
        }
    }
    
    @Override
    public void jouer(int ligne, int colonne) {
        
        
             // le joueur humain joue
                
                if(blanc.jouerPion(listeTable.get(tour), ligne, colonne)) {
                    listeTable.add(new Table(listeTable.get(tour)));
                    updateObserver(listeTable.get(tour));
                    tour++;
                    changerJoueurCourant();
                    
                    // le joueur Artificiel joue
                if(noir.algorithmeJeu(listeTable.get(tour))) {
                    listeTable.add(new Table(listeTable.get(tour)));
                    updateObserver(listeTable.get(tour));
                    tour++;
                }
                changerJoueurCourant();
                }
             
            
            if(listeTable.get(tour).getNbPionBlanc() + listeTable.get(tour).getNbPionNoir() == 64) {
                fini = true;
                return;
            }
            System.out.println("asdfs");
        
    }
    
    public void register(TableObserver observateur) {
        this.observateur = observateur;
    }
    
    public void updateObserver(Table table) {
        observateur.update(table);
    }
    

    public void Sauvegarder() {

    }

    public Couleur getJoueurCourant() {
        return joueurCourant;
    }

    public ArrayList<Table> getTable() {
        return listeTable;
    }

    public int getTour() {
        return tour;
    }


    public void setTour(int tour) {
        this.tour = tour;
    }

    public void setFini(boolean fini) {
        this.fini = fini;
    }

    @Override
    public void visualiser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estFini() {
        return fini;
    }

}
