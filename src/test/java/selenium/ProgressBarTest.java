package selenium;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testbase.TestBase;

import static constants.ByConstants.DOWNLOAD_BUTTON;
import static constants.ByConstants.PERCENT_TEXT;
import static constants.TestConstants.DOWNLOAD_PERCENT;
import static constants.TestConstants.PROGRESS_BAR_URL;

@Slf4j
public class ProgressBarTest extends TestBase {

    @Test
    public void TestProgressBar() {
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
    }
}
