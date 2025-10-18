package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.Sales_InventoryGenericUtility.FileUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

public class LoginPage {
	WebDriverUtility wb=new WebDriverUtility();
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="txtUsername")
	private WebElement usernameEdt;
	

	@FindBy(name="txtPassword")
	private WebElement passwordEdt;
	
	@FindBy(id="login:type")
	private WebElement loginTypeDD;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginbtn;

	@FindBy(xpath="//span[@class='error_message']")
	private WebElement errorMsg;
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	public WebElement getLoginTypeDD() {
		return loginTypeDD;
	}

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public void loginAsAdmin() {
		FileUtility flu=new FileUtility();
		String AdminUn = flu.getDataFromPropertyFile("adminUn");
		String AdminPw = flu.getDataFromPropertyFile("adminPw");
		usernameEdt.sendKeys(AdminUn);
		passwordEdt.sendKeys(AdminPw);
		wb.select(loginTypeDD, "Admin");
		loginbtn.click();
	}
	
public void loginAsAdmin(String username,String password) {
		
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		wb.select(loginTypeDD,"Admin");
		loginbtn.click();		
	}
	
	public void loginAsRetailer(String username,String password) {
		
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		wb.select(loginTypeDD,"Retailer");
		loginbtn.click();		
	}
	
	public void loginAsManufacturer(String username,String password) {
		
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		wb.select(loginTypeDD, "Manufacturer");
		loginbtn.click();
	}
	
	/**
	 * @author Harshali
	 */
	public void loginAsRetailerSamshop() {
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String username=fLib.getDataFromPropertyFile("retailerUn");
		String password=fLib.getDataFromPropertyFile("retailerPw");
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		wLib.select(loginTypeDD,"Retailer");
		getLoginbtn().click();
	}
	public void loginAsManufacturerKhadi() {
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String username=fLib.getDataFromPropertyFile("manufacturerUn");
		String password=fLib.getDataFromPropertyFile("manufacturerPw");
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		wLib.select(loginTypeDD,"Manufacturer");
		getLoginbtn().click();
	}

}
