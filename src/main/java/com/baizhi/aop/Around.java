package com.baizhi.aop;
import com.baizhi.entity.Log;
import com.baizhi.service.LogServiceDao;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/5.
 */
public class Around implements MethodInterceptor {
    @Autowired
    private LogServiceDao logServiceDao;
    public Object invoke(MethodInvocation invocation) throws Throwable {

        /*1什么事*/
        Method method = invocation.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String things = annotation.name();
        System.out.println(things);
        /*1，什么人2*/
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = attributes.getRequest().getSession();
        String username = (String)session.getAttribute("name");
        System.out.println("------------"+username);
        /*1什么时间*/
        Date date=new Date();

        boolean flg=false;
        Object proceed=null;
     try {
          flg=true;
          proceed = invocation.proceed();
     }catch (Exception e){
         flg=false;
     }
        Log log=new Log(username,things,date);
        //把数据添加到数据库
        logServiceDao.addLog(log);
        return proceed;
    }
}
