import java.awt.*;
import javax.swing.*;

/**
 * Classe Bloc qui permet l'ajout du bloc au chiffre random
 * généré par la classe Plateau
 * Respectivement :
 * 1 = rouge
 * 2 = bleu
 * 3 = vert
 * 
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 */

public class Bloc extends JPanel {

    /**Déclaration de variables */
    protected Image imageBloc;
    protected char color;

    /**Constructeur de Bloc */
    public Bloc () {
        super ();
    }

    @Override

	public void paintComponent(Graphics c) {
        
        Graphics secondPinceau = c.create();

		if (this.isOpaque()) {	    	
	    	secondPinceau.setColor(this.getBackground());
	    	secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		}

        
        if(this.color == 1) {
			Image imageBloc = getToolkit().getImage(this.getClass().getResource("/Image/Pokémon/004_opt.png"));
			secondPinceau.drawImage(imageBloc, 0, 0, this);
		}

        if (this.color == 2){
            Image imageBloc = getToolkit().getImage(this.getClass().getResource("/Image/Pokémon/007_opt.png"));
			secondPinceau.drawImage(imageBloc, 0, 0, this);            
        }

        if (this.color == 3){
            Image imageBloc = getToolkit().getImage(this.getClass().getResource("/Image/Pokémon/001_opt.png"));
			secondPinceau.drawImage(imageBloc, 0, 0, this);
        }
    
    }
    
}
