package com.coherentsolutions.aqa.web.makarevich.utils;

import com.coherentsolutions.aqa.web.makarevich.exceptions.TestInfrastructureException;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.SCREENSHOT_FOLDER_PATH;

@Slf4j
public class ScreenshotUtil {
    public static void takeScreenshot(String screenshotFileName) throws TestInfrastructureException {
        File screenshot = takeScreenshotAsFile();
        String screenshotPath = SCREENSHOT_FOLDER_PATH + screenshotFileName;
        try {
            FileHandler.copy(screenshot, new File(screenshotPath));
            log.trace("Screenshot is taken");
        } catch (IOException e) {
            throw new TestInfrastructureException("Failed to copy screenshot: " + e.getMessage());
        }
    }

    public static File takeScreenshotAsFile() {
        return ((TakesScreenshot) WebDriverUtils.getDriver()).getScreenshotAs(OutputType.FILE);
    }
}
