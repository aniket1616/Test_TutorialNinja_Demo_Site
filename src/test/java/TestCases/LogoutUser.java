package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogoutUser {
	public static void main(String[]args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//LOGIN CLASS CODE
				driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.manage().window().maximize();
				
				String loginPage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h2")).getText();
				if(loginPage.equals("Returning Customer")) {
					System.out.print("The user is Reached LoginPage Successfully");
				}
				
				WebElement usernameField = driver.findElement(By.id("input-email"));
				WebElement passwordField = driver.findElement(By.id("input-password"));
				
				usernameField.sendKeys("pass123@yopmail.com");
				passwordField.sendKeys("Pass123$");
				
				driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
				Thread.sleep(3000);
				
				String DashboardAccount = driver.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[2]/a")).getText();
				
				if(DashboardAccount.equals("Account")) {	
					System.out.println("User is successfully Logged-IN");
				}
				
				WebElement accountdrop = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i"));
				accountdrop.click();
				driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
				
				String LogoutMsg = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
				if(LogoutMsg.equals("Account Logout")) {
					System.out.println("User is successfully logout from the account");
					driver.quit();
				}
				
	}

}
