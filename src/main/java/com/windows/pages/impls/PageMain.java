package com.windows.pages.impls;

import com.MainApplication;
import com.windows.pages.IPage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageMain extends IPage {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/windows/MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome to WindFarm Management System!");
        stage.setScene(scene);
        stage.show();
    }
}
