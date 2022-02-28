package selenium4New;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import utils.WaitUtils; 


public class TestGrid {
	
	@Description("Test to verify GRID")
	@Test
	public void testSeleniumGrid() throws Exception {
		
		ChromeOptions opt = new ChromeOptions();
		WebDriver driver=new RemoteWebDriver(new URL("http://34.67.197.48:30936"), opt);
		driver.get("https://selenium.dev/");
		String dataName=(driver.findElement(By.xpath("//*[@id='selenium_logo']")).getDomAttribute("data-name"));
		System.out.println("Retrieved Attribute: "+dataName);
		WaitUtils.hardWait(30000);
		driver.quit();
	}
	

}
