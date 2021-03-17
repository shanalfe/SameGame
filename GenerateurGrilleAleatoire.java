import java.util.Random;
import java.awt.*;
import javax.swing.*;

/**
 * Classe GenerateurGrilleAleatoire
 *  Génère une grille aléatoire et associe les déssins correspondants
 */
public class GenerateurGrilleAleatoire extends JPanel {

    /**Déclaration des variables*/
      protected char [][] tabTerm;
      private JPanel jeu;
      protected Bloc[][] tab;
    
    /**
     * Méthode TabAl
     *  Permet la génération de la grille aléatoire
     * @param panel
     * @see Menu
     */
    public void TabAl (JPanel panel) {

		 /** Déclaration des variables */
        int plouf, colonne = 0, ligne = 0;
        char tabTerm[][] = new char[10][15];
        tab = new Bloc[10][15];
        
        this.jeu = panel;

		Random random = new Random();

        /**Création du tableau */
        for (ligne = 0; ligne <10; ligne ++) {
            for (colonne = 0; colonne <15; colonne++) {
                
                plouf = random.nextInt(3);

                if (plouf == 0){
                    tabTerm[ligne][colonne] = 'R'; 	
                    
                    tab[ligne][colonne] = new Salameche();
					jeu.add(tab[ligne][colonne]);
                }
                else if (plouf == 1) {
                    tabTerm[ligne][colonne] = 'B';   
                    tab[ligne][colonne] = new Carapuce ();
					jeu.add(tab[ligne][colonne]);     
                }
                else if (plouf == 2){
                    tabTerm[ligne][colonne] = 'V';	
                    tab[ligne][colonne] = new Bulbi();
					jeu.add(tab[ligne][colonne]);		
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
     * Méthode getTab 
     * @return tab
     */
    public Bloc[][] getTab() {
		return tab;
	}
    /**
     * Méthode getTabTerm
     * @return tabTerm
     */

	
	public char [][] getTabTerm () {
		return tabTerm;
    }
   

}