package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.base.Base;

public class MobileRechargePage extends Base {

	// Page Factory (Object Repository)
	@FindBy(id = "mobileNumberTextInputId")
	WebElement mobileNumber;

	@FindBy(id = "operatorCircleLink")
	WebElement OperatorCircleEdit;

	@FindBy(xpath = "//a[normalize-space(text()) = 'View plans']")
	WebElement ViewPlans;

	@FindBy(id = "shortDescriptionFormLabelId")
	WebElement verifyPlanName;

	@FindBy(id = "amountTextInputId")
	WebElement verifyPlanAmount;

	@FindBy(id = "payButtonText")
	WebElement payButton;

	// Constructor - initializing the Page Objects
	public MobileRechargePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// Enter Mobile Phone number
	public void enterMobilePhoneNo(String mobileNo) {
		mobileNumber.sendKeys(mobileNo);
	}

	// Select Mobile Operator & Circle
	public void selectMobileOperatorAndCircleName(String operatorName, String operatorCircle)
			throws InterruptedException {
		OperatorCircleEdit.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text() = '" + operatorName + "']/preceding-sibling :: i")).click();
		// CircleTab.click();
		driver.findElement(By.xpath("//span[text() = '" + operatorCircle + "']/preceding-sibling :: i")).click();
	}

	// Select Recharge Amount Plan
	public void chooseMobileRechargePlanNameAndAmount(String PlanName, String Amount) {
		ViewPlans.click();
		if (driver.findElement(By.xpath("//input[contains(@value , '" + PlanName + "~" + Amount + "~')]"))
				.isDisplayed()) {
			driver.findElement(By.xpath("//input[contains(@value , '" + PlanName + "~" + Amount + "~')]")).click();
		} else {
			driver.findElement(By.xpath("//a[normalize-space(text())= '" + PlanName + "']")).click();
			driver.findElement(By.xpath("//input[contains(@value , '" + PlanName + "~" + Amount + "~')]")).click();
		}
	}

	// Assert Recharge Plan Name
	public String verifyRechargePlanName() {
		String[] a = verifyPlanName.getText().split(":");
		String[] b = a[1].split(",");
		String planName = b[0].trim();
		return planName;
	}

	// Assert Recharge Plan Amount
	public String verifyRechargePlanAmount() {
		String[] a = payButton.getText().split("₹");
		return a[1];
	}

	// Click on Contoinue To Pay Button
	public void continueToPayButton() {
		payButton.click();
	}

}
