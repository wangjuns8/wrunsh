package com.minierp.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.minierp.common.CommonFileUtils;
import com.minierp.common.DateUtils;
import com.minierp.dao.ITableNameDao;
import com.minierp.model.TableName;
import com.minierp.service.ITableNameService;
  
  
@Service("tableNameService")  
public class TableNameServiceImpl implements ITableNameService {  
    @Resource  
    private ITableNameDao tableNameDao;  
    
    public TableName getTableNameById(int id) {  
        return this.tableNameDao.selectByPrimaryKey(id);  
    }
    
    public TableName getTableNameByName(String tableName) {  
        return this.tableNameDao.selectByName(tableName);  
    }

    public boolean hasMatchTableName(String tableName) {
    	TableName param = new TableName();
    	param.setTableName(CommonFileUtils.removeSuffix(tableName));
    	
    	int rtn = this.tableNameDao.hasMatchTableName(param);
    	return rtn>0? true: false;
    }
    
	public TableName insertTableName(int userId, String tableName){
		TableName param = new TableName();
		param.setUserId(userId);
    	param.setTableName(CommonFileUtils.removeSuffix(tableName));
    	param.setRealTableName(createRealTableName(userId));
    	System.out.println("insertTableName before: param=" + param);  
    	
    	tableNameDao.insert(param);
    	
    	System.out.println("insertTableName after: param=" + param);  
    	return param;
	}
	
	private String createRealTableName(int userId) {
		return "t_minierp_" + userId + "_" + DateUtils.getCurrentDatetime();
	}
}
