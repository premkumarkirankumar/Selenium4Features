package petClinic;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.WaitUtils; 


public class TestHomePagePROD {
	
	@Description("Test to verify HomePage")
	@Test
	public void testHomePage() throws Exception {
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		ChromeOptions opt = new ChromeOptions();
		WebDriver driver=new RemoteWebDriver(new URL("http://130.211.225.186:31319"), opt);
		driver.get("http://35.222.49.12:30598/petclinic/");
		String findOwners=(driver.findElement(By.xpath("//a[contains(@href,'owners')]/span[contains(text(),'Find')]")).getText());
	    String url = driver.getCurrentUrl();
		System.out.println("Current URL:"+url );
		System.out.println("Retrieved Text:"+findOwners);
		boolean validation=false;
		if(findOwners.contentEquals("FIND 4OWNERS")) {
			validation=true;
		}
		Assert.assertTrue(validation );
		WaitUtils.hardWait(10000);
		driver.quit();
	}
	

}
