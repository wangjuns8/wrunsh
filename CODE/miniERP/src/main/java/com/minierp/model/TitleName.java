package com.minierp.model;

public class TitleName {
	private Integer id;
	private Integer userId;
	private Integer tableId;
	private String titleName;
	private String columnName;
	private Integer indx;
	
	public Integer getIndx() {
		return indx;
	}
	public void setIndx(Integer indx) {
		this.indx = indx;
	}
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
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	@Override
	public String toString() {
		return "TitleName [id=" + id + ", userId=" + userId + ", tableId=" + tableId + ", titleName=" + titleName + ", columnName=" + columnName + ", indx=" + indx + "]";
	}
}
