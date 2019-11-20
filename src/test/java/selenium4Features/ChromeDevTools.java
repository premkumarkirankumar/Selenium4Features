package selenium4Features;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.testng.annotations.Test;

import com.google.common.base.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDevTools {
	
	WebDriver driver;
	
	
	@Test
	public void enableNetworkOffline() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		DevTools devtools=((ChromiumDriver)driver).getDevTools();
		
		devtools.createSession();
		
		//devtools.send(Network.enable(Optional.of(1000000),Optional.empty(), Optional.empty()));

			
	}
	

}
