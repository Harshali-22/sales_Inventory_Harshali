package com.client.SalesInventory.Retailer;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.Sales_Inventory.BaseUtility.RetailerBaseClass;
import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;
import com.client.Sales_Inventory.ObjectRepository.LoginPage;
import com.client.Sales_Inventory.ObjectRepository.ManufacturerHomePage;
import com.client.Sales_Inventory.ObjectRepository.MyOrdersPage;
import com.client.Sales_Inventory.ObjectRepository.OrderDetailsPage;
import com.client.Sales_Inventory.ObjectRepository.OrderItemsPage;
import com.client.Sales_Inventory.ObjectRepository.OrdersInManufacturerPage;
import com.client.Sales_Inventory.ObjectRepository.OrdersPageInAdmin;
import com.client.Sales_Inventory.ObjectRepository.RetailerHomePage;
import com.client.Sales_InventoryGenericUtility.ExcelUtility;
import com.client.Sales_InventoryGenericUtility.JavaUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;
/**
 * @author Harshali
 * This class contains all the test scripts related to Retailer module
 */
public class RetailerProfile extends RetailerBaseClass {
	
	@Test (groups="integration")
	public void verifyPostOrderDetailsInHomePage() throws EncryptedDocumentException, IOException {
		
		RetailerHomePage rhp=new RetailerHomePage(driver);
		OrderItemsPage oip=new OrderItemsPage(driver);
		OrderDetailsPage odp=new OrderDetailsPage(driver);
		WebDriverUtility wLib=new WebDriverUtility();
		
		rhp.getNewOrderLink().click();
		ExcelUtility eLib=new ExcelUtility();
		String prodID=eLib.getDataFromExcel("Prod", 7, 1);
		String quantity=eLib.getDataFromExcel("Prod", 7, 2);
		WebElement prodQnty=driver.findElement(By.xpath("//input[@class='quantity' and @id="+prodID+"]"));
		prodQnty.sendKeys(quantity);
		String product=oip.getProduct(7).getText();
		wLib.scroll(driver, oip.getPostOrderBtn());
		Actions act=new Actions(driver);
		act.scrollToElement(oip.getPostOrderBtn()).scrollByAmount(0, 100).perform();
		oip.getPostOrderBtn().click();
		rhp.getHomeLink().click();
		rhp.getDetails1().click();
		System.out.println(product);
		String actualProd=odp.getProducts().getText();
		System.out.println(actualProd);
		Assert.assertEquals(product, actualProd);
		
	}
	
	@Test (groups="System")
	public void verifyPostOrderInAdminOrders() throws EncryptedDocumentException, IOException {
		
		OrderItemsPage oip=new OrderItemsPage(driver);
		OrderDetailsPage odp=new OrderDetailsPage(driver);
		LoginPage lp=new LoginPage(driver);
		AdminHomePage ahp=new AdminHomePage(driver);
		OrdersPageInAdmin opa=new OrdersPageInAdmin(driver);
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		RetailerHomePage rhp=new RetailerHomePage(driver);
		
		/*Post a new order*/
		rhp.getNewOrderLink().click();
		String prodID=eLib.getDataFromExcel("Prod", 7, 1);
		String quantity=eLib.getDataFromExcel("Prod", 7, 2);
		WebElement prodQnty=driver.findElement(By.xpath("//input[@class='quantity' and @id="+prodID+"]"));
		prodQnty.sendKeys(quantity);
		String product=oip.getProduct(7).getText();
		wLib.scroll(driver, oip.getPostOrderBtn());
		Actions act=new Actions(driver);
		act.scrollToElement(oip.getPostOrderBtn()).scrollByAmount(0, 100).perform();
		oip.getPostOrderBtn().click();
		
		/*verify Post order is reflected in My orders*/
		
		rhp.getMyOrdersLink().click();
		searchOrdersbyDate();
		rhp.getDetails1().click();
		String actualProd=odp.getProducts().getText();
		Assert.assertEquals(product, actualProd);
		rhp.logOut();
		
		/*verify Post order is reflected in Admin profile*/
		lp.loginAsAdmin();
		ahp.getOrdersLink().click();
		wLib.select(opa.getSearchByDD(), "Date");
		String date=jLib.getSystemDate();
		opa.getDateTextEdt().sendKeys(date);
		opa.getSearchBtn().click();
		opa.getDetailsOfRecentOrder().click();
		String prodInAdmin=odp.getProducts().getText();
		Assert.assertEquals(actualProd, prodInAdmin);
	}
	
	@Test (groups="integration")
	public void searchOrdersbyDate() {
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		MyOrdersPage mop=new MyOrdersPage(driver);
		RetailerHomePage rhp=new RetailerHomePage(driver);
		
		rhp.getMyOrdersLink().click();
		wLib.select(mop.getSearchByDD(), "Date");
		String date=jLib.getSystemDate();
		mop.getDateTextEdt().sendKeys(date);
		mop.getSearchBtn().click();
	}
	@Test (groups="integration")
	public void verifyTotalPriceInNewOrder() throws EncryptedDocumentException, IOException, InterruptedException {
		OrderItemsPage oip=new OrderItemsPage(driver);
		RetailerHomePage rhp=new RetailerHomePage(driver);
		rhp.getNewOrderLink().click();
		
		List<WebElement> quantity=oip.getAllQuantities();
		for (WebElement qnty : quantity) {
			qnty.sendKeys("10");
		}
		double totalPrice=0;
		System.out.println(oip.getPrice("3").getText());
		List<WebElement> ids=oip.getAllIds();
		System.out.println(ids.size());
		for (int i=0; i< ids.size()-1; i++) {
			String idc=ids.get(i).getText();
			String productPrice=oip.getPrice(idc).getText();
			double prodPrice=Double.parseDouble(productPrice);
			totalPrice=totalPrice+prodPrice;
		}		
		System.out.println(totalPrice);
		
// can be automated further when GUI of Total price will be changed by front end developer from input to div & we'll get text value.
//		Actions act=new Actions(driver);
//		act.scrollByAmount(0, 20).doubleClick(oip.getTotalPrice()).keyDown(Keys.CONTROL).sendKeys(Keys.chord("C")).release().pause(1000).perform();
//		act.doubleClick(oip.getProdQnty7()).keyDown(Keys.CONTROL).sendKeys(Keys.chord("V")).release().perform();
		//Thread.sleep(10000);
		//String actTotalPrice=oip.getProdQnty7().getText();
		//System.out.println(actTotalPrice+"==========");
		//double actualTotalPrice=Double.parseDouble(actTotalPrice);
	//	Assert.assertEquals(totalPrice, actualTotalPrice);
		
	}
	@Test
	public void verifyPostOrderInManufacturer () throws EncryptedDocumentException, IOException {
		RetailerHomePage rhp=new RetailerHomePage(driver);
		OrderItemsPage oip=new OrderItemsPage(driver);
		LoginPage lp=new LoginPage(driver);
		ManufacturerHomePage mhp=new ManufacturerHomePage(driver);
		OrdersInManufacturerPage omp=new OrdersInManufacturerPage(driver);
		OrderDetailsPage odp=new OrderDetailsPage(driver);
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		rhp.getNewOrderLink().click();
		
		/*Post a new order*/
		rhp.getNewOrderLink().click();
		String prodID=eLib.getDataFromExcel("Prod", 7, 1);
		String quantity=eLib.getDataFromExcel("Prod", 7, 2);
		WebElement prodQnty=driver.findElement(By.xpath("//input[@class='quantity' and @id="+prodID+"]"));
		prodQnty.sendKeys(quantity);
		String product=oip.getProduct(7).getText();
		wLib.scroll(driver, oip.getPostOrderBtn());
		Actions act=new Actions(driver);
		act.scrollToElement(oip.getPostOrderBtn()).scrollByAmount(0, 100).perform();
		oip.getPostOrderBtn().click();
		rhp.logOut();
				
		lp.loginAsManufacturerKhadi();
		mhp.getOrdersLink().click();
		wLib.select(omp.getSearchByDD(), "Date");
		omp.getDateTextEdt().sendKeys(jLib.getSystemDate());
		omp.getSearchBtn().click();
		omp.getDetailsOfRecentOrder().click();
		String actualProd=odp.getProducts().getText();
		Assert.assertEquals(actualProd, product);
	}
}
