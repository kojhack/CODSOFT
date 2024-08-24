import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        NumberGame jeu = new NumberGame();
        jeu.lancerJeu();

    }

    public void lancerJeu() {

        Scanner sc = new Scanner(System.in);
        boolean jouerEncore;
        int total = 0;
        int partieJoue = 0;

        do {
            int nombreADeviner = genererNombreAleatoire(1, 100);
            int tentatives = 0;
            int maxTentatives = 5;
            int score = 100;
            boolean reponse = false;

            System.out.println("Nouvelle partie ! Vous avez " + maxTentatives + " tentatives pour deviner le nombre.");

            while (!reponse && tentatives < maxTentatives) {
                int utilisateurTrouve = getUtilisateurTrouve();
                reponse = compareTrouve(utilisateurTrouve, nombreADeviner);
                tentatives++;

                if (!reponse && tentatives < maxTentatives) {
                    score -= 10;
                    System.out.println("Il vous reste " + (maxTentatives - tentatives) + " tentative(s).");
                }
            }

            if (reponse) {
                System.out.println("Vous avez gagné " + score + "points cette partie !");
                total += score;
            } else {
                System.out.println("Vous avez épuisé toutes vos tentatives. La réponse était : " + nombreADeviner);
            }

            partieJoue++;
            System.out.println("Voulez-vous rejouer ? (Oui/Non) : ");
            jouerEncore = sc.next().equalsIgnoreCase("Oui");

        }while (jouerEncore);

        System.out.println("C'était un bon jeu !");
        System.out.println("Vous avez joué " + partieJoue + " partie(s) avec un score total de " + total + " points.");


    }

    public int genererNombreAleatoire(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1 ) + min;
    }

    public int getUtilisateurTrouve() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nombre à deviner : ");
        return sc.nextInt();
    }

    public boolean compareTrouve(int trouve, int reponseExact) {
        if (trouve > reponseExact) {
            System.out.println("Trop grand !");
            return false;
        } else if (trouve < reponseExact) {
            System.out.println("Trop petit !");
            return false;

        } else {
            System.out.println("Félicitations vous avez deviné le nombre exact !");
            return true;
        }
    }
}