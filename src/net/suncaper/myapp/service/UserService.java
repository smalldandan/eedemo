package net.suncaper.myapp.service;

import net.suncaper.myapp.common.domain.User;

public interface UserService {
    public User findUserByName(String name);
}
