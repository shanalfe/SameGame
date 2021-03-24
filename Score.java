import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>Score</code> 
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 */



public class Score extends JLabel {
	
	private double score;
	
	
	/**
	* Constructeur 
	*/
	 public Score() {
	 	super();
	 	
		Font font = new Font("Chilanka", Font.BOLD, 25);
		this.setFont(font);
		this.setText("Score : " + this.score);
	 }


	/**
	* Methode ChangerScore
	*/
	public void ChangerScore (double s) {

		this.score = s;
		this.setText("Score : " + this.score);
	}
}