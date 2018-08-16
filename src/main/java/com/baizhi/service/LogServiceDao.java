package com.baizhi.service;

import com.baizhi.entity.Log;

import java.util.List;

/**
 * Created by Administrator on 2018/6/5.
 */
public interface LogServiceDao {
    public void addLog(Log log);
    public List<Log> queryAllLog();
}
