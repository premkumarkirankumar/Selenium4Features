package selenium4New;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.emulation.Emulation;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestChromeDevToolsSimulateDevice extends Base {

	@Description("Test to verify Device Simulation")
	@Test
	public void testDeviceSimulationWithEmulation() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		devTools.send(Emulation.setDeviceMetricsOverride(375, 812, 50, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty()));

		driver.get("https://selenium.dev/");
		WaitUtils.hardWait(5000);
		driver.quit();
	}

	@Description("Test to verify Device Simulation with MAP")
	@Test
	public void testDeviceSimulationWithMap() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		@SuppressWarnings("serial")
		Map<String, Object> deviceMetrics = new HashMap<String, Object>() {
			{
				put("width", 375);
				put("height", 812);
				put("mobile", true);
				put("deviceScaleFactor", 50);
			}

		};

		((ChromeDriver) driver).executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

		driver.get("https://selenium.dev/");
		WaitUtils.hardWait(5000);
		driver.quit();
	}

}
