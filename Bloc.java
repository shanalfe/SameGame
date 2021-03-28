import java.awt.*;
import javax.swing.*;

/**
 * Classe <code>Bloc</code> qui déssine les blocs en fonction de sa correspondance
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 */

public class Bloc extends JPanel {

    /**
    * Création des images qui représentent chacune un bloc
    */
    protected Image imageBloc;
    /**
    * Représente la couleur d'un bloc en fonction d'une image
    */
    protected char color;


    /**
     * Constructeur de Bloc 
     */
    public Bloc () {
        super ();
    }

    @Override

    /**
    * Permet la génération des images selon la couleur
    */
	public void paintComponent(Graphics c) {
        
        Graphics secondPinceau = c.create();

		if (this.isOpaque()) {	

	    	secondPinceau.setColor(this.getBackground());
	    	secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
        
        if(this.color == 'R') {

			Image imageBloc = getToolkit().getImage(this.getClass().getResource("/Image/Pokémon/004_opt.png"));
			secondPinceau.drawImage(imageBloc, 0, 0, this);
		}

        if (this.color == 'B'){

            Image imageBloc = getToolkit().getImage(this.getClass().getResource("/Image/Pokémon/007_opt.png"));
			secondPinceau.drawImage(imageBloc, 0, 0, this);            
        }

        if (this.color == 'V'){

            Image imageBloc = getToolkit().getImage(this.getClass().getResource("/Image/Pokémon/001_opt.png"));
			secondPinceau.drawImage(imageBloc, 0, 0, this);
        }

        if (this.color == 'b') {

            secondPinceau.setColor(Color.WHITE);
            secondPinceau.drawOval(0, 0, 50, 50);
            secondPinceau.fillOval(0, 0, 50, 50);
        
        }

    
    }


    /**
    *   Permet de réinitialiser le bloc
    */
    public void ResetBloc () {
        this.color = 'b';
    }


    /**
    *  Permet de changer le type du bloc à x et y position
    * @param c Prend en argument la couleur
    */
    public void ChangerBloc (char c) {
        this.color = c;
        this.repaint ();
    }



   

}
