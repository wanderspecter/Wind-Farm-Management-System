package com.windows.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.system.data.ForecastData;
import com.system.data.PowerData;
import com.system.data.PrePowerData;
import com.system.data.WeatherData;
import com.system.jpython.JPython;
import com.system.mysql.JDBC;
import com.system.utils.MyEventBus;
import com.system.utils.Tools;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ComponentManage {
    @FXML
    private String j00252;
    @FXML
    private String j00267;
    @FXML
    private String j00293;
    @FXML
    private String j00252_;
    @FXML
    private String j00267_;
    @FXML
    private String j00293_;
    @FXML
    private JFXCheckBox checkbox_farm;
    @FXML
    private JFXCheckBox checkbox_turb;
    @FXML
    private ChoiceBox<String> choice_farm;
    @FXML
    private ChoiceBox<String> choice_turb;
    @FXML
    private TableColumn<PrePowerData, String> code_pre_turb;
    @FXML
    private TableColumn<WeatherData, String> code_real_farm;
    @FXML
    private TableColumn<PowerData, String> code_real_turb;
    @FXML
    private TableColumn<ForecastData, Float> dir10_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> dir110_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> dir30_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> dir50_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> dir70_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> dir80_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> dir90_pre_farm;
    @FXML
    private JFXButton gen_farm;
    @FXML
    private JFXButton gen_turb;
    @FXML
    private TableColumn<ForecastData, Float> hum2_pre_farm;
    @FXML
    private TableColumn<ForecastData, String> id_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> pres_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> redia_pre_farm;
    @FXML
    private JFXButton select_farm;
    @FXML
    private JFXButton select_turb;
    @FXML
    private TableColumn<ForecastData, Float> speed10_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> speed110_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> speed30_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> speed50_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> speed70_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> speed80_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> speed90_pre_farm;
    @FXML
    private TableView<ForecastData> table_pre_farm;
    @FXML
    private TableView<PrePowerData> table_pre_turb;
    @FXML
    private TableView<WeatherData> table_real_farm;
    @FXML
    private TableView<PowerData> table_real_turb;
    @FXML
    private TableColumn<ForecastData, String> time_pre_farm;
    @FXML
    private TableColumn<PrePowerData, String> time_pre_turb;
    @FXML
    private TableColumn<WeatherData, String> time_real_farm;
    @FXML
    private TableColumn<PowerData, String> time_real_turb;
    @FXML
    private TableColumn<ForecastData, Float> tmp10_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> tmp110_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> tmp2_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> tmp30_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> tmp50_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> tmp70_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> tmp80_pre_farm;
    @FXML
    private TableColumn<ForecastData, Float> tmp90_pre_farm;
    @FXML
    private TableColumn<PrePowerData, Float> value_pre_turb;
    @FXML
    private TableColumn<PowerData, Float> value_real_turb;
    @FXML
    private TableColumn<WeatherData, Float> wd1_real_farm;
    @FXML
    private TableColumn<WeatherData, Float> wd2_real_farm;
    @FXML
    private TableColumn<WeatherData, Float> wd3_real_farm;
    @FXML
    private TableColumn<WeatherData, Float> wd4_real_farm;
    @FXML
    private TableColumn<WeatherData, Float> ws1_real_farm;
    @FXML
    private TableColumn<WeatherData, Float> ws2_real_farm;
    @FXML
    private TableColumn<WeatherData, Float> ws3_real_farm;
    @FXML
    private TableColumn<WeatherData, Float> ws4_real_farm;


    private final ObservableList<ForecastData> forecastData = FXCollections.observableArrayList();
    private final ObservableList<WeatherData> weatherData = FXCollections.observableArrayList();
    private final ObservableList<PowerData> powerData = FXCollections.observableArrayList();
    private final ObservableList<PrePowerData> prePowerData = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> hour_start_farm;
    @FXML
    private ChoiceBox<String> hour_start_turb;
    @FXML
    private ChoiceBox<String> hour_stop_farm;
    @FXML
    private ChoiceBox<String> hour_stop_turb;
    @FXML
    private ChoiceBox<String> min_start_farm;
    @FXML
    private ChoiceBox<String> min_start_turb;
    @FXML
    private ChoiceBox<String> min_stop_farm;
    @FXML
    private ChoiceBox<String> min_stop_turb;
    @FXML
    private ChoiceBox<String> sec_start_farm;
    @FXML
    private ChoiceBox<String> sec_start_turb;
    @FXML
    private ChoiceBox<String> sec_stop_farm;
    @FXML
    private ChoiceBox<String> sec_stop_turb;
    @FXML
    private DatePicker time_start_farm;
    @FXML
    private DatePicker time_stop_farm;
    @FXML
    private DatePicker time_start_turb;
    @FXML
    private DatePicker time_stop_turb;
    private StringBuilder startTime = new StringBuilder("");
    private StringBuilder endTime = new StringBuilder("");
    private String nowTime;

    @FXML
    void onSelectFarm(ActionEvent event) throws SQLException, ClassNotFoundException {
        weatherData.clear();
        table_real_farm.setItems(weatherData);
        forecastData.clear();
        table_pre_farm.setItems(forecastData);
        startTime.delete(0, startTime.length());
        endTime.delete(0, endTime.length());
        startTime.append(time_start_farm.getValue().toString()).append(" ").append(hour_start_farm.getValue())
                .append(":").append(min_start_farm.getValue()).append(":").append(sec_start_farm.getValue()).append(".000");
        endTime.append(time_stop_farm.getValue().toString()).append(" ").append(hour_stop_farm.getValue())
                .append(":").append(min_stop_farm.getValue()).append(":").append(sec_stop_farm.getValue()).append(".000");

        nowTime = ComponentTitleController.nowTime + ".000";
        if (startTime.toString().compareTo(endTime.toString()) > 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("时间选择错误");
            alert.showAndWait();
            return;
        } else if (endTime.toString().compareTo(nowTime) < 0) {
            // 实际
            StringBuilder where = new StringBuilder("");
            if (!startTime.toString().equals("")) {
                where.append(" where C_TIME>='").append(startTime).append("'");
            }
            if (!endTime.toString().equals("")) {
                if (where.toString().equals("")) {
                    where.append(" where C_TIME<='").append(endTime).append("'");
                } else {
                    where.append(" and C_TIME<='").append(endTime).append("'");
                }
            }
            where.append(" order by C_TIME " + (checkbox_farm.isSelected() ? "desc" : ""));
            queryWeatherData(choice_farm.getValue(), where.toString());
        } else if (startTime.toString().compareTo(nowTime) > 0) {
            // 预测
            StringBuilder where = new StringBuilder("");
            if (!startTime.toString().equals("")) {
                where.append(" where C_TIME>='").append(startTime).append("'");
            }
            if (!endTime.toString().equals("")) {
                if (where.toString().equals("")) {
                    where.append(" where C_TIME<='").append(endTime).append("'");
                } else {
                    where.append(" and C_TIME<='").append(endTime).append("'");
                }
            }
            where.append(" order by C_TIME " + (checkbox_farm.isSelected() ? "desc" : ""));
            queryForecastData(choice_farm.getValue(), where.toString());
        } else {
            //预测+ 实际
            StringBuilder whereReal = new StringBuilder("");
            StringBuilder whereForecast = new StringBuilder("");
            if (!startTime.toString().equals("")) {
                whereReal.append(" where C_TIME>='").append(startTime).append("'");
                whereReal.append(" and C_TIME<='").append(nowTime).append("'");
            }
            if (!endTime.toString().equals("")) {
                whereForecast.append(" where C_TIME<='").append(endTime).append("'");
                whereForecast.append(" and C_TIME>='").append(nowTime).append("'");
            }
            whereReal.append(" order by C_TIME " + (checkbox_farm.isSelected() ? "desc" : ""));
            whereForecast.append(" order by C_TIME " + (checkbox_farm.isSelected() ? "desc" : ""));
            queryWeatherData(choice_farm.getValue(), whereReal.toString());
            queryForecastData(choice_farm.getValue(), whereForecast.toString());
        }
    }

    @FXML
    void onSelectTurb(ActionEvent event) throws SQLException, ClassNotFoundException {
        powerData.clear();
        table_real_turb.setItems(powerData);
        prePowerData.clear();
        table_pre_turb.setItems(prePowerData);
        startTime.delete(0, startTime.length());
        endTime.delete(0, endTime.length());
        startTime.append(time_start_turb.getValue().toString()).append(" ").append(hour_start_turb.getValue())
                .append(":").append(min_start_turb.getValue()).append(":").append(sec_start_turb.getValue()).append(".000");
        endTime.append(time_stop_turb.getValue().toString()).append(" ").append(hour_stop_turb.getValue())
                .append(":").append(min_stop_turb.getValue()).append(":").append(sec_stop_turb.getValue()).append(".000");
        nowTime = ComponentTitleController.nowTime + ".000";
        if (startTime.toString().compareTo(endTime.toString()) > 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("时间选择错误");
            alert.showAndWait();
        } else if (endTime.toString().compareTo(nowTime) < 0) {
            // 实际
            StringBuilder where = new StringBuilder("");
            if (!startTime.toString().equals("")) {
                where.append(" where C_TIME>='").append(startTime).append("'");
            }
            if (!endTime.toString().equals("")) {
                if (where.toString().equals("")) {
                    where.append(" where C_TIME<='").append(endTime).append("'");
                } else {
                    where.append(" and C_TIME<='").append(endTime).append("'");
                }
            }
            where.append(" order by C_TIME " + (checkbox_turb.isSelected() ? "desc" : ""));
            queryPowerData(choice_turb.getValue(), where.toString());
        } else if (startTime.toString().compareTo(nowTime) > 0) {
            // 预测
            Forecast(startTime, endTime);
        } else {
            //预测+ 实际
            StringBuilder whereReal = new StringBuilder("");
            if (!startTime.toString().equals("")) {
                whereReal.append(" where C_TIME>='").append(startTime).append("'");
                whereReal.append(" and C_TIME<='").append(nowTime).append("'");
            }
            whereReal.append(" order by C_TIME " + (checkbox_turb.isSelected() ? "desc" : ""));
            queryPowerData(choice_turb.getValue(), whereReal.toString());

            // 预测
            Forecast(new StringBuilder(nowTime), endTime);
        }
    }

    private void Forecast(StringBuilder start, StringBuilder end) {
        StringBuilder where = new StringBuilder("");
        where.append(" where C_TIME>='").append(start).append("'");
        where.append(" and C_TIME<='").append(end).append("'");
        where.append(" order by C_TIME " + (checkbox_turb.isSelected() ? "desc" : ""));
        List<ForecastData> list = null;
        JDBC jdbc = null;
        String sql = "select\n" +
                "C_FARM_ID,\n" +
                "C_TIME,\n" +
                "C_DIRECTION10,\n" +
                "C_DIRECTION110,\n" +
                "C_DIRECTION30,\n" +
                "C_DIRECTION50,\n" +
                "C_DIRECTION70,\n" +
                "C_DIRECTION80,\n" +
                "C_DIRECTION90,\n" +
                "C_HUMIDITY2,\n" +
                "C_RADIATION,\n" +
                "C_SPEED10,\n" +
                "C_SPEED110,\n" +
                "C_SPEED30,\n" +
                "C_SPEED50,\n" +
                "C_SPEED70,\n" +
                "C_SPEED80,\n" +
                "C_SPEED90,\n" +
                "C_SURFACE_PRESSURE,\n" +
                "C_TEMPERATURE10,\n" +
                "C_TEMPERATURE110,\n" +
                "C_TEMPERATURE2,\n" +
                "C_TEMPERATURE30,\n" +
                "C_TEMPERATURE50,\n" +
                "C_TEMPERATURE70,\n" +
                "C_TEMPERATURE80,\n" +
                "C_TEMPERATURE90\n" +
                "from " + choice_turb.getValue() + "_forecast" + where;
        try {
            jdbc = JDBC.getDefault();
            list = jdbc.executeQuery(sql, ForecastData.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } // 获得预测原始数据库中数据List

        List<PrePowerData> resultList = new ArrayList<PrePowerData>();
        for (ForecastData tmp : list) {
            resultList.add(new PrePowerData(tmp.getC_TIME(), tmp.getC_FARM_ID()));
        } // 将预测原始数据库中数据List转换为预测结果List
        // 获得python预测结果
        String[] pythonRes = JPython.getForecast(list, choice_turb.getValue());

        prePowerData.clear();
        for (PrePowerData tmp : resultList) {
            tmp.setC_VALUE(Float.valueOf(pythonRes[resultList.indexOf(tmp)]));
            prePowerData.add(tmp);
        }
        table_pre_turb.setItems(prePowerData);
    }

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        choice_turb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue ov, Number value, Number new_value) {
                MyEventBus.getDefault().post(new_value);
            }
        });
        choice_farm.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue ov, Number value, Number new_value) {
                MyEventBus.getDefault().post(new_value);
            }
        });

        time_real_turb.setCellValueFactory(new PropertyValueFactory<>("C_TIME"));
        code_real_turb.setCellValueFactory(new PropertyValueFactory<>("C_EF_CODE"));
        value_real_turb.setCellValueFactory(new PropertyValueFactory<>("C_VALUE"));
        time_pre_turb.setCellValueFactory(new PropertyValueFactory<>("C_TIME"));
        code_pre_turb.setCellValueFactory(new PropertyValueFactory<>("C_EF_CODE"));
        value_pre_turb.setCellValueFactory(new PropertyValueFactory<>("C_VALUE"));

        code_real_farm.setCellValueFactory(new PropertyValueFactory<>("C_EF_CODE"));
        time_real_farm.setCellValueFactory(new PropertyValueFactory<>("C_TIME"));
        wd1_real_farm.setCellValueFactory(new PropertyValueFactory<>("C_WD_INST1"));
        wd2_real_farm.setCellValueFactory(new PropertyValueFactory<>("C_WD_INST2"));
        wd3_real_farm.setCellValueFactory(new PropertyValueFactory<>("C_WD_INST3"));
        wd4_real_farm.setCellValueFactory(new PropertyValueFactory<>("C_WD_INST4"));
        ws1_real_farm.setCellValueFactory(new PropertyValueFactory<>("C_WS_INST1"));
        ws2_real_farm.setCellValueFactory(new PropertyValueFactory<>("C_WS_INST2"));
        ws3_real_farm.setCellValueFactory(new PropertyValueFactory<>("C_WS_INST3"));
        ws4_real_farm.setCellValueFactory(new PropertyValueFactory<>("C_WS_INST4"));

        tmp10_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_TEMPERATURE10"));
        tmp110_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_TEMPERATURE110"));
        tmp2_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_TEMPERATURE2"));
        tmp30_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_TEMPERATURE30"));
        tmp50_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_TEMPERATURE50"));
        tmp70_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_TEMPERATURE70"));
        tmp80_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_TEMPERATURE80"));
        tmp90_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_TEMPERATURE90"));

        time_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_TIME"));
        dir10_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_DIRECTION10"));
        dir110_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_DIRECTION110"));
        dir30_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_DIRECTION30"));
        dir50_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_DIRECTION50"));
        dir70_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_DIRECTION70"));
        dir80_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_DIRECTION80"));
        dir90_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_DIRECTION90"));
        hum2_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_HUMIDITY2"));
        id_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_FARM_ID"));
        pres_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_SURFACE_PRESSURE"));
        redia_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_RADIATION"));
        speed10_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_SPEED10"));
        speed110_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_SPEED110"));
        speed30_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_SPEED30"));
        speed50_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_SPEED50"));
        speed70_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_SPEED70"));
        speed80_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_SPEED80"));
        speed90_pre_farm.setCellValueFactory(new PropertyValueFactory<>("C_SPEED90"));

        choice_turb.setValue(j00252);
        choice_farm.setValue(j00252_);
        queryPowerData(choice_turb.getValue(), "");
        queryForecastData(choice_farm.getValue(), "");
        queryWeatherData(choice_farm.getValue(), "");

        time_start_farm.setValue(LocalDate.now());
        time_stop_farm.setValue(LocalDate.now());
        time_start_turb.setValue(LocalDate.now());
        time_stop_turb.setValue(LocalDate.now());

        hour_start_farm.setValue("00");
        hour_stop_farm.setValue("23");
        min_start_farm.setValue("00");
        min_stop_farm.setValue("59");
        sec_start_farm.setValue("00");
        sec_stop_farm.setValue("59");

        hour_start_turb.setValue("00");
        hour_stop_turb.setValue("23");
        min_start_turb.setValue("00");
        min_stop_turb.setValue("59");
        sec_start_turb.setValue("00");
        sec_stop_turb.setValue("59");
    }

    private void queryForecastData(String str, String where) throws SQLException, ClassNotFoundException {
        new Thread(() -> {
            forecastData.clear();
            JDBC jdbc = null;
            String sql = "select\n" +
                    "C_FARM_ID,\n" +
                    "C_TIME,\n" +
                    "C_DIRECTION10,\n" +
                    "C_DIRECTION110,\n" +
                    "C_DIRECTION30,\n" +
                    "C_DIRECTION50,\n" +
                    "C_DIRECTION70,\n" +
                    "C_DIRECTION80,\n" +
                    "C_DIRECTION90,\n" +
                    "C_HUMIDITY2,\n" +
                    "C_RADIATION,\n" +
                    "C_SPEED10,\n" +
                    "C_SPEED110,\n" +
                    "C_SPEED30,\n" +
                    "C_SPEED50,\n" +
                    "C_SPEED70,\n" +
                    "C_SPEED80,\n" +
                    "C_SPEED90,\n" +
                    "C_SURFACE_PRESSURE,\n" +
                    "C_TEMPERATURE10,\n" +
                    "C_TEMPERATURE110,\n" +
                    "C_TEMPERATURE2,\n" +
                    "C_TEMPERATURE30,\n" +
                    "C_TEMPERATURE50,\n" +
                    "C_TEMPERATURE70,\n" +
                    "C_TEMPERATURE80,\n" +
                    "C_TEMPERATURE90\n" +
                    "from " + str + "_forecast" + where;
            List<ForecastData> forecastData1ist = null;
            try {
                jdbc = JDBC.getDefault();
                forecastData1ist = jdbc.executeQuery(sql, ForecastData.class);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            for (ForecastData forecast : forecastData1ist) {
                forecastData.add(forecast);
            }
            table_pre_farm.setItems(forecastData);
        }).start();
    }

    private void queryPowerData(String str, String where) throws SQLException, ClassNotFoundException {
        new Thread(() -> {
            powerData.clear();
            JDBC jdbc = null;
            String sql = "select\n" +
                    "C_TIME,\n" +
                    "C_EF_CODE,\n" +
                    "C_VALUE\n" +
                    "from " + str + "_power" + where;
            List<PowerData> powerDataList = null;
            try {
                jdbc = JDBC.getDefault();
                powerDataList = jdbc.executeQuery(sql, PowerData.class);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            for (PowerData powerData1 : powerDataList) {
                powerData.add(powerData1);
            }
            table_real_turb.setItems(powerData);
        }).start();
    }

    private void queryWeatherData(String str, String where) throws SQLException, ClassNotFoundException {
        new Thread(() -> {
            weatherData.clear();
            String sql = "select\n" +
                    "C_TIME,\n" +
                    "C_EF_CODE,\n" +
                    "C_WD_INST1,\n" +
                    "C_WD_INST2,\n" +
                    "C_WD_INST3,\n" +
                    "C_WD_INST4,\n" +
                    "C_WS_INST1,\n" +
                    "C_WS_INST2,\n" +
                    "C_WS_INST3,\n" +
                    "C_WS_INST4\n" +
                    "from " + str + "_real" + where;
            JDBC jdbc = null;
            List<WeatherData> weatherDataList = null;
            try {
                jdbc = JDBC.getDefault();
                weatherDataList = jdbc.executeQuery(sql, WeatherData.class);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            for (WeatherData weatherData1 : weatherDataList) {
                weatherData.add(weatherData1);
            }
            table_real_farm.setItems(weatherData);
        }).start();
    }

    @FXML
    void onGenFarm(ActionEvent event) {
        File file = Tools.openWindow();
        if (file != null) {
            new Thread(() -> {
                ExcelWriter excelWriter = EasyExcel.write(file).build();
                WriteSheet writeSheet = EasyExcel.writerSheet(1, "实际天气").head(WeatherData.class).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                excelWriter.write(weatherData, writeSheet);

                writeSheet = EasyExcel.writerSheet(2, "天气预报").head(ForecastData.class).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                excelWriter.write(forecastData, writeSheet);
                excelWriter.finish();
            }).start();
        }
    }

    @FXML
    void onGenTurb(ActionEvent event) {
        File file = Tools.openWindow();
        if (file != null) {
            new Thread(() -> {
                ExcelWriter excelWriter = EasyExcel.write(file).build();
                WriteSheet writeSheet = EasyExcel.writerSheet(1, "实际功率").head(PowerData.class).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                excelWriter.write(powerData, writeSheet);

                writeSheet = EasyExcel.writerSheet(2, "预测功率").head(PrePowerData.class).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                excelWriter.write(prePowerData, writeSheet);
                excelWriter.finish();
            }).start();
        }
    }
}

