package net.suncaper.myapp.common.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
    private static String driver =null;
    private static String url;
    private static String dbUser;
    private static String dbPassword;
    static {
        //类路径加载资源
        try {
            InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("/cfg/jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            driver = properties.getProperty("db.driver");
            System.out.println(driver);
            url = properties.getProperty("db.url");
            dbUser = properties.getProperty("db.user");
            dbPassword = properties.getProperty("db.password");
            String mn = properties.getProperty("myname");
            System.out.println(mn);
            inputStream.close();
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){
        Connection conn =null;
          try {
            conn = DriverManager.getConnection(url,dbUser,dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
