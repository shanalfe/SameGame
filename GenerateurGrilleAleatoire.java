import java.util.Random;
import java.awt.*;
import javax.swing.*;


public class GenerateurGrilleAleatoire extends JPanel {

    

    public void TabAl (){

		 /** Déclaration des variables */
        int plouf, colonne = 0, ligne = 0;
        char tabTerm[][] = new char[10][15] ;

		Random random = new Random();

        /**Création du tableau */
        for (ligne = 0; ligne <10; ligne ++) {
            for (colonne = 0; colonne <15; colonne++) {
                
                plouf = random.nextInt(3);

                if (plouf == 0){
                    tabTerm[ligne][colonne] = 'R'; 			
                   
                }
                else if (plouf == 1) {
                    tabTerm[ligne][colonne] = 'B';                 
			

                }
                else if (plouf == 2){
                    tabTerm[ligne][colonne] = 'V';
                   
				

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

   

}