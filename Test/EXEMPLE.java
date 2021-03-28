/**
 * La classe <code>ControllerMouse</code> est le controller de la fenetre
 * principale du jeu. Cette classe gere les clics et la disposition des objets
 * dans la grille
 * @version 0.1
 * @author Morgan Jully et Killian Mocret
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.*;
import java.io.*;

public class ControllerMouse implements MouseListener {

	/**
	* Attribut pour récuperer la fenetre du jeu
	*/
    private Frame fenetre;

	/**
	* Tableau d'objet qui correspond aux objets de la grille
	* quand le joueur choisit de jouer avec une
	* grille aletoire
	*/
    private Couleur[][] tab;

    /**
	* Tableau qui correspond au tablaux d'objet mais avec des
	* entiers (1 = vert, 2 = bleu, 3 = rouge)
	*/
    private int[][] tabi;
    /**
    * Tableau d entier qui stocke le groupe survol&eacute;
    * par l utilisateur
    * -2 signifie que la case est vide
    */
    private int[][] groupe;
    /**
    * Attribut qui stocke la taille des groupes
    * -1 signifie que la case d'appartient pas au groupe
    */
    private int taille_groupe = 0;
    /**
	* Attribut qui stocke le score actuel
    */
    private int score=0;
    /**
    * Objet de la classe Score qui affiche un label
    * avec le score
    */
    private Score scoreL = new Score();
    /**
    * Attribut qui permet de savoir le nombre de clics après
    * la fin du jeu
    */
    private int click = 0;
    private JLabel test = new JLabel("");

    /**
    * Constructeur qui ajoute un ecouteur de la classe ControllerMouse
    * sur tout les objets du tableaux d objets tab
    * @param f qui permet de recuperer les 2 tableaux
    */
    public ControllerMouse(Frame f) {
	// groupe = new int[10][15];
	this.fenetre = f;
	this.tab = f.getTab();
	this.tabi = f.getTabi();
	
	
	
	for (int i=0; i<10; i++) {
	    for (int j=0; j<15; j++) {
		this.tab[i][j].addMouseListener(this);
		this.tab[i][j].setBackground(Color.WHITE);
		groupe[i][j] = -1;
	    }
	}
	
	
	JPanel t = new JPanel();
	Font font = new Font("TYPE1_FONT", Font.BOLD, 33);
	this.test.setFont(font);
	this.fenetre.add(t, BorderLayout.NORTH);
	t.setBackground(Color.WHITE);
	t.add(this.scoreL);
	t.add(test);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    	int fin=1;
    	if((Couleur.getFin())) {
    		this.click++;
    		if(this.click>=2) {
    		this.fenetre.dispose();
	    for (int i=0; i<10; i++) {
	    	for (int j=0; j<15; j++) {
	    		if(tabi[i][j] != -2) {
	    			fin = 0;
	    		}
	    	}
	    }
	    if(fin==0) {
	    	Couleur.setFin(false);
	    	MenuFin menu = new MenuFin("/img/lose.png", this.score);
	    } else {
	    	MenuFin menu = new MenuFin("/img/win.png", this.score);
	    	Couleur.setFin(false);
	    }
    	}
    	}
    }

    /*Séléction taille du groupe*/

    @Override
    public void mouseEntered(MouseEvent e) {
	for (int i=0; i<10; i++) {
	    for (int j=0; j<15; j++) {
			if((e.getSource() == this.tab[i][j]) && (this.tabi[i][j]!=-2)) {
		    	this.tab[i][j].setBackground(Color.YELLOW);
		    	Radar(i,j);
		    	System.out.println("Taille groupe : " + this.taille_groupe);
		   		for (i=0; i<10; i++) {
					for (j=0; j<15; j++) {
			    		if((storage[i][j]!=-1) && (this.tabi[i][j] != -2)) {
							this.tab[i][j].setBackground(Color.YELLOW);
			    		}
					}
		    	}
			}
	  	}
	}
}
	/**
	* Methode qui permet reprer le groupe de bloc en
	* fonction du bloc survole
	* @param x : indice x du bloc survole
	* @param y : indice y du bloc survole
	*/
    public void Radar(int x, int y) {

	if(y>0) {
	    if((this.tabi[x][y] == this.tabi[x][y-1]) && (this.tabi[x][y] != -2)) {

        if((isInGroup(x,y-1))) { //permet de recliquer sur le meme endroit pour un autre groupe
  		    this.storage[x][y-1] = this.tabi[x][y-1];
  		    this.taille_groupe++;
  		    Radar(x, y-1);

		    }
	    }
	}

	if(y+1<15) {
	    if((this.tabi[x][y] == this.tabi[x][y+1]) && (this.tabi[x][y] != -2)) {
		if((isInGroup(x,y+1))) {
		    this.storage[x][y+1] = this.tabi[x][y+1];
		    this.taille_groupe++;
		    Radar(x, y+1);
		}
	    }
	}
	if(x>0) {
	    if((this.tabi[x][y] == this.tabi[x-1][y]) && (this.tabi[x][y] != -2)) {
		if((isInGroup(x-1, y))) {
		    this.storage[x-1][y] = this.tabi[x-1][y];
		    this.taille_groupe++;
		    Radar(x-1, y);
		}
	    }
	}

	if(x+1<10) {
	    if((this.tabi[x][y] == this.tabi[x+1][y]) && (this.tabi[x][y] != -2)) {
		if((isInGroup(x+1, y))) {
		    this.storage[x+1][y] = this.tabi[x+1][y];
		    this.taille_groupe++;
		    Radar(x+1, y);
		}
	    }
	}
    }

    @Override
    public void mouseExited(MouseEvent e) {
	for (int i=0; i<10; i++) {
	    for (int j=0; j<15; j++) {
		this.tab[i][j].setBackground(Color.WHITE);
		this.groupe[i][j] = -1;
	    }
	}
	this.taille_groupe = 0;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
    /**
    * Methode qui vérifie si le bloc n a pas
    * deja ete ajout&eacute; dans le tableau
    * groupe
    * @param x : indice x du bloc
    * @param y : indice y du bloc
	*/
    public boolean isInGroup(int x, int y) {
	for (int i=0; i<10; i++) {
	    for (int j=0; j<15; j++) {
		if(groupe[x][y] == tabi[i][j])
		    return false;
	    }
	}
	return true;
    }


    @Override
    public void mouseReleased(MouseEvent e) {
	int tgroupe=0;
	for(int i=0;i<10;i++) {
	    System.out.println("");
	    for (int j=0; j<15; j++) {
		if(this.groupe[i][j]!=-1) {
		    this.tab[i][j].setBackground(Color.WHITE);
		    this.tab[i][j].resetCouleur();
		    this.tab[i][j].setCouleur(0);
		    this.tabi[i][j] = -2;
		    this.groupe[i][j] = -1;
		    tgroupe++;

		}
		reorganiseColonne(j);
		System.out.print(tabi[i][j] + " ");
	    }
	}

	if(tgroupe >2){
	    this.score += (tgroupe-2)*(tgroupe-2);
	    this.scoreL.setScore(this.score);
	    System.out.println();
	    System.out.println("Score : " + this.score);
	}
	for (int i=0; i<15; i++) {
	    checkTouteColonneVide();
	}
	System.out.println("");
	if(checkJeuFin() == 1){
		Couleur.setFin(true);
		this.fenetre.repaint();
		this.test.setText(" | Cliquez pour continuer");
	    this.fenetre.addMouseListener(this);


	}
    }
    /**
    * Methode qui reorganise la colonne en bouchant les blocs libres
    * @param j : la colonne a reorganiser
    */
    public void reorganiseColonne(int j) {

	for (int i=9; i>0; i--) {
	    if(this.tabi[i][j] == -2) {
	    	int couleur = this.tabi[i-1][j];
	    	this.tab[i-1][j].resetCouleur();
	    	this.tab[i-1][j].setCouleur(0);
	    	this.tabi[i-1][j] = -2;
	    	this.tab[i][j].resetCouleur();
	    	this.tab[i][j].setCouleur(couleur);
	    	this.tabi[i][j] = couleur;
	    }
	}
    }
    /**
    * Methode qui verifie si chaque colonne est vide
    * et si oui copie les colonnes de droite vers la gauche
    */
    public void checkTouteColonneVide() {
	int result = 0;
	for (int i=0; i<15; i++) {
	    result = checkSiUneColonnesVide(i);
	    if((result == 1) && (i!=14)) {
		copieColonne(i);
		result = 0;
	    }
	}
    }
    /**
    *Methode qui verifie si une colonne est vide
    * @param j : la colonne a verifie
    */
    public int checkSiUneColonnesVide(int j) {
	int var = 1;
	for (int i=0; i<10; i++) {
	    if(this.tabi[i][j] !=-2)
		var = 0;
	}
	if(j==14)
	    var=0;
	return var;
    }
    /**
    * Methode qui deplace une colonne vers la gauche
    * @param j : la colonne a copie
    */
    public void copieColonne(int j) {
	for (int i=0; i<10; i++) {

		int couleur = this.tabi[i][j+1];
		this.tabi[i][j+1] = -2;
		this.tab[i][j+1].resetCouleur();
		this.tab[i][j+1].setCouleur(0);
		this.tabi[i][j] = couleur;
		this.tab[i][j].resetCouleur();
		this.tab[i][j].setCouleur(couleur);
	}
    }
    /**
    * Methode qui veirife si la partie est fini
    */
    public int checkJeuFin() {
	this.taille_groupe = 0;
	int fin = 1;
	for (int i=0; i<10; i++) {
	    for (int j=0; j<15; j++) {
			Radar(i,j);
		if(this.taille_groupe != 0)
		    fin = 0;
	    }
	}
	for (int i=0; i<10; i++) {
	    for (int j=0; j<15; j++) {
			groupe[i][j] = -1;
	    }
	}
	return fin;
    }
}

