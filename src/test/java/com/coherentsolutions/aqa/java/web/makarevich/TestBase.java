package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.configuration.Configuration;
import com.coherentsolutions.aqa.web.makarevich.listeners.TestListener;
import com.coherentsolutions.aqa.web.makarevich.pages.*;
import com.coherentsolutions.aqa.web.makarevich.utils.WebDriverUtils;
import com.coherentsolutions.aqa.web.makarevich.webdriver.GridWebDriverStrategy;
import com.coherentsolutions.aqa.web.makarevich.webdriver.LocalWebDriverStrategy;
import com.coherentsolutions.aqa.web.makarevich.webdriver.SaurceLabsWebDriverStrategy;
import com.coherentsolutions.aqa.web.makarevich.webdriver.WebDriverContext;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Slf4j
@Listeners({io.qameta.allure.testng.AllureTestNg.class, TestListener.class})
public class TestBase {
    private WebDriver driver;
    Yandex360MailPage yandex360MailPage;
    YandexMailLoginPage yandexMailLoginPage;
    YandexMailInboxPage yandexMailInboxPage;
    MainPage mainPage;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;
    AddressBookPage addressBookPage;
    ProductPage productPage;
    ProductItemPage productItemPage;
    MyWhishListPage myWhishListPage;
    CartPage cartPage;

    protected static void setWebDriverStrategy() {
        switch (Configuration.DRIVER_STRATEGY.toUpperCase()) {
            case "GRID":
                WebDriverContext.setWebDriverStrategy(new GridWebDriverStrategy());
                break;
            case "SAURCELABS":
                WebDriverContext.setWebDriverStrategy(new SaurceLabsWebDriverStrategy());
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
        mainPage = new MainPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
        addressBookPage = new AddressBookPage(driver);
        productPage = new ProductPage(driver);
        productItemPage = new ProductItemPage(driver);
        myWhishListPage = new MyWhishListPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        Capabilities cap = ((RemoteWebDriver) WebDriverUtils.getDriver()).getCapabilities();
        log.info("Browser: " + cap.getBrowserName() + ", " +
                "Browser Version: " + cap.getBrowserVersion() + ", " +
                "OS: " + cap.getPlatformName().toString()
        );
        WebDriverUtils.closeDriver();
    }

    //For old test cases
    protected WebDriver driver() {
        return driver;
    }
}
