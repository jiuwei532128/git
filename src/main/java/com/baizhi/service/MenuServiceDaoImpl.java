package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.ArticalDao;
import com.baizhi.dao.MenuDao;
import com.baizhi.dao.ShufflingDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Artical;
import com.baizhi.entity.Menu;
import com.baizhi.entity.Shuffling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
@Service(value = "menuServiceDao")
@Transactional
public class MenuServiceDaoImpl implements MenuServiceDao {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private ArticalDao articalDao;
    @Autowired
    private ShufflingDao shufflingDao;
    Logger logger= LoggerFactory.getLogger(MenuServiceDaoImpl.class);
    public List<Menu> queryAllMenu(){
        List<Menu> menuList = menuDao.queryAllMenu();
        try{
            logger.debug("这是MenuServiceDaoImpl内查询所有数据的方法");
        }catch (Exception e){
            logger.error("这是MenuServiceDaoImpl内查询所有数据的方法，但是有异常");
        }
        return menuList;
    }
    public List<Menu> querySecond(Integer id){
        List<Menu> list = menuDao.querySecond(id);
        return list;
    }

    public List firstPage(String type) {
        if(type.equals("0")){
            List<Album> albums = albumDao.queryAllAlbum();
            return albums;
        }else if(type.equals("1")){
            List<Artical> articals = articalDao.queryAllArtical();
            return articals;
        }else{
            List<Shuffling> headers = shufflingDao.queryAllShuffling();
            return headers;
        }
    }

    public List<Menu> querySecondById(Integer parent_id){
        List<Menu> listm = menuDao.querySecondById(parent_id);
        return listm;
    }
}
