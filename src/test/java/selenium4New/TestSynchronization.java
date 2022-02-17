package selenium4New;

import java.time.Duration;
import org.testng.annotations.Test;

import pages.AllegisPage;
import utils.Base;

public class TestSynchronization extends Base  {

	@Test
	public void testImplicitWait() {

		// param need to be given in the following way with Selenium 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		log.info(getPageTitle());
		AllegisPage ap= new AllegisPage(driver);
		ap.clickOptionOurBrands();
		ap.clickOptionHome();		

	}
	
	@Test
	public void testExplicitWait() throws Exception {

		log.info(getPageTitle());
		AllegisPage ap= new AllegisPage(driver);
		ap.clickOptionOurBrands();
		ap.clickOptionHome();	
	
	}

}
