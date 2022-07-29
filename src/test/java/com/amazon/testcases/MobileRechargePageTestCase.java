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
import com.amazon.pages.MobileRechargePage;

@Listeners(com.amazon.listeners.Listeners.class)
public class MobileRechargePageTestCase extends Base {

	LoginPage loginPage;
	HomePage homePage;
	AmazonPayPage amazonPayPage;
	MobileRechargePage mobileRechargePage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		amazonPayPage = new AmazonPayPage();
		mobileRechargePage = new MobileRechargePage();
		loginPage.goToLoginPage();
		loginPage.loginPageUsernameAndPassword(prop.getProperty("username"), prop.getProperty("password"));
		homePage.goToAmazonPayPage();
		amazonPayPage.goToMobileRechargeIcon();
	}

	@Test(priority = 1)
	public void insertMobileRechargeDetailsTest() throws InterruptedException {
		mobileRechargePage.enterMobilePhoneNo("8108042771");
		mobileRechargePage.selectMobileOperatorAndCircleName("Vi", "Maharashtra & Goa");
		mobileRechargePage.chooseMobileRechargePlanNameAndAmount("Hero Unlimited", "599");
		// Assert Recharge Plan Name
		String planName = mobileRechargePage.verifyRechargePlanName();
		Assert.assertEquals(planName, "Hero Unlimited");
		// Assert Recharge Plan Amount
		String planAmount = mobileRechargePage.verifyRechargePlanAmount();
		Assert.assertEquals(planAmount, "599");
		mobileRechargePage.continueToPayButton();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
