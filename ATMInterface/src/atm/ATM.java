package atm;

public class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void withdraw(double montant) {
        bankAccount.retrait(montant);
    }

    public void depot(double montant) {
        bankAccount.depot(montant);
    }

    public void checkBalance() {
        System.out.println("Solde courant: " + bankAccount.getSolde());
    }
}
