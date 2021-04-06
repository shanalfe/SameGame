import java.awt.*;
import javax.swing.*;

/**
* La classe <code>Menu</code> permet la création du menu.
*
* @version 1.0
* @author Shana LEFEVRE & Arthur DECORBEZ
*/
public class Menu extends JFrame
{
	/**
	* Le constructeur créé la fenetre Menu avec ses différents boutons.
	*/
	public Menu()
	{
		super();
		this.setTitle("~ SameGame ~");
		this.setSize (800, 600);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setIconImage(new ImageIcon(getClass().getResource("./Image/icon.png")).getImage());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panneau des boutons
		JPanel bouton = new JPanel();
		bouton.setBackground(Color.GRAY);
		this.add(bouton, BorderLayout.SOUTH);

		// Panneau image de fond
		JPanel fond = new JPanel();		
		JLabel image = new JLabel(new ImageIcon("./Image/startMenuBackground.jpg"));
		fond.add(image);
		this.add(fond, BorderLayout.CENTER);

		// Bouton aléatoire
		JButton jeuAlea = new JButton("Grille aléatoire");
		jeuAlea.setPreferredSize(new Dimension(200, 50));
		jeuAlea.setBackground(new Color(35, 95, 165));
		jeuAlea.setForeground(Color.WHITE);
		jeuAlea.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));

		// Bouton fichier	
		JButton jeuFichier = new JButton("Ouvrir un fichier");
		jeuFichier.setPreferredSize(new Dimension(200, 50));
		jeuFichier.setBackground(new Color(35, 95, 165));
		jeuFichier.setForeground(Color.WHITE);
		jeuFichier.setBorder (BorderFactory.createLineBorder(Color.ORANGE, 5));

		// Appel du controlleur menu
		ControllerMenu controlleurMenu = new ControllerMenu(this);
		jeuFichier.addActionListener(controlleurMenu);
		jeuAlea.addActionListener(controlleurMenu);

		bouton.add(jeuAlea);
		bouton.add(jeuFichier);
	}
}