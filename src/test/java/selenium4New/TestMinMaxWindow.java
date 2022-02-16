package selenium4New;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Base;

public class TestMinMaxWindow extends Base {

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
	public void testChromeMaximize() {

		driver.manage().window().maximize(); // older method
		log.info(driver.getTitle());

	}

	@Test
	public void testChromeMinimize() throws Exception {

		driver.manage().window().minimize(); // New method
		log.info(driver.getTitle());
		System.out.println(driver.getTitle());

	}

	@Test
	public void testChromeFullScreen() throws Exception {

		driver.manage().window().fullscreen(); // New Method
		log.info(driver.getTitle());
		Thread.sleep(3000);

	}

}
