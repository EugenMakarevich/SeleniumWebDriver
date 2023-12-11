package com.coherentsolutions.aqa.web.makarevich.utils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class WebDriverUtils {
    @Getter
    private static WebDriver driver;

    private WebDriverUtils() {}

    public static void setWebDriver(WebDriver driver) {
        WebDriverUtils.driver = driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}