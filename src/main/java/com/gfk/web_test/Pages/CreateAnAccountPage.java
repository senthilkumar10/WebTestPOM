package com.gfk.web_test.Pages;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.gfk.web_test.util.DriverScript;
import com.relevantcodes.extentreports.ExtentTest;

public class CreateAnAccountPage extends DriverScript{
	
		
	public CreateAnAccountPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="id_gender1")
	WebElement mr;
	
	@FindBy(id="id_gender2")
	WebElement mrs;
	
	@FindBy(id="customer_firstname")
	WebElement custFirstName;
	
	@FindBy(id="customer_lastname")
	WebElement custLastName;
	
	@FindBy(id="email")
	WebElement emailAdres;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement postCode;
	
	@FindBy(id="other")
	WebElement additionalInfo;
	
	@FindBy(id="phone")
	WebElement homePhone;
	
	@FindBy(id="phone_mobile")
	WebElement mobPhone;
	
	@FindBy(id="alias")
	WebElement addressAlias;
	
	@FindBy(id="submitAccount")
	WebElement register;
	
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	
	public boolean selectTitle(String title ) {
		if(title.equalsIgnoreCase("Mr")) {
			return clickElement(mr);
		}else if(title.equalsIgnoreCase("Mrs")) {
			return clickElement(mrs);
		}
		return false;
	}
		
	public boolean inputCustFirstName(String custFirstName) {
		return type(this.custFirstName, custFirstName);
	}
	
	public boolean inputCustLastName(String custLastName) {
		return type(this.custLastName, custLastName);
	}
	
	public String getEmailAddresTxt() {
		return getAttribute(this.emailAdres, "value");
	}
	
	public boolean inputPassword(String pwd) {
		return type(this.password, pwd);
	}
	
	public boolean selectDOB(String days,String month,String years) {
		if(!StringUtils.isBlank(days) && !StringUtils.isBlank(month) && !StringUtils.isBlank(years) ) {
			selectDropDownUsingValue(this.days, days);
			selectDropDownUsingValue(this.months, month);
			selectDropDownUsingValue(this.years, years);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean inputFirstName(String firstName) {
		return type(this.firstName, firstName);
	}
	
	public boolean inputLastName(String lastName) {
		return type(this.lastName, lastName);
	}
	
	public boolean inputCompany(String companyName) {
		return type(this.company, companyName);
	}
	
	public boolean inputAddress1(String address1) {
		return type(this.address1, address1);
	}
	
	public boolean inputAddress2(String address2) {
		return type(this.address2, address2);
	}
	
	public boolean inputCity(String city) {
		return type(this.city, city);
	}
	
	public boolean selectState(String state) {
		return selectDropDownUsingText(this.state, state);
	}
	
	public boolean inputPostCode(String postCode) {
		return type(this.postCode, postCode);
	}
	
	
	public boolean inputAdditionaInfo(String addlInfo) {
		return type(this.additionalInfo, addlInfo);
	}
	
	public boolean inputHomePh(String homePhone) {
		return type(this.homePhone, homePhone);
	}
	
	public boolean inputMobilePh(String mobilePh) {
		return type(this.mobPhone, mobilePh);
	}
	
	public boolean inputAddressAlias(String addresAlias) {
		return type(this.addressAlias, addresAlias);
	}
	
	public boolean clickResgisterBtn() {
		return clickElement(this.register);
	}
	
	
}
