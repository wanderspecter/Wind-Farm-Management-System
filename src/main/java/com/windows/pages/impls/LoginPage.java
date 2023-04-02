package com.windows.pages.impls;

import com.windows.pages.IPage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage extends IPage {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("/com/windows/LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        this.stage = stage;
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}