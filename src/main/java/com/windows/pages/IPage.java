package com.windows.pages;

import javafx.application.Application;
import javafx.stage.Stage;

public abstract class IPage extends Application {
    public Stage stage;

    public static void changePage(IPage iPage) throws Exception {
        iPage.start(new Stage());
    }

//    public void changePage(Stage stage, IPage iPage) throws Exception {
//        iPage.start(stage);
//    }
//    public void changePage(Stage stage, IPage iPage) throws Exception {
//        iPage.start(stage);
//    }

    public abstract void start(Stage stage) throws Exception;
}
