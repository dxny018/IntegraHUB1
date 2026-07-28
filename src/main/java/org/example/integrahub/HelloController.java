package org.example.integrahub;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    // Referencias a los botones mediante fx:id
    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnModoConsulta;

    @FXML
    private Button btnAsistencia;

    // Métodos asociados a los 'On Action' de Scene Builder
    @FXML
    protected void onIniciarSesionClick() {
        System.out.println(">>> Clic detectado: Abrir Iniciar Sesión");
        try {
            // Cargar la vista de Login
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);

            // Obtener la ventana actual y cambiar a la pantalla de Login
            Stage stage = (Stage) btnIniciarSesion.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onModoConsultaClick() {
        System.out.println(">>> Clic detectado: Entrar a Modo Consulta");
        // Aquí conectaremos la ventana de Consulta
    }

    @FXML
    protected void onMarcarEntradaSalidaClick() {
        System.out.println(">>> Clic detectado: Registrar Entrada/Salida");
        // Aquí conectaremos la ventana de Asistencia
    }
}