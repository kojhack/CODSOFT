package atm;

public class BankAccount {

    private double solde ;

    public BankAccount(double solde) {
        this.solde = solde;
    }

    public void depot(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Depôt réussi! Nouveau Solde: " + solde);
        } else {
            System.out.println("Montant  du dépôt doit être positif.");
        }
    }

    public void retrait(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println("Retrait réussi! Nouveau Solde: " + solde);
        } else {
            System.out.println("Solde insuffisant ou montant invalide.");
        }
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
