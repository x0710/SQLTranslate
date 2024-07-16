package com.x0710.sql;

import com.x0710.core.DataHolder;
import com.x0710.core.DataLine;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        URL is = Thread.currentThread().getContextClassLoader()
                        .getResource("resources/questions.properties");
        File file = new File(is.getFile());
        DataHolder dh = new DataHolder(file);

//        gamemode(dh);

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
}
