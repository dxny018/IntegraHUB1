package org.example.integrahub;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField txtIdUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnIngresar;

    @FXML
    protected void onRegresarClick() {
        try {
            // Regresar a la pantalla principal
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = (Stage) btnRegresar.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onIngresarClick() {
        String usuario = txtIdUsuario.getText();
        String password = txtPassword.getText();

        System.out.println("Intentando ingresar con Usuario: " + usuario);

        try {
            // Cargar el Dashboard principal
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 850, 550);

            Stage stage = (Stage) btnIngresar.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen(); // Centra la ventana al cambiar de tamaño
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}