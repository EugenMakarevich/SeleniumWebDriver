package com.coherentsolutions.aqa.web.makarevich.listeners;

import com.coherentsolutions.aqa.web.makarevich.utils.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.coherentsolutions.aqa.web.makarevich.services.MultimediaService.attachScreenshot;

@Slf4j
public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Capabilities cap = ((RemoteWebDriver) WebDriverUtils.getDriver()).getCapabilities();
        log.error("Test Failed: " + result.getName() + ", " +
                "Browser: " + cap.getBrowserName()  + ", " +
                "Browser Version: " + cap.getBrowserVersion() + ", " +
                "OS: " + cap.getPlatformName().toString());
        attachScreenshot();
    }
}
