package com.minierp.model;

public class TableName {
	private Integer id;
	private Integer userId;
	private String tableName;
	private String realTableName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getRealTableName() {
		return realTableName;
	}
	public void setRealTableName(String realTableName) {
		this.realTableName = realTableName;
	}
	
	@Override
	public String toString() {
		return "TableName [id=" + id + ", userId=" + userId + ", tableName=" + tableName + ", realTableName=" + realTableName + "]";
	}

}
