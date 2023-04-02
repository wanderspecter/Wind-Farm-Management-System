module com.system.windfarm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com to javafx.fxml;
    opens com.windows to javafx.fxml;
    exports com;
    // exports com.windows;
    exports com.windows.pages;
    exports com.windows.controller;
    opens com.windows.controller to javafx.fxml;
    exports com.windows.pages.impls;
}