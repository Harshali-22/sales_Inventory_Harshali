package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategory {
	
	WebDriver driver;
	public AddCategory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='+ Add Category']")
	private WebElement addCategorybtn;
	
	@FindBy(id="categoryName")
	private WebElement CName;
	
	@FindBy(id="categoryDetails")
	private WebElement CategoryDetails;

}
