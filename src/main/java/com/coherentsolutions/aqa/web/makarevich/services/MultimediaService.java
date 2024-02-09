package com.coherentsolutions.aqa.web.makarevich.services;

import com.google.common.io.Files;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.SCREENSHOT_FAILURE;
import static com.coherentsolutions.aqa.web.makarevich.utils.ScreenshotUtil.takeScreenshotAsFile;

@Slf4j
public class MultimediaService {
    //TODO: DO I need a service here??? Is it better to put it in ScreenshotUtils or even better rename screenshot utils as MultimediaUtils?
    public static void attachScreenshot() {
        try {
            File screenshot = takeScreenshotAsFile();
            ByteArrayInputStream screenshotInBytes = new ByteArrayInputStream(Files.toByteArray(Objects.requireNonNull(screenshot)));
            Allure.addAttachment(SCREENSHOT_FAILURE, "image/png", screenshotInBytes, ".png");
        } catch (IOException e) {
            log.error("Can't take screenshot ", e);
        }
    }
}
