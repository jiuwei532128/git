package com.baizhi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Album;
import com.baizhi.entity.Artical;
import com.baizhi.entity.Menu;
import com.baizhi.entity.Shuffling;
import com.baizhi.service.AlbumServiceDao;
import com.baizhi.service.ArticalServiceDao;
import com.baizhi.service.MenuServiceDao;
import com.baizhi.service.ShufflingServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
@Controller
@RequestMapping(value = "/menu")
public class ControllerMenu {
    @Autowired
    private ShufflingServiceDao shufflingServiceDao;
    @Autowired
    private MenuServiceDao menuServiceDao;

    @RequestMapping(value = "/query")
    public void queryMenu(PrintWriter writer, HttpSession session){
       String username = (String)session.getAttribute("name");
       if(username!=null){
            List<Menu> menuList = menuServiceDao.queryAllMenu();
            for (Menu menu:menuList){
                menu.setList(menuServiceDao.querySecondById(menu.getId()));
            }
            String s = JSONObject.toJSONString(menuList);
            writer.println(s);

       }

    }
    //1.一级页面接口
    @RequestMapping("/first")
    @ResponseBody
    public JSONObject firstPage(String type){
        JSONObject jj=new JSONObject();
        List list = menuServiceDao.firstPage(type);
        jj.put("list",list);
        return jj;
    }
}
