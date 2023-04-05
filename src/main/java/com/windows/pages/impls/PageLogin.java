package com.windows.pages.impls;

import com.windows.pages.IPage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PageLogin extends IPage {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PageLogin.class.getResource("/com/windows/LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        defaultStage.setTitle("Hello!");
        defaultStage.setScene(scene);
        defaultStage.show();
    }
}