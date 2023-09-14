package selenium;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.time.Duration;

import static constants.ByConstants.GET_NEW_USER_BUTTON;
import static constants.ByConstants.USER_INFORMATION_BOX;
import static constants.TestConstants.LOADING_DATA_DYNAMICALLY_URL;
import static constants.TimeOutConstants.MEDIUM_TIMEOUT;

@Slf4j
public class LoadingDataDynamicallyTest extends TestBase {

    @Test
    public void TestLoadingDataDynamically() {
        log.info("Go to the page: {}", LOADING_DATA_DYNAMICALLY_URL);
        driver().get(LOADING_DATA_DYNAMICALLY_URL);

        log.info("Click on the 'Get New User' button");
        driver().findElement(GET_NEW_USER_BUTTON).click();

        log.info("Wait until the user's information appears");
        WebDriverWait wait = new WebDriverWait(driver(), MEDIUM_TIMEOUT, Duration.ofMillis(200));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(USER_INFORMATION_BOX, "First Name"));
    }
}
