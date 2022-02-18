package selenium4New;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;

public class TestBrowsersDrivers {

	@Description("Test to verify Chrome Driver")
	@Test
	public void testChrome() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://astoncarter.com/en");
		System.out.println(driver.getTitle());
		driver.quit();
	}

	@Description("Test to verify Firefox Driver")
	@Test
	public void testFirefox() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://astoncarter.com/en");
		System.out.println(driver.getTitle());
		driver.quit();
	}

	@Description("Test to verify Firefox with specificversion Driver")
	@Test
	public void testFirefoxSpecificVersion() {
		WebDriverManager.firefoxdriver().driverVersion("0.30.0").setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://astoncarter.com/en");
		System.out.println(driver.getTitle());
		driver.quit();
	}

	@Description("Test to verify Edge Driver")
	@Test
	public void testEdge() {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://astoncarter.com/en");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
