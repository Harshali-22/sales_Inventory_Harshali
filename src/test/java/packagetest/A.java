package packagetest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.client.Sales_Inventory.BaseUtility.ManufacturerBaseClass;
import com.client.Sales_InventoryGenericUtility.ExcelUtility;

public class A extends ManufacturerBaseClass {
	@Test
public  void m1() throws EncryptedDocumentException, IOException {
	ExcelUtility eu = new ExcelUtility();
	String data = eu.getDataFromExcel("Sheet1", 1, 1);
	System.out.println(data);
	System.out.println("Added for feature branch-1");
	System.out.println("added for feature branch-2");
	System.out.println("added for feature branch-3");
	System.out.println("Hello :)");
	System.out.println("Hello :)");
	
}
}
