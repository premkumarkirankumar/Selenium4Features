package selenium4New;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.performance.Performance;
import org.openqa.selenium.devtools.v96.performance.model.Metric;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestChromeDevToolsGetPerformanceMetrics extends Base{

	@Description("Test to enable performance metrics")
	@Test
	public void tesGetPerformanceMetrics() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		devTools.send(Performance.enable(Optional.of(Performance.EnableTimeDomain.TIMETICKS)));
		
		driver.get("https://www.cnn.com/");
		WaitUtils.hardWait(10000);

		List<Metric> metrics = devTools.send(Performance.getMetrics());
		metrics.forEach(metric ->log.info(metric.getName()+" : "+metric.getValue()));

		driver.quit();
	}



}
