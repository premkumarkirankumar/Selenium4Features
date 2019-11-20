package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlight {

	
	public static void highlightElement(WebElement ele, WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='2px solid red'", ele);
		
	}
}
