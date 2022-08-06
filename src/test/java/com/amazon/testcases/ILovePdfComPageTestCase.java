package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.base.Base;
import com.amazon.pages.ILovePdfComPage;
import com.amazon.util.TestUtil;

@Listeners(com.amazon.listeners.Listeners.class)
public class ILovePdfComPageTestCase extends Base {

	ILovePdfComPage iLovePdfComPage;
	TestUtil testUtil;

	@BeforeMethod
	public void setUp() {
		initialization();
		iLovePdfComPage = new ILovePdfComPage();
		testUtil = new TestUtil();
		driver.navigate().to("https://www.ilovepdf.com");
	}

	@Test(priority = 1)
	public void UploadJpgImage() throws Exception {
		iLovePdfComPage.goToJpgToPdfConverterOption();
		iLovePdfComPage.selectJpgImagesOption();
		iLovePdfComPage.uplodFileAutoIt("uplodfile.exe", "Apple.jpg");
		iLovePdfComPage.addMoreFilesBtn();
		iLovePdfComPage.uplodFileAutoIt("uplodfile.exe", "Mango.jpg");
		String count = iLovePdfComPage.uploadedFilesCount();
		Assert.assertEquals(count, "2", "Uploded Files Count Mis-match");
		iLovePdfComPage.convertToPdfBtn();
		iLovePdfComPage.downloadPdfBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}