package com.x0710.core;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class DataHolder {

    private final Random random = new Random();
    private final ArrayList<DataLine> dataCollect;

    public DataHolder(File data) {
        dataCollect = new ArrayList<>();
        Properties p = new Properties();
        try (FileReader fr = new FileReader(data)) {
            p.load(fr);
        }catch (IOException e) {
            e.printStackTrace();
        }
        p.forEach((v1,v2)->{
            dataCollect.add(new DataLine((String)v1,(String)v2));
        });

//        System.out.println("DataHolder 构造完成");
    }
    public boolean addLine(DataLine data) {
        return this.dataCollect.add(data);
    }
    public DataLine random() {
       return dataCollect.get(random.nextInt(dataCollect.size()-1));
    }
}
