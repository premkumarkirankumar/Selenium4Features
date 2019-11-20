package selenium4Features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.security.Security;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDevToolsLoadInsecureSite {
	
	@Test
	public void insecureSiteLoad() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		DevTools devTools=((ChromiumDriver)driver).getDevTools();
		
		devTools.createSession();
		
		devTools.send(Security.setIgnoreCertificateErrors(true));
		
		driver.get("https://myit.allegistest.com/sp");
		driver.quit();

	}

}
