/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGraphique;

import Domaine.Couleur;
import Domaine.Table;

/**
 *
 * @author Francis
 */
public class TableObserver {
    ApplicationVue vue;
    
    public TableObserver(ApplicationVue vue) {
        this.vue = vue;
    }
    
    public void update(Table table) {
        for(int i = 0; i < table.getListeCellule().length; i++) {
            for(int j = 0; j < table.getListeCellule()[i].length; j++) {
                if(table.getListeCellule()[i][j].estOccupe()){
                    if(table.getListeCellule()[i][j].getPion().getCouleur().equals(Couleur.BLANC)) {
                        vue.setCouleurCellule(i, j, Couleur.BLANC);
                    }else {
                        vue.setCouleurCellule(i, j, Couleur.NOIR);
                    }
                }
            }
        }
    }
}
