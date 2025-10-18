package com.client.Sales_InventoryGenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * @author author sami
 */
public class DataBaseUtility {
	
	Connection conn;

	// Connect To DataBase
	public void getConnectToDataBase() throws SQLException {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
		    Connection conn = DriverManager.getConnection(null, null, null);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}	
	
	// To Fetch The Data From DataBase
	public ResultSet toFetchTheDataFromDataBase(String Query) throws SQLException {
		ResultSet result = null;
		try {
			Statement state = conn.createStatement();
			 result = state.executeQuery(Query);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}
	
	// To Update The Data To DataBase
	public void toUpdateTheDataToDataBase(String UpdateQuery) throws SQLException {
		try {
			Statement state = conn.createStatement();
			int result = state.executeUpdate( UpdateQuery);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// To close the Connection With DataBase
	public void closeConnectionWithDataBase() throws SQLException{
		try{
             conn.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
