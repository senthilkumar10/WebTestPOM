package com.gfk.web_test.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gfk.web_test.Pages.LoginOrCreateAccountPage;
import com.gfk.web_test.Pages.MyAccountPage;
import com.gfk.web_test.Pages.MyStorePage;
import com.gfk.web_test.util.DriverScript;

public class TC_02_Login extends DriverScript {

	MyStorePage storePage;
	LoginOrCreateAccountPage loginPage;
	MyAccountPage acctPage;

	@BeforeClass
	public void setData() {
		testCaseName = "TC02_Login";
		testDescription = "To validate existing users are able to login to the app";
	}


	@Test
	public void testLogin() throws Exception {	
		storePage = new MyStorePage(driver, test);
		loginPage = new LoginOrCreateAccountPage(driver, test);
		acctPage = new MyAccountPage(driver, test);

		storePage.clickSignInButton();
		loginPage.inputExistingEmailID("reagangould@gmail.com");
		loginPage.inputPassword("testpassword");
		loginPage.clickLoginBtn();
		
		String fullName = "Reagan Gould";

		//**************************
		
		if(acctPage.getHeadingTxt().equalsIgnoreCase("MY ACCOUNT")) {
			reportStep("The Heading Text is as exepected : "+acctPage.getHeadingTxt(), "Pass");
		}else {
			reportStep("The Heading Text is not as exepected and the actual text is : "+acctPage.getHeadingTxt(), "Fail");
		}

		assertEquals(acctPage.getHeadingTxt(), "MY ACCOUNT");
		
		//**************************

		if(acctPage.getURLTxt().contains("controller=my-account")) {
			reportStep("The Account Page is opened", "Pass");
		}else {
			reportStep("The Account Page is not opened", "Fail");
		}

		assertTrue(acctPage.getURLTxt().contains("controller=my-account"));

		//**************************

		if(acctPage.getAccountName().equalsIgnoreCase(fullName)) {
			reportStep("The User Name is exepected : "+acctPage.getAccountName(), "Pass");
		}else {
			reportStep("he User Name is not as exepected and the actual text is : "+acctPage.getAccountName(), "Fail");
		}

		assertEquals(acctPage.getAccountName(), fullName);

		//**************************

		if(acctPage.getWelcomeMessage().contains("Welcome to your account.")) {
			reportStep("The welcome text is as exepected : "+acctPage.getWelcomeMessage(), "Pass");
		}else {
			reportStep("The welcome text is not as exepected and the actual text is : "+acctPage.getWelcomeMessage(), "Fail");
		}

		assertTrue(acctPage.getWelcomeMessage().contains("Welcome to your account."));

		//**************************

		if(acctPage.verifyLogoutBtnvisibility()) {
			reportStep("The Logout action is available","Pass");
		}else {
			reportStep("The Logout action is not available","Fail");
		}

		assertTrue(acctPage.verifyLogoutBtnvisibility());
		
		//**************************

	}

}
