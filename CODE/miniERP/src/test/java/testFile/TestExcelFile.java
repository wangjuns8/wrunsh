package testFile;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.minierp.controller.UploadFileController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestExcelFile {
	
	private static UploadFileController uploadFileController = new UploadFileController();

    
    @Test  
    public void testRead2003() {  
    	File file = new File("D:\\Temp\\test.xls");
    	try {
    		uploadFileController.saveExcelFile2DB(file);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}    	
    }
    
    @Test  
    public void testRead2007() {  
    	File file = new File("D:\\Temp\\test.xlsx");
    	try {
    		uploadFileController.saveExcelFile2DB(file);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}    	
    }  
}
