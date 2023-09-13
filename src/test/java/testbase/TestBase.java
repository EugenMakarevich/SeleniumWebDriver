package testbase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WebDriverUtils;

public class TestBase {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = WebDriverUtils.setWebDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    public WebDriver driver() {
        return driver;
    }
}
