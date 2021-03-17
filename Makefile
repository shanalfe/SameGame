# MakeFile du Projet SameGame 
# Version Avril 2021
# By Arthur DECORBEZ & Shana LEFEVRE


### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS =


### REGLES ESSENTIELLES ###
Bulbi.class : Bulbi.java
	${JC} ${JCFLAGS} Bulbi.java

Salameche.class : Salameche.java
	${JC} ${JCFLAGS} Salameche.java

Carapuce.class : Carapuce.java
	${JC} ${JCFLAGS} Carapuce.java

Main.class : Main.java Menu.class
	${JC} ${JCFLAGS} Main.java

Menu.class : Menu.java ControllerMenu.class
	${JC} ${JCFLAGS} Menu.java

ControllerMenu.class : ControllerMenu.java Plateau.class
	${JC} ${JCFLAGS} ControllerMenu.java

Plateau.class : Plateau.java GenerateurGrilleAleatoire.class
	${JC} ${JCFLAGS} Plateau.java

GenerateurGrilleAleatoire.class : GenerateurGrilleAleatoire.java
	${JC} ${JCFLAGS} GenerateurGrilleAleatoire.java




### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###