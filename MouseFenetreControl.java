/**
 * Classe MouseFenetreControl qui gère les évènements de la classe Fenetre
 * @version 1.0
 * @author Arthur DECORBEZ & Shana LEFEVRE
 * 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class MouseFenetreControl implements MouseListener {
    
    private JFrame windows;

    public MouseFenetreControl (JFrame w) {
        this.windows = w;
    }

    /** Création de plusieurs methode sinon cela ne fonctionne pas */
    public void mouseClicked(MouseEvent evenement) {
    }  

    public void mouseExited(MouseEvent evenement) {
    }

    public void mouseEntered(MouseEvent evenement) {
    }

    public void mouseReleased(MouseEvent evenement){
    }

    public void mousePressed(MouseEvent evenement){
    }


    // Evenement clique bouton menu

}

