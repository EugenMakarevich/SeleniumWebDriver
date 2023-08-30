package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigUtils;
import utils.WebDriverUtils;

import java.time.Duration;

import static constants.TimeOutConstants.SHORT_TIMEOUT;

public class YandexMailLoginTest {
    WebDriver driver;
    WebDriverWait wait;
    private static final String YANDEX_MAIL_URL = ConfigUtils.getProperty("yandexmail.url");
    private static final String YANDEX_MAIL_USERNAME = ConfigUtils.getProperty("yandexmail.username");
    private static final String YANDEX_MAIL_PASSWORD = ConfigUtils.getProperty("yandexmail.password");
    private static final By LOGIN_BUTTON_MAIN_PAGE = By.id("header-login-button");
    private static final By EMAIL_FIELD = By.id("passp-field-login");
    private static final By LOGIN_BUTTON_AUTHORIZATION_PAGE = By.id("passp:sign-in");
    private static final By PASSWORD_FIELD = By.id("passp-field-passwd");
    private static final String YANDEX_MAIL_TITLE = "Inbox — Yandex Mail";

    @BeforeClass(alwaysRun = true)
    void setUp() {
        driver = WebDriverUtils.setWebDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(SHORT_TIMEOUT));
    }

    @Test
    void TestYandexMailLogin() {
        //Navigate to the login main page
        driver.get(YANDEX_MAIL_URL);
        driver.findElement(LOGIN_BUTTON_MAIN_PAGE).click();

        //Enter username and click login button
        driver.findElement(EMAIL_FIELD).sendKeys(YANDEX_MAIL_USERNAME);
        driver.findElement(LOGIN_BUTTON_AUTHORIZATION_PAGE).click();

        //Enter password and click login button
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        driver.findElement(PASSWORD_FIELD).sendKeys(YANDEX_MAIL_PASSWORD);
        driver.findElement(LOGIN_BUTTON_AUTHORIZATION_PAGE).click();

        //Assert the user is logged into personal account
        wait.until(ExpectedConditions.titleIs(YANDEX_MAIL_TITLE));
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }
}
