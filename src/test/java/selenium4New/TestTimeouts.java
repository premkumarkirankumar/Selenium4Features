package selenium4New;

import java.time.Duration;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import utils.Base;


public class TestTimeouts extends Base {

	
	@Description("Test to validate Page timeouts")
	@Test
	public void testPageTimeout() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.cnn.com/");
	}
	
	@Description("Test to validate script timeouts")
	@Test
	public void testScriptWaitTimeout() {

		//WebDriver must wait for an asynchronous script to finish execution before throwing an error
		//driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(30));
		driver.get("https://www.cnn.com/");
	}
	

	
}
