package petClinic;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import utils.WaitUtils; 


public class TestHomePage {
	
	@Description("Test to verify HomePage")
	@Test
	public void testHomePage() throws Exception {
		
		ChromeOptions opt = new ChromeOptions();
		WebDriver driver=new RemoteWebDriver(new URL("http://34.70.191.209:31319"), opt);
		driver.get("http://104.198.68.119:31358/petclinic/");
		String findOwners=(driver.findElement(By.xpath("//a[contains(@href,'owners')]/span[contains(text(),'Find')]")).getText());
		System.out.println("Retrieved Text:"+findOwners);
		boolean validation=false;
		if(findOwners.contentEquals("FIND 3OWNERS")) {
			validation=true;
		}
		Assert.assertTrue(validation );
		WaitUtils.hardWait(10000);
		driver.quit();
	}
	

}
