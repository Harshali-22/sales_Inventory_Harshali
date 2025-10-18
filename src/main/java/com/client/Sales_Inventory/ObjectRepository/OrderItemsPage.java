package com.client.Sales_Inventory.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

public class OrderItemsPage {

	WebDriver driver;
	WebDriverUtility wLib=new WebDriverUtility();
	public OrderItemsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="7")
	private WebElement prodQnty7;
	
	@FindBy(id="totalPrice7")
	private WebElement prodPrice7;
	
	@FindBy(id="btnSubmit")
	private WebElement postOrderBtn;
	
	@FindBy(xpath="//input[@class='quantity']")
	private List<WebElement> allQuantities;
	
	@FindBy(xpath="//table[@class='table_displayData']//td/parent::tr/td[1]")
	private List<WebElement> allIds;
	
	@FindBy(id="txtFinalAmount")
	private WebElement totalPrice;
	
	public WebElement getTotalPrice() {
		return totalPrice;
	}
	public List<WebElement> getAllIds() {
		return allIds;
	}
	public List<WebElement> getAllQuantities() {
		return allQuantities;
	}
	public WebElement getProdQnty7() {
		return prodQnty7;
	}

	public WebElement getProdPrice7() {
		return prodPrice7;
	}

	public WebElement getPostOrderBtn() {
		return postOrderBtn;
	}
	public WebElement getProduct(int id) {
		WebElement prod=driver.findElement(By.xpath("//input[@id='"+id+"']//parent::td//parent::tr//td[2]"));
		return prod;
	}
	public WebElement getProduct() {
		WebElement prod=driver.findElement(By.xpath("//input[@id='7']//parent::td//parent::tr//td[2]"));
		return prod;
	}
	public WebElement getPrice(String id) {
//		String path="//div[@id='totalPrice"+id+"']";
//		System.out.println(path);
		WebElement price=driver.findElement(By.xpath("//div[@id='totalPrice"+id+"']"));
		return price;
	}
	public WebElement getPrice() {
		WebElement price=driver.findElement(By.xpath("//div[@id='totalPrice7']"));
		return price;
	}
}
