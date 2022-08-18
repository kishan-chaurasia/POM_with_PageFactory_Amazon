package com.amazon.testcases;

import java.io.File;

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

	@Test(priority = 1, enabled = false)
	public void UploadJpgImageAndDownloadAndDelete() throws Exception {
		iLovePdfComPage.goToJpgToPdfConverterOption();
		iLovePdfComPage.selectJpgImagesOption();
		iLovePdfComPage.uplodFileAutoIt("uplodfile.exe", "Apple.jpg");
		iLovePdfComPage.addMoreFilesBtn();
		iLovePdfComPage.uplodFileAutoIt("uplodfile.exe", "Mango.jpg");
		String count = iLovePdfComPage.uploadedFilesCount();
		Assert.assertEquals(count, "2", "Uploded Files Count Mis-match");
		iLovePdfComPage.convertToPdfBtn();
		iLovePdfComPage.downloadPdfBtn();
		Thread.sleep(5000);

		// Verify file download or not
		String downloadsDirPath = System.getProperty("user.dir") + File.separator + prop.getProperty("downloadsPath");
		boolean flag = iLovePdfComPage.fileDownloadVerification(downloadsDirPath + File.separator + "Apple.pdf");
		Assert.assertTrue(flag, "File not found / not downloaded...");

		// Get the latest downloaded file name from a specific directory
		String downloadedFileName = iLovePdfComPage.getLatestdownloadedFileNameAndDeleteIt(downloadsDirPath);
		System.out.println(downloadedFileName);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}