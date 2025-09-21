package yashautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandAloneTest {

    public static void main(String[] args) throws InterruptedException {

        // Set up ChromeDriver path if not in system environment variables
        // System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 1: Register New User
        driver.get("https://rahulshettyacademy.com/client/#/auth/register");
        String email = "test" + System.currentTimeMillis() + "@mail.com";
        String password = "Test@1234";

        driver.findElement(By.id("firstName")).sendKeys("Yash");
        driver.findElement(By.id("lastName")).sendKeys("Automation");
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("userMobile")).sendKeys("9876543210");
        driver.findElement(By.cssSelector("input[type='checkbox']")).click(); // Agree to terms
        driver.findElement(By.id("userPassword")).sendKeys(password);
        driver.findElement(By.id("confirmPassword")).sendKeys(password);

        // Click Register
        driver.findElement(By.cssSelector("input[name='login']")).click();

        // Wait for registration to complete & redirect to login
        Thread.sleep(3000);

        // Step 2: Login with registered credentials
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("userPassword")).sendKeys(password);
        driver.findElement(By.id("login")).click();

        // Optional: Add some validation, wait for dashboard
        Thread.sleep(3000);

        // Print result (can also validate presence of element/text)
        System.out.println("Successfully registered and logged in with: " + email);

        driver.quit();
    }
}
