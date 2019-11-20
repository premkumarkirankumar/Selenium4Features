package selenium4Features;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsAboveToRightOf {
	
	@Test
	public void test1() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://automationbookstore.dev/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		//usage of relative locator // Capture book # 2 information
		WebElement bookRequired2 =driver.findElement(RelativeLocator.withTagName("li").toRightOf(By.id("pid1")).above(By.id("pid6")));
		String id= bookRequired2.getAttribute("id");
		System.out.println(id);
		Assert.assertEquals("pid2", id);
		driver.quit();

		
		
		
	}

}
 