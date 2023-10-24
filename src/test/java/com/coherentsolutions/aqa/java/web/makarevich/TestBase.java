package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.pages.Yandex360MailPage;
import com.coherentsolutions.aqa.web.makarevich.pages.YandexMailInboxPage;
import com.coherentsolutions.aqa.web.makarevich.pages.YandexMailLoginPage;
import com.coherentsolutions.aqa.web.makarevich.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    private WebDriver driver;
    Yandex360MailPage yandex360MailPage;
    YandexMailLoginPage yandexMailLoginPage;
    YandexMailInboxPage yandexMailInboxPage;

    @BeforeClass(alwaysRun = true)
    protected void setUp() {
        driver = WebDriverUtils.setWebDriver();
        yandex360MailPage = new Yandex360MailPage(driver);
        yandexMailLoginPage = new YandexMailLoginPage(driver);
        yandexMailInboxPage = new YandexMailInboxPage(driver);
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        WebDriverUtils.closeDriver();
    }

    protected WebDriver driver() {
        return driver;
    }
}
