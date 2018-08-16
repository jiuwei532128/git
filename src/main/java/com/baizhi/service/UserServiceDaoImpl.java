package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */
@Service(value = "userServiceDao")
@Transactional
public class UserServiceDaoImpl implements UserServiceDao{
    Logger logger= LoggerFactory.getLogger(UserServiceDaoImpl.class);
    @Autowired
    private UserDao userDao;
    public List<User> queryAllUser(){
        List<User> users = userDao.queryAllUser();
        System.out.println("dshfnsdjkofdn++++++++++");
        try{
            logger.debug("这是UserServiceDaoImpl内查询所有数据的方法");
        }catch (Exception e){
            logger.error("这是UserServiceDaoImpl内查询所有数据的方法，但是有异常");
        }
        return users;
    }

    public User updateUser(User user) {
        userDao.updateUser(user);
        String id = user.getId();
        User user1 = userDao.queryByIdUser(id);
        return user1;
    }

    public User queryByIdUser(String id) {
        User user = userDao.queryByIdUser(id);
        return user;
    }
}
