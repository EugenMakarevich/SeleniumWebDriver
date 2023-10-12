package com.coherentsolutions.aqa.java.web.makarevich;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.coherentsolutions.aqa.web.makarevich.constants.ByConstants.DOWNLOAD_BUTTON;
import static com.coherentsolutions.aqa.web.makarevich.constants.ByConstants.PERCENT_TEXT;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.DEFAULT_PROGRESS_BAR_VALUE;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.DOWNLOAD_PERCENT;
import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.PROGRESS_BAR_URL;

@Slf4j
public class ProgressBarTest extends TestBase {

    @Test
    public void testProgressBarDownloadCounter() {
        log.info("Open the URL: {}", PROGRESS_BAR_URL);
        driver().get(PROGRESS_BAR_URL);

        log.info("Click on the 'Download' button");
        driver().findElement(DOWNLOAD_BUTTON).click();

        log.info("Wait for the counter to be >= {}", DOWNLOAD_PERCENT);
        while (true) {
            WebElement progressText = driver().findElement(PERCENT_TEXT);
            String percentString = progressText.getText();
            int percent = Integer.parseInt(percentString.replaceAll("[^0-9]", ""));

            if (percent >= DOWNLOAD_PERCENT) {
                break;
            }
        }

        log.info("Refresh the page");
        driver().navigate().refresh();

        String percentValue = driver().findElement(PERCENT_TEXT).getText();
        Assert.assertEquals(percentValue, DEFAULT_PROGRESS_BAR_VALUE, String.format("The progress bar is not set to %s; page is not refreshed", DEFAULT_PROGRESS_BAR_VALUE));
    }
}
