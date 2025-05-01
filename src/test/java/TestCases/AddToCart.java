package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {
	public static void main(String[]args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
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
		
		driver.findElement(By.xpath("//*[@class='form-control input-lg']")).sendKeys("iphone");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		
		String iPhoneResultTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		if(iPhoneResultTitle.equals("Search - iphone")) {
			System.out.println("Iphone result is appears on page !");
		}
		
	  Boolean AddcartIsEnabled = driver.findElement(By.xpath("//div[@class='button-group']/button[1]")).isEnabled();
	  if(AddcartIsEnabled.equals(true)) {
		  driver.findElement(By.xpath("//div[@class='button-group']/button[1]")).click();
	  }
	  
	  //Check whether Item added in cart or not
	  if(driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).isDisplayed()) {
		  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span")).click();
		  Thread.sleep(3000);
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        // Save the screenshot
	        try {
	            FileUtils.copyFile(screenshot, new File("Downloads/screenshot.png"));
	            System.out.println("Screenshot saved successfully!");
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	        }
	  }
	  
	driver.quit();
	}
}
