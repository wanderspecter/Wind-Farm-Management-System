package com.windows.pages.impls;

import com.MainApplication;
import com.windows.pages.IPage;
import javafx.collections.ObservableMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BasePage extends IPage {
    public FXMLLoader fxmlLoader;
    public ObservableMap<String, Object> namespace;

    @Override
    public void start(Stage stage) throws Exception {
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/windows/Base.fxml"));
        Parent root = fxmlLoader.load();
        // namespace = fxmlLoader.getNamespace();
        // Scene scene = new Scene(fxmlLoader.load());
        defaultStage.setTitle("Welcome to WindFarm Management System!");
        defaultStage.setScene(new Scene(root));
        defaultStage.show();
    }
}
