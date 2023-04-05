package com.windows.controller;

import com.windows.pages.impls.PageMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginPageController {
    @FXML
    private Button loginButton;
    @FXML
    private AnchorPane anchorPane;

    public void clickLogin(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        new PageMain().start(stage);
    }

}
