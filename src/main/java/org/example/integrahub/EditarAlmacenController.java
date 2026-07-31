package org.example.integrahub;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EditarAlmacenController {

    @FXML private TextField txtBuscarId;
    @FXML private TextField txtIdAlmacen;
    @FXML private TextField txtZona;
    @FXML private TextField txtPisos;
    @FXML private TextField txtDireccion;

    @FXML private Button btnGuardar;
    @FXML private Button btnSalir;

    // Al presionar Enter en el buscador de ID
    @FXML
    protected void onBuscarClick() {
        String idBuscado = txtBuscarId.getText().trim();

        if (!idBuscado.isEmpty()) {
            System.out.println(">>> Buscando elemento con ID: " + idBuscado);

            // Cargar datos de prueba y habilitar edición de campos
            txtIdAlmacen.setText(idBuscado);
            txtZona.setText("Zona Norte");
            txtPisos.setText("3");
            txtDireccion.setText("Av. Central #102");

            // Desbloquear campos para permitir edición
            setCamposBloqueados(false);
        }
    }

    // Método auxiliar para bloquear/desbloquear los campos
    private void setCamposBloqueados(boolean bloqueado) {
        txtIdAlmacen.setDisable(bloqueado);
        txtZona.setDisable(bloqueado);
        txtPisos.setDisable(bloqueado);
        txtDireccion.setDisable(bloqueado);
    }

    @FXML
    protected void onGuardarClick() {
        if (!txtIdAlmacen.isDisable()) {
            System.out.println(">>> Guardando cambios del Almacén ID: " + txtIdAlmacen.getText());
            System.out.println("   Zona: " + txtZona.getText() + ", Pisos: " + txtPisos.getText() + ", Dir: " + txtDireccion.getText());

            // Regresar al Dashboard al guardar
            regresarDashboard();
        } else {
            System.out.println(">>> Debes buscar un ID válido antes de guardar.");
        }
    }

    @FXML
    protected void onSalirClick() {
        regresarDashboard();
    }

    private void regresarDashboard() {
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