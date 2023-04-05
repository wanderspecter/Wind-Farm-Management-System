package com.windows.controller;

import com.jfoenix.controls.JFXButton;
import com.leewyatt.rxcontrols.controls.RXLineButton;
import com.system.data.UserData;
import com.system.mysql.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.List;

public class ComponentUserController {

    public static UserData selectedItem;
    private final ObservableList<UserData> data = FXCollections.observableArrayList();
    @FXML
    private String all;
    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private TextField condition;
    @FXML
    private RXLineButton delete;
    @FXML
    private TableColumn<UserData, Integer> ifroot;
    @FXML
    private JFXButton new_clear;
    @FXML
    private JFXButton new_create;
    @FXML
    private CheckBox new_ifroot;
    @FXML
    private TextField new_password;
    @FXML
    private TextField new_user;
    @FXML
    private TableColumn<UserData, String> password;
    @FXML
    private JFXButton select;
    @FXML
    private CheckBox select_ifroot;
    @FXML
    private TextField select_password;
    @FXML
    private TextField select_user;
    @FXML
    private TableView<UserData> table;
    @FXML
    private RXLineButton update;
    @FXML
    private TableColumn<UserData, String> user;

    @FXML
    void onDeleteButton(ActionEvent event) throws Exception {
        JDBC jdbc = JDBC.getDefault();
        String sql = String.format("delete from user " +
                "WHERE user = \'%s\' ", selectedItem.getUser());
        System.out.println(sql);
        jdbc.CUDSql(sql);
        queryAllUser();
        new_user.setText("");
        new_password.setText("");
        new_ifroot.setSelected(false);
    }

    @FXML
    void onNewClearButton(ActionEvent event) {
        new_user.setText("");
        new_password.setText("");
        new_ifroot.setSelected(false);
    }

    @FXML
    void onNewCreateButton(ActionEvent event) throws Exception {
        JDBC jdbc = JDBC.getDefault();
        String sql = "INSERT INTO user(user, password, ifroot) VALUES (\'" + new_user.getText() + "\',\'" + new_password.getText() + "\'," + (new_ifroot.isSelected() ? "1" : "0") + ")";
        System.out.println(sql);
        jdbc.CUDSql(sql);
        queryAllUser();
    }

    @FXML
    void onSelectButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        String strChoice = choice.getValue();
        String sql = "select user, password, ifroot from user where ";
        if (strChoice.equals("全部")) {
            queryAllUser();
            return;
        } else if (strChoice.equals(ifroot)) {
            sql = sql + strChoice + " =" + condition.getText();
        } else {
            String strCondition = condition.getText();
            sql = sql + strChoice + " =" + "\'" + strCondition + "\'";
        }
        JDBC jdbc = JDBC.getDefault();
        List<UserData> userDataList = jdbc.executeQuery(sql, UserData.class);
        data.clear();
        for (UserData userData : userDataList) {
            data.add(userData);
        }
        table.setItems(data);
    }

    @FXML
    void onUpdateButton(ActionEvent event) throws Exception {
        JDBC jdbc = JDBC.getDefault();
        String sql = String.format("UPDATE user SET user = \'%s\', password = \'%s\', " +
                "ifroot=%s where user = \'%s\'", select_user.getText(), select_password.getText(), (select_ifroot.isSelected() ? "1" : "0"), selectedItem.getUser());
        System.out.println(sql);
        jdbc.CUDSql(sql);
        queryAllUser();
    }

    @FXML
    void showSelected(MouseEvent event) {
        selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            select_user.setText("");
            select_password.setText("");
            select_ifroot.setSelected(false);
        } else {
            select_user.setText(selectedItem.getUser());
            select_password.setText(selectedItem.getPassword());
            select_ifroot.setSelected((selectedItem.getIfroot() == 1 ? true : false));
        }
    }

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        ifroot.setCellValueFactory(new PropertyValueFactory<>("ifroot"));

        choice.setValue(all);

        queryAllUser();
    }

    private void queryAllUser() throws SQLException, ClassNotFoundException {
        data.clear();
        JDBC jdbc = JDBC.getDefault();
        String sql = "select user, password, ifroot from user";
        List<UserData> userDataList = jdbc.executeQuery(sql, UserData.class);
        for (UserData userData : userDataList) {
            data.add(userData);
        }
        table.setItems(data);
    }
}
