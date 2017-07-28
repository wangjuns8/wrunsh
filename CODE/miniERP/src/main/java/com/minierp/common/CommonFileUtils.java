package com.minierp.common;

public class CommonFileUtils {
	
	public static final String EXCEL_VERSION_2007 = "xlsx";	//poi使用XSSF系
	public static final String EXCEL_VERSION_2003 = "xls"; //poi使用HSSF系

	public static String validFileFormatExcel(String fileName) {
		//取文件后缀名
		String suffix = fileName.substring(fileName.indexOf("."));
		//.xls : application/vnd.ms-excel
		//.xlsx : application/vnd.openxmlformats-officedocument.spreadsheetml.sheet
		//String contentType = file.getContentType();
		
		System.out.println("[validFileFormatExcel] fileName:"+fileName);
		System.out.println("[validFileFormatExcel] suffix:"+suffix);
		//System.out.println("[validFileFormatExcel] contentType:"+contentType);
		
		if ( ".xls".equals(suffix)) {
			return EXCEL_VERSION_2003;
		} else if ( ".xlsx".equals(suffix)) {
			return EXCEL_VERSION_2007;
		}
		
		return null;
	}
	
	public static String removeSuffix(String fileName) {
		if (StringHelper.isNothing(fileName)) return "";
		
		int indx = fileName.indexOf(".");
		if (indx < 0 ) {
			return fileName;
		}
		return fileName.substring(0, indx);
	}
	
	public static void main(String[] args) {
		System.out.println( "removeSuffix: [" + CommonFileUtils.removeSuffix("asdfasdf.sd") + "]");
		System.out.println( "removeSuffix: [" +  CommonFileUtils.removeSuffix(".sd") + "]" );
		System.out.println( "removeSuffix: [" +  CommonFileUtils.removeSuffix("asdfasdf") + "]" );
		System.out.println( "removeSuffix: [" +  CommonFileUtils.removeSuffix("") + "]" );
	}
}
