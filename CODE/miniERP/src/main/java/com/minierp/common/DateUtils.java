package com.minierp.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");

	public static String getCurrentDatetime() {
		return datetimeFormat.format(new Date());
	}
}
