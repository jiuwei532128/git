package com.baizhi.dao;

import com.baizhi.entity.Management;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/5/29.
 */
public interface ManagementDao {
    public Management login(@Param(value="name")String name,@Param(value="password")String password);
}
