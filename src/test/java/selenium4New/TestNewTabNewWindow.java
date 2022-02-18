package selenium4New;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import utils.Base;

public class TestNewTabNewWindow extends Base {
	
	
	@Description("Test to verify Relative locator below")
	@Test
	public void testNewTabNewWindow() throws Exception {

		log.info(getPageTitle());
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://test.salesforce.com/");
		log.info(getPageTitle());
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.allegisglobalsolutions.com/");
		log.info(getPageTitle());
		
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iterator = windowIds.iterator();
 
		List<String> windowIndex = new ArrayList<String>();
		while (iterator.hasNext()) {
 
			windowIndex.add(iterator.next());
		}
		
		driver.switchTo().window(windowIndex.get(0));
		log.info(getPageTitle());
		
		
		driver.switchTo().window(windowIndex.get(1));
		log.info(getPageTitle());
		
		driver.switchTo().window(windowIndex.get(2));
		log.info(getPageTitle());
		
		
 

	}

}
