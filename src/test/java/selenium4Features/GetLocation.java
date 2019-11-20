package selenium4Features;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetLocation {

	
	
	@Test
	public void test1() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://myit.allegistest.com/sp");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		WebElement logo= driver.findElement(By.xpath("//img[@title='ServiceNow']"));
		
		System.out.println("Height:"+logo.getRect().getDimension().getHeight());
		System.out.println("Width:"+logo.getRect().getDimension().getWidth());
		
		System.out.println("X Location:"+logo.getRect().getX());
		System.out.println("Y Location:"+logo.getRect().getY());
		
		
		driver.quit();
		
	}

}
