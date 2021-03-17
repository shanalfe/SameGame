import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
*La classe Menu intègre le menu
*
* @version1
* @author Arthur DECORBEZ & Shana LEFEVRE
*/


public class Menu extends JFrame {

  	/**
	* Création du constructeur Menu
	*	
	*/
    public Menu () {
    	
    	super ("SameGame");
    	this.setSize (800,600);
	  	this.setLocation (200,200);
		this.setResizable(false);
		
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	  	JPanel fond = new JPanel();
	  	this.add (fond, BorderLayout.CENTER);

		
		JButton jeuAlea = new JButton("Grille aléatoire");
		// jeuAlea.setBounds(100,400,200,70);
		jeuAlea.setBackground (Color.RED);
		jeuAlea.setForeground (Color.WHITE);
		jeuAlea.setBorder (BorderFactory.createLineBorder(Color.ORANGE,5));
			
		JButton jeuFichier = new JButton ("Ouvrir un fichier");
		// jeuFichier.setBounds (500,400,200,70);
		jeuFichier.setBackground (Color.RED);
		jeuFichier.setForeground (Color.WHITE);
		jeuFichier.setBorder (BorderFactory.createLineBorder(Color.ORANGE,5));
	
		/**
		 * Appel de la classe ControllerMenu
		 */
		ControllerMenu a = new ControllerMenu (this);
		jeuFichier.addActionListener(a);
		jeuAlea.addActionListener (a);

		fond.add (jeuAlea);
		fond.add (jeuFichier);

  	}


}
