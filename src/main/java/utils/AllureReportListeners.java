package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureReportListeners extends Base implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Text attachments for Allure
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}
	
///*	
	
	@Override
	public void onStart(ITestContext context) {
		log.info("Test Start :" + context.getName());
		context.setAttribute("WebDriver", Base.getDriver());

	}
	
	@Override
	public void onFinish(ITestContext context) {
		log.info("Test Finish :" + context.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test success : " + getTestMethodName(result) + " succeed");
		saveTextLog(getTestMethodName(result) + "Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("I am in onTestFailure method " + getTestMethodName(result) + " failed");
		WebDriver driver = Base.getDriver();
		// Allure ScreenShotRobot and SaveTestLog
		if (driver instanceof WebDriver) {
			log.info("Screenshot captured for test case:" + getTestMethodName(result));
			saveScreenshotPNG(driver);
		}
		// Save a log on allure.
		saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");
	}
//*/
/*
	@Override
	public void onTestStart(ITestResult result) {
		log.info("I am in onTestStart method " + getTestMethodName(result) + " start");
		saveTextLog(getTestMethodName(result) + " Test Started!");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("I am in onTestSuccess method " + getTestMethodName(result) + " succeed");
		saveTextLog(getTestMethodName(result) + "Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("I am in onTestFailure method " + getTestMethodName(result) + " failed");
		WebDriver driver = Base.getDriver();
		// Allure ScreenShotRobot and SaveTestLog
		if (driver instanceof WebDriver) {
			log.info("Screenshot captured for test case:" + getTestMethodName(result));
			saveScreenshotPNG(driver);
		}
		// Save a log on allure.
		saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("I am in onTestSkipped method " + getTestMethodName(result) + " skipped");
		saveTextLog(getTestMethodName(result) + "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("Test failed but it is in defined success ratio " + getTestMethodName(result));
		saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		log.info("I am in onStart method " + context.getName());
		context.setAttribute("WebDriver", Base.getDriver());

	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("I am in onFinish method " + context.getName());
	}
*/
}
