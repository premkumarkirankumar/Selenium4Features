package selenium4New;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import pages.TestPages;
import utils.Base;


public class TestAllureReports extends Base {

	@Severity(SeverityLevel.BLOCKER)
	@Step("Sample Step Pass")
	@Description("Test to use Allure report Pass method")
	@Test(description="Validate Allure report on test Pass")
	public void testAllureReportsPass() {

		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.clickOptionOurBrands();
		ap.clickOptionHome();
		ap.clickOptionServices();
		ap.clickServicesOptionStaffRecrutingServices();
	
	}
	
	@Severity(SeverityLevel.BLOCKER)
	@Step("Sample Step Fail 1")
	@Description("Test to use Allure report failure method")
	@Test(description="Validate Allure report on test failure")
	public void testAllureReportsFail1() {

		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.clickOptionOurBrands();
		ap.clickOptionHome();
		ap.clickOptionServices();
		ap.clickServicesOptionStaffRecrutingServices();
		Assert.assertTrue(false);
	
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Step("Sample Step Fail 2")
	@Description("Test to use Allure report failure method")
	@Test(description="Validate Allure report on test failure")
	public void testAllureReportsFail2() {

		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.clickOptionOurBrands();
		ap.clickOptionHome();
		ap.clickOptionServices();
		ap.clickServicesOptionStaffRecrutingServices();
		Assert.assertTrue(false);
	
	}
	
	@Severity(SeverityLevel.MINOR)
	@Step("Sample Step Fail 3")
	@Description("Test to use Allure report failure method")
	@Test(description="Validate Allure report on test failure")
	public void testAllureReportsFail3() {

		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.clickOptionOurBrands();
		ap.clickOptionHome();
		ap.clickOptionServices();
		ap.clickServicesOptionStaffRecrutingServices();
		Assert.assertTrue(false);
	
	}
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Test to use Allure report Step annotation")
	@Test(description="Validate Allure report on test pass with STEP annotation")
	public void testAllureReportsStepAnnotation() {

		getCustomUrl("https://test.salesforce.com/");
		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.enterUserName("testUserName");
		ap.enterPassword("testPassord");
		
	}
	

	@Link("https://github.com/allure-framework/allure2")
	@Link(name = "allure", type = "mylink")
	@Test
	public void testAllureReportsLinkAnnotation() throws Exception{
	
		getCustomUrl("https://test.salesforce.com/");
		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.enterUserName("testUserName");
		ap.enterPassword("testPassord");
		
	}
	
	@Issue("Issue 1")
	@Issue("Issue 2")
	@Test
	public void testAllureReportsIssueAnnotation() throws Exception{
	
		getCustomUrl("https://test.salesforce.com/");
		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.enterUserName("testUserName");
		ap.enterPassword("testPassord");
		
	}
	
	@TmsLink("test-1")
	@TmsLink("test-2")
	@Test
	public void testAllureReportsTmsLinkAnnotation() throws Exception{
	
		getCustomUrl("https://test.salesforce.com/");
		log.info(getPageTitle());
		TestPages ap = new TestPages(driver);
		ap.enterUserName("testUserName");
		ap.enterPassword("testPassord");
		
	}
	
	// allure serve
	// allure serve C:\Users\Kiran\Documents\AutomationProjects\Selenium4Features\allure-results
}
