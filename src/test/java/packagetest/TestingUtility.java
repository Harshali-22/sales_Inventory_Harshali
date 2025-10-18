package packagetest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.client.Sales_InventoryGenericUtility.ExcelUtility;


public class TestingUtility {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		System.out.println("start");
		ExcelUtility eu = new ExcelUtility();
		String data = eu.getDataFromExcel("Sheet1", 1, 1);
		System.out.println(data);
//		eu.setDataBackToExcel("Sheet1", 5, 5, "sami");
	}
}
