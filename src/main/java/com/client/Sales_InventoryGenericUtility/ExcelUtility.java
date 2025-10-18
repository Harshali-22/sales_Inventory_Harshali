package com.client.Sales_InventoryGenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	String path = "./TestData/ReadDataBasedOnCondition.xlsx";
	// To Fetch The Data From Excel File
	public String getDataFromExcel(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
		return data;
	}
	
	// To Set The Data To Excel
	public void setDataBackToExcel(String sheetname,int rownum, int cellnum,String setdata) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		 Row row = sh.getRow(rownum);
		Cell cel = row.createCell(cellnum);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(setdata);
		
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();	 
	}
	
	// To  check the data is present inside the excel or not
	public void toCheckTheDataIsPresentInExcel(String sheetname, int specifyCellNum) throws EncryptedDocumentException, IOException {
		String ExpectedData = null;
		boolean flag = false;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		
		int rowcount = sh.getLastRowNum();
		for(int i=0;i<rowcount;i++) {
			Cell ActualData = sh.getRow(i).getCell(specifyCellNum);
			if (ActualData.equals(ExpectedData)) {
				flag = true;
				System.out.println(ActualData + "This Data is Present in excel");
				
			}
		}
		if(flag ==false) {
			System.out.println("Data is not Present in excel");
		}
	}
	}
	
