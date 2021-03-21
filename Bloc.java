import java.awt.*;
import javax.swing.*;

/**
 * Classe <code>Bloc</code> 
 *  Déssine les blocs en fonction de sa correspondance
 * 
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 */

public class Bloc extends JPanel {

    /**Déclaration de variables */
    protected Image imageBloc;
    protected char color;


    /**
     * Constructeur de Bloc 
     */
    public Bloc () {
        super ();
    }

    @Override

    /**
     * Méthode paintComponent
     *  Génère les images pour blocs selon la classe GenerateurGrilleAleatoire
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
    * Méthode ResetBloc
    *   Permet de réinitialiser la couleur
    */
    public void ResetBloc (){
        this.color = 'b';
    }


    /**
    * Méthode ChangerBloc
    *   Permet de changer le type du bloc à x,y position
    */
    public void ChangerBloc (char c){
        this.color = c;
        this.repaint ();
    }



   

}
