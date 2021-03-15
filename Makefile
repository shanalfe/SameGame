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

Menu.class : Menu.java ControllerMenu.class
	${JC} ${JCFLAGS} Menu.java




### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###
