package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class TestOnSafari {
	public static void main(String[] args) {
		String username = System.getenv("USERNAME");
		String password = System.getenv("PASSWORD");

		// Creating WebDriver instance
		WebDriver driver = new SafariDriver();

		// Navigate to web page
		driver.get("https://www.browserstack.com/users/sign_in");

		// Maximizing window
		driver.manage().window().maximize();

		// Retrieving web page title
		String title = driver.getTitle();
		System.out.println("The page title is: " + title);

		// Locating web element
		WebElement uName = driver.findElement(By.id("user_email_login"));
		WebElement pswd = driver.findElement(By.id("user_password"));
		WebElement loginBtn1 = driver.findElement(By.id("user_submit"));

		// Peforming actions on web elements
		uName.sendKeys(username); // Use the username variable
		pswd.sendKeys(password); // Use the password variable

		loginBtn1.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Closing browser session
		driver.quit();
	}
}
