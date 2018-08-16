package com.baizhi.service;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.ShufflingDao;
import com.baizhi.entity.Shuffling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/5/30.
 */
@Service(value = "shufflingServiceDao")
@Transactional
public class ShufflingServiceDaoImpl implements ShufflingServiceDao {
    Logger logger= LoggerFactory.getLogger(ShufflingServiceDaoImpl.class);
    @Autowired
    private ShufflingDao shufflingdao;
    public List<Shuffling> queryAllShuffling(){
        List<Shuffling> shufflings = shufflingdao.queryAllShuffling();
        try{
            logger.debug("这是ShufflingServiceDaoImpl内查询所有数据的方法");
        }catch (Exception e){
            logger.error("这是ShufflingServiceDaoImpl内查询所有数据的方法，但是有异常");
        }
        return shufflings;
    }
    @LogAnnotation(name="这是添加方法")
    public void addShuffling(Shuffling shuffling){
        shufflingdao.addShuffling(shuffling);
        try{
            logger.debug("这是ShufflingServiceDaoImpl内查询添加数据的方法");
        }catch (Exception e){
            logger.error("这是ShufflingServiceDaoImpl内查询添加数据的方法，但是有异常");
        }
    }
    @LogAnnotation(name="这是修改方法")
    public void updateShuffling(Shuffling shuffling){
        shufflingdao.updateShuffling(shuffling);
        try{
            logger.debug("这是ShufflingServiceDaoImpl内修改数据的方法");
        }catch (Exception e){
            logger.error("这是ShufflingServiceDaoImpl内修改数据的方法，但是有异常");
        }
    }
    @LogAnnotation(name="这是删除方法")
    public void deleteShuffling(Integer id){
        shufflingdao.deleteShuffling(id);
        try{
            logger.debug("这是ShufflingServiceDaoImpl内删除数据的方法");
        }catch (Exception e){
            logger.error("这是ShufflingServiceDaoImpl内删除数据的方法，但是有异常");
        }
    }
    public Shuffling quertById(Integer id){
        Shuffling shuffling = shufflingdao.quertById(id);
        try{
            logger.debug("这是ShufflingServiceDaoImpl内根据查询数据的方法");
        }catch (Exception e){
            logger.error("这是ShufflingServiceDaoImpl内根据查询数据的方法，但是有异常");
        }
        return shuffling;
    }
}
