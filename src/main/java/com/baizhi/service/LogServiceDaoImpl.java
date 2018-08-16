package com.baizhi.service;

import com.baizhi.dao.LogDao;
import com.baizhi.entity.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/5.
 */
@Service(value = "logServiceDao")
@Transactional
public class LogServiceDaoImpl implements LogServiceDao {
    @Autowired
    private LogDao logDao;
    Logger logger= LoggerFactory.getLogger(LogServiceDaoImpl.class);
    public void addLog(Log log){
        logDao.addLog(log);
    }
    public List<Log> queryAllLog(){
        List<Log> logs = logDao.queryAllLog();
        try{
            logger.debug("这是查询Log内所有数据的方法");
        }catch (Exception e){
            logger.error("这是查询Log内所有数据的方法，但是有异常");
        }
        return logs;
    }

}
