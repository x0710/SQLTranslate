package com;

public class App {
    public static void main(String[] args) throws Exception {
        // Application.launch(UI.class, args);
        SQLTranslate s = new SQLTranslate("jdbc:mysql:localhost/tmp?user=root&passowrd=xxx");
        s.setSqlLimit("enword='word'");
        s.start();
        s.setOnSucceeded(act->System.out.println(s.getValue()));
    }
}
