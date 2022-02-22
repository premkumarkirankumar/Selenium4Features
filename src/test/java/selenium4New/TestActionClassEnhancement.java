package selenium4New;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestActionClassEnhancement extends Base {

	@Description("Test to the element Coordinates")
	@Test
	public void testGetElementCoordinates() throws Exception {

		WebElement playButton = driver.findElement(By.xpath("//img[@alt='play button']"));

		int x = playButton.getRect().getX();
		int y = playButton.getRect().getX();
		log.info("x coordinates:"+x);
		log.info("y coordinates:"+y);
		Actions action = new Actions(driver);
		action.moveByOffset(x, y).click().perform();
		WaitUtils.hardWait(6000);
	}

}
