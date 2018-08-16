package com.baizhi.test;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuServiceDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
public class TestMenu {
    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
    MenuDao menuDao = (MenuDao) ac.getBean("menuDao");
    MenuServiceDao menuServiceDao = (MenuServiceDao)ac.getBean("menuServiceDao");

    @Test
    public void test01() {
        List<Menu> menuList = menuServiceDao.queryAllMenu();
            for (Menu menu:menuList){
                System.out.println(menu);
            }
        ac.close();
    }
    @Test
    public void test011() {
        List<Menu> menuList = menuDao.queryAllMenu();
        for (Menu menu:menuList){
            System.out.println(menu);
        }
        ac.close();
    }
    @Test
    public void test02() {
        List<Menu> menuList = menuServiceDao.queryAllMenu();
        for (Menu menu:menuList){
            System.out.println(menu);
        }
        ac.close();
    }
    @Test
    public void test03() {
        List<Menu> menuList = menuServiceDao.querySecond(1);
        for (Menu menu:menuList){
            System.out.println(menu);
        }
        ac.close();
    }

}
