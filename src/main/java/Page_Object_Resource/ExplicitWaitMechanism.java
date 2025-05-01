package Page_Object_Resource;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitMechanism {
	public static void main(String[]args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("www");
	
	driver.findElement(By.id("dsg")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	//Waiting for an element to be get displayed/appeared on page then take action.
	WebElement WaitingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("dsgsf//sdfsd")));
	
	//Wait until an element get vanished / disappear to proceed further actions
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("dgsfd/sdgs")));
	
	//Waiting for an alert to be appears and check properly on page
	wait.until(ExpectedConditions.alertIsPresent());
	
	//WAITING FOR AN DISABLED BUTTON TO BE GET ENABLED
	WebElement ClickableButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("dsgd/dsfsdfg")));
	ClickableButton.click();
	
	
	 String ElementTitle = WaitingElement.getText();
	 System.out.println(ElementTitle);
	 
	 driver.quit();
	}
}
