package com.amazon.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtil {

	static ExtentReports extentReports;

	public static ExtentReports getReportObejct() {
		// ExtentReports , ExtentSparkReporter
		String path = System.getProperty("user.dir") + "\\Reports\\ExtentReport.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
		extentSparkReporter.config().setReportName("Web Automation Results");
		extentSparkReporter.config().setDocumentTitle("Test Results");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Kishan");
		return extentReports;
	}
}
