package com.amazon.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	Logger log = LogManager.getLogger(LoginPageTestCase.class);

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		loginPage.goToLoginPage();
	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		log.debug("**********************LoginPageTitle Test Started************************");
		String title = loginPage.loginPageTitle();
		Assert.assertEquals(title, "Amazon Sign In");
		log.info("**********************Asserting LoginPageTitle Test Passed**********************");
	}

	@Test(priority = 2)
	public void verifyLoginPageAmazonLogoTest() {
		log.error("**********************LoginPageAmazonLogo Test Started************************");
		boolean flag = loginPage.loginPageAmazonLogo();
		Assert.assertTrue(flag);
		log.fatal("**********************Asserting LoginPageAmazonLogo Test Passed**********************");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
