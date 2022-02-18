package selenium4New;


import org.testng.annotations.Test;
import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestMinMaxWindow extends Base {

	@Description("Test to verify Browser Maximize")
	@Test
	public void testBrowserMaximize() {

		driver.manage().window().maximize(); // older method
		log.info(getPageTitle());

	}

	@Description("Test to verify Browser Minimize")
	@Test
	public void testBrowserMinimize() throws Exception {

		driver.manage().window().minimize(); // New method
		log.info(getPageTitle());

	}


	@Description("Test to verify Browser Full screen")
	@Test
	public void testBrowserFullScreen() throws Exception {

		driver.manage().window().fullscreen(); // New Method
		log.info(getPageTitle());
		WaitUtils.hardWait(3000);

	}

}
