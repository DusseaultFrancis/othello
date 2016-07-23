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
public class Table {

    private Cellule listeCellule[][];
    private int nbPionBlanc = 0;
    private int nbPionNoir = 0;
    

    public Table() {
        listeCellule = new Cellule[8][8];
        for(int i = 0; i < listeCellule.length; i++) {
            for(int j = 0; j < listeCellule.length; j++) {
                listeCellule[i][j] = new Cellule(i,j);
            }
        }
        //4 premiers pions
        init(Couleur.BLANC, 3, 3);
        init(Couleur.NOIR, 3, 4);
        init(Couleur.BLANC, 4, 4);
        init(Couleur.NOIR, 4, 3);
        nbPionBlanc = 2;
        nbPionNoir = 2;
    }

    public Table(Table table) {
        this.listeCellule = new Cellule[8][8];
        for(int i = 0; i < listeCellule.length; i++) {
            for(int j = 0; j < listeCellule.length; j++) {
                this.listeCellule[i][j] = table.listeCellule[i][j];
            }
        }
    }

    private void init(Couleur couleur, int ligne, int colonne) {
        listeCellule[ligne][colonne].setPion(new Pion(couleur));
        listeCellule[ligne][colonne].setOccupe(true);
    }
    
    public int peutJouer(Couleur couleur, int ligne, int colonne) {
        int nbPion = 0;
	int temp;
	if((ligne >= 0 && ligne < 8) && (colonne >= 0 && colonne < 8)){
            if(listeCellule[ligne][colonne].estOccupe()){
		return -1;
            }
            if(ligne - 1 >= 0){ //haut
		if(listeCellule[ligne-1][colonne].estOccupe() && !listeCellule[ligne-1][colonne].getPion().getCouleur().equals(couleur)){
                    temp = validerHaut(couleur,ligne,colonne);
                    if(temp != -1){ nbPion+=temp; }
		}
            }
            if(colonne + 1 < 8){ //droite
		if(listeCellule[ligne][colonne + 1].estOccupe() && !listeCellule[ligne][colonne+1].getPion().getCouleur().equals(couleur)){
                    temp = validerDroite(couleur,ligne,colonne);
                    if(temp != -1){ nbPion+=temp; }
                }
            }
            if(ligne + 1 < 8){ //bas
		if(listeCellule[ligne+1][colonne].estOccupe() && !listeCellule[ligne+1][colonne].getPion().getCouleur().equals(couleur)){
                    temp = validerBas(couleur,ligne,colonne);
                    if(temp != -1){ nbPion+=temp; }
		}
            }
            if(colonne - 1 >= 0){ //gauche
		if(listeCellule[ligne][colonne - 1].estOccupe() && !listeCellule[ligne][colonne-1].getPion().getCouleur().equals(couleur)){
                    temp = validerGauche(couleur,ligne,colonne);
                    if(temp != -1){ nbPion+=temp; }
		}
            }
            if(ligne != 0 && colonne != 7){ //diag haut droite
		if(listeCellule[ligne-1][colonne+1].estOccupe() && !listeCellule[ligne-1][colonne+1].getPion().getCouleur().equals(couleur)){
                    temp = validerDiagHD(couleur,ligne,colonne);
                    if(temp != -1){ nbPion+=temp; }
		}
            }
            if(ligne != 7 && colonne != 7){ //diag bas droite
		if(listeCellule[ligne+1][colonne+1].estOccupe() && !listeCellule[ligne+1][colonne+1].getPion().getCouleur().equals(couleur)){
                    temp = validerDiagBD(couleur,ligne,colonne);
                    if(temp != -1){ nbPion+=temp; }
		}
            }
            if(ligne != 7 && colonne != 0){ //diag bas gauche
		if(listeCellule[ligne+1][colonne-1].estOccupe() && !listeCellule[ligne+1][colonne-1].getPion().getCouleur().equals(couleur)){
                    temp = validerDiagBG(couleur,ligne,colonne);
                    if(temp != -1){ nbPion+=temp; }
		}
            }
            if(ligne != 0 && colonne != 0){ //diag haut gauche
		if(listeCellule[ligne-1][colonne-1].estOccupe() && !listeCellule[ligne-1][colonne-1].getPion().getCouleur().equals(couleur)){
                    temp = validerDiagHG(couleur,ligne,colonne);
                    if(temp != -1){ nbPion+=temp; }
		}
            }
	}
        if(nbPion == 0){
            return -1;
        }
	return nbPion;
    }

    public boolean ajouterPion(Couleur couleur, int ligne, int colonne) {
        if(peutJouer(couleur, ligne, colonne) != -1) {
            listeCellule[ligne][colonne].setPion(new Pion(couleur));
            listeCellule[ligne][colonne].setOccupe(true);
            modifierCouleurPions(couleur, ligne, colonne);
            compteNbPions();
            return true;
        }
        return false;
    }

    public void modifierCouleurPions(Couleur couleur, int ligne, int colonne) {
        if(validerHaut(couleur, ligne, colonne) > 1){
            for (int i = 1; i < 8; i++) {
		if(listeCellule[ligne - i][colonne].getPion().getCouleur().equals(couleur)){
                    break;
		}
		listeCellule[ligne -i][colonne].getPion().changerCouleur();
            }
	}
        if(validerDroite(couleur, ligne, colonne) > 1){
            for (int i = 1; i < 8; i++) {
		if(listeCellule[ligne][colonne+i].getPion().getCouleur().equals(couleur)){
                    break;
		}
		listeCellule[ligne][colonne+i].getPion().changerCouleur();
            }
	}
        if(validerBas(couleur,ligne,colonne) > 1){
            for (int i = 1; i < 8; i++) {
		if(listeCellule[ligne+i][colonne].getPion().getCouleur().equals(couleur)){
                    break;
		}
		listeCellule[ligne+i][colonne].getPion().changerCouleur();
            }
	}
        if(validerGauche(couleur,ligne,colonne) > 1){
            for (int i = 1; i < 8; i++) {
		if(listeCellule[ligne][colonne-i].getPion().getCouleur().equals(couleur)){
                    break;
		}
		listeCellule[ligne][colonne-i].getPion().changerCouleur();
            }
        }
        if(validerDiagHD(couleur,ligne,colonne) > 1){
            for (int i = 1; i < 8; i++) {
		if(listeCellule[ligne-i][colonne+i].getPion().getCouleur().equals(couleur)){
                    break;
		}
		listeCellule[ligne-i][colonne+i].getPion().changerCouleur();
            }
	}
        if(validerDiagBD(couleur,ligne,colonne) > 1){
            for (int i = 1; i < 8; i++) {
		if(listeCellule[ligne+i][colonne+i].getPion().getCouleur().equals(couleur)){
                    break;
		}
		listeCellule[ligne+i][colonne+i].getPion().changerCouleur();
            }
	}
        if(validerDiagBG(couleur,ligne,colonne) > 1){
            for (int i = 1; i < 8; i++) {
		if(listeCellule[ligne+i][colonne-i].getPion().getCouleur().equals(couleur)){
                    break;
		}
		listeCellule[ligne+i][colonne-i].getPion().changerCouleur();
            }
	}
        if(validerDiagHG(couleur,ligne,colonne) > 1){
            for (int i = 1; i < 8; i++) {
		if(listeCellule[ligne-i][colonne-i].getPion().getCouleur().equals(couleur)){
                    break;
		}
		listeCellule[ligne-i][colonne-i].getPion().changerCouleur();
            }		
	}
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

  

    public void compteNbPions() {
        nbPionBlanc = 0;
        nbPionNoir = 0;
        for(int i = 0; i < listeCellule.length; i++) {
            for(int j = 0; j < listeCellule.length; j++) {
                if(listeCellule[i][j].estOccupe()) {
                    if(listeCellule[i][j].getPion().getCouleur().equals(Couleur.BLANC)) {
                        nbPionBlanc += 1;
                    }else{
                        nbPionNoir += 1;
                    }
                }
            }
        }
    }

    private int validerHaut(Couleur couleur, int ligne, int colonne){
	for (int i = 1; i < listeCellule.length; i++) {
            if(ligne-i < 0){
            break;
            }
            if(!listeCellule[ligne-i][colonne].estOccupe()){
                return -1;
            }else if(listeCellule[ligne-i][colonne].getPion().getCouleur().equals(couleur)){
                return i;
            }
	}
	return -1;
    }
	
    private int validerDroite(Couleur couleur, int ligne, int colonne) {
        for (int i = 1; i < listeCellule.length; i++) {
            if (colonne + i >= 8) {
                break;
            }
            if (!listeCellule[ligne][colonne + i].estOccupe()) {
                return -1;
            } else if (listeCellule[ligne][colonne + i].getPion().getCouleur().equals(couleur)) {
                return i;
            }
        }
        return -1;
    }
	
	   private int validerBas(Couleur couleur, int ligne, int colonne) {
        for (int i = 1; i < listeCellule.length; i++) {
            if (ligne + i >= 8) {
                break;
            }
            if (!listeCellule[ligne + i][colonne].estOccupe()) {
                return -1;
            } else if (listeCellule[ligne + i][colonne].getPion().getCouleur().equals(couleur)) {
                return i;
            }
        }
        return -1;
    }

    private int validerGauche(Couleur couleur, int ligne, int colonne) {
        for (int i = 1; i < listeCellule.length; i++) {
            if (colonne - i < 0) {
                break;
            }
            if (!listeCellule[ligne][colonne - i].estOccupe()) {
                return -1;
            } else if (listeCellule[ligne][colonne - i].getPion().getCouleur().equals(couleur)) {
                return i;
            }
        }
        return -1;
    }

    private int validerDiagHD(Couleur couleur, int ligne, int colonne) {
        for (int i = 1; i < listeCellule.length; i++) {
            if (ligne - i < 0 || colonne + i >= 8) {
                break;
            }
            if (!listeCellule[ligne - i][colonne + i].estOccupe()) {
                return -1;
            } else if (listeCellule[ligne - i][colonne + i].getPion().getCouleur().equals(couleur)) {
                return i;
            }
        }
        return -1;
    }

    private int validerDiagBD(Couleur couleur, int ligne, int colonne) {
        for (int i = 1; i < listeCellule.length; i++) {
            if (ligne + i >= 8 || colonne + i >= 8) {
                break;
            }
            if (!listeCellule[ligne + i][colonne + i].estOccupe()) {
                return -1;
            } else if (listeCellule[ligne + i][colonne + i].getPion().getCouleur().equals(couleur)) {
                return i;
            }
        }
        return -1;
    }

    private int validerDiagBG(Couleur couleur, int ligne, int colonne) {
        for (int i = 1; i < listeCellule.length; i++) {
            if (ligne + i >= 8 || colonne - i < 0) {
                break;
            }
            if (!listeCellule[ligne + i][colonne - i].estOccupe()) {
                return -1;
            } else if (listeCellule[ligne + i][colonne - i].getPion().getCouleur().equals(couleur)) {
                return i;
            }
        }
        return -1;
    }

    private int validerDiagHG(Couleur couleur, int ligne, int colonne) {
        for (int i = 1; i < listeCellule.length; i++) {
            if (ligne - i < 0 || colonne - i < 0) {
                break;
            }
            if (!listeCellule[ligne - i][colonne - i].estOccupe()) {
                return -1;
            } else if (listeCellule[ligne - i][colonne - i].getPion().getCouleur().equals(couleur)) {
                return i;
            }
        }
        return -1;
    }

}
