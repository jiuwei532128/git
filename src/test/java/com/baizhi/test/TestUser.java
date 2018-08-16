package com.baizhi.test;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserServiceDao;
import org.junit.Test;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */
public class TestUser {
    @Test
    public void test01(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserServiceDao userDao =(UserServiceDao) ac.getBean("userServiceDao");
        List<User> users = userDao.queryAllUser();
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void test02(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDao userDao =(UserDao) ac.getBean("userDao");
        List<User> users = userDao.queryAllUser();
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void test03(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserServiceDao userDao =(UserServiceDao) ac.getBean("userServiceDao");
        User user=new User();
        user.setId("001");
        user.setPassword("123456");
        user.setUsername("喇叭");
        User user1 = userDao.updateUser(user);
        System.out.println(user1);
    }
}
