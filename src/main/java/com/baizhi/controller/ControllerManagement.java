package com.baizhi.controller;

import com.baizhi.entity.Management;
import com.baizhi.service.ManagementServiceDao;
import net.sf.ehcache.management.ManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/5/29.
 */
@Controller
@RequestMapping(value = "/man")
public class ControllerManagement {
    @Autowired
    private ManagementServiceDao managementServiceDao;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginManagement(String name, String password, HttpSession session){
        session.setAttribute("name",name);
        Management login = managementServiceDao.login(name, password);
        if(login!=null){
            return "redirect:/main/main.jsp";
        }else{
            return "redirect:/login.jsp";
        }

    }
}
