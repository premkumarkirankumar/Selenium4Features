package selenium4New;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestChromeDevToolsChangingBrowserAgent extends Base{

	@Description("Test to verify changing mu user agent")
	@Test
	public void testChangingUserAgent() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		driver.get("https://www.whatismybrowser.com/detect/what-is-my-user-agent");
		WaitUtils.hardWait(5000);

		//user agent passed is mac machine
		String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36";
		
		devTools.send(Network.setUserAgentOverride(userAgent, Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://www.whatismybrowser.com/detect/what-is-my-user-agent");
		WaitUtils.hardWait(5000);
		driver.quit();
	}



}
