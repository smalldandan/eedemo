package com.test;


import org.junit.Test;

import java.sql.*;

public class test {
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC";
        String userName = "root";
        String password = "123456";

//      1、  加载一个驱动到内存中
        Class.forName(driver);
//        2、通过DriverManager 获得数据库连接
        conn = DriverManager.getConnection(url, userName, password);
        System.out.println(conn);



    }
}

