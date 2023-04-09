package com.windows.controller;

import com.system.data.UserData;
import com.system.entity.User;
import com.system.mysql.JDBC;
import com.windows.pages.impls.PageRegister;
import com.windows.pages.impls.PageWindFarm;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

import static com.windows.pages.IPage.defaultStage;

public class PageLoginController {

    @FXML
    private TextField account;

    @FXML
    private Label errorInfo;

    @FXML
    private TextField password;

    @FXML
    private Button sign_in;

    @FXML
    private Button sign_up;

    @FXML
    void doLogin() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select user, password, ifroot from user where ");
        stringBuilder.append("user = '").append(account.getText());
        stringBuilder.append("' and password = '").append(password.getText()).append("'");
        String sql = stringBuilder.toString();
        JDBC jdbc = JDBC.getDefault();
        List<UserData> users = jdbc.executeQuery(sql, UserData.class);
        if (users.size() == 0) {
            errorInfo.setText("账号或密码错误");
        } else {
            UserData user = users.get(0);
            User.user = user;
            if (user.getIfroot() == 1) {
                errorInfo.setText("管理员登录成功");
            } else {
                errorInfo.setText("普通用户登录成功");
            }
            new PageWindFarm().start(defaultStage);
        }
    }

    @FXML
    void doRegister() throws Exception {
        Thread.sleep(1500);
        new PageRegister().start(defaultStage);
    }

}
