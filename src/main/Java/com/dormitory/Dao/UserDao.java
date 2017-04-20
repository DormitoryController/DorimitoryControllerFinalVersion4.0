package com.dormitory.Dao;

import com.dormitory.model.po.User;

import java.util.List;

/**
 * Created by 赵嗣瑜 on 2017/4/19.
 */
public interface UserDao {
    public String addUser();
    public List<User> findUser();
}
