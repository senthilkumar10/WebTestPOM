package com.gfk.web_test.Listner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class EventHandler implements WebDriverEventListener {

	Logger log = LogManager.getLogger(EventHandler.class);


	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		log.info("Alert Accepted");
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		log.info("Alert Dismissed");

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		log.info("Navigated to url: "+url);
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		log.info("Navigated back to page: "+driver.getTitle());

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		log.info("Navigated forward to page: "+driver.getTitle());

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		log.info("page Refreshed: "+driver.getTitle());

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		if(element!=null){
			log.info("Element found : "+element.toString());
		}
		else{
			log.info("Element found : "+by.toString());
		}
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		log.info("Clicked on element : "+element.toString());

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		if(keysToSend!=null && keysToSend.length>0){
			log.info("Entered value : "+String.valueOf(keysToSend[0])+"+ into element "+element.toString());
		}

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		log.error(throwable.getMessage());

	}

}
