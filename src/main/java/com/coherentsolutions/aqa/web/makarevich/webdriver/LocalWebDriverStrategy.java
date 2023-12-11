package com.coherentsolutions.aqa.web.makarevich.webdriver;

import com.coherentsolutions.aqa.web.makarevich.configuration.Configuration;
import com.coherentsolutions.aqa.web.makarevich.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.LONG_TIMEOUT;

public class LocalWebDriverStrategy implements WebDriverStrategy {
    @Override
    public void setStrategy() {
        WebDriver driver;
            switch (Configuration.BROWSER) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                default:
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(LONG_TIMEOUT);
        WebDriverUtils.setWebDriver(driver);
    }
}
