open module com.system.windfarm {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires com.google.common;
    requires rxcontrols;
    requires com.jfoenix;
    requires easyexcel.core;
    requires slf4j.simple;
    requires org.slf4j;

    exports com;
    exports com.windows.pages;
    exports com.windows.controller;
    // opens com.windows.controller to javafx.fxml;
    exports com.windows.pages.impls;
    exports com.system.data;
    exports com.system;
}