package selenium;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

import static constants.ByConstants.*;
import static constants.TestConstants.*;
import static constants.UrlConstants.ALERTS_TEST_URL;

@Slf4j
public class AlertsTest extends TestBase {
    @Test
    public void testJavaScriptAlertBox() {
        log.info("Open the URL: {}", ALERTS_TEST_URL);
        driver().get(ALERTS_TEST_URL);

        log.info("Click the 'Click me!' button for the JavaScript Alert Box");
        driver().findElement(ALERT_BOX_BUTTON).click();

        log.info("Switch to the alert");
        Alert alert = driver().switchTo().alert();

        log.info("Get the alert text");
        String alertText = alert.getText();

        log.info("Verify the alert text is '{}'", ALERT_TEXT);
        Assert.assertEquals(alertText, ALERT_TEXT, "Alert box text mismatch!");

        log.info("Close the alert");
        alert.accept();
    }

    @Test
    public void testJavaScriptConfirmBoxAccept() {
        log.info("Open the URL: {}", ALERTS_TEST_URL);
        driver().get(ALERTS_TEST_URL);

        log.info("Click the 'Click me!' button for the JavaScript Confirm Box");
        driver().findElement(CONFIRM_BOX_BUTTON).click();

        log.info("Switch to the alert");
        Alert alert = driver().switchTo().alert();

        log.info("Accept the alert (Click OK)");
        alert.accept();

        log.info("Verify the result text");
        WebElement resultElement = driver().findElement(CONFIRM_BOX_RESULT);
        String resultText = resultElement.getText();

        Assert.assertEquals(resultText, OK_BUTTON_RESULT_TEXT, "Ok button result text mismatch!");
    }

    @Test
    public void testJavaScriptConfirmBoxDismiss() {
        log.info("Open the URL: {}", ALERTS_TEST_URL);
        driver().get(ALERTS_TEST_URL);

        log.info("Click the 'Click me!' button for the JavaScript Confirm Box");
        driver().findElement(CONFIRM_BOX_BUTTON).click();

        log.info("Switch to the alert");
        Alert alert = driver().switchTo().alert();

        log.info("Dismiss the alert (Click Cancel)");
        alert.dismiss();

        log.info("Verify the result text");
        WebElement resultElement = driver().findElement(CONFIRM_BOX_RESULT);
        String resultText = resultElement.getText();

        Assert.assertEquals(resultText, CANCEL_BUTTON_RESULT_TEXT, "Cancel button result text mismatch!");
    }
}
