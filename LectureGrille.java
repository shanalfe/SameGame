import javax.swing.*;
import java.io.*;

/**
* La classe <code>LectureGrille</code> génère une grille aléatoire et associe les dessins correspondants
*/
public class LectureGrille extends JPanel
{
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
	public LectureGrille (JLabel score, JFrame fenetre)
	{
		this.score = score;
		this.fenetre = fenetre;
	}

	/**
	* Permet la génération de la grille aléatoire
	* @param panel
	* @see Menu
	*/
	public void tabGrille (JPanel panel, File file)
	{

		// Déclaration des variables
		int j = 0, i = 0;
		char tabTerm[][] = new char[10][15];
		tab = new Bloc[10][15];
		char bool [][] = new char [10][15];

		this.jeu = panel;

		try
		{
			FileReader reader = new FileReader(file);

			try
			{
				// Lecture du fichier
				for(i = 0; i < 10; i++)
				{
					for(j = 0; j < 15; j++)
					{
						tabTerm[i][j] = (char) reader.read();
					}
					reader.read();
				}

				// Cf. code de Shana
				for (i = 0; i < 10; i++)
				{
					for (j = 0; j < 15; j++)
					{
						if (tabTerm[i][j] == 'R')
						{
							tab[i][j] = new Salameche();
							jeu.add(tab[i][j]);
						}
						else if (tabTerm[i][j] == 'V')
						{
							tab[i][j] = new Bulbi();
							jeu.add(tab[i][j]);	 
						}
						else if (tabTerm[i][j] == 'B')
						{	
							tab[i][j] = new Carapuce();
							jeu.add(tab[i][j]);		
						}
					}			
				}

				jeu.addMouseListener(new ControllerJeu (tab, tabTerm, bool, grp, score, fenetre));
			}
			catch(IOException e)
			{
				System.err.println("Impossible de lire dans le fichier reels.bin !");
			}

			try
			{
				reader.close();
			}
			catch(IOException e)
			{
				System.err.println("Impossible de fermer le fichier reels.bin !");
			}
		}
		catch(FileNotFoundException e)
		{
			System.err.println("Impossible d'ouvrir le fichier reels.bin en lecture !");
		}
	}

	/**
	* Renvoie la tab contenant les images correspondant à tabTerm
	* @return tab
	*/
	public Bloc[][] getTab()
	{
		return tab;
	}

	/**
	* Renvoie la tab RVB du terminal
	* @return tabTerm
	*/	
	public char [][] getTabTerm()
	{
		return tabTerm;
	}

	/**
	* Renvoie la tab bool utilisé dans ControlleurJeu pour le status des cases
	* @return bool
	*/
	public char [][] getBool()
	{
		return bool;
	}

	/**
	* Renvoie la taille d'un groupe utilisé dans ControlleurJeu
	* @return grp
	*/
	public double getGrp()
	{
		return grp;
	}
}