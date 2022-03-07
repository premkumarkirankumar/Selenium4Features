package selenium4New;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;

public class TestInstallExtension extends Base {
	
	@Description("Test to install and uninstall extension")
	@Test
	public void testInstallUninstallExtension() throws Exception {

		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		String filepath = System.getProperty("user.dir") + "/extensions/selenium_ide-3.17.4-fx.xpi";
		Path path =Paths.get(filepath);
		String extensionId= driver.installExtension(path);
		System.out.println("Extension ID:"+extensionId);
		driver.uninstallExtension(extensionId);
		driver.quit();
	}
}
