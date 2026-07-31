package org.example.integrahub;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FormularioAlmacenController {

    @FXML private TextField txtIdAlmacen;
    @FXML private TextField txtZona;
    @FXML private TextField txtPisos;
    @FXML private TextField txtDireccion;

    @FXML private Button btnGuardar;
    @FXML private Button btnLimpiar;
    @FXML private Button btnSalir;

    // GUARDAR: Almacena el nuevo registro (por ahora imprime en consola y limpia)
    @FXML
    protected void onGuardarClick() {
        String id = txtIdAlmacen.getText();
        String zona = txtZona.getText();
        String pisos = txtPisos.getText();
        String direccion = txtDireccion.getText();

        System.out.println(">>> Guardando Almacén: ID=" + id + ", Zona=" + zona + ", Pisos=" + pisos + ", Dir=" + direccion);

        // Limpiamos los campos al guardar
        onLimpiarClick();
    }

    // LIMPIAR CAMPOS: Vacía los textos ingresados para capturar de nuevo
    @FXML
    protected void onLimpiarClick() {
        txtIdAlmacen.clear();
        txtZona.clear();
        txtPisos.clear();
        txtDireccion.clear();
    }

    // SALIR: Cancela el proceso y regresa a la pantalla anterior (Dashboard)
    @FXML
    protected void onSalirClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 850, 550);
            Stage stage = (Stage) btnSalir.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}