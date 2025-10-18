package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	WebDriver driver;
	public AdminHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@class='submit_button']")
	private WebElement logout;
	
	@FindBy(linkText = "Add Products")
	private WebElement addProduct;
	
	@FindBy(linkText = "Manage Unit")
	private WebElement manageUnit;
	
	
	@FindBy(linkText = "Manage Category")
	private WebElement manageCategory;
	
	
	@FindBy(linkText = "Products")
	private WebElement productList;
	
	@FindBy(xpath="//td//h1")
	private WebElement welcomeMsgText;
	

	@FindBy(xpath = "//a[text()='Add Manufacturer']")
	private WebElement AddManufacturerlink;
	
	public WebElement getAddManufacturerlink() {
		return AddManufacturerlink;
	}
	

	@FindBy(xpath="//a[text()='Orders']")
	private WebElement ordersLink;

	
	@FindBy(linkText = "Manage Area")
	private WebElement manageAreaLink;
	
	public WebElement getManageAreaLink() {
		return manageAreaLink;
	}
	public WebElement getOrdersLink() {
		return ordersLink;
	}
	public WebElement getWelcomeMsgText() {
		return welcomeMsgText;
	}
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getAddProduct() {
		return addProduct;
	}
	public WebElement getManageUnit() {
		return manageUnit;
	}

	public WebElement getManageCategory() {
		return manageCategory;
	}
	
	public WebElement getProductList() {
		return productList;
	}
	
	public void logOut() {
		logout.click();
	}

}
