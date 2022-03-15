package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import utils.WaitUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestPages {

	WebDriver driver;

	public TestPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='score-megamenu-dropdown']/a[normalize-space()='Careers']")
	WebElement optionCareers;
	
	@FindBy(xpath = "//li[@class='score-megamenu-dropdown megamenu-full']/a[.='Services']")
	WebElement optionServices;
	
	@FindBy(xpath = "//li[@class='score-megamenu-basic-item']/a[normalize-space()='Our Brands']")
	WebElement optionOurBrands;
	
	@FindBy(xpath = "//li[@class='score-megamenu-dropdown megamenu-full']/a[normalize-space()='Insights']")
	WebElement optionInsights;
	
	@FindBy(xpath = "//li[@class='score-megamenu-dropdown megamenu-full']/a[normalize-space()='About Us']")
	WebElement optionAboutUs;
	
	@FindBy(xpath = "//li[@class='score-megamenu-basic-item']/a[normalize-space()='Locations']")
	WebElement optionLocations;
	
	@FindBy(xpath = " //span[@itemprop='name']")
	WebElement optionHome;

	@FindBy(xpath = "//a[@class='score-button ag-clickable-area'][contains(text(),'Staffing and Recruiting Services')]")
	WebElement servicesOptionStaffRecruitingServices;

	@FindBy(xpath = "//h1[contains(text(),'Staffing and Recruiting')]")
	WebElement servicesPageStaffRecuritingServices;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;

	public void clickOptionOurBrands() {
		optionOurBrands.click();
	}

	public void elementOptionOurBrandsExist() throws Exception {	
		WaitUtils.hardWait(30000);
		//WaitUtils.waitForElementToBeClickable(optionOurBrands,seconds);
		
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
	
	
	@Step("Enter username {0}")
	public void enterUserName(String uName) {
		if (username.isDisplayed())
			username.sendKeys(uName);
	}

	@Step("Enter password {0}")
	public void enterPassword(String pwd) {
		if (password.isDisplayed())
			password.sendKeys(pwd);
	}
	
	
	public boolean validateHomePagetab() {
		boolean validation = false;
		if(optionCareers.isDisplayed() && optionServices.isDisplayed() && optionOurBrands.isDisplayed() && optionInsights.isDisplayed() &&
				optionAboutUs.isDisplayed() && optionLocations.isDisplayed() ) {
			validation=true;
		}
		return validation;
	}
	
	public boolean validateHomePagetabCareers() {
		boolean validation = false;
		if(optionCareers.isDisplayed()) {
			validation=true;
		}
		return validation;
	}
	
	public boolean validateHomePagetabServices() {
		boolean validation = false;
		if(optionServices.isDisplayed()) {
			validation=true;
		}
		return validation;
	}
	
	public boolean validateHomePagetabOurBrands() {
		boolean validation = false;
		if(optionOurBrands.isDisplayed()) {
			validation=true;
		}
		return validation;
	}
	
	public boolean validateHomePagetabInsights() {
		boolean validation = false;
		if(optionInsights.isDisplayed()) {
			validation=true;
		}
		return validation;
	}
	
	public boolean validateHomePagetabAboutUs() {
		boolean validation = false;
		if(optionAboutUs.isDisplayed()) {
			validation=true;
		}
		return validation;
	}
	
	public boolean validateHomePagetabLocations() {
		boolean validation = false;
		if(optionLocations.isDisplayed() ) {
			validation=true;
		}
		{
			
		}
		return validation;

	}


}
