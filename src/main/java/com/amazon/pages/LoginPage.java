package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Base;

public class LoginPage extends Base {

	// Page Factory (Object Repository)
	@FindBy(id = "nav-link-accountList")
	WebElement accountAndListsTab;

	@FindBy(xpath = "//i[@role = 'img']")
	WebElement amazonLogo;

	@FindBy(id = "ap_email")
	WebElement username;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(id = "ap_password")
	WebElement password;

	@FindBy(id = "signInSubmit")
	WebElement signInBtn;

	// Constructor - initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// Go To Login Page from HomePage
	public void goToLoginPage() {
		accountAndListsTab.click();
	}

	// Get Title of LoginPage
	public String loginPageTitle() {
		return driver.getTitle();
	}

	// validate Amazon Logo
	public boolean loginPageAmazonLogo() {
		return amazonLogo.isDisplayed();
	}

	// Login with username and Password
	public void loginPageUsernameAndPassword(String un, String pd) {
		username.sendKeys(un);
		continueBtn.click();
		password.sendKeys(pd);
		signInBtn.click();
	}

}
