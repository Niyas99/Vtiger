package com.crm.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	
	public Login(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement userpassEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getUserpassEdt() {
		return userpassEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginPage(String username , String password)
	{
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		userpassEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
	
}
