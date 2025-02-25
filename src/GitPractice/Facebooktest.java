package GitPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebooktest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		String url = "https://www.facebook.com/";
		driver.get(url);  
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement language = driver.findElement(By.cssSelector("a[title='Kannada']"));
		
		String emailid = "abcd@gmail.com";
		String pswd = "abcd@1234";
		email.sendKeys(emailid);
		password.sendKeys(pswd);
		
		WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
		login.click();

	}

}
