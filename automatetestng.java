package assignment3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class automatetestng {
	WebDriver driver;

	String username = System.getenv("USERNAME");
	String password = System.getenv("PASSWORD");

	@Test
	public void tmain() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://live.browserstack.com");

		WebElement userName = driver.findElement(By.id("user_email_login"));
		WebElement passwordElement = driver.findElement(By.id("user_password"));
		WebElement button = driver.findElement(By.name("commit"));

		userName.sendKeys(username);
		passwordElement.sendKeys(password);
		button.click();

		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String expectedURL = "https://live.browserstack.com/dashboard";
		String currentURL = driver.getCurrentUrl();
		if (currentURL.contains(expectedURL)) {
			System.out.println("Test passed - URL match found!");
			Assert.assertTrue(true);
		} else {
			System.out.println("Test failed - URL match not found!");
			Assert.fail();
		}

		driver.quit();
	}
}
