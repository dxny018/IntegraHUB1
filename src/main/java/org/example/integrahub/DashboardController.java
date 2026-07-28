package org.example.integrahub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button btnSalir;

    @FXML
    protected void onModuloClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        System.out.println(">>> Módulo seleccionado: " + btn.getText());
    }

    @FXML
    protected void onSalirClick() {
        try {
            // Regresar a la pantalla de Inicio/Login
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            javafx.stage.Stage stage = (javafx.stage.Stage) btnSalir.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}