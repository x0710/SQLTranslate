package com.x0710.ui;

import com.x0710.core.DataHolder;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameArea extends FlowPane {
    public static final Scene READY;
    private DataHolder queCollect;

    public GameArea(DataHolder ques) {
        queCollect = ques;
        

    }
    static {
        // ~~~~~~~~~~~~~~~Ready Scene
        Text readyText = new Text("Are You Ready!?");
        readyText.setFont(Font.font(20));
        Button readyButton = new Button("READY");
        readyButton.setOnAction(act->{
            // READY
        });
        VBox readyRoot = new VBox(readyText, readyButton);
//        readyRoot.set
//        readyRoot.setOrientation(Orientation.VERTICAL);
        readyRoot.setAlignment(Pos.CENTER);
        Scene ready = new Scene(readyRoot);
        READY = ready;
    }
}
