/**
*<b>La classe Fenetre permet la création de la fenetre du jeu et elle intègre le menu</b>
*
* @version1
* @author Arthur DECORBEZ & Shana LEFEVRE
*/

import java.awt.*;
import javax.swing.*;


public class Fenetre extends JFrame {
  	/**
	* Création de la fenetre et ajout du controller
	*/
    public Fenetre () {
    	super ("SameGame");
    	this.setSize (800,600);
	  	this.setLocation (200,200);
		this.setResizable(false);
		//this.add(new Fond(""));
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
		/**
		 * Appel de la classe MouseFenetreControl qui permettra le controle du menu
		 */
		MouseFenetreControl control = new MouseFenetreControl (this);
		this.addMouseListener(control);
  	}

}
