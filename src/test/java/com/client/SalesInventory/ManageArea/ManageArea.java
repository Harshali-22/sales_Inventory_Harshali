package com.client.SalesInventory.ManageArea;

import org.testng.annotations.Test;

import com.client.Sales_Inventory.BaseUtility.AdminBaseClass;
import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;

public class ManageArea extends AdminBaseClass {
	
	@Test
	public void verifyAddAreaWithValidData() {
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getManageAreaLink().click();
		
	}

}
