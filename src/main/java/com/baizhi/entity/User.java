package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import javafx.scene.chart.PieChart;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.io.Serializable;

public class User implements Serializable{
    private String id;
    private String username;
    private String password;
    private String salf;
    private String dharmaname;
    private String province;
    private String city;
    private String sex;
    private String sign;
    private String headpic;
    private String status;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date date;
    private String updateurl;

    public User(String id, String username, String password, String salf, String dharmaname, String province, String city, String sex, String sign, String headpic, String status, Date date, String updateurl) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salf = salf;
        this.dharmaname = dharmaname;
        this.province = province;
        this.city = city;
        this.sex = sex;
        this.sign = sign;
        this.headpic = headpic;
        this.status = status;
        this.date = date;
        this.updateurl = updateurl;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalf() {
        return salf;
    }

    public void setSalf(String salf) {
        this.salf = salf;
    }

    public String getDharmaname() {
        return dharmaname;
    }

    public void setDharmaname(String dharmaname) {
        this.dharmaname = dharmaname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
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

    public String getUpdateurl() {
        return updateurl;
    }

    public void setUpdateurl(String updateurl) {
        this.updateurl = updateurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        if (!salf.equals(user.salf)) return false;
        if (!dharmaname.equals(user.dharmaname)) return false;
        if (!province.equals(user.province)) return false;
        if (!city.equals(user.city)) return false;
        if (!sex.equals(user.sex)) return false;
        if (!sign.equals(user.sign)) return false;
        if (!headpic.equals(user.headpic)) return false;
        if (!status.equals(user.status)) return false;
        if (!date.equals(user.date)) return false;
        return updateurl.equals(user.updateurl);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + salf.hashCode();
        result = 31 * result + dharmaname.hashCode();
        result = 31 * result + province.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + sex.hashCode();
        result = 31 * result + sign.hashCode();
        result = 31 * result + headpic.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + updateurl.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salf='" + salf + '\'' +
                ", dharmaname='" + dharmaname + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sex='" + sex + '\'' +
                ", sign='" + sign + '\'' +
                ", headpic='" + headpic + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", updateurl='" + updateurl + '\'' +
                '}';
    }
}
