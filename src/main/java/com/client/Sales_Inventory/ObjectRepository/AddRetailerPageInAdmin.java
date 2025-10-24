package com.client.Sales_Inventory.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRetailerPageInAdmin {
	
	WebDriver driver;
	public AddRetailerPageInAdmin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="retailer:username")
	private WebElement userNameEdt;
	
	@FindBy (id="retailer:password")
	private WebElement passwordEdt;
	
	@FindBy(id="retailer:areaCode")
	private WebElement areaCodeDD;

	@FindBy(id="retailer:phone")
	private WebElement phoneEdt;
	
	@FindBy(id="retailer:email")
	private WebElement emailEdt;
	
	@FindBy(id="retailer:address")
	private WebElement addressEdt;
	
	@FindBy(xpath = "//input[@value='Add Retailer']")
	private WebElement addRetailerBtn;
	
	@FindBy(xpath = "//select/option")
	private List<WebElement> allAreas;
	
	public List<WebElement> getAllAreas() {
		return allAreas;
	}
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getAreaCodeDD() {
		return areaCodeDD;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getAddressEdt() {
		return addressEdt;
	}

	public WebElement getAddRetailerBtn() {
		return addRetailerBtn;
	}
}
