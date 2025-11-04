package com.crm.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationPage {
	WebDriver driver;
		
		public CreateOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}

		@FindBy(name="accountname")
		private WebElement accNameEdt;
		
		@FindBy(name="accounttype")
		private WebElement accTypeEdt;
		@FindBy(id="phone")
		private WebElement phoneEdt;
		
		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		@FindBy(xpath ="//select[@name='industry']")
		private WebElement IndustryDp;
		
		@FindBy(name ="accounttype")
		private WebElement typeDp;

		public WebElement getAccNameEdt() {
			return accNameEdt;
		}

		public WebElement getAccTypeEdt() {
			return accTypeEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}

		
		public void dataEntry(String accName, String phone,String industry , String type) {
			accNameEdt.sendKeys(accName);
	
			Select sel = new Select(IndustryDp);
			sel.selectByValue(industry);
			
			Select sel1 = new Select(typeDp);
			sel1.selectByValue(type);
			
			phoneEdt.sendKeys(phone);
			
			
			saveBtn.click();
		}
		

}


	
//
//driver.findElement(By.name("accountname")).sendKeys(data);
//
//wlib.selectElement(driver.findElement(By.xpath("//select[@name='industry']")),industry);
//wlib.selectElement(driver.findElement(By.name("accounttype")),type);
//
//driver.findElement(By.id("phone")).sendKeys(phone);
//driver.findElement(By.xpath("")).click();

