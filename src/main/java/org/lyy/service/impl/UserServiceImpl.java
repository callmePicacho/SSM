package org.lyy.service.impl;

import org.lyy.dao.UserDao;
import org.lyy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.lyy.service.UserService;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public void insertUser(User user) {
        System.out.println("service插入数据");
        dao.insertUser(user);
    }

    @Override
    public List<User> queryAll() {
        System.out.println("service查询全部数据");
        return dao.queryAll();
    }
}
