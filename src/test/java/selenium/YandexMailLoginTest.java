package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class YandexMailLoginTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        //Login: selenuimtest
        // Pass: selenuimtest@pass
    }

    @Test
    void TestYandexMailLogin() {
        driver.get("https://mail.yandex.com");
        WebElement enterButton = driver.findElement(By.id("header-login-button"));
        Assert.assertTrue(enterButton.isDisplayed());
        enterButton.click();

        WebElement emailField = driver.findElement(By.id("passp-field-login"));
        emailField.sendKeys("selenuimtest");
        WebElement loginButton = driver.findElement(By.id("passp:sign-in"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000)); // Wait for up to 10 seconds

        // Define the locator for your element
        By elementLocator = By.cssSelector("span.WelcomePage-tagline");

        // Wait for the element to be displayed
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

        WebElement passwordField = driver.findElement(By.id("passp-field-passwd"));
        passwordField.sendKeys("selenuimtest@pass");
        WebElement loginButton1 = driver.findElement(By.id("passp:sign-in"));
        loginButton1.click();
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
