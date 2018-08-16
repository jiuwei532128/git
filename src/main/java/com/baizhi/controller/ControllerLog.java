package com.baizhi.controller;

import com.baizhi.entity.Log;
import com.baizhi.service.LogServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
@Controller
@RequestMapping(value = "/log")
public class ControllerLog {
    @Autowired
    private LogServiceDao logServiceDao;
    @ResponseBody
    @RequestMapping(value = "/query")
    public List<Log> queryLog(){
        List<Log> logs = logServiceDao.queryAllLog();
            return  logs;
       }
    }

