package selenium4New;

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

public class TestChromeDevToolsMockingGeoLocations extends Base {
	

	@Description("Test to verify Mocking Geo Location")
	@Test
	public void testGeoLocation() throws Exception {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		//typecast if required
		//devTools.send(Emulation.setGeolocationOverride(Optional.of((Number)51.509865), Optional.of((double)0.118092), Optional.of((Number)100)));
		
		devTools.send(Emulation.setGeolocationOverride(Optional.of(51.509865), Optional.of(-0.118092), Optional.of(100)));
		driver.get("https://mycurrentlocation.net/");
		WaitUtils.hardWait(5000);
		driver.quit();
	}

}
