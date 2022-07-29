package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Base;

public class HomePage extends Base {

	// Page Factory (Object Repository)
	@FindBy(xpath = "//span[@id = 'nav-link-accountList-nav-line-1']")
	WebElement userName;

	@FindBy(xpath = "//a[text() = 'Amazon Pay']")
	WebElement amazonPay;

	@FindBy(id = "nav-link-accountList")
	WebElement accountAndListsTab;

	// Constructor - initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Verify Page Title after Login
	public String homePageTitle() {
		return driver.getTitle();
	}

	// Verify whether user is logged in with his own id name
	public String loggedInUserName() {
		return userName.getText();
	}

	// Go to Amazon Pay Tab on HomePage
	public void goToAmazonPayPage() {
		amazonPay.click();
	}

	// Click on Account And Lists Tab on HomePage
	public void goToYourAccountPage() {
		accountAndListsTab.click();
	}

}
