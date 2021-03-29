/**
* @version 1.0
* @author Shana LEFEVRE & Arthur DECORBEZ
*/

import javax.swing.*;
import java.awt.event.*;

// Necessary for file selection
import javax.swing.JFileChooser;

// Necessary for file selection & read file
import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
* Classe ControllerMenu qui gère les évènements de la classe Menu
* On peut choisir le mode de génération de la grille : aléatoire ou fichier
*/
public class ControllerMenu implements ActionListener
{
	private JFrame windows;

	/**
	* Constructeur ControlleurMenu
	*/
	public ControllerMenu(JFrame w)
	{
		this.windows = w;
	}

	/**
	* Méthode actionPerformed
	* Permet le control des boutons pour le mode de jeu
	*/
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();

		if(action.equals("Grille aléatoire"))
		{
			System.out.println("Select mode: Random");
			Plateau plateau = new Plateau("Random", null);
			this.windows.dispose();
			plateau.setVisible(true);
		}

		else if(action.equals("Ouvrir un fichier"))
		{
			System.out.println("Select mode: File");

			JFileChooser fileChooser = new JFileChooser(new File("./Grille"));
			fileChooser.setMultiSelectionEnabled(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("GRI File (.gri)", "gri");

			
			fileChooser.setFileFilter(filter);

			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnValue = fileChooser.showOpenDialog(null);

			if(returnValue == JFileChooser.APPROVE_OPTION)
			{
				//System.out.println("APPROVE_OPTION");

				File file = fileChooser.getSelectedFile();

				if(file.getName().endsWith(".gri"))
				{
					System.out.println("It's a .gri file !");
					
					Plateau plateau = new Plateau("File", file);
					this.windows.dispose();
					plateau.setVisible(true);
				}
				else
				{
					System.out.println("It's not a .gri file !");
				}
			}
		}
	}
}