package com.baizhi.test;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.User;
import com.baizhi.service.AlbumServiceDao;
import com.baizhi.service.UserServiceDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */
public class TestAlbum {
    @Test
    public void test01(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
        AlbumServiceDao ad =(AlbumServiceDao) ac.getBean("albumServiceDao");
        List<Album> albums = ad.queryAllAlbum();
        for (Album album:albums){
            System.out.println(album);
        }
    }

}
