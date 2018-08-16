package com.baizhi.test;

import com.baizhi.entity.Log;
import com.baizhi.service.LogServiceDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/5.
 */
public class TestLog {
    @Test
    public void testadd(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
        LogServiceDao ld =(LogServiceDao) ac.getBean("logServiceDao");
        ld.addLog(new Log("李世民","添加方法",new Date()));
    }
}
