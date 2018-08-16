package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/5.
 */
public class Log implements Serializable{
    private Integer id;
    private String name;
    private String things;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date date;

    public Log(Integer id, String name, String things, Date date) {
        this.id = id;
        this.name = name;
        this.things = things;
        this.date = date;
    }

    public Log(String name, String things, Date date) {
        this.name = name;
        this.things = things;
        this.date = date;
    }

    public Log() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Log log = (Log) o;

        if (!id.equals(log.id)) return false;
        if (!name.equals(log.name)) return false;
        if (!things.equals(log.things)) return false;
        return date.equals(log.date);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + things.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", things='" + things + '\'' +
                ", date=" + date +
                '}';
    }
}
