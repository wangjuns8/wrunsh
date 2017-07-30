package com.minierp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.minierp.model.TitleName;


public interface IDataDataDao {
    void createNewTable(@Param("realTableName") String realTableName, @Param("newColumns") List<TitleName> newColumns, @Param("tableName") String tableName);
    void insertDataData(@Param("realTableName") String realTableName, @Param("dataList") List<String> dataList);
}