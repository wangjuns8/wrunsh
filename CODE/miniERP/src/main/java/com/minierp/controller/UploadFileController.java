package com.minierp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.minierp.common.CommonFileUtils;
import com.minierp.common.ExcelHelper;
import com.minierp.common.StringHelper;
import com.minierp.model.TableName;
import com.minierp.model.User;
import com.minierp.service.ITableNameService;
import com.minierp.service.ITitleNameService;

@Controller  
@RequestMapping("/uploadFile")
public class UploadFileController {
	
	@Resource  
	 private ITableNameService tableNameService;
	@Resource  
	 private ITitleNameService titleNameService;
	
	//	/uploadFile/upload.html
	@RequestMapping(value="/upload",method=RequestMethod.POST)
//    public ModelAndView excuteUploadFiles(@RequestParam MultipartFile[] myfiles, HttpServletRequest request) throws IOException{  
    public ModelAndView excuteUploadExcel(MultipartFile myfile, HttpServletRequest request) throws Exception{  
		System.out.println("excuteUploadFile starting...");
		//如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解  
        //如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解  
        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件  
//        for(MultipartFile myfile : myfiles){  
//            if(myfile.isEmpty()){  
//                System.out.println("文件未上传");  
//                return new ModelAndView("index", "error", "文件为空！");
//            }else{  
                System.out.println("文件长度: " + myfile.getSize());  
                System.out.println("文件类型: " + myfile.getContentType());  
                System.out.println("文件名称: " + myfile.getName());  
                System.out.println("文件原名: " + myfile.getOriginalFilename());  
                System.out.println("========================================");
                
                //文件格式验证
                String fileType = CommonFileUtils.validFileFormatExcel(myfile.getOriginalFilename());
                if ( StringHelper.isNothing(fileType) ) {
                	return new ModelAndView("index", "error", "上传文件不是Excel格式！");
                }
    			//生成要服务器端文件
                String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");  
                File targetFile = new File(realPath, myfile.getOriginalFilename());
    			//将上传的文件保存到服务器端
    			myfile.transferTo(targetFile);
                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  
                //FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, myfile.getOriginalFilename()));
                
    			//保存table_name
    			User user = (User) request.getSession().getAttribute("user");
    			if ( user==null || user.getId()==null ) {
    				return new ModelAndView("login");
    			}
    			
    			if( tableNameService.hasMatchTableName(targetFile.getName()) ) {
    				return new ModelAndView("index", "error", "该文件已存在！");
    			}
    			
    			TableName newTableName = tableNameService.insertTableName(user.getId(), targetFile.getName() );
    			
                //读取Excel文件内容
                saveExcelFile2DB(user, newTableName, targetFile);
//            }  
//        }
        return new ModelAndView("index", "error", "文件上传成功！");
    }
	
	public void saveExcelFile2DB(User user, TableName newTableName, File file) throws IOException,InvalidFormatException {
        //读取Excel文件内容
		String fileType = CommonFileUtils.validFileFormatExcel(file.getName());
		
        Workbook workbook;
        if ( CommonFileUtils.EXCEL_VERSION_2003.equals(fileType) ) {
        	POIFSFileSystem pfs = new POIFSFileSystem(file);
        	workbook = new HSSFWorkbook(pfs);
        } else {
        	workbook = new XSSFWorkbook(file);
        }
        Sheet sheet = workbook.getSheetAt(0);
        
		Row row = null;
		Cell cell = null;
        int curRow = 0;
		int curCol = 0;
		while ( true ) {
			if ( sheet.getRow( curRow ) == null ) { break; }
			row = sheet.getRow(curRow);
			
			List<String> rowDataList = new ArrayList<String>();
			curCol = 0;
			while ( true ) {
				cell = row.getCell( (short)curCol );
				if ( cell == null ) { break; }

				rowDataList.add(ExcelHelper.getCellValue(cell));
				
				curCol++;
			}
			
			if ( curRow == 0 ) {
				titleNameService.insertTitleName(user.getId(), newTableName.getId(), rowDataList);
			}
			System.out.println("row["+curRow+"]: " + rowDataList); 
			curRow++;
		}
		
		workbook.close();
	}
}
