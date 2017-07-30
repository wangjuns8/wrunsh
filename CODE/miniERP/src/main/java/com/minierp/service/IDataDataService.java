package com.minierp.service;

import java.util.List;

import com.minierp.model.TitleName;

public interface IDataDataService {
	public void createNewTable(String realTableName, List<TitleName> newColumns, String tableName);
	public void insertDataData(String realTableName, List<String> dataList);
}
