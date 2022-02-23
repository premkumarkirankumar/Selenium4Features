package selenium4New;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.openqa.selenium.devtools.v96.network.model.ConnectionType;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;

public class TestChromeDevToolsManipulatingNetworkSpeed extends Base {

	@Description("Test to verify Network Speed 2G")
	@Test
	public void testRunNetworkSpeed2G() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		//download throughput and upload throughput can be changed
		devTools.send(Network.emulateNetworkConditions(false, 100, 20000, 10000, Optional.of(ConnectionType.CELLULAR2G)));
		
		driver.get("https://www.cnn.com/");
		driver.quit();
	}
	
	@Description("Test to verify Network Speed 3G")
	@Test
	public void testRunNetworkSpeed3G() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 100, 20000, 10000, Optional.of(ConnectionType.CELLULAR3G)));
		
		driver.get("https://www.cnn.com/");
		driver.quit();
	}
	
	@Description("Test to verify Network Speed 4G")
	@Test
	public void testRunNetworkSpeed4G() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 100, 20000, 10000, Optional.of(ConnectionType.CELLULAR4G)));
		
		driver.get("https://www.cnn.com/");
		driver.quit();
	}
	
	
	@Description("Test to verify Network Speed BlueTooth")
	@Test
	public void testRunNetworkSpeedBluetooth() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 100, 20000, 10000, Optional.of(ConnectionType.BLUETOOTH)));
		
		driver.get("https://www.cnn.com/");
		driver.quit();
	}

	
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
