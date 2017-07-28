package com.minierp.service;

import com.minierp.model.TableName;

public interface ITableNameService {
	public TableName getTableNameById(int tableId);
	public boolean hasMatchTableName(String tableName);
	public TableName insertTableName(int userId, String tableName);
	public TableName getTableNameByName(String tableName);
}
