package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/30.
 */
public class Shuffling implements Serializable{
    private Integer id;
    private String title;
    private String imgPath;
    private String dese;
    private String status;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date date;

    public Shuffling() {
    }

    public Shuffling(Integer id, String title, String imgPath, String dese, String status, Date date) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.dese = dese;
        this.status = status;
        this.date = date;
    }

    public Shuffling(String title, String imgPath, String dese, String status) {
        this.title = title;
        this.imgPath = imgPath;
        this.dese = dese;
        this.status = status;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDese() {
        return dese;
    }

    public void setDese(String dese) {
        this.dese = dese;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

        Shuffling shuffling = (Shuffling) o;

        if (!id.equals(shuffling.id)) return false;
        if (!title.equals(shuffling.title)) return false;
        if (!imgPath.equals(shuffling.imgPath)) return false;
        if (!dese.equals(shuffling.dese)) return false;
        if (!status.equals(shuffling.status)) return false;
        return date.equals(shuffling.date);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + imgPath.hashCode();
        result = 31 * result + dese.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Shuffling{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", dese='" + dese + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
