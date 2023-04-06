package hitema.java.joueur;



public class Joueur {
    private char symbole;

    public Joueur(char symbole) {
        this.symbole = symbole;
    }

    public char getSymbole() {
        return symbole;
    }

    public int[] demanderPosition() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int x, y;
        boolean error = false;
        while (true) {
            if (error){
                System.out.flush();
                System.out.println("Position invalide, veuillez réessayer.");
                error =false;
            }
            else {
                System.out.print("Entrez la ligne (0-2): ");
                x = scanner.nextInt();
                System.out.print("Entrez la colonne (0-2): ");
                y = scanner.nextInt();

                if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                    break;
                } else {
                    error = true;
                }
            }
        }
        return new int[]{x, y};
    }
}
