package com.client.Sales_Inventory.BaseUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;
import com.client.Sales_Inventory.ObjectRepository.LoginPage;


public class AdminBaseClass extends SuperBaseClass{

	@BeforeMethod(alwaysRun=true)
	public void configBM() {
		System.out.println("Login to application as Admin");
		LoginPage lp=new LoginPage(driver);
		lp.loginAsAdmin();
		
	}
	@AfterMethod(alwaysRun=true)
	public void configAM() {
		System.out.println("Logout from application");
		AdminHomePage ah=new AdminHomePage(driver);
		ah.logOut();
	}
	

}
