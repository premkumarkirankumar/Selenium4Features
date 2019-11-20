package selenium4Features;


import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;
import org.testng.annotations.Test;
import static org.openqa.selenium.devtools.network.Network.loadingFailed;
import static org.testng.Assert.assertEquals;
import static org.openqa.selenium.devtools.network.Network.emulateNetworkConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDevToolsNetworkOfflineOnline {
	
	WebDriver driver;
	
	
	@Test(priority=1)
	public void enableNetworkOffline() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		DevTools devTools=((ChromiumDriver)driver).getDevTools();
		
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.of(1000000),Optional.empty(), Optional.empty()));
		//latency , throughput
		//devTools.send(emulateNetworkConditions(true, 100,1000,2000,Optional.of(ConnectionType.ethernet)));
		//adding a listeners
		//devTools.addListener(loadingFailed(), loadingFailed -> assertEquals(loadingFailed.getErrorText(),"net::ERR_INTERNET_DISCONNECTED"));
		
		
	    devTools.send(emulateNetworkConditions(true, 100, 1000, 2000, Optional.of(ConnectionType.ethernet)));

	    devTools.addListener(loadingFailed(), loadingFailed -> assertEquals(loadingFailed.getErrorText(), "net::ERR_INTERNET_DISCONNECTED"));
		
		driver.get("https://myit.allegistest.com/sp");
		driver.quit();
			
	}
	
	@Test(priority=2)
	public void enableNetworkOnline() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		DevTools devTools=((ChromiumDriver)driver).getDevTools();
		
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.of(1000000),Optional.empty(), Optional.empty()));

		//change the parameter to false
	    devTools.send(emulateNetworkConditions(false, 100, 1000, 2000, Optional.of(ConnectionType.ethernet)));

		driver.get("https://myit.allegistest.com/sp");
		driver.quit();
	}
	

}
