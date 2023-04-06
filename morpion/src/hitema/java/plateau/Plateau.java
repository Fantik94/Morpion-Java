package hitema.java.plateau;

import hitema.java.morpion.Jeu;

public class Plateau {
    private char[][] grille;
    private int taille;

    public Plateau(int taille) {
        if (taille < 3) {
            taille = 3;
        } else if (taille > 9) {
            taille = 9;
        }
        this.taille = taille;
        grille = new char[taille][taille];
        initialiser();
    }

    public void initialiser() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = '-';
            }
        }
    }
    public void afficher() {
        // Affiche les numéros de colonne
        for (int j = 0; j < taille; j++) {
            System.out.print("  " + j + " ");
        }
        System.out.println();

        for (int i = 0; i < taille; i++) {
            // Affiche les lignes de séparation
            System.out.print(" ┌");
            for (int j = 0; j < taille - 1; j++) {
                System.out.print("───┬");
            }
            System.out.println("───┐");

            // Affiche les numéros de ligne et les cellules
            System.out.print(i + "│");
            for (int j = 0; j < taille; j++) {
                System.out.print(" " + grille[i][j] + " │");
            }
            System.out.println();
        }

        // Affiche la dernière ligne de séparation
        System.out.print(" └");
        for (int j = 0; j < taille - 1; j++) {
            System.out.print("───┴");
        }
        System.out.println("───┘");
    }



    public boolean placer(int x, int y, char symbole) {
        if (x < 0 || x >= taille || y < 0 || y >= taille || grille[x][y] != '-') {
            System.err.println("Position invalide ou déjà occupée, réessayer.");
            return false;
        }

        grille[x][y] = symbole;
        return true;
    }

    public boolean verifierVictoire(char symbole) {
        // Vérifie les lignes
        for (int i = 0; i < taille; i++) {
            boolean ligneComplete = true;
            for (int j = 0; j < taille; j++) {
                if (grille[i][j] != symbole) {
                    ligneComplete = false;
                    break;
                }
            }
            if (ligneComplete) {
                return true;
            }
        }

        // Vérifie les colonnes
        for (int i = 0; i < taille; i++) {
            boolean colonneComplete = true;
            for (int j = 0; j < taille; j++) {
                if (grille[j][i] != symbole) {
                    colonneComplete = false;
                    break;
                }
            }
            if (colonneComplete) {
                return true;
            }
        }

        // Vérifie la diagonale principale
        boolean diagonalePrincipale = true;
        for (int i = 0; i < taille; i++) {
            if (grille[i][i] != symbole) {
                diagonalePrincipale = false;
                break;
            }
        }
        if (diagonalePrincipale) {
            return true;
        }

        // Vérifie la diagonale secondaire
        boolean diagonaleSecondaire = true;
        for (int i = 0; i < taille; i++) {
            if (grille[i][taille - 1 - i] != symbole) {
                diagonaleSecondaire = false;
                break;
            }
        }
        if (diagonaleSecondaire) {
            return true;
        }

        return false;
    }


    public boolean estPlein() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (grille[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

}