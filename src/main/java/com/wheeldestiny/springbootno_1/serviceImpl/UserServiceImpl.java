package com.wheeldestiny.springbootno_1.serviceImpl;

import com.wheeldestiny.springbootno_1.bean.User;
import com.wheeldestiny.springbootno_1.dao.UserDao;
import com.wheeldestiny.springbootno_1.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User login(String username, String password) {

        return userDao.getInfo(username,password);
    }

    @Override
    public Long addUser(String username, String password) {
        return userDao.addUser(username,password);
    }

    @Override
    public User queryByName(String username) {
        return userDao.getByName(username);
    }
}
