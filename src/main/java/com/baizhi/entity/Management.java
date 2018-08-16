package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/28.
 */
public class Management implements Serializable{
    private Integer Id;
    private String name;
    private String password;

    public Management() {
    }

    public Management(Integer id, String name, String password) {
        Id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Management that = (Management) o;

        if (!Id.equals(that.Id)) return false;
        if (!name.equals(that.name)) return false;
        return password.equals(that.password);
    }

    @Override
    public int hashCode() {
        int result = Id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Management{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
