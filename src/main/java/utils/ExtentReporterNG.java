package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;

	/**
	 * Method to return extent object
	 * 
	 * @return
	 */
	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\extentReports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Test Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("SDET", "Kiran Kumar");
		return extent;

	}

}
