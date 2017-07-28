package com.minierp.dao;

import com.minierp.model.TableName;


public interface ITableNameDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TableName record);

    TableName selectByPrimaryKey(Integer id);
    
    TableName selectByName(String tableName);

    int hasMatchTableName(TableName record);

    int updateByPrimaryKey(TableName record);
}