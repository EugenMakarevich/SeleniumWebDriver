package selenium;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WebDriverUtils;

import static constants.ByConstants.*;
import static constants.TestConstants.*;
import static constants.TimeOutConstants.SHORT_TIMEOUT;

@Slf4j
public class YandexMailLoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    void setUp() {
        driver = WebDriverUtils.setWebDriver();
        wait = new WebDriverWait(driver, SHORT_TIMEOUT);
    }

    @Test
    void TestYandexMailLogin() {
        log.info("Navigate to the login main page");
        driver.get(YANDEX_MAIL_URL);
        driver.findElement(LOGIN_BUTTON_MAIN_PAGE).click();

        log.info("Enter username and click login button");
        driver.findElement(EMAIL_FIELD).sendKeys(YANDEX_MAIL_USERNAME);
        driver.findElement(LOGIN_BUTTON_AUTHORIZATION_PAGE).click();

        log.info("Enter password and click login button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        driver.findElement(PASSWORD_FIELD).sendKeys(YANDEX_MAIL_PASSWORD);
        driver.findElement(LOGIN_BUTTON_AUTHORIZATION_PAGE).click();

        log.info("Assert the user is logged into personal account");
        wait.until(ExpectedConditions.titleContains(YANDEX_MAIL_INBOX_TITLE));
        Assert.assertTrue(driver.getTitle().contains(YANDEX_MAIL_INBOX_TITLE),"Unexpected page title");
    }

    @AfterClass
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
