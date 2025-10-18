package com.client.Sales_Inventory.BaseUtility;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;
import com.client.Sales_Inventory.ObjectRepository.LoginPage;

/**
 * @author sami
 */
public class ManufacturerBaseClass extends SuperBaseClass {

	
	@BeforeMethod(alwaysRun = true)
	public void loginAsManufacturer() {
		LoginPage lp = new LoginPage(driver);
		WebElement username = lp.getUsernameEdt();
		WebElement password = lp.getPasswordEdt();
		WebElement loginBtn = lp.getLoginbtn();
		
		username.sendKeys("man");
		password.sendKeys("man123");
		loginBtn.click();
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutAsManufacturer() {
		AdminHomePage hp = new AdminHomePage(driver);
		WebElement logoutBtn = hp.getLogout();
		logoutBtn.click();
	}
}
