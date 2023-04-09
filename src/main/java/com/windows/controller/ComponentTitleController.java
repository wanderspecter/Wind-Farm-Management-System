package com.windows.controller;

import com.google.common.eventbus.Subscribe;
import com.system.utils.MyEventBus;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ComponentTitleController {
    public static String finalTime = "2021-08-08";
    public static String nowTime = "2021-08-08";
    @FXML
    private Label time;

    @FXML
    void initialize() {
        MyEventBus.getDefault().register(this);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    nowTime = new SimpleDateFormat(finalTime + " HH:mm:ss").format(new Date());
                    time.setText(nowTime);
                });
            }
        }, 0, 1000);
    }

    @Subscribe
    private void changeTime(Integer message) {
        switch (message) {
            case 1:
                finalTime = "2021-11-02";
                break;
            case 2:
                finalTime = "2022-03-13";
                break;
            case 0:
                finalTime = "2021-08-08";
                break;
            default:
                break;
        }
    }
}
