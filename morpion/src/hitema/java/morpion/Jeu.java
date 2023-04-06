package hitema.java.morpion;

import hitema.java.joueur.Joueur;
import hitema.java.plateau.Plateau;

public class Jeu {
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;

    public Jeu() {
        plateau = new Plateau();
        joueur1 = new Joueur('X');
        joueur2 = new Joueur('O');
    }

    public void lancer() {
        Joueur joueurActuel = joueur1;
        boolean fin = false;
        while (!fin) {
            plateau.afficher();
            System.out.println("C'est au tour du joueur " + joueurActuel.getSymbole() + " :");
            int[] position = joueurActuel.demanderPosition();
            try {
                plateau.placer(position[0], position[1], joueurActuel.getSymbole());
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
                continue;
            }
            if (plateau.verifierVictoire(joueurActuel.getSymbole())) {
                System.out.println("Le joueur " + joueurActuel.getSymbole() + " a gagné !");
                fin = true;
            } else if (plateau.Plein()) {
                System.out.println("Match nul !");
                fin = true;
            } else {
                joueurActuel = (joueurActuel == joueur1) ? joueur2 : joueur1;
            }
        }
        plateau.afficher();
    }

}

