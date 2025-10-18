package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomePage {
	
	WebDriver driver;
	public ManufacturerHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//section[contains(.,'Welcome')]")
	private WebElement manufactrerWelcomeMsg;
	
	@FindBy(className="submit_button")
	private WebElement logoutBtn;
	
	@FindBy(linkText = "Orders")
	private WebElement ordersLink;

	public WebElement getOrdersLink() {
		return ordersLink;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getManufactrerWelcomeMsg() {
		return manufactrerWelcomeMsg;
	}

}
