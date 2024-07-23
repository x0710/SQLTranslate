package com.x0710.ui;

import com.x0710.core.DataHolder;
import com.x0710.core.DataLine;
import com.x0710.sql.Main;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameStage extends Application {
    private Stage primayStage;
    private DataHolder ques;

    public GameStage() {
        ques = Main.ques;

    }
    @Override
    public void start(Stage stage) throws Exception {
//        MenuBar bar =
        stage.setWidth(600);
        stage.setHeight(400);
        stage.setScene(GameArea.READY);
        primayStage = stage;
        stage.show();

        gameStart();
    }
    public void gameStart() {
        nextQuesion();
        primayStage.setScene(initGameScene());


    }
    private DataLine currentQues;
    private Text question = new Text(), answer = new Text();

    /**
     * @return
     */
    public Scene initGameScene() {
        Text correctNumberText = new Text(), errorNumberText = new Text();
        correctNumberText.textProperty().bind(correctNum.asString());
        errorNumberText.textProperty().bind(errorNum.asString());
//        errorNum.bind(errorNumberText.textProperty().correctNum);

        // 显示正确错误个数
        BorderPane countertop = new BorderPane();
        Label corLabel = new Label("正确个数", correctNumberText), errLabel = new Label("错误个数", errorNumberText);
        corLabel.setFont(Font.font(20));
        errLabel.setFont(Font.font(20));
        countertop.setLeft(corLabel);
        countertop.setRight(errLabel);

        // 设置Button监听
        Button knowBtn = new Button("know"), unknowBtn = new Button("unknow");
        knowBtn.setOnAction(actionEvent -> {
            System.out.println("KNOWN");
            result(true);
        });
        unknowBtn.setOnAction(actionEvent -> {
            System.out.println("UNKNOWN");
            result(false);
        });
        FlowPane ansPane = new FlowPane(knowBtn, unknowBtn); // 回答问题的按钮的父容器

        BorderPane ansGroup = new BorderPane();
        Label questionLabel = new Label("问题", question), answerLabel = new Label("答案", answer);
        ansGroup.setTop(questionLabel);
        ansGroup.setBottom(answerLabel);

        BorderPane bproot = new BorderPane(ansGroup);
        bproot.setTop(countertop);
        bproot.setBottom(ansPane);
        return new Scene(bproot);


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
    public DataHolder getQuestionInstance() {
        return ques;
    }

    /**
     * 在一个问题之后，这个问题是否被答对
     * 做问题完成后的处理
     * @param isCorrect 这个问题是否被答对
     */
    protected void result(boolean isCorrect) {
        if(isCorrect) correctNum.set(correctNum.get()+1);
        else errorNum.set(errorNum.get()+1);
        nextQuesion();
        System.out.printf("corNum: %s, errNum: %s", correctNum, errorNum);

    }
    private SimpleIntegerProperty correctNum = new SimpleIntegerProperty(), errorNum = new SimpleIntegerProperty();
    protected void nextQuesion() {
        currentQues = ques.random();
        answer.setText(currentQues.getAns());
        question.setText(currentQues.getTip());

    }
}