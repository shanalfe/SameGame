import javax.swing.*;
import java.awt.event.*;

/**
* La classe <code>ControllerMenuFin</code> permet d'ajouter des évènements aux boutons du menu de fin.
*
* @version 1.0
* @author Shana LEFEVRE & Arthur DECORBEZ
*/
public class ControllerMenuFin implements ActionListener
{
	/**
	* Composante de la fenetre
	*/
	private JFrame windows;

	/**
	* Le constructeur est destiné à la création des constantes publiques.
	*
	* @param w variable de fenetre du jeu
	*/
	public ControllerMenuFin(JFrame w)
	{
		this.windows = w;
	}

	/**
	* La méthode permet de savoir ce que l'on fait suite à tel bouton cliqué.
	*/
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();

		if(action.equals("Rejouer"))
		{
			System.out.println("Partie relancée");
			Menu menu = new Menu();
			this.windows.dispose();
			menu.dispose();
			menu.setVisible(true);
		}
		else if(action.equals("Quitter"))
		{
			this.windows.dispose();
			System.exit(0);
		}
	}
}