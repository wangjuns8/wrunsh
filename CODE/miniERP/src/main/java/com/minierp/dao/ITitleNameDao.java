package com.minierp.dao;

import com.minierp.model.TitleName;


public interface ITitleNameDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TitleName record);

    TitleName selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TitleName record);
}