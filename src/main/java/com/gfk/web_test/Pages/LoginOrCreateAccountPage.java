package com.gfk.web_test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.gfk.web_test.util.DriverScript;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginOrCreateAccountPage extends DriverScript{

	
	public LoginOrCreateAccountPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email_create")
	WebElement emailAddress;

	@FindBy(id="SubmitCreate")
	WebElement createAnAccountBtn;
	
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement loginBtn;

	
	public String getTitle() {
		return driver.getTitle();
	}

	public boolean inputEmailAddress(String emailID) {
		return type(emailAddress, emailID);	
	}

	public boolean clickCreateAnAccountbtn() {
		return clickElement(createAnAccountBtn);
	}

	public boolean inputExistingEmailID(String emailID) {
		return type(email, emailID);	
	}
	

	public boolean inputPassword(String pwd) {
		return type(password, pwd);	
	}
	
	public boolean clickLoginBtn() {
		return clickElement(loginBtn);
	}

}
