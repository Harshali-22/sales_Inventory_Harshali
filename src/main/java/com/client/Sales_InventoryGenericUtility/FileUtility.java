package com.client.Sales_InventoryGenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) {
		String data = null;
		try {
			FileInputStream fis = new FileInputStream("./TestData/commonData.properties");
			Properties pobj = new Properties();
			pobj.load(fis);
			data = pobj.getProperty(key);
		} catch (Exception e) {
		}
		return data;
	}
}
