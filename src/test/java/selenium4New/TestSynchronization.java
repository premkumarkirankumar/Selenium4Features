package selenium4New;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestPages;
import utils.Base;

public class TestSynchronization extends Base {

	@Test
	public void testImplicitWait() {

		// param need to be given in the following way with Selenium 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.clickOptionOurBrands();
		ap.clickOptionHome();

	}

	@Test
	public void testExcplicitWait() {

		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.clickOptionOurBrands();
		ap.clickOptionHome();
		ap.clickOptionServices();
		ap.clickServicesOptionStaffRecrutingServices();

		// param need to be given in the following way for Selenium 4
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(text(),'Staffing and Recruiting')]")));

		Assert.assertTrue(ap.validateStaffRecruitingServicesPage());

	}

	@Test
	public void testFluentWait() {

		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.clickOptionOurBrands();
		ap.clickOptionHome();
		ap.clickOptionServices();
		ap.clickServicesOptionStaffRecrutingServices();

		// param need to be given in the following way for Selenium 4
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1)).withMessage("Time out as the condition is not met")
				.ignoring(NoSuchElementException.class);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(text(),'Staffing and Recruiting')]")));

		Assert.assertTrue(ap.validateStaffRecruitingServicesPage());

	}

	@Test
	public void testIntentionalFailure() throws Exception {

		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.clickOptionOurBrands();
		ap.clickOptionHome();
		Assert.assertTrue(false);

	}

}
