package com.client.Sales_Inventory.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddManufacturerPage {

	 public WebDriver driver;
	public AddManufacturerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//h1[text()='Add Manufacturer']")
	private WebElement AddManufacturerMessage;
	
	@FindBy(name = "txtManufacturerName")
	private WebElement NameField;
	
	@FindBy(id = "manufacturer:email")
	private WebElement EmailField;
	
	@FindBy(id = "manufacturer:phone")
	private WebElement PhoneField;
	
	@FindBy(id = "manufacturer:username")
	private WebElement usernameField;
	
	@FindBy(id = "manufacturer:password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement addmanufacturerbutton;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddManufacturerMessage() {
		return AddManufacturerMessage;
	}

	public WebElement getNameField() {
		return NameField;
	}

	public WebElement getEmailField() {
		return EmailField;
	}

	public WebElement getPhoneField() {
		return PhoneField;
	}

	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getAddmanufacturerbutton() {
		return addmanufacturerbutton;
	}
	
	public void addmanufacturer(String Name, String Email, String Phone, String username, String Password) throws InterruptedException {
		NameField.sendKeys(Name);
		EmailField.sendKeys(Email);
		PhoneField.sendKeys(Phone);
		usernameField.sendKeys(username);
		passwordField.sendKeys(Password);
		addmanufacturerbutton.click();
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

	}
	
	
}
