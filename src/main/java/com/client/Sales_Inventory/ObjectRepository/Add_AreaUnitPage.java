package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_AreaUnitPage {
	
	WebDriver driver;
	public Add_AreaUnitPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="areaName")
	private WebElement areaNameEdt;
	
	@FindBy (id="areaCode")
	private WebElement areaCodeEdt;
	
	@FindBy(xpath="//input[@value='Add Area']")
	private WebElement addAreaBtn;
	
	public WebElement getAreaNameEdt() {
		return areaNameEdt;
	}

	public WebElement getAreaCodeEdt() {
		return areaCodeEdt;
	}

	public WebElement getAddAreaBtn() {
		return addAreaBtn;
	}

}
