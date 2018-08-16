package com.baizhi.service;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.entity.Management;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/5/29.
 */
public interface ManagementServiceDao {

    public Management login(String name, String password);
}
