package com.mytt.boot.Dao;

import com.mytt.boot.Moudel.User;

import java.util.List;
public interface UserDao {
    /**
     * 拉去全部用户信息
     * @return
     */
     List<User> getAlluser();
}
