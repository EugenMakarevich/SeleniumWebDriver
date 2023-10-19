package com.coherentsolutions.aqa.java.web.makarevich;

import com.coherentsolutions.aqa.web.makarevich.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    protected void setUp() {
        driver = WebDriverUtils.setWebDriver();
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        WebDriverUtils.closeDriver();
    }

    protected WebDriver driver() {
        return driver;
    }
}
