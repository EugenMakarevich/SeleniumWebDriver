package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigUtils;

import java.time.Duration;

public class YandexMailLoginTest {
    WebDriver driver;
    WebDriverWait wait;
    private final String yandexMailUrl = ConfigUtils.getProperty("yandexmail.url");
    private final String yandexMailUsername = ConfigUtils.getProperty("yandexmail.username");
    private final String yandexMailPassword = ConfigUtils.getProperty("yandex.password");
    private static final By LOGIN_BUTTON_MAIN_PAGE = By.id("header-login-button");
    private static final By EMAIL_FIELD = By.id("passp-field-login");
    private static final By LOGIN_BUTTON_AUTHORIZATION_PAGE = By.id("passp:sign-in");
    private static final By PASSWORD_FIELD = By.id("passp-field-passwd");
    private static final String YANDEX_MAIL_TITLE = "Inbox — Yandex Mail";

    @BeforeClass(alwaysRun = true)
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(50000));
    }

    @Test
    void TestYandexMailLogin() {
        driver.get(yandexMailUrl);
        driver.findElement(LOGIN_BUTTON_MAIN_PAGE).click();

        driver.findElement(EMAIL_FIELD).sendKeys(yandexMailUsername);
        driver.findElement(LOGIN_BUTTON_AUTHORIZATION_PAGE).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        driver.findElement(PASSWORD_FIELD).sendKeys(yandexMailPassword);
        driver.findElement(LOGIN_BUTTON_AUTHORIZATION_PAGE).click();

        wait.until(ExpectedConditions.titleContains(YANDEX_MAIL_TITLE));
        Assert.assertEquals(driver.getTitle(), YANDEX_MAIL_TITLE);
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }
}
