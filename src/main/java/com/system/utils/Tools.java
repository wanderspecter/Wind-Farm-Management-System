package com.system.utils;

import com.alibaba.excel.EasyExcel;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class Tools {
    public static void getXlsx(File file, List rs, Class myClass) {
        // java 实现将List数据写入到Excel文件中
        new Thread(() -> {
            EasyExcel.write(file, myClass).sheet("sheet1").doWrite(rs);
        }).start();
    }

    public static File openWindow() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx");
        fileChooser.getExtensionFilters().add(extFilter);
        Stage primaryStage = new Stage();
        fileChooser.setTitle("保存文件至");
        File file = fileChooser.showSaveDialog(primaryStage);
        return file;
    }
}
