package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllegisPage {
	
	WebDriver driver;
	
	public AllegisPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//a[contains(text(),'Our Brands')]")
	WebElement optionOurBrands ;
	
	@FindBy(xpath =" //span[@itemprop='name']")
	WebElement optionHome ;
	
	public void clickOptionOurBrands() {
		optionOurBrands.click();
	}
	
	public void clickOptionHome() {
		optionHome.click();
	}
	
	
	

}
