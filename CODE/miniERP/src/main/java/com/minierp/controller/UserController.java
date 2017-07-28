package com.minierp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minierp.common.MD5;
import com.minierp.common.MyLog;
import com.minierp.model.LoginCommand;
import com.minierp.model.User;
import com.minierp.service.IUserService;

@Controller  
@RequestMapping("/user")  
public class UserController {
	private static Logger log=LoggerFactory.getLogger(UserController.class);
	 @Resource  
	 private IUserService userService;
   
   //http://localhost/user/index.html
   @RequestMapping(value="/index.html")
   public String loginPage(){
	   return "login";
   }
   
   @RequestMapping(value="/loginCheck.html")
   public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
	   MyLog.log("loginCheck:" + loginCommand.toString());
	   
	   //验证码
	   String validateC = (String) request.getSession().getAttribute("validateCode");
	   if(loginCommand.getVerifyCode()==null||"".equals(loginCommand.getVerifyCode())){         
		   return new ModelAndView("login", "error", "验证码为空");
       }else if(!validateC.equalsIgnoreCase(loginCommand.getVerifyCode())) {
    	   return new ModelAndView("login", "error", "验证码错误");
       }
	   
	   //密码加密
	   String passwordMD5 = MD5.getMD5Code(loginCommand.getPassword());
	   MyLog.log("passwordMD5:" + passwordMD5);
	   
	   //check
	   boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), passwordMD5);
	   if( !isValidUser ) {
		   return new ModelAndView("login", "error", "用户名密码错误！");
	   } else {
		   User user = userService.getUserByUserName(loginCommand.getUserName());
		   request.getSession().setAttribute("user", user);
		   return new ModelAndView("index");
	   }
   }
}
