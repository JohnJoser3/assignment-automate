package assignment6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomateTestngLocal {
    private WebDriver driver;

//    @BeforeClass
//    public void setUp() {
//        // Set up Chrome driver
//        System.setProperty("webdriver.chrome.driver", "/Users/johnjose/node_modules/chromedriver/lib/chromedriver/chromedriver");
//        driver = new ChromeDriver();
//    }

//    @Test(priority = 1)
//    public void testLoginWithChrome() {
//        login(driver);
//    }

    @Test(priority = 2)
    public void testLoginWithFirefox() {
        // Set up Firefox driver
        System.setProperty("webdriver.gecko.driver", "/Users/johnjose/Downloads/geckodriver");
        driver = new FirefoxDriver();
        login(driver);
    }

    @Test(priority = 3)
    public void testLoginWithSafari() {
        // Set up Safari driver
        driver = new SafariDriver();
        login(driver);
    }

    private void login(WebDriver driver) {
        String username = System.getenv("USERNAME");
        String password = System.getenv("PASSWORD");
        driver.get("https://live.browserstack.com");

        System.out.println("browser is:");
        System.out.println(driver);

        // Perform login
        WebElement emailInput = driver.findElement(By.id("user_email_login"));
        WebElement passwordInput = driver.findElement(By.id("user_password"));
        WebElement loginButton = driver.findElement(By.id("user_submit"));

        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify if login was successful
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("https://live.browserstack.com/dashboard")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
