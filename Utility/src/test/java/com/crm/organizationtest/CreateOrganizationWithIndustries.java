package com.crm.organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.crm.generic.fileutility.FileUtility;
import org.openqa.selenium.interactions.Actions;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganizationWithIndustries {

	public static void main(String[] args) throws Throwable {
		
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
		String industry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 5);
		String phone = elib.getDataFromExcel("org", 4, 6);
		
		WebDriver driver=wlib.driverLaunch(browser);
		
		wlib.pageMaximize(driver);
		wlib.pageLoad(driver);
	
//step 1 : login
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
	
//Step 2 : navigate to  organization module
		driver.findElement(By.linkText("Organizations")).click();;
		
//step 3:click on create organization
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
//step 4 : enter all the details and create a new organization
		driver.findElement(By.name("accountname")).sendKeys(data);
		
		wlib.selectElement(driver.findElement(By.xpath("//select[@name='industry']")),industry);
		wlib.selectElement(driver.findElement(By.name("accounttype")),type);

		driver.findElement(By.id("phone")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
//verify orgtextfeild name to expected result
		wlib.elementValidation(driver.findElement(By.id("dtlview_Organization Name")).getText(), data);
		
//verify the type data and expected data
		wlib.elementValidation(driver.findElement(By.id("dtlview_Type")).getText(), type);
						
//verify the industry data and expected data
		wlib.elementValidation(driver.findElement(By.id("dtlview_Industry")).getText(), industry);
		
//verify the industry data and expected data
		wlib.elementValidation(driver.findElement(By.id("dtlview_Phone")).getText(), phone);

//step 5 : Logout
		Actions action = new Actions(driver);
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		action.moveToElement(ele).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}


