package com.baizhi.service;

import com.baizhi.dao.ArticalDao;
import com.baizhi.entity.Artical;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/6.
 */
@Service(value = "articalServiceDao")
@Transactional
public class ArticalServiceDaoImpl implements ArticalServiceDao{
    @Autowired
    private ArticalDao articalDao;
    Logger logger= LoggerFactory.getLogger(ArticalServiceDaoImpl.class);
    public List<Artical> queryAllArtical() {
        List<Artical> articals = articalDao.queryAllArtical();
        try{
            logger.debug("这是查询Artical内的所有数据");
        }catch (Exception e){
            logger.error("这是查询Artical内所有数据，但是有异常");
        }
        return articals;
    }
}
