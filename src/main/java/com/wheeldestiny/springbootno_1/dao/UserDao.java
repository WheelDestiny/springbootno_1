package com.wheeldestiny.springbootno_1.dao;

import com.wheeldestiny.springbootno_1.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    //登录
    User getInfo(@Param("username") String username, @Param("password") String password);
    //注册
    Long addUser(@Param("username") String username, @Param("password") String password);
    //用户名查重
    User getByName(@Param("username") String username);

}
