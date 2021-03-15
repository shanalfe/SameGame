import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;


/**
 * Classe Plateau qui créé le plateau de jeu 
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 */

public class Plateau extends JFrame {

    public Plateau () {
        super ("SameGame");
    }

    
    /**
     * Méthode IniGrilleAl qui permet la création de la grille aléatoire
     */
    public void IniGrilleAl (){
     
        JPanel panneau = new JPanel();
        this.add(panneau);

        Random random = new Random();

        this.setSize (800,600);
        this.setLocation (200,200);
        this.setLayout (null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        System.out.println("Création de la Grille aléatoire");

    }
	



}