import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;


/**
 * Classe Plateau qui créé et gère le plateau de jeu
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 */

public class Plateau extends JFrame {

    
	private Couleur[][] tab;
	private int[][] tabObjet;


    public void InitialiserPlateau () {

        /** Déclaration des variables */
        int ligne = 0, colonne = 0, plouf;
        
        JPanel panneau = new JPanel();
        this.add (panneau);
        this.tab = new Couleur[10][15];
		this.tabObjet = new int [10][15];

		Random aleatoire = new Random();
		

        /** Création du tableau de 10 lignes et 15 colonnes */
        panneau.setLayout(new GridLayout(10,15,0,0));
       
        /**
         * @params ligne : variable représentant la ligne
         * @param colonne : variable représentant la colonne
         */
        
        for (ligne = 0; ligne < 10; ligne ++){
            for (colonne = 0; colonne <15; colonne ++){
                
                
                /** Gestion de l'aléatoire */

                plouf = aleatoire.nextInt(3);

                if (plouf == 0){
                    this.tab [i][j] = new Salameche ();
                    panneau.add (tab[i][j]);
                    this.tabObjet [i][j] = 1;
                }

                if (plouf == 1){
                    this.tab [i][j] = new Carapuce ();
                    panneau.add (tab[i][j]);
                    this.tabObjet [i][j] = 2;
                }

                if (plouf == 2){
                    this.tab [i][j] = new Bulbi ();
                    panneau.add (tab[i][j]);
                    this.tabObjet [i][j] = 3;
                }
                
            }
        }
    }

    
	public Couleur[][] getTab() {
		return this.tab;
	}
	
	public int[][] getTabi() {
		return this.tabObject;
	}

}