import java.util.Random;
import javax.swing.*;

/**
* La classe <code>GenerateurGrilleAleatoire</code> génère une grille aléatoire et associe les dessins correspondants.
*
* @version 1.0
* @author Shana LEFEVRE & Arthur DECORBEZ
*/
public class GenerateurGrilleAleatoire extends JPanel
{
	/**
	* Tableau qui représente la valeur d'une case d'un tableau.
	*/
	protected char[][] tabTerm;

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
	protected char[][] bool;

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
	*
	* @param score
	* @param fenetre
	* @see Plateau
	*/
	public GenerateurGrilleAleatoire (JLabel score, JFrame fenetre)
	{
		this.score = score;
		this.fenetre = fenetre;
	}



	/**
	* La méthode permet la génération de la grille aléatoire.
	*
	* @param panel
	* @see Menu
	*/
	public void TabAl(JPanel panel)
	{
		int i = 0;
		int j = 0;
		int randomVal = 0;
		char tabTerm[][] = new char[10][15];
		char bool[][] = new char[10][15];

		tab = new Bloc[10][15];

		this.jeu = panel;

		Random random = new Random();

		for(i = 0; i < 10; i ++)
		{
			for(j = 0; j < 15; j++)
			{
				randomVal = random.nextInt(3);

				if(randomVal == 0)
				{
					tabTerm[i][j] = 'R';

					tab[i][j] = new Salameche();
					jeu.add(tab[i][j]);
				}
				else if(randomVal == 1)
				{
					tabTerm[i][j] = 'B';

					tab[i][j] = new Carapuce();
					jeu.add(tab[i][j]);
				}

				else if(randomVal == 2)
				{
					tabTerm[i][j] = 'V';

					tab[i][j] = new Bulbi();
					jeu.add(tab[i][j]);
				}
			}
		}

		jeu.addMouseListener(new ControllerJeu (tab, tabTerm, bool, grp, score, fenetre));
	}



	/**
	* La méthode renvoie le tableau tab contenant les images correspondant à tabTerm.
	*
	* @return tab
	*/
	public Bloc[][] getTab()
	{
		return tab;
	}



	/**
	* La méthode renvoie le tableau tabTerm RVB du terminal.
	*
	* @return tabTerm
	*/	
	public char[][] getTabTerm()
	{
		return tabTerm;
	}



	/**
	* La méthoderRenvoie le tableau bool utilisé dans ControlleurJeu pour le status des cases.
	*
	* @return bool
	*/
	public char[][] getBool()
	{
		return bool;
	}



	/**
	* La méthode renvoie la taille d'un groupe.
	*
	* @return grp
	*/
	public double getGrp()
	{
		return grp;
	}
}