package com.client.Sales_Inventory.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageAreaPage {

	WebDriver driver;
	public ManageAreaPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@value='+ Add Area']")
	private WebElement addAreaBtn;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;
	
	@FindBy(name="chkId[]")
	private List<WebElement> checkBoxes;
	
	@FindBy(xpath = "//a[contains(@href,'edit')]")
	private List<WebElement> allEditBtns;
}
