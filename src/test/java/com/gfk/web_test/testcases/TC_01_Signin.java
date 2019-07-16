package com.gfk.web_test.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gfk.web_test.Pages.CreateAnAccountPage;
import com.gfk.web_test.Pages.LoginOrCreateAccountPage;
import com.gfk.web_test.Pages.MyAccountPage;
import com.gfk.web_test.Pages.MyStorePage;
import com.gfk.web_test.util.DriverScript;
import com.gfk.web_test.util.RandomTestDataGenerator;

public class TC_01_Signin extends DriverScript {
	
	Logger log = Logger.getLogger(TC_01_Signin.class);

	MyStorePage storePage;
	LoginOrCreateAccountPage loginPage;
	CreateAnAccountPage createAccount;
	MyAccountPage acctPage;
	RandomTestDataGenerator randomTestData;

	@BeforeClass
	public void setData() {
		testCaseName = "TC01_Sign In";
		testDescription = "To validate the sign-in process of the app";
	}


	@Test
	public void testSignIn() throws Exception {	
		storePage = new MyStorePage(driver, test);
		loginPage = new LoginOrCreateAccountPage(driver, test);
		createAccount = new CreateAnAccountPage(driver, test);
		acctPage = new MyAccountPage(driver, test);
		randomTestData = new RandomTestDataGenerator();

		Map<String,String> testData = randomTestData.randomTDGen();

		log.info("User Date => "+testData);

		storePage.clickSignInButton();
		loginPage.inputEmailAddress(testData.get("email"));
		loginPage.clickCreateAnAccountbtn();
		createAccount.selectTitle(testData.get("title"));
		createAccount.inputCustFirstName(testData.get("firstname"));
		createAccount.inputCustLastName(testData.get("lastname"));

		reportStep("The Email id which is registered is "+testData.get("email"), "info");

		createAccount.inputPassword(testData.get("password"));
		createAccount.selectDOB(testData.get("day"), testData.get("month"), testData.get("year"));
		createAccount.inputCompany(testData.get("company"));
		createAccount.inputAddress1(testData.get("address1"));
		createAccount.inputAddress2(testData.get("address2"));
		createAccount.inputCity(testData.get("city"));
		createAccount.selectState("Colorado");
		createAccount.inputPostCode(testData.get("postcode"));
		createAccount.inputAdditionaInfo(testData.get("addlinfo"));
		createAccount.inputMobilePh(testData.get("mobilephone"));
		createAccount.inputAddressAlias(testData.get("alias"));
		createAccount.clickResgisterBtn();

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


		if(acctPage.getAccountName().equalsIgnoreCase(testData.get("firstname")+" "+testData.get("lastname"))) {
			reportStep("The User Name is exepected : "+acctPage.getAccountName(), "Pass");
		}else {
			reportStep("he User Name is not as exepected and the actual text is : "+acctPage.getAccountName(), "Fail");
		}

		assertEquals(acctPage.getAccountName(), testData.get("firstname")+" "+testData.get("lastname"));

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
