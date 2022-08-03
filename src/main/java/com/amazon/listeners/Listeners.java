package com.amazon.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.amazon.base.Base;
import com.amazon.util.ReportUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener {

	ExtentTest test;
	ExtentReports reportObj = ReportUtil.getReportObejct();

	public void onTestStart(ITestResult result) {
		test = reportObj.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String methodName = result.getMethod().getMethodName();
		test.addScreenCaptureFromPath(takeScreenshot(methodName), methodName);
	}

	public void onTestSkipped(ITestResult result) {
		test.skip(result.getThrowable());
		String methodName = result.getMethod().getMethodName();
		test.addScreenCaptureFromPath(takeScreenshot(methodName), methodName);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		reportObj.flush();

	}

}
