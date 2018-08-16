package com.baizhi.poi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2018/6/4.
 * 自定义注解
 */
    //注解使用位置，属性上
    @Target(ElementType.FIELD)
    //注解使用时机，在运行时使用
    @Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnoation {
    //name是注解中小括号里面的参数名，String是参数值的类型
    public String name();
}
