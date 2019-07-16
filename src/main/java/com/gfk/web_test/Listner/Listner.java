package com.gfk.web_test.Listner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.gfk.web_test.util.DriverScript;



public class Listner extends DriverScript implements ITestListener{
	
	Logger log = LogManager.getLogger(Listner.class);

	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test Case method "+result.getMethod().getMethodName()+" started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test Case successfully Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		reportStep("TestCase Failed", "Fail");
		log.error("Test case failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		reportStep("TestCase Failed", "Fail");
		log.error("Test case failed");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info(result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		log.info(context.getName());		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}

}
