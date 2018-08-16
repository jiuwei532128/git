package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.entity.Artical;
import com.baizhi.service.AlbumServiceDao;
import com.baizhi.service.ArticalServiceDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */
public class TestArtical {
    @Test
    public void test01(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
        ArticalServiceDao ad =(ArticalServiceDao) ac.getBean("articalServiceDao");
        List<Artical> articals = ad.queryAllArtical();
        for (Artical artical:articals){
            System.out.println(artical);
        }
    }

}
