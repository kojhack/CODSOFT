package atm;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ATMApp extends Application {
    private ATM atm;
    private BankAccount account;

    @Override
    public void start(Stage primaryStage) {
        // Initialiser le compte et l'ATM
        account = new BankAccount(1000); // Solde initial
        atm = new ATM(account);

        // Créer les éléments de l'interface
        Label balanceLabel = new Label(new StringBuilder().append("Solde courant: ").append(atm.checkBalance()).toString());
        TextField amountField = new TextField();
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button checkBalanceButton = new Button("Check Balance");

        // Définir les gestionnaires d'événements
        depositButton.setOnAction(e -> {
            double amount = Double.parseDouble(amountField.getText());
            atm.depot(amount);
            balanceLabel.setText("Solde courant: " + atm.checkBalance());
        });

        withdrawButton.setOnAction(e -> {
            double amount = Double.parseDouble(amountField.getText());
            atm.withdraw(amount);
            balanceLabel.setText("Solde courant: " + atm.checkBalance());
        });

        checkBalanceButton.setOnAction(e -> {
            balanceLabel.setText("Solde courant: " + atm.checkBalance());
        });

        // Disposer les éléments
        VBox layout = new VBox(10);
        layout.getChildren().addAll(amountField, depositButton, withdrawButton, checkBalanceButton, balanceLabel);

        // Créer et afficher la scène
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ATM Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

