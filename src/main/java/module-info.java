module com.example.tejerina_zapico_ruslan_practica_02 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;

    opens com.example.tejerina_zapico_ruslan_practica_02 to javafx.fxml;
    exports com.example.tejerina_zapico_ruslan_practica_02;
}