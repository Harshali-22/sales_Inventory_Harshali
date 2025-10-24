package com.client.SalesInventory.ManageArea;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.client.Sales_Inventory.BaseUtility.AdminBaseClass;
import com.client.Sales_Inventory.ObjectRepository.AddRetailerPageInAdmin;
import com.client.Sales_Inventory.ObjectRepository.Add_AreaUnitPage;
import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;
import com.client.Sales_Inventory.ObjectRepository.ViewAreaPage;
import com.client.Sales_InventoryGenericUtility.ExcelUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

@Listeners(com.client.Sales_Inventory.ListenerUtility.ListenerImpClass.class)
public class ManageArea extends AdminBaseClass {
	
	@Test (groups="integration")
	public void verifyAddAreaWithValidData() throws EncryptedDocumentException, IOException {
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ViewAreaPage vap=new ViewAreaPage(driver);
		Add_AreaUnitPage aup=new Add_AreaUnitPage(driver);
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String areaName=eLib.getDataFromExcel("area", 1, 0);
		String areaCode=eLib.getDataFromExcel("area", 1, 1);
		System.out.println(areaName +" , "+ areaCode);
		ahp.getManageAreaLink().click();
		Actions act=new Actions(driver);
		act.scrollToElement(vap.getAddAreaBtn()).scrollByAmount(0, 100).perform();;
		vap.getAddAreaBtn().click();
		aup.getAreaNameEdt().sendKeys(areaName);
		aup.getAreaCodeEdt().sendKeys(areaCode);
		aup.getAddAreaBtn().click();
		wLib.handleAlert(driver);
		ahp.getManageAreaLink().click();
		boolean flag=false;
		if (vap.getArea(areaName).isDisplayed()) {
			flag=true;
		}
		Assert.assertEquals(flag, true);
	}

	@Test(dependsOnMethods = "verifyAddAreaWithValidData", groups="system")
	public void verifyAddAreaInAddRetailer() throws EncryptedDocumentException, IOException {
		AdminHomePage ahp=new AdminHomePage(driver);
		AddRetailerPageInAdmin arp=new AddRetailerPageInAdmin(driver);
		ExcelUtility eLib=new ExcelUtility();
		String areaName=eLib.getDataFromExcel("area", 1, 0);
		ahp.getAddRetailerLink().click();
		boolean flag=false;
		List<WebElement> areas=arp.getAllAreas();
		for(WebElement area:areas) {
			String actualArea=area.getText();
			System.out.println(actualArea);
			if(actualArea.contains(areaName)) {
				flag=true;
			}
		}
		Assert.assertEquals(flag, true);
	}
}