package com.windows.controller;

import com.MainApplication;
import com.system.mysql.JDBC;
import com.windows.pages.impls.PageLogin;
import com.windows.pages.impls.PageWindFarm;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PageRegisterController {

    @FXML
    private TextField account;

    @FXML
    private Button cancel;

    @FXML
    private Label info;

    @FXML
    private TextField password;

    @FXML
    private Button register;

    @FXML
    void onCancel() throws Exception {
        Thread.sleep(1500);
        new PageLogin().start(MainApplication.defaultStage);
    }

    @FXML
    void onRegister() {
        StringBuilder str = new StringBuilder().append("INSERT INTO user(user, password, ifroot) VALUES (").append(account.getText())
                .append(",").append(password.getText()).append(",").append(0).append(");");
        String sql = str.toString();
        try {
            JDBC.getDefault().CUDSql(sql);
            info.setText("注册成功");
            new PageWindFarm().start(MainApplication.defaultStage);
        } catch (Exception e) {
            info.setText("注册失败，请重试");
            throw new RuntimeException(e);
        }
    }
}
