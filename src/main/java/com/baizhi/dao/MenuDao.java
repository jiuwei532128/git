package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
public interface MenuDao {
    public List<Menu> queryAllMenu();
    public List<Menu> querySecondById(Integer parent_id);
    public List<Menu> querySecond(Integer id);
}
