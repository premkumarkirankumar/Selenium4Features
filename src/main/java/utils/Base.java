package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.HasFullPageScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void setup(ITestContext context) throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		context.setAttribute("WebDriver", driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	/**
	 * Method to initialize Driver
	 * 
	 * @return
	 * @throws IOException
	 */
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		String filepath = System.getProperty("user.dir") + "/src/main/java/resources/data.properties";
		FileInputStream fis = new FileInputStream(filepath);
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String browserRun = prop.getProperty("browserRun");
		log.info("Browser for Test :" + browserName);
		log.info("Browser to Run :" + browserRun);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (browserRun.equals("headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (browserRun.equals("headless")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
			} else {
				driver = new FirefoxDriver();
			}
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			if (browserRun.equals("headless")) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("headless");
				driver = new EdgeDriver(options);
			} else {
				driver = new EdgeDriver();
			}

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	/**
	 * Method to load custom url
	 * 
	 * @param url
	 */
	public void getCustomUrl(String url) {
		driver.get(url);
	}

	/**
	 * Method to Highlight an element
	 * 
	 * @param ele
	 * @param driver
	 */
	public static void highlightElement(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", ele);

	}

	/**
	 * Method to take take screen shot of the page
	 * 
	 * @param testCaseName
	 * @param driver
	 * @throws IOException
	 */
	public void getElementScreenShot(String testCaseName, WebDriver driver, WebElement element) throws IOException {
		File source = element.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

	}

	/**
	 * Method to take take screen shot of the page
	 * 
	 * @param testCaseName
	 * @param driver
	 * @throws IOException
	 */
	public void getScreenShot(String testCaseName, WebDriver driver) throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

	}

	/**
	 * Method to take take full page screen shot of the page
	 * 
	 * @param testCaseName
	 * @param driver
	 * @throws IOException
	 */
	public void getFullPageScreenShot(String testCaseName, WebDriver driver) throws IOException {
		// this is only implemented for firefox and has not yet implemented for chrom
		File source = ((HasFullPageScreenshot) driver).getFullPageScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

	}

	/**
	 * Method to take take screen of the page and return the path of it
	 * 
	 * @param testCaseName
	 * @param driver
	 * @throws IOException
	 */
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

	/**
	 * Method to do hard wait for specific seconds
	 * 
	 * @param secs
	 * @throws Exception
	 */
	public void hardWait(long secs) throws Exception {
		Thread.sleep(secs);
	}

	/*
	 * Method to get title
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Method for explicit wait for that element to be Clickable
	 * 
	 * @param by
	 * @param seconds
	 */
	public void waitForElementToBeClickable(By by, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();

	}

	/**
	 * Method to explicit wait for that element to be clickable with polling
	 * 
	 * @param by
	 * @param seconds
	 * @param pollingSeconds
	 */
	public void waitForElementToBeClickableWithPolling(By by, int seconds, int pollingSeconds) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
				.pollingEvery(Duration.ofSeconds(pollingSeconds)).withMessage("Time out as the condition is not met")
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();

	}

}
