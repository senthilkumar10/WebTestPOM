package com.gfk.web_test.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.gfk.web_test.util.DriverScript;
import com.relevantcodes.extentreports.ExtentTest;

public class MyStoreCategorisedShoppingPage extends DriverScript{
	
			
	public MyStoreCategorisedShoppingPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
		
	//This is a dynamic xpath to choose a dress from the shopping list
	String xpathShoppingItem = "//h5//a[@title='%s']";
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement size;
	
	//This is a dynamic xpath to choose a color passed from Test Data
	String xpathColor = "//a[@name='%s']";
	
	@FindBy(xpath="//button[@name='Submit']/span")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
	WebElement cartCheckoutBtn;
	
	@FindBy(xpath="//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
	WebElement summaryCheckOutBtn;
	
	@FindBy(name="processAddress")
	WebElement addressCheckOutBtn;
	
	@FindBy(id="uniform-cgv")
	WebElement agreeTerms;
	
	@FindBy(name="processCarrier")
	WebElement shippingCheckOutBtn;
	
	@FindBy(className = "bankwire")
	WebElement payByBankWireBtn;
	
	@FindBy(xpath = "//*[@id='cart_navigation']/button")
	WebElement confirmMyOrderbtn;
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement headingOrderConf;
	
	@FindBy(xpath = "//*[@class='cheque-indent']/strong")
	WebElement orderCompleteTxt;
	
	@FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
	WebElement payment;
	
	@FindBy(xpath = "//li[@class='step_done step_done_last four']")
	WebElement shipping;
	
	public String getTitle() {
		return driver.getTitle();
	}
			
	public boolean clickShoppingItem(String shoppingItem) {
		return clickElement(driver.findElement(By.xpath(String.format(xpathShoppingItem, shoppingItem))));
	}
	
	public boolean inputQuantity(String input) {
		return type(quantity, input);
	}
	
	public boolean selectSize(String size) {
		return selectDropDownUsingText(this.size, size);
	}
	
	public boolean selectColor(String color) {
		return clickElement(driver.findElement(By.xpath(String.format(xpathColor, color))));
	}
	
	public boolean clickAddToCartBtn() {
		return clickElement(addToCartBtn);
	}
	
	public boolean clickCartCheckOutBtn() {
		return clickElement(cartCheckoutBtn);
	}
	
	public boolean clickSummaryCheckOutBtn() {
		return clickElement(summaryCheckOutBtn);
	}
	
	public boolean clickAddressCheckOutBtn() {
		return clickElement(addressCheckOutBtn);
	}
	
	public boolean clickAgreeTermsBtn() {
		return clickElement(agreeTerms);
	}
	
	public boolean clickShippingCheckOutBtn() {
		return clickElement(shippingCheckOutBtn);
	}
	
	public boolean clickPayByWireBtn() {
		return clickElement(payByBankWireBtn);
	}
	
	
	public boolean clickConfirmMyOrderBtn() {
		return clickElement(confirmMyOrderbtn);
	}
	
	public String getHeadingTxt() {
		dynamicWaitToBeVisible(10, headingOrderConf);
		return getText(headingOrderConf);
	}
	
	public String getURLTxt() {
		return driver.getCurrentUrl();
	}
	
	public String getOrderCompleteTxt() {
		return getText(orderCompleteTxt);
	}
	
	public boolean verifyPaymentTabIsDisplayed() {
		return payment.isDisplayed();
	}
	
	public boolean verifyShippingTabIsDisplayed() {
		return shipping.isDisplayed();
	}
	
}

