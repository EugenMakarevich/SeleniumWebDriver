package com.coherentsolutions.aqa.web.makarevich.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.coherentsolutions.aqa.web.makarevich.services.MultimediaService.attachScreenshot;

@Slf4j
public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test Failed: " + result.getName());
        attachScreenshot();
    }
}
