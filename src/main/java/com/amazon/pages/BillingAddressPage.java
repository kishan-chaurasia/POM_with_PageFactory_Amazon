package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.base.Base;

public class BillingAddressPage extends Base {

	@FindBy(xpath = "//a[normalize-space(text() = 'Use this address')]")
	WebElement useAddressBtn;

	// Constructor - initializing the Page Objects
	public BillingAddressPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// Select Debit or credit Card Payment checkbox
	public void useThisAddressBtn() {
		useAddressBtn.click();
	}

}
