package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/6.
 */
@Service(value = "albumServiceDao")
@Transactional
public class AlbumServiceDaoImpl  implements AlbumServiceDao{
@Autowired
private AlbumDao albumDao;
    Logger logger= LoggerFactory.getLogger(AlbumServiceDaoImpl.class);
    public List<Album> queryAllAlbum() {
        List<Album> albums = albumDao.queryAllAlbum();
        try{
            logger.debug("这是查询Album内的所有数据");
        }catch (Exception e){
            logger.error("这是查询Album内所有数据，但是有异常");
        }
        return albums;
    }
}
