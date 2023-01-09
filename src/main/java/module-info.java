module com.example.assignmentnotepad {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.assignmentnotepad to javafx.fxml;
    exports com.example.assignmentnotepad;
}