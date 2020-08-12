package com.wheeldestiny.springbootno_1.service;

import com.wheeldestiny.springbootno_1.bean.User;

public interface UserService {
    //登录
    User login(String username, String password);
    //添加新用户
    Long addUser(String username,String password);
    //用户名查重
    User queryByName(String username);
}
