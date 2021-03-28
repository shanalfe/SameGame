import java.awt.*;
import javax.swing.*;



/** 
* Classe MenuFin
*/
public class MenuFin extends JFrame {

   public JLabel score;
   private double resultat;
    
    /**
    * Constructeur MenuFin
    *   Menu fin du jeu
    */
    public MenuFin(double resultat) {
            
        super ();
        this.resultat = resultat;
        this.setTitle ("SameGame");
        this.setSize (800,600);
        this.setLocation (200,200);
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
        info.add (score);


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

