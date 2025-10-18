package com.client.SalesInventory.Module;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.client.Sales_Inventory.BaseUtility.RetailerBaseClass;
import com.client.Sales_InventoryGenericUtility.ExcelUtility;
@Listeners(com.client.Sales_Inventory.ListenerUtility.ListenerImpClass.class)
public class SampleTestClass extends RetailerBaseClass{

	@Test
	public void test() throws EncryptedDocumentException, IOException {
	
	ExcelUtility eLib=new ExcelUtility();
	List<WebElement> products=driver.findElements(By.xpath("//table[@class='table_displayData']//tr"));
	for(int i=0;i<products.size()-1;i++) {
		eLib.setDataBackToExcel("Prod", i, 0, browser);	
	}
	

}
}
