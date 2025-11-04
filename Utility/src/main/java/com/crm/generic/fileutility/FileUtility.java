package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;


public class FileUtility {

	public String getDataPropertyFile(String key) throws Throwable {
		
		FileInputStream file = new FileInputStream("C:\\Users\\niyas\\eclipse-Advanceselenium\\Utility\\src\\main\\resources\\CommonData.properties");
		
		Properties prop =new Properties();
		prop.load(file);
		
		String data = prop.getProperty(key);
		
		return data;
		
	}
	
	

}
