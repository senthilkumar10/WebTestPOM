package com.gfk.web_test.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gfk.web_test.Pages.LoginOrCreateAccountPage;
import com.gfk.web_test.Pages.MyAccountPage;
import com.gfk.web_test.Pages.MyStoreCategorisedShoppingPage;
import com.gfk.web_test.Pages.MyStorePage;
import com.gfk.web_test.util.DriverScript;

public class TC_03_Checkout extends DriverScript {

	MyStorePage storePage;
	LoginOrCreateAccountPage loginPage;
	MyAccountPage acctPage;
	MyStoreCategorisedShoppingPage shoppingPage;

	@BeforeClass
	public void setData() {
		dataSheetName="TC003_Checkout";
		testCaseName = "TC03_Checkout";
		testDescription = "To validate the checkout process for an existing user";
	}


	@Test(dataProvider="fetchData")
	public void testCheckOut(String emailId,String password,String category,String shoppingItem,
			String quantity,String size, String color) throws Exception {	
		storePage = new MyStorePage(driver, test);
		loginPage = new LoginOrCreateAccountPage(driver, test);
		acctPage = new MyAccountPage(driver, test);
		shoppingPage = new MyStoreCategorisedShoppingPage(driver, test);

		storePage.clickSignInButton();
		loginPage.inputExistingEmailID(emailId);
		loginPage.inputPassword(password);
		loginPage.clickLoginBtn();
		acctPage.clickCategories(category); 
		shoppingPage.clickShoppingItem(shoppingItem);
		shoppingPage.inputQuantity(quantity);
		shoppingPage.selectSize(size);
		shoppingPage.selectColor(color);
		shoppingPage.clickAddToCartBtn();
		shoppingPage.clickCartCheckOutBtn();
		shoppingPage.clickSummaryCheckOutBtn();
		shoppingPage.clickAddressCheckOutBtn();
		shoppingPage.clickAgreeTermsBtn();
		shoppingPage.clickShippingCheckOutBtn();
		shoppingPage.clickPayByWireBtn();
		shoppingPage.clickConfirmMyOrderBtn();
		
		//**************************

		if(shoppingPage.getHeadingTxt().equalsIgnoreCase("ORDER CONFIRMATION")) {
			reportStep("The Heading Text is as exepected : "+shoppingPage.getHeadingTxt(), "Pass");
		}else {
			reportStep("The Heading Text is not as exepected and the actual text is : "+shoppingPage.getHeadingTxt(), "Fail");
		}

		assertEquals("ORDER CONFIRMATION", shoppingPage.getHeadingTxt());
		
		//**************************

		if(shoppingPage.getURLTxt().contains("controller=order-confirmation")) {
			reportStep("The Order Confirmation Page is opened", "Pass");
		}else {
			reportStep("The Order Confirmation Page is not opened", "Fail");
		}

		assertTrue(shoppingPage.getURLTxt().contains("controller=order-confirmation"));
		
		//**************************
		
		if(shoppingPage.getOrderCompleteTxt().contains("Your order on My Store is complete.")) {
			reportStep("The order confirmation text is as exepected : "+shoppingPage.getOrderCompleteTxt(), "Pass");
		}else {
			reportStep("The Order confirmation text is not as exepected and the actual text is : "+shoppingPage.getOrderCompleteTxt(), "Fail");
		}

		assertTrue(shoppingPage.getOrderCompleteTxt().contains("Your order on My Store is complete."));

		//**************************
		
		if(shoppingPage.verifyPaymentTabIsDisplayed()) {
			reportStep("The Payment tab is the last step of ordering","Pass");
		}else {
			reportStep("The Payment tab is not the last step of ordering","Fail");
		}

		assertTrue(shoppingPage.verifyPaymentTabIsDisplayed());
		
		//**************************
		
		if(shoppingPage.verifyShippingTabIsDisplayed()) {
			reportStep("The Shipping tab is the previous step of ordering","Pass");
		}else {
			reportStep("The Payment tab is not the previous step of ordering","Fail");
		}

		assertTrue(shoppingPage.verifyShippingTabIsDisplayed());
		
		//**************************
	}

}
