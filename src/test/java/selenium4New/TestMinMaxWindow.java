package selenium4New;

import org.testng.annotations.Test;
import utils.Base;

public class TestMinMaxWindow extends Base {

	@Test
	public void testChromeMaximize() {

		driver.manage().window().maximize(); // older method
		log.info(driver.getTitle());

	}

	@Test
	public void testChromeMinimize() throws Exception {

		driver.manage().window().minimize(); // New method
		log.info(driver.getTitle());

	}

	@Test
	public void testChromeFullScreen() throws Exception {

		driver.manage().window().fullscreen(); // New Method
		log.info(driver.getTitle());
		hardWait(3000);

	}

}
