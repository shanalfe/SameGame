import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Classe Plateau 
 *  créé le plateau du jeu 
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 * 
 * Respectivement :
 * 1 = rouge
 * 2 = bleu
 * 3 = vert
 */
public class Plateau extends JFrame {

    /*Déclaration des variables*/

  


  
    /**
     * Constructeur de la classe Plateau
     *  Initalisation de la fenetre
     */
    public Plateau () {    
       
        JFrame fenetre = new JFrame("SameGame");
        fenetre.setSize (800,600);
        fenetre.setLocation (200,200);
        fenetre.setResizable(false);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible (true);

         /*Panneau des scores*/
        JPanel info = new JPanel();
        fenetre.add (info, BorderLayout.NORTH);
        info.setBackground(Color.GRAY);
        JLabel score = new JLabel ("Score");
        info.add (score);
      
        /*Panneau du jeu*/
        JPanel jeu = new JPanel();
        fenetre.add (jeu, BorderLayout.CENTER);
        jeu.setBackground(Color.RED);

        /*Création de la grille*/
        jeu.setLayout (new GridLayout (10,15));
        jeu.setBackground (Color.BLUE);
      
        GenerateurGrilleAleatoire al = new GenerateurGrilleAleatoire ();
        al.TabAl(jeu);


    }


  

   





}