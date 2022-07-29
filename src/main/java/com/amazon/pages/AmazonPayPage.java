package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.base.Base;

public class AmazonPayPage extends Base {

	// Page Factory (Object Repository)
	@FindBy(xpath = "//div[@id= 'apay-sticker']/a/img")
	WebElement amazonPayImage;

	@FindBy(xpath = "//span[text() = 'Mobile Recharge']")
	WebElement mobileRechargeIcon;

	// Constructor - initializing the Page Objects
	public AmazonPayPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// Verify AmazonPay Page Title
	public String amazonPayPageTitle() {
		return driver.getTitle();
	}

	// Verify Amazon Pay Logo on Amazon Pay Landing Page
	public boolean amazonPayImageOnLandingPage() {
		return amazonPayImage.isDisplayed();
	}

	// Click on Mobile Recharge icon on AmazonPay Page
	public void goToMobileRechargeIcon() {
		mobileRechargeIcon.click();
	}

}
