package selenium;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parameters.TestData;
import utils.WebDriverUtils;

import java.time.Duration;

import static constants.ByConstants.*;
import static constants.TestConstants.YANDEX_MAIL_INBOX_TITLE;
import static constants.TestConstants.YANDEX_MAIL_URL;
import static constants.TimeOutConstants.SHORT_TIMEOUT;

@Slf4j
public class YandexMailLoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    void setUp() {
        driver = WebDriverUtils.setWebDriver();
        wait = new WebDriverWait(driver, SHORT_TIMEOUT);
        driver.manage().timeouts().implicitlyWait(SHORT_TIMEOUT); //2.Add implicit waiter for WebDrive
    }

    @Test(dataProvider = "yandexMailCredentials", dataProviderClass = TestData.class)
    void TestYandexMailLogin(String username, String password) throws InterruptedException {
        log.info("Navigate to the login main page");
        driver.get(YANDEX_MAIL_URL);
        driver.findElement(LOGIN_BUTTON_MAIN_PAGE).click();

        log.info("Enter username and click login button");
        driver.findElement(EMAIL_FIELD).sendKeys(username);
        driver.findElement(LOGIN_BUTTON_AUTHORIZATION_PAGE).click();
        Thread.sleep(7000); //3.Add Thread.sleep for login test. What type of waiter is it - Implicit waiter?

        log.info("Enter password and click login button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON_AUTHORIZATION_PAGE).click();

        log.info("Assert the user is logged into personal account");
        wait.until(ExpectedConditions.titleContains(YANDEX_MAIL_INBOX_TITLE));
        new WebDriverWait(driver,SHORT_TIMEOUT, Duration.ofMillis(300)).until(ExpectedConditions.visibilityOfElementLocated(USER_ACCOUNT_NAME)); //4. Add explicit waiter for login test, which will wait until name appears (after login). Add polling frequency, which is differ from default value
        Assert.assertEquals(username, driver.findElement(USER_ACCOUNT_NAME).getText());
        Assert.assertTrue(driver.getTitle().contains(YANDEX_MAIL_INBOX_TITLE),"Unexpected page title");
    }

    @AfterClass
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
