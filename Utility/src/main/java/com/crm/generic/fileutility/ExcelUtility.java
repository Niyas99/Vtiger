package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//pull

////push
public class ExcelUtility {

	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable {
		
		FileInputStream file1= new FileInputStream("C:\\Users\\niyas\\eclipse-Advanceselenium\\Utility\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(file1);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
		
	}
	
	
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream file1= new FileInputStream("C:\\Users\\niyas\\eclipse-Advanceselenium\\Utility\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(file1);
		int data = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return data;
		
	}
	
	public String setDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable {
		
		FileInputStream file1= new FileInputStream("C:\\Users\\niyas\\eclipse-Advanceselenium\\Utility\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(file1);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos= new FileOutputStream("C:\\Users\\niyas\\eclipse-Advanceselenium\\Utility\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();
				
		return "Success";
		
	}
}

