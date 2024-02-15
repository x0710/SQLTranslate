package com;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;

public class UI extends Application {
    private Stage primaryStage = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setHeight(200);
        primaryStage.setWidth(400);
        primaryStage.setX(Screen.getPrimary().getBounds().getWidth()/2-primaryStage.getHeight()/2);
        primaryStage.setY(Screen.getPrimary().getBounds().getHeight()/2-primaryStage.getWidth()/2);
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
    private SQLTranslate trs = null;
    @Override
    public void init() throws Exception {
        SQLTranslate trs = new SQLTranslate("jdbc:mysql://localhost/dir");
        this.trs = trs;
        
    }
    private void initLayout() {
        BorderPane bPane = new BorderPane();
        FlowPane fp = new FlowPane();
        TextField inputField = new TextField();
        Button transBtn = new Button("翻译");
        inputField.setPromptText("请输入单词");
        inputField.setOnAction(val->transBtn.fire());
        transBtn.setOnAction(val->{
            trs.restart();
        });
    }
}
