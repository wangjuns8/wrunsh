package com.minierp.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.minierp.dao.ITitleNameDao;
import com.minierp.model.TitleName;
import com.minierp.service.ITitleNameService;
  
  
@Service("titleNameService")  
public class TitleNameServiceImpl implements ITitleNameService {  
    @Resource  
    private ITitleNameDao titleNameDao;  
    
    public TitleName getTitleNameById(int id) {  
        return this.titleNameDao.selectByPrimaryKey(id);  
    }  
	public List<TitleName> insertTitleName(int userId, int tableId, List<String> titleNameList){
		List<TitleName> newTitleList = new ArrayList<TitleName>();
		
		for (int i=0; i<titleNameList.size(); i++) {
			TitleName param = new TitleName();
			param.setUserId(userId);
			param.setTableId(tableId);
	    	param.setTitleName(titleNameList.get(i));
	    	int curIndx = i+1;
	    	param.setColumnName(createColumnName(curIndx));
	    	param.setIndx(curIndx);
	    	System.out.println("insertTitleName["+i+"] before: param=" + param);
	    	
	    	titleNameDao.insert(param);
	    	
	    	newTitleList.add(param);
	    	System.out.println("insertTitleName["+i+"] after: param=" + param);
		}
		
		return newTitleList;
	}
	
	private String createColumnName(int indx) {
		return "col_" + indx;
	}
}
