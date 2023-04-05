package com.windows.controller;

import com.MainApplication;
import com.leewyatt.rxcontrols.controls.RXFillButton;
import com.windows.pages.IPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class ComponentNavigateController {

    @FXML
    private RXFillButton bnt_data;

    @FXML
    private RXFillButton bnt_rep;

    @FXML
    private RXFillButton bnt_turb;

    @FXML
    private RXFillButton bnt_user;

    @FXML
    void onBntData(ActionEvent event) {
    }

    @FXML
    void onBntRep(ActionEvent event) {

    }

    @FXML
    void onBntTurb(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/windows/PageWindFarm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        IPage.defaultStage.setScene(scene);
        System.out.println("ok");
        IPage.defaultStage.show();
    }

    @FXML
    void onBntUser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/windows/LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        IPage.defaultStage.setScene(scene);
        System.out.println("ok");
        IPage.defaultStage.show();
    }

}
