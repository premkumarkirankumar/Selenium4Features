package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPages {

	WebDriver driver;

	public TestPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Our Brands')]")
	WebElement optionOurBrands;

	@FindBy(xpath = "//li[@class='score-megamenu-dropdown megamenu-full']/a[.='Services']")
	WebElement optionServices;

	@FindBy(xpath = " //span[@itemprop='name']")
	WebElement optionHome;

	@FindBy(xpath = "//a[@class='score-button ag-clickable-area'][contains(text(),'Staffing and Recruiting Services')]")
	WebElement servicesOptionStaffRecruitingServices;

	@FindBy(xpath = "//h1[contains(text(),'Staffing and Recruiting')]")
	WebElement servicesPageStaffRecuritingServices;

	public void clickOptionOurBrands() {
		optionOurBrands.click();
	}

	public WebElement elementOptionOurBrands() {
		return optionOurBrands;
	}

	public void clickOptionHome() {
		optionHome.click();
	}

	public void clickOptionServices() {
		optionServices.click();
	}

	public void clickServicesOptionStaffRecrutingServices() {
		servicesOptionStaffRecruitingServices.click();
	}

	public boolean validateStaffRecruitingServicesPage() {
		boolean validation = false;
		if (servicesPageStaffRecuritingServices.isDisplayed()) {
			validation = true;
		}
		return validation;
	}

}
