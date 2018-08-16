package com.baizhi.service;

import com.baizhi.entity.Menu;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
public interface MenuServiceDao {
    public List<Menu> queryAllMenu();
    public List<Menu> querySecondById(Integer parent_id);
    public List<Menu> querySecond(Integer id);
    public List firstPage(String type);
}
