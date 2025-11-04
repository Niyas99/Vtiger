package com.crm.organizationtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		FileUtility flib= new FileUtility();
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib= new JavaUtility();
		WebDriverUtility wlib= new WebDriverUtility();
		
		String browser = flib.getDataPropertyFile("Browser");
		String url = flib.getDataPropertyFile("Url");
		String username = flib.getDataPropertyFile("username");
		String password = flib.getDataPropertyFile("password");
		
		
		int num = jlib.getRandomNum();
		

		String exData = elib.getDataFromExcel("org", 4, 2);
		String data = exData+num;
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver= new ChromeDriver();
			
		}
		else if(browser.equals("firefox")) {
			driver= new FirefoxDriver();
			
		}
		else if(browser.equals("edge")) {
			driver= new EdgeDriver();
			
		}
		else {
			driver= new ChromeDriver();
		}
		
		wlib.pageMaximize(driver);
		wlib.pageLoad(driver);
		
//step 1 : login
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
	
//Step 2 : navigate to  orgaization module
		driver.findElement(By.linkText("Organizations")).click();;
		
//step 3:click on create organization
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
//step 4 : enter all the details and create a new organization
		driver.findElement(By.name("accountname")).sendKeys(data);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//verify header msg to expected result
		String expData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(expData.contains(data)) {
			System.out.println(data+" == "+" Created ");
		}
		else {
			System.out.println(data+" == "+"Not Created ");
		}
		
		//verify orgtextfeild name to expected result
		String expOrg = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(expOrg.equals(data)) {
			System.out.println(expOrg+" == "+" Matching ");
		}
		else {
			System.out.println(expOrg+" == "+"Not Matching ");
		}
		
		
		
//step 5 : Logout
		Actions action = new Actions(driver);
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		action.moveToElement(ele).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
