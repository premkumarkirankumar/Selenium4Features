package selenium4New;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import utils.Base;

public class TestGetDOMAttributeProperty extends Base {
	
	@Description("Test to getAttribute ")
	@Test()
	public void testGetDOMAttribute() {

		driver.get("https://test.salesforce.com/");
		log.info(getPageTitle());		
		WebElement element = driver.findElement(By.xpath("//input[@id='username']"));	
		log.info(element.getDomAttribute("type"));

	}
	
	
	@Description("Test to get DOM property ")
	@Test()
	public void testGetDOMProperty() {

		driver.get("https://test.salesforce.com/");
		log.info(getPageTitle());		
		WebElement element = driver.findElement(By.xpath("//input[@id='rememberUn']"));	
		log.info(element.getDomProperty("type"));

	}


}
