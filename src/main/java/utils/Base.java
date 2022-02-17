package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@AfterTest
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
		log.info("Browser for Test :" + browserName);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

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
	 * Method to take take screen of the page
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
	 * Method to do hard wait for specific seconds
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
		
}
