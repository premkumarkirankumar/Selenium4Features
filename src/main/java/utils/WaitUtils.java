package utils;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils extends Base {
	
	
	/**
	 * Method to do hard wait for specific seconds
	 * 
	 * @param secs
	 * @throws Exception
	 */
	public static void hardWait(long secs) throws Exception {
		Thread.sleep(secs);
	}
	
	/**
	 * Method for explicit wait for that element to be Clickable
	 * 
	 * @param by
	 * @param seconds
	 */
	public static void waitForElementToBeClickable(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	/**
	 * Method to explicit wait for that element to be clickable with polling
	 * 
	 * @param by
	 * @param seconds
	 * @param pollingSeconds
	 */
	public static void waitForElementToBeClickableWithPolling(WebElement element, int seconds, int pollingSeconds) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
				.pollingEvery(Duration.ofSeconds(pollingSeconds)).withMessage("Time out as the condition is not met")
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();

	}

}
