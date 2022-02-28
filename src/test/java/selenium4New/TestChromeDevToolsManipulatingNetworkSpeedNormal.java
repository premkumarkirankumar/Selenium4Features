package selenium4New;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;

public class TestChromeDevToolsManipulatingNetworkSpeedNormal extends Base {

	@Description("Test to verify Network Speed Normal Speed")
	@Test
	public void testRunNetworkSpeedNormal() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		driver.get("https://www.cnn.com/");
		driver.quit();
	}

}
