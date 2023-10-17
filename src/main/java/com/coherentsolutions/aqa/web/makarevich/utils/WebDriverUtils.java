package com.coherentsolutions.aqa.web.makarevich.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.LONG_TIMEOUT;
import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.MEDIUM_TIMEOUT;

public class WebDriverUtils {
    public static WebDriver setWebDriver() {
        WebDriver driver;
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
        return driver;
    }
}