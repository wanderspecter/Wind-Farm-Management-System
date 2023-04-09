package com.windows.controller;

import com.jfoenix.controls.JFXButton;
import com.leewyatt.rxcontrols.controls.RXLineButton;
import com.system.data.RepData;
import com.system.mysql.JDBC;
import com.system.utils.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class ComponentRepController {

    private static RepData selectedItem;
    private final ObservableList<RepData> data = FXCollections.observableArrayList();
    @FXML
    private String all;
    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private TableColumn<RepData, String> code;
    @FXML
    private TextField condition;
    @FXML
    private RXLineButton delete;
    @FXML
    private TableColumn<RepData, String> message;
    @FXML
    private JFXButton new_clear;
    @FXML
    private TextField new_code;
    @FXML
    private JFXButton new_create;
    @FXML
    private TextField new_message;
    @FXML
    private TextField new_status;
    @FXML
    private TextField new_time;
    @FXML
    private JFXButton select;
    @FXML
    private TextField select_code;
    @FXML
    private TextField select_message;
    @FXML
    private TextField select_status;
    @FXML
    private TextField select_time;
    @FXML
    private TableColumn<RepData, String> status;
    @FXML
    private TableView<RepData> table;
    @FXML
    private TableColumn<RepData, String> time;
    @FXML
    private RXLineButton update;

    @FXML
    private JFXButton gen;


    @FXML
    void onDeleteButton(ActionEvent event) throws Exception {
        JDBC jdbc = JDBC.getDefault();
        String sql = String.format("delete from repair " +
                "WHERE time = \'%s\' ", selectedItem.getTime());
        System.out.println(sql);
        jdbc.CUDSql(sql);
        queryAll();
        select_time.setText("");
        select_code.setText("");
        select_status.setText("");
        select_message.setText("");
    }

    @FXML
    void onNewClearButton(ActionEvent event) {
        new_time.setText("");
        new_code.setText("");
        new_status.setText("");
        new_message.setText("");
    }

    @FXML
    void onNewCreateButton(ActionEvent event) throws Exception {
        JDBC jdbc = JDBC.getDefault();
        String sql = "INSERT INTO repair(time, code, status, message) VALUES (\'" + new_time.getText() + "\',\'" + new_code.getText() + "\',\'" + new_status.getText() + "\',\'" + new_message.getText() + "\')";
        System.out.println(sql);
        jdbc.CUDSql(sql);
        queryAll();
    }

    @FXML
    void onSelectButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        String strChoice = choice.getValue();
        String sql = "select time, code, status, message from repair where ";
        if (strChoice.equals("全部")) {
            queryAll();
            return;
        } else {
            String strCondition = condition.getText();
            sql = sql + strChoice + "=" + "\'" + strCondition + "\'";
        }

        JDBC jdbc = JDBC.getDefault();
        List<RepData> repDataList = jdbc.executeQuery(sql, RepData.class);
        data.clear();
        for (RepData repData : repDataList) {
            data.add(repData);
        }
        table.setItems(data);
    }

    @FXML
    void onUpdateButton(ActionEvent event) throws Exception {
        JDBC jdbc = JDBC.getDefault();
        String sql = String.format("UPDATE repair SET time = \'%s\', code = \'%s\', " +
                "status=\'%s\', message=\'%s\' where time = \'%s\'", select_time.getText(), select_code.getText(), select_status.getText(), select_message.getText(), selectedItem.getTime());
        System.out.println(sql);
        jdbc.CUDSql(sql);
        queryAll();
    }


    @FXML
    void showSelected(MouseEvent event) {
        selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            select_time.setText("");
            select_code.setText("");
            select_status.setText("");
            select_message.setText("");
        } else {
            select_time.setText(selectedItem.getTime());
            select_code.setText(selectedItem.getCode());
            select_status.setText(selectedItem.getStatus());
            select_message.setText(selectedItem.getMessage());
        }
    }

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        message.setCellValueFactory(new PropertyValueFactory<>("message"));

        choice.setValue(all);
        queryAll();
    }

    private void queryAll() throws SQLException, ClassNotFoundException {
        new Thread(() -> {
            try {
                JDBC jdbc = JDBC.getDefault();
                String sql = "select time, code, status, message from repair";
                List<RepData> repDataList = jdbc.executeQuery(sql, RepData.class);
                data.clear();
                for (RepData repData : repDataList) {
                    data.add(repData);
                }
                table.setItems(data);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();
    }


    @FXML
    void onGen(ActionEvent event) {
        File file = Tools.openWindow();
        if (file != null) {
            Tools.getXlsx(file, data, RepData.class);
        }
    }

}
