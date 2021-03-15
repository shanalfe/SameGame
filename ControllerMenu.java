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


public class ControllerMenu implements ActionListener {

    
    private JFrame windows;

    public ControllerMenu(JFrame w) {
		this.windows = w;
	}
    
    public void actionPerformed(ActionEvent e){
			
		String action = e.getActionCommand();
	
		if(action.equals("Grille aléatoire")){
			System.out.println("Jeu séléctionné : Grille aléatoire");
            this.windows.dispose();
            Plateau windows = new Plateau();
            windows.IniGrilleAl();
      
        }

		else if(action.equals("Ouvrir un fichier")){
			System.out.println("Jeu séléctionné : Ouvrir un fichier");
           
        
        }

	}

 
}

