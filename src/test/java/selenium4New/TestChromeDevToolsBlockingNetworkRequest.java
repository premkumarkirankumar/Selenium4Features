package selenium4New;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestChromeDevToolsBlockingNetworkRequest extends Base{

	@Description("Test to verify Blocking Network Requests")
	@Test
	public void testBlockNetworkRequest() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg",".png","*.jpeg")));
		
		driver.get("https://www.cnn.com/");
		WaitUtils.hardWait(10000);
		driver.quit();
	}



}
