package TestCases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Page_Object_Resource.JavaScriptExecutor;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {
	public static void main(String[]args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String MainWindowID = driver.getWindowHandle();
		
		
		driver.findElement(By.xpath("//a[text()='Open a popup window']")).click();
		Set<String> twowindow = driver.getWindowHandles();
		String popupWindow = null;
		for(String w1 : twowindow) {
			if(!w1.equals(MainWindowID)) {
				popupWindow = w1;
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"Attribution1\"]/div[1]/a")).click();
		Set<String> threewindow = driver.getWindowHandles();
		String bloggerWindow = null;
		for(String w2 : threewindow) {
			if(!(w2.equals(MainWindowID))||w2.equals(twowindow)) {
				bloggerWindow = w2;
				break;
			}
		}
		
		driver.switchTo().window(popupWindow);
		String PopupPageTitle = driver.getTitle();
		System.out.println(PopupPageTitle);
		Thread.sleep(2000);
		
		driver.switchTo().window(bloggerWindow);
		driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/a[1]/span")).click();
		
		driver.switchTo().window(MainWindowID);
		driver.findElement(By.id("ta1")).sendKeys("Aniket chaudhari");
		
		driver.quit();
		
	}

}
