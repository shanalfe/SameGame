
import java.awt.*;
import javax.swing.*;
import javax.swing.JComponent;
import java.awt.Graphics;

 

public class Background extends JComponent {
    
    private Image background;


    public Background (String s) {
		super();
        this.background = getToolkit().getImage(this.getClass().getResource(s));
    }


	public void paintComponent(Graphics c) {

		Graphics p = c.create();
		
        if (this.isOpaque()) {

      		c.setColor(this.getBackground());
      		c.fillRect(0, 0, this.getWidth(), this.getHeight());
    	}
    
		p.drawImage(this.background, 0, 0, this.getWidth(), this.getHeight(), this);

    	
	}


}
