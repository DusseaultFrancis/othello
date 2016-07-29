/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import InterfaceGraphique.TableObserver;
import java.io.IOException;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.StringTokenizer;
=======
import java.util.Iterator;
>>>>>>> origin/master
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francis
 */
public class PartieIA implements Partie {

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
        tour = 0;
        updateObserver(listeTable.get(tour));
    }

    @Override
    public void changerJoueurCourant() {
        if (joueurCourant.equals(Couleur.BLANC)) {
            joueurCourant = Couleur.NOIR;
        } else {
            joueurCourant = Couleur.BLANC;
        }
    }

    @Override
    public void jouer(int ligne, int colonne) {
<<<<<<< HEAD
        boolean peutJouer = false;
        if(fini){
            return;
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(listeTable.get(tour).peutJouer(Couleur.BLANC, i, j) != -1){
                    peutJouer = true;
                    break;
                }
            }
            if(peutJouer){
                break;
            }
            if(i == 7){
                noir.algorithmeJeu(listeTable.get(tour));
                listeTable.add(new Table(listeTable.get(tour)));
                updateObserver(listeTable.get(tour));
                tour++;
                changerJoueurCourant();
            }
        }
        
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
            System.out.println(listeTable.get(tour).getNbPionBlanc() + listeTable.get(tour).getNbPionNoir());
        
=======

        // le joueur humain joue
        if (blanc.jouerPion(listeTable.get(tour), ligne, colonne)) {
            listeTable.add(new Table(listeTable.get(tour)));
            updateObserver(listeTable.get(tour));
            tour++;
            changerJoueurCourant();

            // le joueur Artificiel joue
            if (noir.algorithmeJeu(listeTable.get(tour))) {
                listeTable.add(new Table(listeTable.get(tour)));
                updateObserver(listeTable.get(tour));
                tour++;
            }
            changerJoueurCourant();
        }

        if (listeTable.get(tour).getNbPionBlanc() + listeTable.get(tour).getNbPionNoir() == 64) {
            fini = true;
            return;
        }
        System.out.println("asdfs");

>>>>>>> origin/master
    }

    public void register(TableObserver observateur) {
        this.observateur=observateur;
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
<<<<<<< HEAD
    public void visualiser(int tour) {
        if(fini){
            updateObserver(listeTable.get(tour));
=======
    public void visualiser() {

        Iterator<Table> it = listeTable.iterator();

        while (it.hasNext()) {
            Table table = it.next();
            InterfaceGraphique.TableObserver.update(table);

            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("Error reading from user");
            }
>>>>>>> origin/master
        }
    }

    @Override
    public boolean estFini() {
        return fini;
    }

}
