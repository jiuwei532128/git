package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Management;
import com.baizhi.entity.User;
import com.baizhi.service.ManagementServiceDao;
import com.baizhi.service.UserServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping(value = "/user1")
public class ControllerUser {
    @Autowired
    private UserServiceDao userServiceDao;
    @Autowired
    private ManagementServiceDao managementServiceDao;
    @RequestMapping(value ="/query")
    public String queryAllUser(HttpSession session){
        session.setAttribute("user","张三");
        List<User> users = userServiceDao.queryAllUser();
        System.out.println(userServiceDao);
        System.out.println(users);
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("最终结果----------");
        return "login";
    }
    //5.注册接口
    @RequestMapping("/register")
    @ResponseBody
    public JSONObject register(String phone){
        JSONObject jj=new JSONObject();
        if(phone.equals("15011160775")){
            jj.put("erron","-200");
            jj.put("error_msg","该手机号已经存在");
            return jj;
        }else{
            User user=new User("012", "达摩", "123456", "111", "高僧", "安徽", "合肥", "男", "足迹","头信息", "n", new Date(), "1.jpg");
            jj.put("id",user.getId());
            jj.put("username",user.getUsername());
            jj.put("password",user.getPassword());
            jj.put("salf",user.getSalf());
            jj.put("dharmaname",user.getDharmaname());
            jj.put("province",user.getProvince());
            jj.put("city",user.getCity());
            jj.put("sex",user.getSalf());
            jj.put("sign",user.getSalf());
            jj.put("headpic",user.getHeadpic());
            jj.put("status",user.getStatus());
            jj.put("date",user.getDate());
            jj.put("updateurl",user.getUpdateurl());
            return  jj;
        }
    }
    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(String phoneNumber, String password) {
        JSONObject jsonObject = new JSONObject();
        Management login = managementServiceDao.login(phoneNumber, password);
        if (login!=null) {
            /*说明比对成功*/
            jsonObject.put("id", login.getId());
            jsonObject.put("name", login.getName());
            jsonObject.put("password", login.getPassword());
            return jsonObject;
        } else {
            jsonObject.put("error","-200");
            jsonObject.put("errmsg","密码错误");
            return jsonObject;
        }

    }
    @RequestMapping("/update")
    @ResponseBody
    public JSONObject update(String id,String username, String password) {
        JSONObject jsonObject = new JSONObject();
        User user=new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userServiceDao.updateUser(user);
        jsonObject.put("User",user1);
        return jsonObject;
    }

}
