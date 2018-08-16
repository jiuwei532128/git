package com.baizhi.service;

import com.baizhi.entity.Shuffling;

import java.util.List;

/**
 * Created by Administrator on 2018/5/30.
 */
public interface ShufflingServiceDao {
    public List<Shuffling> queryAllShuffling();
    public void addShuffling(Shuffling shuffling);
    public void updateShuffling(Shuffling shuffling);
    public void deleteShuffling(Integer id);
    public Shuffling quertById(Integer id);
}
