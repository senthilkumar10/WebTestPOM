package com.gfk.web_test.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gfk.web_test.Listner.EventHandler;
import com.gfk.web_test.Report.ExtentReporter;

public class GenericMethods extends ExtentReporter {

	public WebDriver driver;

	public void initialize() {
		String browser=ReadPropertyFile.get("Browser");
		if(browser.equalsIgnoreCase("chrome")|| browser.toUpperCase().contains("CHROME")){
			try{
				System.setProperty("webdriver.chrome.driver",OsPath.getPath(browser));
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--incognito");
				DesiredCapabilities capabilites=DesiredCapabilities.chrome();
				capabilites.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver(options);
				reportStep("The browser:" + browser + " launched successfully", "PASS");
			}
			catch (Exception e){
				e.printStackTrace();
				reportStep("The browser:" + browser + " could not be launched", "FAIL");
			}
		}
		else if (browser.equalsIgnoreCase("FF")|| browser.toUpperCase().contains("FIRE")) {
			try{
				System.setProperty("webdriver.gecko.driver",OsPath.getPath(browser));
				FirefoxOptions FFoptions=new FirefoxOptions();
				driver=new FirefoxDriver(FFoptions);
				reportStep("The browser:" + browser + " launched successfully", "PASS");
			}
			catch(Exception e){
				e.printStackTrace();
				reportStep("The browser:" + browser + " could not be launched", "FAIL");
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.EventHandlerInit();
		driver.get(ReadPropertyFile.get("URL"));
		driver.manage().deleteAllCookies();
	}

	//quits browser
	public void tearDown(){
		if (driver != null) {
			driver.quit();
		}
	}


	//initializes WebDriver EventListner
	public void EventHandlerInit(){
		EventFiringWebDriver eventHandle=new EventFiringWebDriver(driver);
		EventHandler handler=new EventHandler();
		eventHandle.register(handler);
		driver=eventHandle;
	}

	public void dynamicWaitToClick(long time, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void dynamicWaitToBeVisible(long time, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}


	public boolean clickElement(WebElement ele) {
		String text = "";
		try {
			dynamicWaitToClick(60, ele);		
			text = ele.getText();
			ele.click();
			reportStep("The element : "+text+" is clicked "+text, "PASS");
			return true;
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" is not interactable", "FAIL",true);
			return false;
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(), "FAIL",true);
			return false;
		} 
	}

	public boolean type(WebElement ele, String input) {
		try {
			ele.clear();
			ele.sendKeys(input);
			reportStep("The data: "+input+" entered successfully in field :"+ele.getText(), "PASS");
			return true;
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+ele.getText()+" is not interactable","FAIL",true);
			return false;
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(), "FAIL",true);
			return false;
		}
	}

	public boolean selectDropDownUsingText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			reportStep("The dropdown is selected with text "+value,"PASS");
			return true;
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(), "FAIL",true);
			return false;
		}

	}

	public boolean selectDropDownUsingValue(WebElement ele, String value) {
		try {
			new Select(ele).selectByValue(value);
			reportStep("The dropdown is selected with value "+value,"PASS");
			return true;
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(), "FAIL",true);
			return true;
		}

	}

	public boolean selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			reportStep("The dropdown is selected with index "+index,"PASS");
			return true;
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(), "FAIL",true);
			return true;
		} 

	}

	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(), "FAIL");
		}
		return bReturn;
	}

	public String getAttribute(WebElement ele, String attribute) {		
		String bReturn = "";
		try {
			bReturn=  ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(), "FAIL");
		} 
		return bReturn;
	}

	@Override
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) , new File("./TestResults/Snapshots/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	public void setDateForLog4j() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy hhmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}

}
