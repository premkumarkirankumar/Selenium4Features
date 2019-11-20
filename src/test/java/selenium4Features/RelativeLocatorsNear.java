package selenium4Features;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsNear {
	
	@Test
	public void test1() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://myit.allegistest.com/sp");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		WebElement label= driver.findElement(By.xpath("//label[@for='password']"));

		//usage of relative locator // Capture book # 5 information
		WebElement password =driver.findElement(RelativeLocator.withTagName("input").near(label));
		password.click();
		driver.quit();

			
	}

}
 