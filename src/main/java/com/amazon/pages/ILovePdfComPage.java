package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Base;

public class ILovePdfComPage extends Base {

	@FindBy(xpath = "//a[@title='JPG to PDF']")
	WebElement jpgToPdfOption;

	@FindBy(xpath = "//span[text() = 'Select JPG images']/parent :: a[@id = 'pickfiles']")
	WebElement selectJpgImage;

	@FindBy(xpath = "//a[@id='pickfiles']//*[name()='svg']")
	WebElement addMoreFilesButton;

	@FindBy(xpath = "//div[@id = 'filecount' and text() = '2']")
	WebElement FileCount;

	@FindBy(id = "processTask")
	WebElement convertToPdfButton;

	@FindBy(xpath = "//a[normalize-space()= 'Download PDF']")
	WebElement downloadPdfButton;

	// Constructor - initializing the Page Objects
	public ILovePdfComPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// Go To Jpg To Pdf Converter Tab
	public void goToJpgToPdfConverterOption() {
		jpgToPdfOption.click();
	}

	// Click on Select Jpg Image Option
	public void selectJpgImagesOption() {
		selectJpgImage.click();
	}

	// Click on Select Jpg Image Option
	public void addMoreFilesBtn() {
		addMoreFilesButton.click();
	}

	// Click on convert To Pdf Button
	public void convertToPdfBtn() {
		convertToPdfButton.click();
	}

	// Click on Download Pdf Button
	public void downloadPdfBtn() {
		downloadPdfButton.click();
	}

	// Method to Uplod File on iLovePdf.com
	public void uplodFileAutoIt(String autoItExeName, String fileName) throws Exception {
		String autoItExeFilePath = System.getProperty("user.dir") + "/AutoItFiles/";
		String fileOrDocPath = System.getProperty("user.dir") + "\\Sample_Images\\";
		Runtime.getRuntime().exec(autoItExeFilePath + autoItExeName + " " + fileOrDocPath + fileName);
	}

	// Return Uploded Files Count
	public String uploadedFilesCount() {
		return FileCount.getText();
	}
}
