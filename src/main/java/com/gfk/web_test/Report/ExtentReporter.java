package com.gfk.web_test.Report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class ExtentReporter {
	public ExtentTest test;
	public static ExtentReports extent;
	public String testCaseName, testDescription;
	SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_ hh_mm_ss");
	Date date = new Date();
	String currentDate = formatter.format(date);

	
	public void reportStep(String desc, String status, boolean bSnap) {

		if(bSnap && !status.equalsIgnoreCase("INFO")){
			long snapNumber = 100000l;
			
			try {
				snapNumber= takeSnap();
			} catch (Exception e) {
				e.printStackTrace();
			}
			desc = desc+test.
					addScreenCapture("./../TestResults/Snapshots/"+snapNumber+".jpg");
		}
		
		// Write if it is successful or failure or information
		if(status.equalsIgnoreCase("PASS")){
			test.log(LogStatus.PASS, desc);
		}else if(status.equalsIgnoreCase("FAIL")){
			test.log(LogStatus.FAIL, desc);
			throw new RuntimeException("FAILED");
		}else if(status.equalsIgnoreCase("WARN")){
			test.log(LogStatus.WARNING, desc);
		}else if(status.equalsIgnoreCase("INFO")){
			test.log(LogStatus.INFO, desc);
		}
	
	}
	
	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}


	public abstract long takeSnap();
	

	public ExtentReports startResult(){
		extent = new ExtentReports("./TestResults/Test Report_"+currentDate+".html", false);
		extent.loadConfig(new File("./src/main/resources/extentreport.xml"));
		return extent;
	}

	public ExtentTest startTestCase(String testCaseName, String testDescription){
		test = extent.startTest(testCaseName, testDescription);
		return test;
	}

	public void endResult(){		
		extent.flush();
	}

	public void endTestcase(){
		extent.endTest(test);
	}

	
	
}