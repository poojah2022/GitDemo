package GitPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Interview_Prep {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");	
	}
	
	@Test
	public void loginAndNavigateHome()
	{
		//login functionality
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement login = driver.findElement(By.name("login"));
		
		username.sendKeys("abcd123@gmail.com");
		password.sendKeys("xyz@@567");
		login.click();
		
		//Navigate to Homepage
		WebElement home = driver.findElement(By.cssSelector("a[aria-label='Home']"));
		home.click(); //test will fail here as unable to locate element bcz credentials are not valid, othewise script will work
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
