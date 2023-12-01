package com.coherentsolutions.aqa.web.makarevich.utils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.LONG_TIMEOUT;

public class WebDriverUtils {
    @Getter
    private static WebDriver driver;

    private WebDriverUtils() {}

    public static WebDriver setWebDriver() {
        if (driver == null) {
            switch (ConfigUtils.getProperty("driver.browser")) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                default:
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(LONG_TIMEOUT);
        }
        return driver;
    }

    public static WebDriver serGridWebDriver() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(LONG_TIMEOUT);
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}