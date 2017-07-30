package com.minierp.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.minierp.dao.IDataDataDao;
import com.minierp.model.TitleName;
import com.minierp.service.IDataDataService;
  
  
@Service("dataDataService")  
public class DataDataServiceImpl implements IDataDataService {  
    @Resource  
    private IDataDataDao dataDataDao;  
    
	public void createNewTable(String realTableName, List<TitleName> newColumns, String tableName) {
		dataDataDao.createNewTable(realTableName, newColumns, tableName);
	}
	
	public void insertDataData(String realTableName, List<String> dataList) {
		dataDataDao.insertDataData(realTableName, dataList);
	}
}
