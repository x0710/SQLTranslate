package com;
import javafx.application.Application;
import javafx.stage.Stage;

public class UI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setX(100);
        primaryStage.setY(100);
        primaryStage.setHeight(150);
        primaryStage.setWidth(300);
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
    
}
