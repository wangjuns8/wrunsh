package com.minierp.model;

/**
 * @author wangj
 *
 */
public class LoginCommand {
	private String userName;
	private String password;
    
    private String verifyCode;

    public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "LoginCommand : " + userName + ", " + password + ", " + verifyCode;
	}
}
