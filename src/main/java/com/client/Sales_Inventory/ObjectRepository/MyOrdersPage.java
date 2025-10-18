package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.Sales_InventoryGenericUtility.JavaUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

public class MyOrdersPage {

	public WebDriver driver;
	public MyOrdersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	WebDriverUtility wLib=new WebDriverUtility();
	JavaUtility jLib=new JavaUtility();
	
	@FindBy (id="cmbFilter")
	private WebElement searchByDD;
	
	@FindBy (id="datepicker")
	private WebElement dateTextEdt;
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchBtn;
	
	public WebElement getSearchByDD() {
		return searchByDD;
	}

	public WebElement getDateTextEdt() {
		return dateTextEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
}
