import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;


/**
 * Classe Plateau qui créé le plateau de jeu 
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 * 
 * Respectivement :
 * 1 = rouge
 * 2 = bleu
 * 3 = vert
 */

public class Plateau extends JFrame {

    /** Déclaration des variables*/
    private int [][] tabTerm;
    private Bloc [][] tab;

    public Plateau () {
        super ("SameGame");
    }
    

    /**
     * Méthode IniGrilleAl qui permet la création de la grille aléatoire
     *
     */

    public void IniGrilleAl (){

        System.out.println("Création d'une grille aléatoire" + "\n");
         /**Fenetre */
         this.setSize (800,600);
         this.setLocation (200,200);
        
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setResizable(false);
         this.setVisible(true);
         
        /** Déclaration des variables */
        int plouf, colonne = 0, ligne = 0;
        this.tabTerm = new int[10][15];
        this.tab = new Bloc [10][15];
     
        JPanel panneau = new JPanel();
        panneau.setLayout (new GridLayout (10,15));
        panneau.setBackground(Color.BLUE);
        
        this.add(panneau);
        

        Random random = new Random();

        /**Création du tableau */
        for (ligne = 0; ligne <10; ligne ++) {
            for (colonne = 0; colonne <15; colonne++) {
                
                plouf = random.nextInt(3);

                if (plouf == 0){

                    this.tabTerm[ligne][colonne] = 1;

                    this.tab[ligne][colonne] = new Salameche();
					panneau.add(tab[ligne][colonne]);
                   
                }
                else if (plouf == 1) {

                    this.tabTerm[ligne][colonne] = 2;
                    this.tab[ligne][colonne] = new Carapuce ();
					panneau.add(tab[ligne][colonne]);

                }
                else if (plouf == 2){

                    this.tabTerm[ligne][colonne] = 3;
                    this.tab[ligne][colonne] = new Bulbi();
					panneau.add(tab[ligne][colonne]);

                }
               
            }            
        }

        /**Affichage terminal */
        for (int[] tab: tabTerm) {
            for (int s: tab) {
                System.out.print(s + "\t");
            }
            System.out.println("\n");
        }


    }

    public Bloc[][] getTab() {
		return this.tab;
	}

	public int[][] getTabt() {
		return this.tabTerm;
	}
	



}