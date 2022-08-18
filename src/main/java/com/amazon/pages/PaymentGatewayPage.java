package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Base;
import com.amazon.util.TestUtil;

public class PaymentGatewayPage extends Base {

	TestUtil testUtil = new TestUtil();

	@FindBy(xpath = "//input[@value = 'SelectableAddCreditCard']")
	WebElement cardPaymentCheckBox;

	@FindBy(xpath = "//a[text() = 'Add a credit or debit card']")
	WebElement addCardOption;

	@FindBy(name = "addCreditCardNumber")
	WebElement cardNumber;

	@FindBy(name = "ppw-accountHolderName")
	WebElement nameOnTheCard;

	@FindBy(xpath = "//span[contains(@id , '-21')]")
	WebElement cardExpiryMonthDropdown;

	@FindBy(xpath = "//span[contains(@id , '-22')]")
	WebElement cardExpiryYearDropdown;

	@FindBy(xpath = "//span[text() = 'Add your card']/preceding-sibling :: input")
	WebElement addYourCardBtn;

	@FindBy(xpath = "//input[@name = 'addCreditCardVerificationNumber0']")
	WebElement cardCvv;

	@FindBy(xpath = "//div[contains(@id , '-113')]//input")
	WebElement saveCardRbiGuidelinesCheckbox;

	@FindBy(xpath = "//input[@name = 'ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']")
	WebElement placeOrderAndPayBtn;

	// Constructor - initializing the Page Objects
	public PaymentGatewayPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// Select Debit or credit Card Payment checkbox
	public void selectDebitOrCreditCardPaymentCheckbox() {
		cardPaymentCheckBox.click();
	}

	// Click on Add Debit or Credit Card
	public void addDebitOrCreditCard() {
		addCardOption.click();
	}

	// Add Debit Or Credit Card Details
	public void enterDebitOrCreditCardDetails(String cardNo, String nameOnCard, int cardExpiryMonth,
			int cardExpiryYear) {
		cardNumber.sendKeys(cardNo);
		nameOnTheCard.clear();
		nameOnTheCard.sendKeys(nameOnCard);
		cardExpiryMonthDropdown.click();
		driver.findElement(By.xpath("//a[contains(@id , '-18_" + (cardExpiryMonth - 1) + "')]")).click();
		cardExpiryYearDropdown.click();
		driver.findElement(By.xpath("//a[text() = '" + cardExpiryYear + "']")).click();

	}

	// Click On Add Your Card Btn
	public void addYourCardButton() {
		addYourCardBtn.click();
	}

	// Enter Card CVV number
	public void enterCardCvv(String cvv) {
		cardCvv.sendKeys(cvv);
	}

	// Tick Checkbox Save Card as per New RBI Guidelines
	public void saveCardAsPerNewRbiGuidelinesCheckbox() throws InterruptedException {
		Thread.sleep(1000);
		saveCardRbiGuidelinesCheckbox.click();
	}

	// Click on Place Order And Pay Button (Select a Payment Method)
	public void placeOrderAndPayBtnPaymentPage() {
		placeOrderAndPayBtn.click();
	}

}
