import javax.swing.*;
import java.io.*;

/**
* La classe <code>LectureGrille</code> lit le fichier choisi, met les valeurs du fichier dans un tableau et associe les dessins correspondants.
*
* @version 1.0
* @author Shana LEFEVRE & Arthur DECORBEZ
*/
public class LectureGrille extends JPanel
{
	/**
	* Tableau qui représente la valeur d'une case d'un tableau.
	*/
	protected char [][] tabTerm;

	/**
	* Composante du JPanel du jeu.
	*/
	private JPanel jeu;

	/**
	* Composante du JFrame de la fenetre.
	*/
	private JFrame fenetre;

	/**
	* Tableau qui affiche les blocs.
	*/
	protected Bloc[][] tab;

	/**
	* Tableau qui représente le statut d'une case.
	*/
	protected char [][] bool;

	/**
	* Taille d'un groupe.
	*/
	protected double grp = 0;

	/**
	* Composante du JLabel du score.
	*/
	public JLabel score;



	/**
	* Le constructueur appelle la fenetre et le JLabel du score. 
	*/
	public LectureGrille (JLabel score, JFrame fenetre)
	{
		this.score = score;
		this.fenetre = fenetre;
	}



	/**
	* La méthode permet la lecture du fichier choisie ainsi que la transformation des données lu en tableau.
	* @param panel
	* @param file
	* @see Menu
	* @see Plateau
	*/
	public void tabGrille (JPanel panel, File file)
	{
		int i = 0; 
		int j = 0;
		char tabTerm[][] = new char[10][15];
		char bool[][] = new char [10][15];

		tab = new Bloc[10][15];

		this.jeu = panel;

		try
		{
			FileReader reader = new FileReader(file);

			try
			{
				for(i = 0; i < 10; i++)
				{
					for(j = 0; j < 15; j++)
					{
						tabTerm[i][j] = (char) reader.read();
					}

					reader.read();
				}

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
	* La méthode renvoie le tableau tab contenant les images correspondant à tabTerm.
	* @return tab
	*/
	public Bloc[][] getTab()
	{
		return tab;
	}



	/**
	* La méthode renvoie le tableau tabTerm RVB du terminal.
	* @return tabTerm
	*/	
	public char [][] getTabTerm()
	{
		return tabTerm;
	}



	/**
	* La méthoderRenvoie le tableau bool utilisé dans ControlleurJeu pour le status des cases.
	* @return bool
	*/
	public char [][] getBool()
	{
		return bool;
	}



	/**
	* La méthode renvoie la taille d'un groupe.
	* @return grp
	*/
	public double getGrp()
	{
		return grp;
	}
}