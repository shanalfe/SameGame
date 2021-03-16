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
    private char [][] tabTerm;
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
        this.tabTerm = new char[10][15];
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

                    this.tabTerm[ligne][colonne] = 'R';

                    this.tab[ligne][colonne] = new Salameche();
					panneau.add(tab[ligne][colonne]);
                   
                }
                else if (plouf == 1) {

                    this.tabTerm[ligne][colonne] = 'B';
                    this.tab[ligne][colonne] = new Carapuce ();
					panneau.add(tab[ligne][colonne]);

                }
                else if (plouf == 2){

                    this.tabTerm[ligne][colonne] = 'V';
                    this.tab[ligne][colonne] = new Bulbi();
					panneau.add(tab[ligne][colonne]);

                }
               
            }            
        }

        /**Affichage terminal */
        for (char[] tab: tabTerm) {
            for (char s: tab) {
                System.out.print(s + "\t");
            }
            System.out.println("\n");
        }


    }

    /**
     * @return tab : tableau avec les images
     */

    public Bloc[][] recupTab() {
		return this.tab;
	}

    /**
     * @return tabTerm : tableau du terminal avec les références : RBV
     */
    
	public char[][] recupTabTerm() {
		return this.tabTerm;
	}
	


}