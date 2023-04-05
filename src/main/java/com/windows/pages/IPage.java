package com.windows.pages;

import javafx.application.Application;
import javafx.stage.Stage;

public abstract class IPage extends Application {
    public static Stage defaultStage;

    public static void newPage(IPage iPage) throws Exception {
        iPage.start(new Stage());
    }

    public abstract void start(Stage stage) throws Exception;

}
