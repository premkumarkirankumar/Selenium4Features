package selenium4New;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.security.Security;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestChromeDevToolsSSLHandling extends Base {
	

	@Description("Test to verify bad SSL")
	@Test
	public void testBadSSLSite() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Security.enable());
		devTools.send(Security.setIgnoreCertificateErrors(true));	
		
		driver.get("https://expired.badssl.com/");
		WaitUtils.hardWait(5000);
		driver.quit();
	}

}