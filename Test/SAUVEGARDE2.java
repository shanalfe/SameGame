import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 * Class <code>ControllerJeu</code>
 *  Permet de gérer les évenements de la souris et donc la gestion du jeu 
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 * @see GenerateurGrilleAleatoire
 * @see LectureGrille
 */
public class ControllerJeu implements MouseListener {
    
    /**
    * Composante du "plateau du jeu" 
    */
    private JPanel jeu;
     /**
    * Composante du tableau généré sur le terminal
    * X -> Bloc non existant, R-> bloc rouge, V-> bloc vert, B-> bloc bleu
    */
    protected char [][] tabTerm;
     /**
    * Composante de l'affichage des blocs
    */
    protected Bloc[][] tab;
     /**
    * Composante du tableau pour vérifier les status d'une sélection
    * T -> bloc appartient à un groupe, F -> bloc appartient pas a un groupe
    * . -> bloc n'existe plus donc pas de status
    */
    protected char [][] bool;
     /**
    * Composante de la taille d'un groupe
    */
    protected double grp = 0;
     /**
    * Composante du score
    */
    public double resultat;

    // private Score score;


    /**
     * Constructeur ControllerJeu
     * @param tab : récupération du tableau Bloc 
     * @param tabTerm : récupération du tableau terminal
     * @param bool : récupération du tableau 
     * @param grp : récupération de la variable pour calculer la taille du groupe
     * @param score : récupération du score
     */
    public ControllerJeu (Bloc[][] tab, char [][]tabTerm, char [][] bool, double grp) {
        
        //Déclaration et récupération des variables 

        super ();
        this.tab = tab;
        this.tabTerm = tabTerm;       
        this.bool = bool; // tableau qui s'utilise comme booleen
        this.grp = grp; // Taille du groupe
        grp = 0;
        this.resultat = resultat;
        resultat = 0;
        // this.score = sco;

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

    /**
    * Méthode Radar
    *   Permet la détection d'un groupe d'un bloc, utilisé par la méthode mouseEntered
    *   Utilisation d'un tab comme booléen : bool[][].
    *       Si F -> alors la case n'appartient pas au groupe
    *       Si T -> alors la case appartient au groupe
    *   @param x : coordonnée d'une ligne 
    *   @param y : coordonnée d'une colonne
    */
    public void Radar (int x, int y){

        // Déclaration des variables
        int i = 0, j = 0;
        
            for (i = 0; i<10; i++){

                 for (j = 0; j<15; j++){

                    // Vérife bas
                    if ( x<9){

                        if ( ( this.tabTerm[x][y] == this.tabTerm[x+1][y] ) && ( this.bool[x+1][y] == 'F' ) ) {
                            
                            if ( ( Boule (x+1,y) ) ) {
                                this.grp++;
                                this.bool [x+1][y] = this.tabTerm[x+1][y];
                                this.tab[x+1][y].setBackground(Color.YELLOW);
                                x = x+1;
                                Radar (x, y); // Récursivité
                            }

                        }

                    }

                    // Vérifie haut
                    if ( x>0 ) {

                        if ( ( this.tabTerm[x][y] == this.tabTerm[x-1][y] ) && ( this.bool[x-1][y] == 'F' ) ) {
                            if ( Boule(x-1, y) ) {
                                this.grp++;
                                this.bool [x-1][y] = this.tabTerm[x-1][y];
                                this.tab[x-1][y].setBackground(Color.YELLOW);
                                x = x-1;
                                Radar (x, y);
                            }
                        }

                    }

                    // Vérifie droite 
                    if ( y<14 ) {

                        if ( ( this.tabTerm[x][y] == this.tabTerm[x][y+1] ) && ( this.bool[x][y+1] == 'F' ) ) {
                            if ( Boule(x,y-1) ) {    
                                this.grp++;
                                this.bool[x][y+1] = this.tabTerm[x][y+1];
                                this.tab[x][y+1].setBackground(Color.YELLOW);
                                y = y+1;
                                Radar(x, y);
                            }

                        }
                    }

                    // vérifie gauche
                    if ( y>0 ) {
                        
                        if ( ( this.tabTerm[x][y] == this.tabTerm[x][y-1] ) && ( this.bool[x][y-1] == 'F' ) ) {
                            if (Boule (x,y-1) ) {
                                this.grp++;
                                this.bool[x][y-1]= this.tabTerm[x][y-1];
                                this.tab[x][y-1].setBackground(Color.YELLOW);
                                y = y-1;
                                Radar (x,y);
                            }
                        }
                    }

                }
            }

            // Affichage
            //System.out.println("Initialisation bool");
            // for (char[] tab: bool) {
            //     for (char bo: tab) {
            //         System.out.print(bo + " ");
            //     }
            //     System.out.println("\n");
            // }
        
    }
    

    @Override 
    /**
     * Méthode mouseEnterd
     *  Permet de séléctionner un groupe
     */
    public void mouseEntered (MouseEvent evenement){
        
        // Déclaration des variables
        int i = 0, j = 0;
        
        for (i = 0; i <10; i ++){
            
            for (j = 0; j < 15; j ++){
            
                if ( (evenement.getSource() == tab[i][j]) && (this.tabTerm [i][j] != 'X')  ){
                                         
                    this.tab[i][j].setOpaque(true);
                    this.tab[i][j].setBackground(Color.YELLOW);
                    
                    Radar (i, j);

                }
            }
        }

        System.out.println("Groupe : " +this.grp);

        // Affichage Terminal
        // System.out.println("Tab bool");
        // for (char[] tab: bool) {
        //     for (char bo: tab) {
        //         System.out.print(bo + " ");
        //     }
        //     System.out.println("\n");
        // }
        // System.out.println("Tabterm");
        // for (char[] tab: tabTerm) {
        //     for (char ta: tab) {
        //         System.out.print(ta + " ");
        //     }
        //     System.out.println("\n");
        // }


    }    
    
    /**
    *Méthode mouseExited
    * Quand l'utilisateur quitte le composant 
    * On concidèrera qu'il ne s'est rien passé donc on reset les valeurs générées par 
    * la méthode mouseEntered
    */
    @Override
    public void mouseExited(MouseEvent e) {
        
        // Déclaration des variables
        int i = 0, j = 0;

        for ( i = 0; i < 10; i ++) {
            for ( j = 0; j < 15; j ++) {

                this.bool [i][j] = 'F'; // Réinitialisation du tableau booléen
                this.tab[i][j].setBackground(Color.WHITE);
            }
        }
        this.grp = 0; // Réinitialisation taille du groupe

        // Affichage terminal
        //System.out.println("MAJ Bool");
        // for (char[] tab: bool) {
        //     for (char bo: tab) {
        //         System.out.print(bo + " ");
        //     }
        //     System.out.println("\n");
        // }

    }


    @Override
    /**
     * Méthode mouseClicked
     *  Permet de gérer l'evenement clique (enfoncé + relaché) de la souris
     * On vérifie à chaque clique si fin du jeu il y a.
     * 
     */
    public void mouseClicked​(MouseEvent e){
        
    }


    @Override
    /**
    * Méthode mousePressed
    *   Permet l'évènement quand le bouton de la souris est enfoncé
    *   Dans cette méthode, on supprime et on calcule le score
    */  
    public void mousePressed​(MouseEvent e){
        
        // Déclaration des variables
        int i = 0, j=0;

        for (i=0; i<10; i++){

            for (j=0; j<15; j++){

                if (this.bool [i][j] == tabTerm[i][j]){

                    this.tab[i][j].setBackground(Color.WHITE);
                    this.tab[i][j].ResetBloc();
                    this.tab[i][j].ChangerBloc('b');
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

        if (Resultat () == true) {
            // Calcul du score
            this.resultat = this.resultat + Math.pow ( (this.grp - 2), 2 ); // Affichage
            System.out.println ("Score : "+this.resultat);
            // this.score.ChangerScore(this.resultat);
        }

    }


    @Override
    /**
    * Méthode mouseReleased
    *   Permet de gérer l'évènement quand le bouton de la souris est relaché
    *   On réinitialisera toutes les valeurs dans cette méthode
    */
    public void mouseReleased​(MouseEvent e){
        
        // Déclaration des variables
        int i = 0, j = 0;

        //Affichage terminal 
        System.out.println("Décalage fait");
        // for (char[] tab: tabTerm) {
        //     for (char s: tab) {
        //         System.out.print(s + " ");
        //     }
        //     System.out.println("\n");
        // }

       
        for (i = 0; i < 10; i++){

            for (j = 0; j < 15; j++){
               
                this.tab[i][j].setForeground (Color.WHITE);   

                 // Détection lignes vides
                if (this.tabTerm[i][j] == 'X'){
                   
                    OrganiserLignes (j);
                    
                }

            }
        }

        
         // Détection lignes vides
        for (j = 0; j < 15; j++){
            
            if ( this.VerificationCol(j) == true){
               
               CopyColonne ();
            }            
        }


        // Réinitialisation 
        for (i = 0; i < 10; i++){

            for (j = 0; j < 15; j++){

                if (this.tabTerm [i][j] == 'X') {

                    this.bool [i][j] = '.'; // status non compatible avec une case vide

                } else if (this.tabTerm [i][j] != 'X') {

                    this.bool [i][j] = 'F'; // réinitialisation du tableau bool
                }
            }
        }
        this.grp = 0;


            
        
        if (End() == true) {

            System.out.println ("Fin jeu");
        }
            
        
      

       
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


    public boolean Boule (int x, int y){
        int i = 0, j = 0;

        for (i = 0; i < 10; i++){

            for (j = 0; j < 15; j++){

                if (this.bool [x][y] == this.tabTerm[i][j]) {

                    return false;
                }
            }
        }

        return true;

    }

    /**
    * Méthode Resultat
    * Permet de gagner des points QUE quand l'utilisateur clique sur un groupe
    */
    public boolean Resultat () {

        int i = 0, j = 0;

        for (i = 0; i < 10; i++){

            for (j = 0; j < 15; j++){

                if (this.bool [i][j] == this.tabTerm [i][j]) {

                    return true;
                }
            }
        }

        return false;
    }


    /**
    * Méthode OrganiserLigne
    *   Permet de déplacer les blocs vers le bas s'il y a une case vide
    * @param j : Récupère une colonne
    */
    public void OrganiserLignes (int j) {
        
        // Déclaration des variables
        int i;
        char color;

        for ( i = 9; i > 0; i--) {
           
            if(this.tabTerm[i][j] == 'X') {

                color = this.tabTerm[i-1][j];
               
                this.tab[i-1][j].ChangerBloc('b');
                this.tabTerm[i-1][j] = 'X';
        
                this.tab[i][j].ChangerBloc(color);                
                this.tabTerm [i][j] = color;
            }
        }
    }


    /**
    * Méthode CopyColonne
    *   Permet l'affichage
    */
    public void CopyColonne () {

        int i = 0, k = 0, j=0;
        char color;

        // Décalage pour les 15 colonnes
        for (k = 0; k<14; k++){

            // Maximum 15 colonnes donc 14
            for (j = 0; j<14; j++){

                if (VerificationCol(j)){

                    for (i = 0; i < 10; i++) {

                        color = this.tabTerm[i][j+1];
                        this.tab[i][j].ChangerBloc(color);

                        this.tabTerm[i][j] = this.tabTerm[i][j+1];
                        this.tabTerm[i][j+1] = 'X';
                        this.tab[i][j+1].ChangerBloc ('b');
                    }                   
                    
                }
            }
        }
    }


    /**
    * Méthode VerificationCol
    * @param j : prend une colonne précise
    *   Permet de vérifier si une colonne est vide
    */
    public boolean VerificationCol (int j) {

        int i = 0;

        for (i=0; i <10; i++){
            
            if (this.tabTerm[i][j] != 'X'){
                
                return false;
            }
        }

        return true;
    }


    // public boolean End () {

    //     int fin = 1, i = 0, j = 0;
    //     this.grp = 0;

    //     for (i = 0; i < 10; i++) {

    //         for (j = 0; j < 15; j++) {

    //             if ( (this.tabTerm[i][j] != 'X') && (this.bool [i][j] != '.') ) {

    //                 Radar (i, j);

    //                 if (this.grp != 0) {

    //                     this.tab[i][j].setBackground(Color.WHITE);
    //                     return true;
    //                 }

    //             }

                  
    //         }

    //     }

    //     for (i = 0; i < 10; i++) {

    //         for (j = 0; j < 15; j++) {

    //             this.bool[i][j] = 'F';
    //         }
    //     }

    //     return false;
    
    // }



}
 