package Page_Object_Resource;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitMechanism {
	public static void main(String[]args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("xxx");
		Thread.sleep(3000);
		driver.findElement(By.xpath("sdg/sfsdg/")).click();
	
		String elementName = driver.findElement(By.id("df")).getText();
		System.out.println(elementName);
		
		driver.quit();	
	}
}
