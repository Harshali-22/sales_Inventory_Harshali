package com.client.Sales_Inventory.ObjectRepository;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersInManufacturerPage {

		WebDriver driver;
		public OrdersInManufacturerPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="cmbFilter")
		private WebElement searchByDD;
		
		@FindBy(xpath="//input[@value='Search']")
		private WebElement searchBtn;
		
		@FindBy(id="datepicker")
		private WebElement dateTextEdt;
		
		@FindBy (linkText = "Details")
		private WebElement detailsOfRecentOrder;
		
		@FindBy (xpath="//td//table[@class='table_invoiceFormat']//td")
		private List<WebElement> product;
		
		public List<WebElement> getProduct() {
			return product;
		}

		public WebElement getSearchByDD() {
			return searchByDD;
		}

		public WebElement getSearchBtn() {
			return searchBtn;
		}

		public WebElement getDateTextEdt() {
			return dateTextEdt;
		}

		public WebElement getDetailsOfRecentOrder() {
			return detailsOfRecentOrder;
		}



}
