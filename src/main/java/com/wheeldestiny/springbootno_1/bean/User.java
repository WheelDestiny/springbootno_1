package com.wheeldestiny.springbootno_1.bean;

//用户实体
public class User {
    private long userid;
    private String username;
    private String password;
    private int isDelete;//删除标记

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passworg) {
        this.password = passworg;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

//    public User() {
//    }
}
