import java.awt.*;
import javax.swing.*;
import java.io.*;

/**
* La classe <code>Plateau</code> créé la fenetre du jeu.
*
* @version 1.0
* @author Shana LEFEVRE & Arthur DECORBEZ
*/
public class Plateau extends JFrame
{
	/*
	* Composante du score.
	*/
	public JLabel score;

	/**
	* Composante de la fenetre.
	*/
	public JFrame fenetre;

	/**
	* Constructeur de la classe Plateau.
	* Initalisation de la fenetre.
	*
	* @param mode
	* @param file
	* @see ControllerMenu
	*/
	public Plateau(String mode, File file)
	{
		JFrame fenetre = new JFrame("~ SameGame ~");
		fenetre.setSize(800, 600);
		fenetre.setLocation(200, 200);
		this.setIconImage(new ImageIcon(getClass().getResource("./Image/icon.png")).getImage());
		fenetre.setResizable(false);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);

		// Panneau des scores
		JPanel info = new JPanel();
		fenetre.add(info, BorderLayout.NORTH);
		info.setBackground(Color.GRAY);

		JLabel score = new JLabel("Score : 0");		   
		Font police = new Font("Chilanka", Font.BOLD, 25);
		score.setFont(police);

		info.add(score);

		// Panneau du jeu
		JPanel jeu = new JPanel();
		fenetre.add(jeu, BorderLayout.CENTER);

		// Création de la grille
		jeu.setLayout(new GridLayout(10, 15));
		jeu.setBackground(Color.BLUE);

		if(mode == "Random")
		{
			System.out.println("Random");
			
			/**
			* Appel de la classe GenerateurGrilleAleatoire
			* Permet aussi l'affichage sur le JPanel jeu
			*/
			GenerateurGrilleAleatoire generateurGrilleAleatoire = new GenerateurGrilleAleatoire(score, fenetre);
			generateurGrilleAleatoire.TabAl(jeu);
		}
		else if(mode == "File")
		{
			System.out.println("File");

			/*
			* Appel de la classe LectureGrille.java
			* Lit le fichier choisi et met les valeurs du fichier dans un tableau.
			*/
			LectureGrille lectureGrille = new LectureGrille(score, fenetre);
			lectureGrille.tabGrille(jeu, file);
		}
	}
}