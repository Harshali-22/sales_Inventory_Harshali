package com.client.Sales_Inventory.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.client.Sales_Inventory.BaseUtility.SuperBaseClass;
import com.client.Sales_Inventory.BaseUtility.UtilityClassObject;

/**
 * @author Harshali
 * This class is implemented to capture runtime events
 */

public class ListenerImpClass implements ISuiteListener, ITestListener {

	ExtentReports report;
	ExtentTest test;
	String timeStamp=new Date().toString().replace(" ","_").replace(":","_");
	
	@Override
	public void onStart(ISuite suite) {
		/* Configure Extent Report */
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/ProjectReport"+timeStamp+".html");
		spark.config().setDocumentTitle("SCM Suite Report");
		spark.config().setReportName("SCM Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", SuperBaseClass.browser);
		report.setSystemInfo("Operating System", "Windows");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		test=report.createTest(testName);
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, testName+" Execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		test.log(Status.PASS, testName+" Execution Completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName=result.getMethod().getMethodName();
		test.log(Status.FAIL, testName+" Execution Failed");
		
		/* Screenshot of failed test case */
		TakesScreenshot ts=(TakesScreenshot)UtilityClassObject.getDriver();
		String filePath=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath);
		test.log(Status.INFO,result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		test.log(Status.SKIP, testName+" Execution Skipped");
	}

	@Override
	public void onFinish(ISuite suite) {
		/*Report Backup*/
		report.flush();
	}

}
