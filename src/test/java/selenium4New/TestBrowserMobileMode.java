package selenium4New;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.WaitUtils;

public class TestBrowserMobileMode {
	
	@Description("Test to open the browser in Mobile Mode")
	@Test
	public void testOpenBrowserMobileMode() throws Exception {


		Map<String,String> mobileEm = new HashMap<String,String>();
		mobileEm.put("deviceName", "iPhone X");
		
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("mobileEmulation",mobileEm );
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://selenium.dev/");
		WaitUtils.hardWait(5000);
		driver.quit();

	}
}
