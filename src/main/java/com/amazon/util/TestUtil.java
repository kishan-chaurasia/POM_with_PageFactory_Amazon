package com.amazon.util;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.base.Base;

public class TestUtil extends Base {

	public static long PAGE_LOAD_TIMEOUT = 15;
	public static long IMPLICIT_WAIT = 15;
	public static long EXPLICIT_WAIT = 20;
	

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

	// Explicit Wait
	public void explicitWait(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
}
