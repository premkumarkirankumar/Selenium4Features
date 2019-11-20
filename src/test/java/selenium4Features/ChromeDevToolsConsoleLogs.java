package selenium4Features;

import static org.openqa.selenium.devtools.network.Network.emulateNetworkConditions;
import static org.openqa.selenium.devtools.network.Network.loadingFailed;
import static org.testng.Assert.assertEquals;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.Log;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDevToolsConsoleLogs {

	
	@Test
	public void consoleLogs() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		DevTools devTools=((ChromiumDriver)driver).getDevTools();
		
		devTools.createSession();
		
		devTools.send(Log.enable());
		
		//adding a listener
	    devTools.addListener(Log.entryAdded(), entry ->System.out.println(entry.asSeleniumLogEntry()));
	    
		driver.get("https://myit.allegistest.com/sp");
		driver.quit();
	}
}
