module org.example.integrahub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.integrahub to javafx.fxml;
    exports org.example.integrahub;
}