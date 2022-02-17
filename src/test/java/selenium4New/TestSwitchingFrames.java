package selenium4New;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.Base;

public class TestSwitchingFrames extends Base {

	@Test
	public void testRelativeLocatorToLeftOf() throws Exception {

		getCustomUrl("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_frames2");
		log.info(getPageTitle());
		log.info("Number of frames:" + driver.findElements(By.tagName("iframe")).size());

		driver.switchTo().frame("iframeResult");
		String text1 = driver.findElement(By.xpath("//body/h1")).getText();
		log.info(text1);
		log.info("Number of frames:" + driver.findElements(By.tagName("iframe")).size());

		// we use default content or parent frame id or window handle we can use
		// parentFrame
		driver.switchTo().parentFrame();
		log.info("Number of frames:" + driver.findElements(By.tagName("iframe")).size());
		// driver.findElement(By.xpath("//body/h1")).getText();

	}

}
