package com.amazon.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.amazon.base.Base;

public class TestUtil extends Base {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	// Switch To Frame Method
	public void switchToFrame(String frameName) throws InterruptedException {
		driver.switchTo().frame(frameName);
		Thread.sleep(1000);
	}

	// Scroll Method
	public void scrollPageToElement(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", webElement);
	}
}
