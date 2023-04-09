package com.windows.controller;

import com.MainApplication;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.leewyatt.rxcontrols.controls.RXFillButton;
import com.system.utils.MyEventBus;
import com.windows.pages.IPage;
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
    private static final EventBus eventBus = MyEventBus.getDefault();

    public ComponentNavigateController() {
        MyEventBus.getDefault().register(this);
    }

    @FXML
    void onBntData() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/windows/PageManage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        IPage.defaultStage.setScene(scene);
        IPage.defaultStage.show();
        eventBus.post("manage");
    }

    @FXML
    void onBntRep() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/windows/PageRep.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        IPage.defaultStage.setScene(scene);
        IPage.defaultStage.show();
        eventBus.post("repair");
    }

    @FXML
    void onBntTurb() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/windows/PageWindFarm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        IPage.defaultStage.setScene(scene);
        IPage.defaultStage.show();
        eventBus.post("wind_farm");
    }

    @FXML
    void onBntUser() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/windows/PageUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        IPage.defaultStage.setScene(scene);
        IPage.defaultStage.show();
        eventBus.post("user");
    }

    @FXML
    private void initialize() {
        bnt_user.setFillType(RXFillButton.FillType.LEFT_TO_RIGHT);
    }

    @Subscribe()
    private void onMessageEvent(String message) {
        switch (message) {
            case "wind_farm":
                bnt_turb.setStyle("-fx-background-color: rgb(97, 109, 255); -fx-text-fill: white");
                break;
            case "manage":
                bnt_data.setStyle("-fx-background-color: rgb(97, 109, 255); -fx-text-fill: white");
                break;
            case "repair":
                bnt_rep.setStyle("-fx-background-color: rgb(97, 109, 255); -fx-text-fill: white");
                break;
            case "user":
                bnt_user.setStyle("-fx-background-color: rgb(97, 109, 255); -fx-text-fill: white");
                break;
            default:
                break;
        }
    }
}
