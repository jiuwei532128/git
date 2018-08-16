package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
public class Menu implements Serializable {
    private Integer id;
    private String title;
    private String iconcls;
    private String url;
    private Integer parent_id;
    private Menu menu;
    private List<Menu> list;

    public Menu() {
    }

    public Menu(Integer id, String title, String iconcls, String url, Integer parent_id, Menu menu, List<Menu> list) {
        this.id = id;
        this.title = title;
        this.iconcls = iconcls;
        this.url = url;
        this.parent_id = parent_id;
        this.menu = menu;
        this.list = list;
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

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu1 = (Menu) o;

        if (!id.equals(menu1.id)) return false;
        if (!title.equals(menu1.title)) return false;
        if (!iconcls.equals(menu1.iconcls)) return false;
        if (!url.equals(menu1.url)) return false;
        if (!parent_id.equals(menu1.parent_id)) return false;
        if (!menu.equals(menu1.menu)) return false;
        return list.equals(menu1.list);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + iconcls.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + parent_id.hashCode();
        result = 31 * result + menu.hashCode();
        result = 31 * result + list.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", iconcls='" + iconcls + '\'' +
                ", url='" + url + '\'' +
                ", parent_id=" + parent_id +
                ", menu=" + menu +
                ", list=" + list +
                '}';
    }
}
