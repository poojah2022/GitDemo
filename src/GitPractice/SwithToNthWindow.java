package GitPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SwithToNthWindow {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement discCoupons = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]"));
		List<WebElement> links = discCoupons.findElements(By.tagName("a"));
		
		Actions a = new Actions(driver);
		
		for(WebElement link: links)
		{
			a.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		}
		
		/*for(int i=1; i<links.size();i++)	
		{
			a.keyDown(Keys.CONTROL).click(links.get(i)).keyUp(Keys.CONTROL).build().perform();
		}*/  //in the url "Discount Coupons" link is opening again the same window-so to skip that link, loop starts from 1
		//- otherwise we could use enhanced for loop - shown above
		
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> windowsList = new ArrayList<>(windows);
		
		if(windowsList.size()>4)
		{
			driver.switchTo().window(windowsList.get(2));
			System.out.println("Swithed to 3rd window " + driver.getTitle());
		}
		else
		{
			System.out.println("2nd window does not exist");
		}
		
	}

}
