package com.minierp.service;

import com.minierp.model.User;

public interface IUserService {
	public User getUserById(int userId);  
	public User getUserByUserName(String UserName);  
	public boolean hasMatchUser(String userName, String password);
}
