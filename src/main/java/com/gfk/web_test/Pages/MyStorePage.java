package com.gfk.web_test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.gfk.web_test.util.DriverScript;
import com.relevantcodes.extentreports.ExtentTest;


public class MyStorePage extends DriverScript{
	
	public MyStorePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="login")
	private WebElement signIN;
	
	public String getTitle() {
		return driver.getTitle();
	}

	public void clickSignInButton() {	
		clickElement(signIN);	
	}
	
	
}
