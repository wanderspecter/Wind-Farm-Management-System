package com;

import com.windows.pages.IPage;
import com.windows.pages.impls.PageUser;
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
        // LoginPage loginPage = new LoginPage();
        // loginPage.start(stage);
        //PageWindFarm pageWindFarm = new PageWindFarm();
        //pageWindFarm.start(defaultStage);
        PageUser pageUser = new PageUser();
        pageUser.start(defaultStage);
    }
}