package com.minierp.dao;

import com.minierp.model.User;


public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    User selectByUserName(String userName);

    int hasMatchUser(User record);


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}