import java.awt.*;
import javax.swing.*;



/** 
* Classe MenuFin
*/
public class MenuFin extends JFrame {

   
    
    /**
    * Constructeur MenuFin
    *   Menu fin du jeu
    */
    public MenuFin() {

            
        super ();
        this.setTitle ("SameGame");
        this.setSize (800,600);
        this.setLocation (200,200);
        this.setResizable(false);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Paneau bouton
        JPanel boutton = new JPanel ();
        this.add (boutton, BorderLayout.SOUTH);

       
        // Panneau fond 
        JPanel fond = new JPanel();     
        JLabel image = new JLabel( new ImageIcon( "salameche.jpg"));
        fond.add(image);
        this.add (fond, BorderLayout.CENTER);
    
        
        JButton rejouer = new JButton("Rejouer");
        rejouer.setPreferredSize(new Dimension(200,50));
        rejouer.setBackground (Color.RED);
        rejouer.setForeground (Color.WHITE);
        rejouer.setBorder (BorderFactory.createLineBorder(Color.ORANGE,5));        
        boutton.add (rejouer);

            
        JButton quitter = new JButton ("Quitter");
        quitter.setPreferredSize(new Dimension(200,50));
        quitter.setBackground (Color.RED);
        quitter.setForeground (Color.WHITE);
        quitter.setBorder (BorderFactory.createLineBorder(Color.ORANGE,5));
        boutton.add (quitter);
    
        
        /**
         * Appel de la classe ControllerMenuFin
         *  Gestion des événements
         */
        ControllerMenuFin a = new ControllerMenuFin (this);
        rejouer.addActionListener(a);
        quitter.addActionListener (a);

    }
}

