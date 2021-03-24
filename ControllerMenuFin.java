/**
* @version 1.0
* @author Shana LEFEVRE & Arthur DECORBEZ
*/

import javax.swing.*;
import java.awt.event.*;


public class ControllerMenuFin implements ActionListener {

	private JFrame windows;


	public ControllerMenuFin (JFrame w)	{

		this.windows = w;

	}

	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand();

		if(action.equals("Rejouer")) {

			System.out.println("Partie relancée");
			Menu menu = new Menu ();
			this.windows.dispose();
			menu.dispose();
			menu.setVisible(true);

		}

		else if(action.equals("Quitter")) {

			this.windows.dispose();
			System.exit (0);
		}
	}

}