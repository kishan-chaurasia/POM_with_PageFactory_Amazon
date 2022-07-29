package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.amazon.base.Base;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;

@Listeners(com.amazon.listeners.Listeners.class)
public class HomePageTestCase extends Base {

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		loginPage.goToLoginPage();
		loginPage.loginPageUsernameAndPassword(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		Thread.sleep(1000);
		String title = homePage.homePageTitle();
		Assert.assertEquals(title,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

	@Test(priority = 2)
	public void verifyLoggedInUserNameTest() {
		String username = homePage.loggedInUserName();
		Assert.assertEquals(username, "Hello, Ashwin", "UserName not Found");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
