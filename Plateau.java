import java.awt.*;
import javax.swing.*;

/**
* La classe <code>Plateau</code> créé la fenetre du jeu
* @version 1.0
* @author Arthur DECORBEZ & Shana LEFEVRE
*/
public class Plateau extends JFrame
{

    public JLabel score;

    /**
    * Constructeur de la classe Plateau
    * Initalisation de la fenetre
    */
    public Plateau(String mode)
    
    {
        if(mode == "Random")

        {
            System.out.println("Random");

            JFrame fenetre = new JFrame("~ SameGame ~");
            fenetre.setSize(800, 600);
            fenetre.setLocation(200, 200);
            fenetre.setResizable(false);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setVisible(true);

            // Panneau des scores
            JPanel info = new JPanel();
            fenetre.add(info, BorderLayout.NORTH);
            info.setBackground(Color.GRAY);

            JLabel score = new JLabel ("Score : 0");           
            Font police = new Font("Chilanka", Font.BOLD, 25);
            score.setFont(police);

            info.add (score);

            // Panneau du jeu
            JPanel jeu = new JPanel();
            fenetre.add(jeu, BorderLayout.CENTER);

            // Création de la grille
            jeu.setLayout(new GridLayout(10, 15));
            jeu.setBackground(Color.BLUE);

            /**
            * Appel de la classe GenerateurGrilleAleatoire
            * Permet aussi l'affichage sur le JPanel jeu
            */
            GenerateurGrilleAleatoire al = new GenerateurGrilleAleatoire(score);
            al.TabAl(jeu);

            ControllerJeu.window = this;

        }

        else if(mode == "File")

        {
            System.out.println("File");

            JFrame fenetre = new JFrame("~ SameGame ~");
            fenetre.setSize(800, 600);
            fenetre.setLocation(200, 200);
            fenetre.setResizable(false);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setVisible(true);

            /*
            * Panneau des scores
            */
            JPanel info = new JPanel();
            fenetre.add(info, BorderLayout.NORTH);
            info.setBackground(Color.GRAY);
            JLabel score = new JLabel("Score : ");

            Font police = new Font("Chilanka", Font.BOLD, 25);
            score.setFont(police);
            info.add (score);

            /*
            * Panneau du jeu
            */
            JPanel jeu = new JPanel();
            fenetre.add(jeu, BorderLayout.CENTER);

            /*
            * Création de la grille
            */
            jeu.setLayout(new GridLayout(10, 15));
            jeu.setBackground(Color.BLUE);

            /*
            * Appel de la classe LectureGrille.java
            */
        }
    }
}