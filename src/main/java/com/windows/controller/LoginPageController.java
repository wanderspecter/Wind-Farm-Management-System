package com.windows.controller;

import com.windows.pages.IPage;
import com.windows.pages.impls.MainPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class LoginPageController {
    @FXML
    private Button loginButton;
    @FXML
    private AnchorPane anchorPane;

    public void clickLogin(ActionEvent actionEvent) throws Exception {
        IPage.changePage(new MainPage());
    }

}
