package com.gfk.web_test.util;

public class OsPath {
	//Provide browser exe path based on OS
	public static String getPath(String browser) 
	{
		String OS=System.getProperty("os.name");
		String driverPath=null;
		if(OS.toUpperCase().contains("WINDOWS"))
		{
			if(browser.toUpperCase().contains("CHROME"))
			{
				driverPath=".//src//main//resources//drivers//chromedriver.exe";
			}
			else if(browser.toUpperCase().contains("FF")||browser.toUpperCase().contains("FIRE"))
			{
				driverPath=".//src//main//resources//drivers//geckodriver.exe";

			}
		}
		else if(OS.toUpperCase().contains("MAC"))
		{
			if(browser.toUpperCase().contains("CHROME"))
			{
				driverPath=".//src//main//resources//drivers//chromedriver";
			}
			else if(browser.toUpperCase().contains("FF")||browser.toUpperCase().contains("FIRE"))
			{
				driverPath=".//src//main//resources//drivers//geckodriver";
			}
		}
		return driverPath;
	}

}
