package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/6.
 */
public class Artical implements Serializable{
    private String id;
    private String title;
    private String insertimg;
    private Integer size;
    private String duration;
    private String downpath;

    public Artical() {
    }

    public Artical(String id, String title, String insertimg, Integer size, String duration, String downpath) {
        this.id = id;
        this.title = title;
        this.insertimg = insertimg;
        this.size = size;
        this.duration = duration;
        this.downpath = downpath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInsertimg() {
        return insertimg;
    }

    public void setInsertimg(String insertimg) {
        this.insertimg = insertimg;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownpath() {
        return downpath;
    }

    public void setDownpath(String downpath) {
        this.downpath = downpath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artical artical = (Artical) o;

        if (!id.equals(artical.id)) return false;
        if (!title.equals(artical.title)) return false;
        if (!insertimg.equals(artical.insertimg)) return false;
        if (!size.equals(artical.size)) return false;
        if (!duration.equals(artical.duration)) return false;
        return downpath.equals(artical.downpath);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + insertimg.hashCode();
        result = 31 * result + size.hashCode();
        result = 31 * result + duration.hashCode();
        result = 31 * result + downpath.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Artical{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", insertimg='" + insertimg + '\'' +
                ", size=" + size +
                ", duration='" + duration + '\'' +
                ", downpath='" + downpath + '\'' +
                '}';
    }
}
