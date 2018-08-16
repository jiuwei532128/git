package com.baizhi.service;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.ManagementDao;
import com.baizhi.entity.Management;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/5/29.
 */
@Service(value = "managementServiceDao")
@Transactional
public class ManagementServiceDaoImpl implements ManagementServiceDao{
    Logger logger= LoggerFactory.getLogger(ManagementServiceDaoImpl.class);
    @Autowired
    private ManagementDao managementDao;
    @LogAnnotation(name="登录")
    public Management login(String name, String password) {
        Management login = managementDao.login(name, password);
        try{
            logger.debug("这是ManagementServiceDaoImpl内的登录");
        }catch (Exception e){
            logger.error("这是ManagementServiceDaoImpl内的登录，但是有异常");
        }
        return login;
    }
}
