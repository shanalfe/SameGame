import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 * Class ControllerJeu
 *  Permet de gérer les évenements de la souris et donc la gestion du jeu 
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 * @see GenerateurGrilleAleatoire
 * @see
 * N = no group == seule, sans voisin du même type
 * X = case libre, vide, sans bloc
 */
public class ControllerJeu implements MouseListener {
    
    //Déclaration des variables
    
    private JPanel jeu;
    protected char [][] tabTerm;
    protected Bloc[][] tab; //tab de Bloc



    private int grp = 0; // taille du groupe    
    private char [][] storage; // tableau qui stocke le groupe survolé, X : case libre

   

    /**
     * Constructeur ControllerJeu
     * @param tab : récupération du tableau Bloc 
     * @param tabTerm : récupération du tableau terminal
     */
    public ControllerJeu (Bloc[][] tab, char [][]tabTerm ) {
        
        //Déclaration des variables 
        super ();
        this.tab=tab;
        this.tabTerm=tabTerm;       
        int ligne = 0, colonne = 0;
        char storage [][] = new char [10][15];

        
        for (ligne = 0; ligne < 10; ligne++ ) {
            
            for (colonne = 0; colonne < 15;colonne++ ) {
                
                this.tab[ligne][colonne].addMouseListener(this);
                this.tab[ligne][colonne].setBackground(Color.WHITE);
                storage [ligne][colonne] = 'N'; //Initalisation case occupée
                // System.out.println (storage[ligne][colonne]);
                             
            }
        }

        //rajouter le panel pour le score
    }

    

    @Override 
    /**
     * Méthode mouseEnterd
     *  Permet de séléctionner un groupe
     */
    public void mouseEntered (MouseEvent evenement){
        
        int ligne = 0, colonne = 0;
        
        for (ligne = 0; ligne <10; ligne ++){
            
            for (colonne = 0; colonne < 15; colonne ++){
            
                if ( (evenement.getSource() == this.tab[ligne][colonne]) && this.tabTerm [ligne][colonne] != 'X' ){
                    this.tab[ligne][colonne].setOpaque(true);

                    this.tab[ligne][colonne].setBackground(Color.YELLOW);
                    Radar (ligne, colonne);
                    System.out.println("Groupe : " +this.grp);
                   
                    
                    for (ligne = 0; ligne <10; ligne ++){
                        for (colonne = 0; colonne <15; colonne ++){
                            if ( (storage [ligne][colonne] != 'N') && (this.tabTerm [ligne][colonne] != 'X') ){
                                this.tab [ligne][colonne].setBackground(Color.YELLOW);
                            }
                        }
                    }

                }
            }
        }
    }

    
    @Override
 
    public void mouseClicked​(MouseEvent e){

        
    }

    /**
    *Méthode mouseExited
    * Quand l'utilisateur quitte le composant
    */
    @Override
    public void mouseExited(MouseEvent e) {
	for (int i=0; i<10; i++) {
	    for (int j=0; j<15; j++) {
		  this.tab[i][j].setBackground(Color.WHITE);
		  this.storage[i][j] = 'N';
	    }
	}
	this.grp = 0;
    }



    @Override
    public void mousePressed​(MouseEvent e){

    }

    @Override
    public void mouseReleased​(MouseEvent e){

        // int tgroupe=0;

        // for(int i=0;i<10;i++) {
        //     System.out.println("");
        //     for (int j=0; j<15; j++) {
        //     if(this.storage[i][j]!='N') {
        //         this.tab[i][j].setBackground(Color.WHITE);
        //         this.tab[i][j].resetCouleur();
        //         this.tab[i][j].setCouleur(0);
        //         this.tabTerm[i][j] = 'X';
        //         this.storage[i][j] = 'N';
        //         tgroupe++;

        //     }
        //     // reorganiseColonne(j);
        //     System.out.print(tabTerm[i][j] + " ");
        //     }
        // }

        // if(tgroupe >2){
        //     this.score += (tgroupe-2)*(tgroupe-2);
        //     this.scoreL.setScore(this.score);
        //     System.out.println();
        //     System.out.println("Score : " + this.score);
        // }
        // for (int i=0; i<15; i++) {
        //     checkTouteColonneVide();
        // }
        // System.out.println("");
        // if(checkJeuFin() == 1){
        //     Couleur.setFin(true);
        //     this.fenetre.repaint();
        //     this.test.setText(" | Cliquez pour continuer");
        //     this.fenetre.addMouseListener(this);


        // }
    }


     /**
     * Méthode Radar 
     *  Permet de détecter/trouver un groupe à partir d'un bloc en utilisant la récurrence
     */

    public void Radar(int x, int y) {

        if(y>0) {
            if((this.tabTerm[x][y] == this.tabTerm[x][y-1]) && (this.tabTerm[x][y] != 'X')) {
    
           
                  this.storage[x][y-1] = this.tabTerm[x][y-1];
                  this.grp++;
                  Radar(x, y-1);
    
                
            }
        }
    
        if(y+1<15) {
            if((this.tabTerm[x][y] == this.tabTerm[x][y+1]) && (this.tabTerm[x][y] != 'X')) {
           
                this.storage[x][y+1] = this.tabTerm[x][y+1];
                this.grp++;
                Radar(x, y+1);
            
            }
        }
        if(x>0) {
            if((this.tabTerm[x][y] == this.tabTerm[x-1][y]) && (this.tabTerm[x][y] != 'X')) {
           
                this.storage[x-1][y] = this.tabTerm[x-1][y];
                this.grp++;
                Radar(x-1, y);
            
            }
        }
    
        if(x+1<10) {
            if((this.tabTerm[x][y] == this.tabTerm[x+1][y]) && (this.tabTerm[x][y] != 'X')) {
           
                this.storage[x+1][y] = this.tabTerm[x+1][y];
                this.grp++;
                Radar(x+1, y);
            
            }
        }
    }




   


     

}
