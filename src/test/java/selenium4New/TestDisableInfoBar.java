package selenium4New;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestDisableInfoBar extends Base {
	
	@Description("Test to disable the info bar")
	@Test
	public void testDisableInfoBar() throws Exception {

		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://selenium.dev/");
		driver.manage().window().maximize();
		WaitUtils.hardWait(5000);
		driver.quit();
	}
}
