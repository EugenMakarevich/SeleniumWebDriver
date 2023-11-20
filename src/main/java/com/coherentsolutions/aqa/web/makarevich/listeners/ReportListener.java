package com.coherentsolutions.aqa.web.makarevich.listeners;

import com.coherentsolutions.aqa.web.makarevich.utils.WebDriverUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.coherentsolutions.aqa.web.makarevich.services.MultimediaService.attachScreenshot;

public class ReportListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        attachScreenshot();
    }

    /*//This works!
    private void captureScreenshot(ITestResult result) {
        WebDriver driver = WebDriverUtils.getDriver();
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);
            // Implement logic to save or handle the screenshot as needed
            // For simplicity, let's print the screenshot size here
            System.out.println("Screenshot Size: " + screenshot.length + " bytes");
        } else {
            System.out.println("Driver does not support screenshot capture");
        }
    }*/

    // Implement other methods of ITestListener as needed
    // You can leave them empty or provide custom implementation
    // ...

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }
}
