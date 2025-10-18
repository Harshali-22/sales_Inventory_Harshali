package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPageInAdmin {
	
	WebDriver driver;
	public OrdersPageInAdmin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cmbFilter")
	private WebElement searchByDD;
	
	@FindBy (id="datepicker")
	private WebElement dateTextEdt;
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchBtn;
	
	@FindBy (linkText = "Details")
	private WebElement detailsOfRecentOrder;
	
	public WebElement getDetailsOfRecentOrder() {
		return detailsOfRecentOrder;
	}

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
