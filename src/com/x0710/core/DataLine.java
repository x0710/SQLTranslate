package com.x0710.core;

public class DataLine {

    private final String tip, ans;

    public DataLine(String tip, String ans) {
        this.tip = tip;
        this.ans = ans;

    }

    public boolean checkAns(String input) {
       return ans.equals(input);
    }
    public String getTip() {
        return tip;
    }

    public String getAns() {
        return ans;
    }
}
