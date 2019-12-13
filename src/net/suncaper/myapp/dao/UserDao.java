package net.suncaper.myapp.dao;

import net.suncaper.myapp.common.domain.User;

public interface UserDao {
    public User selectUserByName(String name);
}
