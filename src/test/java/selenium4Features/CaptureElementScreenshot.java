package selenium4Features;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureElementScreenshot {
	
	@Test
	public void test1() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://myit.allegistest.com/sp");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		WebElement logo= driver.findElement(By.xpath("//img[@title='ServiceNow']"));
		//WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		
		File file=logo.getScreenshotAs(OutputType.FILE);
		//File file=username.getScreenshotAs(OutputType.FILE);
	
		
		File destFile= new File("logo.png");
		FileUtils.copyFile(file, destFile);
		
		driver.quit();

		
	}

}
