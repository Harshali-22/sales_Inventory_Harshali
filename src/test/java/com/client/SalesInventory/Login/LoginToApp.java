package com.client.SalesInventory.Login;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.client.Sales_Inventory.BaseUtility.SuperBaseClass;
import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;
import com.client.Sales_Inventory.ObjectRepository.LoginPage;
import com.client.Sales_Inventory.ObjectRepository.ManufacturerHomePage;
import com.client.Sales_Inventory.ObjectRepository.RetailerHomePage;
import com.client.Sales_InventoryGenericUtility.FileUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;
/**
 * @author Harshali
 * This class contains all the test scripts on Login module
 */
@Listeners(com.client.Sales_Inventory.ListenerUtility.ListenerImpClass.class)
public class LoginToApp extends SuperBaseClass{
	
	@Test(groups="smoke")
	public void loginAsAdmin() {
		LoginPage lp=new LoginPage(driver);
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		AdminHomePage ahp=new AdminHomePage(driver);
		
		String username=fLib.getDataFromPropertyFile("adminUn");
		String password=fLib.getDataFromPropertyFile("adminPw");
		
		lp.getUsernameEdt().sendKeys(username);
		lp.getPasswordEdt().sendKeys(password);
		wLib.select(lp.getLoginTypeDD(), "Admin");
		lp.getLoginbtn().click();
		
		String welcomeMsg=ahp.getWelcomeMsgText().getText();
		String actualUsername=welcomeMsg.substring(8);
		System.out.println(actualUsername);
		Assert.assertEquals(actualUsername, username);
		System.out.println(actualUsername);
		ahp.logOut();
	}

	@Test (groups="smoke")
	public void loginAsRetailer() {
		LoginPage lp=new LoginPage(driver);
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		RetailerHomePage rhp=new RetailerHomePage(driver);
		
		String username=fLib.getDataFromPropertyFile("retailerUn");
		String password=fLib.getDataFromPropertyFile("retailerPw");
		
		lp.getUsernameEdt().sendKeys(username);
		lp.getPasswordEdt().sendKeys(password);
		wLib.select(lp.getLoginTypeDD(), "Retailer");
		lp.getLoginbtn().click();
		
		boolean flag=false;
		String welcomeMsg=rhp.getRetailerWelcomeMsg().getText();
		if(welcomeMsg.contains("Welcome "+username))
		{
			flag=true;
		}
		Assert.assertEquals(flag, true);
		
		rhp.logOut();
	}
	@Test (groups="smoke")
	public void loginToManufacturer() {
		LoginPage lp=new LoginPage(driver);
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		ManufacturerHomePage mhp=new ManufacturerHomePage(driver);
		
		String username=fLib.getDataFromPropertyFile("manufacturerUn");
		String password=fLib.getDataFromPropertyFile("manufacturerPw");
		
		lp.getUsernameEdt().sendKeys(username);
		lp.getPasswordEdt().sendKeys(password);
		wLib.select(lp.getLoginTypeDD(), "Manufacturer");
		lp.getLoginbtn().click();
		
		String welcomeMsg=mhp.getManufactrerWelcomeMsg().getText();
		boolean flag=false;
		if (welcomeMsg.contains("Welcome "+username)){
			flag=true;
		}
		Assert.assertEquals(flag, true);
		
		mhp.getLogoutBtn().click();
	}
	
	@Test(groups="regression")
	public void loginAsAdminWithWrongPswd() {
		LoginPage lp=new LoginPage(driver);
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String username=fLib.getDataFromPropertyFile("adminUn");
		String password=fLib.getDataFromPropertyFile("wrongpw");
		
		lp.getUsernameEdt().sendKeys(username);
		lp.getPasswordEdt().sendKeys(password);
		wLib.select(lp.getLoginTypeDD(), "Admin");
		lp.getLoginbtn().click();
		
		String errorMsg=lp.getErrorMsg().getText();
		boolean flag=false;
		if(errorMsg.contains("incorrect")) {
			flag=true;
		}
		Assert.assertEquals(flag, true);
	}

	@Test (groups="regression")
	public void loginAsRetailerWithWrongPswd() {
		LoginPage lp=new LoginPage(driver);
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String username=fLib.getDataFromPropertyFile("retailerUn");
		String password=fLib.getDataFromPropertyFile("wrongpw");
		
		lp.getUsernameEdt().sendKeys(username);
		lp.getPasswordEdt().sendKeys(password);
		wLib.select(lp.getLoginTypeDD(), "Retailer");
		lp.getLoginbtn().click();
		
		String errorMsg=lp.getErrorMsg().getText();
		boolean flag=false;
		if(errorMsg.contains("incorrect")) {
			flag=true;
		}
		Assert.assertEquals(flag, true);
	}
	@Test (groups="regression")
	public void loginToManufacturerWithWrongPswd() {
		LoginPage lp=new LoginPage(driver);
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String username=fLib.getDataFromPropertyFile("manufacturerUn");
		String password=fLib.getDataFromPropertyFile("wrongpw");
		
		lp.getUsernameEdt().sendKeys(username);
		lp.getPasswordEdt().sendKeys(password);
		wLib.select(lp.getLoginTypeDD(), "Manufacturer");
		lp.getLoginbtn().click();
		
		String errorMsg=lp.getErrorMsg().getText();
		boolean flag=false;
		if(errorMsg.contains("incorrect")) {
			flag=true;
		}
		Assert.assertEquals(flag, true);
	}
}
