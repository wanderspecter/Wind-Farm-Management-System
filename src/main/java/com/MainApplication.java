package com;

import com.windows.pages.IPage;
import com.windows.pages.impls.PageLogin;
import javafx.stage.Stage;

public class MainApplication extends IPage {
    public static void main(String[] args) {
        launch();
    }

    public static IPage iPage;

    @Override
    public void start(Stage stage) throws Exception {
        IPage.defaultStage = stage;
        defaultStage.setResizable(false);
        new PageLogin().start(defaultStage);
    }
}