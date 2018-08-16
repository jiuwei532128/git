package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */
public interface UserDao {
    public List<User> queryAllUser();
    public void updateUser(User user);
    public User queryByIdUser(String id);
}
