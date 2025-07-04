package com.ejemplo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class MenuController {

    private double saldo = 1000.0;

    @FXML
    public void consultarSaldo() {
        mostrarAlerta("Consulta de Saldo", "Tu saldo es: $" + String.format("%.2f", saldo));
    }

    @FXML
    public void depositar() {
        Optional<String> input = pedirCantidad("Depósito", "¿Cuánto deseas depositar?");
        input.ifPresent(valor -> {
            try {
                double cantidad = Double.parseDouble(valor);
                if (cantidad > 0) {
                    saldo += cantidad;
                    mostrarAlerta("Depósito exitoso", "Nuevo saldo: $" + saldo);
                } else {
                    mostrarAlerta("Error", "Cantidad inválida.");
                }
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "Número inválido.");
            }
        });
    }

    @FXML
    public void retirar() {
        Optional<String> input = pedirCantidad("Retiro", "¿Cuánto deseas retirar?");
        input.ifPresent(valor -> {
            try {
                double cantidad = Double.parseDouble(valor);
                if (cantidad > 0 && cantidad <= saldo) {
                    saldo -= cantidad;
                    mostrarAlerta("Retiro exitoso", "Nuevo saldo: $" + saldo);
                } else if (cantidad > saldo) {
                    mostrarAlerta("Error", "Fondos insuficientes.");
                } else {
                    mostrarAlerta("Error", "Cantidad inválida.");
                }
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "Número inválido.");
            }
        });
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private Optional<String> pedirCantidad(String titulo, String mensaje) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titulo);
        dialog.setHeaderText(null);
        dialog.setContentText(mensaje);
        return dialog.showAndWait();
    }
}
