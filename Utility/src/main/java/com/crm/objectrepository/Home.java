package com.crm.objectrepository;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;

	@FindBy(linkText="More")
	private WebElement moreLink;
	
	
	public WebElement getOrglink() {
		return orglink;
	}


	public WebElement getContactLink() {
		return contactLink;
	}


	public WebElement getCampaignsLink() {
		return campaignsLink;
	}


	public WebElement getMoreLink() {
		return moreLink;
	}


	public void nvigateToCampaigns() {
		Actions act= new Actions(driver);
		act.moveToElement(moreLink);
		campaignsLink.click();
	}

	
}
