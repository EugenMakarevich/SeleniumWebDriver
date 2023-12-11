package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.configuration.Configuration;
import com.coherentsolutions.aqa.web.makarevich.listeners.TestListener;
import com.coherentsolutions.aqa.web.makarevich.pages.Yandex360MailPage;
import com.coherentsolutions.aqa.web.makarevich.pages.YandexMailInboxPage;
import com.coherentsolutions.aqa.web.makarevich.pages.YandexMailLoginPage;
import com.coherentsolutions.aqa.web.makarevich.utils.WebDriverUtils;
import com.coherentsolutions.aqa.web.makarevich.webdriver.GridWebDriverStrategy;
import com.coherentsolutions.aqa.web.makarevich.webdriver.LocalWebDriverStrategy;
import com.coherentsolutions.aqa.web.makarevich.webdriver.WebDriverContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({io.qameta.allure.testng.AllureTestNg.class, TestListener.class})
public class TestBase {
    private WebDriver driver;
    Yandex360MailPage yandex360MailPage;
    YandexMailLoginPage yandexMailLoginPage;
    YandexMailInboxPage yandexMailInboxPage;

    protected static void setWebDriverStrategy() {
        switch (Configuration.DRIVER_STRATEGY.toUpperCase()) {
            case "GRID":
                WebDriverContext.setWebDriverStrategy(new GridWebDriverStrategy());
                break;
            case "LOCAL":
            default:
                WebDriverContext.setWebDriverStrategy(new LocalWebDriverStrategy());
                break;
        }
    }

    @BeforeClass(alwaysRun = true)
    protected void setUp() {
        setWebDriverStrategy();
        driver = WebDriverUtils.getDriver();
        yandex360MailPage = new Yandex360MailPage(driver);
        yandexMailLoginPage = new YandexMailLoginPage(driver);
        yandexMailInboxPage = new YandexMailInboxPage(driver);
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        WebDriverUtils.closeDriver();
    }

    //For old test cases
    protected WebDriver driver() {
        return driver;
    }
}
