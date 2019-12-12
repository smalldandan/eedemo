package com.test;

import org.junit.Test;

import java.sql.*;

public class TestJDBC {
    @Test
    public void test(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
            String userName = "root";
            String password = "123456";

//      1、  加载一个驱动到内存中
            Class.forName(driver);
//        2、通过DriverManager 获得数据库连接
            conn = DriverManager.getConnection(url, userName, password);
//        3、获取statement，它可以执行sql语句
            String sql = "select * from user where id > ?";
//            String sql = "select * from user where id > ? and id <?";
             /*   preparedStatement.setString(1,"admin");
        preparedStatement.setString(2,"admin");*/
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
//            preparedStatement.setInt(2, 6);

//        4、执行sql语句
            boolean is = preparedStatement.execute();
//true: 执行的结果包含结果集, false: 执行的结果包含更新行数
            if (is) {
//        5、处理结果集
                rs = preparedStatement.getResultSet();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String pwd = rs.getString("password");
                    System.out.println("id: " + id + ",name: " + name + ",pwd: " + pwd);
                }
            } else {
                int updateCount = preparedStatement.getUpdateCount();
                System.out.println("updateCount: " + updateCount);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //6. 关闭资源
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (preparedStatement != null) try {
                preparedStatement.close();
            } catch (SQLException e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
}
