package net.suncaper.myapp.service;

import net.suncaper.myapp.common.domain.User;
import net.suncaper.myapp.dao.UserDao;
import net.suncaper.myapp.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    public User findUserByName(String name) {
        return userDao.selectUserByName(name);
    }
}
