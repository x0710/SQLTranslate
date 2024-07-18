package com.x0710.ui;

import com.x0710.core.DataHolder;
import com.x0710.core.DataLine;
import com.x0710.sql.Main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
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
        stage.setScene(GameArea.READY);
        primayStage = stage;
        stage.show();

        gameStart();
    }
    public void gameStart() {
        nextQuesion();
        primayStage.setScene(initGameScene());


    }
    private Text tip = new Text("Quesion"); // Current Question
    private TextField yourAns = new TextField();
    private DataLine currentQues;
    public Scene initGameScene() {
        VBox root = new VBox(tip, yourAns);

        yourAns.setOnAction(action->{
            boolean isCorrect = currentQues.getAns().equals(yourAns.getText());
            System.out.printf("Que: %s, Ans: %s, isTrue: %b\n", currentQues.getTip(), currentQues.getTip(), isCorrect);
            result(isCorrect);
            nextQuesion();
        });

        Scene scene = new Scene(root);
        return scene;
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
     * After an episode, what to do.
     * @param isCorrect It is correct or fault in an episode.
     */
    protected void result(boolean isCorrect) {}
    protected void nextQuesion() {
        currentQues = ques.random();
        tip.setText(currentQues.getTip());
        yourAns.clear();
        yourAns.requestFocus();

    }
}