/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Francis
 */
public class IAAvance implements JoueurArtificiel{

    private Couleur couleur;
    private ArrayList<Cellule> listeCellule;
    
    public  IAAvance() {
        listeCellule = new ArrayList<Cellule>();
        couleur = Couleur.NOIR;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    @Override
    public boolean algorithmeJeu(Table table) {
        int nbPion = 0;
        for(int i = 0; i < table.getListeCellule().length; i++) {
            for(int j = 0; j < table.getListeCellule().length; j++) {
                if(table.peutJouer(couleur, i, j) != -1 && table.peutJouer(couleur, i, j) == nbPion) {
                    listeCellule.add(new Cellule(i,j));
                }else{
                    listeCellule.clear();
                    listeCellule.add(new Cellule(i,j));
                    nbPion = table.peutJouer(couleur, i, j);
                }
            }
        }
        if(listeCellule.isEmpty()) {
            return false;
        }else{
            Random nbr = new Random();
            int index = nbr.nextInt(listeCellule.size());
            table.ajouterPion(couleur, listeCellule.get(index).getLigne(), listeCellule.get(index).getColonne());
            return true;
        }
    }

}
