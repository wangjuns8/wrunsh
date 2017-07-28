package com.minierp.service;

import java.util.List;

import com.minierp.model.TitleName;

public interface ITitleNameService {
	public TitleName getTitleNameById(int id);
	public List<TitleName> insertTitleName(int userId, int tableId, List<String> titleNameList);
}
