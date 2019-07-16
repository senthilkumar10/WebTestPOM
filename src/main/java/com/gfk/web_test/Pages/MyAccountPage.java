package com.gfk.web_test.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.gfk.web_test.util.DriverScript;
import com.relevantcodes.extentreports.ExtentTest;

public class MyAccountPage extends DriverScript{
	
			
	public MyAccountPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement myAccountheading;
	
	@FindBy(className = "account")
	WebElement accountName;
	
	@FindBy(className = "info-account")
	WebElement welcomeMsg;
	
	@FindBy(className = "logout")
	WebElement logoutbtn;
	
	//This is a dynamic xpath which would allow us to click any one of three catagories [Women,Dresses,T-shirts]	
	String xpathCategory = "//div[@id='block_top_menu']/ul/li/a[@title='%s']";
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	
	public String getHeadingTxt() {
		dynamicWaitToBeVisible(10, myAccountheading);
		return getText(myAccountheading);
	}
	
	public String getAccountName() {
		return getText(accountName);
	}
	
	public String getWelcomeMessage() {
		return getText(welcomeMsg);
	}
	
	public boolean verifyLogoutBtnvisibility() {
		return logoutbtn.isDisplayed();
	}
	
	public String getURLTxt() {
		return driver.getCurrentUrl();
	}
	
	public boolean clickCategories(String category) {
		return clickElement(driver.findElement(By.xpath(String.format(xpathCategory, category))));
	}
	
}

