package com.coherentsolutions.aqa.web.makarevich.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.coherentsolutions.aqa.web.makarevich.services.MultimediaService.attachScreenshot;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        attachScreenshot();
    }
}
