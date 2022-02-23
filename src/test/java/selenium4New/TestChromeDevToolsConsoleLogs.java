package selenium4New;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.console.Console;
import org.openqa.selenium.devtools.v96.log.Log;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;


public class TestChromeDevToolsConsoleLogs extends Base {

	@Description("Test to verify Console Logs")
	@Test
	public void testConsoleLogs() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		
		devTools.send(Log.enable());
		devTools.send(Console.enable());
		
		//lambda expression
		devTools.addListener(Log.entryAdded(), entry ->{
 
			log.info("Text is : "+entry.getText());
			log.info("TimeStamp is : "+entry.getTimestamp());
			log.info("Source is : "+entry.getSource());
			log.info("Level is : "+entry.getLevel());
		});
		
		
		devTools.addListener(Console.messageAdded(), message ->{
 	
			log.info("Console Text is : "+message.getText());	
			
		});
		
		driver.get("https://www.amazon.com/");
		
		((JavascriptExecutor) driver).executeScript("console.log('This is a sample log')");
 
 
		driver.quit();
	}



}
