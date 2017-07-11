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
  
}  
