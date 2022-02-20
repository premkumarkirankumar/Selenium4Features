package selenium4New;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import pages.TestPages;

public class TestSelfHealing {
	
    WebDriver driver;
    
	@Description("Test for self healing element")
	@Test
	public void testSelfHealing() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver1 = new ChromeDriver();
		driver = SelfHealingDriver.create(driver1);
		driver.get("https://www.allegisgroup.com/en");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		TestPages ap = new TestPages(driver);
		ap.clickOptionOurBrands();
		ap.clickOptionHome();
		driver.quit();
		/*
		driver.get("https://www.allegisgroup.com/en");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Our Brands')]")).click();
		driver.quit();
		*/
	}


}
