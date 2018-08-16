package com.baizhi.service;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */
public interface UserServiceDao {

    public List<User> queryAllUser();
    public User updateUser(User user);
    public User queryByIdUser(String id);
}
