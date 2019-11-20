package selenium4Features;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenShotWebPage {
	
	
	//this exist in Selenium 3 as well
	
	@Test
	public void test1() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://myit.allegistest.com/sp");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);

		File destFile= new File("LoginPage.png");
		FileUtils.copyFile(file, destFile);
		
		driver.quit();

		
	}

}
