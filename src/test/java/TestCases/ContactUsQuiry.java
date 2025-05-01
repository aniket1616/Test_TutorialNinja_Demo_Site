package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUsQuiry {
	public static void main(String[]args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
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
		Thread.sleep(1000);
		
		String DashboardAccount = driver.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[2]/a")).getText();
		
		if(DashboardAccount.equals("Account")) {	
			System.out.println("User is successfully Logged-IN");
		}
		
		
		
	//Click Quiry- ContactUS option
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[1]/a")).click();
		
		String contactusTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		if(contactusTitle.equals("Contact Us")) {
			System.out.println("User is reached on CONTACT-US page");
			
			driver.findElement(By.xpath("//div[@class='col-sm-10']/input[1]")).clear();
			driver.findElement(By.xpath("//div[@class='col-sm-10']/input[1]")).sendKeys("Aniket Chaudhari");
			
			driver.findElement(By.xpath("//*[@id=\"input-email\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("aniket@yopmail.com");
			driver.findElement(By.id("input-enquiry")).sendKeys("ABCDE   FGHIJK   LMNOP");
			
			Boolean submitbutton = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).isEnabled();
			if(submitbutton.equals(true)) {
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();
			}
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		Thread.sleep(1000);
		System.out.println("Contact Us quiry perfromed successfully");
		driver.quit();
	}
}
