package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.amazon.base.Base;
import com.amazon.pages.AmazonPayPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;

@Listeners(com.amazon.listeners.Listeners.class)
public class AmazonPayPageTestCase extends Base {

	LoginPage loginPage;
	HomePage homePage;
	AmazonPayPage amazonPayPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		amazonPayPage = new AmazonPayPage();
		loginPage.goToLoginPage();
		loginPage.loginPageUsernameAndPassword(prop.getProperty("username"), prop.getProperty("password"));
		homePage.goToAmazonPayPage();
	}

	@Test(priority = 1)
	public void verifyAmazonPayPageTitleTest() {
		String title = amazonPayPage.amazonPayPageTitle();
		Assert.assertEquals(title, "Amazon Pay");
	}

	@Test(priority = 2)
	public void verifyAmazonPayPageImageTest() {
		boolean flag = amazonPayPage.amazonPayImageOnLandingPage();
		Assert.assertTrue(flag, "Amazon Pay image/Logo not Found");
	}

	@Test(priority = 3)
	public void goToMobileRechargeIconTest() {
		amazonPayPage.goToMobileRechargeIcon();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
