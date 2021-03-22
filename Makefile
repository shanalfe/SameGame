# MakeFile du Projet SameGame 
# Version Avril 2021
# By Arthur DECORBEZ & Shana LEFEVRE


### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS =


### REGLES ESSENTIELLES ###
Bulbi.class : Bulbi.java Bloc.class
	${JC} ${JCFLAGS} Bulbi.java

Salameche.class : Salameche.java Bloc.class
	${JC} ${JCFLAGS} Salameche.java

Carapuce.class : Carapuce.java Bloc.class
	${JC} ${JCFLAGS} Carapuce.java

Main.class : Main.java Menu.class
	${JC} ${JCFLAGS} Main.java

Menu.class : Menu.java ControllerMenu.class 
	${JC} ${JCFLAGS} Menu.java

ControllerMenu.class : ControllerMenu.java Plateau.class LectureGrille.class
	${JC} ${JCFLAGS} ControllerMenu.java

Plateau.class : Plateau.java GenerateurGrilleAleatoire.class Score.class
	${JC} ${JCFLAGS} Plateau.java

LectureGrille.class : LectureGrille.java 
	${JC} ${JCFLAGS} LectureGrille.java

ControllerJeu.class : ControllerJeu.java Score.class
	${JC} ${JCFLAGS} ControllerJeu.java

GenerateurGrilleAleatoire.class : GenerateurGrilleAleatoire.java Bulbi.class Salameche.class Carapuce.class ControllerJeu.class
	${JC} ${JCFLAGS} GenerateurGrilleAleatoire.java

Bloc.class : Bloc.java 
	${JC} ${JCFLAGS} Bloc.java

Score.class : Score.java
	${JC} ${JCFLAGS} Score.java








### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###