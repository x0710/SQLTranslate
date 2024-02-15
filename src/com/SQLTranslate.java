package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class SQLTranslate extends Service<TreeMap<String,String>> {
    private String sqlLimit;

    public Connection connection;
    static {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SQLTranslate(String url) throws SQLException {
        connection = DriverManager.getConnection(url);

    }

    @Override
    protected Task<TreeMap<String, String>> createTask() {
        return new Task<TreeMap<String,String>>() {
            @Override
            protected TreeMap<String, String> call() throws SQLException {
                TreeMap<String,String> ret = new TreeMap<>();
                Statement s = connection.createStatement();
                ResultSet rs = s.executeQuery("SELECT c1,x2 FROM tb_name WHERE "+getSqlLimit());
                while(rs.next()) {
                    ret.put(rs.getString(1), rs.getString(2));
                }
                return ret;
            }
            
        };
    }


    public String getSqlLimit() {
        return sqlLimit;
    }

    public void setSqlLimit(String sqlLimit) {
        this.sqlLimit = sqlLimit;
    }
}
