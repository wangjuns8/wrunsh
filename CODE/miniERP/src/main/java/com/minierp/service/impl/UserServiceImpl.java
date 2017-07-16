package com.minierp.service.impl;
import javax.annotation.Resource;  
  



import org.springframework.stereotype.Service;  

import com.minierp.dao.IUserDao;
import com.minierp.model.User;
import com.minierp.service.IUserService;
  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserDao userDao;  
    
    public User getUserById(int userId) {  
        return this.userDao.selectByPrimaryKey(userId);  
    }  

    public User getUserByUserName(String userName) {  
        return this.userDao.selectByUserName(userName);  
    }  

    public boolean hasMatchUser(String userName, String password) {
    	User paramUser = new User();
    	paramUser.setUserName(userName);
    	paramUser.setPassword(password);
    	
    	int rtn = this.userDao.hasMatchUser(paramUser);
    	return rtn>0? true: false;
    }
  
}  
