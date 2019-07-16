package com.gfk.web_test.util;


import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


public class DriverScript extends GenericMethods{


	Logger log = Logger.getLogger(DriverScript.class);
	public String dataSheetName;


	//Initializes reports
	@BeforeSuite
	public void beforeSuite() {
		startResult();
	}

	//Initialise the browser before each @Test Method
	@BeforeMethod
	public void beforeMethod() {
		test = startTestCase(testCaseName, testDescription);
		setDateForLog4j();
		log.info("****GFK Code Assignment 1****");
		initialize();
	}

	//Closed browser at the end of the Method
	@AfterMethod
	public void afterMethod() {
		endTestcase();
		tearDown();
	}

	//closed report object
	@AfterSuite
	public void afterSuite() {
		endResult();
	}
	
	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		return ExcelDataProvider.getData(dataSheetName);		
	}	


}
