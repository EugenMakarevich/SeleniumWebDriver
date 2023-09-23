package com.coherentsolutions.aqa.java.web.makarevich;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.coherentsolutions.aqa.web.makarevich.testbase.TestBase;

import java.time.Duration;

import static com.coherentsolutions.aqa.web.makarevich.constants.ByConstants.*;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.*;
import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.SHORT_TIMEOUT;
import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.YANDEX_MAIL_URL;

@Slf4j
public class YandexMailLoginTest extends TestBase {
    private WebDriverWait wait;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        wait = new WebDriverWait(driver(), SHORT_TIMEOUT);
        driver().manage().timeouts().implicitlyWait(SHORT_TIMEOUT); //2.Add implicit waiter for WebDrive
    }

    @DataProvider(name = "yandexMailCredentials")
    public static Object[][] yandexMailCredentials() {
        return new Object[][] {
                {YANDEX_MAIL_USERNAME_1, YANDEX_MAIL_PASSWORD_1},
                {YANDEX_MAIL_USERNAME_2, YANDEX_MAIL_PASSWORD_2}
        };
    }

    @Test(dataProvider = "yandexMailCredentials")
    public void testYandexMailLogin(String username, String password) throws InterruptedException {
        log.info("Navigate to the login main page");
        driver().get(YANDEX_MAIL_URL);
        driver().findElement(LOGIN_BUTTON_MAIN_PAGE).click();

        log.info("Enter username and click login button");
        driver().findElement(EMAIL_FIELD).sendKeys(username);
        driver().findElement(LOGIN_BUTTON_AUTHORIZATION_PAGE).click();
        Thread.sleep(3000); //3.Add Thread.sleep for login test. What type of waiter is it - Not implicit nor explicit?

        log.info("Enter password and click login button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        driver().findElement(PASSWORD_FIELD).sendKeys(password);
        driver().findElement(LOGIN_BUTTON_AUTHORIZATION_PAGE).click();

        log.info("Assert the user is logged into personal account");
        wait.until(ExpectedConditions.titleContains(YANDEX_MAIL_INBOX_TITLE));
        new WebDriverWait(driver(),SHORT_TIMEOUT, Duration.ofMillis(300)).until(ExpectedConditions.visibilityOfElementLocated(USER_ACCOUNT_NAME)); //4. Add explicit waiter for login test, which will wait until name appears (after login). Add polling frequency, which is differ from default value
        String actualUsername = driver().findElement(USER_ACCOUNT_NAME).getText();
        String actualYandexMailInboxTitile = driver().getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(username, actualUsername, "Username is different from expected!");
        softAssert.assertTrue(actualYandexMailInboxTitile.contains(YANDEX_MAIL_INBOX_TITLE),"Unexpected page title");
        softAssert.assertAll();
    }
}
