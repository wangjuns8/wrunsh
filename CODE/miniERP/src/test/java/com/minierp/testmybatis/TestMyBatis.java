package com.minierp.testmybatis;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import com.alibaba.fastjson.JSON;  
import com.minierp.model.User;
import com.minierp.service.IUserService;
  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  

public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private IUserService userService = null;  
  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    @Test  
    public void test1() {  
    	User user = userService.getUserById(1);  
        // System.out.println(user.getUserName());  
        // logger.info("鍊硷細"+user.getUserName());  
        logger.info(getFunc() + ": " + JSON.toJSONString(user));  
    }  
    
    @Test  
    public void testGetByUserName() {  
        User user = userService.getUserByUserName("test");  
        // System.out.println(user.getUserName());  
        // logger.info("鍊硷細"+user.getUserName());  
        logger.info(getFunc() + ": " + JSON.toJSONString(user));  
    }  
    
    @Test  
    public void testHasMatchUser() {  
        boolean hasUser = userService.hasMatchUser("evan", "123");  
        // System.out.println(user.getUserName());  
        // logger.info("鍊硷細"+user.getUserName());  
        logger.info(getFunc() + ": " + (hasUser? "has user : evan" : "evan is not exist or password is wrong!") );  
        
        hasUser = userService.hasMatchUser("evan", "234");  
        // System.out.println(user.getUserName());  
        // logger.info("鍊硷細"+user.getUserName());  
        logger.info(getFunc() + ": " + (hasUser? "has user : evan" : "evan is not exist or password is wrong!") );  
    }  
    
    private String getFunc() {
    	StackTraceElement[] traces = (new Exception()).getStackTrace();
    	return traces[1].getMethodName();
    }
}  