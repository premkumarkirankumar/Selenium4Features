package selenium4New;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pages.TestPages;
import utils.Base;
import utils.WaitUtils;

public class TestScreenShot extends Base {

	@Test
	public void testTakeElementScreenshot() throws Exception {

		WaitUtils.hardWait(5000);
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		TestPages ap = new TestPages(driver);
		File source = ap.elementOptionOurBrands().getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + nameofCurrMethod + ".jpg";
		FileUtils.copyFile(source, new File(destinationFile));
	}

	@Test
	public void testTakePageScreenshot() throws Exception {

		WaitUtils.hardWait(5000);
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + nameofCurrMethod + ".jpg";
		FileUtils.copyFile(source, new File(destinationFile));
	}

	@Test
	public void testTakeFullPageScreenshot() throws Exception {

		WaitUtils.hardWait(5000);
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		if (driver instanceof FirefoxDriver) {
			File source = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir") + "\\reports\\" + nameofCurrMethod + ".jpg";
			FileUtils.copyFile(source, new File(destinationFile));
		} else {
			log.info("Test will run only for FireFox and Test Not run as expected");
		}
	}

}
