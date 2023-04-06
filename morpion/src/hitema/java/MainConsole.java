package hitema.java;

import hitema.java.morpion.Jeu;

import static hitema.java.morpion.Jeu.demanderTaille;


public class MainConsole {
    public static void main(String[] args) {
        int taille = demanderTaille();
        Jeu jeu = new Jeu(taille);
        jeu.lancer();
    }
}



