# MakeFile du Projet SameGame 
# Version Avril 2021
# By Arthur DECORBEZ & Shana LEFEVRE


### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS =


### REGLES ESSENTIELLES ###

Main.class : Main.java Menu.class
	${JC} ${JCFLAGS} Main.java

Menu.class : Menu.java Background.class ControllerMenu.class
	${JC} ${JCFLAGS} Menu.java

ControllerMenu.class : ControllerMenu.java Plateau.class
	${JC} ${JCFLAGS} ControllerMenu.java

Plateau.class : Plateau.java
	${JC} ${JCFLAGS} Plateau.java

Background.class : Background.java 
	${JC} ${JCFLAGS} Background.java


### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###