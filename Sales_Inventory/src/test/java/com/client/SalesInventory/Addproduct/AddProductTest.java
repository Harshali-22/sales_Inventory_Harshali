 package com.client.SalesInventory.Addproduct;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.client.Sales_Inventory.BaseUtility.AdminBaseClass;
import com.client.Sales_Inventory.BaseUtility.UtilityClassObject;
import com.client.Sales_Inventory.ObjectRepository.AddProductPage;
import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;
import com.client.Sales_InventoryGenericUtility.ExcelUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

@Listeners(com.client.Sales_Inventory.ListenerUtility.ListenerImpClass.class)
public class AddProductTest extends AdminBaseClass{
	ExcelUtility ex=new ExcelUtility();
	WebDriverUtility wb=new WebDriverUtility();
	@Test(groups="smoke")
	
	public void productPageDisplay(){
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		AddProductPage app=new AddProductPage(driver);
		String Text = app.getPageName().getText();
		assertEquals(Text, "Add Product");
		System.out.println("We have reached on AddProductPage");
		
	}
	@Test(groups="smoke")
	public void addProductTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String product1 = ex.getDataFromExcel("productInfo", 1, 0);
		String price1 = ex.getDataFromExcel("productInfo", 1, 1);
		String desc1 = ex.getDataFromExcel("productInfo", 1, 2);
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product1);
		app.getPrice().sendKeys(price1);
		app.selectUnit("PCS");
		app.selectCategory("Add On Items");
		app.getDescription().sendKeys(desc1);
		app.selectEnable();
		app.getDescription().sendKeys(desc1);
		app.clickAddproduct();
		wb.handleAlert(driver);	
	}
	
	@Test(groups="smoke")
	public void addproductWithoutdesc() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String product2 = ex.getDataFromExcel("productInfo", 2, 0);
		String price2 = ex.getDataFromExcel("productInfo", 2, 1);
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product2);
		app.getPrice().sendKeys(price2);
		app.selectUnit("PCS");
		app.selectCategory("Add On Items");
		app.selectEnable();
		app.clickAddproduct();
		wb.handleAlert(driver);		
		
	}
	
	@Test(groups="smoke")
	public void logoutFromProductPage() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		
		String product3 = ex.getDataFromExcel("productInfo", 3, 0);
		String price3 = ex.getDataFromExcel("productInfo", 3, 1);
		String desc3 = ex.getDataFromExcel("productInfo", 3, 2);
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product3);
		app.getPrice().sendKeys(price3);
		app.selectUnit("No");
		app.selectCategory("Add On Items");
		
		app.selectEnable();
		app.getDescription().sendKeys(desc3);
		app.clickAddproduct();
		wb.handleAlert(driver);	
		app.getLogout();			
		
	}
	@Test(groups="regression")
	public void checkAddedProduct() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from excel");
		String product4 = ex.getDataFromExcel("productInfo", 4, 0);
		String price4 = ex.getDataFromExcel("productInfo", 4, 1);
		String desc4 = ex.getDataFromExcel("productInfo", 4, 2);
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product4);
		app.getPrice().sendKeys(price4);
		app.selectUnit("No");
		app.selectCategory("Add On Items");
		
		app.selectEnable();
		app.getDescription().sendKeys(desc4);
		app.clickAddproduct();
		wb.handleAlert(driver);	
		
		app.getProductColoumn().click();
		boolean flag=false;
		List<WebElement> Data = app.getProductList();
		for(WebElement PList:Data) {
			String PrdtList = PList.getText();	
			if(PrdtList.contains(product4)) {
				flag=true;
				break;
			}					
		}
		assertEquals(flag, true);
		System.out.println("Product added successfully"+product4);	
	}
	
	@Test(groups="system")
	public void checkDeletedProduct() throws EncryptedDocumentException, IOException {
			UtilityClassObject.getTest().log(Status.INFO, "Read the data from excel");
			String product5 = ex.getDataFromExcel("productInfo", 5, 0);
			String price5 = ex.getDataFromExcel("productInfo", 5, 1);
			String desc5 = ex.getDataFromExcel("productInfo", 5, 2);
			
			AdminHomePage ahp=new AdminHomePage(driver);
			ahp.getAddProduct().click();
			
			AddProductPage app=new AddProductPage(driver);
			app.getProductName().sendKeys(product5);
			app.getPrice().sendKeys(price5);
			app.selectUnit("No");
			app.selectCategory("Add On Items");
			
			app.selectEnable();
			app.getDescription().sendKeys(desc5);
			app.clickAddproduct();
			wb.handleAlert(driver);	
			
			app.getProductColoumn().click();
			boolean flag=false;
			List<WebElement> Data = app.getProductList();
			for(WebElement PList:Data) {
				String PrdtList = PList.getText();	
				if(PrdtList.contains(product5)) {
					flag=true;
					break;
				}					
			}
			assertEquals(flag, true);
			System.out.println("Product added successfully"+product5);	
			AddProductPage app1=new AddProductPage(driver);
			app1.getProductColoumn().click();
			
			System.out.println("sample for gitbash");
		}
		
		
	
}
