package selenium4New;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Base;

public class TestScreenShot extends Base {
	
	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	
	@Test
	public void testTakeScreenshot() throws Exception {
		
		Thread.sleep(5000);
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+nameofCurrMethod+".jpg";
		FileUtils.copyFile(source,new File(destinationFile));
	}

}
