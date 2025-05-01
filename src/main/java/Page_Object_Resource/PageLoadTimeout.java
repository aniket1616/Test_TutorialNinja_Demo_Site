package Page_Object_Resource;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTimeout {
	public static void main(String[]args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	//Driver only wait  till specified time for page to get load completely;
	//If not load within specified time, TIMEOUT_EXCEPTION Occur;
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

	driver.get("www");
	driver.quit();
		
	}
}
