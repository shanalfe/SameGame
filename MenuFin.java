import java.awt.*;
import javax.swing.*;


public class MenuFin extends JFrame {
    /**
    * Constructeur de la classe Plateau
    * Initalisation de la fenetre
    */
    public MenuFin() {

        JFrame fenetre = new JFrame("~ SameGame ~");
        fenetre.setSize(800, 600);
        fenetre.setLocation(200, 200);
        fenetre.setResizable(false);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }
}

