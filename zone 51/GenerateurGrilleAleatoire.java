import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class GenerateurGrilleAleatoire extends JPanel {

	private JPanel jeu;
	private char[][] tabTerm = new char[10][15];
    private Bloc[][] tab = new Bloc [10][15];

	
	public GenerateurGrilleAleatoire (JPanel j){

		this.jeu = j;

		 /** Déclaration des variables */
        int plouf, colonne = 0, ligne = 0;

		Random random = new Random();

        /**Création du tableau */
        for (ligne = 0; ligne <10; ligne ++) {
            for (colonne = 0; colonne <15; colonne++) {
                
                plouf = random.nextInt(3);

                if (plouf == 0){

                    tabTerm[ligne][colonne] = 'R';

                    
					jeu.add(tab[ligne][colonne]);
                   
                }
                else if (plouf == 1) {

                    tabTerm[ligne][colonne] = 'B';
                   
					jeu.add(tab[ligne][colonne]);

                }
                else if (plouf == 2){

                    tabTerm[ligne][colonne] = 'V';
                   
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

    public Bloc[][] getTab() {
		return this.tab;
	}

	public char[][] getTabt() {
		return this.tabTerm;
	}
	

}