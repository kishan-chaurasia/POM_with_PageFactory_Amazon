package com.amazon.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.amazon.base.Base;
import com.amazon.pages.AmazonPayPage;
import com.amazon.pages.BillingAddressPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.MobileRechargePage;
import com.amazon.pages.PaymentGatewayPage;
import com.amazon.pages.YourAccountPage;
import com.amazon.util.TestUtil;

@Listeners(com.amazon.listeners.Listeners.class)
public class PaymentGatewayPageTestCase extends Base {

	LoginPage loginPage;
	HomePage homePage;
	AmazonPayPage amazonPayPage;
	MobileRechargePage mobileRechargePage;
	PaymentGatewayPage paymentGatewayPage;
	TestUtil testUtil;
	BillingAddressPage billingAddressPage;
	YourAccountPage yourAccountPage;
	WebDriverWait wait;

	@BeforeMethod
	public void loginSetUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		amazonPayPage = new AmazonPayPage();
		mobileRechargePage = new MobileRechargePage();
		paymentGatewayPage = new PaymentGatewayPage();
		billingAddressPage = new BillingAddressPage();
		yourAccountPage = new YourAccountPage();
		testUtil = new TestUtil();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		loginPage.goToLoginPage();
		loginPage.loginPageUsernameAndPassword(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void addMobileRechargeAndPerformPaymentWithDebitCard() throws InterruptedException {
		homePage.goToAmazonPayPage();
		amazonPayPage.goToMobileRechargeIcon();
		mobileRechargePage.enterMobilePhoneNo("8108042771");
		mobileRechargePage.selectMobileOperatorAndCircleName("Vi", "Maharashtra & Goa");
		mobileRechargePage.chooseMobileRechargePlanNameAndAmount("Popular", "99");
		mobileRechargePage.continueToPayButton();
		paymentGatewayPage.selectDebitOrCreditCardPaymentCheckbox();
		paymentGatewayPage.addDebitOrCreditCard();
		testUtil.switchToFrame("ApxSecureIframe");
		paymentGatewayPage.enterDebitOrCreditCardDetails("5299920000000149", "Testing Account", 06, 2025);
		paymentGatewayPage.addYourCardButton();
		driver.switchTo().parentFrame();
		paymentGatewayPage.enterCardCvv("246");
		paymentGatewayPage.saveCardAsPerNewRbiGuidelinesCheckbox();
		paymentGatewayPage.placeOrderAndPayBtnPaymentPage();
		billingAddressPage.useThisAddressBtn();
	}

	@Test(priority = 2)
	public void removePaymentMethodDebitAndCreditCardTest() throws InterruptedException {
		homePage.goToYourAccountPage();
		yourAccountPage.goToPaymentOptionsTab();
		testUtil.scrollPageToElement(
				driver.findElement(By.xpath("//span[text() = 'Your default purchase preference']")));
		yourAccountPage.yourSavedCreditAndDebitCardsOption();
		yourAccountPage.removeDebitAndCreditCardButton();
		yourAccountPage.confirmRemoveDebitAndCreditCardButton();
		String Message = yourAccountPage.paymentMethodRemovedMessage();
		Assert.assertEquals(Message, "Payment method removed", "Assert Message not Found");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
