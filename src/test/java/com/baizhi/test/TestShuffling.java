package com.baizhi.test;

import com.baizhi.dao.MenuDao;
import com.baizhi.dao.ShufflingDao;
import com.baizhi.entity.Shuffling;
import com.baizhi.service.MenuServiceDao;
import javafx.scene.chart.PieChart;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


/**
 * Created by Administrator on 2018/5/30.
 */
public class TestShuffling {
    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
    ShufflingDao shufflingDao = (ShufflingDao)ac.getBean("shufflingDao");

    @Test
    public void test01(){
        Shuffling sf=new Shuffling("华严经","img/2.gif","佛经.华严经","y");
        shufflingDao.addShuffling(sf);
    }
    @Test
    public void test02(){
        shufflingDao.deleteShuffling(4);
    }
    @Test
    public void test03(){
        Shuffling shuffling = shufflingDao.quertById(1);
        System.out.println(shuffling);
    }
    @Test
    public void test04(){
        Shuffling sf=new Shuffling();
        sf.setStatus("n");
        sf.setId(4);
        shufflingDao.updateShuffling(sf);
    }
}
