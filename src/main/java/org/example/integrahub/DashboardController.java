package org.example.integrahub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button btnSalir;

    @FXML
    private StackPane contentArea;

    private String moduloActual = "almacen";

    // 1. CARGA INICIAL (Evita que la pantalla empiece en blanco)
    @FXML
    public void initialize() {
        cargarVista("almacen_principal.fxml");
    }

    // 2. NAVEGACIÓN DEL MENÚ SUPERIOR
    @FXML
    protected void onModuloClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        moduloActual = btn.getText().toLowerCase();
        cargarVista(moduloActual + "_principal.fxml");
    }

    // 3. NAVEGACIÓN INTERNA (Botones de la izquierda)
    @FXML
    protected void onAbrirAgregarClick(ActionEvent event) {
        cargarVista(moduloActual + "_agregar.fxml");
    }

    @FXML
    protected void onAbrirEditarClick(ActionEvent event) {
        cargarVista(moduloActual + "_editar.fxml");
    }

    @FXML
    protected void onRegresarPrincipalClick(ActionEvent event) {
        cargarVista(moduloActual + "_principal.fxml");
    }

    // MÉTODO MAESTRO PARA INYECTAR LAS VISTAS
    private void cargarVista(String archivoFxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(archivoFxml));
            loader.setController(this); // Conecta la nueva vista a este mismo controlador
            Node vista = loader.load();
            contentArea.getChildren().clear();
            contentArea.getChildren().add(vista);
        } catch (IOException e) {
            System.err.println("Error: No se encontró el archivo " + archivoFxml + " en la carpeta resources.");
            e.printStackTrace();
        }
    }

    // 4. LÓGICA DE FORMULARIOS
    @FXML
    protected void onLimpiarClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        Parent contenedorFormulario = btn.getParent().getParent();
        limpiarCampos(contenedorFormulario);
    }

    private void limpiarCampos(Parent parent) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof TextField) {
                ((TextField) node).clear();
            } else if (node instanceof HBox || node instanceof VBox) {
                limpiarCampos((Parent) node);
            }
        }
    }

    @FXML
    protected void onGuardarClick(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Guardar Registro");
        alert.setHeaderText(null);
        alert.setContentText("Operación realizada con éxito.");
        alert.showAndWait();
    }

    @FXML
    protected void onSalirClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = (Stage) btnSalir.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}