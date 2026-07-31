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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DashboardController {

    @FXML
    private Button btnSalir;

    @FXML
    private StackPane contentArea;

    private String moduloActual = "almacen";

    // Caché en memoria para guardar las vistas cargadas y evitar recargarlas del disco
    private final Map<String, Node> cacheVistas = new HashMap<>();

    // 1. CARGA INICIAL
    @FXML
    public void initialize() {
        cargarVista("almacen_principal.fxml");

        // Destaca el botón "Almacén" visualmente desde que abre la app
        destacarBotonInicial();
    }

    // 2. NAVEGACIÓN DEL MENÚ SUPERIOR
    @FXML
    protected void onModuloClick(ActionEvent event) {
        Button btn = (Button) event.getSource();

        // 1. Actualiza el color del botón seleccionado
        actualizarEstiloBotonesNavegacion(btn);

        // 2. Obtiene el nombre del módulo
        Object userData = btn.getUserData();
        if (userData != null) {
            moduloActual = userData.toString();
        } else {
            moduloActual = btn.getText().toLowerCase().replaceAll("\\s+", "");
        }

        // 3. Carga la vista correspondiente
        cargarVista(moduloActual + "_principal.fxml");
    }

    // MÉTODO PARA GESTIONAR EL COLOR Y ESTILO DEL BOTÓN SELECCIONADO
    private void actualizarEstiloBotonesNavegacion(Button btnActivo) {
        // Puedes cambiar estos valores Hexadecimales si tus colores exactos en Scene Builder son diferentes:
        String estiloNormal = "-fx-background-color: #178A96; -fx-text-fill: white; -fx-background-radius: 15;";
        String estiloActivo = "-fx-background-color: #3BB5C4; -fx-text-fill: #000000; -fx-background-radius: 15; -fx-font-weight: bold;";

        if (btnActivo != null && btnActivo.getParent() instanceof Parent) {
            Parent contenedorPadre = btnActivo.getParent();

            // Recorre todos los botones dentro del menú superior
            for (Node node : contenedorPadre.getChildrenUnmodifiable()) {
                if (node instanceof Button) {
                    Button btn = (Button) node;

                    // Restablece el estilo normal a todos, EXCEPTO al botón Salir
                    if (btn != btnSalir) {
                        btn.setStyle(estiloNormal);
                    }
                }
            }
        }

        // Aplica el estilo destacado solo al botón al que diste clic (y que no sea Salir)
        if (btnActivo != btnSalir) {
            btnActivo.setStyle(estiloActivo);
        }
    }

    // Busca y destaca el botón inicial ("almacen") cuando arranca la ventana
    private void destacarBotonInicial() {
        if (btnSalir != null && btnSalir.getParent() instanceof Parent) {
            Parent padre = btnSalir.getParent();
            for (Node node : padre.getChildrenUnmodifiable()) {
                if (node instanceof Button && node != btnSalir) {
                    Button btn = (Button) node;
                    Object userData = btn.getUserData();
                    String nombre = (userData != null) ? userData.toString() : btn.getText().toLowerCase();

                    if (nombre.contains("almacen")) {
                        actualizarEstiloBotonesNavegacion(btn);
                        break;
                    }
                }
            }
        }
    }

    // 3. NAVEGACIÓN INTERNA
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

    // MÉTODO MAESTRO PARA INYECTAR LAS VISTAS CON CACHÉ
    private void cargarVista(String archivoFxml) {
        // Si ya está guardada en la RAM, la muestra al instante
        if (cacheVistas.containsKey(archivoFxml)) {
            contentArea.getChildren().setAll(cacheVistas.get(archivoFxml));
            return;
        }

        URL fxmlUrl = getClass().getResource(archivoFxml);

        if (fxmlUrl == null) {
            System.err.println("Error: No se encontró el archivo " + archivoFxml + " en la carpeta resources.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            loader.setController(this);
            Node vista = loader.load();

            // La guardamos en el mapa para los siguientes clics
            cacheVistas.put(archivoFxml, vista);

            contentArea.getChildren().setAll(vista);
        } catch (IOException e) {
            System.err.println("Error al cargar la vista " + archivoFxml);
            e.printStackTrace();
        }
    }

    // 4. LÓGICA DE FORMULARIOS
    @FXML
    protected void onLimpiarClick(ActionEvent event) {
        if (!contentArea.getChildren().isEmpty()) {
            Node vistaActual = contentArea.getChildren().get(0);
            if (vistaActual instanceof Parent) {
                limpiarCampos((Parent) vistaActual);
            }
        }
    }

    private void limpiarCampos(Parent parent) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof TextField) {
                ((TextField) node).clear();
            } else if (node instanceof Parent) {
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