package org.lyy.service;

import org.lyy.entity.User;

import java.util.List;


public interface UserService {

    public void insertUser(User user);

    public List<User> queryAll();
}