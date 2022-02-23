package selenium4New;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.openqa.selenium.devtools.v96.network.model.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import utils.Base;
import utils.WaitUtils;

public class TestChromeDevToolsRequestrResponseCustomHeaders extends Base {

	@Description("Test to verify Request Response Headers")
	@Test
	public void testRequestResponseHeaders() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		// request
		devTools.addListener(Network.requestWillBeSent(), request -> {

			Headers header = request.getRequest().getHeaders();

			if (!header.isEmpty()) {

				log.info("Request Headers: ");
				header.forEach((key, value) -> {

					log.info("  " + key + " = " + value);

				});

			}

		});

		// response
		devTools.addListener(Network.responseReceived(), response -> {

			Headers header = response.getResponse().getHeaders();

			if (!header.isEmpty()) {

				log.info("Response Headers: ");
				header.forEach((key, value) -> {

					log.info("  " + key + " = " + value);

				});

			}

			log.info("Response URL is : " + response.getResponse().getUrl() + "  status code is : "
					+ response.getResponse().getStatus());

		});
		
		Map<String, Object> headers = new HashMap<String,Object>();
		headers.put("customHeaderName", "customHeaderValue");
		headers.put("Kiran", "SDET");
		Headers head = new Headers(headers);
		devTools.send(Network.setExtraHTTPHeaders(head));
		
		driver.get("https://reqres.in/api/users?page=2");
		WaitUtils.hardWait(5000);
		driver.quit();
	}

}
