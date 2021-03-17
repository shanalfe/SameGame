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

Menu.class : Menu.java Background.class ControllerMenu.class
	${JC} ${JCFLAGS} Menu.java

Background.class : Background.java 
	${JC} ${JCFLAGS} Background.java

ControllerMenu.class : ControllerMenu.java Plateau.class 
	${JC} ${JCFLAGS} ControllerMenu.java



Plateau.class : Plateau.java Bloc.class Salameche.class Bulbi.class Carapuce.class
	${JC} ${JCFLAGS} Plateau.java

Bloc.class : Bloc.java Salameche.class Bulbi.class Carapuce.class
	${JC} ${JCFLAGS} Bloc.java







### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###