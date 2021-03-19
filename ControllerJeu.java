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
    protected char [][] bool;

    private int grp = 0; // taille du groupe    


   

    /**
     * Constructeur ControllerJeu
     * @param tab : récupération du tableau Bloc 
     * @param tabTerm : récupération du tableau terminal
     */
    public ControllerJeu (Bloc[][] tab, char [][]tabTerm, char [][] bool ) {
        
        //Déclaration des variables 
        super ();
        this.tab = tab;
        this.tabTerm = tabTerm;       
        int i = 0, j = 0;
        this.bool = bool; // tableau qui s'utilise comme booleen

        
        for (i = 0; i < 10; i++ ) {
            
            for (j = 0; j < 15;j++ ) {
                
                this.tab[i][j].addMouseListener(this);
                this.tab[i][j].setBackground(Color.WHITE);
               
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
        
        int i = 0, j = 0;
        
        for (i = 0; i <10; i ++){
            
            for (j = 0; j < 15; j ++){

                bool[i][j] = 'F'; // initialisation du tableau booléen à false -> sans groupe
            
                if ( (evenement.getSource() == tab[i][j]) && this.tabTerm [i][j] != 'X' ){
                     
                    
                    tab[i][j].setOpaque(true);
                    tab[i][j].setBackground(Color.YELLOW);
                    
                    Radar (i, j);                    
                    System.out.println("Groupe : " +this.grp);


                }
            }
        }

        System.out.println("Initialisation bool");
        for (char[] tab: bool) {
            for (char bo: tab) {
                System.out.print(bo + " ");
            }
            System.out.println("\n");
        }
        System.out.println("Tabterm");
        for (char[] tab: tabTerm) {
            for (char ta: tab) {
                System.out.print(ta + " ");
            }
            System.out.println("\n");
        }

    }

    public void Radar (int x, int y){
       
            // Vérife bas
            if ( x<9){

                if ( ( this.tabTerm[x][y] == this.tabTerm[x+1][y] ) && ( this.bool[x+1][y] == 'F' ) ) {
                    this.bool [x+1][y] = 'T';
                    this.tab[x+1][y].setBackground(Color.YELLOW);
                    x = x+1;
                    Radar (x, y); // Récursivité
                }

            }

            // Vérifie haut
            if ( x>0 ) {

                if ( ( this.tabTerm[x][y] == this.tabTerm[x-1][y] ) && ( this.bool[x-1][y] == 'F' ) ) {
                    this.bool [x+1][y] = 'T';
                    this.tab[x-1][y].setBackground(Color.YELLOW);
                    x = x-1;
                    Radar (x, y);
                }

            }

            // Vérifie droite 
            if ( y<14 ) {

                if ( ( this.tabTerm[x][y] == this.tabTerm[x][y+1] ) && ( this.bool[x][y+1] == 'F' ) ) {
                    this.bool[x][y+1] = 'T';
                    this.tab[x][y+1].setBackground(Color.YELLOW);
                    y = y+1;
                    Radar(x, y);

                }
            }

            // vérifie gauche

            if ( y>0 ) {
                
                if ( ( this.tabTerm[x][y] == this.tabTerm[x][y-1] ) && ( this.bool[x][y-1] == 'F' ) ) {
                    this.bool[x][y-1]= 'T';
                    this.tab[x][y-1].setBackground(Color.YELLOW);
                    y = y-1;
                    Radar (x,y);
                }
            }

            System.out.println("Initialisation bool");
        for (char[] tab: bool) {
            for (char bo: tab) {
                System.out.print(bo + " ");
            }
            System.out.println("\n");
        }
        
    }
    
    
    /**
    *Méthode mouseExited
    * Quand l'utilisateur quitte le composant
    */
    @Override
    public void mouseExited(MouseEvent e) {
       
        int i = 0, j = 0;

        for ( i=0; i<10; i++) {
            for ( j=0; j<15; j++) {
                this.bool [i][j] = 'F'; // Réinitialisation du tableau booléen
                this.tab[i][j].setBackground(Color.WHITE);
            }
        }

    }

    @Override
    /**
     * Méthode mouseClicked
     *  Permet de gérer l'evenement clique de la souris
     * 
     */
    public void mouseClicked​(MouseEvent e){
        
        //Affichage terminal 
        System.out.println("\n");
        for (char[] tab: tabTerm) {
            for (char s: tab) {
                System.out.print(s + " ");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
        for (char[] tab: bool) {
            for (char b: tab) {
                System.out.print(b + " ");
            }
            System.out.println("\n");
        }
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


 


   


     

}
