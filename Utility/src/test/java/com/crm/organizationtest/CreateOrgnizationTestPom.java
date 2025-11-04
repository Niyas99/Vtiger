package com.crm.organizationtest;

import org.openqa.selenium.WebDriver;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;
import com.crm.objectrepository.CreateOrganizationPage;
import com.crm.objectrepository.Home;
import com.crm.objectrepository.Login;
import com.crm.objectrepository.Oraganization;
import com.crm.objectrepository.OrganizationInfoPage;

public class CreateOrgnizationTestPom {
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
		
//step 1 : login
		driver.get(url);
		Login lp = new Login(driver);
		lp.loginPage(username, password);
		
//Step 2 : navigate to  organization module
		Home hp = new Home(driver);
		hp.getOrglink().click();
		
//step 3:click on create organization
		Oraganization op = new Oraganization(driver);
		op.getCreateOrgLink().click();
		
//step 4 : enter all the details and create a new organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.dataEntry(data, phone, industry ,type);
	
//verify orgTextfeild name to expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		Thread.sleep(2000);
		String head = oip.getHeaderMsg().getText();
		if(head.contains(data)) {
			System.out.println(data+" == "+" Created ");
		}
		else {
			System.out.println(data+" == "+"Not Created ");
		}

//step 5 : Logout
		oip.signOut();
		
	}
}
