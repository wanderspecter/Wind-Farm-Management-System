package com;

import com.windows.pages.IPage;
import javafx.stage.Stage;

public class MainApplication extends IPage {
    public static void main(String[] args) {
        launch();
    }

    public static IPage iPage;

    @Override
    public void start(Stage stage) throws Exception {
        // MainApplication.stage = stage;

        //changePage(new LoginPage()); // 启动页
    }

}