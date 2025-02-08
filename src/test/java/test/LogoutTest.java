package test;

import com.test.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--user-data-dir=/tmp/chrome-user-data");  // Set a temporary user data directory
        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }


    @Test
    public void testLogin() {
        loginPage.login("standard_user", "secret_sauce");

        // Add assertion to verify successful login
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testLogout() throws InterruptedException {
        loginPage.logout();
    }



    @AfterClass
    public void tearDown() {
        try {
            // Wait for 2 seconds
            Thread.sleep(5000);  // Time in milliseconds
            driver.quit();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
