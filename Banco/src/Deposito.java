package com.example.banco;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DepositoVentana{
    public static void show() {
        Stage ventana = new Stage();
        ventana.setTitle("Deposito");

        Label lblTitulo     = new Label("Ingrese el monto a divir");
        TextField txtDeposito   = new TextField();
        Button btnDepositar   = new Button("Depositar");
        Label lblResultado  = new Label("solo se pueden ingresar numeros");

        btnDepositar.setOnAction(e -> {
            try {
                double txtDepositos = Double.parseDouble(txtDeposito.getText());
                Depositar operacion = new Depositar(txtDepositos);

                if (textDeposito <= 0) {
                    lblResultado.setText("El monto a depositar tiene que ser mayor a 0");
                } else if (textDeposito )
                { else {
                    double resultado = operacion.dividir(num1, num2);
                    lblResultado.setText("Se ha depositado " + txtDepositos + " correctamente");
                }
            } catch (NumberFormatException ex) {
                lblResultado.setText("Ingresa valores numéricos");
            }
        });

        VBox layout = new VBox(10, lblTitulo, txtDeposito, btnDepositar, lblResultado);
        layout.setPadding(new Insets(15));

        Scene escena = new Scene(layout, 350, 250);

        escena.getStylesheets().add(
                DivisionWindow.class.getResource("/src/main/resources/Styles/EstiloDivision.css").toExternalForm()
        );

        ventana.setScene(escena);
        ventana.show();
    }
}