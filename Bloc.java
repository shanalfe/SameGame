import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>Bloc</code> qui dessine les blocs en fonction de sa correspondance.
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 */
public class Bloc extends JPanel {

    /**
    * Composante des images qui représentent chacune un bloc.
    */
    protected Image imageBloc;
    /**
    * Composante de la couleur d'un bloc en fonction d'une image.
    */
    protected char color;


    /**
     * Le constructeur destiné à d'appeler les méthodes de la classe parent.
     */
    public Bloc () {

        super ();
    }

    @Override

    /**
    * La méthode permet la génération des images selon la couleur.
    * @param c 
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
    *  La méthode permet de réinitialiser le bloc.
    */
    public void ResetBloc () {

        this.color = 'b';
    }


    /**
    *  La méthode permet de changer le type du bloc à x et y position.
    * @param c prend en argument la couleur.
    */
    public void ChangerBloc (char c) {

        this.color = c;
        this.repaint ();
    }
   

}
