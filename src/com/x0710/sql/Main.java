package com.x0710.sql;

import com.x0710.core.DataHolder;
import com.x0710.core.DataLine;
import com.x0710.ui.GameStage;
import javafx.application.Application;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static DataHolder ques;
    public static void main(String[] args) {
        Application.launch(GameStage.class, args);
    }
    public static void gamemode(DataHolder dh) {
        Scanner sc = new Scanner(System.in);
        for(;;) {
            DataLine que = dh.random();
            String question = que.getTip(), ans = que.getAns();
            System.out.printf("Question: %s, your Answer: ", question);
            String youAns = sc.next();

            boolean correct = que.checkAns(youAns);
            System.out.println(correct);
        }
    }
    static {

        URL is = Thread.currentThread().getContextClassLoader()
                .getResource("resources/questions");
        File file = new File(is.getFile());
////        System.out.println(file.exists());
        ques = new DataHolder(file, "=");
    }
}
