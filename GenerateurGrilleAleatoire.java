import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * La classe </code>GenerateurGrilleAleatoire</code> génère une grille aléatoire et associe les dessins correspondants
 */
public class GenerateurGrilleAleatoire extends JPanel {

  /**
  * Tableau qui représente la valeur d'une case d'un tableau
  */
  protected char [][] tabTerm;
  /**
  * Appel du JPanel du jeu
  */
  private JPanel jeu;
  private JFrame fenetre;
  /**
  * Tableau qui affiche les blocs
  */
  protected Bloc[][] tab;
  /**
  * Tableau qui représente le statut d'une case
  */
  protected char [][] bool;
  /**
  * Taille d'un groupe
  */
  protected double grp = 0;
  /**
  * JLabel du score
  */
  public JLabel score;


  /**
  * Appel le JLabel score
  */
  public GenerateurGrilleAleatoire (JLabel score) {

    this.score = score;

  }
 

    /**
     * Permet la génération de la grille aléatoire
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

      jeu.addMouseListener(new ControllerJeu (tab, tabTerm, bool, grp, score));

    }



    /**
     * Renvoie la tab contenant les images correspondant à tabTerm
     * @return tab
     */
    public Bloc[][] getTab() {
      return tab;
    }

    /**
     * Renvoie la tab RVB du terminal
     * @return tabTerm
     */	
    public char [][] getTabTerm () {
      return tabTerm;
    }

    /**
    * Renvoie la tab bool utilisé dans ControlleurJeu pour le status des cases
    * @return bool
    */
    public char [][] getBool (){
      return bool;
    }

    /**
    * Renvoie la taille d'un groupe utilisé dans ControlleurJeu
    * @return grp
    */
    public double getGrp (){
      return grp;
    }

  }