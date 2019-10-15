package com.javaweb.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String username;
    private static String password;
    private static String classpath;

    static {

        Properties p = new Properties();
        try {
            InputStream in = new FileInputStream("src/com/javaweb/util/jdbc.properties");
            p.load(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据库连接驱动名字
        classpath = p.getProperty("classpath",null);
        //获取数据库连接地址
        url = p.getProperty("url",null);
        //获取数据库连接用户名
        username = p.getProperty("username",null);
        //获取数据库连接密码
        password = p.getProperty("password",null);
        try {
            Class.forName(classpath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
