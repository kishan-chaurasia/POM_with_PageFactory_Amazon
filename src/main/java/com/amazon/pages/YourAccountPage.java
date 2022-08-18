package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Base;

public class YourAccountPage extends Base {

	@FindBy(xpath = "//div[@data-card-identifier='PaymentOptions']")
	WebElement paymentOptions;

	@FindBy(xpath = "//a[@data-action='a-expander-toggle']")
	WebElement savedDebitAndCreditCards;

	@FindBy(xpath = "//span[text() = 'Remove']/preceding ::  input[contains(@name , 'true')]")
	WebElement removeDebitAndCreditCardBtn;

	@FindBy(xpath = "//span[text() = 'Confirm remove']/preceding-sibling :: input")
	WebElement confirmRemoveBtn;

	@FindBy(xpath = "//span[text() = 'Payment method removed']")
	WebElement paymentMethodRemoved;

	// Constructor - initializing the Page Objects
	public YourAccountPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// Select Payment Options Tab in Your Account Page
	public void goToPaymentOptionsTab() {
		paymentOptions.click();
	}

	// Select Payment Options Tab in Your Account Page
	public void yourSavedCreditAndDebitCardsOption() {
		savedDebitAndCreditCards.click();
	}

	// Click on Debit and Credit Card Remove Button
	public void removeDebitAndCreditCardButton() {
		removeDebitAndCreditCardBtn.click();
	}

	// Click on Debit and Credit Card Confirmation Remove Button
	public void confirmRemoveDebitAndCreditCardButton() throws InterruptedException {
		Thread.sleep(2000);
		confirmRemoveBtn.click();
	}

	// Return String Message "Payment method removed"
	public String paymentMethodRemovedMessage() {
		return paymentMethodRemoved.getText();
	}

}
