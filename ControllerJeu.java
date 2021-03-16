import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ControllerJeu implements MouseListener {
    
    /**Récupération*/
    private Plateau windows;
    private char [][] tabTerm;
    private Bloc [][] tab;
    private int grp = 0; 
    /**Stocke le groupe */
    private char [][] storage;

    /**Déclaration des variables */
    int ligne = 0, colonne = 0;


    public ControllerJeu (Plateau w) {
        this.windows = w;  
       
        this.tab = w.recupTab();
        this.tabTerm = w.recupTabTerm();

        for (ligne=0; ligne<10; ligne++) {
            for (colonne=0; colonne<15;colonne++) {
                this.tab[ligne][colonne].addMouseListener(this);
                this.tab[ligne][colonne].setBackground(Color.WHITE);
                
            }
        }
    }



    /**
     * Méthode Radar qui permet de détecter/trouver un groupe
     * à partir d'un bloc en utilisant la récurrence
     */

     public void Radar (int i, int j){

        /**Recherche à gauche */
        if (i >0){
            if ( (this.tabTerm[i][j] == this.tabTerm[i-1][j]) && this.tabTerm[i][j] != 'X' ){
                this.storage [i-1][j] = this.tabTerm [i-1][j];
                this.grp ++;
                Radar (i-1,j);
            }
        }

        /**Recherche à droite */
        if ( (i+1) < 10 ) {
            if ( (this.tabTerm[i][j] == this.tabTerm[i+1][j]) && this.tabTerm[i][j] != 'X' ){
                this.storage [i+1][j] = this.tabTerm [i+1][j];
                this.grp ++;
                Radar (i+1,j);
            }
        }


        /**Recherche vers le bas*/
        if (j > 0){
            if ( (this.tabTerm [i][j] == this.tabTerm [i][j-1] ) && this.tabTerm [i][j] != 'X'  ){
                this.storage [i][j-1] = this.tabTerm [i][j-1];
                this.grp ++;
                Radar (i, j-1);
            }
        }

        /**Recherche vers le haut */
        if ( (j+1) < 15){
            if ( (this.tabTerm [i][j] == this.tabTerm [i][j+1] ) && this.tabTerm [i][j] != 'X'  ){
                this.storage [i][j+1] = this.tabTerm [i][j+1];
                this.grp ++;
                Radar (i, j+1);
            }
        }




    }

    /**Evenement séléction d'un groupe */
    @Override 

    public void mouseEntered (MouseEvent evenement){
        

        for (ligne = 0; ligne <10; ligne ++){
            
            for (colonne = 0; colonne < 15; colonne ++){
            
                if ( (evenement.getSource() == this.tab[ligne][colonne]) ){
                   
                    System.out.println("Groupe : " +this.grp);
                    this.tab[ligne][colonne].setBackground(Color.YELLOW);

                }
            }
        }
    }

    @Override
 
    public void mouseClicked​(MouseEvent e){

    }
    @Override
    public void mouseExited​(MouseEvent e){

    }
    @Override
    public void mousePressed​(MouseEvent e){

    }
    @Override
    public void mouseReleased​(MouseEvent e){

    }

     

}