package selenium4New;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;
import utils.Base;

public class TestRelativeLocators extends Base {

	@Test
	public void testRelativeLocatorBelow() throws Exception {

		getCustomUrl("https://test.salesforce.com/");
		log.info(getPageTitle());
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("test");
		WebElement password = driver
				.findElement(RelativeLocator.with(By.xpath("//input[@id='password']")).below(userName));
		password.sendKeys("test");
		hardWait(5000);
	}

	@Test
	public void testRelativeLocatorAbove() throws Exception {

		getCustomUrl("https://test.salesforce.com/");
		log.info(getPageTitle());
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("test");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		WebElement password = driver
				.findElement(RelativeLocator.with(By.xpath("//input[@id='password']")).above(loginButton));
		password.sendKeys("test");
		hardWait(5000);
	}

	@Test
	public void testRelativeLocatorNear() throws Exception {

		getCustomUrl("https://test.salesforce.com/");
		log.info(getPageTitle());
		WebElement customDomainLink = driver.findElement(By.xpath("//a[@id='mydomainLink']"));
		WebElement forgetYourPassword = driver
				.findElement(RelativeLocator.with(By.xpath("//a[@id='forgot_password_link']")).near(customDomainLink));
		forgetYourPassword.click();
		hardWait(5000);
	}

	@Test
	public void testRelativeLocatorToRightOf() throws Exception {

		getCustomUrl("https://test.salesforce.com/");
		log.info(getPageTitle());
		WebElement checkRememberMe = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		WebElement rememberMeLabel = driver
				.findElement(RelativeLocator.with(By.xpath("//label[@for='rememberUn']")).toRightOf(checkRememberMe));
		log.info(rememberMeLabel.getText());
		hardWait(5000);
	}

	@Test
	public void testRelativeLocatorToLeftOf() throws Exception {

		getCustomUrl("https://test.salesforce.com/");
		log.info(getPageTitle());
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='rememberUn']"));
		WebElement checkRememberMe = driver
				.findElement(RelativeLocator.with(By.xpath("//input[@id='rememberUn']")).toLeftOf(rememberMe));
		checkRememberMe.click();
		hardWait(5000);
	}

}
