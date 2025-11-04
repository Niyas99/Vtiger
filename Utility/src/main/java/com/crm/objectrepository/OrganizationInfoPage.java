package com.crm.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement profileBtn;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutBtn;
	
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	public void signOut() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(profileBtn).build().perform();
		Thread.sleep(3000);
		signoutBtn.click();
		
	}

}
