package selenium4New;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.emulation.Emulation;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestChromeDevToolsTImeZone extends Base {

	@Description("Test to verify Overriding Time Zone")
	@Test
	public void testRunOverrideTimeZone() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://whatismytimezone.com/");
		WaitUtils.hardWait(5000);
		
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setTimezoneOverride("PST"));
		driver.get("https://whatismytimezone.com/");
		WaitUtils.hardWait(5000);
		driver.quit();
	}



}
