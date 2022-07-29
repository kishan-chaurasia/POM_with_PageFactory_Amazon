package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.amazon.base.Base;
import com.amazon.pages.LoginPage;

@Listeners(com.amazon.listeners.Listeners.class)

public class LoginPageTestCase extends Base {

	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		loginPage.goToLoginPage();
	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.loginPageTitle();
		Assert.assertEquals(title, "Amazon Sign In");
	}

	@Test(priority = 2)
	public void verifyLoginPageAmazonLogoTest() {
		boolean flag = loginPage.loginPageAmazonLogo();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
