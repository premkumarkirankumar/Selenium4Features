package selenium4New;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSelfHealing {
	
    WebDriver driver;
	@Test
	public void testSelfHealing() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver1 = new ChromeDriver();
		driver = SelfHealingDriver.create(driver1);
		driver.get("https://www.allegisgroup.com/en");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Our')]")).click();
		driver.quit();
	}


}
