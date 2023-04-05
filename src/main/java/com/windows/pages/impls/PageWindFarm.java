package com.windows.pages.impls;

import com.MainApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageWindFarm extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/windows/PageWindFarm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome to WindFarm Management System!");
        stage.setScene(scene);
        stage.show();
    }
}
