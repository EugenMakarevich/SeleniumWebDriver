package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        return driver;
    }
}