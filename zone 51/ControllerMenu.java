/**
 * Classe ControllerMenu qui gère les évènements de la classe Menu
 * On peut choisir le mode de génération de la grille : aléatoire ou fichier
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Necessary for file selection
import javax.swing.JFileChooser;
import java.io.File;

public class ControllerMenu implements ActionListener
{
	// private JFrame windows;

	// public ControllerMenu(JFrame w)
	// {
	// 	this.windows = w;
	// }

	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();

		if(action.equals("Grille aléatoire"))
		{
			System.out.println("Select mode: Random");
			this.windows.dispose();
			Plateau windows = new Plateau();
			windows.IniGrilleAl();
            // ControllerJeu control = new ControllerJeu (windows);
            // windows.addMouseListener (control);
		}

		else if(action.equals("Ouvrir un fichier"))
		{
			System.out.println("Select mode: File");

			JFileChooser importFile = new JFileChooser();
			importFile.setMultiSelectionEnabled(false);
			int res = importFile.showOpenDialog(null);
			File f = null;

			if(res == JFileChooser.APPROVE_OPTION)
			{
				f = importFile.getSelectedFile();
				System.out.println("Name of file select : " + f.getName());

				if(f.getName().endsWith(".gri"))
				{
					System.out.println("Valid extension");
				}
				else
				{
					System.out.println("Invalid extension");
					JOptionPane.showMessageDialog(null, "Please select a file with the extension .gri", "Invalid extension", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		}
	}
}