package com.windows.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.leewyatt.rxcontrols.controls.RXLineButton;
import com.system.data.WindFarmData;
import com.system.mysql.JDBC;
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

import java.sql.SQLException;
import java.util.List;

public class ComponentFarmManageController {

        public static WindFarmData selectData;
        private final ObservableList<WindFarmData> data = FXCollections.observableArrayList();
        @FXML
        private TextField blades;
        @FXML
        private JFXCheckBox checkbox;
        @FXML
        private TextField condition;
        @FXML
        private RXLineButton delete;
        @FXML
        private TextField diameter;
        @FXML
        private TextField height;
        @FXML
        private TextField in_wind_speed;
        @FXML
        private TextField new_blades;
        @FXML
        private JFXButton new_cancel;
        @FXML
        private JFXButton new_create;
        @FXML
        private TextField new_diameter;
        @FXML
        private TextField new_height;
        @FXML
        private TextField new_in_wind_speed;
        @FXML
        private TextField new_num;
        @FXML
        private TextField new_out_wind_speed;
        @FXML
        private TextField new_power;
        @FXML
        private TextField new_rotation_speed;
        @FXML
        private TextField new_size;
        @FXML
        private TextField new_weight;
        @FXML
        private TextField new_wind_arrange;
        @FXML
        private TextField new_wind_speed;
        @FXML
        private TextField num;
        @FXML
        private TextField out_wind_speed;
        @FXML
        private TextField power;
        @FXML
        private TextField rotation_speed;
        @FXML
        private JFXButton select;
        @FXML
        private TextField size;
        @FXML
        private TableView<WindFarmData> table;
        @FXML
        private RXLineButton update;
        @FXML
        private TextField weight;
        @FXML
        private TextField wind_arrange;
        @FXML
        private TextField wind_speed;
        @FXML
        private TableColumn<WindFarmData, String> num_co;
        @FXML
        private TableColumn<WindFarmData, Integer> diameter_co;
        @FXML
        private TableColumn<WindFarmData, Integer> height_co;
        @FXML
        private TableColumn<WindFarmData, Integer> blades_co;
        @FXML
        private TableColumn<WindFarmData, Float> power_co;
        @FXML
        private TableColumn<WindFarmData, String> wind_arrange_co;
        @FXML
        private TableColumn<WindFarmData, Integer> wind_speed_co;
        @FXML
        private TableColumn<WindFarmData, Integer> rotation_speed_co;
        @FXML
        private TableColumn<WindFarmData, Integer> in_wind_speed_co;
        @FXML
        private TableColumn<WindFarmData, Integer> out_wind_speed_co;
        @FXML
        private TableColumn<WindFarmData, Float> size_co;
        @FXML
        private TableColumn<WindFarmData, Integer> weight_co;
        @FXML
        private ChoiceBox choice;
        @FXML
        private TextField condition2;
        @FXML
        private String all;

        public ComponentFarmManageController() {
        }

        @FXML
        void onDeleteButton(ActionEvent event) throws Exception {
                JDBC jdbc = JDBC.getDefault();
                String sql = String.format("delete from turbines " +
                        "WHERE num = \'%s\' and diameter = %d and " +
                        "height=%d and blades=%d and power=%f and wind_arrange=\'%s\' and wind_speed=%d and rotation_speed=%d and in_wind_speed=%d and " +
                        "out_wind_speed=%d and size=%f and weight=%d", selectData.getNum(), selectData.getDiameter(), selectData.getHeight(), selectData.getBlades(), selectData.getPower(), selectData.getWind_arrange(), selectData.getWind_speed(), selectData.getRotation_speed(), selectData.getIn_wind_speed(), selectData.getOut_wind_speed(), selectData.getSize(), selectData.getWeight());
                System.out.println(sql);
                jdbc.CUDSql(sql);
                queryAllWindFarm();
                num.setText("");
                diameter.setText("");
                height.setText("");
                blades.setText("");
                power.setText("");
                wind_arrange.setText("");
                wind_speed.setText("");
                rotation_speed.setText("");
                in_wind_speed.setText("");
                out_wind_speed.setText("");
                size.setText("");
                weight.setText("");
        }

        @FXML
        void onNewClearButton(ActionEvent event) {
                new_num.setText("");
                new_diameter.setText("");
                new_height.setText("");
                new_blades.setText("");
                new_power.setText("");
                new_wind_arrange.setText("");
                new_wind_speed.setText("");
                new_rotation_speed.setText("");
                new_in_wind_speed.setText("");
                new_out_wind_speed.setText("");
                new_size.setText("");
                new_weight.setText("");
        }

        @FXML
        void onNewCreateButton(ActionEvent event) throws Exception {
                WindFarmData windFarmData = new WindFarmData(new_num.getText(), new_diameter.getText(), new_height.getText(), new_blades.getText(), new_power.getText(), new_wind_arrange.getText(), new_wind_speed.getText(), new_rotation_speed.getText(), new_in_wind_speed.getText(), new_out_wind_speed.getText(), new_size.getText(), new_weight.getText());
                JDBC jdbc = JDBC.getDefault();
                String sql = "INSERT INTO turbines VALUES (\'" + windFarmData.getNum() + "\'," + windFarmData.getDiameter() + "," + windFarmData.getHeight() + "," + windFarmData.getBlades() + "," + windFarmData.getPower() + ",\'" + windFarmData.getWind_arrange() + "\'," + windFarmData.getWind_speed() + "," + windFarmData.getRotation_speed() + "," + windFarmData.getIn_wind_speed() + "," + windFarmData.getOut_wind_speed() + "," + windFarmData.getSize() + "," + windFarmData.getWeight() + ")";
                jdbc.CUDSql(sql);
        }

        @FXML
        void onSelectButton(ActionEvent event) throws SQLException, ClassNotFoundException {
                String sql = "select num, diameter, height, blades, power, wind_arrange,wind_speed,rotation_speed,in_wind_speed,out_wind_speed,size,weight from turbines";
                sql += " where ";
                String str = "";
                String myCondition = condition.getText();
                String myCondition2 = condition2.getText();
                String myChoice = (String) choice.getValue();
                switch (myChoice) {
                        case "全部":
                                queryAllWindFarm();
                                return;
                        case "机组编号":
                                str = "num";
                                break;
                        case "风轮直径":
                                str = "diameter";
                                break;
                        case "塔高":
                                str = "height";
                                break;
                        case "叶片数量":
                                str = "blades";
                                break;
                        case "发电机额定功率":
                                str = "power";
                                break;
                        case "风速范围":
                                str = "wind_arrange";
                                break;
                        case "风速额定值":
                                str = "wind_speed";
                                break;
                        case "额定转速":
                                str = "rotation_speed";
                                break;
                        case "切入风速":
                                str = "in_wind_speed";
                                break;
                        case "切出风速":
                                str = "out_wind_speed";
                                break;
                        case "风轮面积":
                                str = "size";
                                break;
                        case "风机重量":
                                str = "weight";
                                break;
                }
                if (!myCondition.equals("")) {
                        sql = sql + str + "<=" + (myChoice.equals("机组编号") || myChoice.equals("发电机额定功率") ? "\'" + myCondition + "\'" : myCondition);
                        if (!myCondition2.equals("")) {
                                sql += " and " + str + ">=" + (myChoice.equals("机组编号") || myChoice.equals("发电机额定功率") ? "\'" + myCondition2 + "\'" : myCondition2);
                        }
                } else if (!myCondition2.equals("")) {
                        sql += str + ">=" + (myChoice.equals("机组编号") || myChoice.equals("发电机额定功率") ? "\'" + myCondition2 + "\'" : myCondition2);
                } else {
                        sql += "1 = 1";
                }
                sql += " order by " + str;


                if (checkbox.isSelected()) {
                        sql += " desc";
                }
                System.out.println(sql);
                JDBC jdbc = JDBC.getDefault();
                List<WindFarmData> windFarmDataList = jdbc.executeQuery(sql, WindFarmData.class);
                data.clear();
                for (WindFarmData windFarmData : windFarmDataList) {
                        data.add(windFarmData);
                }
                table.setItems(data);
        }

        @FXML
        void onUpdateButton(ActionEvent event) throws Exception {
                JDBC jdbc = JDBC.getDefault();
                String sql = String.format("UPDATE turbines SET num = \'%s\', diameter = %s, " +
                        "height=%s,blades=%s,power=%s,wind_arrange=\'%s\',wind_speed=%s,rotation_speed=%s,in_wind_speed=%s," +
                        "out_wind_speed=%s,size=%s,weight=%s WHERE num = \'%s\' and diameter = %d and " +
                        "height=%d and blades=%d and power=%f and wind_arrange=\'%s\' and wind_speed=%d and rotation_speed=%d and in_wind_speed=%d and " +
                        "out_wind_speed=%d and size=%f and weight=%d", num.getText(), diameter.getText(), height.getText(), blades.getText(), power.getText(), wind_arrange.getText(), wind_speed.getText(), rotation_speed.getText(), in_wind_speed.getText(), out_wind_speed.getText(), size.getText(), weight.getText(), selectData.getNum(), selectData.getDiameter(), selectData.getHeight(), selectData.getBlades(), selectData.getPower(), selectData.getWind_arrange(), selectData.getWind_speed(), selectData.getRotation_speed(), selectData.getIn_wind_speed(), selectData.getOut_wind_speed(), selectData.getSize(), selectData.getWeight());
                System.out.println(sql);
                jdbc.CUDSql(sql);
                queryAllWindFarm();
        }


        @FXML
        private void initialize() throws SQLException, ClassNotFoundException {
                num_co.setCellValueFactory(new PropertyValueFactory<>("num"));
                diameter_co.setCellValueFactory(new PropertyValueFactory<>("diameter"));
                height_co.setCellValueFactory(new PropertyValueFactory<>("height"));
                blades_co.setCellValueFactory(new PropertyValueFactory<>("blades"));
                power_co.setCellValueFactory(new PropertyValueFactory<>("power"));
                wind_arrange_co.setCellValueFactory(new PropertyValueFactory<>("wind_arrange"));
                wind_speed_co.setCellValueFactory(new PropertyValueFactory<>("wind_speed"));
                rotation_speed_co.setCellValueFactory(new PropertyValueFactory<>("rotation_speed"));
                in_wind_speed_co.setCellValueFactory(new PropertyValueFactory<>("in_wind_speed"));
                out_wind_speed_co.setCellValueFactory(new PropertyValueFactory<>("out_wind_speed"));
                size_co.setCellValueFactory(new PropertyValueFactory<>("size"));
                weight_co.setCellValueFactory(new PropertyValueFactory<>("weight"));
                choice.setValue(all);


                queryAllWindFarm();
        }

        public void queryAllWindFarm() throws SQLException, ClassNotFoundException {
                data.clear();
                JDBC jdbc = JDBC.getDefault();
                String sql = "select num, diameter, height, blades, power, wind_arrange,wind_speed,rotation_speed,in_wind_speed,out_wind_speed,size,weight from turbines";
                List<WindFarmData> windFarmDataList = jdbc.executeQuery(sql, WindFarmData.class);
                for (WindFarmData windFarmData : windFarmDataList) {
                        data.add(windFarmData);
                }
                table.setItems(data);
        }

        @FXML
        void showSelected(MouseEvent event) {
                WindFarmData selectedItem = table.getSelectionModel().getSelectedItem();
                if (selectedItem == null) return;
                selectData = selectedItem;
                num.setText(selectedItem.getNum());
                diameter.setText(String.valueOf(selectedItem.getDiameter()));
                height.setText(String.valueOf(selectedItem.getHeight()));
                blades.setText(String.valueOf(selectedItem.getBlades()));
                power.setText(String.valueOf(selectedItem.getPower()));
                wind_arrange.setText(selectedItem.getWind_arrange());
                wind_speed.setText(String.valueOf(selectedItem.getWind_speed()));
                rotation_speed.setText(String.valueOf(selectedItem.getRotation_speed()));
                in_wind_speed.setText(String.valueOf(selectedItem.getIn_wind_speed()));
                out_wind_speed.setText(String.valueOf(selectedItem.getOut_wind_speed()));
                size.setText(String.valueOf(selectedItem.getSize()));
                weight.setText(String.valueOf(selectedItem.getWeight()));
        }
}
