package selenium4New;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;

public class TestSaveOrPrintAsPDF {

	public class TestBasicAuth extends Base {

		@Description("Test to verify printing on PDF")
		@Test
		public void testSavePrintoPDF() throws Exception {

			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("headless");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(opt);
			driver.get("https://selenium.dev/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Pdf pdf = ((PrintsPage) driver).print(new PrintOptions());
			Files.write(Paths.get("./reports/selenium.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
			driver.quit();
		}

	}

}
