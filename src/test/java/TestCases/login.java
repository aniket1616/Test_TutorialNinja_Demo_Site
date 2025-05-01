package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	WebDriver driver;
	public static void main(String[]args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		
		String homepageTitle = driver.findElement(By.id("logo")).getText();
		if(homepageTitle.equals("Qafox.com")) {
			System.out.print("Page Loaded Successfully!");
		}
		else {
			System.out.print("Page isnt loaded Successfully!");
			driver.quit();
		}
		Thread.sleep(2000);
		
		WebElement myAccDropdown =  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i"));
		Select drop = new Select(myAccDropdown);
		drop.selectByVisibleText("Login");
		
		String loginPage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h2")).getText();
		if(loginPage.equals("Returning Customer")) {
			System.out.print("The user is Reached LoginPage Successfully");
		}
		
		WebElement usernameField = driver.findElement(By.id("input-email"));
		WebElement passwordField = driver.findElement(By.id("input-password"));
		
		usernameField.sendKeys("pass123@yopmail.com");
		passwordField.sendKeys("Pass123$");
		
		driver.findElement(By.className("btn btn-primary")).click();
		Thread.sleep(3000);
		
		String DashboardAccount = driver.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[2]/a")).getText();
		
		if(DashboardAccount.equals("Account")) {	
			System.out.println("User is successfully Logged-IN");
		}
		driver.quit();
	}
	
}
