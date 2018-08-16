package com.baizhi.test;

import com.baizhi.dao.ManagementDao;
import com.baizhi.entity.Management;
import com.baizhi.service.ManagementServiceDao;
import net.sf.ehcache.management.ManagementService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.TestExecutionListeners;

/**
 * Created by Administrator on 2018/5/29.
 */
public class TestManagement {
    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
    ManagementDao managementDao = (ManagementDao) ac.getBean("managementDao");
    ManagementServiceDao managementServiceDao = (ManagementServiceDao) ac.getBean("managementServiceDao");

    @Test
    public void test01() {
        Management login = managementDao.login("秦始皇", "123456");
        System.out.println(login);
        ac.close();
    }
    @Test
    public void test02() {
        Management login = managementServiceDao.login("秦始皇", "123456");
        System.out.println(login);
        ac.close();
    }
}
