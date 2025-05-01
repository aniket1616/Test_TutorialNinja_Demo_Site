package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForgotPassword {
	public static void main(String[]args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Boolean visible =  driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")).isDisplayed();
		if(visible.equals(true)) {
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")).click();
		}
		
		Thread.sleep(2000);
		String ForgotPasswordTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		if(ForgotPasswordTitle.equalsIgnoreCase("Forgot Your Password")) {
			System.out.println("User reached forgot password page succesfully!");
		}
		
		driver.findElement(By.id("input-email")).sendKeys("pass123@yopmail.com");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).isEnabled();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
		
		String ForgotpasswordDone = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		if(ForgotpasswordDone.equals("An email with a confirmation link has been sent your email address.")) {
			System.out.println("User has Successfully perfromed Forgot password flow and forgotpass link is send to Email ID");
		}
	
		Thread.sleep(4000);
		driver.quit();
	}

}
