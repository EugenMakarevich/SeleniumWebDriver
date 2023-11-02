package com.coherentsolutions.aqa.web.makarevich.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.SCREENSHOT_FOLDER_PATH;

public class ScreenshotUtil {
    public static void takeScreenshot(WebDriver driver, String screenshotFileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = SCREENSHOT_FOLDER_PATH + screenshotFileName;
        try {
            FileHandler.copy(screenshot, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
