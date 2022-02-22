package selenium4New;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import utils.Base; 


public class TestBasicAuth extends Base {
	
	@Description("Test to verify Basic AUTH")
	@Test
	public void testBasicAuthentication() throws Exception {
		
		((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));
		getCustomUrl("https://the-internet.herokuapp.com/basic_auth");
		log.info(getPageTitle());
		Boolean validation =driver.findElement(By.xpath("//div/p[contains(text(),'Congratulations')]")).isDisplayed();
		Assert.assertTrue(validation);
		
	}

}
