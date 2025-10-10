package com.client.Sales_Inventory.BaseUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.client.Sales_Inventory.ObjectRepository.LoginPage;


public class AdminBaseClass extends SuperBaseClass{

	@BeforeMethod
	public void configBM() {
		System.out.println("Login to application as Admin");
		
		String USERNAME = futils.getDataFromPropertyFile("adminUn");
		String PASSWORD = futils.getDataFromPropertyFile("adminPw");
		LoginPage lp=new LoginPage(driver);
		lp.loginAsAdmin(USERNAME, PASSWORD);
		
		
	}
	@AfterMethod
	public void configAM() {
		System.out.println("Logout from application");
		
	}
	

}
