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
 */
public class ControllerJeu implements MouseListener {
    
    //Déclaration des variables
    
    private JPanel jeu;
    protected char [][] tabTerm;
    protected Bloc[][] tab; //tab de Bloc
    protected char [][] bool;

    protected double grp = 0; // taille du groupe    
    protected double score;


    /**
     * Constructeur ControllerJeu
     * @param tab : récupération du tableau Bloc 
     * @param tabTerm : récupération du tableau terminal
     */
    public ControllerJeu (Bloc[][] tab, char [][]tabTerm, char [][] bool, double grp, double score ) {
        
        //Déclaration des variables 
        super ();
        this.tab = tab;
        this.tabTerm = tabTerm;       
        this.bool = bool; // tableau qui s'utilise comme booleen
        this.grp = grp; // Taille du groupe
        grp = 0;
        this.score = score;

        int i = 0, j = 0;
        
        for (i = 0; i < 10; i++ ) {
            
            for (j = 0; j < 15;j++ ) {
                
                this.bool[i][j] = 'F';
                this.tab[i][j].addMouseListener(this);
                this.tab[i][j].setBackground(Color.WHITE);
                                            
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
            
                if ( (evenement.getSource() == tab[i][j]) && this.tabTerm [i][j] != 'X' ){
                                         
                    this.tab[i][j].setOpaque(true);
                    this.tab[i][j].setBackground(Color.YELLOW);
                    
                    Radar (i, j);

                }
            }
        }

        System.out.println("Groupe : " +this.grp);

        // Affichage Terminal
        System.out.println("Tab bool");
        for (char[] tab: bool) {
            for (char bo: tab) {
                System.out.print(bo + " ");
            }
            System.out.println("\n");
        }
        // System.out.println("Tabterm");
        // for (char[] tab: tabTerm) {
        //     for (char ta: tab) {
        //         System.out.print(ta + " ");
        //     }
        //     System.out.println("\n");
        // }


    }


    /**
    * Méthode Radar
    *   Permet la détection d'un groupe d'un bloc
    *   Utilisation d'un tab comme booléen : bool[][].
    *       Si F -> alors la case n'appartient pas au groupe
    *       Si T -> alors la case appartient au groupe
    */
    public void Radar (int x, int y){

        int i = 0, j = 0;
        
            for (i = 0; i<10; i++){
                 for (j = 0; j<15; j++){

                    // Vérife bas
                    if ( x<9){

                        if ( ( this.tabTerm[x][y] == this.tabTerm[x+1][y] ) && ( this.bool[x+1][y] == 'F' ) ) {
                            this.grp++;
                            this.bool [x+1][y] = 'T';
                            this.tab[x+1][y].setBackground(Color.YELLOW);
                            x = x+1;
                            Radar (x, y); // Récursivité
                        }

                    }

                    // Vérifie haut
                    if ( x>0 ) {

                        if ( ( this.tabTerm[x][y] == this.tabTerm[x-1][y] ) && ( this.bool[x-1][y] == 'F' ) ) {
                            this.grp++;
                            this.bool [x-1][y] = 'T';
                            this.tab[x-1][y].setBackground(Color.YELLOW);
                            x = x-1;
                            Radar (x, y);
                        }

                    }

                    // Vérifie droite 
                    if ( y<14 ) {

                        if ( ( this.tabTerm[x][y] == this.tabTerm[x][y+1] ) && ( this.bool[x][y+1] == 'F' ) ) {
                            this.grp++;
                            this.bool[x][y+1] = 'T';
                            this.tab[x][y+1].setBackground(Color.YELLOW);
                            y = y+1;
                            Radar(x, y);

                        }
                    }

                    // vérifie gauche

                    if ( y>0 ) {
                        
                        if ( ( this.tabTerm[x][y] == this.tabTerm[x][y-1] ) && ( this.bool[x][y-1] == 'F' ) ) {
                            this.grp++;
                            this.bool[x][y-1]= 'T';
                            this.tab[x][y-1].setBackground(Color.YELLOW);
                            y = y-1;
                            Radar (x,y);
                        }
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
        
    }
    
    
    /**
    *Méthode mouseExited
    * Quand l'utilisateur quitte le composant, alors on 
    * on concidèrera qu'il ne s'est rien passé. Cette majorité du code reset les veleurs
    */
    @Override
    public void mouseExited(MouseEvent e) {
       
        int i = 0, j = 0;

        for ( i = 0; i < 10; i ++) {
            for ( j = 0; j < 15; j ++) {

                this.bool [i][j] = 'F'; // Réinitialisation du tableau booléen
                this.tab[i][j].setBackground(Color.WHITE);
            }
        }
        this.grp = 0; // Réinitialisation taille du groupe

        // Affichage terminal
        System.out.println("MAJ Bool");
        for (char[] tab: bool) {
            for (char bo: tab) {
                System.out.print(bo + " ");
            }
            System.out.println("\n");
        }

    }


    @Override
    /**
     * Méthode mouseClicked
     *  Permet de gérer l'evenement clique de la souris
     * On concidèrera que le joueur a et veut éliminer un groupe
     * 
     */
    public void mouseClicked​(MouseEvent e){

        // Déclaration des variables
        int i = 0, j=0;


        // Suppression
        for (i=0; i<10; i++){

            for (j=0; j<15; j++){

                if (this.bool [i][j] == 'T'){

                    this.tab[i][j].setBackground(Color.WHITE);
                    this.tab[i][j].ResetBloc();
                    this.tab[i][j].ChangerBloc(0);
                    this.tabTerm[i][j] = 'X'; // La case est libre
                }
                
            }
        }
        // Affichage terminal 
        // System.out.println("TabTerm après suppression");
        // for (char[] tab: tabTerm) {
        //     for (char s: tab) {
        //         System.out.print(s + " ");
        //     }
        //     System.out.println("\n");
        // }



        // Calcul du score
        this.score = this.score + Math.pow ( (this.grp - 2), 2 ); // Affichage
        System.out.println ("Score : "+this.score);

        // Vérification des colonnes et lignes






        // Réinitialisation
        for (i=0; i<10; i++){

            for (j=0; j<15; j++){

                this.bool [i][j] = 'F'; // réinitialisation du tableau bool
                this.tab[i][j].setForeground (Color.WHITE);
               
            }
        }
        this.grp = 0;


        
        //Affichage terminal 
        // System.out.println("\n");
        // for (char[] tab: tabTerm) {
        //     for (char s: tab) {
        //         System.out.print(s + " ");
        //     }
        //     System.out.println("\n");
        // }
        System.out.println("Tab Bool réinitialisationCliqued");
        // System.out.println("\n");
        // for (char[] tab: bool) {
        //     for (char b: tab) {
        //         System.out.print(b + " ");
        //     }
        //     System.out.println("\n");
        // }

    }


    @Override
    public void mousePressed​(MouseEvent e){

    }

    @Override
    public void mouseReleased​(MouseEvent e){

    }


 


   
     

}
