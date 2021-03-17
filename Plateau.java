import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Plateau extends JFrame {

    public Plateau () {    
       
        JFrame fenetre = new JFrame();
        fenetre.setSize (800,600);
        fenetre.setLocation (200,200);
        fenetre.setResizable(false);
        fenetre.setLayout (null);
        fenetre.setTitle("SameGame");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible (true);
   
    }

}