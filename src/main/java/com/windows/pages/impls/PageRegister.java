package com.windows.pages.impls;

import com.MainApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageRegister extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/windows/register.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome to WindFarm Management System!");
        stage.setScene(scene);
        stage.show();
    }
}
