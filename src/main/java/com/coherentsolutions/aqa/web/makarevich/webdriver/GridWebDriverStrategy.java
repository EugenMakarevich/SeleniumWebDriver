package com.coherentsolutions.aqa.web.makarevich.webdriver;

import com.coherentsolutions.aqa.web.makarevich.utils.ConfigUtils;
import com.coherentsolutions.aqa.web.makarevich.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.LONG_TIMEOUT;

public class GridWebDriverStrategy implements WebDriverStrategy {
    @Override
    public void setStrategy() {
        DesiredCapabilities cap = new DesiredCapabilities();

        switch (ConfigUtils.getProperty("driver.browser")) {
            case "chrome":
                cap.setBrowserName("chrome");
                break;
            default:
                cap.setBrowserName("firefox");
                break;
        }
        WebDriver driver;

        try {
            driver = new RemoteWebDriver(new URL(ConfigUtils.getProperty("hub.url")), cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(LONG_TIMEOUT);
        WebDriverUtils.setWebDriver(driver);
    }
}
