package com.minierp.common;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;


public class ExcelHelper {
	private static final String VALUE_STRING = "java.lang.String";
	private static final String VALUE_INT = "java.lang.Integer";
	private static final String VALUE_SHORT = "java.lang.Short";
	private static final String VALUE_FLOAT = "java.lang.Float";
	private static final String VALUE_DOUBLE = "java.lang.Double";
	private static final String VALUE_SQL_DATE = "java.sql.Date";
	private static final String VALUE_UTIL_DATE = "java.util.Date";
	
	private static final short FONT_SIZE = 10;	//默认字体大小为：10号字
	private static final String FONT_NAME = "宋体";	//默认字体为：宋体

	
	public HSSFWorkbook workBook;
	public HSSFSheet sheet;

	public ExcelHelper(String sheetName){
		init( sheetName );
	}

	public ExcelHelper (){
		init( null );
	}
	
	private void init(String sheetName) {
		workBook = new HSSFWorkbook();
		if( !StringHelper.isNothing(sheetName) ) {
			sheet = workBook.createSheet( sheetName );
		} else {
			sheet = workBook.createSheet();
		}
	}
	
	public static String getCellValue(HSSFCell cell) {
		String sValue = null;
		try {
			switch ( cell.getCellType() ) {
			case HSSFCell.CELL_TYPE_STRING:
				sValue = cell.getRichStringCellValue().getString().trim();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				sValue = String.valueOf( cell.getNumericCellValue() );
				break;
			default:
				sValue = null;//其他类型不做处理
			}
		} catch (Exception e) {
			//若当前cell是空值或不是数字，则不赋值
			e.printStackTrace();
			sValue = null;
		}
		return sValue;
	}
	public static String getCellValue(Cell cell) {
		String sValue = null;
		try {
			switch ( cell.getCellType() ) {
			case HSSFCell.CELL_TYPE_STRING:
				sValue = cell.getRichStringCellValue().getString().trim();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				sValue = String.valueOf( cell.getNumericCellValue() );
				break;
			default:
				sValue = null;//其他类型不做处理
			}
		} catch (Exception e) {
			//若当前cell是空值或不是数字，则不赋值
			e.printStackTrace();
			sValue = null;
		}
		return sValue;
	}
	
    public void setColumnWidth(short column, short width) {
		sheet.setColumnWidth(column, width);
	}
    
	public void exportExcel(String path, String fileName) throws Exception {
		if (StringHelper.isNothing(path)) {
			throw new Exception("路径不能为空");
		}
		if (StringHelper.isNothing(fileName)) {
			throw new Exception("文件名不能为空");
		}
		if (!fileName.endsWith(".xls") || !fileName.endsWith(".xlsx")) {
			throw new Exception();
		}
		if (!path.endsWith(File.separator)) {
			path += File.separator;
		}
		if(!new File(path).exists()){
			new File(path).mkdirs();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(path + fileName);
		workBook.write(fileOutputStream);
		fileOutputStream.close();
	}
	
    public void cellMerged(int rowFrom, short colFrom, int rowTo, short colTo) {
		sheet.addMergedRegion(new CellRangeAddress(rowFrom, colFrom, rowTo, colTo));
	}
    
    @SuppressWarnings("deprecation")
	public void setCellValue(int rownum, short column, short cellHeight, Object value, HSSFCellStyle cellStyle){
    	//若已经创建过，取出来；否则，创建一行
    	HSSFRow row = sheet.getRow(rownum);
    	if ( row == null ) {
    		row = sheet.createRow(rownum);
    	}
    	HSSFCell cell = row.getCell(column);//根据列值创建一个单元格。
    	if( cell == null ) {
    		cell = row.createCell( column );
    	}
    		
		row.setHeightInPoints(cellHeight);
		if (null != cellStyle) {
			cell.setCellStyle(cellStyle);
		} else {
			cell.setCellStyle(getDefaultCellStyle());
		}
		if (VALUE_STRING.equals(value.getClass().getName())) {
			cell.setCellValue((String) value);
		} else if (VALUE_INT.equals(value.getClass().getName())) {
			cell.setCellValue((Integer) value);
		} else if (VALUE_SHORT.equals(value.getClass().getName())) {
			cell.setCellValue((Short) value);
		} else if (VALUE_SQL_DATE.equals(value.getClass().getName())) {
			cell.setCellValue((java.sql.Date) value);
		} else if (VALUE_UTIL_DATE.equals(value.getClass().getName())) {
			cell.setCellValue((java.util.Date) value);
		} else if(VALUE_DOUBLE.equals(value.getClass().getName())){
			cell.setCellValue((java.lang.Double) value);
		} else if(VALUE_FLOAT.equals(value.getClass().getName())){
			cell.setCellValue((java.lang.Float) value);
		}
    }
    
	//带边框的
	@SuppressWarnings("deprecation")
	public HSSFCellStyle getDefaultCellStyleWithBorder() {
		HSSFCellStyle cellStyle = getDefaultCellStyle();
		cellStyle.setBorderBottom( HSSFCellStyle.BORDER_THIN );// 下边框
		cellStyle.setBorderLeft( HSSFCellStyle.BORDER_THIN );// 左边框
		cellStyle.setBorderRight( HSSFCellStyle.BORDER_THIN );// 右边框
		cellStyle.setBorderTop( HSSFCellStyle.BORDER_THIN );// 上边框
		return cellStyle;
	}
	
    public HSSFCellStyle getDefaultCellStyle() {
    	HSSFCellStyle cellStyle = workBook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
		cellStyle.setWrapText(true); // 自动换行
		cellStyle.setFont( getDefaultFont() );
		return cellStyle;
    }

    public HSSFFont getDefaultFont() {
		HSSFFont f = workBook.createFont();
		f.setFontName( FONT_NAME );
		f.setFontHeightInPoints( FONT_SIZE ); //字体设置
		return f;
    }
}
