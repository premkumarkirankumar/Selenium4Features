package selenium4New;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestBrowserIncognito extends Base {
	
	@Description("Test to open the browser in incognito mode")
	@Test
	public void testOpenBrowserIngnito() throws Exception {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("incognito");		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://selenium.dev/");
		WaitUtils.hardWait(5000);
		driver.quit();
	}
}
