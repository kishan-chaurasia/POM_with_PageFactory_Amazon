package com.amazon.util;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.base.Base;

public class TestUtil extends Base {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static long EXPLICIT_WAIT = 20;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));

	// Switch To Frame Method
	public void switchToFrame(String frameName) throws InterruptedException {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		// driver.switchTo().frame(frameName);
		Thread.sleep(2000);
	}

	// Scroll Method
	public void scrollPageToElement(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", webElement);
	}

	// Explicit Wait - ElementToBeClickable
	public WebElement explicitWaitElementToBeClickable(WebElement webElement) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		return element;
	}

	// Explicit Wait - visibilityOf
	public void explicitWaitVisibilityOf(WebElement webElement) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
}
