package com.x0710.ui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainStage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
//        MenuBar bar =
        stage.setScene(GameArea.READY);
        stage.show();
    }
//    protected void initSatge(Stage stage) {
//        MenuBar bar = new MenuBar();
//        BorderPane root = new BorderPane();
//        // GamePane setting
//        FlowPane tip$ans = new FlowPane();
//        tip$ans.setOrientation(Orientation.VERTICAL);
//        Text tipText = new
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//
//    }
}
