package selenium4Features;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsBelowToleftof {
	
	@Test
	public void test1() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://automationbookstore.dev/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		/*
		driver.findElement(By.xpath("//input[@id='username']")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("@NA End User");
		
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SNOW1234");
		
		driver.findElement(By.xpath("//input[@name='c.remember_me']")).click();
	
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(5000);
		
		WebElement onBase= driver.findElement(By.xpath("//div/h2[@title='OnBase']"));
		WebElement generalRequest= driver.findElement(By.xpath("//div/h2[@title='General Request']"));
			
		
		WebElement peopleSOftItem =driver.findElement(RelativeLocator.withTagName("div").toLeftOf(onBase).below(generalRequest));
		peopleSOftItem.click();
		Thread.sleep(5000);
		*/
		
		//usage of relative locator // Capture book # 5 information
		WebElement bookRequired5 =driver.findElement(RelativeLocator.withTagName("li").toLeftOf(By.id("pid6")).below(By.id("pid1")));
		String id= bookRequired5.getAttribute("id");
		System.out.println(id);
		Assert.assertEquals("pid5", id);
		driver.quit();

		
		
		
	}

}
 