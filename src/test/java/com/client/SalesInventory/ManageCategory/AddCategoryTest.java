package com.client.SalesInventory.ManageCategory;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.client.Sales_Inventory.BaseUtility.AdminBaseClass;
import com.client.Sales_Inventory.BaseUtility.UtilityClassObject;
import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;

public class AddCategoryTest extends AdminBaseClass{
	
	@Test(groups="smoke")
	public void addCategory() {
		UtilityClassObject.getTest().log(Status.INFO, "Read the Data from Excel");
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getManageCategory().click();
		
		
		
	}

}
