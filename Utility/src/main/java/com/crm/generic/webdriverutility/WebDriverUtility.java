package com.crm.generic.webdriverutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	public void pageMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void pageLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void selectElement(WebElement element , String value) {
		Select selectIndustry = new Select(element);
		selectIndustry.selectByValue(value);
		
	}
	
	public void elementValidation(String element , String data) {
		String expData = element;
		if(expData.contains(data)) {
			System.out.println(data+" == "+" Matching ");
		}
		else {
			System.out.println(data+" == "+"Not Matching ");
			
		}
		
		
	}
	public WebDriver driverLaunch(String browser) {
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
		return driver;
		
	}
}
