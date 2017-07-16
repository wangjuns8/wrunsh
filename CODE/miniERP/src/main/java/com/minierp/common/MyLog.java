package com.minierp.common;

import org.apache.log4j.Logger;

public class MyLog {
	private static Logger logger = Logger.getLogger(MyLog.class);  
    
    public static void log(String mg) {
    	logger.info(getFunc() + ": " + mg);  
    }
	
    private static String getFunc() {
    	StackTraceElement[] traces = (new Exception()).getStackTrace();
    	return traces[1].getMethodName();
    }
}
