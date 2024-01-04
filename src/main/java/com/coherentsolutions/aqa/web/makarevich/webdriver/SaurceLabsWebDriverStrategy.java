package com.coherentsolutions.aqa.web.makarevich.webdriver;

import com.coherentsolutions.aqa.web.makarevich.configuration.Configuration;
import com.coherentsolutions.aqa.web.makarevich.utils.WebDriverUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.LONG_TIMEOUT;

public class SaurceLabsWebDriverStrategy implements WebDriverStrategy {
    @Override
    public void setStrategy() {
        MutableCapabilities caps = new MutableCapabilities();
        /*
        Needed options:
        MicrosoftEdge latest Windows 10
        Chrome 100 Linux
        Firefox 100 Windows 8.1
        */
        caps.setCapability("browserName", Configuration.BROWSER);
        caps.setCapability("browserVersion", Configuration.BROWSER_VERSION);
        caps.setCapability("platformName", Configuration.PLATFORM);

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-evgeny.makarevich.2019-dd62b");
        sauceOptions.put("accessKey", "58f4ae90-08cc-45f2-b960-e14d8f59f961");
        sauceOptions.put("build", "S");
        sauceOptions.put("name", "Windows 10 Edge latest");
        caps.setCapability("sauce:options", sauceOptions);

        WebDriver driver;

        try {
            driver = new RemoteWebDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(LONG_TIMEOUT);
        WebDriverUtils.setWebDriver(driver);
    }
}
