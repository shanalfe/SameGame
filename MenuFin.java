import java.awt.*;
import javax.swing.*;

/** 
* La classe <code>MenuFin</code> permet de générer le menu de fin et propose au joueur de rejouer ou bien de quitter le jeu.
*
* @version 1.0
* @author Shana LEFEVRE & Arthur DECORBEZ 
*/
public class MenuFin extends JFrame
{
	/*
	* Composante du JLabel du score
	*/
	public JLabel score;

	/**
	* Composante du score
	*/
	private double resultat;

	/**
	* Le construteur permet la création du menu de fin avec les différents panneaux, boutons...
	*
	* @param resultat Score total du joueur.
	* @see ControllerJeu
	*/
	public MenuFin(double resultat)
	{
		super();
		this.resultat = resultat;
		this.setTitle("~ SameGame ~");
		this.setSize(800, 600);
		this.setLocation(200, 200);
		this.setIconImage(new ImageIcon(getClass().getResource("./Image/icon.png")).getImage());
		this.setResizable(false);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panneau des scores
		JPanel info = new JPanel();
		this.add(info, BorderLayout.NORTH);
		info.setBackground(Color.GRAY);

		JLabel score = new JLabel ("Score total : " +(int)this.resultat);		   
		Font police = new Font("Chilanka", Font.BOLD, 25);
		score.setFont(police);
		info.add(score);

		// Paneau bouton
		JPanel bouton = new JPanel();
        bouton.setBackground(Color.GRAY);
		this.add(bouton, BorderLayout.SOUTH);

		// Panneau fond 
		JPanel fond = new JPanel();	 
		JLabel image = new JLabel(new ImageIcon("./Image/endMenuBackground.jpg"));
		fond.add(image);
		this.add(fond, BorderLayout.CENTER);

		// Stylisation des boutons
		JButton rejouer = new JButton("Rejouer");
		rejouer.setPreferredSize(new Dimension(200, 50));
		rejouer.setBackground(new Color(35, 95, 165));
		rejouer.setForeground(Color.WHITE);
		rejouer.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));		
		bouton.add(rejouer);
			
		JButton quitter = new JButton("Quitter");
		quitter.setPreferredSize(new Dimension(200, 50));
		quitter.setBackground(new Color(35, 95, 165));
		quitter.setForeground(Color.WHITE);
		quitter.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
		bouton.add(quitter);

		// Appel du controlleur 
		ControllerMenuFin controllerMenuFin = new ControllerMenuFin(this);
		rejouer.addActionListener(controllerMenuFin);
		quitter.addActionListener(controllerMenuFin);
	}
}