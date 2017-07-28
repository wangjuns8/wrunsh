package com.minierp.common;

import java.text.DecimalFormat;

public class StringHelper {
	
	public static String float2String(float v, int len) {
		String p = "0.";
		for (int i=0; i<len; i++ ) {
			p += "0";
		}
		return formatDecimal(v, p);
	}

	public static String double2String(double v, int len) {
		String p = "0.";
		for (int i=0; i<len; i++ ) {
			p += "0";
		}
		return formatDecimal(v, p);
	}
	
	public static boolean isNothing(String str) {
		if (str == null) {
			return true;
		}
		if (str.trim().length() < 1) {
			return true;
		}
		return false;
	}
	
	private static String formatDecimal(Object v, String p) {
		DecimalFormat decimalFormat = new DecimalFormat( p );//构造方法的字符格式这里如果小数不足2位,会以0补足.
		return decimalFormat.format( v );//format 返回的是字符串
	}


}
