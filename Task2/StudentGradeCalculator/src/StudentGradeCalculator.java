import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
            StudentGradeCalculator calculator = new StudentGradeCalculator();
            calculator.start();
    }

    public void start() {
        int nombreDeMatieres = getNombreDeMatieres();
        int[] note = getNote(nombreDeMatieres);
        int notesTotal = calculerNoteTotal(note);
        double moyennePourcentage = calculerMoyennePourcentage(notesTotal, nombreDeMatieres);
        char grade = calculerGrade(moyennePourcentage);
        afficherResultats(notesTotal, moyennePourcentage, grade);
    }

    public int getNombreDeMatieres() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nombre de matières : ");
        return sc.nextInt();
    }

    public int[] getNote(int nombreDeMatieres) {
        Scanner sc = new Scanner(System.in);
        int[] notes = new int[nombreDeMatieres];

        for (int i = 0; i < nombreDeMatieres; i++) {
            System.out.println("Entrez les notes dans la matière " + (i + 1) + " : ");
            notes[i] = sc.nextInt();
        }


        return notes;
    }

    public int calculerNoteTotal(int[] notes) {
        int total = 0;
        for (int note : notes) {
            total += note;
        }

        return total;
    }

    public double calculerMoyennePourcentage(int noteTotal, int nombreDeMatieres) {
        return (double) noteTotal / nombreDeMatieres;
    }

    public char calculerGrade(double moyennePourcentage) {
        if(moyennePourcentage >= 90) {
            return 'A';
        } else if (moyennePourcentage >= 80) {
            return 'B';

        } else if (moyennePourcentage >= 70) {
            return 'C';

        } else if (moyennePourcentage >= 60) {
            return 'D';

        } else {
            return 'F';

        }
    }

    public void afficherResultats(int noteTotal, double moyennePourcentage, char grade) {

        System.out.println("Notes totales : " + noteTotal);
        System.out.println("Pourcentage moyen : " + moyennePourcentage);
        System.out.println("Grade attribuée : " + grade);
    }
}