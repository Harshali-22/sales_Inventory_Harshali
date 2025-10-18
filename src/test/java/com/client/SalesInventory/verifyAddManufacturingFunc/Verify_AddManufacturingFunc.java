package com.client.SalesInventory.verifyAddManufacturingFunc;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.client.Sales_Inventory.BaseUtility.AdminBaseClass;
import com.client.Sales_Inventory.ObjectRepository.AddManufacturerPage;
import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;

public class Verify_AddManufacturingFunc extends AdminBaseClass  {
	AddManufacturerPage amp;
	AdminHomePage ahp ;
	@Test(groups = "smoke")
	public void verifyAddmanufacturing() throws InterruptedException {
		amp = new AddManufacturerPage(driver);
		ahp=new AdminHomePage(driver);
		ahp.getAddManufacturerlink().click();
		amp.addmanufacturer("abhi", "bluestar@gmail.com", "0987654321", "sami77", "sami77");

		String url = driver.getCurrentUrl();
		if(url.contains("admin")) {
			System.out.println("Admin login done successfully");
		}
		else {
			System.out.println("admin not found");
		}
	}
}
