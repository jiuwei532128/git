package com.baizhi.dao;

import com.baizhi.entity.Shuffling;

import java.util.List;

/**
 * Created by Administrator on 2018/5/30.
 */
public interface ShufflingDao {
    public List<Shuffling> queryAllShuffling();
    public void addShuffling(Shuffling shuffling);
    public void updateShuffling(Shuffling shuffling);
    public void deleteShuffling(Integer id);
    public Shuffling quertById(Integer id);
}
