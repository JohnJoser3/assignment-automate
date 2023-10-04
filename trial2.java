package assignment1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class trial2 {

	@Test
	public void testOnFirefox() {
		String username = System.getenv("USERNAME");
		String password = System.getenv("PASSWORD");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.browserstack.com/users/sign_in");
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println("The page title is: " + title);

		WebElement uName = driver.findElement(By.id("user_email_login"));
		WebElement pswd = driver.findElement(By.id("user_password"));
		WebElement loginBtn1 = driver.findElement(By.id("user_submit"));

		uName.sendKeys(username);
		pswd.sendKeys(password);
		loginBtn1.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.quit();
	}
	
}
