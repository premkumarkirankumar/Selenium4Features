package selenium4New;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import utils.Base;


public class TestElementCoordinates extends Base {
	
	@Description("Test to the element Coordinates")
	@Test
	public void testGetElementCoordinates() throws Exception {
		
		WebElement img = driver.findElement(By.xpath("//img[@itemprop='logo']"));
		
		Rectangle coordinates = img.getRect();

		log.info("Height : "+coordinates.getHeight());
		log.info("Width : "+coordinates.getWidth());
		log.info("X Cord : "+coordinates.getX());
		log.info("Y Cord : "+coordinates.getY());
		
	}
}
