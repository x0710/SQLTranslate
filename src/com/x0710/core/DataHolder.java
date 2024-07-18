package com.x0710.core;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class DataHolder extends ArrayList<DataLine> {

    private final Random random = new Random();

    public DataHolder(File data, String splitChar) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(data)))) {
            for (String buf;(buf = br.readLine())!= null;) {
                String[] s = buf.split(splitChar);
                add(new DataLine(s[0], s[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("DataHolder 构造完成");
    }
    public boolean addLine(DataLine data) {
        return add(data);
    }
    public DataLine random() {
       return this.get(random.nextInt(this.size()));
    }
}
