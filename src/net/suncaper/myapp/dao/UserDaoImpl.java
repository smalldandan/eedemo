package net.suncaper.myapp.dao;

import net.suncaper.myapp.common.domain.User;
import net.suncaper.myapp.common.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{


    public User selectUserByName(String name) {
        Connection conn = DBUtil.getConnection();
        User user = null;
        ResultSet resultSet = null;
        PreparedStatement statement=null;
        try {
            String sql = "  SELECT id, name, password FROM user WHERE NAME = ? ";
            statement = conn.prepareStatement(sql);
            statement.setString(1,name);
            if(statement.execute()){
                resultSet = statement.getResultSet();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String n = resultSet.getString("name");
                    String p = resultSet.getString("password");
                    user = new User().setId(id).setName(n).setPassword(p);
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet!=null) try { resultSet.close(); } catch (SQLException e) { }
            if(statement!=null) try { statement.close(); } catch (SQLException e) { }
            if(conn!=null) try { conn.close(); } catch (SQLException e) { }
        }

        return user;
    }
}
