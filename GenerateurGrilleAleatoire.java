import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Classe GenerateurGrilleAleatoire
 *  Génère une grille aléatoire et associe les déssins correspondants
 */
public class GenerateurGrilleAleatoire extends JPanel {

    /**Déclaration des variables*/
      protected char [][] tabTerm;
      private JPanel jeu;
      protected Bloc[][] tab;
      protected char [][] bool;
      protected int grp =0;
    
    /**
     * Méthode TabAl
     *  Permet la génération de la grille aléatoire
     * @param panel
     * @see Menu
     */
    public void TabAl (JPanel panel) {

		 // Déclaration des variables
        int plouf, j = 0, i = 0;
        char tabTerm[][] = new char[10][15];
        tab = new Bloc[10][15];
        char bool [][] = new char [10][15];
        
        this.jeu = panel;
   

		Random random = new Random();

        //Création du tableau 
        for (i = 0; i <10; i ++) {
            for (j = 0; j <15; j++) {
                
                plouf = random.nextInt(3);

                if (plouf == 0){
                    tabTerm[i][j] = 'R'; 	
                    
                    tab[i][j] = new Salameche();
					jeu.add(tab[i][j]);
                }
                else if (plouf == 1) {
                    tabTerm[i][j] = 'B';   
                    tab[i][j] = new Carapuce ();
					jeu.add(tab[i][j]);     
                }
                else if (plouf == 2){
                    tabTerm[i][j] = 'V';	
                    tab[i][j] = new Bulbi();
					jeu.add(tab[i][j]);		
                }
               
            }            
        }

        //Affichage terminal 
        for (char[] tab: tabTerm) {
            for (char s: tab) {
                System.out.print(s + " ");
            }
            System.out.println("\n");
        }
        
        jeu.addMouseListener(new ControllerJeu (tab, tabTerm, bool, grp));
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

    public char [][] getBool (){
        return bool;
    }

    public int getGrp (){
      return grp;
    }

   



}