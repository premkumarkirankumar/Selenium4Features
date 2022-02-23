package selenium4New;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;


public class TestPageLoadStrategies extends Base {

	
	@Description("Test load the page with option None")
	@Test
	public void testPageLoadNone() throws Exception {

		ChromeOptions opt = new ChromeOptions();
		opt.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		long start = System.currentTimeMillis();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		driver.findElement(By.xpath("//a/span[contains(text(),'Downloads')]")).click();
		long stop = System.currentTimeMillis();
		log.info(stop-start);
		driver.quit();
	}
	
	
	@Description("Test load the page with option Normal")
	@Test
	public void testPageLoadNormal() throws Exception {

		ChromeOptions opt = new ChromeOptions();
		opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		long start = System.currentTimeMillis();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		driver.findElement(By.xpath("//a/span[contains(text(),'Downloads')]")).click();
		long stop = System.currentTimeMillis();
		log.info(stop-start);
		driver.quit();
	}
	
	@Description("Test load the page with option Eager")
	@Test
	public void testPageLoadEager() throws Exception {

		ChromeOptions opt = new ChromeOptions();
		opt.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		long start = System.currentTimeMillis();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		driver.findElement(By.xpath("//a/span[contains(text(),'Downloads')]")).click();
		long stop = System.currentTimeMillis();
		log.info(stop-start);
		driver.quit();
	}
	
	
}
