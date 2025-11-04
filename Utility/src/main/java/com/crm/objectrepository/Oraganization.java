package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Oraganization {

	WebDriver driver;
	public Oraganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLink;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}
	
	
	
}
