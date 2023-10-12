package com.coherentsolutions.aqa.java.web.makarevich;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.coherentsolutions.aqa.web.makarevich.constants.ByConstants.*;
import static com.coherentsolutions.aqa.web.makarevich.constants.TestConstants.*;
import static com.coherentsolutions.aqa.web.makarevich.constants.TimeOutConstants.MEDIUM_TIMEOUT;
import static com.coherentsolutions.aqa.web.makarevich.constants.UrlConstants.LOADING_DATA_DYNAMICALLY_URL;

@Slf4j
public class LoadingDataDynamicallyTest extends TestBase {
    WebDriverWait wait;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        wait = new WebDriverWait(driver(), MEDIUM_TIMEOUT, Duration.ofMillis(200));
    }

    @Test
    public void testLoadingUserDataDynamically() {
        log.info("Go to the page: {}", LOADING_DATA_DYNAMICALLY_URL);
        driver().get(LOADING_DATA_DYNAMICALLY_URL);

        log.info("Click on the 'Get New User' button");
        driver().findElement(GET_NEW_USER_BUTTON).click();

        log.info("Wait until the user's information appears");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(USER_INFORMATION_BOX, FIRST_NAME_TEXT));

        WebElement userInfoElement = driver().findElement(USER_INFORMATION_BOX);
        WebElement imgTag = userInfoElement.findElement(USER_PHOTO);
        String userInfoText = userInfoElement.getText();
        userInfoText = userInfoText.replaceAll("\\n", " ");
        log.info("User Info: {}", userInfoText);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(userInfoText.contains(FIRST_NAME_TEXT), String.format("%s text is not present in the user information block", FIRST_NAME_TEXT));
        softAssert.assertTrue(userInfoText.contains(LAST_NAME_TEXT), String.format("%s text is not present in the user information block", LAST_NAME_TEXT));
        softAssert.assertNotNull(imgTag, "The img tag is not present in the DOM within the user information block");
        softAssert.assertAll();
    }
}
