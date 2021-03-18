import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
*Classe Menu
* Permet l'intégration du menu
*
* @version1
* @author Arthur DECORBEZ & Shana LEFEVRE
*/
public class Menu extends JFrame {

  	/**
	* Constructeur Menu
	*	Création de la fenetre Menu avec ses boutons
	*/
    public Menu () {
    	
    	super ();
		this.setTitle ("SameGame");
    	this.setSize (800,600);
	  	this.setLocation (200,200);
		this.setResizable(false);
		
		this.setVisible(true);
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		  /**Paneau bouton */
	  	JPanel bouton = new JPanel();
		bouton.setBackground(Color.GRAY);
	  	this.add (bouton, BorderLayout.SOUTH);
		
		  /**Panneau fond */
		JPanel fond = new JPanel();		
		JLabel image = new JLabel( new ImageIcon( "salameche.jpg"));
		fond.add(image);
		this.add (fond, BorderLayout.CENTER);
	
		
		JButton jeuAlea = new JButton("Grille aléatoire");
		jeuAlea.setPreferredSize(new Dimension(200,50));
		jeuAlea.setBackground (Color.RED);
		jeuAlea.setForeground (Color.WHITE);
		jeuAlea.setBorder (BorderFactory.createLineBorder(Color.ORANGE,5));
			
		JButton jeuFichier = new JButton ("Ouvrir un fichier");
		jeuFichier.setPreferredSize(new Dimension(200,50));
		jeuFichier.setBackground (Color.RED);
		jeuFichier.setForeground (Color.WHITE);
		jeuFichier.setBorder (BorderFactory.createLineBorder(Color.ORANGE,5));
	
		/**
		 * Appel de la classe ControllerMenu
		 * 	Gestion des événements
		 */
		ControllerMenu a = new ControllerMenu (this);
		jeuFichier.addActionListener(a);
		jeuAlea.addActionListener (a);

		bouton.add (jeuAlea);
		bouton.add (jeuFichier);

  	}


}
