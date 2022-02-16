package selenium4New;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.Base;

public class TestSynchronization extends Base {

	@Test
	public void testImplicitWait() {

		// param need to be given in the following way with Selenium 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		log.info(driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'Our Brands')]")).click();
		driver.findElement(By.xpath(" //span[@itemprop='name']")).click();

	}

}