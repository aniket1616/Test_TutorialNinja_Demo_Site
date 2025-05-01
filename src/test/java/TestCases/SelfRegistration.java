package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelfRegistration {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		String RegistrationTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		if(RegistrationTitle.equals("Register Account")) {
			System.out.println("User is reached on Regitration Page!");
		}
		
		driver.findElement(By.id("input-firstname")).sendKeys("Aniket");
		driver.findElement(By.id("input-lastname")).sendKeys("Chaudhari");
		driver.findElement(By.id("input-email")).sendKeys("aniketchaudhari1616@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9916161616");
		driver.findElement(By.id("input-password")).sendKeys("Pass123$");
		driver.findElement(By.id("input-confirm")).sendKeys("Pass123$");
		
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		if(driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).isSelected()) {
			driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		}
		else {
			System.out.println("Term&Condition Checkox is Unselected");
		}
		Thread.sleep(3000);
		driver.quit();
	}

}
